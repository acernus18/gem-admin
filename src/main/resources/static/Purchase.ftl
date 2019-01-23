<!DOCTYPE html>
<html lang="zh">

<#include "Header.ftl">

<body>
<#include "Navigation.ftl">

<div id="wrapper">
    <div id="page-wrapper">
        <input type="file" id="file"/>
        <div id="demo"></div>
        <input type="button" onclick="out()">
    </div>
</div>
</body>
<script src="js/ExcelUtils.js"></script>
<script>

    let data = null;
    $('#file').change(function (e) {
        let files = e.target.files;
        data = parseExcelToObject(files[0]);
    });
    
    function out() {
        dumpObjectToExcel(data, "QA.xlsx");
    }

</script>
</html>