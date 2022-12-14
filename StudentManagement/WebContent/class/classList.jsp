<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<link rel="stylesheet" href="<%=request.getContextPath()%>/css/home.css">

<section class="py-5 text-center container">
	<div class="row py-lg-5">
		<div class="col-lg-6 col-md-8 mx-auto">
			<h1 class="fw-light">학생 관리 프로그램</h1>
			<p class="lead text-muted"></p>
		</div>
	</div>
</section>

<div class="album py-5 bg-light">
	<div class="container">

		<div class="dropdown justify-content-end d-flex p-2">
			<button class="btn btn-secondary btn-lg dropdown-toggle show"
				type="button" data-bs-toggle="dropdown" aria-expanded="true">
				<% String year="" ; try { year=request.getParameter("year"); }catch(Exception e) { } if(year !=null){
                out.print(year); }else{ out.print("연도 선택"); } %>
			</button>
			<ul class="dropdown-menu"
				style="position: absolute; inset: 0px auto auto 0px; margin: 0px; transform: translate(0px, 50px);"
				data-popper-placement="bottom-start">
				<li>
					<h6 class="dropdown-header">연도 선택</h6>
				</li>
				<li><a class="dropdown-item" href="/classList?year=2022">2022년</a></li>
				<li><a class="dropdown-item" href="/classList?year=2021">2021년</a></li>
				<li><a class="dropdown-item" href="/classList?year=2020">2020년</a></li>
				<li>
					<hr class="dropdown-divider">
				</li>
				<li><a class="dropdown-item" href="/">전체 보기</a></li>
			</ul>
		</div>
		<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">

			<c:forEach var="item" items="${classes}">
				<div class="col">
					<div class="card shadow-sm">
						<svg class="bd-placeholder-img card-img-top" width="100%"
							height="225" xmlns="http://www.w3.org/2000/svg" role="img"
							aria-label="Placeholder: Thumbnail"
							preserveAspectRatio="xMidYMid slice" focusable="false">
                    <title>Placeholder</title>
                    <rect width="100%" height="100%" fill="#55595c"></rect>
							<text x="50%" y="50%" fill="#eceeef" dy=".3em">${item.className}</text>
                  </svg>

						<div class="card-body">
							<div class="d-flex justify-content-between align-items-center">
								<div class="btn-group">
									<a
										href="${pageContext.request.contextPath}/classView?classId=${item.classId}"
										class="edit"><button type="button"
											class="btn btn-sm btn-outline-secondary" style="margin-right:10px;">보기</button></a>
											<a
										href="${pageContext.request.contextPath}/classDelete?classId=${item.classId}"
										class="del"><button type="button"
											class="btn btn-sm btn-outline-secondary">삭제</button></a>
										

								</div>
								<small class="text-muted">${item.date}</small>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>


		</div>
	</div>
</div>
<%@ include file="/footer.jsp"%>