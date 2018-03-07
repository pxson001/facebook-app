package com.facebook.crowdsourcing.enums;

/* compiled from: com.nokia.pushnotifications.intent.REGISTER */
public enum CrowdsourcingFieldType {
    PAGE_PHONE(137075966484179L),
    PLACE_ADDRESS(337046403064701L),
    PLACE_TOPIC(333522400104087L);
    
    private long value;

    private CrowdsourcingFieldType(long j) {
        this.value = j;
    }

    public final long getValue() {
        return this.value;
    }
}
