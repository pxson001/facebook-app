package com.facebook.graphql.enums;

/* compiled from: media_data */
public enum GraphQLCommercePageSetting {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    COMMERCE_FAQ_ENABLED,
    IN_MESSENGER_SHOPPING_ENABLED,
    COMMERCE_NUX_ENABLED,
    NULL_STATE_CTA_BUTTON_ALWAYS_ENABLED,
    STRUCTURED_MENU_ENABLED;

    public static GraphQLCommercePageSetting fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("COMMERCE_FAQ_ENABLED")) {
            return COMMERCE_FAQ_ENABLED;
        }
        if (str.equalsIgnoreCase("IN_MESSENGER_SHOPPING_ENABLED")) {
            return IN_MESSENGER_SHOPPING_ENABLED;
        }
        if (str.equalsIgnoreCase("COMMERCE_NUX_ENABLED")) {
            return COMMERCE_NUX_ENABLED;
        }
        if (str.equalsIgnoreCase("NULL_STATE_CTA_BUTTON_ALWAYS_ENABLED")) {
            return NULL_STATE_CTA_BUTTON_ALWAYS_ENABLED;
        }
        if (str.equalsIgnoreCase("STRUCTURED_MENU_ENABLED")) {
            return STRUCTURED_MENU_ENABLED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
