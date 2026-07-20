<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Hello spring jsp</title>
</head>
<body>
<h1>Hello spring jsp</h1>
<section>
    <form method="post">
        <input name="name" placeholder="계좌명">
        <button>생성</button>
    </form>
</section>

<section>
    <c:forEach items="${accounts}" var="account">
        <div>
            <span>계좌ID : ${account.id}</span><br>
            <span>계좌이름 : ${account.name}</span><br>
            <span>생성일시 : ${account.createdAt}</span>
            <a href="<c:url value='/account/${account.id}' />">자세히보기</a>
        </div>
    </c:forEach>
</section>

</body>
</html>
