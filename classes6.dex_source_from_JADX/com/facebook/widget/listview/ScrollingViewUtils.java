package com.facebook.widget.listview;

import android.view.View;

/* compiled from: redspace_user_promote */
public class ScrollingViewUtils {
    public static void m8637a(ScrollingViewProxy scrollingViewProxy) {
        if (scrollingViewProxy != null && scrollingViewProxy.q() == 0) {
            int top;
            View f = scrollingViewProxy.f(0);
            if (f != null) {
                top = f.getTop();
            } else {
                top = 0;
            }
            scrollingViewProxy.d(0, top);
        }
    }
}
