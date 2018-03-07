package com.facebook.react.views.scroll;

import android.os.SystemClock;

/* compiled from: backstage-graphql */
public class OnScrollDispatchHelper {
    private int f19059a = Integer.MIN_VALUE;
    private int f19060b = Integer.MIN_VALUE;
    private long f19061c = -11;

    public final boolean m19026a(int i, int i2) {
        long uptimeMillis = SystemClock.uptimeMillis();
        boolean z = (uptimeMillis - this.f19061c <= 10 && this.f19059a == i && this.f19060b == i2) ? false : true;
        this.f19061c = uptimeMillis;
        this.f19059a = i;
        this.f19060b = i2;
        return z;
    }
}
