package com.facebook.feed.fragment.subscriber;

import android.os.Bundle;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: group_order */
class XOutPlaceReviewItemEventSubscriber$2 implements Callable<ListenableFuture<OperationResult>> {
    final /* synthetic */ Bundle f11898a;
    final /* synthetic */ XOutPlaceReviewItemEventSubscriber f11899b;

    XOutPlaceReviewItemEventSubscriber$2(XOutPlaceReviewItemEventSubscriber xOutPlaceReviewItemEventSubscriber, Bundle bundle) {
        this.f11899b = xOutPlaceReviewItemEventSubscriber;
        this.f11898a = bundle;
    }

    public Object call() {
        return BlueServiceOperationFactoryDetour.a(this.f11899b.a, "xOutPlaceReviewItem", this.f11898a, -177262732).a();
    }
}
