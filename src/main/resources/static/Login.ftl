<!DOCTYPE html>
<html lang="zh">
<head>
    <title>登录</title>
</head>
<body>
${message!"null"}
<form method="post" action="/login">
    <label>用户名：
        <input name="username">
    </label><br>

    <label>密码：
        <input name="password">
    </label><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
