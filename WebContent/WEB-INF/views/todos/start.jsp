<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_message">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>スタート画面</h2>

        <p><a href="${pageContext.request.contextPath}/login">ログイン（登録済みの方はこちら）</a></p>
        <p><a href="${pageContext.request.contextPath}/signup">アカウント作成（新規の方はこちら）</a></p>

    </c:param>
</c:import>