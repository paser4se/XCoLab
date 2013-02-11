<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/portlet/wiki/init.jsp" %>

<%
boolean followRedirect = ParamUtil.getBoolean(request, "followRedirect", true);

WikiNode node = (WikiNode)request.getAttribute(WebKeys.WIKI_NODE);
WikiPage wikiPage = (WikiPage)request.getAttribute(WebKeys.WIKI_PAGE);

WikiPage originalPage = null;
WikiPage redirectPage = wikiPage.getRedirectPage();

if (followRedirect && (redirectPage != null)) {
	originalPage = wikiPage;
	wikiPage = redirectPage;
}

String title = wikiPage.getTitle();

String parentTitle = StringPool.BLANK;

if (wikiPage != null) {
	parentTitle = wikiPage.getParentTitle();
}

List childPages = wikiPage.getChildPages();

String[] attachments = new String[0];

if (wikiPage != null) {
	attachments = wikiPage.getAttachmentsFiles();
}

boolean preview = false;
boolean print = ParamUtil.getString(request, "viewMode").equals(Constants.PRINT);

PortletURL viewPageURL = renderResponse.createRenderURL();

viewPageURL.setParameter("struts_action", "/wiki/view");
viewPageURL.setParameter("nodeName", node.getName());
viewPageURL.setParameter("title", title);

PortletURL viewParentPageURL = null;

if (Validator.isNotNull(parentTitle)) {
	viewParentPageURL = PortletURLUtil.clone(viewPageURL, renderResponse);

	viewParentPageURL.setParameter("title", parentTitle);

	parentTitle = StringUtil.shorten(parentTitle, 20);
}

PortletURL addPageURL = renderResponse.createRenderURL();

addPageURL.setParameter("struts_action", "/wiki/edit_page");
addPageURL.setParameter("redirect", currentURL);
addPageURL.setParameter("nodeId", String.valueOf(node.getNodeId()));
addPageURL.setParameter("title", StringPool.BLANK);
addPageURL.setParameter("editTitle", "1");

if (wikiPage != null) {
	addPageURL.setParameter("parentTitle", wikiPage.getTitle());
}

PortletURL editPageURL = renderResponse.createRenderURL();

editPageURL.setParameter("struts_action", "/wiki/edit_page");
editPageURL.setParameter("redirect", currentURL);
editPageURL.setParameter("nodeId", String.valueOf(node.getNodeId()));
editPageURL.setParameter("title", title);

PortletURL printPageURL = PortletURLUtil.clone(viewPageURL, renderResponse);

printPageURL.setWindowState(LiferayWindowState.POP_UP);

printPageURL.setParameter("viewMode", Constants.PRINT);

PortletURL categorizedPagesURL = renderResponse.createRenderURL();

categorizedPagesURL.setParameter("struts_action", "/wiki/view_categorized_pages");
categorizedPagesURL.setParameter("nodeId", String.valueOf(node.getNodeId()));

PortletURL taggedPagesURL = renderResponse.createRenderURL();

taggedPagesURL.setParameter("struts_action", "/wiki/view_tagged_pages");
taggedPagesURL.setParameter("nodeId", String.valueOf(node.getNodeId()));

PortletURL viewAttachmentsURL = PortletURLUtil.clone(viewPageURL, renderResponse);

viewAttachmentsURL.setParameter("struts_action", "/wiki/view_page_attachments");

AssetEntryServiceUtil.incrementViewCounter(WikiPage.class.getName(), wikiPage.getResourcePrimKey());

if (Validator.isNotNull(ParamUtil.getString(request, "title"))) {
	AssetUtil.addLayoutTags(request, AssetTagLocalServiceUtil.getTags(WikiPage.class.getName(), wikiPage.getResourcePrimKey()));
}

if (wikiPage != null) {
	AssetEntry layoutAssetEntry = AssetEntryLocalServiceUtil.getEntry(WikiPage.class.getName(), wikiPage.getResourcePrimKey());

	request.setAttribute(WebKeys.LAYOUT_ASSET_ENTRY, layoutAssetEntry);
}
%>

<c:choose>
	<c:when test="<%= print %>">
		<div class="popup-print">
			<liferay-ui:icon
				image="print"
				label="<%= true %>"
				url="javascript:print();"
			/>
		</div>

		<aui:script>
			print();
		</aui:script>
	</c:when>
	<c:otherwise>
		<aui:script>
			function <portlet:namespace />printPage() {
				window.open('<%= printPageURL %>', '', "directories=0,height=480,left=80,location=1,menubar=1,resizable=1,scrollbars=yes,status=0,toolbar=0,top=180,width=640");
			}
		</aui:script>
	</c:otherwise>
