package com.facebook.placetips.bootstrap.fake;

import com.facebook.inject.InjectorLike;
import com.facebook.placetips.bootstrap.PagePresenceProvider;
import com.facebook.placetips.bootstrap.PagePresenceProviderFuture;
import com.google.common.util.concurrent.ForwardingListenableFuture.SimpleForwardingListenableFuture;
import com.google.common.util.concurrent.Futures;
import javax.inject.Inject;

/* compiled from: search_awareness */
public class FakePagePresenceProviderFuture extends SimpleForwardingListenableFuture<PagePresenceProvider> implements PagePresenceProviderFuture {
    private static FakePagePresenceProviderFuture m3736b(InjectorLike injectorLike) {
        return new FakePagePresenceProviderFuture(new FakeCurrentPresenceProvider());
    }

    @Inject
    public FakePagePresenceProviderFuture(FakeCurrentPresenceProvider fakeCurrentPresenceProvider) {
        super(Futures.a(fakeCurrentPresenceProvider));
    }
}
