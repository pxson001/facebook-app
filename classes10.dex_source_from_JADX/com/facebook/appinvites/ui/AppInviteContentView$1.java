package com.facebook.appinvites.ui;

import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

/* compiled from: downloadmanager_completion_exception */
class AppInviteContentView$1 implements OnGlobalLayoutListener {
    final /* synthetic */ AppInviteContentView f14696a;

    AppInviteContentView$1(AppInviteContentView appInviteContentView) {
        this.f14696a = appInviteContentView;
    }

    public void onGlobalLayout() {
        LayoutParams layoutParams = this.f14696a.h.getLayoutParams();
        layoutParams.height = (int) Math.floor(((double) this.f14696a.h.getWidth()) * 0.5233333333333333d);
        this.f14696a.h.setLayoutParams(layoutParams);
    }
}
