<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>ログイン画面</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div id="loginPage">
            <div id="header">
                <h1>ログイン画面</h1>
                <a href="start.jsp" style="position: absolute; right: 0; bottom: 0;">戻る</a>
            </div>
            <div id="content">
                <form action="LoginServlet" method="post" class="login-form">
                    <label for="user_id">UserID</label>
                    <input type="text" id="user_id" name="user_id"><br>
                    <label for="user_password">Password</label>
                    <input type="password" id="user_password" name="user_password"><br>
                    <input type="submit" value="ログイン" class="login-button">
                </form>
            </div>
            <div id="footer">
                by T.Shimizu and R.Inoue
            </div>
        </div>
    </body>
</html>
