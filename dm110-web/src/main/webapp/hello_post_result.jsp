<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Hello Result</title>
</head>
<body>
	<h1>Hello from Servlet!</h1>

	<c:if test="${not empty nameSaved}">
		<h2>Hi ${nameSaved}. Your name is saved for next calls.</h2>
	</c:if>
	<a href="/dm110-web/form_servlet.html">Click here to go to form.</a>
</body>
</html>