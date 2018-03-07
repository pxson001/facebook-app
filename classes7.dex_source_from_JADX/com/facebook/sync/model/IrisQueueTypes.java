package com.facebook.sync.model;

/* compiled from: feed_friendable_header_add */
public enum IrisQueueTypes {
    MESSAGES_QUEUE_TYPE("m"),
    CONTACTS_QUEUE_TYPE("c"),
    VOIP_QUEUE_TYPE("v"),
    PAYMENTS_QUEUE_TYPE("p2p");
    
    public final String apiString;

    private IrisQueueTypes(String str) {
        this.apiString = str;
    }
}
