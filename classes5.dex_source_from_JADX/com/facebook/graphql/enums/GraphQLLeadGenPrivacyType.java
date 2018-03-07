package com.facebook.graphql.enums;

/* compiled from: mSelection= */
public enum GraphQLLeadGenPrivacyType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    SHORT_SECURE_SHARING_TEXT,
    SECURE_SHARING_TEXT,
    PRIVACY_WITH_PHONE,
    CHECK_BOX_TEXT_WITH_PHONE,
    PRIVACY_LINK_TEXT,
    DISCLAIMER_PAGE_TITLE,
    CUSTOMIZED_DISCLAIMER;

    public static GraphQLLeadGenPrivacyType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("SHORT_SECURE_SHARING_TEXT")) {
            return SHORT_SECURE_SHARING_TEXT;
        }
        if (str.equalsIgnoreCase("SECURE_SHARING_TEXT")) {
            return SECURE_SHARING_TEXT;
        }
        if (str.equalsIgnoreCase("PRIVACY_WITH_PHONE")) {
            return PRIVACY_WITH_PHONE;
        }
        if (str.equalsIgnoreCase("CHECK_BOX_TEXT_WITH_PHONE")) {
            return CHECK_BOX_TEXT_WITH_PHONE;
        }
        if (str.equalsIgnoreCase("PRIVACY_LINK_TEXT")) {
            return PRIVACY_LINK_TEXT;
        }
        if (str.equalsIgnoreCase("DISCLAIMER_PAGE_TITLE")) {
            return DISCLAIMER_PAGE_TITLE;
        }
        if (str.equalsIgnoreCase("CUSTOMIZED_DISCLAIMER")) {
            return CUSTOMIZED_DISCLAIMER;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
