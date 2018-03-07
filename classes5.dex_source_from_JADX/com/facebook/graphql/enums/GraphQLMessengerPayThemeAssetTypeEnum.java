package com.facebook.graphql.enums;

/* compiled from: mOptinConfirmButtonText */
public enum GraphQLMessengerPayThemeAssetTypeEnum {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    CHAT_BUBBLE_VIEW,
    REQUEST_PAY_VIEW,
    SEND_VIEW,
    FULLSCREEN_CARD_VIEW,
    FULLSCREEN_TOP,
    FULLSCREEN_BOTTOM;

    public static GraphQLMessengerPayThemeAssetTypeEnum fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("CHAT_BUBBLE_VIEW")) {
            return CHAT_BUBBLE_VIEW;
        }
        if (str.equalsIgnoreCase("REQUEST_PAY_VIEW")) {
            return REQUEST_PAY_VIEW;
        }
        if (str.equalsIgnoreCase("SEND_VIEW")) {
            return SEND_VIEW;
        }
        if (str.equalsIgnoreCase("FULLSCREEN_CARD_VIEW")) {
            return FULLSCREEN_CARD_VIEW;
        }
        if (str.equalsIgnoreCase("FULLSCREEN_TOP")) {
            return FULLSCREEN_TOP;
        }
        if (str.equalsIgnoreCase("FULLSCREEN_BOTTOM")) {
            return FULLSCREEN_BOTTOM;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
