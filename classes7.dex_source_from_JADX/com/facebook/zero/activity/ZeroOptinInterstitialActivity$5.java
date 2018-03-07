package com.facebook.zero.activity;

import android.content.Intent;
import com.facebook.zero.sdk.common.TokenRequestReason;

/* compiled from: ्ऊ */
class ZeroOptinInterstitialActivity$5 implements Runnable {
    final /* synthetic */ ZeroOptinInterstitialActivity f57a;

    ZeroOptinInterstitialActivity$5(ZeroOptinInterstitialActivity zeroOptinInterstitialActivity) {
        this.f57a = zeroOptinInterstitialActivity;
    }

    public void run() {
        this.f57a.t.a(new Intent("com.facebook.zero.ACTION_ZERO_REFRESH_TOKEN").putExtra("zero_token_request_reason", TokenRequestReason.OPTIN));
        this.f57a.u.a("com.facebook.zero.ACTION_FORCE_ZERO_HEADER_REFRESH");
    }
}
