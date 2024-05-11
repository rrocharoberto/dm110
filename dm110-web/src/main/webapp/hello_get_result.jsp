<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello Result</title>
</head>
<body>
	<h1>Hello from Servlet!</h1>

	<c:if test="${(empty name) and (empty previousName)}">
		<h2>No name to say hi</h2>
	</c:if>
	<c:if test="${not empty previousName}">
		<h2>Hi using previous name ${previousName}</h2>
	</c:if>
	<c:if test="${not empty name}">
		<h2>Hi ${name}</h2>
	</c:if>
	<!--<h2>Current date: ${currentDate}</h2>-->

	<a href="/dm110-web/form.html">Click here to go back</a>
</body>
</html>