package com.ext.portlet.ontology.service.persistence;

import com.ext.portlet.ontology.model.OntologyTerm;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the ontology term service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OntologyTermPersistenceImpl
 * @see OntologyTermUtil
 * @generated
 */
public interface OntologyTermPersistence extends BasePersistence<OntologyTerm> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link OntologyTermUtil} to access the ontology term persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the ontology term in the entity cache if it is enabled.
    *
    * @param ontologyTerm the ontology term
    */
    public void cacheResult(
        com.ext.portlet.ontology.model.OntologyTerm ontologyTerm);

    /**
    * Caches the ontology terms in the entity cache if it is enabled.
    *
    * @param ontologyTerms the ontology terms
    */
    public void cacheResult(
        java.util.List<com.ext.portlet.ontology.model.OntologyTerm> ontologyTerms);

    /**
    * Creates a new ontology term with the primary key. Does not add the ontology term to the database.
    *
    * @param id the primary key for the new ontology term
    * @return the new ontology term
    */
    public com.ext.portlet.ontology.model.OntologyTerm create(java.lang.Long id);

    /**
    * Removes the ontology term with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the ontology term
    * @return the ontology term that was removed
    * @throws com.ext.portlet.ontology.NoSuchOntologyTermException if a ontology term with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.ontology.model.OntologyTerm remove(java.lang.Long id)
        throws com.ext.portlet.ontology.NoSuchOntologyTermException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.ext.portlet.ontology.model.OntologyTerm updateImpl(
        com.ext.portlet.ontology.model.OntologyTerm ontologyTerm, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the ontology term with the primary key or throws a {@link com.ext.portlet.ontology.NoSuchOntologyTermException} if it could not be found.
    *
    * @param id the primary key of the ontology term
    * @return the ontology term
    * @throws com.ext.portlet.ontology.NoSuchOntologyTermException if a ontology term with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.ontology.model.OntologyTerm findByPrimaryKey(
        java.lang.Long id)
        throws com.ext.portlet.ontology.NoSuchOntologyTermException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the ontology term with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the ontology term
    * @return the ontology term, or <code>null</code> if a ontology term with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.ontology.model.OntologyTerm fetchByPrimaryKey(
        java.lang.Long id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the ontology terms where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @return the matching ontology terms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.ontology.model.OntologyTerm> findByParentId(
        java.lang.Long parentId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the ontology terms where parentId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param parentId the parent ID
    * @param start the lower bound of the range of ontology terms
    * @param end the upper bound of the range of ontology terms (not inclusive)
    * @return the range of matching ontology terms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.ontology.model.OntologyTerm> findByParentId(
        java.lang.Long parentId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the ontology terms where parentId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param parentId the parent ID
    * @param start the lower bound of the range of ontology terms
    * @param end the upper bound of the range of ontology terms (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching ontology terms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.ontology.model.OntologyTerm> findByParentId(
        java.lang.Long parentId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first ontology term in the ordered set where parentId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching ontology term
    * @throws com.ext.portlet.ontology.NoSuchOntologyTermException if a matching ontology term could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.ontology.model.OntologyTerm findByParentId_First(
        java.lang.Long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.ontology.NoSuchOntologyTermException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last ontology term in the ordered set where parentId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching ontology term
    * @throws com.ext.portlet.ontology.NoSuchOntologyTermException if a matching ontology term could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.ontology.model.OntologyTerm findByParentId_Last(
        java.lang.Long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.ontology.NoSuchOntologyTermException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the ontology terms before and after the current ontology term in the ordered set where parentId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param id the primary key of the current ontology term
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next ontology term
    * @throws com.ext.portlet.ontology.NoSuchOntologyTermException if a ontology term with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.ontology.model.OntologyTerm[] findByParentId_PrevAndNext(
        java.lang.Long id, java.lang.Long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.ontology.NoSuchOntologyTermException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the ontology terms where parentId = &#63; and ontologySpaceId = &#63;.
    *
    * @param parentId the parent ID
    * @param ontologySpaceId the ontology space ID
    * @return the matching ontology terms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.ontology.model.OntologyTerm> findByParentIdSpaceId(
        java.lang.Long parentId, java.lang.Long ontologySpaceId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the ontology terms where parentId = &#63; and ontologySpaceId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param parentId the parent ID
    * @param ontologySpaceId the ontology space ID
    * @param start the lower bound of the range of ontology terms
    * @param end the upper bound of the range of ontology terms (not inclusive)
    * @return the range of matching ontology terms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.ontology.model.OntologyTerm> findByParentIdSpaceId(
        java.lang.Long parentId, java.lang.Long ontologySpaceId, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the ontology terms where parentId = &#63; and ontologySpaceId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param parentId the parent ID
    * @param ontologySpaceId the ontology space ID
    * @param start the lower bound of the range of ontology terms
    * @param end the upper bound of the range of ontology terms (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching ontology terms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.ontology.model.OntologyTerm> findByParentIdSpaceId(
        java.lang.Long parentId, java.lang.Long ontologySpaceId, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first ontology term in the ordered set where parentId = &#63; and ontologySpaceId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param parentId the parent ID
    * @param ontologySpaceId the ontology space ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching ontology term
    * @throws com.ext.portlet.ontology.NoSuchOntologyTermException if a matching ontology term could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.ontology.model.OntologyTerm findByParentIdSpaceId_First(
        java.lang.Long parentId, java.lang.Long ontologySpaceId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.ontology.NoSuchOntologyTermException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last ontology term in the ordered set where parentId = &#63; and ontologySpaceId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param parentId the parent ID
    * @param ontologySpaceId the ontology space ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching ontology term
    * @throws com.ext.portlet.ontology.NoSuchOntologyTermException if a matching ontology term could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.ontology.model.OntologyTerm findByParentIdSpaceId_Last(
        java.lang.Long parentId, java.lang.Long ontologySpaceId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.ontology.NoSuchOntologyTermException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the ontology terms before and after the current ontology term in the ordered set where parentId = &#63; and ontologySpaceId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param id the primary key of the current ontology term
    * @param parentId the parent ID
    * @param ontologySpaceId the ontology space ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next ontology term
    * @throws com.ext.portlet.ontology.NoSuchOntologyTermException if a ontology term with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.ontology.model.OntologyTerm[] findByParentIdSpaceId_PrevAndNext(
        java.lang.Long id, java.lang.Long parentId,
        java.lang.Long ontologySpaceId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.ontology.NoSuchOntologyTermException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the ontology terms where ontologySpaceId = &#63;.
    *
    * @param ontologySpaceId the ontology space ID
    * @return the matching ontology terms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.ontology.model.OntologyTerm> findBySpaceId(
        java.lang.Long ontologySpaceId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the ontology terms where ontologySpaceId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param ontologySpaceId the ontology space ID
    * @param start the lower bound of the range of ontology terms
    * @param end the upper bound of the range of ontology terms (not inclusive)
    * @return the range of matching ontology terms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.ontology.model.OntologyTerm> findBySpaceId(
        java.lang.Long ontologySpaceId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the ontology terms where ontologySpaceId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param ontologySpaceId the ontology space ID
    * @param start the lower bound of the range of ontology terms
    * @param end the upper bound of the range of ontology terms (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching ontology terms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.ontology.model.OntologyTerm> findBySpaceId(
        java.lang.Long ontologySpaceId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first ontology term in the ordered set where ontologySpaceId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param ontologySpaceId the ontology space ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching ontology term
    * @throws com.ext.portlet.ontology.NoSuchOntologyTermException if a matching ontology term could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.ontology.model.OntologyTerm findBySpaceId_First(
        java.lang.Long ontologySpaceId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.ontology.NoSuchOntologyTermException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last ontology term in the ordered set where ontologySpaceId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param ontologySpaceId the ontology space ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching ontology term
    * @throws com.ext.portlet.ontology.NoSuchOntologyTermException if a matching ontology term could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.ontology.model.OntologyTerm findBySpaceId_Last(
        java.lang.Long ontologySpaceId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.ontology.NoSuchOntologyTermException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the ontology terms before and after the current ontology term in the ordered set where ontologySpaceId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param id the primary key of the current ontology term
    * @param ontologySpaceId the ontology space ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next ontology term
    * @throws com.ext.portlet.ontology.NoSuchOntologyTermException if a ontology term with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.ontology.model.OntologyTerm[] findBySpaceId_PrevAndNext(
        java.lang.Long id, java.lang.Long ontologySpaceId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.ontology.NoSuchOntologyTermException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the ontology terms where name = &#63;.
    *
    * @param name the name
    * @return the matching ontology terms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.ontology.model.OntologyTerm> findByName(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the ontology terms where name = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param name the name
    * @param start the lower bound of the range of ontology terms
    * @param end the upper bound of the range of ontology terms (not inclusive)
    * @return the range of matching ontology terms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.ontology.model.OntologyTerm> findByName(
        java.lang.String name, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the ontology terms where name = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param name the name
    * @param start the lower bound of the range of ontology terms
    * @param end the upper bound of the range of ontology terms (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching ontology terms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.ontology.model.OntologyTerm> findByName(
        java.lang.String name, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first ontology term in the ordered set where name = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching ontology term
    * @throws com.ext.portlet.ontology.NoSuchOntologyTermException if a matching ontology term could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.ontology.model.OntologyTerm findByName_First(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.ontology.NoSuchOntologyTermException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last ontology term in the ordered set where name = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching ontology term
    * @throws com.ext.portlet.ontology.NoSuchOntologyTermException if a matching ontology term could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.ontology.model.OntologyTerm findByName_Last(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.ontology.NoSuchOntologyTermException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the ontology terms before and after the current ontology term in the ordered set where name = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param id the primary key of the current ontology term
    * @param name the name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next ontology term
    * @throws com.ext.portlet.ontology.NoSuchOntologyTermException if a ontology term with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.ext.portlet.ontology.model.OntologyTerm[] findByName_PrevAndNext(
        java.lang.Long id, java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.ext.portlet.ontology.NoSuchOntologyTermException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the ontology terms.
    *
    * @return the ontology terms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.ontology.model.OntologyTerm> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the ontology terms.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of ontology terms
    * @param end the upper bound of the range of ontology terms (not inclusive)
    * @return the range of ontology terms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.ontology.model.OntologyTerm> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the ontology terms.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of ontology terms
    * @param end the upper bound of the range of ontology terms (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of ontology terms
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.ext.portlet.ontology.model.OntologyTerm> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the ontology terms where parentId = &#63; from the database.
    *
    * @param parentId the parent ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByParentId(java.lang.Long parentId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the ontology terms where parentId = &#63; and ontologySpaceId = &#63; from the database.
    *
    * @param parentId the parent ID
    * @param ontologySpaceId the ontology space ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByParentIdSpaceId(java.lang.Long parentId,
        java.lang.Long ontologySpaceId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the ontology terms where ontologySpaceId = &#63; from the database.
    *
    * @param ontologySpaceId the ontology space ID
    * @throws SystemException if a system exception occurred
    */
    public void removeBySpaceId(java.lang.Long ontologySpaceId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the ontology terms where name = &#63; from the database.
    *
    * @param name the name
    * @throws SystemException if a system exception occurred
    */
    public void removeByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the ontology terms from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of ontology terms where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @return the number of matching ontology terms
    * @throws SystemException if a system exception occurred
    */
    public int countByParentId(java.lang.Long parentId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of ontology terms where parentId = &#63; and ontologySpaceId = &#63;.
    *
    * @param parentId the parent ID
    * @param ontologySpaceId the ontology space ID
    * @return the number of matching ontology terms
    * @throws SystemException if a system exception occurred
    */
    public int countByParentIdSpaceId(java.lang.Long parentId,
        java.lang.Long ontologySpaceId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of ontology terms where ontologySpaceId = &#63;.
    *
    * @param ontologySpaceId the ontology space ID
    * @return the number of matching ontology terms
    * @throws SystemException if a system exception occurred
    */
    public int countBySpaceId(java.lang.Long ontologySpaceId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of ontology terms where name = &#63;.
    *
    * @param name the name
    * @return the number of matching ontology terms
    * @throws SystemException if a system exception occurred
    */
    public int countByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of ontology terms.
    *
    * @return the number of ontology terms
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
