package com.facebook.graphql.enums;

/* compiled from: m_chain_friend_request_pending */
public enum GraphQLGroupJoinState {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    CAN_JOIN,
    CAN_REQUEST,
    CANNOT_JOIN_OR_REQUEST,
    REQUESTED,
    MEMBER;

    public static GraphQLGroupJoinState fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("CAN_JOIN")) {
            return CAN_JOIN;
        }
        if (str.equalsIgnoreCase("CAN_REQUEST")) {
            return CAN_REQUEST;
        }
        if (str.equalsIgnoreCase("CANNOT_JOIN_OR_REQUEST")) {
            return CANNOT_JOIN_OR_REQUEST;
        }
        if (str.equalsIgnoreCase("REQUESTED")) {
            return REQUESTED;
        }
        if (str.equalsIgnoreCase("MEMBER")) {
            return MEMBER;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