</c:choose>

<c:if test="<%= themeDisplay.isSignedIn() && WikiPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_NODE) %>">
 <liferay-util:include page="/html/portlet/wiki/top_links.jsp" />
</c:if>
<liferay-ui:header
	localizeTitle="<%= false %>"
	title="<%= title %>"
/>
    <div id="bread">
        <div style="display: inline;">
        <a href="/web/guest/about">About </a>
        
    <%

		List<WikiPage> parentPages = wikiPage.getParentPages();
        viewParentPageURL = PortletURLUtil.clone(viewPageURL, renderResponse);

        for (int i = 0; i < parentPages.size(); i++) {
            WikiPage curParentPage = (WikiPage)parentPages.get(i);

            if (curParentPage.getTitle().equals("Resources")) {
    %>
                <img width="8" height="8" alt="" src="/climatecolab-theme/images/arrow.gif">
                <a href="/web/guest/aboutresources"><%= curParentPage.getTitle() %></a>
    <%
            } else if (curParentPage.getTitle().equals("People")){
    %>
                <img width="8" height="8" alt="" src="/climatecolab-theme/images/arrow.gif">
                <a href="/web/guest/people"><%= curParentPage.getTitle() %></a>
    <%            
            } else if (curParentPage.getTitle().equals("Sponsors and Collaborators")){
    %>
                <img width="8" height="8" alt="" src="/climatecolab-theme/images/arrow.gif">
                <a href="/web/guest/sponsors"><%= curParentPage.getTitle() %></a>
    <%                        
            } else {
                viewParentPageURL.setParameter("title", curParentPage.getTitle());
    %>
                <img width="8" height="8" alt="" src="/climatecolab-theme/images/arrow.gif">
                <a href="<%= viewParentPageURL %>"><%= curParentPage.getTitle() %></a>

    <% 
            
            }
        }
        %>

        <img width="8" height="8" alt="" src="/climatecolab-theme/images/arrow.gif" />
    <a href="<%= viewPageURL %>">
    <%= title %>
    </a>
    </div>
<c:if test="<%= !print %>">
	<div class="page-actions top-actions">
		<c:if test="<%= WikiPagePermission.contains(permissionChecker, wikiPage, ActionKeys.UPDATE) %>">
			<c:if test="<%= followRedirect || (redirectPage == null) %>">
				<liferay-ui:icon
					image="edit"
					label="<%= true %>"
					url="<%= editPageURL.toString() %>"
				/>
			</c:if>

		<%
		PortletURL viewPageDetailsURL = PortletURLUtil.clone(viewPageURL, renderResponse);

		viewPageDetailsURL.setParameter("struts_action", "/wiki/view_page_details");
		viewPageDetailsURL.setParameter("redirect", currentURL);
		%>

		<liferay-ui:icon
			image="history"
			label="<%= true %>"
			message="details"
			method="get"
			url="<%= viewPageDetailsURL.toString() %>"
		/>

		<liferay-ui:icon
			image="print"
			label="<%= true %>"
			url='<%= "javascript:" + renderResponse.getNamespace() + "printPage();" %>'
		/>
		</c:if>
	</div>
</c:if>

<c:if test="<%= originalPage != null %>">

	<%
	PortletURL originalViewPageURL = renderResponse.createRenderURL();

	originalViewPageURL.setParameter("struts_action", "/wiki/view");
	originalViewPageURL.setParameter("nodeName", node.getName());
	originalViewPageURL.setParameter("title", originalPage.getTitle());
	originalViewPageURL.setParameter("followRedirect", "false");
	%>

	<div class="page-redirect" onClick="location.href = '<%= originalViewPageURL.toString() %>';">
		(<%= LanguageUtil.format(pageContext, "redirected-from-x", originalPage.getTitle()) %>)
	</div>
</c:if>

<c:if test="<%= !wikiPage.isHead() %>">
	<div class="page-old-version">
		(<liferay-ui:message key="you-are-viewing-an-archived-version-of-this-page" /> (<%= wikiPage.getVersion() %>), <aui:a href="<%= viewPageURL.toString() %>" label="go-to-the-latest-version" />)
	</div>
</c:if>

<div class="page-categorization">
	<div class="page-categories">
		<liferay-ui:asset-categories-summary
			className="<%= WikiPage.class.getName() %>"
			classPK="<%= wikiPage.getResourcePrimKey() %>"
			portletURL="<%= PortletURLUtil.clone(categorizedPagesURL, renderResponse) %>"
		/>
	</div>

	<div class="page-tags">
		<liferay-ui:asset-tags-summary
			className="<%= WikiPage.class.getName() %>"
			classPK="<%= wikiPage.getResourcePrimKey() %>"
			message="tags"
			portletURL="<%= PortletURLUtil.clone(taggedPagesURL, renderResponse) %>"
		/>
	</div>
