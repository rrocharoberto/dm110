<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Hello Result</title>
</head>
<body>
	<h1>Hello from Servlet!</h1>

	<c:if test="${(empty name) and (empty previousName)}">
		<h2>No name nor previousName.</h2>
	</c:if>
	<c:if test="${not empty previousName}">
		<h2>Previous name: ${previousName}</h2>
	</c:if>
	<c:if test="${not empty name}">
		<h2>Current name: ${name}</h2>
	</c:if>
	<h2>Greetings message: ${greetings}</h2>
	<h3>Current date: ${currentDate}</h3>

	<a href="/dm110-web/form_servlet.html">Click here to go back</a>
</body>
</html>