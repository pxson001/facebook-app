package com.facebook.graphql.enums;

/* compiled from: lv_LV */
public enum GraphQLSubscribeStatus {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    CANNOT_SUBSCRIBE,
    IS_SUBSCRIBED,
    CAN_SUBSCRIBE;

    public static GraphQLSubscribeStatus fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("CANNOT_SUBSCRIBE")) {
            return CANNOT_SUBSCRIBE;
        }
        if (str.equalsIgnoreCase("IS_SUBSCRIBED")) {
            return IS_SUBSCRIBED;
        }
        if (str.equalsIgnoreCase("CAN_SUBSCRIBE")) {
            return CAN_SUBSCRIBE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
