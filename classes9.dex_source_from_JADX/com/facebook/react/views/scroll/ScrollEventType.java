package com.facebook.react.views.scroll;

/* compiled from: b942005d8057b6b3245545645217cbd6 */
public enum ScrollEventType {
    BEGIN_DRAG("topScrollBeginDrag"),
    END_DRAG("topScrollEndDrag"),
    SCROLL("topScroll"),
    MOMENTUM_BEGIN("topMomentumScrollBegin"),
    MOMENTUM_END("topMomentumScrollEnd"),
    ANIMATION_END("topScrollAnimationEnd");
    
    private final String mJSEventName;

    private ScrollEventType(String str) {
        this.mJSEventName = str;
    }

    public final String getJSEventName() {
        return this.mJSEventName;
    }
}
