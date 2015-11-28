<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<style>

</style>
<script  type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js">
</script>
<script>
	function crunchifyAjax() {
		console.log('testing ajax');
		$.ajax({
			url : '/ShopApp/ajaxtest',
			success : function(data) {
				$('#result').html(data);
			}
		});
	}
</script>

<body>
	<h1>${message}</h1>

	<br>
	<br>
	<div id="result"></div>
	<button onclick="crunchifyAjax()">TEst</button>
	<form:form method="post" commandName="productForm"  action="/ShopApp/product">
		<table>
			<tr>
				<td>
					<form:input path="name"></form:input>
				</td>
				<td>
					<input type="submit" value="Submit">
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>