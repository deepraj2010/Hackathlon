<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h2>Offers in Acending order : </h2>
	<c:if test="${not empty searchResult}">
 
		<ul>
			<c:forEach var="listValue" items="${searchResult}">
				<li>${listValue}</li>
			</c:forEach>
		</ul>
 
	</c:if>
</body>
</html>