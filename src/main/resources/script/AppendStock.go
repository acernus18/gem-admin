package main

import (
	"database/sql"
	"fmt"
	_ "github.com/go-sql-driver/mysql"
	"io"
	"io/ioutil"
	"os"
	"strconv"
	"strings"
	"time"
)

type Gemstone struct {
	//Id          int     `json:"id"`
	GemId       int     `json:"gem_id"`
	Name        string  `json:"name"`
	Type        string  `json:"type"`
	Color       string  `json:"color"`
	Amount      int     `json:"amount"`
	Weight      float64 `json:"weight"`
	CountAmount bool    `json:"count_amount"`
	CountWeight bool    `json:"count_weight"`
	CreateTime  int     `json:"create_time"`
	UpdateTime  int     `json:"update_time"`
}

func SaveDataToDB(db *sql.DB, reader io.Reader) {
	content, _ := ioutil.ReadAll(reader)
	lines := strings.Split(string(content), "\n")

	gemstones := make([]Gemstone, 0)
	for i := range lines {
		if len(strings.TrimSpace(lines[i])) != 0 {
			elements := strings.Split(lines[i], ",")

			gemstone := Gemstone{}

			gemstone.GemId, _ = strconv.Atoi(elements[0])
			gemstone.Name = strings.TrimSpace(elements[1])
			gemstone.Type = strings.TrimSpace(elements[2])
			gemstone.Color = strings.TrimSpace(elements[3])
			gemstone.Amount, _ = strconv.Atoi(elements[4])
			gemstone.Weight, _ = strconv.ParseFloat(elements[5], 64)

			gemstone.CountAmount, _ = strconv.ParseBool(elements[6])
			gemstone.CountWeight, _ = strconv.ParseBool(elements[7])

			gemstone.CreateTime = time.Now().Second()
			gemstone.UpdateTime = time.Now().Second()

			fmt.Println(gemstone)

			gemstones = append(gemstones, gemstone)
		}
	}

	statement, _ := db.Prepare("insert into `tb_gemstone`(`gem_id`, `name`, `type`, `color`, `amount`, `weight`, `count_amount`, `count_weight`, `create_time`, `update_time`) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")

	for i := range gemstones {
		response, execError := statement.Exec(
			gemstones[i].GemId,
			gemstones[i].Name,
			gemstones[i].Type,
			gemstones[i].Color,
			gemstones[i].Amount,
			gemstones[i].Weight,
			gemstones[i].CountAmount,
			gemstones[i].CountWeight,
			gemstones[i].CreateTime,
			gemstones[i].UpdateTime)

		if execError != nil {
			fmt.Println(execError)
		}

		id, _ := response.LastInsertId()

		fmt.Println(id)

		break
	}
}

func main() {
	client, _ := sql.Open("mysql", "maples:dev#pass@tcp(120.78.175.39:3306)/db_jewelry")
	file, _ := os.Open("/Users/v_liufenglin/Downloads/Gem/Gemstones1.csv")
	SaveDataToDB(client, file)
	_ = client.Close()
}
