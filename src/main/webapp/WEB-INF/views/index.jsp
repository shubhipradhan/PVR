<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false"%>
<%@ page isELIgnored="false" %>
<html>
<head>
	<title>Show Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Show
</h1>
<h2><a href="login">LOGIN</a></h2>
<c:url var="addAction" value="/show/add" ></c:url>




<form:form action="${addAction}" commandName="show">
<table>
	<c:if test="${!empty show.movie}">
	<tr>
		<td>
			<form:label path="showId">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="showId" readonly="true" size="8"  disabled="true" />
			<form:hidden path="showId" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="movie">
				<spring:message text="Movie"/>
			</form:label>
		</td>
		<td>
			<form:input path="movie" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="area">
				<spring:message text="Area"/>
			</form:label>
		</td>
		<td>
			<form:input path="area" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty show.movie}">
				<input type="submit"
					value="<spring:message text="Edit Person"/>" />
			</c:if>
			<c:if test="${empty show.movie}">
				<input type="submit"
					value="<spring:message text="Add Person"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Shows List</h3>
<c:if test="${!empty listShows}">
	<table class="tg">
	<tr>
		<th width="80">Show ID</th>
		<th width="120">Movie</th>
		<th width="120">Area</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listShows}" var="show">
		<tr>
			<td>${show.showId}</td>
			<td>${show.movie}</td>
			<td>${show.area}</td>
			<td><a href="<c:url value='/edit/${show.showId}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${show.showId}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>