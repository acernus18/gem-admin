package org.maples.gem.admin.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.maples.gem.admin.utility.ConstUtils;
import org.maples.gem.admin.utility.ExcelUtils;
import org.maples.gem.admin.utility.ParseUtils;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Slf4j
@Service
public class BuyService {
    private List<Object> getOutputHeader() {
        List<Object> header = new ArrayList<>();
        header.add("唯一号");
        header.add("石号");
        header.add("石名称");
        header.add("石料");
        header.add("色彩");
        header.add("形状");
        header.add("石数");
        header.add("石重");
        header.add("成本价");
        header.add("成本金额");
        header.add("规格");
        header.add("备注");
        header.add("平均重");
        header.add("计数量");
        header.add("计重量");
        header.add("重计价");
        header.add("证书类别");
        header.add("销售价");
        header.add("证书费");
        return header;
    }

    public void getTemplate(OutputStream outputStream, int index) {
        List<List<Object>> result = new ArrayList<>();
        List<Object> header = new ArrayList<>();
        header.add("石号");
        header.add("石名称");

        if (index == 0) {
            header.add("石成本(总)");
        } else {
            header.add("石编码");
        }

        header.add("石数");
        header.add("石重");
        header.add("供货商");
        header.add("证书类别");
        header.add("销售价");
        result.add(header);
        ExcelUtils.dump(result, outputStream);
    }


    public void generateBuyList(InputStream inputStream, OutputStream outputStream) {
        List<List<String>> sheet = ExcelUtils.load(inputStream, 0);
        List<List<String>> data = sheet.subList(1, sheet.size());
        List<List<Object>> result = new ArrayList<>();
        result.add(getOutputHeader());

        for (List<String> row : data) {
            if (row.stream().allMatch(StringUtils::isBlank)) {
                continue;
            }

            double weight = Double.parseDouble(row.get(4));
            int number = Integer.parseInt(row.get(3));
            double average = Double.parseDouble(String.format("%.2f", weight / number));

            int cost = 0;
            int unitCost = 0;
            String code = null;

            if (Pattern.matches("^\\d+$", row.get(2))) {
                cost = Integer.parseInt(row.get(2));
                unitCost = (int) Math.round(cost / weight);
                code = ParseUtils.encode(unitCost);
            } else if (Pattern.matches("^[VHKLMNRSTUBCDEF]+$", row.get(2))) {
                code = row.get(2);
                unitCost = ParseUtils.decode(code);
                cost = (int) Math.round(unitCost * weight);
            }

            int id = Integer.parseInt(row.get(0));
            String name = row.get(1);
            String[] info = ConstUtils.get(name);
            String type = info[0];
            String color = info[1];

            List<Object> temp = new ArrayList<>();
            temp.add(number == 1 ? "TRUE" : "FALSE"); // unique
            temp.add(id); // id
            temp.add(String.format("%s %s", name, code)); // name
            temp.add(type); // type
            temp.add(color); // color
            temp.add("通用"); // shape
            temp.add(number); // number
            temp.add(weight); // weight
            temp.add(unitCost); // unitCost
            temp.add(cost); // cost
            temp.add(1); // standard

            if (Pattern.matches("^\\d+$", row.get(5))) {
                temp.add(Integer.parseInt(row.get(5))); // other
            } else {
                temp.add(row.get(5));
            }

            temp.add(average); // average weight
            temp.add("TRUE");
            temp.add("TRUE");
            temp.add("TRUE");
            temp.add(row.get(6)); // certification
            temp.add(Integer.parseInt(row.get(7))); // sell price
            temp.add(0); // certification fee

            result.add(temp);
        }

        ExcelUtils.dump(result, outputStream);
    }
}
