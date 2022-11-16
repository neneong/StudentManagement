<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String str=(String) session.getAttribute("id");
	if(str !=null){
		
	} else{
		out.print("<script>alert('잘못된 접근입니다.');location.href='/'</script>");
		
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생관리 프로그램</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</head>
<body class = "d-flex flex-column min-vh-100">
    <header class="p-3 mb-3 border-bottom">
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">
          <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
        </a>

        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <li><a href="/studentList" class="nav-link px-2 link-dark">학생 관리</a></li>
          <li><a href="/classList" class="nav-link px-2 link-dark">수업 관리</a></li>
        </ul>

        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
          <input type="search" class="form-control" placeholder="Search..." aria-label="Search">
        </form>

        <div class="dropdown text-end">
          <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
            <img src="https://github.com/mdo.png" alt="mdo" width="32" height="32" class="rounded-circle">
          </a>
          <ul class="dropdown-menu text-small">
          	<li class="dropdown-item"><%= (String)session.getAttribute("id") %></li>
            <li><a class="dropdown-item" href="/ClassAdd.jsp">새 클래스 만들기</a></li>
            <li><a class="dropdown-item" href="/studentAdd.jsp">학생 추가하기</a></li>
            <li><a class="dropdown-item" href="/settings.jsp">설정</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="/userLogout">로그아웃</a></li>
          </ul>
        </div>
      </div>
    </div>
  </header>
