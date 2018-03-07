package com.facebook.graphql.enums;

/* compiled from: destroy */
public enum GraphQLStoryActionLinkDestinationType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    APP,
    APP_WITH_PRODUCT,
    LINK,
    NOT_CLASSIFIED,
    INTERNAL_FLOW;

    public static GraphQLStoryActionLinkDestinationType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("APP")) {
            return APP;
        }
        if (str.equalsIgnoreCase("APP_WITH_PRODUCT")) {
            return APP_WITH_PRODUCT;
        }
        if (str.equalsIgnoreCase("LINK")) {
            return LINK;
        }
        if (str.equalsIgnoreCase("NOT_CLASSIFIED")) {
            return NOT_CLASSIFIED;
        }
        if (str.equalsIgnoreCase("INTERNAL_FLOW")) {
            return INTERNAL_FLOW;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
