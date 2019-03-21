<!DOCTYPE html>
<html lang="en">

<#include "template/Header.ftl">

<body>
<#--<nav class="navbar navbar-expand-sm bg-light navbar-light">-->
    <#--<a class="navbar-brand" href="#">立信</a>-->
    <#--<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">-->
        <#--<span class="navbar-toggler-icon"></span>-->
    <#--</button>-->
    <#--<div class="collapse navbar-collapse" id="collapsibleNavbar">-->
        <#--<ul class="navbar-nav">-->
            <#--<li class="nav-item">-->
                <#--<a class="nav-link" href="#">神秘代码转换器</a>-->
            <#--</li>-->
            <#--<li class="nav-item">-->
                <#--<a class="nav-link" href="#">Link</a>-->
            <#--</li>-->
            <#--<li class="nav-item">-->
                <#--<a class="nav-link" href="#">Link</a>-->
            <#--</li>-->
        <#--</ul>-->
    <#--</div>-->
<#--</nav>-->
<#--<br>-->

<div id="wrapper">
    <#include "template/Navigation.ftl">



    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Tables</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>

        <div class="container">
            <div class="card">
                <div class="card-body">
                    <div class="form-group">
                        <label for="origin">数字</label>
                        <input class="form-control" type="number" id="origin"/>
                    </div>
                    <div class="form-group">
                        <label for="old">旧码</label>
                        <input class="form-control" type="text" id="old"/>
                    </div>

                    <div class="form-group">
                        <label for="new">新码</label>
                        <input class="form-control" type="text" id="new"/>
                    </div>
                </div>
            </div>
        </div>
</div>

</body>

<script>
    function convert(price) {
        const codeMap = ['V', 'H', 'K', 'L', 'M', 'N', 'R', 'S', 'T', 'U'];
        let result = "";
        price.toString().split("").forEach(function (e) {
            if (/^\d$/.test(e)) {
                result += codeMap[parseInt(e)];
            } else {
                result += "输入错误";
            }
        });
        return result;
    }
    function convertHex(price) {
        const codeMap = ['V', 'H', 'K', 'L', 'M', 'N', 'R', 'S', 'T', 'U'];
        let result = "";
        parseInt(price).toString(16).split("").forEach(function (e) {
            if (/^\d$/.test(e)) {
                result += codeMap[parseInt(e)];
            } else if (/^[a-fA-F]$/.test(e)) {
                result += e.toUpperCase();
            } else {
                result += "输入错误";
            }
        });
        return result;
    }
    function convertOriginOld(origin) {
        const codeMap = {'V': 0, 'H': 1, 'K': 2, 'L': 3, 'M': 4, 'N': 5, 'R': 6, 'S': 7, 'T': 8, 'U': 9};
        let result = "";
        origin.toString().split("").forEach(function (value) {
            if (value in codeMap) {
                result += codeMap[value];
            } else {
                result += "输入错误";
            }
        });
        return result;
    }
    function convertOriginNew(origin) {
        const codeMap = {'V': 0, 'H': 1, 'K': 2, 'L': 3, 'M': 4, 'N': 5, 'R': 6, 'S': 7, 'T': 8, 'U': 9};
        let result = "";
        origin.toString().split("").forEach(function (e) {
            if (e in codeMap) {
                result += codeMap[e];
            } else if (/^[a-fA-F]$/.test(e)) {
                result += e.toUpperCase();
            } else {
                result += "输入错误";
            }
        });
        return parseInt(result, 16);
    }
    document.getElementById("origin").onchange = function (ev) {
        let x = document.getElementById("origin").value;
        document.getElementById("old").value = convert(x);
        document.getElementById("new").value = convertHex(x);
    };
    document.getElementById("old").onchange = function (ev) {
        let x = document.getElementById("old").value;
        document.getElementById("origin").value = convertOriginOld(x);
        document.getElementById("new").value = convertHex(document.getElementById("origin").value);
    };
    document.getElementById("new").onchange = function (ev) {
        let x = document.getElementById("new").value;
        document.getElementById("origin").value = convertOriginNew(x);
        document.getElementById("old").value = convert(document.getElementById("origin").value);
    };
</script>
</html>
