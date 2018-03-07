package com.facebook.graphql.enums;

/* compiled from: mark is not supported */
public enum GraphQLEventInviteeStatusType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    INVITABLE,
    INVITABLE_FOF,
    INVITED,
    GOING,
    MAYBE,
    NOT_GOING,
    REMOVED,
    VIEWER_SELF,
    OVER_LIMIT,
    NOT_FRIEND,
    NOT_GROUP_MEMBER,
    NOT_GROUP_FRIEND,
    HIDDEN_REASON,
    INELIGIBLE_FOR_EVENT,
    SUBSCRIBED,
    UNKNOWN;

    public static GraphQLEventInviteeStatusType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("INVITABLE")) {
            return INVITABLE;
        }
        if (str.equalsIgnoreCase("INVITABLE_FOF")) {
            return INVITABLE_FOF;
        }
        if (str.equalsIgnoreCase("INVITED")) {
            return INVITED;
        }
        if (str.equalsIgnoreCase("GOING")) {
            return GOING;
        }
        if (str.equalsIgnoreCase("MAYBE")) {
            return MAYBE;
        }
        if (str.equalsIgnoreCase("NOT_GOING")) {
            return NOT_GOING;
        }
        if (str.equalsIgnoreCase("REMOVED")) {
            return REMOVED;
        }
        if (str.equalsIgnoreCase("VIEWER_SELF")) {
            return VIEWER_SELF;
        }
        if (str.equalsIgnoreCase("OVER_LIMIT")) {
            return OVER_LIMIT;
        }
        if (str.equalsIgnoreCase("NOT_FRIEND")) {
            return NOT_FRIEND;
        }
        if (str.equalsIgnoreCase("NOT_GROUP_MEMBER")) {
            return NOT_GROUP_MEMBER;
        }
        if (str.equalsIgnoreCase("NOT_GROUP_FRIEND")) {
            return NOT_GROUP_FRIEND;
        }
        if (str.equalsIgnoreCase("HIDDEN_REASON")) {
            return HIDDEN_REASON;
        }
        if (str.equalsIgnoreCase("INELIGIBLE_FOR_EVENT")) {
            return INELIGIBLE_FOR_EVENT;
        }
        if (str.equalsIgnoreCase("SUBSCRIBED")) {
            return SUBSCRIBED;
        }
        if (str.equalsIgnoreCase("UNKNOWN")) {
            return UNKNOWN;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
