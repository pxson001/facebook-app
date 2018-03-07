package com.facebook.redspace.pagerindicator;

import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import java.util.Map;

/* compiled from: PageLoadLastCard */
public class RatioAwareScroller implements OnPageChangeListener {
    private OnPageChangeListener f12138a;
    private ViewPager f12139b;
    public Map<ViewPager, Float> f12140c;
    private int f12141d = 0;
    private boolean f12142e;
    private int f12143f;

    public RatioAwareScroller(@Nullable OnPageChangeListener onPageChangeListener, ViewPager viewPager) {
        this.f12138a = onPageChangeListener;
        this.f12139b = viewPager;
        this.f12139b.setOnPageChangeListener(this);
        this.f12140c = new ArrayMap();
    }

    public final void m12580a(int i, float f, int i2) {
        if (this.f12138a != null) {
            this.f12138a.a(i, f, i2);
        }
        if (this.f12141d != 0) {
            Object obj;
            for (ViewPager viewPager : this.f12140c.keySet()) {
                if (viewPager.S) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj != null) {
                for (ViewPager viewPager2 : this.f12140c.keySet()) {
                    viewPager2.a((float) (viewPager2.getScrollX() - ((int) (((Float) this.f12140c.get(viewPager2)).floatValue() * ((float) this.f12139b.getScrollX())))));
                }
            }
        }
    }

    public final void e_(int i) {
        if (this.f12138a != null) {
            if (this.f12141d == 0) {
                this.f12138a.e_(i);
                this.f12142e = false;
            } else {
                this.f12142e = true;
            }
        }
        this.f12143f = i;
    }

    public final void m12581b(int i) {
        if (this.f12138a != null) {
            this.f12138a.b(i);
        }
        int i2 = this.f12141d;
        this.f12141d = i;
        switch (i) {
            case 0:
                m12579a();
                return;
            case 1:
                if (i2 != 0) {
                    m12579a();
                }
                for (ViewPager viewPager : this.f12140c.keySet()) {
                    if (!viewPager.S) {
                        viewPager.c();
                    }
                }
                return;
            default:
                return;
        }
    }

    private void m12579a() {
        for (ViewPager viewPager : this.f12140c.keySet()) {
            if (viewPager.S) {
                viewPager.d();
            }
        }
        if (this.f12142e) {
            if (this.f12138a != null) {
                this.f12138a.e_(this.f12143f);
            }
            this.f12142e = false;
        }
    }
}
