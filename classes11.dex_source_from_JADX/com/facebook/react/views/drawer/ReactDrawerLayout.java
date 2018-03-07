package com.facebook.react.views.drawer;

import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.LayoutParams;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.events.NativeGestureUtil;

/* compiled from: SEE_ALL_FOOTER */
class ReactDrawerLayout extends DrawerLayout {
    private int f11430b = 8388611;
    private int f11431c = -1;

    public ReactDrawerLayout(ReactContext reactContext) {
        super(reactContext);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!super.onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        NativeGestureUtil.a(this, motionEvent);
        return true;
    }

    final void m11803d() {
        c(this.f11430b);
    }

    final void m11804e() {
        d(this.f11430b);
    }

    final void m11805e(int i) {
        this.f11430b = i;
        m11806f();
    }

    final void m11807f(int i) {
        this.f11431c = i;
        m11806f();
    }

    final void m11806f() {
        if (getChildCount() == 2) {
            View childAt = getChildAt(1);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            layoutParams.a = this.f11430b;
            layoutParams.width = this.f11431c;
            childAt.setLayoutParams(layoutParams);
            childAt.setClickable(true);
        }
    }
}
