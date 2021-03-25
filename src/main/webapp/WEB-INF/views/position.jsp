<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp"%>
<h1>포지션별 리스트</h1>
<table border="1" width="1000px">
	<tr>
		<th>포지션</th>
		<th>롯데자이언츠</th>
		<th>LG트윈스</th>
		<th>kt wiz</th>
	</tr>

	<c:forEach var="dto" items="${dto}">
		<tr>
			<td>${dto.position}</td>
			<td>${dto.lotte}</td>
			<td>${ dto.lg}</td>
			<td>${dto.kt}</td>
		</tr>
	</c:forEach>

</table>

</body>
</html>