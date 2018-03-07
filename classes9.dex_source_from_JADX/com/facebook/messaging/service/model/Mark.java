package com.facebook.messaging.service.model;

/* compiled from: contentsearch */
public enum Mark {
    READ("read"),
    ARCHIVED("archived"),
    SPAM("spam");
    
    private String apiName;

    private Mark(String str) {
        this.apiName = str;
    }

    public final String getApiName() {
        return this.apiName;
    }
}
