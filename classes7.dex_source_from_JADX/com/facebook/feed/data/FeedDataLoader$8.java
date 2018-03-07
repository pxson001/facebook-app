package com.facebook.feed.data;

import com.facebook.api.feed.data.FetchPortion;
import com.facebook.api.feed.data.ViewPortShift;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.model.FetchResultState;
import java.util.concurrent.CancellationException;

/* compiled from: application/vobsub */
class FeedDataLoader$8 extends OperationResultFutureCallback {
    final /* synthetic */ boolean f19162a;
    final /* synthetic */ FetchResultState f19163b;
    final /* synthetic */ FeedDataLoader f19164c;

    FeedDataLoader$8(FeedDataLoader feedDataLoader, boolean z, FetchResultState fetchResultState) {
        this.f19164c = feedDataLoader;
        this.f19162a = z;
        this.f19163b = fetchResultState;
    }

    public final void m22691a(Object obj) {
        m22689b();
        this.f19164c.m();
        FeedDataLoader.a(this.f19164c, this.f19162a, null, this.f19163b, null, -1, FetchPortion.FULL, ViewPortShift.Perform);
        this.f19164c.d();
    }

    private void m22689b() {
        this.f19164c.r = null;
    }

    protected final void m22692a(CancellationException cancellationException) {
        m22689b();
    }

    protected final void m22690a(ServiceException serviceException) {
        m22689b();
    }
}
