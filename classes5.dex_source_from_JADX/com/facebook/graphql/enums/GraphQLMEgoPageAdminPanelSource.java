package com.facebook.graphql.enums;

/* compiled from: mRecreateDisplayList */
public enum GraphQLMEgoPageAdminPanelSource {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    PROFILE_COVER_PHOTO,
    PROFILE_BADGE,
    LAST_CARD,
    LAST_CARD_CREATE_PAGE,
    LAST_CARD_LAUNCH_POINT,
    FLYOUT_TRIGGER,
    FLYOUT_OPTION_MENU,
    FLYOUT_SEE_LESS,
    FLYOUT_SEE_LESS_UNDO,
    FLYOUT_SEE_MORE,
    FLYOUT_SEE_MORE_UNDO,
    CONTEXT_ROW,
    AYMT_TIP;

    public static GraphQLMEgoPageAdminPanelSource fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("PROFILE_COVER_PHOTO")) {
            return PROFILE_COVER_PHOTO;
        }
        if (str.equalsIgnoreCase("PROFILE_BADGE")) {
            return PROFILE_BADGE;
        }
        if (str.equalsIgnoreCase("LAST_CARD")) {
            return LAST_CARD;
        }
        if (str.equalsIgnoreCase("LAST_CARD_CREATE_PAGE")) {
            return LAST_CARD_CREATE_PAGE;
        }
        if (str.equalsIgnoreCase("LAST_CARD_LAUNCH_POINT")) {
            return LAST_CARD_LAUNCH_POINT;
        }
        if (str.equalsIgnoreCase("FLYOUT_TRIGGER")) {
            return FLYOUT_TRIGGER;
        }
        if (str.equalsIgnoreCase("FLYOUT_OPTION_MENU")) {
            return FLYOUT_OPTION_MENU;
        }
        if (str.equalsIgnoreCase("FLYOUT_SEE_LESS")) {
            return FLYOUT_SEE_LESS;
        }
        if (str.equalsIgnoreCase("FLYOUT_SEE_LESS_UNDO")) {
            return FLYOUT_SEE_LESS_UNDO;
        }
        if (str.equalsIgnoreCase("FLYOUT_SEE_MORE")) {
            return FLYOUT_SEE_MORE;
        }
        if (str.equalsIgnoreCase("FLYOUT_SEE_MORE_UNDO")) {
            return FLYOUT_SEE_MORE_UNDO;
        }
        if (str.equalsIgnoreCase("CONTEXT_ROW")) {
            return CONTEXT_ROW;
        }
        if (str.equalsIgnoreCase("AYMT_TIP")) {
            return AYMT_TIP;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
