package com.facebook.earlyfetch.map;

import android.content.Context;
import com.facebook.common.fragmentconstants.FragmentConstants$ContentFragmentType;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.earlyfetch.EarlyFetcher;
import com.facebook.events.dashboard.EventsDashboardEarlyFetcher;
import com.facebook.events.permalink.EventPermalinkEarlyFetcher;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.pages.common.surface.protocol.headerfetcher.PageHeaderEarlyFetcher;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.saved.loader.SavedDashboardEarlyFetcher;
import com.facebook.timeline.datafetcher.TimelineEarlyFetcher;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: imageUri */
public final class EarlyFetcherMapImpl implements EarlyFetcherMap {
    private static EarlyFetcherMapImpl f20471f;
    private static final Object f20472g = new Object();
    private final Lazy<EventsDashboardEarlyFetcher> f20473a;
    private final Lazy<EventPermalinkEarlyFetcher> f20474b;
    private final Lazy<PageHeaderEarlyFetcher> f20475c;
    private final Lazy<SavedDashboardEarlyFetcher> f20476d;
    private final Lazy<TimelineEarlyFetcher> f20477e;

    private static EarlyFetcherMapImpl m28208b(InjectorLike injectorLike) {
        return new EarlyFetcherMapImpl(IdBasedSingletonScopeProvider.m1810b(injectorLike, 5551), IdBasedSingletonScopeProvider.m1810b(injectorLike, 5631), IdBasedSingletonScopeProvider.m1810b(injectorLike, 8997), IdBasedSingletonScopeProvider.m1810b(injectorLike, 10432), IdBasedSingletonScopeProvider.m1810b(injectorLike, 11175));
    }

    @Inject
    public EarlyFetcherMapImpl(Lazy<EventsDashboardEarlyFetcher> lazy, Lazy<EventPermalinkEarlyFetcher> lazy2, Lazy<PageHeaderEarlyFetcher> lazy3, Lazy<SavedDashboardEarlyFetcher> lazy4, Lazy<TimelineEarlyFetcher> lazy5) {
        this.f20473a = lazy;
        this.f20474b = lazy2;
        this.f20475c = lazy3;
        this.f20476d = lazy4;
        this.f20477e = lazy5;
    }

    @Nullable
    public final EarlyFetcher mo3138a(FragmentConstants$ContentFragmentType fragmentConstants$ContentFragmentType) {
        switch (fragmentConstants$ContentFragmentType.ordinal()) {
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return (EarlyFetcher) this.f20477e.get();
            case 9:
                return (EarlyFetcher) this.f20475c.get();
            case 77:
                return (EarlyFetcher) this.f20474b.get();
            case 83:
                return (EarlyFetcher) this.f20476d.get();
            case 86:
                return (EarlyFetcher) this.f20473a.get();
            default:
                return null;
        }
    }

    public final ImmutableList<? extends EarlyFetcher> mo3139a() {
        return ImmutableList.of(this.f20473a.get(), this.f20474b.get(), this.f20475c.get(), this.f20476d.get(), this.f20477e.get());
    }

    public static EarlyFetcherMapImpl m28207a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EarlyFetcherMapImpl b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20472g) {
                EarlyFetcherMapImpl earlyFetcherMapImpl;
                if (a2 != null) {
                    earlyFetcherMapImpl = (EarlyFetcherMapImpl) a2.mo818a(f20472g);
                } else {
                    earlyFetcherMapImpl = f20471f;
                }
                if (earlyFetcherMapImpl == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28208b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20472g, b3);
                        } else {
                            f20471f = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = earlyFetcherMapImpl;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
