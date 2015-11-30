<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories
    </title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<script  type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js">
</script>

<script>
    function getAllCategory() {
        $.ajax({
            url : '/ShopApp/category/getAll',
            success : function(data) {
                $.each(data, function(i, f) {
                    var tblRow = "<tr>" + "<td>" + data[i].name + "</td>" +"</tr>";
                    $('#categoryData tbody').append(tblRow);
                });
            }
        });
    }
</script>
<body>
    <div style="width: 90%;margin-left: 5%;">
    <a href="${pageContext.request.contextPath}">< Home</a>
    <h1>${message}</h1>
    <form:form method="post" action="/ShopApp/category" commandName="categoryForm">

            <table class="table">
                <thead>
                <tr>
                    <th>
                        Category Name
                    </th>
                    <th>
                        Select
                    </th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="w" items="${categoryForm.wrappers}" varStatus="status">
                    <tr>
                        <td>
                            <form:input cssClass="text-input" path="wrappers[${status.index}].category.name"></form:input>
                        </td>
                        <td>
                            <c:if test="${categoryForm.wrappers[status.index].category.name!=null}">
                                <form:checkbox path="wrappers[${status.index}].selected"></form:checkbox>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>

                <tfoot>
                <tr>
                    <td colspan="2"><input type="submit" class="button" value="Save Category"></td>
                </tr>

               <%-- <tr>
                    <td colspan="2"><input type="button" onclick="getAllCategory()" value="All Categories"></td>
                </tr>--%>
                </tfoot>
            </table>
    </form:form>

    <div>
        <table class="table">
            <thead>
                <th>
                    Category Name
                </th>
            </thead>
            <tbody>
                <c:forEach var="wp" items="${list}" varStatus="status" >
                    <tr>
                        <td>${wp.category.name}</td>
                    </tr>
                </c:forEach>
            </tbody>

        </table>
    </div>
    <table id="categoryData">
        <tbody>

        </tbody>
    </table>
    </div>
</body>
</html>
