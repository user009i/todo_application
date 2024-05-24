<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>初期画面</title>
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
                <h1>TODO List</h1>
                <h1>共有アプリケーション</h1>
            </div>
            <div id="content">
                <div class="center-button">
                    <button onclick="location.href='${pageContext.request.contextPath}/signup'">アカウント作成</button>
                    <button onclick="location.href='${pageContext.request.contextPath}/login'">ログイン</button>
                </div>
            </div>
            <div id="footer">
                by T.Shimizu and R.Inoue
            </div>
        </div>
    </body>
</html>
