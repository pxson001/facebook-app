package com.facebook.backstage.nub;

import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

/* compiled from: reply_intent */
public class ProxyFullWindow extends FloatingWindow<View> {
    public ProxyFullWindow(WindowManager windowManager, View view) {
        LayoutParams layoutParams = new LayoutParams(-1, -1, 2010, 16843520, -3);
        layoutParams.gravity = 51;
        super(windowManager, layoutParams, view);
        m5641b(false);
        m5695e();
    }

    public final void m5695e() {
        m5638a(false);
    }
}
