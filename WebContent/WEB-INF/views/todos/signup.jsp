<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>アカウント作成</title>
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
    </head>
    <c:if test="${flush != null}">
            <div id="flush_message">
                <c:out value="${flush}"></c:out>
            </div>
    </c:if>
       <div id="login-page">
            <div id="header">
                <h1>アカウント作成画面</h1>
            </div>
            <div id="content" class="form">
                <form method="POST" action="${pageContext.request.contextPath}/userCreateConfirm">
                    <input type="text" name="user_id" id="user_id" value="${user.user_id }"  placeholder="userId" /><br>
                    <input type="text" name="user_name" id="user_name" value="${user.user_name}" placeholder="username" /><br>
                    <input type="password" name="user_password" id="user_password" value="${user.user_password}"  placeholder="password" /><br>
                    <br>

                    <input type="hidden" name="_token" value="${_token}" />
                    <button type="submit" class="login-button">アカウントを作成する</button>
                </form>
                <a href="${pageContext.request.contextPath}/start" style="position: absolute; right: 0; bottom: 0;">戻る</a>
            </div>
            <div id="footer">
                by T.Shimizu and R.Inoue
            </div>
        </div>
    </body>

            <div id="footer">
                by T.Shimizu and R.Inoue
            </div>
        </div>
    </body>
</html>


