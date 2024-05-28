<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>プロジェクト参加画面</title>
         <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h1>プロジェクト参加画面</h1>
                <h>参加したいプロジェクトIDを入力してね！！！！！</h>
            </div>
            <div id="content">
                ${param.content}
                <form action="ProjectJoinServlet" method="post">
                    プロジェクトID: <input type="text" name="project_id"><br>
                    <br>
                    <input type="submit" value="プロジェクトに参加する">
                </form>
            </div>
            <div id="footer">
                by T.Shimizu and R.Inoue
            </div>
        </div>
    </body>
</html>
