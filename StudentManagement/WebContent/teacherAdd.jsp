<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ include file="header.jsp" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/classes.css">

      <section>

        <main class="form-signin w-100 m-auto text-center">
        	<form action="/teacherAdd" method="post">
          <div class="form-floating mb-3">
            <input type="text" class="form-control" name="teacherName" id="floatingInput" placeholder="alphabeta">
            <label for="floatingInput">선생님 성함</label>
          </div>
          <div class="form-floating mb-3">
            <input type="text" class="form-control" name="teacherId" id="floatingInput" placeholder="betagamma">
            <label for="floatingInput">선생님 아이디</label>
          </div>
          <div class="form-floating">
            <input type="password" class="form-control" name = "teacherPw" id="floatingPassword" placeholder="Password">
            <label for="floatingPassword">비밀번호</label>
          </div>
          
          <button type="submit" class="btn btn-outline-primary w-100 btn-lg">생성하기</button>
        </form>
        
        </main>

      </section>

      <script src="./js/script.js"></script>
      <%@ include file="footer.jsp" %>