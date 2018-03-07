package com.facebook.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms.auth.GetToken */
public class ScrollingAwareScrollView extends ScrollView {
    public boolean f5771a = true;
    private final OnGestureListener f5772b = new C05271(this);
    private final GestureDetector f5773c = new GestureDetector(getContext(), this.f5772b);
    private final List<OnScrollListener> f5774d = new ArrayList();
    public GestureDetectorListener f5775e;

    /* compiled from: com.google.android.gms.auth.GetToken */
    class C05271 extends SimpleOnGestureListener {
        final /* synthetic */ ScrollingAwareScrollView f5770a;

        C05271(ScrollingAwareScrollView scrollingAwareScrollView) {
            this.f5770a = scrollingAwareScrollView;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (this.f5770a.f5775e != null) {
                this.f5770a.f5775e.m10535a(this.f5770a, motionEvent2, f);
            }
            return super.onScroll(motionEvent, motionEvent2, f, f2);
        }
    }

    /* compiled from: com.google.android.gms.auth.GetToken */
    public interface GestureDetectorListener {
        void m10534a(MotionEvent motionEvent);

        void m10535a(ScrollingAwareScrollView scrollingAwareScrollView, MotionEvent motionEvent, float f);
    }

    /* compiled from: com.google.android.gms.auth.GetToken */
    public interface OnScrollListener {
        void m10536a(int i, int i2);
    }

    public ScrollingAwareScrollView(Context context) {
        super(context);
    }

    public ScrollingAwareScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScrollingAwareScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setGestureListener(GestureDetectorListener gestureDetectorListener) {
        this.f5775e = gestureDetectorListener;
    }

    public void setScrollingEnabled(boolean z) {
        this.f5771a = z;
    }

    public final boolean m10539a() {
        return this.f5771a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1636534210);
        if (this.f5773c != null) {
            this.f5773c.onTouchEvent(motionEvent);
        }
        if ((motionEvent.getAction() == 3 || motionEvent.getAction() == 1) && this.f5775e != null) {
            this.f5775e.m10534a(motionEvent);
        }
        boolean onTouchEvent = this.f5771a ? super.onTouchEvent(motionEvent) : false;
        LogUtils.a(-1134501952, a);
        return onTouchEvent;
    }

    public final void m10538a(OnScrollListener onScrollListener) {
        this.f5774d.add(onScrollListener);
    }

    public final void m10540b(OnScrollListener onScrollListener) {
        this.f5774d.remove(onScrollListener);
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f5774d != null && !this.f5774d.isEmpty()) {
            for (int i5 = 0; i5 < this.f5774d.size(); i5++) {
                ((OnScrollListener) this.f5774d.get(i5)).m10536a(i2, i4);
            }
        }
    }
}
