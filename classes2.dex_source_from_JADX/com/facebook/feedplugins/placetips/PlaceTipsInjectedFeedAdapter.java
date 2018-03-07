package com.facebook.feedplugins.placetips;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.placetips.bootstrap.PlaceTipsEnabledFuture;
import com.facebook.widget.listview.FbListAdapter;
import com.facebook.widget.listview.PreconditionedListAdapter;
import com.facebook.widget.listview.PreconditionedListAdapterProvider;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: partial_user */
public class PlaceTipsInjectedFeedAdapter {
    public final Provider<PlaceTipsFeedAdapter> f10374a;
    public final Lazy<PlaceTipsEnabledFuture> f10375b;
    private final PreconditionedListAdapterProvider f10376c;

    /* compiled from: partial_user */
    public class C05401 {
        public final /* synthetic */ PlaceTipsInjectedFeedAdapter f13540a;

        C05401(PlaceTipsInjectedFeedAdapter placeTipsInjectedFeedAdapter) {
            this.f13540a = placeTipsInjectedFeedAdapter;
        }
    }

    public static PlaceTipsInjectedFeedAdapter m15471a(InjectorLike injectorLike) {
        return new PlaceTipsInjectedFeedAdapter(IdBasedProvider.m1811a(injectorLike, 1952), IdBasedLazy.m1808a(injectorLike, 3020), (PreconditionedListAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PreconditionedListAdapterProvider.class));
    }

    @Inject
    public PlaceTipsInjectedFeedAdapter(Provider<PlaceTipsFeedAdapter> provider, Lazy<PlaceTipsEnabledFuture> lazy, PreconditionedListAdapterProvider preconditionedListAdapterProvider) {
        this.f10374a = provider;
        this.f10375b = lazy;
        this.f10376c = preconditionedListAdapterProvider;
    }

    public final FbListAdapter m15472a() {
        Object obj = this.f10376c;
        return new PreconditionedListAdapter(ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(obj), new C05401(this));
    }
}
