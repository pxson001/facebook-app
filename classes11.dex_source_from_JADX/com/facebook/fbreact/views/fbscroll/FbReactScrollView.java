package com.facebook.fbreact.views.fbscroll;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.infer.annotation.Assertions;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.react.uimanager.MeasureSpecAssertions;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import com.facebook.react.views.scroll.FpsListener;
import com.facebook.react.views.scroll.OnScrollDispatchHelper;
import com.facebook.react.views.scroll.ReactScrollViewHelper;
import com.facebook.react.views.view.ReactClippingViewGroup;
import com.facebook.react.views.view.ReactClippingViewGroupHelper;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.annotation.Nullable;

/* compiled from: event/ */
public class FbReactScrollView extends BugFixScrollView implements ReactClippingViewGroup {
    private final OnScrollDispatchHelper f7438a = new OnScrollDispatchHelper();
    public boolean f7439b;
    @Nullable
    public Rect f7440c;
    public boolean f7441d;
    private boolean f7442e;
    public boolean f7443f;
    public boolean f7444g;
    public boolean f7445h = true;
    @Nullable
    private FpsListener f7446i = null;
    @Nullable
    public String f7447j;
    @Nullable
    public Drawable f7448k;
    public int f7449l = 0;

    /* compiled from: event/ */
    class C09471 implements Runnable {
        final /* synthetic */ FbReactScrollView f7480a;

        C09471(FbReactScrollView fbReactScrollView) {
            this.f7480a = fbReactScrollView;
        }

        public void run() {
            if (this.f7480a.f7444g) {
                this.f7480a.f7443f = false;
                FbReactScrollView.m8630c(this.f7480a);
                ReactScrollViewHelper.e(this.f7480a);
                return;
            }
            this.f7480a.f7444g = true;
            this.f7480a.postOnAnimationDelayed(this, 20);
        }
    }

    public FbReactScrollView(Context context, FpsListener fpsListener) {
        super(context);
        this.f7446i = fpsListener;
    }

    protected void onMeasure(int i, int i2) {
        MeasureSpecAssertions.a(i, i2);
        setMeasuredDimension(MeasureSpec.getSize(i), MeasureSpec.getSize(i2));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        scrollTo(getScrollX(), getScrollY());
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -926325439);
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f7439b) {
            m8632a();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -214371491, a);
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f7438a.a(i, i2)) {
            if (this.f7439b) {
                m8632a();
            }
            if (this.f7443f) {
                this.f7444g = false;
            }
            ReactScrollViewHelper.a(this);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f7445h || !super.onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        NativeGestureUtil.a(this, motionEvent);
        ReactScrollViewHelper.b(this);
        this.f7442e = true;
        m8629b();
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -2037453652);
        if (this.f7445h) {
            if ((motionEvent.getAction() & 255) == 1 && this.f7442e) {
                ReactScrollViewHelper.c(this);
                this.f7442e = false;
                m8630c(this);
            }
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            LogUtils.a(491218219, a);
            return onTouchEvent;
        }
        Logger.a(2, EntryType.UI_INPUT_END, 1023645227, a);
        return false;
    }

    public boolean getRemoveClippedSubviews() {
        return this.f7439b;
    }

    public final void m8632a() {
        if (this.f7439b) {
            Assertions.b(this.f7440c);
            ReactClippingViewGroupHelper.a(this, this.f7440c);
            View childAt = getChildAt(0);
            if (childAt instanceof ReactClippingViewGroup) {
                ((ReactClippingViewGroup) childAt).a();
            }
        }
    }

    public final void mo223a(Rect rect) {
        rect.set((Rect) Assertions.b(this.f7440c));
    }

    public final void mo222a(int i) {
        super.mo222a(i);
        if (this.f7441d || m8631d()) {
            this.f7443f = true;
            m8629b();
            ReactScrollViewHelper.d(this);
            postOnAnimationDelayed(new C09471(this), 20);
        }
    }

    private void m8629b() {
        if (m8631d()) {
            this.f7446i.a(this.f7447j);
        }
    }

    public static void m8630c(FbReactScrollView fbReactScrollView) {
        if (fbReactScrollView.m8631d()) {
            fbReactScrollView.f7446i.b(fbReactScrollView.f7447j);
        }
    }

    private boolean m8631d() {
        return (this.f7446i == null || this.f7447j == null || this.f7447j.isEmpty()) ? false : true;
    }

    public void draw(Canvas canvas) {
        if (this.f7449l != 0) {
            View childAt = getChildAt(0);
            if (!(this.f7448k == null || childAt == null || childAt.getBottom() >= getHeight())) {
                this.f7448k.setBounds(0, childAt.getBottom(), getWidth(), getHeight());
                this.f7448k.draw(canvas);
            }
        }
        super.draw(canvas);
    }
}
