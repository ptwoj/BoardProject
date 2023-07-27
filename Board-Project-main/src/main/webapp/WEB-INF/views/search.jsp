<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
    <%--검색 조건을 선택하고 해당하는 조건 키워드와 일치하는게 있으면 가져오도록 설정함--%>
    <% String condition = request.getParameter("condition"); %>
    <form method="get" action="/search">
        <select name="condition">
            <option value="b.title"<% if(condition != null && condition.equals("title")) { %>selected<% } %>>제목</option>
            <option value="b.content"<% if(condition != null && condition.equals("content")) { %>selected<% } %>>내용</option>
            <option value="u.username"<% if(condition != null && condition.equals("u.username")) { %>selected<% } %>>아이디</option>
            <option value="b.create_at"<% if(condition != null && condition.equals("create_at")) { %>selected<% } %>>작성날짜</option>
        </select>
<%--  selected if문은 검색 조건 저장하려고 만듬    --%>
<%-- null인 상태에서 equals() 메서드를 호출하면 오류가 발생하기 떄문에 condition != null 을 condition.equals("content") 보다
코드를 먼저 실행해서 null이 아닐떄만 equals()메서드를 호출하도록 함--%>
<%--searchDao select 구문에서 board와 user를 inner join하는데 username이 두군데 다 존재하기 때문에--%>
<%--컬럼을 공통되게 사용하는건 어떤 테이블에서 조회할지 지정을 하려고 u나 b를 넣어준것 (u = user table,b = board table)--%>
        <input type="text" name="keyword" placeholder="검색할 내용을 입력하세요" value="${param.keyword}" style="width:300px;height:40px;">
        <%--  value="${param.keyword}" 으로 검색한 값을 보여줌      --%>
        <input type="submit" value="검색">
    </form>
    <p>※작성날짜로 검색 예시 -> 0000-00-00 ※</p>

    <table>
        <tr>
            <td>username(id)</td>
            <td>name</td>
            <td>id</td>
            <td>title</td>
            <td>content</td>
            <td>category</td>
            <td>create_at</td>
        </tr>
        <c:forEach items="${boardlist}" var = "board">
            <tr>
                <td>${board.username}</td>
                <td>${board.name}</td>
                <td>${board.id}</td>
                <td>${board.title}</td>
                <td>${board.content}</td>
                <td>${board.category}</td>
                <td>${board.create_at}</td>
            </tr>
        </c:forEach>
    </table>
    <c:if test="${empty boardlist}">
        <p>검색조건에 맞는 데이터가 존재하지 않습니다.</p>
    </c:if>
</body>
</html>
