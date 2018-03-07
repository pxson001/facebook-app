package com.facebook.graphql.enums;

/* compiled from: mIsCurrent */
public enum GraphQLPYMACategory {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    BOOSTED_POST,
    BOOSTED_EVENT,
    PROMOTE_PAGE_LIKE,
    PROMOTE_WEBSITE_CLICK,
    PROMOTE_LOCAL_AWARENESS,
    PROMOTE_PAGE_CTA;

    public static GraphQLPYMACategory fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("BOOSTED_POST")) {
            return BOOSTED_POST;
        }
        if (str.equalsIgnoreCase("BOOSTED_EVENT")) {
            return BOOSTED_EVENT;
        }
        if (str.equalsIgnoreCase("PROMOTE_PAGE_LIKE")) {
            return PROMOTE_PAGE_LIKE;
        }
        if (str.equalsIgnoreCase("PROMOTE_WEBSITE_CLICK")) {
            return PROMOTE_WEBSITE_CLICK;
        }
        if (str.equalsIgnoreCase("PROMOTE_LOCAL_AWARENESS")) {
            return PROMOTE_LOCAL_AWARENESS;
        }
        if (str.equalsIgnoreCase("PROMOTE_PAGE_CTA")) {
            return PROMOTE_PAGE_CTA;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
