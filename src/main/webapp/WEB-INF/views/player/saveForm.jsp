<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<h1>선수등록 페이지</h1>
<br />
<form action="/player" method="post">
	<div class="form-group">
		<label for="text">선수 이름 :</label> <input type="text"
			class="form-control" id="playerName" placeholder="선수이름을 입력하세요."
			name="playerName">
	</div>
	<div class="form-group">
		<label for="text">포지션 :</label>
		<select  class="form-control" name="position">
			<option>투수</option>
			<option>내야수</option>
			<option>외야수</option>
			<option>포수</option>
		
		</select>
	</div>
	
	<div class="form-group">
	<label for="text">팀 이름 :</label>
		<select  class="form-control" name="teamId">
			<c:forEach var="team" items="${teams}">
				<option value="${team.id }">${team.teamName }</option>
			</c:forEach>
		</select>
	</div>
	<button type="submit" class="btn btn-primary">선수 등록</button>
</form>
</body>
</html>