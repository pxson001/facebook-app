package com.facebook.adinterfaces.external.logging;

/* compiled from: base64 */
public enum AdInterfacesExternalLogger$BoostedComponentModule {
    BOOSTED_POST_MOBILE_MODULE("boosted_post_mobile"),
    BOOSTED_EVENT_MOBILE_MODULE("boosted_event_mobile"),
    PROMOTE_PAGE_MOBILE_MODULE("boosted_page_like_mobile");
    
    private final String module;

    private AdInterfacesExternalLogger$BoostedComponentModule(String str) {
        this.module = str;
    }

    public final String toString() {
        return this.module;
    }
}
