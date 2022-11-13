<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ include file="header.jsp" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.b-example-divider {
	height: 3rem;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
		rgba(0, 0, 0, .15);
}

.b-example-vr {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh;
}

.bi {
	vertical-align: -.125em;
	fill: currentColor;
}

.nav-scroller {
	position: relative;
	z-index: 2;
	height: 2.75rem;
	overflow-y: hidden;
}

.nav-scroller .nav {
	display: flex;
	flex-wrap: nowrap;
	padding-bottom: 1rem;
	margin-top: -1px;
	overflow-x: auto;
	text-align: center;
	white-space: nowrap;
	-webkit-overflow-scrolling: touch;
}

html, body {
	height: 100%;
}

section{
	height:500px;
	dispaly:flex;
	align-items: center;
	padding-top: 5%;
	padding-bottom: 5%;
}

.form-signin {
	max-width: 330px;
	padding: 15px;
}

.form-signin .form-floating:focus-within {
	z-index: 2;
}

.form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>

      <section>

        <main class="form-signin w-100 m-auto text-center">
        	<form action="/classAdd">
          <div class="form-floating mb-3">
            <input type="text" class="form-control" name="className" id="floatingInput" placeholder="alphabeta">
            <label for="floatingInput">클래스 이름</label>
          </div>
          <div class="form-floating mb-3">
            <input type="text" class="form-control" name="classId" id="floatingInput" placeholder="betagamma">
            <label for="floatingInput">클래스 아이디</label>
          </div>
          <div class="form-floating">
            <input type="password" class="form-control" name = "classPw" id="floatingPassword" placeholder="Password">
            <label for="floatingPassword">비밀번호(선택)</label>
          </div>
          <button type="button" class="btn btn-outline-primary w-100 btn-lg">생성하기</button>
        </form>
        
        </main>

      </section>


      <script src="./js/script.js"></script>
      <%@ include file="footer.jsp" %>