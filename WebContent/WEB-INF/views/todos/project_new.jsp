<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>プロジェクト作成画面</title>
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
    </head>
    <body>
        <div id="wrapper">
        <div id="login-form">
            <div id="header">
                <h1>プロジェクト作成画面</h1>
                <h2>プロジェクトのIDと名前を作成してください</h2>
            </div>
            <div id="content" class="form">

                ${param.content}
                <form action="${pageContext.request.contextPath}/projectCreateConfirm" method="post">
                    プロジェクトID<input type="text" name="project_id" placeholder="project_id"><br>
                    プロジェクト名<input type="text" name="project_name" placeholder="project_name"><br>
                    <br>
                    <button type="submit">プロジェクトを作成する</button>
                </form>
            </div>
            <div id="footer">
                by T.Shimizu and R.Inoue
            </div>
        </div>
        </div>
    </body>
</html>