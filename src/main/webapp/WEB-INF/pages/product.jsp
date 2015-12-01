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
    <a href="${pageContext.request.contextPath}">< Home</a>
    <h2>${message}</h2>
    <form:form method="post" action="/ShopApp/product" modelAttribute="productForm">
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
                        <form:input cssClass="text-input" path="wrappers[${status.index}].product.name"></form:input>
                        <%--<c:if test="${productForm.wrappers[status.index].product.name!=null}">
                            <c:out value="${productForm.wrappers[status.index].product.name}"></c:out>
                        </c:if>
                        <c:if test="${productForm.wrappers[status.index].product.name==null}">
                            New :
                            <form:input cssClass="text-input" path="wrappers[${status.index}].product.name"></form:input>
                        </c:if>--%>
                    </td>
                    <td>
                        <form:input cssClass="text-input" path="wrappers[${status.index}].product.unitPrice"></form:input>
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
        <form:form method="post" modelAttribute="productForm" enctype="multipart/form-data" action="/ShopApp/product/uploadFile">
            <table class="table">
                <thead>
                    <tr>
                        <th>
                            Product Name
                        </th>
                        <th>
                            Price
                        </th>
                        <th>
                            Select for Upload
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <c:forEach var="prd" items="${productForm.wrappers}" varStatus="status" >
                            <c:if test="${prd.product.name!=null}">
                            <tr>
                                <td>
                                    <%--<form:input cssClass="text-input" path="wrappers[${status.index}].product.name" disabled="true"></form:input>--%>
                                    <c:out value="${prd.product.name}"></c:out>
                                </td>
                                <td>
                                    <%--<form:input cssClass="text-input" path="wrappers[${status.index}].product.unitPrice" disabled="true"></form:input>--%>
                                    <c:out value="${prd.product.unitPrice}"></c:out>
                                </td>
                                <td>
                                    <form:checkbox path="wrappers[${status.index}].selected"></form:checkbox>
                                </td>
                            </tr>
                            </c:if>
                        </c:forEach>
                    </tr>
                </tbody>
                <thead>
                    <tr>
                        <td colspan="2"><input type="file" name="file"></td>
                        <td><input type="submit" class="button" value="Save Files"></td>
                    </tr>
                </thead>
            </table>
        </form:form>
    </div>
    </div>
</body>
</html>
