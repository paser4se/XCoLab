<jsp:root xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions"
	xmlns:fmt="http://java.sun.com/jsp/jstl/fmt"
	xmlns:spring="http://www.springframework.org/tags"
	xmlns:form="http://www.springframework.org/tags/form"
	xmlns:collab="http://climatecolab.org/tags/collab_1.0"
	xmlns:modeling="urn:jsptagdir:/WEB-INF/tags/modeling"
	xmlns:portlet="http://java.sun.com/portlet_2_0" version="2.0">
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"><!-- --></script>
	<script type="text/javascript" src="/climatecolab-theme/js/jquery.blockUI.js?tt=1393189878000"><!-- --></script>
	<script type="text/javascript" src="//code.jquery.com/ui/1.10.1/jquery-ui.js"><!-- --></script>
	<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jcarousel/0.3.1/jquery.jcarousel-core.min.js"><!-- --></script>
    <script src="${pageContext.request.contextPath}/js/codemirror/codemirror.js"><!-- --></script>
    <script src="${pageContext.request.contextPath}/js/codemirror/javascript.js"><!-- --></script>
    <script src="${pageContext.request.contextPath}/js/codemirror/fullscreen.js"><!-- --></script>
    <script type="text/javascript" src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"><!-- --></script>
	<link rel="stylesheet" href="/climatecolab-theme/css/style_additions.css"><!-- --></link>
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"><!-- --></link>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/codemirror/codemirror.css"><!-- --></link>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/codemirror/fullscreen.css"><!-- --></link>
	<div class="breadcrumb">
		<portlet:renderURL var="modelsIndexUrl" />
		<span><a href="${modelsIndexUrl }">Models index</a></span>
		&amp;raquo;
		<span>${model.name }</span>
	</div>
	
	<h1>${model.name }</h1>
	<ul class="nav nav-tabs">
		<portlet:renderURL var="detailsUrl">
			<portlet:param name="modelId" value="${model.id }"/>
		</portlet:renderURL>
		<li class="${tab == 'details' ? 'active' : ''}"><a href='${detailsUrl }'>Details</a></li>
		<portlet:renderURL var="inputWidgetsUrl">
			<portlet:param name="modelId" value="${model.id }"/>
			<portlet:param name="tab" value="inputWidgets"/>
		</portlet:renderURL>
		<li class="${tab == 'inputWidgets' ? 'active' : ''}"><a href='${inputWidgetsUrl }'>Input widgets</a></li>
		<portlet:renderURL var="outputWidgetsUrl">
			<portlet:param name="modelId" value="${model.id }"/>
			<portlet:param name="tab" value="outputWidgets"/>
		</portlet:renderURL>
		<li class="${tab == 'outputWidgets' ? 'active' : ''}"><a href='${outputWidgetsUrl }'>Output widgets</a></li>
		<portlet:renderURL var="inputTabsUrl">
			<portlet:param name="modelId" value="${model.id }"/>
			<portlet:param name="tab" value="inputTabs"/>
		</portlet:renderURL>
		<li class="${tab == 'inputTabs' ? 'active' : ''}"><a href='${inputTabsUrl }'>Input tabs</a></li>
		<portlet:renderURL var="modelDisplayByJSONUrl">
			<portlet:param name="modelId" value="${model.id }"/>
			<portlet:param name="tab" value="modelDisplayByJSON"/>
		</portlet:renderURL>
		<li class="${tab == 'modelDisplayByJSON' ? 'active' : ''}"><a href='${modelDisplayByJSONUrl }'>Configure Model by json</a></li>
	</ul>

</jsp:root>