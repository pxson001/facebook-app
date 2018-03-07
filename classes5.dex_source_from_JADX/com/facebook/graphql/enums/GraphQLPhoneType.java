package com.facebook.graphql.enums;

/* compiled from: mBatchPayloadIterator is null */
public enum GraphQLPhoneType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    UNKNOWN,
    WORK,
    HOME,
    CELL;

    public static GraphQLPhoneType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("UNKNOWN")) {
            return UNKNOWN;
        }
        if (str.equalsIgnoreCase("WORK")) {
            return WORK;
        }
        if (str.equalsIgnoreCase("HOME")) {
            return HOME;
        }
        if (str.equalsIgnoreCase("CELL")) {
            return CELL;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
