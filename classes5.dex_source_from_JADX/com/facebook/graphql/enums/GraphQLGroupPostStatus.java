package com.facebook.graphql.enums;

/* compiled from: m_chain_friend_accept_notif */
public enum GraphQLGroupPostStatus {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    CAN_POST_WITHOUT_APPROVAL,
    CAN_POST_AFTER_APPROVAL,
    CANNOT_POST;

    public static GraphQLGroupPostStatus fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("CAN_POST_WITHOUT_APPROVAL")) {
            return CAN_POST_WITHOUT_APPROVAL;
        }
        if (str.equalsIgnoreCase("CAN_POST_AFTER_APPROVAL")) {
            return CAN_POST_AFTER_APPROVAL;
        }
        if (str.equalsIgnoreCase("CANNOT_POST")) {
            return CANNOT_POST;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
