package com.facebook.widget.recyclerview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;

/* compiled from: not a valid Long value */
public class BetterLayoutManagerDelegate {
    public AbstractFbErrorReporter f12208a;
    private LinearLayoutManager f12209b;
    private OrientationHelper f12210c;

    public BetterLayoutManagerDelegate(LinearLayoutManager linearLayoutManager) {
        this.f12209b = linearLayoutManager;
    }

    public final void m17999a(int i) {
        this.f12210c = OrientationHelper.m18000a(this.f12209b, i);
    }

    public final int m17998a() {
        if (this.f12210c == null) {
            throw new IllegalStateException("setOrientation call must be passed from the LayoutManager");
        }
        View a = m17997a(0, this.f12209b.m17367v(), false);
        if (a == null) {
            return -1;
        }
        return ((LayoutParams) a.getLayoutParams()).m20427f();
    }

    private View m17997a(int i, int i2, boolean z) {
        boolean r = this.f12209b.m17364r();
        int c = r ? this.f12210c.mo2330c() : 0;
        int d = r ? this.f12210c.mo2332d() : this.f12210c.mo2334e();
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            View f = this.f12209b.m17351f(i);
            if (f != null) {
                int a = this.f12210c.mo2327a(f);
                int b = this.f12210c.mo2329b(f);
                if (a < d && b >= c) {
                    if (!z) {
                        return f;
                    }
                    if (a >= c && b <= d) {
                        return f;
                    }
                }
            }
            i += i3;
        }
        return null;
    }
}