</div>

<div>
	<%@ include file="/html/portlet/wiki/view_page_content.jspf" %>
</div>

<liferay-ui:custom-attributes-available className="<%= WikiPage.class.getName() %>">
	<liferay-ui:custom-attribute-list
		className="<%= WikiPage.class.getName() %>"
		classPK="<%= (wikiPage != null) ? wikiPage.getPrimaryKey() : 0 %>"
		editable="<%= false %>"
		label="<%= true %>"
	/>
</liferay-ui:custom-attributes-available>

<c:if test="<%= (wikiPage != null) && Validator.isNotNull(formattedContent) && (followRedirect || (redirectPage == null)) %>">
	<c:if test="<%= !childPages.isEmpty() %>">
		<div class="child-pages">
			<h2><liferay-ui:message key="children-pages" /></h2>

			<ul>

				<%
				PortletURL curPageURL = PortletURLUtil.clone(viewPageURL, renderResponse);

				for (int i = 0; i < childPages.size(); i++) {
					WikiPage curPage = (WikiPage)childPages.get(i);

					curPageURL.setParameter("title", curPage.getTitle());
				%>

					<c:if test="<%= Validator.isNull(curPage.getRedirectTitle()) %>">
						<li>
							<aui:a href="<%= curPageURL.toString() %>"><%= curPage.getTitle() %></aui:a>
						</li>
					</c:if>

				<%
				}
				%>

			</ul>
		</div>
	</c:if>

	<div class="page-actions">
		<div class="article-actions">
			<c:if test="<%= WikiNodePermission.contains(permissionChecker, node, ActionKeys.ADD_PAGE) %>">
				<liferay-ui:icon
					image="add_article"
					label="<%= true %>"
					message="add-child-page"
					method="get"
					url="<%= addPageURL.toString() %>"
				/>,
			</c:if>

			<liferay-ui:icon
				image="clip"
				label="<%= true %>"
				message='<%= attachments.length + " " + LanguageUtil.get(pageContext, (attachments.length == 1) ? "attachment" : "attachments") %>' method="get" url="<%= viewAttachmentsURL.toString() %>"
			/>
		</div>

		<div class="stats">

			<%
			AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(WikiPage.class.getName(), wikiPage.getResourcePrimKey());
			%>

			<c:choose>
				<c:when test="<%= assetEntry.getViewCount() == 1 %>">
					<%= assetEntry.getViewCount() %> <liferay-ui:message key="view" />
				</c:when>
				<c:when test="<%= assetEntry.getViewCount() > 1 %>">
					<%= assetEntry.getViewCount() %> <liferay-ui:message key="views" />
				</c:when>
			</c:choose>
		</div>
	</div>

	<c:if test="<%= enableRelatedAssets %>">
		<div class="entry-links">
			<liferay-ui:asset-links
				assetEntryId="<%= assetEntry.getEntryId() %>"
			/>
		</div>
	</c:if>

	<c:if test="<%= enablePageRatings %>">
		<div class="page-ratings">
			<liferay-ui:ratings
				className="<%= WikiPage.class.getName() %>"
				classPK="<%= wikiPage.getResourcePrimKey() %>"
			/>
		</div>
	</c:if>

	<c:if test="<%= enableComments %>">
		<liferay-ui:panel-container extended="<%= false %>" id="wikiCommentsPanelContainer" persistState="<%= true %>">
			<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="wikiCommentsPanel" persistState="<%= true %>" title="comments">
				<portlet:actionURL var="discussionURL">
					<portlet:param name="struts_action" value="/wiki/edit_page_discussion" />
				</portlet:actionURL>

				<liferay-ui:discussion
					className="<%= WikiPage.class.getName() %>"
					classPK="<%= wikiPage.getResourcePrimKey() %>"
					formAction="<%= discussionURL %>"
					formName="fm2"
					ratingsEnabled="<%= enableCommentRatings %>"
					redirect="<%= currentURL %>"
					subject="<%= wikiPage.getTitle() %>"
					userId="<%= wikiPage.getUserId() %>"
				/>
			</liferay-ui:panel>
		</liferay-ui:panel-container>
	</c:if>
</c:if>

<aui:script use="aui-base">
	var toc = A.one('#p_p_id<portlet:namespace /> .toc');

	if (toc) {
		var index = toc.one('.toc-index');
		var trigger = toc.one('a.toc-trigger');

		trigger.on(
			'click',
			function(event) {
				index.toggle();
			}
		);
	}
</aui:script>
