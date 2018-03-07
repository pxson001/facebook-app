package com.facebook.video.engine;

/* compiled from: composer_transliterate_click */
public enum VideoPlayer$VideoSourceType {
    VIDEO_SOURCE_HLS("hls"),
    VIDEO_SOURCE_RTMP("rtmp"),
    VIDEO_SOURCE_INVALID("invalid");
    
    public final String value;

    private VideoPlayer$VideoSourceType(String str) {
        this.value = str;
    }
}
