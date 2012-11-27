package com.ext.portlet.ontology.model.impl;

import com.ext.portlet.ontology.model.FocusAreaOntologyTerm;
import com.ext.portlet.ontology.service.FocusAreaOntologyTermLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the FocusAreaOntologyTerm service. Represents a row in the &quot;ontology_FocusAreaOntologyTerm&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FocusAreaOntologyTermImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FocusAreaOntologyTermImpl
 * @see com.ext.portlet.ontology.model.FocusAreaOntologyTerm
 * @generated
 */
public abstract class FocusAreaOntologyTermBaseImpl
    extends FocusAreaOntologyTermModelImpl implements FocusAreaOntologyTerm {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a focus area ontology term model instance should use the {@link FocusAreaOntologyTerm} interface instead.
     */
    public void persist() throws SystemException {
        if (this.isNew()) {
            FocusAreaOntologyTermLocalServiceUtil.addFocusAreaOntologyTerm(this);
        } else {
            FocusAreaOntologyTermLocalServiceUtil.updateFocusAreaOntologyTerm(this);
        }
    }
}
