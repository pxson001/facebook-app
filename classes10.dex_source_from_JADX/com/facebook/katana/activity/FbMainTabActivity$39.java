package com.facebook.katana.activity;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.uicontrib.fab.FabView;
import com.facebook.widget.LazyView.OnInflateRunner;

/* compiled from: SDK_VERSION */
class FbMainTabActivity$39 implements OnInflateRunner<FabView> {
    final /* synthetic */ int f24222a;
    final /* synthetic */ FbMainTabActivity f24223b;

    FbMainTabActivity$39(FbMainTabActivity fbMainTabActivity, int i) {
        this.f24223b = fbMainTabActivity;
        this.f24222a = i;
    }

    public final void m25510a(View view) {
        FabView fabView = (FabView) view;
        fabView.setFillColor(this.f24222a);
        if (this.f24223b.bT) {
            LayoutParams layoutParams = (LayoutParams) fabView.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, this.f24223b.getResources().getDimensionPixelSize(2131429780));
        }
    }
}
