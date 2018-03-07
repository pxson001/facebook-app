package com.facebook.graphql.enums;

/* compiled from: lowerEndpoint (%s) > upperEndpoint (%s) */
public enum GraphQLPrivacyCheckupSectionType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    SECTION_HEADER_ITEM_TYPE,
    SECTION_DATA_ITEM_TYPE,
    SECTION_INFORMATION_ITEM_TYPE;

    public static GraphQLPrivacyCheckupSectionType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("SECTION_HEADER_ITEM_TYPE")) {
            return SECTION_HEADER_ITEM_TYPE;
        }
        if (str.equalsIgnoreCase("SECTION_DATA_ITEM_TYPE")) {
            return SECTION_DATA_ITEM_TYPE;
        }
        if (str.equalsIgnoreCase("SECTION_INFORMATION_ITEM_TYPE")) {
            return SECTION_INFORMATION_ITEM_TYPE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
