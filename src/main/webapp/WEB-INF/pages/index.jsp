<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>

<body>
  <h1>${message}</h1>
    <h2>${pageContext.request.contextPath}</h2>
    <a href="/ShopApp/category">Categories</a>
    <a href="/ShopApp/product">Products</a>
</body>

</html>
