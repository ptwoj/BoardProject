<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>메인 페이지</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script>
        // 게시물 클릭 시 상세 페이지로 이동하는 함수
        function viewBoard(boardId) {
            location.href = "/board/" + boardId;
        }
    </script>
    <style>
        .custom-input {
            height: 30px; /* 높이 조정 */
            width: 400px; /* 넓이 조정 */
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/main">게시판 프로그램</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <%-- 로그인 상태에 따라 회원가입 링크 표시 여부 결정 --%>
            <% if (session.getAttribute("username") == null) { %>
            <li class="nav-item">
                <a class="nav-link" href="/user/signup">회원가입</a>
            </li>
            <li>
                <a class="nav-link" href="/user/login">로그인</a>
            </li>
            <% } else { %>
            <li class="nav-item">
                <a class="nav-link" href="/user/logout">로그아웃</a>
            </li>
            <% } %>
            <li class="nav-item">
                <a class="nav-link" href="/board/create">게시물 작성</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container mt-4">
    <div class="jumbotron">
        <% if (session.getAttribute("username") == null) { %>
        <h1 class="display-4">방문자님 환영합니다!</h1>
        <% } else { %>
        <h1 class="display-4"><%=session.getAttribute("username")%>님 환영합니다!</h1>
        <% } %>
        <p class="lead">게시판 프로그램을 사용해보세요.</p>
    </div>
</div>
<%-- 검색 조건을 선택하고 해당하는 조건 키워드와 일치하는 것이 있으면 가져오도록 설정 --%>
<% String condition = request.getParameter("condition"); %>
<div class="d-flex justify-content-center">
    <form method="get" action="/main" class="form-inline text-center">
        <div class="form-group">
            <select name="condition" class="form-control" style="width: 110px;height: 40px;">
                <option value="b.title" <%= (condition != null && condition.equals("b.title")) ? "selected" : "" %>>제목
                </option>
                <option value="b.content" <%= (condition != null && condition.equals("b.content")) ? "selected" : "" %>>
                    내용
                </option>
                <option value="u.username" <%= (condition != null && condition.equals("u.username")) ? "selected" : "" %>>
                    아이디
                </option>
                <option value="b.create_at" <%= (condition != null && condition.equals("b.create_at")) ? "selected" : "" %>>
                    작성날짜
                </option>
            </select>
        </div>
        <div class="form-group">
            <div class="input-group">
                <input type="text" name="keyword" placeholder="검색할 내용을 입력하세요" value="${param.keyword}"
                       class="form-control" style="height: 40px; width: 210px;">
                <div class="input-group-append">
                    <button type="submit" class="btn btn-primary">검색</button>
                </div>
            </div>
        </div>
    </form>
</div>
<p class="mt-2 text-center" style="font-size: 13px; color: #999;">※작성날짜로 검색시 예시 -&gt; 0000-00-00 ※</p>


<%@ include file="boardList.jsp" %>

</body>
</html>
