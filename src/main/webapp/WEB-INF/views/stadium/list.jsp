<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<h1>야구장 리스트</h1>
<table border="1" width="1000px">
	<tr>
		<th>No</th>
		<th>구장</th>
		<th>팀</th>
		<th></th>
	</tr>


	<c:forEach var="stadium" items="${stadiums}">
		<tr id="no-${stadium.id}">
			<td>${stadium.id}</td>
			<td>${stadium.name}</td>
			<td>${stadium.team.teamName}</td>
			<td><button class="btn btn-danger"
					onClick="deleteStadium(${stadium.id})">삭제</button></td>
		</tr>
	</c:forEach>


</table>

<script>
function deleteStadium(id) {
	console.log(id);
	$.ajax({
		method:"DELETE",
		url: "/stadium/"+id
	})
	.done((data) => {
		console.log(data);
		if(data === "ok"){
			$("#no-"+id).remove();
		}
	});
}
</script>
</body>
</html>