<%--
  Created by IntelliJ IDEA.
  User: sujeong
  Date: 2023/06/27
  Time: 5:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.board.domain.dto.BoardDto" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<div class="container mt-4">
    <div class="row">
        <c:forEach items="${boardList}" var="board">
            <div class="col-md-4 mb-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">${board.title}</h5>
                        <p class="card-text">작성자: ${board.username}</p>
                        <p class="card-text">작성일: ${board.createAt}</p>
                        <a href="#" class="btn btn-primary" onclick="viewBoard(${board.id})">자세히 보기</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<script>
    // 게시물 클릭 시 상세 페이지로 이동하는 함수
    function viewBoard(boardId) {
        location.href = "/board/" + boardId;
    }
</script>
