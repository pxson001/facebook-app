package com.facebook.ipc.composer.model;

@Deprecated
/* compiled from: TIMEOUT */
public enum ComposerType {
    STATUS("status"),
    SHARE("share"),
    RECOMMENDATION("recommendation"),
    SELL("sell"),
    LIFE_EVENT("life_event"),
    GREETING_CARD("greeting_card"),
    GOODWILL_CAMPAIGN("goodwill_campaign");
    
    public final String analyticsName;

    private ComposerType(String str) {
        this.analyticsName = str;
    }

    public final String toString() {
        return this.analyticsName;
    }
}
