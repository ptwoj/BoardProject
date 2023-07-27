<%--
  Created by IntelliJ IDEA.
  User: sujeong
  Date: 2023/06/28
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.board.domain.dto.BoardDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<div class="container mt-4">
    <h2>게시물 수정</h2>
    <form action="/board/update" method="post">
        <input type="hidden" name="id" value="${board.id}">
        <div class="form-group">
            <label for="title">제목</label>
            <input type="text" class="form-control" id="title" name="title" value="${board.title}">
        </div>
        <div class="form-group">
            <label for="category">카테고리</label>
            <input type="text" class="form-control" id="category" name="category" value="${board.category}">
        </div>
        <div class="form-group">
            <label for="content">내용</label>
            <textarea class="form-control" id="content" name="content" rows="5">${board.content}</textarea>
        </div>
        <%--        <div class="form-group">--%>
        <%--            <label for="username">작성자</label>--%>
        <%--            <input type="text" class="form-control" id="username" name="username" value="${board.username}">--%>
        <%--        </div>--%>
        <button type="submit" class="btn btn-primary">수정</button>
    </form>
</div>
