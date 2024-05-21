<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${flush != null}">
    <div id="flush_message">
        <c:out value="${flush}"></c:out>
    </div>
</c:if>


<h2>ログイン画面</h2>
<form method="POST" action="${pageContext.request.contextPath}/userLoginConfirm">
    <label for="user_id">ユーザID</label><br />
    <input type="text" name="user_id" id="user_id" value="${user.user_id}" />
    <br /><br />

    <label for="user_password">パスワード</label><br />
    <input type="text" name="user_password" id="user_password" value="${user.user_password}" />
    <br /><br />

    <input type="hidden" name="_token" value="${_token}" />
    <button type="submit">ログイン</button>
</form>