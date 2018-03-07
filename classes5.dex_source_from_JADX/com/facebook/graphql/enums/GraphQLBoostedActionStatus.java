package com.facebook.graphql.enums;

/* compiled from: media_question_option_order */
public enum GraphQLBoostedActionStatus {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    INACTIVE,
    ACTIVE,
    PAUSED,
    FINISHED,
    REJECTED,
    PENDING,
    CREATING,
    ERROR;

    public static GraphQLBoostedActionStatus fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("INACTIVE")) {
            return INACTIVE;
        }
        if (str.equalsIgnoreCase("ACTIVE")) {
            return ACTIVE;
        }
        if (str.equalsIgnoreCase("PAUSED")) {
            return PAUSED;
        }
        if (str.equalsIgnoreCase("FINISHED")) {
            return FINISHED;
        }
        if (str.equalsIgnoreCase("REJECTED")) {
            return REJECTED;
        }
        if (str.equalsIgnoreCase("PENDING")) {
            return PENDING;
        }
        if (str.equalsIgnoreCase("CREATING")) {
            return CREATING;
        }
        if (str.equalsIgnoreCase("ERROR")) {
            return ERROR;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
