package com.facebook.graphql.enums;

/* compiled from: low_res_theme_image */
public enum GraphQLPrivacyReviewCoreSectionType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    SECTION_HEADER_ITEM_TYPE,
    SECTION_DATA_ITEM_TYPE;

    public static GraphQLPrivacyReviewCoreSectionType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("SECTION_HEADER_ITEM_TYPE")) {
            return SECTION_HEADER_ITEM_TYPE;
        }
        if (str.equalsIgnoreCase("SECTION_DATA_ITEM_TYPE")) {
            return SECTION_DATA_ITEM_TYPE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
