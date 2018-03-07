package com.facebook.graphql.enums;

/* compiled from: mImplicitLoc */
public enum GraphQLPageCallToActionRef {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NONE,
    MOBILE_PAGE_PRESENCE_CALL_TO_ACTION,
    COVER_PHOTO_SURFACE,
    HOVER_CARD_SURFACE,
    PAGE_PLUGIN_SURFACE,
    ADMIN_MENU_TEST_LINK,
    PAGE_PRESENCE_LHS_CARD,
    SEARCH_ENTITY_CARD,
    PROSERVICES_SEARCH_ENTITY_CARD,
    FEED_STORY,
    FEED_STORY_SEARCH,
    DEPRECATED_12,
    PAGES_ACTIONS_UNIT_SURFACE,
    PAGES_SERVICES_SURFACE,
    CTA_HOVER_CARD_SURFACE;

    public static GraphQLPageCallToActionRef fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NONE")) {
            return NONE;
        }
        if (str.equalsIgnoreCase("MOBILE_PAGE_PRESENCE_CALL_TO_ACTION")) {
            return MOBILE_PAGE_PRESENCE_CALL_TO_ACTION;
        }
        if (str.equalsIgnoreCase("COVER_PHOTO_SURFACE")) {
            return COVER_PHOTO_SURFACE;
        }
        if (str.equalsIgnoreCase("HOVER_CARD_SURFACE")) {
            return HOVER_CARD_SURFACE;
        }
        if (str.equalsIgnoreCase("PAGE_PLUGIN_SURFACE")) {
            return PAGE_PLUGIN_SURFACE;
        }
        if (str.equalsIgnoreCase("ADMIN_MENU_TEST_LINK")) {
            return ADMIN_MENU_TEST_LINK;
        }
        if (str.equalsIgnoreCase("PAGE_PRESENCE_LHS_CARD")) {
            return PAGE_PRESENCE_LHS_CARD;
        }
        if (str.equalsIgnoreCase("SEARCH_ENTITY_CARD")) {
            return SEARCH_ENTITY_CARD;
        }
        if (str.equalsIgnoreCase("PROSERVICES_SEARCH_ENTITY_CARD")) {
            return PROSERVICES_SEARCH_ENTITY_CARD;
        }
        if (str.equalsIgnoreCase("FEED_STORY")) {
            return FEED_STORY;
        }
        if (str.equalsIgnoreCase("FEED_STORY_SEARCH")) {
            return FEED_STORY_SEARCH;
        }
        if (str.equalsIgnoreCase("PAGES_ACTIONS_UNIT_SURFACE")) {
            return PAGES_ACTIONS_UNIT_SURFACE;
        }
        if (str.equalsIgnoreCase("PAGES_SERVICES_SURFACE")) {
            return PAGES_SERVICES_SURFACE;
        }
        if (str.equalsIgnoreCase("CTA_HOVER_CARD_SURFACE")) {
            return CTA_HOVER_CARD_SURFACE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
