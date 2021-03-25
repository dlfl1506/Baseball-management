<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<h1>야구장 등록페이지</h1>
<br/>
<form action="/stadium" method="post">
    <div class="form-group">
      <label for="text">구장 이름 :</label>
      <input type="text" class="form-control"  placeholder="구장 이름을 입력하세요" name="name" >
    </div>
    <button type="submit" class="btn btn-primary">야구장 등록</button>
  </form>
</body>
</html>