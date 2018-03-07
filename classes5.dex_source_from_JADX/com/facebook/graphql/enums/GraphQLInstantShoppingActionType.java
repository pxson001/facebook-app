package com.facebook.graphql.enums;

/* compiled from: mTextOnlyPlace */
public enum GraphQLInstantShoppingActionType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    OPEN_URL,
    POST,
    SHOW_SELECTOR,
    ADD_TO_CART,
    SAVE,
    UNSAVE;

    public static GraphQLInstantShoppingActionType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("OPEN_URL")) {
            return OPEN_URL;
        }
        if (str.equalsIgnoreCase("POST")) {
            return POST;
        }
        if (str.equalsIgnoreCase("SHOW_SELECTOR")) {
            return SHOW_SELECTOR;
        }
        if (str.equalsIgnoreCase("ADD_TO_CART")) {
            return ADD_TO_CART;
        }
        if (str.equalsIgnoreCase("SAVE")) {
            return SAVE;
        }
        if (str.equalsIgnoreCase("UNSAVE")) {
            return UNSAVE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
