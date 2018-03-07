package com.facebook.qe.store;

import com.facebook.abtest.qe.bootstrap.data.QuickExperimentInfo;
import com.facebook.qe.api.manager.Authority;

/* compiled from: thread_presence_local_duration */
public class Utils {
    public static void m1392a(int i, int i2, int i3, View view, ViewBuilder viewBuilder, Authority authority) {
        if (authority == Authority.OVERRIDE && view.a(i)) {
            viewBuilder.m818a(i2);
            return;
        }
        switch (i3) {
            case 100:
            case 105:
                if (view.f(authority, i)) {
                    viewBuilder.m823a(authority, i2, view.a(authority, i));
                    return;
                }
                return;
            case 101:
                if (view.f(authority, i)) {
                    viewBuilder.m824a(authority, i2, view.e(authority, i));
                    return;
                }
                return;
            case 102:
                if (view.f(authority, i)) {
                    viewBuilder.m821a(authority, i2, view.b(authority, i));
                    return;
                }
                return;
            case 103:
                if (view.f(authority, i)) {
                    viewBuilder.m822a(authority, i2, view.c(authority, i));
                    return;
                }
                return;
            case 104:
                if (view.f(authority, i)) {
                    viewBuilder.m820a(authority, i2, view.d(authority, i));
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException("Illegal type: " + i3);
        }
    }

    public static void m1393a(QuickExperimentInfo quickExperimentInfo, ViewBuilder viewBuilder, int i, Authority authority) {
        int i2 = i + 1;
        int i3 = i + 2;
        int i4 = i + 3;
        viewBuilder.m824a(authority, i + 0, quickExperimentInfo.d);
        viewBuilder.m824a(authority, i2, quickExperimentInfo.c);
        String b = quickExperimentInfo.b();
        String c = quickExperimentInfo.c();
        if (b != null) {
            viewBuilder.m823a(authority, i3, b);
        }
        if (c != null) {
            viewBuilder.m823a(authority, i4, c);
        }
    }
}
