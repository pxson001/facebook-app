package com.facebook.securitycheckup.items;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.facebook.securitycheckup.SecurityCheckupScrollingController.SecurityCheckupScrollingStateChangeListener;

/* compiled from: http_opera */
public class SecurityCheckupLayoutManager extends LinearLayoutManager {
    private Context f9854a;
    public int f9855b;
    public boolean f9856c = false;
    private boolean f9857d = false;
    public SecurityCheckupScrollingStateChangeListener f9858e;
    private int f9859f = -1;
    private int f9860g = -1;
    private int f9861h = -1;
    private int f9862i = -1;
    public int f9863t = -1;
    public int f9864u = 100;

    /* compiled from: http_opera */
    class SmoothScrollerWithSpeedControl extends LinearSmoothScroller {
        final /* synthetic */ SecurityCheckupLayoutManager f9850a;
        private final float f9851g;
        private final float f9852h;
        private final int f9853i;

        public SmoothScrollerWithSpeedControl(SecurityCheckupLayoutManager securityCheckupLayoutManager, Context context, int i, int i2, int i3) {
            this.f9850a = securityCheckupLayoutManager;
            super(context);
            this.f9851g = (float) i;
            this.f9852h = (float) i2;
            this.f9853i = i3;
        }

        public final PointF m10035a(int i) {
            return this.f9850a.d(i);
        }

        protected final int m10036b(int i) {
            return (int) ((((float) i) / this.f9851g) * this.f9852h);
        }

        protected final int m10037c() {
            return this.f9853i;
        }
    }

    public SecurityCheckupLayoutManager(Context context, int i, boolean z) {
        super(i, z);
        this.f9854a = context;
    }

    public final void m10041c() {
        this.f9857d = true;
        this.f9862i = -1;
        this.f9861h = -1;
        this.f9860g = -1;
        this.f9859f = -1;
    }

    public final void m10042d() {
        this.f9857d = false;
    }

    public final void m10039a(RecyclerView recyclerView, State state, int i) {
        View childAt = recyclerView.getChildAt(0);
        int abs = Math.abs((this.f9855b == 0 ? childAt.getHeight() : this.f9855b) * (RecyclerView.d(childAt) - i));
        if (abs == 0) {
            abs = (int) Math.abs(childAt.getY());
        }
        SmoothScrollerWithSpeedControl smoothScrollerWithSpeedControl = new SmoothScrollerWithSpeedControl(this, recyclerView.getContext(), abs, this.f9864u, this.f9863t);
        smoothScrollerWithSpeedControl.a = i;
        a(smoothScrollerWithSpeedControl);
    }

    public final int m10040b(int i, Recycler recycler, State state) {
        if (this.f9857d) {
            super.b(i, recycler, state);
        } else {
            int bottom;
            int i2 = -1;
            int n = n();
            View c = c(n);
            if (c != null) {
                i2 = c.getTop();
            }
            int l = l();
            View c2 = c(l);
            if (c2 != null) {
                bottom = c2.getBottom();
            } else {
                bottom = -1;
            }
            if (i < 0) {
                int i3;
                if (this.f9861h == l && this.f9859f != -1) {
                    if (((double) this.f9859f) < m10038a(0.1d) && ((double) bottom) >= m10038a(0.1d)) {
                        this.f9858e.m9922b(l, 0.1d);
                    }
                    if (((double) this.f9859f) < m10038a(0.05d) && ((double) bottom) >= m10038a(0.05d)) {
                        this.f9858e.m9922b(l, 0.05d);
                    }
                }
                if (!this.f9856c || ((double) bottom) > m10038a(0.1d)) {
                    i3 = i;
                } else {
                    i3 = (int) (((double) i) * 0.6d);
                }
                if (n != D() - 1 || ((double) i2) > m10038a(0.1d)) {
                    i = i3;
                } else {
                    i = (int) (((double) i) * 0.6d);
                }
            } else {
                if (this.f9862i == n && this.f9860g != -1 && ((double) this.f9860g) > m10038a(0.9d) && ((double) i2) <= m10038a(0.9d)) {
                    this.f9858e.m9921a(n, 0.9d);
                }
                if ((n == D() - 1 || this.f9856c) && ((double) i2) > m10038a(0.9d)) {
                    i = (int) (((double) i) * 0.6d);
                }
                if (this.f9861h == l && this.f9859f != -1 && ((double) this.f9859f) > m10038a(0.05d) && ((double) bottom) <= m10038a(0.05d)) {
                    this.f9858e.m9923c(l, 0.05d);
                }
            }
            super.b(i, recycler, state);
            this.f9859f = bottom;
            this.f9860g = i2;
            this.f9861h = l;
            this.f9862i = n;
        }
        return i;
    }

    private double m10038a(double d) {
        return ((double) this.f9854a.getResources().getDisplayMetrics().heightPixels) * d;
    }
}
