package com.facebook.katana.activity;

import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.uicontrib.fab.FabView;

/* compiled from: SDK_VERSION */
class FbMainTabActivity$SpringListener extends SimpleSpringListener {
    final /* synthetic */ FbMainTabActivity f24225a;

    public FbMainTabActivity$SpringListener(FbMainTabActivity fbMainTabActivity) {
        this.f24225a = fbMainTabActivity;
    }

    public final void m25511a(Spring spring) {
        FabView fabView = (FabView) this.f24225a.ci.a();
        float d = (float) spring.d();
        fabView.setAlpha(d);
        fabView.setScaleX(d);
        fabView.setScaleY(d);
    }

    public final void m25512b(Spring spring) {
        if (spring.g(0.0d)) {
            FbMainTabActivity.aH(this.f24225a);
        }
    }
}
