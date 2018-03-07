package com.facebook.zero.service;

import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.zero.common.constants.FbZeroTokenType;
import com.facebook.zero.sdk.request.FetchZeroIndicatorRequestParams;
import com.facebook.zero.sdk.request.ZeroIndicatorData;
import com.facebook.zero.sdk.request.ZeroRequestHandler;
import com.facebook.zero.sdk.util.ZeroNetworkAndTelephonyHelper;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: write_review_action */
class FbZeroIndicatorManager$1 implements Runnable {
    final /* synthetic */ FbZeroIndicatorManager f223a;

    /* compiled from: write_review_action */
    class C00331 implements FutureCallback<ZeroIndicatorData> {
        final /* synthetic */ FbZeroIndicatorManager$1 f222a;

        C00331(FbZeroIndicatorManager$1 fbZeroIndicatorManager$1) {
            this.f222a = fbZeroIndicatorManager$1;
        }

        public void onSuccess(Object obj) {
            FbZeroIndicatorManager.a(this.f222a.f223a, (ZeroIndicatorData) obj);
        }

        public void onFailure(Throwable th) {
        }
    }

    FbZeroIndicatorManager$1(FbZeroIndicatorManager fbZeroIndicatorManager) {
        this.f223a = fbZeroIndicatorManager;
    }

    public void run() {
        ((ZeroRequestHandler) this.f223a.i.get()).a(new FetchZeroIndicatorRequestParams(((ZeroNetworkAndTelephonyHelper) this.f223a.j.get()).a(), ((ZeroNetworkAndTelephonyHelper) this.f223a.j.get()).b(), ((FbSharedPreferences) this.f223a.c.get()).a(((FbZeroTokenType) this.f223a.g.get()).getCampaignIdKey(), "")), new C00331(this));
    }
}
