package com.facebook.graphql.enums;

/* compiled from: media_owner_object_id */
public enum GraphQLBoostedComponentMessageType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    ERROR,
    WARNING,
    TIP;

    public static GraphQLBoostedComponentMessageType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("ERROR")) {
            return ERROR;
        }
        if (str.equalsIgnoreCase("WARNING")) {
            return WARNING;
        }
        if (str.equalsIgnoreCase("TIP")) {
            return TIP;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
