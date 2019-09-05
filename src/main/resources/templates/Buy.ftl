<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">

    <script src="/webjars/jquery/3.3.1/jquery.min.js"></script>
    <script src="/webjars/popper.js/1.14.7/popper.min.js"></script>
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="#">123</a>
</nav>
<div class="container">
    <div class="card">
        <div class="card-header">

        </div>
        <div class="card-body">
            <table class="table">
                <thead>
                <tr>
                    <th>下载模板</th>
                    <th>生成提货单</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        <form method="POST" action="/data/template" class="form-inline">
                            <div class="form-group mb-2">
                                <input type="submit" class="btn btn-primary" value="下载">
                            </div>
                        </form>
                    </td>
                    <td>
                        <form method="POST" action="/data/generateBuyOrder" enctype="multipart/form-data" class="form-inline">
                            <div class="form-group mb-2">
                                <input type="file" class="form-control-file" name="file">
                            </div>
                            <div class="form-group mb-2">
                                <input type="submit" class="btn btn-primary" value="提交">
                            </div>
                        </form>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="card-footer">
            版权所有 @Maples
        </div>
    </div>
</div>

</body>
</html>