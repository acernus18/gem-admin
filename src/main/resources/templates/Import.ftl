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
<form method="POST" action="/data/importSoldList" enctype="multipart/form-data" class="form-inline">
    <div class="form-group mb-2">
        <input type="file" class="form-control-file" name="file">
    </div>
    <div class="form-group mb-2">
        <input type="submit" class="btn btn-primary" value="SUBMIT">
    </div>
</form>
</body>
</html>