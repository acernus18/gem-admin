<!DOCTYPE html>
<html lang="zh">

<#include "Header.ftl">

<body>

<div id="wrapper">

    <#include "Navigation.ftl">

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Tables</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>

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
                                <th>TYPE</th>
                                <th>COLOR</th>
                                <th>AMOUNT</th>
                                <th>WEIGHT</th>
                                <th>COUNT AMOUNT</th>
                                <th>COUNT WEIGHT</th>
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
                                <td class="center">4</td>
                                <td class="center">X</td>
                            </tr>
                            <tr class="even gradeC">
                                <td>Trident</td>
                                <td>Internet Explorer 5.0</td>
                                <td>Win 95+</td>
                                <td class="center">5</td>
                                <td class="center">C</td>
                                <td>Win 95+</td>
                                <td class="center">4</td>
                                <td class="center">X</td>
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
            "name": 1,
            "type": 1,
            "color": 1,
            "amount": 1,
            "weight": 1,
            "countAmount": 1,
            "countWeight": 1,
        },
        {
            "gemId": 2,
            "name": 2,
            "type": 2,
            "color": 2,
            "amount": 2,
            "weight": 2,
            "countAmount": 2,
            "countWeight": 2,
        }
    ];

    $(document).ready(function () {
        $('#dataTables-example').DataTable({
            responsive: true,
            data: data,
            columns: [
                {data: "gemId"},
                {data: "name"},
                {data: "type"},
                {data: "color"},
                {data: "amount"},
                {data: "weight"},
                {data: "countAmount"},
                {data: "countWeight"}
            ]
        });
    });
</script>
</body>

</html>