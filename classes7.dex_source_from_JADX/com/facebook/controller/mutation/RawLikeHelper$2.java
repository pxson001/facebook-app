package com.facebook.controller.mutation;

import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;

/* compiled from: tap_photo_button */
class RawLikeHelper$2 extends AbstractDisposableFutureCallback<OperationResult> {
    final /* synthetic */ MutationCallback f2272a;
    final /* synthetic */ String f2273b;
    final /* synthetic */ String f2274c;
    final /* synthetic */ boolean f2275d;
    final /* synthetic */ String f2276e;
    final /* synthetic */ RawLikeHelper f2277f;

    RawLikeHelper$2(RawLikeHelper rawLikeHelper, MutationCallback mutationCallback, String str, String str2, boolean z, String str3) {
        this.f2277f = rawLikeHelper;
        this.f2272a = mutationCallback;
        this.f2273b = str;
        this.f2274c = str2;
        this.f2275d = z;
        this.f2276e = str3;
    }

    public final void m2227a(Object obj) {
        if (this.f2272a != null) {
            this.f2272a.b(this.f2273b);
        }
    }

    protected final void m2228a(Throwable th) {
        if (this.f2272a != null) {
            this.f2272a.a(this.f2273b, ServiceException.a(th));
        }
        if (this.f2274c != null) {
            this.f2277f.a.a(CommonEventsBuilder.a(this.f2274c + "_fail", this.f2273b, String.valueOf(this.f2275d), this.f2276e));
        }
    }
}
