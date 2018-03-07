package com.facebook.graphql.enums;

/* compiled from: longPressTimeout */
public enum GraphQLProfileFieldStyle {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ADDRESS,
    DATE,
    EMAIL,
    INFO_REQUEST,
    INFO_REQUEST_CANCEL,
    LIST_OF_STRINGS,
    PAGE_TAGS,
    PARAGRAPH,
    PHONE,
    STRING,
    TEXT_LINK,
    TEXT_LISTS,
    UPSELL;

    public static GraphQLProfileFieldStyle fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("ADDRESS")) {
            return ADDRESS;
        }
        if (str.equalsIgnoreCase("DATE")) {
            return DATE;
        }
        if (str.equalsIgnoreCase("EMAIL")) {
            return EMAIL;
        }
        if (str.equalsIgnoreCase("INFO_REQUEST")) {
            return INFO_REQUEST;
        }
        if (str.equalsIgnoreCase("INFO_REQUEST_CANCEL")) {
            return INFO_REQUEST_CANCEL;
        }
        if (str.equalsIgnoreCase("LIST_OF_STRINGS")) {
            return LIST_OF_STRINGS;
        }
        if (str.equalsIgnoreCase("PAGE_TAGS")) {
            return PAGE_TAGS;
        }
        if (str.equalsIgnoreCase("PARAGRAPH")) {
            return PARAGRAPH;
        }
        if (str.equalsIgnoreCase("PHONE")) {
            return PHONE;
        }
        if (str.equalsIgnoreCase("STRING")) {
            return STRING;
        }
        if (str.equalsIgnoreCase("TEXT_LINK")) {
            return TEXT_LINK;
        }
        if (str.equalsIgnoreCase("TEXT_LISTS")) {
            return TEXT_LISTS;
        }
        if (str.equalsIgnoreCase("UPSELL")) {
            return UPSELL;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
