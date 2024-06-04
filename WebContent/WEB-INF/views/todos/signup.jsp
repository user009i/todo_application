<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>アカウント作成画面</title>
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
    </head>
    <c:if test="${flush != null}">
            <div id="flush_message">
                <c:out value="${flush}"></c:out>
            </div>
    </c:if>
    <body>
        <div id="wrapper">
            <div id="header">
                <h1>TODO List 共有アプリケーション</h1>
                <a href="${pageContext.request.contextPath}/start" style="position: absolute; right: 0; bottom: 0;">戻る</a>
            </div>
            <div id="content">
                <form method="POST" action="${pageContext.request.contextPath}/userCreateConfirm">
                    ユーザーID: <input type="text" name="user_id" id="user_id" /><br>
                    名前:       <input type="text" name="user_name" id="user_name" /><br>
                    パスワード: <input type="password" name="user_password" id="user_password" /><br>
                    <br>

                    <input type="hidden" name="_token" value="${_token}" />
                    <button type="submit">アカウントを作成する</button>
                </form>
            </div>
            <div id="footer">
                by T.Shimizu and R.Inoue
            </div>
        </div>
    </body>
</html>
