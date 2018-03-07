package com.facebook.graphql.enums;

/* compiled from: link_display */
public enum GraphQLTosTransitionTypeEnum {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NOOP,
    EXPLICIT,
    EXPLICIT_FROM_BLOCKING,
    IMPLICIT;

    public static GraphQLTosTransitionTypeEnum fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NOOP")) {
            return NOOP;
        }
        if (str.equalsIgnoreCase("EXPLICIT")) {
            return EXPLICIT;
        }
        if (str.equalsIgnoreCase("EXPLICIT_FROM_BLOCKING")) {
            return EXPLICIT_FROM_BLOCKING;
        }
        if (str.equalsIgnoreCase("IMPLICIT")) {
            return IMPLICIT;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
