package com.facebook.messaging.threadview.hotlikes;

import com.facebook.common.util.MathUtil;

/* compiled from: com.facebook.Session */
public enum HotLikesSpringConfig {
    SMALL(0.24f, 3.0f, -1.0f, "369239263222822"),
    MEDIUM(0.56f, 5.0f, -2.0f, "369239343222814"),
    LARGE(1.0f, 7.0f, -3.0f, "369239383222810");
    
    public final float rotationVelocity;
    public final float sizeEndValue;
    public final float sizeVelocityIncrease;
    public final String stickerId;

    private HotLikesSpringConfig(float f, float f2, float f3, String str) {
        this.sizeEndValue = f;
        this.sizeVelocityIncrease = f2;
        this.rotationVelocity = f3;
        this.stickerId = str;
    }

    public static float convertSizeEndValueForHotEmojilikes(float f) {
        return MathUtil.a(f, SMALL.sizeEndValue, LARGE.sizeEndValue, SMALL.sizeEndValue, MEDIUM.sizeEndValue);
    }
}
