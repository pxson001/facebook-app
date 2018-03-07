package com.facebook.react.uimanager.layoutanimation;

/* compiled from: flyout_video_feedback_animation */
enum AnimatedPropertyType {
    OPACITY("opacity"),
    SCALE_XY("scaleXY");
    
    private final String mName;

    private AnimatedPropertyType(String str) {
        this.mName = str;
    }

    public static AnimatedPropertyType fromString(String str) {
        for (AnimatedPropertyType animatedPropertyType : values()) {
            if (animatedPropertyType.toString().equalsIgnoreCase(str)) {
                return animatedPropertyType;
            }
        }
        throw new IllegalArgumentException("Unsupported animated property : " + str);
    }

    public final String toString() {
        return this.mName;
    }
}
