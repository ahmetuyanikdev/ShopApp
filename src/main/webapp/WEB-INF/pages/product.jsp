<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
    </title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
    <div style="width: 90%;margin-left: 5%">
    <h3><a href="${pageContext.request.contextPath}">< Home</a></h3>
    <br>
    <h2><label class="label label-primary">Add Products</label></h2>
    <form:form method="post" action="${pageContext.request.contextPath}/product" modelAttribute="productForm">
        <table class="table">
            <thead>
                <tr>
                    <th>
                        Product Name
                    </th>
                    <th>
                        Price
                    </th>
                </tr>
            </thead>
            <tbody>

            </tbody>

            <c:forEach var="w" items="${productForm.wrappers}" varStatus="status">
                <tr>
                    <td>
                        <c:if test="${productForm.wrappers[status.index].product.name==null}">
                           <div class="col-md-2" style="float: left">
                               New :
                           </div>
                            <div class="col-md-9" style="float: left">
                                <form:input cssClass="form-control" path="wrappers[${status.index}].product.name"></form:input>
                            </div>
                        </c:if>
                        <c:if test="${productForm.wrappers[status.index].product.name!=null}">
                            <div class="col-md-2" style="float: left">
                                Edit :
                            </div>
                            <div class="col-md-9" style="float: left">
                                <form:input cssClass="form-control" path="wrappers[${status.index}].product.name"></form:input>
                            </div>
                        </c:if>
                    </td>
                    <td>
                        <form:input cssClass="form-control" path="wrappers[${status.index}].product.unitPrice"></form:input>
                    </td>

                </tr>
            </c:forEach>

            <tr>
                <td colspan="2">
                    <input type="submit" class="btn btn-info" value="Save Product">
                </td>
            </tr>
        </table>
    </form:form>
    <div>
        <table class="table">
            <thead>
                <tr>
                    <th>
                        Product Name
                    </th>
                    <th>
                        Price
                    </th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <c:forEach var="wp" items="${list}" varStatus="status" >
                        <tr>
                            <td>${wp.product.name}</td>
                            <td>${wp.product.unitPrice} $</td>
                        </tr>
                    </c:forEach>
                </tr>
            </tbody>
        </table>
    </div>
    </div>
</body>
</html>
