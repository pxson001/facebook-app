package com.facebook.goodwill.analytics;

/* compiled from: {rule} */
public enum GoodwillAnalyticsLogger$SubscriptionSource {
    THROWBACK_FEED_MENU("subscribe_menu"),
    THROWBACK_FEED_NUX_MEGAPHONE("nux_megaphone"),
    THROWBACK_FEED_EMPTY_STATE("nux_empty_state");
    
    public final String name;

    private GoodwillAnalyticsLogger$SubscriptionSource(String str) {
        this.name = str;
    }
}
