package com.facebook.video.player;

/* compiled from: part */
public enum VideoSpecText$VideoSpecParam {
    SOURCE("Source"),
    CURRENT_STATE("Current State"),
    TARGET_STATE("Target State"),
    NEW_START_TIME("Stall Time"),
    VIDEO_MIME("Mime Type"),
    API_CONFIG("Api Config"),
    RELATED_VIDEO("Channels Eligibility"),
    NEW_PLAYER("New Player"),
    VIDEO_REUSE("Reuse"),
    STREAMING_FORMAT("Streaming Format"),
    DASH_STREAM("DASH Stream");
    
    public final String value;

    private VideoSpecText$VideoSpecParam(String str) {
        this.value = str;
    }
}
