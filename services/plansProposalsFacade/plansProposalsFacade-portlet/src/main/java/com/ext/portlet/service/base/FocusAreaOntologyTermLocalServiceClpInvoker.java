package com.ext.portlet.service.base;

import com.ext.portlet.service.FocusAreaOntologyTermLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FocusAreaOntologyTermLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName514;
    private String[] _methodParameterTypes514;
    private String _methodName515;
    private String[] _methodParameterTypes515;
    private String _methodName520;
    private String[] _methodParameterTypes520;
    private String _methodName521;
    private String[] _methodParameterTypes521;
    private String _methodName522;
    private String[] _methodParameterTypes522;
    private String _methodName523;
    private String[] _methodParameterTypes523;
    private String _methodName524;
    private String[] _methodParameterTypes524;
    private String _methodName525;
    private String[] _methodParameterTypes525;

    public FocusAreaOntologyTermLocalServiceClpInvoker() {
        _methodName0 = "addFocusAreaOntologyTerm";

        _methodParameterTypes0 = new String[] {
                "com.ext.portlet.model.FocusAreaOntologyTerm"
            };

        _methodName1 = "createFocusAreaOntologyTerm";

        _methodParameterTypes1 = new String[] {
                "com.ext.portlet.service.persistence.FocusAreaOntologyTermPK"
            };

        _methodName2 = "deleteFocusAreaOntologyTerm";

        _methodParameterTypes2 = new String[] {
                "com.ext.portlet.service.persistence.FocusAreaOntologyTermPK"
            };

        _methodName3 = "deleteFocusAreaOntologyTerm";

        _methodParameterTypes3 = new String[] {
                "com.ext.portlet.model.FocusAreaOntologyTerm"
            };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchFocusAreaOntologyTerm";

        _methodParameterTypes10 = new String[] {
                "com.ext.portlet.service.persistence.FocusAreaOntologyTermPK"
            };

        _methodName11 = "getFocusAreaOntologyTerm";

        _methodParameterTypes11 = new String[] {
                "com.ext.portlet.service.persistence.FocusAreaOntologyTermPK"
            };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getFocusAreaOntologyTerms";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getFocusAreaOntologyTermsCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateFocusAreaOntologyTerm";

        _methodParameterTypes15 = new String[] {
                "com.ext.portlet.model.FocusAreaOntologyTerm"
            };

        _methodName514 = "getBeanIdentifier";

        _methodParameterTypes514 = new String[] {  };

        _methodName515 = "setBeanIdentifier";

        _methodParameterTypes515 = new String[] { "java.lang.String" };

        _methodName520 = "findTermsByFocusArea";

        _methodParameterTypes520 = new String[] { "java.lang.Long" };

        _methodName521 = "addAreaTerm";

        _methodParameterTypes521 = new String[] {
                "java.lang.Long", "java.lang.Long"
            };

        _methodName522 = "removeAreaTerm";

        _methodParameterTypes522 = new String[] {
                "java.lang.Long", "java.lang.Long"
            };

        _methodName523 = "store";

        _methodParameterTypes523 = new String[] {
                "com.ext.portlet.model.FocusAreaOntologyTerm"
            };

        _methodName524 = "getTerm";

        _methodParameterTypes524 = new String[] {
                "com.ext.portlet.model.FocusAreaOntologyTerm"
            };

        _methodName525 = "getArea";

        _methodParameterTypes525 = new String[] {
                "com.ext.portlet.model.FocusAreaOntologyTerm"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return FocusAreaOntologyTermLocalServiceUtil.addFocusAreaOntologyTerm((com.ext.portlet.model.FocusAreaOntologyTerm) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return FocusAreaOntologyTermLocalServiceUtil.createFocusAreaOntologyTerm((com.ext.portlet.service.persistence.FocusAreaOntologyTermPK) arguments[0]);
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return FocusAreaOntologyTermLocalServiceUtil.deleteFocusAreaOntologyTerm((com.ext.portlet.service.persistence.FocusAreaOntologyTermPK) arguments[0]);
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return FocusAreaOntologyTermLocalServiceUtil.deleteFocusAreaOntologyTerm((com.ext.portlet.model.FocusAreaOntologyTerm) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return FocusAreaOntologyTermLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return FocusAreaOntologyTermLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return FocusAreaOntologyTermLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return FocusAreaOntologyTermLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return FocusAreaOntologyTermLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return FocusAreaOntologyTermLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return FocusAreaOntologyTermLocalServiceUtil.fetchFocusAreaOntologyTerm((com.ext.portlet.service.persistence.FocusAreaOntologyTermPK) arguments[0]);
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return FocusAreaOntologyTermLocalServiceUtil.getFocusAreaOntologyTerm((com.ext.portlet.service.persistence.FocusAreaOntologyTermPK) arguments[0]);
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return FocusAreaOntologyTermLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return FocusAreaOntologyTermLocalServiceUtil.getFocusAreaOntologyTerms(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return FocusAreaOntologyTermLocalServiceUtil.getFocusAreaOntologyTermsCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return FocusAreaOntologyTermLocalServiceUtil.updateFocusAreaOntologyTerm((com.ext.portlet.model.FocusAreaOntologyTerm) arguments[0]);
        }

        if (_methodName514.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes514, parameterTypes)) {
            return FocusAreaOntologyTermLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName515.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes515, parameterTypes)) {
            FocusAreaOntologyTermLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName520.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes520, parameterTypes)) {
            return FocusAreaOntologyTermLocalServiceUtil.findTermsByFocusArea((java.lang.Long) arguments[0]);
        }

        if (_methodName521.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes521, parameterTypes)) {
            FocusAreaOntologyTermLocalServiceUtil.addAreaTerm((java.lang.Long) arguments[0],
                (java.lang.Long) arguments[1]);

            return null;
        }

        if (_methodName522.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes522, parameterTypes)) {
            FocusAreaOntologyTermLocalServiceUtil.removeAreaTerm((java.lang.Long) arguments[0],
                (java.lang.Long) arguments[1]);

            return null;
        }

        if (_methodName523.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes523, parameterTypes)) {
            FocusAreaOntologyTermLocalServiceUtil.store((com.ext.portlet.model.FocusAreaOntologyTerm) arguments[0]);

            return null;
        }

        if (_methodName524.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes524, parameterTypes)) {
            return FocusAreaOntologyTermLocalServiceUtil.getTerm((com.ext.portlet.model.FocusAreaOntologyTerm) arguments[0]);
        }

        if (_methodName525.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes525, parameterTypes)) {
            return FocusAreaOntologyTermLocalServiceUtil.getArea((com.ext.portlet.model.FocusAreaOntologyTerm) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}
