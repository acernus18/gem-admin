<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>File</title>
    <link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">

    <script src="/webjars/jquery/3.3.1/jquery.min.js"></script>
    <script src="/webjars/popper.js/1.14.7/popper.min.js"></script>
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="/webjars/vue/2.6.10/dist/vue.min.js"></script>
</head>
<body>

<div id="application">
    <table>
        <thead>
        <tr>
            <td>File Name</td>
            <td>Operator</td>
        </tr>
        </thead>
        <tbody>
        <tr v-for="file in fileList">
            <td><a href="#" @click="download(file)">{{file}}</a></td>
            <td>Delete</td>
        </tr>
        </tbody>
    </table>
</div>


<form method="POST" action="/file/upload" enctype="multipart/form-data" class="form-inline">
    <div class="form-group mb-2">
        <input type="file" class="form-control-file" name="file">
    </div>
    <div class="form-group mb-2">
        <input type="submit" class="btn btn-primary" value="SUBMIT">
    </div>
</form>

<script>
    let application = new Vue({
        el: '#application',
        data: {
            message: "123",
            fileList: [],
        },
        methods: {
            queryFileList: function () {
                let request = new XMLHttpRequest();
                request.onreadystatechange = function (e) {
                    if (request.readyState === 4 && request.status === 200) {
                        application["fileList"] = JSON.parse(request.responseText);
                    }
                };
                request.open("GET", "/file/list");
                request.send();
            },

            download: function (filename) {
                let token = btoa(encodeURIComponent(filename));
                window.location.assign("/file/get?code=" + token);
            },
        },
        mounted: function () {
            this.queryFileList();
        },
    });
</script>
</body>
</html>