<!DOCTYPE html>
<html lang="zh">

<#include "template/Header.ftl">
<#include "template/SearchModal.ftl">
<body>

<div id="wrapper">

    <#include "template/Navigation.ftl">

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Tables</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>

        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#searchModal">
            查询
        </button>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        DataTables Advanced Tables
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <table width="100%"
                               class="table table-striped table-bordered table-hover"
                               id="dataTables-example">
                            <thead>
                            <tr>
                                <th>GEM ID</th>
                                <th>NAME</th>
                                <th>AMOUNT</th>
                                <th>WEIGHT</th>
                                <th>Sold Time</th>
                                <th>Unit Price</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr class="odd gradeX">
                                <td>Trident</td>
                                <td>Internet Explorer 4.0</td>
                                <td>Win 95+</td>
                                <td class="center">4</td>
                                <td class="center">X</td>
                                <td>Win 95+</td>
                            </tr>
                            </tbody>
                        </table>
                        <!-- /.table-responsive -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->


<script>
    let data = [
        {
            "gemId": 1,
            "gemName": 1,
            "gemNumber": 1,
            "gemWeight": 1,
            "gemUnitPrice": 1,
            "soldTime": 1,
        }
    ];

    let dataTable = $('#dataTables-example').DataTable({
        responsive: true,
        data: data,
        columns: [
            {data: "gemId"},
            {data: "gemName"},
            {data: "gemNumber"},
            {data: "gemWeight"},
            {data: "gemUnitPrice"},
            {data: "soldTime"}
        ]
    });

    function search() {
        let settings = {
            "url": "/sold/get/" + $("#recipient-name").val(),
            "method": "GET",
            "headers": {
                "Content-Type": "application/json",
            }
        };

        $.ajax(settings).done(function (response) {
            data = response;
            console.log(response);
            dataTable.clear();
            dataTable.rows.add(response);
            dataTable.draw(response);
        });
    }
</script>
</body>

</html>