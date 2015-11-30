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
  <a href="${pageContext.request.contextPath}">< Home</a>
  <div style="width: 60%">
      <form:form  id="newPurchaseItemForm" method="post" action="/ShopApp/productDetail/addBasket" commandName="productDetailForm">
          <table class="table">
              <tbody>
              <tr>
                  <td>Name : <form:input path="name" disabled="true"></form:input></td>
                  <td>Price : <form:input path="productPrice" disabled="true"></form:input></td>
              </tr>
              <tr>
                  <td>
                      Qty : <form:input path="quantity" onchange="calculateTaxAndTotal()"></form:input>
                  </td>
                  <td>
                      Tax : <form:input path="tax"></form:input>
                  </td>
              </tr>
              <tr>
                  <td colspan="2">
                      Total : <form:input path="total"></form:input>
                  </td>
              </tr>
              </tbody>
          </table>
      </form:form>
      <input type="button" value="Add to Basket" onclick="addToBasket()">
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
        var tax = parseFloat($('#tax').val());
        var total = parseFloat($('#total').val());
        var purchaseItem = {"productPrice":productPrice,"quantity":quantity,
                            "tax":tax,"total":total};

        $.ajax({
                    headers: {
                        Accept : "application/json"
                    },
                    url: '/ShopApp/productDetail/addBasket',
                    data: JSON.stringify(purchaseItem),
                    type: "POST"

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
