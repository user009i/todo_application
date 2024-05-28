<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>プロジェクト作成画面</title>
         <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h1>プロジェクト作成画面</h1>
                <h>プロジェクトのIDと名前を作成してね</h>
            </div>
            <div id="content">
                ${param.content}
                <form action="ProjectNewServlet" method="post">
                    プロジェクトID: <input type="text" name="project_id"><br>
                    プロジェクト名: <input type="text" name="project_name"><br>
                    <br>
                    <input type="submit" value="プロジェクトを作成する">
                </form>
            </div>
            <div id="footer">
                by T.Shimizu and R.Inoue
            </div>
        </div>
    </body>
</html>
