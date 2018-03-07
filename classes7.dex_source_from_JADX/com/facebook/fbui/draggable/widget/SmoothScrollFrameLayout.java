package com.facebook.fbui.draggable.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.facebook.fbui.draggable.DefaultScrollDurationCalculator;
import com.facebook.fbui.draggable.SmoothLinearInterpolator;
import com.facebook.fbui.draggable.SmoothScroller;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: sprout_button_clicked */
public class SmoothScrollFrameLayout extends CustomFrameLayout {
    public Scroller f3541a;
    public DefaultScrollDurationCalculator f3542b;
    private boolean f3543c = false;

    public static void m4233a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        SmoothScrollFrameLayout smoothScrollFrameLayout = (SmoothScrollFrameLayout) obj;
        DefaultScrollDurationCalculator defaultScrollDurationCalculator = new DefaultScrollDurationCalculator((Context) fbInjector.getInstance(Context.class));
        Scroller scroller = (Scroller) new SmoothScroller((Context) fbInjector.getInstance(Context.class), (Interpolator) new SmoothLinearInterpolator());
        smoothScrollFrameLayout.f3542b = defaultScrollDurationCalculator;
        smoothScrollFrameLayout.f3541a = scroller;
    }

    public SmoothScrollFrameLayout(Context context) {
        super(context);
        mo166a();
    }

    public SmoothScrollFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo166a();
    }

    public SmoothScrollFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo166a();
    }

    private final void mo166a() {
        Class cls = SmoothScrollFrameLayout.class;
        m4233a((Object) this, getContext());
    }

    public final boolean m4236f() {
        return !this.f3541a.isFinished();
    }

    public final boolean m4237g() {
        if (!m4236f()) {
            return false;
        }
        this.f3541a.abortAnimation();
        return true;
    }

    public final void m4234a(int i, int i2) {
        int abs;
        m4237g();
        int scrollX = getScrollX();
        int i3 = i - scrollX;
        int scrollY = getScrollY();
        int i4 = i2 - scrollY;
        if (-1 < null) {
            abs = (int) (Math.abs((float) Math.max(Math.abs(i3), Math.abs(i4))) * this.f3542b.a);
        } else {
            abs = -1;
        }
        this.f3541a.startScroll(scrollX, scrollY, i3, i4, abs);
        invalidate();
    }

    public final void scrollTo(int i, int i2) {
        mo167a(i, i2, false);
    }

    protected void mo167a(int i, int i2, boolean z) {
        if (z) {
            this.f3543c = true;
            super.scrollTo(i, i2);
            this.f3543c = false;
            postInvalidate();
            return;
        }
        super.scrollTo(i, i2);
    }

    public void computeScroll() {
        if (this.f3541a.computeScrollOffset()) {
            int currX = this.f3541a.getCurrX();
            int currY = this.f3541a.getCurrY();
            if (currX == this.f3541a.getFinalX() && currY == this.f3541a.getFinalY()) {
                this.f3541a.abortAnimation();
            }
            mo167a(currX, currY, true);
        }
    }

    public void invalidate(Rect rect) {
        if (!this.f3543c) {
            super.invalidate(rect);
        }
    }

    public void invalidate(int i, int i2, int i3, int i4) {
        if (!this.f3543c) {
            super.invalidate(i, i2, i3, i4);
        }
    }

    public void invalidate() {
        if (!this.f3543c) {
            super.invalidate();
        }
    }
}
