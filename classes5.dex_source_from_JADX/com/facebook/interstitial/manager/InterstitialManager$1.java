package com.facebook.interstitial.manager;

import com.facebook.fbservice.ops.OperationResultFutureCallback2;
import com.facebook.fbservice.service.OperationResult;

/* compiled from: TOPIC_ENTERTAINER */
public class InterstitialManager$1 extends OperationResultFutureCallback2 {
    final /* synthetic */ String f13874a;
    final /* synthetic */ InterstitialManager f13875b;

    public InterstitialManager$1(InterstitialManager interstitialManager, String str) {
        this.f13875b = interstitialManager;
        this.f13874a = str;
    }

    protected final void mo478a(OperationResult operationResult) {
        InterstitialManager.a(this.f13875b, this.f13874a, 0);
    }
}
