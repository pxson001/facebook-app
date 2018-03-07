package com.facebook.http.protocol;

/* compiled from: dialtone_mode_selection_interstitial_back_pressed */
class UDPPrimingHelper$1 implements Runnable {
    final /* synthetic */ String f5095a;
    final /* synthetic */ UDPPrimingHelper f5096b;

    UDPPrimingHelper$1(UDPPrimingHelper uDPPrimingHelper, String str) {
        this.f5096b = uDPPrimingHelper;
        this.f5095a = str;
    }

    public void run() {
        UDPPrimingHelper uDPPrimingHelper = this.f5096b;
        UDPPrimingHelper.a(this.f5095a);
    }
}
