package com.facebook.graphql.enums;

/* compiled from: media_invitation_after_edit_dialog */
public enum GraphQLBoostedPostAudienceOption {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    GROUPER,
    NCPP,
    CUSTOM_AUDIENCE,
    LOOKALIKE,
    ENGAGED,
    FANS,
    LOCAL,
    IG_PROMOTED_POST_AUTO,
    SAVED_AUDIENCE;

    public static GraphQLBoostedPostAudienceOption fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("GROUPER")) {
            return GROUPER;
        }
        if (str.equalsIgnoreCase("NCPP")) {
            return NCPP;
        }
        if (str.equalsIgnoreCase("CUSTOM_AUDIENCE")) {
            return CUSTOM_AUDIENCE;
        }
        if (str.equalsIgnoreCase("LOOKALIKE")) {
            return LOOKALIKE;
        }
        if (str.equalsIgnoreCase("ENGAGED")) {
            return ENGAGED;
        }
        if (str.equalsIgnoreCase("FANS")) {
            return FANS;
        }
        if (str.equalsIgnoreCase("LOCAL")) {
            return LOCAL;
        }
        if (str.equalsIgnoreCase("IG_PROMOTED_POST_AUTO")) {
            return IG_PROMOTED_POST_AUTO;
        }
        if (str.equalsIgnoreCase("SAVED_AUDIENCE")) {
            return SAVED_AUDIENCE;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
