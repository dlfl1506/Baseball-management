<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<h1>팀 리스트</h1>
<table border="1" width="1000px">
	<tr>
		<th>No</th>
		<th>팀 이름</th>
		<th>구장</th>
		<th></th>
	</tr>

	<c:forEach var="team" items="${teams}">
		<tr id="no-${team.id }">
			<td>${team.id }</td>
			<td>${team.teamName }</td>
			<td>${team.stadium.name }</td>
			<td><button class="btn btn-danger"
					onClick="deleteTeam(${team.id})">삭제</button></td>
		</tr>
	</c:forEach>
</table>


<script>
	function deleteTeam(id) {
		console.log(id);
		$.ajax({
			method:"DELETE",
			url: "/team/"+id
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