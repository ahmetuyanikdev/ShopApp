<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h1>${message}</h1>
    <form:form method="post" action="/ShopApp/product" commandName="productForm">
        <table>
            <tr>
                <td>Product Name</td>
                <td><form:input path="name"></form:input></td>
            </tr>

            <tr>
                <td>Product Price</td>
                <td><form:input path="unitPrice"></form:input></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Save Product">
                </td>
            </tr>
        </table>
    </form:form>
    <div>
        <tr>
            <c:forEach items="${list}" var="prd">
                    <h2>${prd.name}</h2><h2>${prd.unitPrice}</h2>
            </c:forEach>
        </tr>
    </div>
</body>
</html>
