<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>メイン画面</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h1>TODO List 共有アプリケーション</h1>
                    <form action="logout" method="post" style="position: absolute; right: 0; top: 0;">
                    <input type="submit" value="ログアウト">
            </div>
            <div id="content">
                ${param.content}
                <button onclick="location.href='new.jsp'">タスクを作成する</button>
            </div>
            <div id="footer">
                by T.Shimizu and R.Inoue

            </div>
        </div>
    </body>
</html>
