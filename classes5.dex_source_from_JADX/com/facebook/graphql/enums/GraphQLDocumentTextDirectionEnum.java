package com.facebook.graphql.enums;

/* compiled from: max-height */
public enum GraphQLDocumentTextDirectionEnum {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    LEFT_TO_RIGHT,
    RIGHT_TO_LEFT;

    public static GraphQLDocumentTextDirectionEnum fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("LEFT_TO_RIGHT")) {
            return LEFT_TO_RIGHT;
        }
        if (str.equalsIgnoreCase("RIGHT_TO_LEFT")) {
            return RIGHT_TO_LEFT;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
