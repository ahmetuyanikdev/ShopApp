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
            url : '${pageContext.request.contextPath}/category/getAll',
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
    <h3><a href="${pageContext.request.contextPath}">< Home</a></h3>
    <br>
    <h2><label class="label label-primary">Add Categories</label></h2>
    <form:form method="post" action="${pageContext.request.contextPath}/category" commandName="categoryForm">

            <table class="table">
                <thead>
                <tr>
                    <th>
                        Category Name
                    </th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="w" items="${categoryForm.wrappers}" varStatus="status">
                    <tr>
                        <td>
                            <c:if test="${categoryForm.wrappers[status.index].category.name==null}">
                              <div class="col-md-1" style="float: left"> New : </div> <div style="float: left" class="col-md-9"><form:input cssClass="form-control" path="wrappers[${status.index}].category.name"></form:input></div>
                            </c:if>
                            <c:if test="${categoryForm.wrappers[status.index].category.name!=null}">
                              <div class="col-md-1" style="float:left"> Edit :</div> <div style="float: left" class="col-md-9"><form:input cssClass="form-control" path="wrappers[${status.index}].category.name"></form:input></div>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>

                <tfoot>
                <tr>
                    <td colspan="2"><input type="submit" class="btn btn-info" value="Save Category"></td>
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
                    Categories
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
