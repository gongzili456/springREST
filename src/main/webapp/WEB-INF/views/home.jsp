<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1></h1>

	<P>The time on the server is ${serverTime}.</P>
	<input type="button" value="submit" onclick="a()">


	<script src="resources/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
		function a() {
			var p = {
				name : 'sansan',
				age : 13
			};
			$.ajax({
				type : 'POST',
				url : 'users',
				dataType : 'JSON',
				contentType : 'application/json',
				data : JSON.stringify(p),
				success : function(data) {
					console.log(data);
				}
			});
		}
	</script>

</body>
</html>
