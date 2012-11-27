package com.ext.portlet.contests.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the ContestTeamMember service. Represents a row in the &quot;Contests_ContestTeamMember&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ContestTeamMemberModel
 * @see com.ext.portlet.contests.model.impl.ContestTeamMemberImpl
 * @see com.ext.portlet.contests.model.impl.ContestTeamMemberModelImpl
 * @generated
 */
public interface ContestTeamMember extends ContestTeamMemberModel, PersistedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this interface directly. Add methods to {@link com.ext.portlet.contests.model.impl.ContestTeamMemberImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */
    public void store()
        throws com.liferay.portal.kernel.exception.SystemException;

    public void delete()
        throws com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.portal.model.User getUser()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.ext.portlet.contests.model.Contest getContest()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;
}
