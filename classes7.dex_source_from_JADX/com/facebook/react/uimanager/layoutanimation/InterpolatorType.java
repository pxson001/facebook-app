package com.facebook.react.uimanager.layoutanimation;

/* compiled from: flyout_comments_edit_history_animation_perf */
enum InterpolatorType {
    LINEAR("linear"),
    EASE_IN("easeIn"),
    EASE_OUT("easeOut"),
    EASE_IN_EASE_OUT("easeInEaseOut"),
    SPRING("spring");
    
    private final String mName;

    private InterpolatorType(String str) {
        this.mName = str;
    }

    public static InterpolatorType fromString(String str) {
        for (InterpolatorType interpolatorType : values()) {
            if (interpolatorType.toString().equalsIgnoreCase(str)) {
                return interpolatorType;
            }
        }
        throw new IllegalArgumentException("Unsupported interpolation type : " + str);
    }

    public final String toString() {
        return this.mName;
    }
}
