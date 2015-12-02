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
<style>
    .listDiv{
        overflow-y: auto;
        height: 450px;
    }
</style>

<body>
  <div style="width: 90%;margin-left: 5%">
    <h3><a href="${pageContext.request.contextPath}">< Home</a></h3>
    <br>
    <h2><label class="label label-primary">Create Many to Many Sale Items</label></h2>
    <form:form method="post" action="${pageContext.request.contextPath}/saleItem" commandName="saleItemForm">
      <div style="width: 50%;float: left" class="alert alert-success listDiv">
        <table class="table">
          <thead>
            <tr>
              <th colspan="1">Categories</th>
              <th colspan="1">Related products ></th>
              <th colspan="1">Select</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="cw" items="${saleItemForm.categoryWrappers}" varStatus="status">
              <tr>
                  <td>
                      <form:input cssClass="form-control" path="categoryWrappers[${status.index}].category.name"></form:input>
                    <%--<label>${saleItemForm.categoryWrappers[status.index].category.name}</label>--%>
                  </td>
                  <td>
                      <a href="${pageContext.request.contextPath}/saleItem?categoryId=${cw.category.id}">list products</a>
                  </td>
                  <td>
                    <form:checkbox  path="categoryWrappers[${status.index}].selected"></form:checkbox>
                  </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
          <div style="text-align: right">
              <input type="submit" class="btn btn-info" value="Save SaleItem">
          </div>
      </div>
      <div style="width: 45%;float: left" class="alert alert-warning listDiv">
        <table class="table">
          <thead>
            <tr>
                <th colspan="1">Product</th>
                <th colspan="1">Price</th>
                <th colspan="1">Select</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="pw" items="${saleItemForm.productWrappers}" varStatus="status">
              <tr>
                <td>
                  <%--<label>${saleItemForm.productWrappers[status.index].product.name}</label>--%>
                  <form:input path="productWrappers[${status.index}].product.name"></form:input>
                </td>
                  <td>${saleItemForm.productWrappers[status.index].product.unitPrice} $</td>
                <td>
                  <form:checkbox path="productWrappers[${status.index}].selected"></form:checkbox>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </form:form>
    <hr>
    <div style="width: 60%">
        <h2>SaleItems : Categories and related Products</h2>
        <table class="table">
          <thead>
              <tr>
                  <th>Category</th>
                  <th>Product</th>
                  <th>Price</th>
              </tr>
          </thead>
          <tbody>
            <c:forEach items="${saleItemList}" var="sli">
                <tr>
                    <td>${sli.category.name}</td>
                    <td>${sli.product.name}</td>
                    <td>${sli.product.unitPrice} $</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/productDetail?productId=${sli.product.id}">product detail ></a>
                    </td>
                </tr>
            </c:forEach>
          </tbody>
        </table>
    </div>
  </div>
</body>
</html>
