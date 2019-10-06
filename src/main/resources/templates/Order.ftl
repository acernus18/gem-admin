<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">

    <script src="/webjars/jquery/3.3.1/jquery.min.js"></script>
    <script src="/webjars/popper.js/1.14.7/popper.min.js"></script>
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-light navbar-light">
    <a class="navbar-brand" href="#">立信</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <#--<li class="nav-item">-->
            <#--    <a class="nav-link" href="#">神秘代码转换器</a>-->
            <#--</li>-->
            <#--<li class="nav-item">-->
            <#--    <a class="nav-link" href="#">Link</a>-->
            <#--</li>-->
            <#--<li class="nav-item">-->
            <#--    <a class="nav-link" href="#">Link</a>-->
            <#--</li>-->
        </ul>
    </div>
</nav>
<br>
<div id="wrapper">
    <div id="page-wrapper">
        <#--<div class="row">-->
        <#--    <div class="col-lg-12">-->
        <#--        <h1 class="page-header">Tables</h1>-->
        <#--    </div>-->
        <#--    <!-- /.col-lg-12 &ndash;&gt;-->
        <#--</div>-->

        <div class="container">
            <div class="card">
                <table class="table card-body">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>重量</th>
                        <th>克拉价</th>
                        <th>价格</th>
                    </tr>
                    </thead>
                    <tbody id="table_body">
                    </tbody>
                    <tbody>
                    <tr>
                        <td>总价</td>
                        <td> </td>
                        <td> </td>
                        <td id="total">0</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <br>
            <div class="card">
                <form class="card-body">
                    <div class="form-group">
                        <label class="form-group">重量</label>
                        <input class="form-control" type="number" id="weight" title="weight"/>
                    </div>
                    <div class="form-group">
                        <label class="form-group">单价</label>
                        <input class="form-control" type="number" id="price" title="price" pattern="\d*"/>
                    </div>
                    <div class="form-group">
                        <input class="btn btn-primary btn-block" type="button" onclick="inc()" value="添加"/>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>

<script>
    class Price {
        constructor(unitPrice, weight) {
            this.unitPrice = unitPrice;
            this.weight = weight;
        }
        total() {
            return parseFloat(this.unitPrice * this.weight);
        }
        get(index) {
            let result = "<tr id='" + index +"'>";
            result += "<td>" + (index + 1) + "</td>";
            result += "<td>" + this.weight + "</td>";
            result += "<td>" + this.unitPrice + "</td>";
            result += "<td>" + this.total().toFixed(2) + "</td>";
            result += "</tr>";
            return result;
        }
    }
    let gems = [];
    let timer = null;
    function inc() {
        let price = document.getElementById("price").value;
        let weight = document.getElementById("weight").value;
        if (price == null || price === "")
        {
            alert("输入价格出错");
            return false;
        }
        if (weight == null || weight === "")
        {
            alert("输入重量出错");
            return false;
        }
        gems.push(new Price(price, weight));
        let index = gems.length - 1;
        document.getElementById("table_body").innerHTML += gems[index].get(index) + "<br />";
        let sum = 0;
        for (let gem of gems) {
            sum += gem.total();
        }
        document.getElementById("total").innerText = sum.toFixed(2).toString();
        document.getElementById("price").value = "";
        document.getElementById("weight").value = "";
        bindRemover();
    }
    function remove(index) {
        let result = confirm("确认删除: " + (index + 1) + " 吗?");
        if (result) {
            gems.splice(index, 1);
            document.getElementById("table_body").innerHTML = "";
            for (let i = 0; i < gems.length; i++) {
                document.getElementById("table_body").innerHTML += gems[i].get(i) + "<br />";
            }
            bindRemover();
            let sum = 0;
            for (let gem of gems) {
                sum += gem.total();
            }
            document.getElementById("total").innerText = sum.toFixed(2).toString();
            document.getElementById("price").value = "";
            document.getElementById("weight").value = "";
        }
    }
    function bindRemover() {
        for (let i = 0; i < gems.length; i++) {
            document.getElementById(i.toString()).ontouchstart = () => timer = setTimeout(() => remove(i), 800);
            document.getElementById(i.toString()).ontouchend = () => clearTimeout(timer);
        }
    }
</script>
</body>
</html>