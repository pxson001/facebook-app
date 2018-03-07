package com.facebook.zero.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: ्ऊ */
class ZeroOptinInterstitialActivity$1 implements OnClickListener {
    final /* synthetic */ ZeroOptinInterstitialActivity f48a;

    ZeroOptinInterstitialActivity$1(ZeroOptinInterstitialActivity zeroOptinInterstitialActivity) {
        this.f48a = zeroOptinInterstitialActivity;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1286236342);
        this.f48a.d(null);
        Logger.a(2, EntryType.UI_INPUT_END, 239041710, a);
    }
}
