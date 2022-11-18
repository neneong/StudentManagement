<!-- index.jsp실행하면 됩니다. 서버 경로는 /로 설정해주시면 됩니다.  -->
<!-- sql 실행의 경우는 qeury.sql파일을 열고, 위에서 아래로 순차 실행해주시면 됩니다. -->


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>



	<% String str=(String) session.getAttribute("id"); if(str !=null){ response.sendRedirect("/classList"); } %>

		<html lang="en">

		<head>
			<meta charset="utf-8">
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<meta name="description" content="">
			<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
			<meta name="generator" content="Hugo 0.104.2">
			<title>로그인 화면</title>

			<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
				integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
				crossorigin="anonymous">
				
			<link rel="stylesheet" href="/css/style.css">

			<link rel="stylesheet" href="/css/signin.css">
			
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
				crossorigin="anonymous"></script>
			
			
			<!-- Favicons -->
			<meta name="theme-color" content="#712cf9">

		</head>

		<body class="text-center">

			<main class="form-signin w-100 m-auto">
				<form action="/userLogin" method="post">

					<h1 class="h3 mb-3 fw-normal">학생관리프로그램 </br> 로그인</h1>

					<div class="form-floating">
						<input type="text" name="userId" class="form-control" id="floatingInput" placeholder="id">
						<label for="floatingInput">아이디</label>
					</div>
					<div class="form-floating" style="margin-top:5px;">
						<input type="password" name="userPwd" class="form-control" id="floatingPassword"
							placeholder="Password"> <label for="floatingPassword">비밀번호</label>
					</div>

					<button class="w-100 btn btn-lg btn-primary" type="submit">로그인하기</button>
					
					
				</form>
				
				<a href = "/signup.jsp"><button class="w-100 btn btn-lg btn-primary" style="margin-top:5px;">회원가입하기</button></a>
				<p class="mt-5 mb-3 text-muted">© 2017–2022</p>
			</main>





		</body>

		</html>