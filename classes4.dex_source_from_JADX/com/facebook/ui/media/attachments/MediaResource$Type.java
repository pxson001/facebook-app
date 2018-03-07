package com.facebook.ui.media.attachments;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

/* compiled from: mLayoutMode */
public enum MediaResource$Type {
    PHOTO("PHOTO"),
    VIDEO("VIDEO"),
    AUDIO("AUDIO"),
    OTHER("OTHER"),
    ENCRYPTED_PHOTO("ENCRYPTED_PHOTO"),
    ENT_PHOTO("ENT_PHOTO");
    
    private static final ImmutableMap<String, MediaResource$Type> VALUE_MAP = null;
    public final String DBSerialValue;

    static {
        Builder builder = ImmutableMap.builder();
        MediaResource$Type[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            MediaResource$Type mediaResource$Type = values[i];
            builder.b(mediaResource$Type.DBSerialValue, mediaResource$Type);
            i++;
        }
        VALUE_MAP = builder.b();
    }

    private MediaResource$Type(String str) {
        this.DBSerialValue = str;
    }

    public static MediaResource$Type fromDBSerialValue(String str) {
        if (VALUE_MAP.containsKey(str)) {
            return (MediaResource$Type) VALUE_MAP.get(str);
        }
        throw new IllegalArgumentException("Unsupported Type: " + str);
    }
}
