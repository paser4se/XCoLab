<jsp:root xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:modeling="urn:jsptagdir:/WEB-INF/tags/modeling"
	version="2.0">

	<jsp:directive.include file="./init_proposal_tab.jspx" />

	<jsp:directive.include file="./proposalDetails/header.jspx" />

	<div id="content">
		<modeling:simulationView scenarioId="${proposal.scenarioId }" modelId="${proposal.modelId }" />
	</div>
		<div class="clear"><!--  --></div>
		<br />
		<br />
	
		<c:if test="${proposal.modelId ge 10 and proposal.modelId le 13 }">
			Click on the link to learn more about the <a href='/web/guest/resources/-/wiki/Main/MIT+Composite+Model'>MIT Composite Model</a>
	</c:if>

</jsp:root>