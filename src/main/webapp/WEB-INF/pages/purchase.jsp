<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<script  type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js">
</script>

<body>
    <div style="width: 90%;margin-left: 5%">
    <h3><a href="${pageContext.request.contextPath}">< Home</a></h3>
    <br>
    <h2><label class="label label-primary">Your Shopping Card</label></h2>
    <form:form method="get" id="purchaseForm" action="${pageContext.request.contextPath}/purchases/delete" >
        <table class="table table-bordered" id="shoppingData">
            <thead>
                <tr>
                    <th>Product Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Tax</th>
                    <th>Total</th>
                    <th>Delete Item</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${purchaseItems}" var="pi">
                    <tr>
                        <td><c:out value="${pi.name}"></c:out></td>
                        <td><c:out value="${pi.quantity}"></c:out></td>
                        <td><c:out value="${pi.productPrice}"></c:out> $</td>
                        <td><c:out value="${pi.tax}"></c:out> $</td>
                        <td><c:out value="${pi.total}"></c:out> $</td>
                        <td>
                            <input type="button" value="delete" class="btn btn-danger" onclick="deletePurchaseItem('${pi.id}')">
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="3"></td>
                    <td colspan="1">
                        <label class="label label-success">Tax Total : ${taxTotal} $</label>
                    </td>
                    <td colspan="1">
                        <label class="label label-success">Grand Total : ${grandTotal} $</label>
                    </td>
                    <td colspan="1"><input class="btn btn-info" value="Checkout"></td>
                </tr>
            </tfoot>
        </table>
    </form:form>

  </div>
</body>

<script>
    function deletePurchaseItem(id){
        var form = $('#purchaseForm');
        form.append("<input type='hidden' name='purchaseItemId' value='"+id+"' />");
        form.submit();
    }
</script>
</html>
