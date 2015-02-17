package org.xcolab.portlets.contestmanagement.views;

import org.xcolab.interfaces.TabContext;
import org.xcolab.interfaces.TabEnum;
import org.xcolab.interfaces.TabPermissions;
import org.xcolab.interfaces.TabPermissionAlgorithm;
import org.xcolab.interfaces.TabActivityCountAlgorithm;

import javax.portlet.PortletRequest;
/**
 * Created by Thomas on 2/9/2015.
 */
public enum ContestDetailsTabs implements TabEnum{
	ADMIN("Admin", TabPermissionAlgorithm.alwaysFalseViewAndEdit, TabActivityCountAlgorithm.alwaysZero),
	DESCRIPTION("Description", TabPermissionAlgorithm.contestCreationViewAndEdit, TabActivityCountAlgorithm.alwaysZero),
	TEAM("Team", TabPermissionAlgorithm.contestCreationViewAndEdit, TabActivityCountAlgorithm.alwaysZero),
	ONTOLOGY("Ontology", TabPermissionAlgorithm.contestCreationViewAndEdit, TabActivityCountAlgorithm.alwaysZero),
	RESOURCES("Resources", TabPermissionAlgorithm.contestCreationViewAndEdit, TabActivityCountAlgorithm.alwaysZero),
	PROPOSALTEMPLATE("Proposal Template", TabPermissionAlgorithm.contestCreationViewAndEdit, TabActivityCountAlgorithm.alwaysZero),
	ADVANCED("Advanced", TabPermissionAlgorithm.alwaysFalseViewAndEdit, TabActivityCountAlgorithm.alwaysZero);

	private final String displayName;
	private final TabPermissionAlgorithm tabPermissionAlgorithm;
	private final TabActivityCountAlgorithm activitiesCountAlgorithm;

	private ContestDetailsTabs(String displayName, TabPermissionAlgorithm tabPermissionAlgorithm,
							   TabActivityCountAlgorithm activitiesCountAlgorithm) {
		this.displayName = displayName;
		this.tabPermissionAlgorithm = tabPermissionAlgorithm;
		this.activitiesCountAlgorithm = activitiesCountAlgorithm;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getName() {
		return this.name();
	}

	public boolean getIsDefault() {
		return this.ordinal() == 0;
	}

	public boolean getCanView(TabPermissions permissions, TabContext context, PortletRequest request) {
		return tabPermissionAlgorithm.canView(permissions, context, request);
	}

	public boolean getCanEdit(TabPermissions permissions, TabContext context, PortletRequest request) {
		return tabPermissionAlgorithm.canEdit(permissions, context, request);
	}

	public boolean getCanAddComment(TabPermissions permissions, TabContext context, PortletRequest request){
		return tabPermissionAlgorithm.getCanAddComment(permissions, context, request);
	}

	public int getActivityCount(TabContext context, PortletRequest request){
		return activitiesCountAlgorithm.getActivityCount(context, request);
	}

}
