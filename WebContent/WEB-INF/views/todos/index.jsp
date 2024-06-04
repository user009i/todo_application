<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>メイン画面</title>
        <link rel="stylesheet" href="style.css">
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
                <form action="logout" method="post" style="position: absolute; right: 0; top: 0;">
                    <input type="submit" value="ログアウト">
                </form>
                <h1>${user_name} 様のページ</h1>
                <button onclick="location.href='${pageContext.request.contextPath}/joinProjectForm'">プロジェクト参加</button>
                <button onclick="location.href='${pageContext.request.contextPath}/createProjectForm'">プロジェクト作成</button>
            </div>
            <div id="content">
                <ol>
                    <li>
                        <c:forEach var="todo" items="${todos}" varStatus="status">
                            内容: ${todo.content} <br/>
                            締め切り: ${todo.deadline_at} <br/>
                            作成者: ${creators[status.index]} <br/>
                            状況: <c:choose>
                                      <c:when test="${todo.status == 0}">未着手</c:when>
                                      <c:when test="${todo.status == 1}">作業中</c:when>
                                      <c:otherwise>完了</c:otherwise>
                                  </c:choose>
                        </c:forEach>
                        <button onclick="location.href='${pageContext.request.contextPath}/WIP?todo_id=${todo.todo_id}'">作業開始</button>
                        <button onclick="location.href='${pageContext.request.contextPath}/done?todo_id=${todo.todo_id}''">完了</button>
                    </li>
                </ol>
                <button onclick="location.href='${pageContext.request.contextPath}/new'">タスクを作成する</button>
            </div>
            <div id="footer">
                by T.Shimizu and R.Inoue
            </div>
        </div>
    </body>
</html>
