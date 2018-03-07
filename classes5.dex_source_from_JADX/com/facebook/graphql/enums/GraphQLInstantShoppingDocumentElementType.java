package com.facebook.graphql.enums;

/* compiled from: mSubTitle */
public enum GraphQLInstantShoppingDocumentElementType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    RICH_TEXT,
    PHOTO,
    BUTTON,
    SLIDESHOW,
    DIVIDER,
    EXPANDABLE_SECTION,
    STATEFUL,
    VIDEO,
    COLOR_SELECTOR,
    TOGGLE_BUTTON,
    HEADER,
    COMPOSITE_BLOCK,
    FOOTER,
    ELEMENT_GROUP;

    public static GraphQLInstantShoppingDocumentElementType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("RICH_TEXT")) {
            return RICH_TEXT;
        }
        if (str.equalsIgnoreCase("PHOTO")) {
            return PHOTO;
        }
        if (str.equalsIgnoreCase("BUTTON")) {
            return BUTTON;
        }
        if (str.equalsIgnoreCase("SLIDESHOW")) {
            return SLIDESHOW;
        }
        if (str.equalsIgnoreCase("DIVIDER")) {
            return DIVIDER;
        }
        if (str.equalsIgnoreCase("EXPANDABLE_SECTION")) {
            return EXPANDABLE_SECTION;
        }
        if (str.equalsIgnoreCase("STATEFUL")) {
            return STATEFUL;
        }
        if (str.equalsIgnoreCase("VIDEO")) {
            return VIDEO;
        }
        if (str.equalsIgnoreCase("COLOR_SELECTOR")) {
            return COLOR_SELECTOR;
        }
        if (str.equalsIgnoreCase("TOGGLE_BUTTON")) {
            return TOGGLE_BUTTON;
        }
        if (str.equalsIgnoreCase("HEADER")) {
            return HEADER;
        }
        if (str.equalsIgnoreCase("COMPOSITE_BLOCK")) {
            return COMPOSITE_BLOCK;
        }
        if (str.equalsIgnoreCase("FOOTER")) {
            return FOOTER;
        }
        if (str.equalsIgnoreCase("ELEMENT_GROUP")) {
            return ELEMENT_GROUP;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
