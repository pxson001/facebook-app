package com.facebook.graphql.enums;

/* compiled from: initiatePreconfirmation */
public enum GraphQLFeedOptimisticPublishState {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    POSTING,
    RETRYING_IN_BACKGROUND,
    SUCCESS,
    OFFLINE,
    FAILED,
    TRANSCODING_FAILED,
    DELETED;

    public static GraphQLFeedOptimisticPublishState fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("POSTING")) {
            return POSTING;
        }
        if (str.equalsIgnoreCase("RETRYING_IN_BACKGROUND")) {
            return RETRYING_IN_BACKGROUND;
        }
        if (str.equalsIgnoreCase("SUCCESS")) {
            return SUCCESS;
        }
        if (str.equalsIgnoreCase("OFFLINE")) {
            return OFFLINE;
        }
        if (str.equalsIgnoreCase("FAILED")) {
            return FAILED;
        }
        if (str.equalsIgnoreCase("TRANSCODING_FAILED")) {
            return TRANSCODING_FAILED;
        }
        if (str.equalsIgnoreCase("DELETED")) {
            return DELETED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
