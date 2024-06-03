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
        <div id="wrapper">
            <div id="header">
                <h1>TODO List 共有アプリケーション</h1>
                <div id="end">
                <form action="logout" method="post" style="position: absolute; right: 0; top: 0;">
                    <input type="submit" value="ログアウト">
                </form>
                </div>
                <h3>${user_name} 様のページ</h3>
                <button onclick="location.href='${pageContext.request.contextPath}/joinProjectForm'">プロジェクト参加</button>
                <button onclick="location.href='${pageContext.request.contextPath}/createProjectForm'">プロジェクト作成</button>
            </div>
            <div id="content">
                <ol>

                    <c:forEach var="todo" items="${todos}" varStatus="status">
                        <li>
                            内容: ${todo.content} <br/>｜
                            締め切り: ${todo.deadline_at} <br/>｜
                            作成者: ${creators[status.index]} <br/>｜
                            状況: <c:choose>
                                    <c:when test="${todo.status == 0}">未着手</c:when>
                                    <c:when test="${todo.status == 1}">作業中</c:when>
                                    <c:otherwise>完了</c:otherwise>
                                  </c:choose>
                        </li>
                    </c:forEach>

                </ol>
                <button onclick="location.href='${pageContext.request.contextPath}/new'">タスクを作成する</button>
            </div>
            <div id="footer">
                by T.Shimizu and R.Inoue
            </div>
        </div>
    </body>
</html>
