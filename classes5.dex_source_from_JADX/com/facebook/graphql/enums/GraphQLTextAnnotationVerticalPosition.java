package com.facebook.graphql.enums;

/* compiled from: links_pyml */
public enum GraphQLTextAnnotationVerticalPosition {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    TOP,
    CENTER,
    BOTTOM,
    BELOW,
    ABOVE;

    public static GraphQLTextAnnotationVerticalPosition fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("TOP")) {
            return TOP;
        }
        if (str.equalsIgnoreCase("CENTER")) {
            return CENTER;
        }
        if (str.equalsIgnoreCase("BOTTOM")) {
            return BOTTOM;
        }
        if (str.equalsIgnoreCase("BELOW")) {
            return BELOW;
        }
        if (str.equalsIgnoreCase("ABOVE")) {
            return ABOVE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
