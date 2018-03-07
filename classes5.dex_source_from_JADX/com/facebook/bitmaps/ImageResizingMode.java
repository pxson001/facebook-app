package com.facebook.bitmaps;

/* compiled from: android.wearable.EXTENSIONS */
public enum ImageResizingMode {
    JAVA_RESIZER("false"),
    NATIVE_JT_13("jt13");
    
    private final String name;

    private ImageResizingMode(String str) {
        this.name = str;
    }

    public final String toString() {
        return this.name;
    }
}
