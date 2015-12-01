<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>

<body>
  <div class="col-md-12"><h2><label class="label label-primary">${message}</label></h2></div>
   <div class="col-md-12">
       <div class="col-md-2"><h3><a href="${pageContext.request.contextPath}/category">Categories</a></h3></div>
       <div class="col-md-2"><h3><a href="${pageContext.request.contextPath}/product">Products</a></h3></div>
       <div class="col-md-2"><h3><a href="${pageContext.request.contextPath}/saleItem">Sale Items</a></h3></div>
       <div class="col-md-2"><h3><a href="${pageContext.request.contextPath}/purchases">Shopping Card</a></h3></div>
   </div>
</body>

</html>
