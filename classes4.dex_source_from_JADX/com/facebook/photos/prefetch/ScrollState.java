package com.facebook.photos.prefetch;

import com.google.common.base.Preconditions;

/* compiled from: proximity */
public enum ScrollState {
    IDLE,
    TOUCH_SCROLL,
    FLING;

    public static ScrollState getFromListViewScrollState(int i) {
        Object obj = null;
        switch (i) {
            case 0:
                obj = IDLE;
                break;
            case 1:
                obj = TOUCH_SCROLL;
                break;
            case 2:
                obj = FLING;
                break;
        }
        return (ScrollState) Preconditions.checkNotNull(obj);
    }
}
