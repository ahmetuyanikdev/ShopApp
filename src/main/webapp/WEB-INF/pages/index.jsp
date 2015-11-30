<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>

<body>
  <h1>${message}</h1>
    <h2>${pageContext.request.contextPath}</h2>
    <a href="${pageContext.request.contextPath}/category">Categories</a>
    <a href="${pageContext.request.contextPath}/product">Products</a>
    <a href="${pageContext.request.contextPath}/saleItem">Sale Items</a>
</body>

</html>
