package com.facebook.graphql.enums;

/* compiled from: maxZoomLevel */
public enum GraphQLDocumentFormatVersion {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    V1;

    public static GraphQLDocumentFormatVersion fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("V1")) {
            return V1;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
