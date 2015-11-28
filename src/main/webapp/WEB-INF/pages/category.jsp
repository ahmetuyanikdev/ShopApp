<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories</title>
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
    <h1>${message}</h1>
    <h2>${pageContext.request.contextPath}</h2>
    <form:form method="post" action="/ShopApp/category" commandName="categoryForm">
        <table>
            <c:forEach var="w" items="${categoryForm.wrappers}" varStatus="status">
                <tr>
                    <td>
                        <c:if test="${categoryForm.wrappers[status.index].category.name!=null}">
                            <label>${categoryForm.wrappers[status.index].category.name}</label>
                        </c:if>
                        <c:if test="${categoryForm.wrappers[status.index].category.name==null}">
                            New Category :
                            <form:input path="wrappers[${status.index}].category.name"></form:input>
                        </c:if>
                    </td>
                    <td>
                        <form:checkbox path="wrappers[${status.index}].selected"></form:checkbox>
                    </td>
                </tr>
            </c:forEach>

            <tr>
                <td colspan="2"><input type="submit" value="Save Category"></td>
            </tr>

            <tfoot>
                <tr>
                    <td colspan="2"><input type="button" onclick="getAllCategory()" value="All Categories"></td>
                </tr>
            </tfoot>

        </table>
    </form:form>

    <hr>

    <div>
        <table>
            <c:forEach var="wp" items="${list}" varStatus="status" >
                <tr>
                    <td>${wp.category.name}</td>
                    <%--<td><form:radiobutton path="items[${status.index}].selected"></form:radiobutton></td>--%>
                </tr>
            </c:forEach>
        </table>
    </div>
    <table id="categoryData">
        <tbody>

        </tbody>
    </table>

</body>
</html>
