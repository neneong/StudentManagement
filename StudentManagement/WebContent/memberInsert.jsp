<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>

<section>
    <form action="./memberInsert" method="post">
        userId: <input type="text" name="userId" id="">
        userName : <input type="text" name="userName" id="">
        <button type="submit">등록</button>
    </form>

</section>


<%@ include file="footer.jsp" %>