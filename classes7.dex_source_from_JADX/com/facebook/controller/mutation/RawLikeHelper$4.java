package com.facebook.controller.mutation;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;

/* compiled from: tap_photo_button */
class RawLikeHelper$4 extends AbstractDisposableFutureCallback<OperationResult> {
    final /* synthetic */ MutationCallback f2281a;
    final /* synthetic */ String f2282b;
    final /* synthetic */ RawLikeHelper f2283c;

    RawLikeHelper$4(RawLikeHelper rawLikeHelper, MutationCallback mutationCallback, String str) {
        this.f2283c = rawLikeHelper;
        this.f2281a = mutationCallback;
        this.f2282b = str;
    }

    public final void m2229a(Object obj) {
        if (this.f2281a != null) {
            this.f2281a.b(this.f2282b);
        }
    }

    protected final void m2230a(Throwable th) {
        if (this.f2281a != null) {
            this.f2281a.a(this.f2282b, ServiceException.a(th));
        }
    }
}
