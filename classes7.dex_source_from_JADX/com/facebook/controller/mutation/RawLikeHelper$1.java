package com.facebook.controller.mutation;

import com.facebook.api.ufiservices.common.TogglePageLikeParams;
import com.facebook.fbservice.service.OperationResult;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: tap_photo_button */
class RawLikeHelper$1 implements Callable<ListenableFuture<OperationResult>> {
    final /* synthetic */ boolean f2269a;
    final /* synthetic */ TogglePageLikeParams f2270b;
    final /* synthetic */ RawLikeHelper f2271c;

    RawLikeHelper$1(RawLikeHelper rawLikeHelper, boolean z, TogglePageLikeParams togglePageLikeParams) {
        this.f2271c = rawLikeHelper;
        this.f2269a = z;
        this.f2270b = togglePageLikeParams;
    }

    public Object call() {
        if (this.f2269a) {
            return this.f2271c.f.a(this.f2270b);
        }
        return this.f2271c.e.a(this.f2270b, null);
    }
}
