package com.facebook.graphql.enums;

/* compiled from: media_list */
public enum GraphQLBoostedComponentStatus {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    INACTIVE,
    DRAFT,
    PENDING,
    ACTIVE,
    PAUSED,
    REJECTED,
    FINISHED,
    EXTENDABLE,
    INSIGHTS,
    NO_CTA,
    CREATING,
    ERROR,
    PENDING_FUNDING_SOURCE;

    public static GraphQLBoostedComponentStatus fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("INACTIVE")) {
            return INACTIVE;
        }
        if (str.equalsIgnoreCase("DRAFT")) {
            return DRAFT;
        }
        if (str.equalsIgnoreCase("PENDING")) {
            return PENDING;
        }
        if (str.equalsIgnoreCase("ACTIVE")) {
            return ACTIVE;
        }
        if (str.equalsIgnoreCase("PAUSED")) {
            return PAUSED;
        }
        if (str.equalsIgnoreCase("REJECTED")) {
            return REJECTED;
        }
        if (str.equalsIgnoreCase("FINISHED")) {
            return FINISHED;
        }
        if (str.equalsIgnoreCase("EXTENDABLE")) {
            return EXTENDABLE;
        }
        if (str.equalsIgnoreCase("INSIGHTS")) {
            return INSIGHTS;
        }
        if (str.equalsIgnoreCase("NO_CTA")) {
            return NO_CTA;
        }
        if (str.equalsIgnoreCase("CREATING")) {
            return CREATING;
        }
        if (str.equalsIgnoreCase("ERROR")) {
            return ERROR;
        }
        if (str.equalsIgnoreCase("PENDING_FUNDING_SOURCE")) {
            return PENDING_FUNDING_SOURCE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
