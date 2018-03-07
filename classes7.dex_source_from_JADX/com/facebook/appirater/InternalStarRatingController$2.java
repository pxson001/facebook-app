package com.facebook.appirater;

import com.facebook.fbservice.service.OperationResult;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: cta_lead_gen_next_button_click */
class InternalStarRatingController$2 implements FutureCallback<OperationResult> {
    final /* synthetic */ InternalStarRatingController f16466a;

    InternalStarRatingController$2(InternalStarRatingController internalStarRatingController) {
        this.f16466a = internalStarRatingController;
    }

    public void onSuccess(Object obj) {
        this.f16466a.c.b.edit().putBoolean(InternalStarRatingPrefKeys.f16472e, true).commit();
        this.f16466a.a(null);
        this.f16466a.t = false;
    }

    public void onFailure(Throwable th) {
        this.f16466a.a(null);
        this.f16466a.t = false;
        this.f16466a.f.a("InternalStarRating-CreateReport-Fail", th);
    }
}
