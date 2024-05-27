<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>ToDolist作成画面</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h1>TODO List 共有アプリケーション</h1>
                <a href="index.jsp" style="position: absolute; right: 0; bottom: 0;">戻る</a>
            </div>
            <div id="content">
                <form action="NewTodoServlet" method="post">
                    タスク名: <input type="text" name="content"><br>
                    いつまでに: <input type="date" name="done_at"><br>
                    誰と: <input type="text" name="joined_user"><br>
                    <input type="submit" value="作成する">
                </form>
            </div>
            <div id="footer">
                by T.Shimizu and R.Inoue
            </div>
        </div>
    </body>
</html>
