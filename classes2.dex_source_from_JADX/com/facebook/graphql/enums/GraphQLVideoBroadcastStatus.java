package com.facebook.graphql.enums;

/* compiled from: is_action_send */
public enum GraphQLVideoBroadcastStatus {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    LEGACY,
    PREVIEW,
    LIVE,
    LIVE_STOPPED,
    VOD_READY,
    SEAL_STARTED,
    SCHEDULED;

    public static GraphQLVideoBroadcastStatus fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("LEGACY")) {
            return LEGACY;
        }
        if (str.equalsIgnoreCase("PREVIEW")) {
            return PREVIEW;
        }
        if (str.equalsIgnoreCase("LIVE")) {
            return LIVE;
        }
        if (str.equalsIgnoreCase("LIVE_STOPPED")) {
            return LIVE_STOPPED;
        }
        if (str.equalsIgnoreCase("VOD_READY")) {
            return VOD_READY;
        }
        if (str.equalsIgnoreCase("SEAL_STARTED")) {
            return SEAL_STARTED;
        }
        if (str.equalsIgnoreCase("SCHEDULED")) {
            return SCHEDULED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
