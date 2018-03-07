package com.facebook.graphql.enums;

/* compiled from: loop_count */
public enum GraphQLProductAvailability {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    IN_STOCK,
    OUT_OF_STOCK,
    PREORDER,
    AVAILABLE_FOR_ORDER,
    DISCONTINUED;

    public static GraphQLProductAvailability fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("IN_STOCK")) {
            return IN_STOCK;
        }
        if (str.equalsIgnoreCase("OUT_OF_STOCK")) {
            return OUT_OF_STOCK;
        }
        if (str.equalsIgnoreCase("PREORDER")) {
            return PREORDER;
        }
        if (str.equalsIgnoreCase("AVAILABLE_FOR_ORDER")) {
            return AVAILABLE_FOR_ORDER;
        }
        if (str.equalsIgnoreCase("DISCONTINUED")) {
            return DISCONTINUED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
