<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ include file="/header.jsp" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/classes.css">

      <section>

        <main class="form-signin w-100 m-auto text-center">
        	<form action="/classAdd" method="post">
          <div class="form-floating mb-3">
            <input type="text" class="form-control" name="className" id="floatingInput" placeholder="alphabeta">
            <label for="floatingInput">클래스 이름</label>
          </div>
          <div class="form-floating mb-3">
            <input type="text" class="form-control" name="classId" id="floatingInput" placeholder="betagamma">
            <label for="floatingInput">클래스 아이디</label>
          </div>
          
          <button type="submit" class="btn btn-outline-primary w-100 btn-lg">생성하기</button>
        </form>
        
        </main>

      </section>


      <%@ include file="/footer.jsp" %>