package com.facebook.zero.sdk.common;

/* compiled from: fonts/HelveticaNeue-Thin.ttf */
public enum TokenRequestReason {
    OPTIN("optin"),
    MESSENGE_CAP_OPTIN("message_cap_optin"),
    CARRIER_MANAGER("carrier_manager"),
    PUSH("token_push"),
    LOGIN("login"),
    HEADERS_REFRESH("headers"),
    MCCMNC_CHANGED("mccmnc_changed"),
    UNKNOWN_STATE("unknown_state"),
    TTL_EXPIRED("ttl_expired"),
    GATEKEEPER_CHANGED("gatekeeper_changed"),
    FACEWEB("faceweb"),
    FEED_PULL_TO_REFRESH("feed_pull_to_refresh"),
    UPSELL("upsell"),
    DEBUG("debug"),
    PREFETCH("prefetch"),
    GRAPHQL_VERIFICATION("debug_graphql_verification"),
    UNKNOWN_REASON("unknown_reason"),
    FREE_FACEBOOK_LAUNCH_PUSH("free_facebook_launch_push"),
    TOKEN_FETCH_FAILED_RETRY("token_fetch_failed_retry"),
    HEADER_PARAM_MISMATCH("header_param_mismatch");
    
    private final String mRequestString;

    private TokenRequestReason(String str) {
        this.mRequestString = str;
    }

    public static TokenRequestReason fromString(String str) {
        for (TokenRequestReason tokenRequestReason : values()) {
            if (tokenRequestReason.toString().equals(str)) {
                return tokenRequestReason;
            }
        }
        return UNKNOWN_REASON;
    }

    public final String getRequestString() {
        return this.mRequestString;
    }
}
