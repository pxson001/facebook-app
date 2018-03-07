package com.facebook.graphql.enums;

/* compiled from: media_editor_review_and_suggest_module */
public enum GraphQLCommerceCheckoutStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    CONTACT_MERCHANT,
    OFFSITE_LINK,
    ONSITE_CHECKOUT;

    public static GraphQLCommerceCheckoutStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("CONTACT_MERCHANT")) {
            return CONTACT_MERCHANT;
        }
        if (str.equalsIgnoreCase("OFFSITE_LINK")) {
            return OFFSITE_LINK;
        }
        if (str.equalsIgnoreCase("ONSITE_CHECKOUT")) {
            return ONSITE_CHECKOUT;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
