package com.facebook.messaging.model.send;

/* compiled from: upload_enabled/ */
public enum PendingSendQueueType {
    NORMAL("n"),
    VIDEO("v"),
    PHOTO("p"),
    LIGHT_MEDIA("l");
    
    public final String serializedValue;

    private PendingSendQueueType(String str) {
        this.serializedValue = str;
    }
}
