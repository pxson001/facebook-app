package com.facebook.react.views.scroll;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.HorizontalScrollView;
import com.facebook.infer.annotation.Assertions;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.react.uimanager.MeasureSpecAssertions;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import com.facebook.react.views.view.ReactClippingViewGroup;
import com.facebook.react.views.view.ReactClippingViewGroupHelper;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.annotation.Nullable;

/* compiled from: backstage */
public class ReactHorizontalScrollView extends HorizontalScrollView implements ReactClippingViewGroup {
    private final OnScrollDispatchHelper f19064a = new OnScrollDispatchHelper();
    public boolean f19065b;
    @Nullable
    private Rect f19066c;
    private boolean f19067d;
    public boolean f19068e = false;
    @Nullable
    public Runnable f19069f;
    private boolean f19070g;
    public boolean f19071h = true;
    public boolean f19072i;
    @Nullable
    private FpsListener f19073j = null;
    @Nullable
    public String f19074k;
    @Nullable
    private Drawable f19075l;
    private int f19076m = 0;

    /* compiled from: backstage */
    class C22481 implements Runnable {
        final /* synthetic */ ReactHorizontalScrollView f19062a;
        private boolean f19063b = false;

        C22481(ReactHorizontalScrollView reactHorizontalScrollView) {
            this.f19062a = reactHorizontalScrollView;
        }

        public void run() {
            boolean z = false;
            if (this.f19062a.f19065b) {
                this.f19062a.f19065b = false;
            } else {
                if (!this.f19062a.f19068e || this.f19063b) {
                    z = true;
                } else {
                    this.f19063b = true;
                    this.f19062a.m19028a(0);
                }
                if (z) {
                    if (this.f19062a.f19072i) {
                        ReactScrollViewHelper.m19064e(this.f19062a);
                    }
                    this.f19062a.f19069f = null;
                    ReactHorizontalScrollView.m19034c(this.f19062a);
                    return;
                }
            }
            this.f19062a.postOnAnimationDelayed(this, 20);
        }
    }

    public ReactHorizontalScrollView(Context context, @Nullable FpsListener fpsListener) {
        super(context);
        this.f19073j = fpsListener;
    }

    public void setScrollPerfTag(@Nullable String str) {
        this.f19074k = str;
    }

    public void setRemoveClippedSubviews(boolean z) {
        if (z && this.f19066c == null) {
            this.f19066c = new Rect();
        }
        this.f19070g = z;
        m19039a();
    }

    public boolean getRemoveClippedSubviews() {
        return this.f19070g;
    }

    public void setSendMomentumEvents(boolean z) {
        this.f19072i = z;
    }

    public void setScrollEnabled(boolean z) {
        this.f19071h = z;
    }

    public void setPagingEnabled(boolean z) {
        this.f19068e = z;
    }

    protected void onMeasure(int i, int i2) {
        MeasureSpecAssertions.a(i, i2);
        setMeasuredDimension(MeasureSpec.getSize(i), MeasureSpec.getSize(i2));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        scrollTo(getScrollX(), getScrollY());
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f19064a.m19026a(i, i2)) {
            if (this.f19070g) {
                m19039a();
            }
            this.f19065b = true;
            ReactScrollViewHelper.m19059a(this);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f19071h || !super.onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        NativeGestureUtil.a(this, motionEvent);
        ReactScrollViewHelper.m19061b(this);
        this.f19067d = true;
        m19032b();
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1057741643);
        if (this.f19071h) {
            if ((motionEvent.getAction() & 255) == 1 && this.f19067d) {
                ReactScrollViewHelper.m19062c(this);
                this.f19067d = false;
                m19038e();
            }
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            LogUtils.a(380229871, a);
            return onTouchEvent;
        }
        Logger.a(2, EntryType.UI_INPUT_END, 1008481836, a);
        return false;
    }

    public void fling(int i) {
        if (this.f19068e) {
            m19028a(i);
        } else {
            super.fling(i);
        }
        m19038e();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 40050644);
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f19070g) {
            m19039a();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -2071627398, a);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -818833530);
        super.onAttachedToWindow();
        if (this.f19070g) {
            m19039a();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1295617610, a);
    }

    public final void m19039a() {
        if (this.f19070g) {
            Assertions.b(this.f19066c);
            ReactClippingViewGroupHelper.a(this, this.f19066c);
            View childAt = getChildAt(0);
            if (childAt instanceof ReactClippingViewGroup) {
                ((ReactClippingViewGroup) childAt).a();
            }
        }
    }

    public final void m19040a(Rect rect) {
        rect.set((Rect) Assertions.b(this.f19066c));
    }

    public void setEndFillColor(int i) {
        if (i != this.f19076m) {
            this.f19076m = i;
            this.f19075l = new ColorDrawable(this.f19076m);
        }
    }

    private void m19032b() {
        if (m19037d()) {
            Assertions.b(this.f19073j);
            Assertions.b(this.f19074k);
            this.f19073j.mo274a(this.f19074k);
        }
    }

    public static void m19034c(ReactHorizontalScrollView reactHorizontalScrollView) {
        if (reactHorizontalScrollView.m19037d()) {
            Assertions.b(reactHorizontalScrollView.f19073j);
            Assertions.b(reactHorizontalScrollView.f19074k);
            reactHorizontalScrollView.f19073j.mo275b(reactHorizontalScrollView.f19074k);
        }
    }

    private boolean m19037d() {
        return (this.f19073j == null || this.f19074k == null || this.f19074k.isEmpty()) ? false : true;
    }

    public void draw(Canvas canvas) {
        if (this.f19076m != 0) {
            View childAt = getChildAt(0);
            if (!(this.f19075l == null || childAt == null || childAt.getRight() >= getWidth())) {
                this.f19075l.setBounds(childAt.getRight(), 0, getWidth(), getHeight());
                this.f19075l.draw(canvas);
            }
        }
        super.draw(canvas);
    }

    @TargetApi(16)
    private void m19038e() {
        if ((this.f19072i || this.f19068e || m19037d()) && this.f19069f == null) {
            if (this.f19072i) {
                ReactScrollViewHelper.m19063d(this);
            }
            this.f19065b = false;
            this.f19069f = new C22481(this);
            postOnAnimationDelayed(this.f19069f, 20);
        }
    }

    private void m19028a(int i) {
        int width = getWidth();
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        scrollX /= width;
        if (i2 > (scrollX * width) + (width / 2)) {
            scrollX++;
        }
        smoothScrollTo(scrollX * width, getScrollY());
    }
}
