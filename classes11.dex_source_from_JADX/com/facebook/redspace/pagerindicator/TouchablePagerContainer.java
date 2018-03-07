package com.facebook.redspace.pagerindicator;

import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Preconditions;

/* compiled from: PageHeaderTag */
public class TouchablePagerContainer extends FrameLayout {
    public ViewPager f12164a;
    public ViewPager f12165b;
    public final Point f12166c = new Point();
    private GestureDetector f12167d;

    /* compiled from: PageHeaderTag */
    class C14471 extends SimpleOnPageChangeListener {
        final /* synthetic */ TouchablePagerContainer f12161a;

        C14471(TouchablePagerContainer touchablePagerContainer) {
            this.f12161a = touchablePagerContainer;
        }

        public final void m12606b(int i) {
            switch (i) {
                case 2:
                    this.f12161a.f12166c;
                    return;
                default:
                    this.f12161a.m12611b();
                    return;
            }
        }
    }

    /* compiled from: PageHeaderTag */
    class GestureListener extends SimpleOnGestureListener {
        final /* synthetic */ TouchablePagerContainer f12163a;

        /* compiled from: PageHeaderTag */
        class C14481 implements Runnable {
            final /* synthetic */ GestureListener f12162a;

            C14481(GestureListener gestureListener) {
                this.f12162a = gestureListener;
            }

            public void run() {
                this.f12162a.f12163a.m12611b();
                this.f12162a.f12163a.invalidate();
            }
        }

        public GestureListener(TouchablePagerContainer touchablePagerContainer) {
            this.f12163a = touchablePagerContainer;
        }

        public boolean onDown(MotionEvent motionEvent) {
            this.f12163a.f12166c.set((int) motionEvent.getX(), (int) motionEvent.getY());
            return true;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            int a = this.f12163a.m12607a((float) this.f12163a.f12166c.x, motionEvent.getX());
            if (a != 0) {
                motionEvent.setAction(3);
                a += this.f12163a.f12165b.k;
                this.f12163a.f12164a.a(a, true);
                this.f12163a.f12165b.a(a, false);
                this.f12163a.f12166c;
                this.f12163a.f12164a.postDelayed(new C14481(this), 600);
            }
            return true;
        }
    }

    public TouchablePagerContainer(Context context) {
        super(context);
        m12609a();
    }

    public TouchablePagerContainer(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m12609a();
    }

    public TouchablePagerContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12609a();
    }

    private void m12609a() {
        if (VERSION.SDK_INT <= 16) {
            setLayerType(1, null);
        }
        setClipChildren(false);
        setClipToPadding(false);
        this.f12167d = new GestureDetector(getContext(), new GestureListener(this), new Handler(Looper.getMainLooper()));
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1286341389);
        try {
            this.f12164a = (ViewPager) getChildAt(0);
            this.f12164a.setClipChildren(false);
            this.f12164a.setOnPageChangeListener(new C14471(this));
            super.onFinishInflate();
            LogUtils.g(711931818, a);
        } catch (Exception e) {
            IllegalStateException illegalStateException = new IllegalStateException("TouchablePagerContainer root view must be a ViewPager");
            LogUtils.g(412516373, a);
            throw illegalStateException;
        }
    }

    private int m12607a(float f, float f2) {
        int width = this.f12164a.getWidth();
        int width2 = getWidth();
        int i = (width2 - width) / 2;
        if (f < ((float) i) && f2 < ((float) i)) {
            return -((int) Math.ceil((double) ((((float) i) - f2) / ((float) width))));
        }
        width2 = (width2 + width) / 2;
        if (f <= ((float) width2) || f2 <= ((float) width2)) {
            return 0;
        }
        return (int) Math.ceil((double) ((f2 - ((float) width2)) / ((float) width)));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 979237001);
        Preconditions.checkNotNull(this.f12165b, "Master ViewPager must be set");
        this.f12167d.onTouchEvent(motionEvent);
        boolean dispatchTouchEvent = this.f12165b.dispatchTouchEvent(motionEvent);
        Logger.a(2, EntryType.UI_INPUT_END, 1875440547, a);
        return dispatchTouchEvent;
    }

    public ViewPager getMasterViewPager() {
        return this.f12165b;
    }

    public void setMasterViewPager(ViewPager viewPager) {
        this.f12165b = viewPager;
    }

    private void m12611b() {
        setEnabled(true);
    }

    public static void m12614c(TouchablePagerContainer touchablePagerContainer) {
        touchablePagerContainer.setEnabled(false);
    }
}
