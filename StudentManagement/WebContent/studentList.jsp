<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="header.jsp" %>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
						<button class="btn btn-secondary btn-lg dropdown-toggle show" type="button"
							data-bs-toggle="dropdown" aria-expanded="true">
							<% String year="" ; try { year=request.getParameter("year"); }catch(Exception e) { } if(year
								!=null){ out.print(year); }else{ out.print("연도 선택"); } %>
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


						<div class="col">
							<div class="card" style="width: 18rem;">
								<div class="card-header">
									Featured
								</div>
								<ul class="list-group list-group-flush">
									<c:forEach var="item" items="${classes}">
										<li class="list-group-item">${item.classId} <br> 
											<a href="${pageContext.request.contextPath}/ClassDelete?userId=${item.classId}"class="del">
												<button type="button"class="btn btn-sm btn-outline-secondary">삭제</button>
											</a>
										</li>
									</c:forEach>
								</ul>
							</div>
						</div>


					</div>
				</div>
			</div>
			<script src="./js/script.js"></script>
			<%@ include file="footer.jsp" %>