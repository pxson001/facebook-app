package com.facebook.videocodec.base;

/* compiled from: reviews_feed_header_load_failure */
public enum VideoCodecOpenGlColorFormat {
    RGBA("rgba", 6408),
    BGRA("bgra", 32993);
    
    public final int openGlConstant;
    public final String openGlString;

    private VideoCodecOpenGlColorFormat(String str, int i) {
        this.openGlString = str;
        this.openGlConstant = i;
    }
}
