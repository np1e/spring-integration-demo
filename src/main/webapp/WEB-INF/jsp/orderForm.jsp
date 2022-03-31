<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<%-- Meta Content --%>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<title>Spring Integration Demo</title>
	</head>

	<body>
		<h1>Spring Integration Demo</h1>
		<h3>Track Button Click</h3>
		<script>
			function clickButton() {
                const xhr = new XMLHttpRequest();
                xhr.onreadystatechange = function() {
                    if (this.readyState === XMLHttpRequest.DONE) {
                        console.log(`Event sent, got status` + this.status);
                    }
				}

                xhr.open('POST', '/trackmcevent', true);
                xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
                xhr.send(JSON.stringify({
					assetUrl: "https://assets.hansgrohe.com/mam/celum/celum_assets/16__acb03213_dwg.dwg",
					eventType: "WEBSITE_DOWNLOAD",
					assetName: "35878_16.jpg",
					mimeType: "DWG"
                }));
			}
		</script>
		<button onclick="clickButton()">Click</button>
		<hr>
		<h3>Track form submission</h3>
		<form:form action="${add_book_url}" method="post" modelAttribute="order">
			<form:label path="firstName">First name: </form:label> <form:input type="text" path="firstName"/>
			<form:label path="lastName">Last Name: </form:label> <form:input type="text" path="lastName"/>
			<form:label path="email">Email: </form:label> <form:input path="email"/>
			<input type="submit" value="submit"/>
		</form:form>

	</body>

</html>