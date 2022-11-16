<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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


	<div class="album py-5 ">
		<div class="container">
			<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3 ">
				<div class="col">
					<div class="card text-center ms-4" style="width: 80rem;">
						<form action="/studentAttendIn">
							<div class="card-header d-flex justify-content-around ">
								<div id="stduentIdTitle" style="width: 25rem;">학생 아이디</div>
								<div id="studentNameTitle" style="width: 25rem;">학생 이름</div>
								<div id="studentNameTitle" style="width: 25rem;">출석여부</div>
							</div>

							<ul class="list-group list-group-flush">

								<c:forEach var="item" items="${studentList}">

									<li class="list-group-item d-flex justify-content-around">
										<div id="stduentId" style="width: 25rem;">${item.studentId}</div>
										<div id="studentName" style="width: 25rem;">${item.studentName}</div>
										<div class="form-check d-flex justify-content-center "
											style="width: 25rem;">
											<input class="form-check-input" type="checkbox"
												value="${item.studentId}" name="attend"
												id="flexCheckDefault"> 
											<input type="hidden"
												value="${classId}" name="classId">
										</div>
									</li>

								</c:forEach>
							</ul>

							<button type="submit" class="btn btn-primary">출석체크하기</button>
						</form>
					</div>

				</div>


			</div>
		</div>
	</div>


</div>
<script src="./js/script.js"></script>
<%@ include file="footer.jsp"%>