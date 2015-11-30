<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.project.controller.SaleItemController" %>
<html>
<head>
    <title>Sale Item</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<script  type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js">
</script>

<body>
  <div style="width: 90%;margin-left: 5%">
    <a href="${pageContext.request.contextPath}">< Home</a>
    <form:form method="post" action="/ShopApp/saleItem" commandName="saleItemForm">
      <div style="width: 50%;float: left">
        <table class="table">
          <thead>
            <tr>
              <th colspan="2">Category</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="cw" items="${saleItemForm.categoryWrappers}" varStatus="status">
              <tr>
                  <td>
                    <label>${saleItemForm.categoryWrappers[status.index].category.name}</label>
                  </td>
                  <td>
                    <form:checkbox path="categoryWrappers[${status.index}].selected"></form:checkbox>
                  </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <div style="width: 50%;float: left">
        <table class="table">
          <thead>
            <tr>
                <th colspan="2">Product</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="pw" items="${saleItemForm.productWrappers}" varStatus="status">
              <tr>
                <td>
                  <label>${saleItemForm.productWrappers[status.index].product.name}</label>
                </td>
                <td>
                  <form:checkbox path="productWrappers[${status.index}].selected"></form:checkbox>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
          <br>
        <input type="submit" class="button" value="Save SaleItem">
      </div>
    </form:form>
    <hr>
    <div style="width: 60%">
        <h2>SaleItems : Categories and related Product</h2>
        <table class="table">
          <thead>
              <tr>
                  <th>Category</th>
                  <th>Product</th>
              </tr>
          </thead>
          <tbody>
            <c:forEach items="${saleItemList}" var="sli">
                <tr>
                    <td>${sli.category.name}</td>
                    <td>${sli.product.name}</td>
                </tr>
            </c:forEach>
          </tbody>
        </table>
    </div>
  </div>
</body>
</html>
