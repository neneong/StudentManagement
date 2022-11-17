<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="/header.jsp" %>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


			<link rel="stylesheet" href="<%=request.getContextPath()%>/css/home.css">

			<div class="container">
				<section class="py-5 text-center container">
				<div class="row py-lg-5">
					<div class="col-lg-6 col-md-8 mx-auto">
						<h1 class="fw-light">클래스 화면</h1>
						<p class="lead text-muted"></p>
					</div>
				</div>
			</section>
			
			<div class="justify-content-end d-flex p-2">
			<a href="/studentAddToClass?classId=<%= request.getParameter("classId")%>"><button class="btn btn-primary btn-md"
				type="button" aria-expanded="true">
				학생 추가하기
			</button></a>
			<a href="/studentAttend?classId=<%= request.getParameter("classId")%>"><button class="btn btn-primary btn-md"
				type="button" aria-expanded="true" style="margin-left: 20px;">
				출석체크하기
			</button></a>
			
		</div>

			<div class="album py-5 ">
				<div class="container">
					<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3 ">
						<div class="col">
							<div class="card text-center ms-4" style="width: 80rem;">
								<div class="card-header d-flex justify-content-around ">
									<div id = "stduentIdTitle" style="width: 10rem;">학생 아이디</div>
									<div id = "studentNameTitle" style="width: 10rem;">학생 이름</div>
									<div id = "studentNameTitle" style="width: 10rem;">생년월일</div>
									<div id = "studentEditTitle" style="width: 10rem;">수정</div>
									<div id = "studentDeleteTitle" style="width: 10rem;">삭제</div>
									<div style = "width:10rem;">출석 확인하기</div>
								</div>
								<ul class="list-group list-group-flush">

									<c:forEach var="item" items="${studentList}">

										<li class="list-group-item d-flex justify-content-around">
											<div id = "stduentId" style="width: 10rem;">${item.studentId}</div>
											<div id = "studentName" style="width: 10rem;">${item.studentName}</div>
											<div id = "studentBirth" style="width: 10rem;">${item.studentBirth}</div>
											<a style="width: 10rem;" href="${pageContext.request.contextPath}/StudentEdit?userId=${item.studentId}"class="del">
												<button type="button"class="btn btn-sm btn-outline-secondary">수정</button>
											</a>
											<a style="width: 10rem;" href="${pageContext.request.contextPath}/StudentDelete?userId=${item.studentId}"class="del">
												<button type="button"class="btn btn-sm btn-outline-secondary">삭제</button>
											</a>
											<a style="width: 10rem;" href="${pageContext.request.contextPath}/classAttend?userId=${item.studentId}&classId=<%= request.getParameter("classId")%>"class="del">
												<button type="button"class="btn btn-sm btn-outline-secondary">출석 확인하기</button>
											</a>
										</li>

									</c:forEach>
								</ul>
							</div>
						</div>


					</div>
				</div>
			</div>
			
			
			</div>

			<%@ include file="/footer.jsp" %>