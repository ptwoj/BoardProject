<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판</title>
    <style>
        /* 스타일링을 위한 CSS 코드 */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        .header {
            background-color: #333;
            color: #fff;
            padding: 10px;
            text-align: center;
        }

        .container {
            margin: 20px;
        }

        .title {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 10px;
        }

        .board {
            border: 1px solid #ddd;
            padding: 20px;
            margin-bottom: 20px;
        }

        .board-title {
            font-size: 18px;
            font-weight: bold;
            margin-bottom: 10px;
            cursor: pointer; /* 클릭 가능한 커서 스타일 적용 */
        }

        .board-content {
            margin-bottom: 10px;
        }

        .board-footer {
            color: #999;
            font-size: 12px;
        }

        .login-section {
            margin-bottom: 20px;
            text-align: right;
        }

        .login-section a {
            color: #333;
            text-decoration: none;
            font-weight: bold;
        }

    </style>
    <script>
        // 게시물 클릭 시 상세 페이지로 이동하는 함수
        function viewBoard(boardId) {
            location.href = "/board/" + boardId;
        }
    </script>
</head>
<body>
<div class="header">
    <h1>게시판</h1>
</div>
<div class="container">
    <div class="login-section">
        <%-- 로그인 상태에 따라 다른 링크 표시 --%>
        <% if (session.getAttribute("username") != null) { %>
        <a href="/logout">로그아웃</a>
        <% } else { %>
        <a href="/user/login">로그인</a> |
        <a href="/user/signup">회원가입</a>
        <% } %>
    </div>
    <div class="title">
        최신 게시물
    </div>
    <%@ include file="boardList.jsp" %>
</div>
</body>
</html>
