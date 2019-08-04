<html lang="zh">
<head>
    <title>Check</title>

    <link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">

    <script src="/webjars/jquery/3.3.1/jquery.min.js"></script>
    <script src="/webjars/popper.js/1.14.7/popper.min.js"></script>
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="jumbotron text-center display-1">
    服务器状态监控
    <#if isOnline == "true">
        <span class="badge badge-success">在线</span>
    <#else>
        <span class="badge badge-danger">离线</span>
        <span class="display-4 text-danger">请检查服务器是否关机或网络是否正常</span>
    </#if>
</div>

<#--<div class="jumbotron">-->
<#--    footer-->
<#--</div>-->

<#--Server state: ${isOnline}-->
</body>
</html>
