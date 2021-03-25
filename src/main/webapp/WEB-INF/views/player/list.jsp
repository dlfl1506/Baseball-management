<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<h1>선수 리스트</h1>
<table border="1" width="1000px">
	<tr>
		<th>No</th>
		<th>선수이름</th>
		<th>포지션</th>
		<th>팀</th>
		<th></th>
	</tr>


	<c:forEach var="player" items="${players}">
		<tr id="no-${ player.id} ">
			<td>${ player.id}</td>
			<td>${ player.playerName}</td>
			<td>${ player.position}</td>
			<td>${ player.team.teamName}</td>
			<td>
				<button class="btn btn-danger" onClick="deletePlayer(${player.id})">삭제</button>
			</td>
		</tr>
	</c:forEach>

</table>


<script>
	function deletePlayer(id) {
		console.log(id);
		$.ajax({
			method:"DELETE",
			url: "/player/"+id
		})
		.done((data) => {
			console.log(data);
			if(data === "ok"){
				$("#no-"+id).remove();
				location.reload();
			}
		});
		
	}
</script>
</body>
</html>