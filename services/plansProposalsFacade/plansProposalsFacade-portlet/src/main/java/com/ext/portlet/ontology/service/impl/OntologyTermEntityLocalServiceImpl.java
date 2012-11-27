package com.ext.portlet.ontology.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ext.portlet.ontology.model.OntologyTermEntity;
import com.ext.portlet.ontology.service.base.OntologyTermEntityLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ClassNameLocalServiceUtil;

/**
 * The implementation of the ontology term entity local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ext.portlet.ontology.service.OntologyTermEntityLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ext.portlet.ontology.service.base.OntologyTermEntityLocalServiceBaseImpl
 * @see com.ext.portlet.ontology.service.OntologyTermEntityLocalServiceUtil
 */
public class OntologyTermEntityLocalServiceImpl
    extends OntologyTermEntityLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ext.portlet.ontology.service.OntologyTermEntityLocalServiceUtil} to access the ontology term entity local service.
     */
    
    public List<Long> findTagedIdsForClass(Long termId, Class clasz) throws SystemException {
        List<Long> ret = new ArrayList<Long>();
        
        for (OntologyTermEntity ote: ontologyTermEntityPersistence.findByTermIdClassNameId(termId, ClassNameLocalServiceUtil.getClassNameId(clasz))) {
            ret.add(ote.getClassPK());
        }
        
        return ret;
    }
}
