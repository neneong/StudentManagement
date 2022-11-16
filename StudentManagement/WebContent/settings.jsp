<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class = 'py-2 md-3 container d-flex shadow-sm w-25 h-25 mx-auto mt-auto flex-column '>
	<div class="card text-center" >
  		<div class="card-header">
    		프로필 사진 변경
 		 </div>
  		<div class="card-body">
    		<h5 class="card-title">프로필 사진을 변경합니다.</h5>
    		<a href="#" class="btn btn-primary">사진 변경하기</a>
  		</div>
	</div>


	<div class="card text-center" style="margin-top:30px;">
  		<div class="card-header">
    		비밀번호 변경하기
 		 </div>
  		<div class="card-body">
    		<h5 class="card-title">비밀번호를 변경합니다.</h5>
    		<a href="/changePassword.jsp" class="btn btn-primary">비밀번호 변경하기</a>
  		</div>
	</div>
	
	<div class="card text-center" style="margin-top:30px;">
  		<div class="card-header">
    		선생님 추가하기
 		 </div>
  		<div class="card-body">
    		<h5 class="card-title">선생님을 추가합니다.</h5>
    		<a href="/teacherAdd.jsp" class="btn btn-primary">선생님 추가하기</a>
  		</div>
	</div>
	
	<div class="card text-center" style="margin-top:30px;">
  		<div class="card-header">
    		회원 탈퇴하기
 		 </div>
  		<div class="card-body">
    		<h5 class="card-title">회원 탈퇴 메뉴입니다.</h5>
    		<a href="#" class="btn btn-primary">회원 탈퇴하기</a>
  		</div>
	</div>

</section>
      
<%@ include file="footer.jsp" %>