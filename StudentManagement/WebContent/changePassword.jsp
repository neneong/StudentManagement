<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ include file="header.jsp" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/classes.css">

      <section>

        <main class="form-signin w-100 m-auto text-center">
        	<form action="/changePassword" method="post">
          <div class="form-floating mb-3">
            <input type="text" class="form-control" name="defaultPw" id="floatingInput" placeholder="alphabeta">
            <label for="floatingInput">기존의 비밀번호</label>
          </div>
          <div class="form-floating">
            <input type="text" class="form-control" name = "newPw" id="floatingInput" placeholder="pw">
            <label for="floatingDate">새로운 비밀번호</label>
          </div>
          
          <button type="submit" class="btn btn-outline-primary w-100 btn-lg">비밀번호 변경하기</button>
        </form>
        
        </main>

      </section>


      <script src="./js/script.js"></script>
      <%@ include file="footer.jsp" %>