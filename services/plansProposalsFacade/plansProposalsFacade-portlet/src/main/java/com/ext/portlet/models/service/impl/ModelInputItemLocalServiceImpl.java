package com.ext.portlet.models.service.impl;

import java.util.Collections;
import java.util.List;

import com.ext.portlet.models.NoSuchModelInputItemException;
import com.ext.portlet.models.model.ModelInputItem;
import com.ext.portlet.models.service.base.ModelInputItemLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import edu.mit.cci.simulation.client.MetaData;
import edu.mit.cci.simulation.client.Simulation;

/**
 * The implementation of the model input item local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ext.portlet.models.service.ModelInputItemLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ext.portlet.models.service.base.ModelInputItemLocalServiceBaseImpl
 * @see com.ext.portlet.models.service.ModelInputItemLocalServiceUtil
 */
public class ModelInputItemLocalServiceImpl
    extends ModelInputItemLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ext.portlet.models.service.ModelInputItemLocalServiceUtil} to access the model input item local service.
     */


    private static Log _log = LogFactoryUtil.getLog(ModelInputItemLocalServiceImpl.class);

    public List<ModelInputItem> getItemsForModel(Simulation sim) {
        try {
            return modelInputItemPersistence.findByModelId(sim.getId());
        } catch (SystemException e) {
            _log.error("WTF now",e);
        }
        return Collections.emptyList();

    }

    public ModelInputItem getItemForMetaData(Long modelId, MetaData md) {
        try {
            return modelInputItemPersistence.findByModelIdModelInputId(modelId, md.getId());
        } catch (NoSuchModelInputItemException e) {
            //ignore
        } catch (SystemException e) {
            _log.error("Unexpected error",e);
        }
        return null;

    }

   

    public List<ModelInputItem> getItemForGroupId(Long groupid) {
        try {
            return modelInputItemPersistence.findByModelGroupId(groupid);
        } catch (SystemException e) {
            _log.error("goddamn!",e);
        }
        return null;

    }
}
