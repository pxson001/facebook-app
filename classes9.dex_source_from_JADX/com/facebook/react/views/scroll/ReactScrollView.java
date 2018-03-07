package com.facebook.react.views.scroll;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;
import com.facebook.infer.annotation.Assertions;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.react.uimanager.MeasureSpecAssertions;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import com.facebook.react.views.view.ReactClippingViewGroup;
import com.facebook.react.views.view.ReactClippingViewGroupHelper;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.annotation.Nullable;

/* compiled from: back_camera */
public class ReactScrollView extends ScrollView implements ReactClippingViewGroup {
    private final OnScrollDispatchHelper f19079a;
    @Nullable
    private Rect f19080b;
    public boolean f19081c;
    private boolean f19082d;
    public boolean f19083e;
    private boolean f19084f;
    public boolean f19085g;
    public boolean f19086h;
    @Nullable
    private FpsListener f19087i;
    @Nullable
    public String f19088j;
    @Nullable
    private Drawable f19089k;
    private int f19090l;

    /* compiled from: back_camera */
    class C22491 implements Runnable {
        final /* synthetic */ ReactScrollView f19078a;

        C22491(ReactScrollView reactScrollView) {
            this.f19078a = reactScrollView;
        }

        public void run() {
            if (this.f19078a.f19081c) {
                this.f19078a.f19083e = false;
                ReactScrollView.m19053c(this.f19078a);
                ReactScrollViewHelper.m19064e(this.f19078a);
                return;
            }
            this.f19078a.f19081c = true;
            this.f19078a.postOnAnimationDelayed(this, 20);
        }
    }

    public ReactScrollView(Context context) {
        this(context, null);
    }

    public ReactScrollView(Context context, @Nullable FpsListener fpsListener) {
        super(context);
        this.f19079a = new OnScrollDispatchHelper();
        this.f19085g = true;
        this.f19087i = null;
        this.f19090l = 0;
        this.f19087i = fpsListener;
    }

    public void setSendMomentumEvents(boolean z) {
        this.f19086h = z;
    }

    public void setScrollPerfTag(String str) {
        this.f19088j = str;
    }

    public void setScrollEnabled(boolean z) {
        this.f19085g = z;
    }

    protected void onMeasure(int i, int i2) {
        MeasureSpecAssertions.a(i, i2);
        setMeasuredDimension(MeasureSpec.getSize(i), MeasureSpec.getSize(i2));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        scrollTo(getScrollX(), getScrollY());
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1625298251);
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f19084f) {
            m19055a();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1270583747, a);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 670490985);
        super.onAttachedToWindow();
        if (this.f19084f) {
            m19055a();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1464318912, a);
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f19079a.m19026a(i, i2)) {
            if (this.f19084f) {
                m19055a();
            }
            if (this.f19083e) {
                this.f19081c = false;
            }
            ReactScrollViewHelper.m19059a(this);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f19085g || !super.onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        NativeGestureUtil.a(this, motionEvent);
        ReactScrollViewHelper.m19061b(this);
        this.f19082d = true;
        m19050b();
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1393234498);
        if (this.f19085g) {
            if ((motionEvent.getAction() & 255) == 1 && this.f19082d) {
                ReactScrollViewHelper.m19062c(this);
                this.f19082d = false;
                m19053c(this);
            }
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            LogUtils.a(-1648213983, a);
            return onTouchEvent;
        }
        Logger.a(2, EntryType.UI_INPUT_END, 631435889, a);
        return false;
    }

    public void setRemoveClippedSubviews(boolean z) {
        if (z && this.f19080b == null) {
            this.f19080b = new Rect();
        }
        this.f19084f = z;
        m19055a();
    }

    public boolean getRemoveClippedSubviews() {
        return this.f19084f;
    }

    public final void m19055a() {
        if (this.f19084f) {
            Assertions.b(this.f19080b);
            ReactClippingViewGroupHelper.a(this, this.f19080b);
            View childAt = getChildAt(0);
            if (childAt instanceof ReactClippingViewGroup) {
                ((ReactClippingViewGroup) childAt).a();
            }
        }
    }

    public final void m19056a(Rect rect) {
        rect.set((Rect) Assertions.b(this.f19080b));
    }

    public void fling(int i) {
        super.fling(i);
        if (this.f19086h || m19054d()) {
            this.f19083e = true;
            m19050b();
            ReactScrollViewHelper.m19063d(this);
            postOnAnimationDelayed(new C22491(this), 20);
        }
    }

    private void m19050b() {
        if (m19054d()) {
            Assertions.b(this.f19087i);
            Assertions.b(this.f19088j);
            this.f19087i.mo274a(this.f19088j);
        }
    }

    public static void m19053c(ReactScrollView reactScrollView) {
        if (reactScrollView.m19054d()) {
            Assertions.b(reactScrollView.f19087i);
            Assertions.b(reactScrollView.f19088j);
            reactScrollView.f19087i.mo275b(reactScrollView.f19088j);
        }
    }

    private boolean m19054d() {
        return (this.f19087i == null || this.f19088j == null || this.f19088j.isEmpty()) ? false : true;
    }

    public void draw(Canvas canvas) {
        if (this.f19090l != 0) {
            View childAt = getChildAt(0);
            if (!(this.f19089k == null || childAt == null || childAt.getBottom() >= getHeight())) {
                this.f19089k.setBounds(0, childAt.getBottom(), getWidth(), getHeight());
                this.f19089k.draw(canvas);
            }
        }
        super.draw(canvas);
    }

    public void setEndFillColor(int i) {
        if (i != this.f19090l) {
            this.f19090l = i;
            this.f19089k = new ColorDrawable(this.f19090l);
        }
    }
}
