package com.facebook.timeline.aboutpage.model;

/* compiled from: Method Not Allowed */
public enum GroupJoinStatus {
    UNKNOWN,
    CAN_JOIN,
    CAN_REQUEST,
    CANNOT_JOIN_OR_REQUEST,
    REQUESTED,
    MEMBER;

    public static GroupJoinStatus fromString(String str) {
        if (str == null) {
            return UNKNOWN;
        }
        try {
            return valueOf(str);
        } catch (IllegalArgumentException e) {
            return UNKNOWN;
        }
    }
}
