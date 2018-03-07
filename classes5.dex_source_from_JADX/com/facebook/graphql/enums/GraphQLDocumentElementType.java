package com.facebook.graphql.enums;

/* compiled from: max_view_depth */
public enum GraphQLDocumentElementType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    RICH_TEXT,
    PHOTO,
    VIDEO,
    SLIDESHOW,
    MAP,
    LIST_ITEM,
    WEBVIEW,
    AD,
    MULTI_TEXT,
    NATIVE_AD,
    RELATED_ARTICLES,
    SUBSCRIPTION_OPTION;

    public static GraphQLDocumentElementType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("RICH_TEXT")) {
            return RICH_TEXT;
        }
        if (str.equalsIgnoreCase("PHOTO")) {
            return PHOTO;
        }
        if (str.equalsIgnoreCase("VIDEO")) {
            return VIDEO;
        }
        if (str.equalsIgnoreCase("SLIDESHOW")) {
            return SLIDESHOW;
        }
        if (str.equalsIgnoreCase("MAP")) {
            return MAP;
        }
        if (str.equalsIgnoreCase("LIST_ITEM")) {
            return LIST_ITEM;
        }
        if (str.equalsIgnoreCase("WEBVIEW")) {
            return WEBVIEW;
        }
        if (str.equalsIgnoreCase("AD")) {
            return AD;
        }
        if (str.equalsIgnoreCase("MULTI_TEXT")) {
            return MULTI_TEXT;
        }
        if (str.equalsIgnoreCase("NATIVE_AD")) {
            return NATIVE_AD;
        }
        if (str.equalsIgnoreCase("RELATED_ARTICLES")) {
            return RELATED_ARTICLES;
        }
        if (str.equalsIgnoreCase("SUBSCRIPTION_OPTION")) {
            return SUBSCRIPTION_OPTION;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
