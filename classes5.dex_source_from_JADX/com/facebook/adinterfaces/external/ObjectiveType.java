package com.facebook.adinterfaces.external;

import com.facebook.graphql.calls.BoostedComponentAppInputBoostedComponentApp;

/* compiled from: base_url */
public enum ObjectiveType {
    BOOST_POST(BoostedComponentAppInputBoostedComponentApp.BOOSTED_POST_MOBILE, "boosted_post"),
    BOOSTED_COMPONENT_BOOST_POST(BoostedComponentAppInputBoostedComponentApp.BOOSTED_POST_MOBILE, "boosted_post"),
    LOCAL_AWARENESS(BoostedComponentAppInputBoostedComponentApp.BOOSTED_LOCAL_AWARENESS_MOBILE),
    PROMOTE_WEBSITE(BoostedComponentAppInputBoostedComponentApp.BOOSTED_WEBSITE_MOBILE, "promoted_website"),
    PROMOTE_CTA(BoostedComponentAppInputBoostedComponentApp.BOOSTED_CCTA_MOBILE),
    PAGE_LIKE(BoostedComponentAppInputBoostedComponentApp.BOOSTED_PAGELIKE_MOBILE, "promoted_page"),
    PROMOTE_PRODUCT(BoostedComponentAppInputBoostedComponentApp.BOOSTED_PRODUCT_MOBILE),
    BOOST_EVENT(BoostedComponentAppInputBoostedComponentApp.BOOSTED_EVENT_MOBILE),
    BOOST_POST_INSIGHTS(BoostedComponentAppInputBoostedComponentApp.BOOSTED_POST_MOBILE),
    BOOST_POST_EDIT_TARGETING(null),
    BOOST_EVENT_EDIT_TARGETING(null),
    BOOSTED_COMPONENT_EDIT_TARGETING(null),
    BOOSTED_COMPONENT_EDIT_DURATION(null),
    BOOSTED_COMPONENT_EDIT_BUDGET(null),
    PAGE_LIKE_EDIT_CREATIVE(null),
    PROMOTE_WEBSITE_EDIT_CREATIVE(null),
    PROMOTE_CTA_EDIT_CREATIVE(null),
    LOCAL_AWARENESS_EDIT_CREATIVE(null),
    PAGE_LIKE_EDIT_RUNNING_CREATIVE(null);
    
    private BoostedComponentAppInputBoostedComponentApp mBoostedComponentApp;
    private final String mEntryPoint;

    private ObjectiveType(BoostedComponentAppInputBoostedComponentApp boostedComponentAppInputBoostedComponentApp) {
        this(r2, r3, boostedComponentAppInputBoostedComponentApp, "unknown");
    }

    private ObjectiveType(BoostedComponentAppInputBoostedComponentApp boostedComponentAppInputBoostedComponentApp, String str) {
        this.mBoostedComponentApp = boostedComponentAppInputBoostedComponentApp;
        this.mEntryPoint = str;
    }

    public final BoostedComponentAppInputBoostedComponentApp getComponentAppEnum() {
        return this.mBoostedComponentApp;
    }

    public final String getEntryPoint() {
        return this.mEntryPoint;
    }
}
