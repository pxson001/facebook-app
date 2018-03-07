package com.facebook.react.views.swiperefresh;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.MotionEvent;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.events.NativeGestureUtil;

/* compiled from: RefHandOff */
public class ReactSwipeRefreshLayout extends SwipeRefreshLayout {
    private boolean f11505c = false;
    private boolean f11506d = false;
    private float f11507e = 0.0f;

    public ReactSwipeRefreshLayout(ReactContext reactContext) {
        super(reactContext);
    }

    public void setRefreshing(boolean z) {
        this.f11506d = z;
        if (this.f11505c) {
            super.setRefreshing(z);
        }
    }

    public void setProgressViewOffset(float f) {
        this.f11507e = f;
        if (this.f11505c) {
            int progressCircleDiameter = getProgressCircleDiameter();
            a(false, Math.round(PixelUtil.a(f)) - progressCircleDiameter, Math.round(PixelUtil.a(64.0f + f) - ((float) progressCircleDiameter)));
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.f11505c) {
            this.f11505c = true;
            setProgressViewOffset(this.f11507e);
            setRefreshing(this.f11506d);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!super.onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        NativeGestureUtil.a(this, motionEvent);
        return true;
    }
}
