<jsp:root xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt"
	xmlns:spring="http://www.springframework.org/tags"
	xmlns:form="http://www.springframework.org/tags/form"
	xmlns:collab="http://climatecolab.org/tags/collab_1.0"
	xmlns:portlet="http://java.sun.com/portlet_2_0" version="2.0">
	<jsp:directive.include file="init.jspx" />
	Contests were created successfully.

	<table>
		<tr><th>Contest name</th><th>Contest edit link</th></tr>
		<c:forEach items="${contestEditLinks}" var="contestEditLink">
			<tr><td>${contestEditLink.key}</td><td><a href="${contestEditLink.value}">${contestEditLink.value}</a></td></tr>
		</c:forEach>
	</table>
</jsp:root>