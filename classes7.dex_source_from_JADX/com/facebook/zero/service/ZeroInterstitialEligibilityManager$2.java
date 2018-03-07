package com.facebook.zero.service;

import com.facebook.zero.sdk.request.FetchZeroInterstitialEligibilityResult;
import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;

/* compiled from: width =  */
class ZeroInterstitialEligibilityManager$2 implements FutureCallback<FetchZeroInterstitialEligibilityResult> {
    final /* synthetic */ ZeroInterstitialEligibilityManager f231a;

    ZeroInterstitialEligibilityManager$2(ZeroInterstitialEligibilityManager zeroInterstitialEligibilityManager) {
        this.f231a = zeroInterstitialEligibilityManager;
    }

    public void onSuccess(@Nullable Object obj) {
        this.f231a.a((FetchZeroInterstitialEligibilityResult) obj);
    }

    public void onFailure(Throwable th) {
        if (!(th instanceof CancellationException)) {
            ZeroInterstitialEligibilityManager.a(this.f231a, th);
        }
    }
}
