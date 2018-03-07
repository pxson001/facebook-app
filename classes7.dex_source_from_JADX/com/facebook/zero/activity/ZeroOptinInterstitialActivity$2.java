package com.facebook.zero.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: ्ऊ */
class ZeroOptinInterstitialActivity$2 implements OnClickListener {
    final /* synthetic */ ZeroOptinInterstitialActivity f49a;

    ZeroOptinInterstitialActivity$2(ZeroOptinInterstitialActivity zeroOptinInterstitialActivity) {
        this.f49a = zeroOptinInterstitialActivity;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -482452321);
        this.f49a.c(null);
        Logger.a(2, EntryType.UI_INPUT_END, 1582957802, a);
    }
}
