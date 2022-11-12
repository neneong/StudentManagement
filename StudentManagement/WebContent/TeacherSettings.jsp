<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ include file="header.jsp" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<section>

        <form action="">
          <div class="form-floating mb-3">
            <input type="text" class="form-control" id="floatingInput" placeholder="alphabeta">
            <label for="floatingInput">클래스 이름</label>
          </div>
          <div class="form-floating mb-3">
            <input type="text" class="form-control" id="floatingInput" placeholder="betagamma">
            <label for="floatingInput">클래스 아이디</label>
          </div>
          <div class="form-floating">
            <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
            <label for="floatingPassword">비밀번호(선택)</label>
          </div>
          <button type="button" class="btn btn-outline-primary">Primary</button>
        </form>

      </section>
      <%@ include file="footer.jsp" %>