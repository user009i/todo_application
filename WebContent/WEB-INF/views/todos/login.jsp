<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>メイン画面</title>
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
    </head>
    <c:if test="${flush != null}">
            <div id="flush_message">
                <c:out value="${flush}"></c:out>
            </div>
    </c:if>
    <body>
        <div id="login-page">
            <div id="header">
                <h1>ログイン画面</h1>
            </div>
            <div id="content" class="form">
                <form action="${pageContext.request.contextPath}/userLoginConfirm" method="post" class="login-form">
                    <input type="text" id="user_id" name="user_id" value="${user.user_id}" placeholder="username"><br>

                    <input type="password" id="user_password" name="user_password" value="${user.user_password}" placeholder="password"><br>

                    <input type="hidden" name="_token" value="${_token}" />
                    <button type="submit" class="login-button">ログイン</button>
                </form>
                <a href="${pageContext.request.contextPath}/start" style="position: absolute; right: 0; bottom: 0;" id="back">戻る</a>
            </div>

            <div id="footer">
                by T.Shimizu and R.Inoue
            </div>
        </div>
    </body>
</html>
