<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>プロジェクト参加画面</title>
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
    </head>
    <body>
        <div id="login-page">
        <div id="wrapper">
            <div id="header">
                <h1>プロジェクト参加画面</h1>
                <h2>参加したいプロジェクトIDを入力してください</h2>
            </div>
            <div id="content" class="form">
                ${param.content}
                <form action="${pageContext.request.contextPath}/joinProject" method="post">
                     <p>プロジェクトID</p>
                     <input type="text" name="project_id" placeholder="project_id"><br>
                    <br>
                    <button type="submit">参加する</button>
                </form>
            </div>
            <div id="footer">
                by T.Shimizu and R.Inoue
            </div>
        </div>
        </div>
    </body>
</html>