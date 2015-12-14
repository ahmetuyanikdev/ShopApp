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
  <h2><label class="label label-primary">Product Detail</label></h2>
  <div style="width: 70%;float: left" class="alert alert-success">
      <form:form  id="newPurchaseItemForm" method="post" action="${pageContext.request.contextPath}/productDetail" commandName="productDetailForm">
          <table class="table">
              <tbody>
              <tr>
                  <td>Name : <form:input  path="name" disabled="true"></form:input></td>
                  <td>Price : <form:input path="productPrice" disabled="true"></form:input> $</td>
              </tr>
              <tr>
                  <td>
                     Quantity <div class="col-md-10" style="float: right"><form:input cssClass="form-control" path="quantity" ></form:input></div>
                  </td>
                  <%--<td>
                     Tax <div class="col-md-10" style="float: right"><form:input path="tax"></form:input>$</div>
                  </td>--%>
              </tr>
              <%--<tr>
                  <td>
                     Total <div class="col-md-10" style="float: right"><form:input  path="total"></form:input>$</div>
                  </td>
                  <td>

                  </td>
              </tr>--%>
              </tbody>
          </table>
      </form:form>

      <input type="button" class="btn btn-info" value="Add to Basket" onclick="addToBasket()">
  </div>
  <div style="width: 30%;float: left">

  </div>

  <div>
      <br>
      <table class="table table-bordered" id="purchaseItemData">
          <thead>
            <tr>
                <th>Name</th>
                <th>Quantity</th>
                <th>Product Price</th>
            </tr>
          </thead>
          <tbody>
              <c:forEach items="${purchaseItemList}" var="pit">
                <tr>
                    <td><c:out value="${pit.name}"></c:out></td>
                    <td><c:out value="${pit.quantity}"></c:out></td>
                    <td><c:out value="${pit.productPrice}"></c:out> $</td>
                </tr>
              </c:forEach>
          </tbody>
      </table>
  </div>

</div>
</body>
<script>

    function calculateTaxAndTotal(){
        var quantity = parseInt($('#quantity').val());
        var productPrice = parseFloat($('#productPrice').val());
        var tax = quantity * productPrice * (18/100);
        var total = quantity * productPrice + tax;
        $('#tax').val(tax);
        $('#total').val(total);

    }
    function addToBasket(){
        var quantity = parseInt($('#quantity').val());
        var productPrice = parseFloat($('#productPrice').val());
        var purchaseItem = {"productPrice":productPrice,"quantity":quantity,
                            "tax":null,"total":null};
        $.ajax({
                contentType: "application/json",
                url: '/ShopApp/productDetail/addToBasket',
                data: JSON.stringify(purchaseItem),
                type: "POST",
                    success:function(data){
                        $('#purchaseItemData tbody').empty();
                        $.each(data, function(i, f) {

                            var tblRow = "<tr>" + "<td>" + data[i].name + "</td>" +
                                                            "<td>" + data[i].quantity + "</td>" +
                                                            "<td>" + data[i].productPrice + " $</td>" +
                                                            "</tr>";

                            $('#purchaseItemData tbody').append(tblRow);
                        });
                    }
                }
        );
    }

    $(document).ready(function() {
            $('#newPurchaseItemForm').submit(function(event){
                var quantity = $('#quantity');
                var name = $('#name');
                var productPrice = $('#productPrice');
            });

        });

</script>
</html>
