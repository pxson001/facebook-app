package com.facebook.widget;

import android.content.Context;
import android.os.SystemClock;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.facebook.fbui.draggable.Direction;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: o_calling_class */
public class ListViewFriendlyViewPager extends CustomViewPager {
    private int f6350a;
    private int f6351b;
    private boolean f6352c;
    private int f6353d;
    private int f6354e;
    private long f6355f = 0;
    private boolean f6356g = false;
    private boolean f6357h = false;

    public ListViewFriendlyViewPager(Context context) {
        super(context);
        m6828a(context);
    }

    public ListViewFriendlyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6828a(context);
    }

    private void m6828a(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f6350a = viewConfiguration.getScaledTouchSlop();
        this.f6351b = ViewConfigurationCompat.a(viewConfiguration);
        this.f6352c = false;
    }

    private boolean m6829h() {
        PagerAdapter adapter = getAdapter();
        return adapter != null && adapter.b() > 0;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!m6829h()) {
            return false;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        this.f6357h = onInterceptTouchEvent;
        if (!onInterceptTouchEvent) {
            return onInterceptTouchEvent;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        return onInterceptTouchEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1201210035);
        if (!m6829h()) {
            Logger.a(2, EntryType.UI_INPUT_END, 1349781233, a);
            return false;
        } else if (!this.f6357h) {
            onInterceptTouchEvent(motionEvent);
            LogUtils.a(-36310695, a);
            return true;
        } else if (!super.onTouchEvent(motionEvent)) {
            getParent().requestDisallowInterceptTouchEvent(false);
            LogUtils.a(489113008, a);
            return false;
        } else if (this.f6356g) {
            switch (motionEvent.getAction()) {
                case 0:
                    LogUtils.a(-256714957, a);
                    return true;
                case 2:
                    getParent().requestDisallowInterceptTouchEvent(true);
                    LogUtils.a(1694783841, a);
                    return true;
                default:
                    getParent().requestDisallowInterceptTouchEvent(false);
                    LogUtils.a(-861961426, a);
                    return false;
            }
        } else {
            switch (motionEvent.getAction()) {
                case 0:
                    this.f6353d = (int) motionEvent.getRawX();
                    this.f6354e = (int) motionEvent.getRawY();
                    this.f6352c = true;
                    LogUtils.a(-554832805, a);
                    return true;
                case 2:
                    if (this.f6352c) {
                        int abs = Math.abs(((int) motionEvent.getRawX()) - this.f6353d);
                        int abs2 = Math.abs(((int) motionEvent.getRawY()) - this.f6354e);
                        if (abs > abs2 && abs > this.f6351b) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                            LogUtils.a(820528612, a);
                            return true;
                        } else if (abs2 <= abs || abs2 <= this.f6350a) {
                            LogUtils.a(1169949360, a);
                            return true;
                        } else {
                            getParent().requestDisallowInterceptTouchEvent(false);
                            LogUtils.a(907090409, a);
                            return false;
                        }
                    }
                    this.f6352c = true;
                    this.f6353d = (int) motionEvent.getRawX();
                    this.f6354e = (int) motionEvent.getRawY();
                    LogUtils.a(-419013890, a);
                    return true;
                default:
                    this.f6352c = false;
                    if (getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    LogUtils.a(-991446734, a);
                    return false;
            }
        }
    }

    public void scrollTo(int i, int i2) {
        if (getScrollX() != i) {
            this.f6355f = SystemClock.uptimeMillis();
        }
        super.scrollTo(i, i2);
    }

    public final boolean m6830a(Direction direction, int i, int i2) {
        PagerAdapter adapter = getAdapter();
        if (adapter == null) {
            return false;
        }
        if (SystemClock.uptimeMillis() - this.f6355f <= 1000) {
            return true;
        }
        int i3 = this.k;
        switch (1.a[direction.ordinal()]) {
            case 1:
                if (i3 > 0) {
                    return true;
                }
                return false;
            case 2:
                if (i3 < adapter.b() - 1) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    public final void m6831g() {
        this.f6356g = true;
    }
}
