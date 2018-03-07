package com.facebook.graphql.enums;

/* compiled from: localId */
public enum GraphQLRedirectionReason {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    REDIRECT_ROVI_PAGES_TO_MSITE,
    REDIRECT_WORLD_CUP_TO_WEB,
    REDIRECT_SPORTSDATA_TO_PERMALINK,
    REDIRECT_PAGE_TO_TOPIC,
    REDIRECT_EVENT_TO_EXTERNAL_URL,
    REDIRECT_PAGE_TO_BEST_PAGE,
    REDIRECT_GLOBAL_PAGE_TO_MARKET_PAGE,
    REDIRECT_WORK_PAGE_TO_HELP;

    public static GraphQLRedirectionReason fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("REDIRECT_ROVI_PAGES_TO_MSITE")) {
            return REDIRECT_ROVI_PAGES_TO_MSITE;
        }
        if (str.equalsIgnoreCase("REDIRECT_WORLD_CUP_TO_WEB")) {
            return REDIRECT_WORLD_CUP_TO_WEB;
        }
        if (str.equalsIgnoreCase("REDIRECT_SPORTSDATA_TO_PERMALINK")) {
            return REDIRECT_SPORTSDATA_TO_PERMALINK;
        }
        if (str.equalsIgnoreCase("REDIRECT_PAGE_TO_TOPIC")) {
            return REDIRECT_PAGE_TO_TOPIC;
        }
        if (str.equalsIgnoreCase("REDIRECT_EVENT_TO_EXTERNAL_URL")) {
            return REDIRECT_EVENT_TO_EXTERNAL_URL;
        }
        if (str.equalsIgnoreCase("REDIRECT_PAGE_TO_BEST_PAGE")) {
            return REDIRECT_PAGE_TO_BEST_PAGE;
        }
        if (str.equalsIgnoreCase("REDIRECT_GLOBAL_PAGE_TO_MARKET_PAGE")) {
            return REDIRECT_GLOBAL_PAGE_TO_MARKET_PAGE;
        }
        if (str.equalsIgnoreCase("REDIRECT_WORK_PAGE_TO_HELP")) {
            return REDIRECT_WORK_PAGE_TO_HELP;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
