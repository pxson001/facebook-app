package com.facebook.graphql.enums;

/* compiled from: link_caption */
public enum GraphQLVideoChannelFeedUnitPruneBehavior {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    NONE,
    NON_LIVE,
    SEAL;

    public static GraphQLVideoChannelFeedUnitPruneBehavior fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("NONE")) {
            return NONE;
        }
        if (str.equalsIgnoreCase("NON_LIVE")) {
            return NON_LIVE;
        }
        if (str.equalsIgnoreCase("SEAL")) {
            return SEAL;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
