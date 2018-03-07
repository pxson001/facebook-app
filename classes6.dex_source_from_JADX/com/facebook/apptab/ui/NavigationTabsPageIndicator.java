package com.facebook.apptab.ui;

import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.facebook.common.util.ContextUtils;
import com.facebook.view.ControlledView;
import com.facebook.view.ViewController;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.viewpageindicator.PageIndicator;
import com.google.common.base.Preconditions;

/* compiled from: promoExpiry */
public class NavigationTabsPageIndicator extends ViewController implements PageIndicator {
    public ViewPager f7208b;
    public OnPageChangeListener f7209c;
    private int f7210d;
    public int f7211e;
    public float f7212f;
    public boolean f7213g;
    private final Runnable f7214h = new C04231(this);

    /* compiled from: promoExpiry */
    class C04231 implements Runnable {
        final /* synthetic */ NavigationTabsPageIndicator f7206a;

        C04231(NavigationTabsPageIndicator navigationTabsPageIndicator) {
            this.f7206a = navigationTabsPageIndicator;
        }

        public void run() {
            int i;
            Preconditions.checkState(this.f7206a.f7213g);
            this.f7206a.f7213g = false;
            ViewController viewController = this.f7206a;
            ViewParent parent = viewController.f7207a.getParent();
            if (parent == null || viewController.f7208b == null || viewController.f7208b.getAdapter() == null) {
                i = 0;
            } else {
                i = ((View) parent).getWidth() / viewController.f7208b.getAdapter().b();
            }
            int i2 = i;
            if (this.f7206a.f7207a.getWidth() != i2) {
                LayoutParams layoutParams = this.f7206a.f7207a.getLayoutParams();
                layoutParams.width = i2;
                this.f7206a.f7207a.setLayoutParams(layoutParams);
            }
            this.f7206a.f7207a.setTranslationX(((float) i2) * (((float) this.f7206a.f7211e) + this.f7206a.f7212f));
        }
    }

    public NavigationTabsPageIndicator(ControlledView controlledView) {
        super(controlledView);
        CustomViewUtils.b(this.f7207a, new ColorDrawable(ContextUtils.c(this.f7207a.getContext(), 2130772522, 0)));
    }

    public final void m10360b(int i) {
        this.f7210d = i;
        if (this.f7209c != null) {
            this.f7209c.b(i);
        }
        if (this.f7209c != null) {
            this.f7209c.b(i);
        }
    }

    public final void m10358a(int i, float f, int i2) {
        this.f7211e = i;
        this.f7212f = f;
        m10356b();
        if (this.f7209c != null) {
            this.f7209c.a(i, f, i2);
        }
    }

    public final void e_(int i) {
        if (this.f7210d == 0) {
            this.f7211e = i;
            m10356b();
        }
        if (this.f7209c != null) {
            this.f7209c.e_(i);
        }
    }

    public final void m10359a(ViewPager viewPager) {
        if (this.f7208b != viewPager) {
            if (this.f7208b != null) {
                this.f7208b.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.f7208b = viewPager;
            this.f7208b.setOnPageChangeListener(this);
            m10356b();
        }
    }

    public final void mo895a() {
        m10356b();
    }

    private void m10356b() {
        if (!this.f7213g) {
            this.f7213g = true;
            this.f7207a.post(this.f7214h);
        }
    }
}
