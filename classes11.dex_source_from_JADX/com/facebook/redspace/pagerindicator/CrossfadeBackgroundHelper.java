package com.facebook.redspace.pagerindicator;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.MathUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: PageNewlyAddedEventsQuery */
public class CrossfadeBackgroundHelper implements OnPageChangeListener {
    private static final CallerContext f12130a = CallerContext.a(SwipeImagePageIndicator.class);
    private FbDraweeView f12131b;
    private FbDraweeView f12132c;
    private SwipeImagePagerAdapter f12133d;
    private int f12134e = -1;
    private int f12135f;
    private boolean f12136g = false;
    private int f12137h;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: PageNewlyAddedEventsQuery */
    public @interface SwipeDirection {
    }

    public CrossfadeBackgroundHelper(SwipeImagePagerAdapter swipeImagePagerAdapter, FbDraweeView fbDraweeView, FbDraweeView fbDraweeView2) {
        this.f12133d = swipeImagePagerAdapter;
        this.f12131b = fbDraweeView;
        this.f12132c = fbDraweeView2;
        this.f12132c.setVisibility(8);
    }

    public final void m12576a(int i, float f, int i2) {
        if (this.f12134e != i) {
            this.f12136g = true;
        }
        this.f12134e = i;
        if (this.f12137h == 0 || this.f12136g) {
            if (f < 0.5f) {
                this.f12137h = -1;
                m12574d(i + 1);
            } else {
                this.f12137h = 1;
                m12574d(i);
            }
            this.f12136g = false;
        }
        if (i2 == 0) {
            m12574d(i);
            m12578c(i);
        }
        switch (this.f12137h) {
            case -1:
                f = Math.abs(1.0f - f);
                break;
            case 1:
                break;
            default:
                f = 0.0f;
                break;
        }
        this.f12131b.setAlpha(MathUtil.b(f, 0.0f, 1.0f));
    }

    private void m12574d(int i) {
        if (m12575e(i)) {
            this.f12132c.a(this.f12133d.mo330c(i), f12130a);
        }
    }

    public final void e_(int i) {
        m12578c(i);
        this.f12135f = i;
    }

    public final void m12577b(int i) {
        boolean z = true;
        if (i == 0) {
            this.f12137h = 0;
            m12578c(this.f12135f);
            this.f12132c.setVisibility(8);
        } else {
            this.f12132c.setVisibility(0);
        }
        if (!(i == 1 && this.f12137h == 0)) {
            z = false;
        }
        this.f12136g = z;
    }

    public final void m12578c(int i) {
        if (m12575e(i)) {
            this.f12131b.a(this.f12133d.mo330c(i), f12130a);
            this.f12131b.setAlpha(1.0f);
            this.f12135f = i;
        }
    }

    private boolean m12575e(int i) {
        return i >= 0 && i < this.f12133d.mo328b();
    }
}
