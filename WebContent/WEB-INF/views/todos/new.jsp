<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>ToDolist作成画面</title>
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

            </div>
            <div id="task_new_create_content">
                <form action="${pageContext.request.contextPath}/createTodo" method="post">
                    タスク名: <input type="text" name="content" id="task"><br>
                    いつまでに:<input type="date" name="deadline_at" id="untilwhen"><br>
                    プロジェクトID: <input type="text" name="project_id" id="project_id"><br>
                    <div id="task_new_create_box">
                      <input type="submit" value="作成する" id="task_new_create">
                    </div>
                </form>
                <a href="${pageContext.request.contextPath}/index" style="position: absolute; right: 0; bottom: 0;">戻る</a>
            </div>
            <div id="footer">
                by T.Shimizu and R.Inoue
            </div>
        </div>
    </body>
</html>
