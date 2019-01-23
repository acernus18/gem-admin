<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>GEM</title>

    <link href="/webjars/bootstrap/3.4.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="/webjars/metisMenu/1.1.3-1/metisMenu.min.css" rel="stylesheet">
    <link href="/webjars/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
    <link href="/webjars/datatables/1.10.12/css/dataTables.bootstrap.css" rel="stylesheet">
    <link href="/webjars/datatables-responsive/1.0.6/css/dataTables.responsive.css" rel="stylesheet">

    <script src="/webjars/jquery/3.3.1-1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <script src="/webjars/metisMenu/1.1.3-1/metisMenu.min.js"></script>
    <script src="/webjars/datatables/1.10.12/js/jquery.dataTables.min.js"></script>
    <script src="/webjars/datatables/1.10.12/js/dataTables.bootstrap.min.js"></script>
    <script src="/webjars/datatables-responsive/1.0.6/js/dataTables.responsive.js"></script>

    <link href="css/gem-admin.css" rel="stylesheet">
    <script src="js/gem-admin.js"></script>

    <script>
        $(document).ready(function () {
            $('#dataTables-example').DataTable({
                responsive: true
            });
        });
    </script>
</head>

<body>

<div id="wrapper">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/index">SB Admin v2.0</a>
        </div>
        <!-- /.navbar-header -->

        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <li>
                        <a href="/index"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-sitemap fa-fw"></i> Multi-Level Dropdown<span
                                    class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#">Second Level Item</a>
                            </li>
                            <li>
                                <a href="#">Second Level Item</a>
                            </li>
                            <li>
                                <a href="#">Third Level <span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="#">Third Level Item</a>
                                    </li>
                                    <li>
                                        <a href="#">Third Level Item</a>
                                    </li>
                                    <li>
                                        <a href="#">Third Level Item</a>
                                    </li>
                                    <li>
                                        <a href="#">Third Level Item</a>
                                    </li>
                                </ul>
                                <!-- /.nav-third-level -->
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                </ul>
            </div>
            <!-- /.sidebar-collapse -->
        </div>
        <!-- /.navbar-static-side -->
    </nav>

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

</body>

</html>