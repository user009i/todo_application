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
                <div id="logoutbox">
                    <button onclick="location.href='${pageContext.request.contextPath}/logout'" id="logout">ログアウト</button>
                </div>
                <h1>TODO List 共有アプリケーション</h1>
                <h3>${user_name} 様のページ</h3>
                <button onclick="location.href='${pageContext.request.contextPath}/joinProjectForm'" id="joinProject">プロジェクト参加</button>
                <button onclick="location.href='${pageContext.request.contextPath}/createProjectForm'" id="createProjectForm">プロジェクト作成</button>
            </div>
            <div id="content_index">
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
                            <c:choose>
                                <c:when test="${todo.in_project == true}">
                                     | プロジェクト: ${projects[status.index]} <br/>
                                </c:when>
                            </c:choose>

                            <c:choose>
                                <c:when test="${todo.creator == user_id}">
                                    <form method="POST" action="${pageContext.request.contextPath}/WIP?todo_id=${todo.todo_id}">
                                        <button type="submit" class="WIP-button">着手</button>
                                    </form>
                                    <form method="POST" action="${pageContext.request.contextPath}/done?todo_id=${todo.todo_id}">
                                        <button type="submit" class="done-button">完了</button>
                                    </form>
                                </c:when>
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