<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
    </title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
          crossorigin="anonymous">
</head>
<body>
    <div style="width: 90%;margin-left: 5%">
    <a href="${pageContext.request.contextPath}">< Home</a>
    <h2>${message}</h2>
    <form:form method="post" action="/ShopApp/product" commandName="productForm">
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
                        <c:if test="${productForm.wrappers[status.index].product.name!=null}">
                            <label>${productForm.wrappers[status.index].product.name}</label>
                        </c:if>
                        <c:if test="${productForm.wrappers[status.index].product.name==null}">
                            New :
                            <form:input cssClass="text-input" path="wrappers[${status.index}].product.name"></form:input>
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${productForm.wrappers[status.index].product.unitPrice!=null}">
                            <label>${productForm.wrappers[status.index].product.unitPrice}</label>
                        </c:if>
                        <c:if test="${productForm.wrappers[status.index].product.unitPrice==null}">
                            <form:input cssClass="text-input" path="wrappers[${status.index}].product.unitPrice"></form:input>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>

            <tr>
                <td colspan="2">
                    <input type="submit" class="button" value="Save Product">
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
                            <td>${wp.product.unitPrice}</td>
                        </tr>
                    </c:forEach>
                </tr>
            </tbody>
        </table>
    </div>
    </div>
</body>
</html>
