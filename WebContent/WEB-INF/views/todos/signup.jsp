<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>アカウント作成画面</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h1>TODO List 共有アプリケーション</h1>
                <a href="start.jsp" style="position: absolute; right: 0; bottom: 0;">戻る</a>
            </div>
            <div id="content">
                <form action="NewAccountServlet" method="post">
                    ユーザーID: <input type="text" name="user_id"><br>
                    名前:       <input type="text" name="user_name"><br>
                    パスワード: <input type="password" name="user_password"><br>
                    <br>
                    <input type="submit" value="作成する">
                </form>
            </div>
            <div id="footer">
                by T.Shimizu and R.Inoue
            </div>
        </div>
    </body>
</html>
