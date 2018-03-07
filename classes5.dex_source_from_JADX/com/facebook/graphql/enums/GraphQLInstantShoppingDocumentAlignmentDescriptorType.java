package com.facebook.graphql.enums;

/* compiled from: mTaggedPlace */
public enum GraphQLInstantShoppingDocumentAlignmentDescriptorType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    LEFT,
    CENTER,
    RIGHT;

    public static GraphQLInstantShoppingDocumentAlignmentDescriptorType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("LEFT")) {
            return LEFT;
        }
        if (str.equalsIgnoreCase("CENTER")) {
            return CENTER;
        }
        if (str.equalsIgnoreCase("RIGHT")) {
            return RIGHT;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
