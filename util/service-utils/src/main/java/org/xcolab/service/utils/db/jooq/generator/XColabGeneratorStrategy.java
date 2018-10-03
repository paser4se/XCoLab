package org.xcolab.service.utils.db.jooq.generator;

import org.jooq.util.Definition;

import org.xcolab.commons.jooq.JooqGeneratorStrategy;

import java.util.List;

public class XColabGeneratorStrategy extends JooqGeneratorStrategy {

    static final String PREFIX_SEPARATOR = "__";
    static final String INTERFACE_PATH_FORMAT = "org.xcolab.client.%s.pojo.%s";

    @Override
    protected String customizeJavaClassName(String originalName) {
        String unprefixedName = cleanUpSchemeAndPrefix(originalName);
        return super.customizeJavaClassName(unprefixedName);
    }

    @Override
    protected String customizeJavaIdentifier(String originalName) {
        String unprefixedName = cleanUpSchemeAndPrefix(originalName);
        return super.customizeJavaIdentifier(unprefixedName);
    }

    private String cleanUpSchemeAndPrefix(String val) {
        final int prefixIndex = val.indexOf(PREFIX_SEPARATOR);
        if (prefixIndex != -1) {
            return val.substring(prefixIndex + PREFIX_SEPARATOR.length());
        }
        return val;
    }
}
