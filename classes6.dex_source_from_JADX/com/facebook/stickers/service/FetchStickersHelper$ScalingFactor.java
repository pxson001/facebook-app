package com.facebook.stickers.service;

/* compiled from: eb04c61de96ecfc74ef6c3fbcb876241 */
enum FetchStickersHelper$ScalingFactor {
    MDPI(1.0f, "1"),
    HDPI(1.5f, "1.5"),
    XHDPI(2.0f, "2");
    
    public final float numericValue;
    public final String stringValue;

    private FetchStickersHelper$ScalingFactor(float f, String str) {
        this.numericValue = f;
        this.stringValue = str;
    }
}
