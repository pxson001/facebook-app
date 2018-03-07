package com.facebook.graphql.enums;

/* compiled from: growth_friend_finder */
public enum GraphQLBoostedPostStatus {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    INACTIVE,
    ACTIVE,
    PAUSED,
    EXTENDABLE,
    FINISHED,
    REJECTED,
    PENDING,
    ERROR,
    PENDING_FUNDING_SOURCE,
    DRAFT,
    INSIGHTS,
    NO_CTA;

    public static GraphQLBoostedPostStatus fromString(String str) {
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
        if (str.equalsIgnoreCase("EXTENDABLE")) {
            return EXTENDABLE;
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
        if (str.equalsIgnoreCase("ERROR")) {
            return ERROR;
        }
        if (str.equalsIgnoreCase("PENDING_FUNDING_SOURCE")) {
            return PENDING_FUNDING_SOURCE;
        }
        if (str.equalsIgnoreCase("DRAFT")) {
            return DRAFT;
        }
        if (str.equalsIgnoreCase("INSIGHTS")) {
            return INSIGHTS;
        }
        if (str.equalsIgnoreCase("NO_CTA")) {
            return NO_CTA;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
