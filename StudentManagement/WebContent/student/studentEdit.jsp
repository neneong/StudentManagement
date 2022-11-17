<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ include file="/header.jsp" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/classes.css">

      <section>

        <main class="form-signin w-100 m-auto text-center">
        	<form action="/studentEdit" method="post">
          <div class="form-floating mb-3">
            <input type="text" class="form-control" name="studentName" id="floatingInput" placeholder="alphabeta" value = "${student.studentName}">
            <label for="floatingInput"  >학생 이름</label>
          </div>
          <div class="form-floating">
            <input type="text" class="form-control" name = "studentBirth" id="floatingInput" placeholder="pw" value="${student.studentBirth}">
            <label for="floatingDate">학생 생년월일 </label>
          </div>
          
          <input type="hidden" name = "studentId"  value = "${student.studentId}">
          
          <button style="margin-top:20px;" type="submit" class="btn btn-outline-primary w-100 btn-lg">학생 정보 변경하기</button>
        </form>
        
        </main>

      </section>


      <%@ include file="/footer.jsp" %>