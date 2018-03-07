package com.facebook.backstage.nub;

import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.facebook.backstage.nub.FullWindowView.ViewState;

/* compiled from: request started */
public class FullWindow extends FloatingWindow<FullWindowView> {
    public FullWindow(WindowManager windowManager, FullWindowView fullWindowView) {
        LayoutParams layoutParams = new LayoutParams(-1, -1, 2010, 16843520, -3);
        layoutParams.gravity = 21;
        super(windowManager, layoutParams, fullWindowView);
        m5641b(false);
    }

    public final void m5651d() {
        m5652e();
        FullWindowView fullWindowView = (FullWindowView) this.f5411b;
        fullWindowView.f5446e = ViewState.HIDDEN;
        fullWindowView.mo203e();
        fullWindowView.f5448g.setY((float) fullWindowView.f5443b.m4552b());
        fullWindowView.mo207i();
        fullWindowView.f5445d.f5457a = true;
        fullWindowView.f5445d.invalidate();
    }

    public final void m5652e() {
        m5638a(false);
        m5641b(false);
    }

    public final void m5653f() {
        m5639b();
        m5638a(true);
        m5641b(true);
    }
}
