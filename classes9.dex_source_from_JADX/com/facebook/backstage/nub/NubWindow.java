package com.facebook.backstage.nub;

import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.facebook.backstage.nub.NubView.DrawingMode;

/* compiled from: reply_thread_count */
public class NubWindow extends FloatingWindow<NubView> {
    public final void m5680a(int i, int i2, int i3) {
        ((NubView) this.f5411b).m5679a(i, i3);
        m5637a(i);
        m5643c(i2);
    }

    public final void m5681d() {
        m5638a(false);
        ((NubView) this.f5411b).f5457a = true;
        ((NubView) this.f5411b).invalidate();
    }

    public NubWindow(WindowManager windowManager, NubView nubView) {
        LayoutParams layoutParams = new LayoutParams(nubView.f5458b, nubView.f5459c, 2010, 16843520, -3);
        layoutParams.gravity = 51;
        super(windowManager, layoutParams, nubView);
        m5641b(false);
        nubView.f5462f = DrawingMode.ARC_LEFT;
    }
}
