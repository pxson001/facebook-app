package com.facebook.react.uimanager.events;

/* compiled from: fontScale */
public enum TouchEventType {
    START("topTouchStart"),
    END("topTouchEnd"),
    MOVE("topTouchMove"),
    CANCEL("topTouchCancel");
    
    private final String mJSEventName;

    private TouchEventType(String str) {
        this.mJSEventName = str;
    }

    public final String getJSEventName() {
        return this.mJSEventName;
    }
}
