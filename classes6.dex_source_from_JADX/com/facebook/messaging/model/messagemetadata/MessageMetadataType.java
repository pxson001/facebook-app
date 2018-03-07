package com.facebook.messaging.model.messagemetadata;

import com.google.common.base.Objects;

/* compiled from: url_attachment_length */
public enum MessageMetadataType {
    NONE(""),
    TIMESTAMP("timestamp"),
    WATCH_MOVIE("watch_movie");
    
    public final String value;

    private MessageMetadataType(String str) {
        this.value = str;
    }

    public static MessageMetadataType fromRawValue(String str) {
        for (MessageMetadataType messageMetadataType : values()) {
            if (Objects.equal(messageMetadataType.value, str)) {
                return messageMetadataType;
            }
        }
        return NONE;
    }
}
