package com.facebook.react.touch;

import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import javax.annotation.Nullable;

/* compiled from: friendingButtonModel */
public class JSResponderHandler implements OnInterceptTouchEventListener {
    private volatile int f11705a = -1;
    @Nullable
    private ViewParent f11706b;

    public final void m13783a(int i, @Nullable ViewParent viewParent) {
        this.f11705a = i;
        m13781b();
        if (viewParent != null) {
            viewParent.requestDisallowInterceptTouchEvent(true);
            this.f11706b = viewParent;
        }
    }

    public final void m13782a() {
        this.f11705a = -1;
        m13781b();
    }

    private void m13781b() {
        if (this.f11706b != null) {
            this.f11706b.requestDisallowInterceptTouchEvent(false);
            this.f11706b = null;
        }
    }

    public final boolean mo732a(ViewGroup viewGroup, MotionEvent motionEvent) {
        int i = this.f11705a;
        if (i == -1 || motionEvent.getAction() == 1) {
            return false;
        }
        if (viewGroup.getId() == i) {
            return true;
        }
        return false;
    }
}
