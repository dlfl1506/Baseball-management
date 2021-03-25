<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<h1>팀등록페이지</h1>
<br />
<form action="/team" method="post">
	<div class="form-group">
	 <label for="text">팀 이름 :</label>
		<input type="text" class="form-control" placeholder="팀 이름을 입력해주세요." name="teamName">
	</div>
	<div class="form-group">
		 <label for="text">구장 이름 :</label>
		<select class="form-control" name="stadiumId">
			<c:forEach var="stadium" items="${stadiums}">
				<option value="${stadium.id }">${stadium.name }</option>
			</c:forEach>
		</select>
	</div>
	<button type="submit" class="btn btn-primary">팀 등록</button>
</form>
</body>
</html>