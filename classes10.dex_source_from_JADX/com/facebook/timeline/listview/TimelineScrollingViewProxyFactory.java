package com.facebook.timeline.listview;

import android.content.Context;
import android.view.ViewStub;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.ui.MultiRowAdapterRecyclerViewProxy;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.timeline.ui.TimelineFragmentView;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.LayoutManagerWithKeepAttachedHack;
import javax.inject.Provider;

@ContextScoped
/* compiled from: fetchEventsDiscoveryTimeFilters */
public class TimelineScrollingViewProxyFactory {
    private static TimelineScrollingViewProxyFactory f12053c;
    private static final Object f12054d = new Object();
    @Inject
    public volatile Provider<MultipleRowsStoriesRecycleCallback> f12055a = UltralightRuntime.a;
    @Inject
    public Context f12056b;

    private static TimelineScrollingViewProxyFactory m12068b(InjectorLike injectorLike) {
        TimelineScrollingViewProxyFactory timelineScrollingViewProxyFactory = new TimelineScrollingViewProxyFactory();
        Context context = (Context) injectorLike.getInstance(Context.class);
        timelineScrollingViewProxyFactory.f12055a = IdBasedSingletonScopeProvider.a(injectorLike, 1489);
        timelineScrollingViewProxyFactory.f12056b = context;
        return timelineScrollingViewProxyFactory;
    }

    public final ScrollingViewProxy m12069a(TimelineFragmentView timelineFragmentView) {
        BetterRecyclerView betterRecyclerView = (BetterRecyclerView) timelineFragmentView.asViewGroup().findViewById(16908298);
        betterRecyclerView.setLayoutManager(new LayoutManagerWithKeepAttachedHack(betterRecyclerView));
        MultiRowAdapterRecyclerViewProxy multiRowAdapterRecyclerViewProxy = new MultiRowAdapterRecyclerViewProxy(betterRecyclerView);
        multiRowAdapterRecyclerViewProxy.d(true);
        multiRowAdapterRecyclerViewProxy.k();
        multiRowAdapterRecyclerViewProxy.b().setClipToPadding(false);
        multiRowAdapterRecyclerViewProxy.a(((MultipleRowsStoriesRecycleCallback) this.f12055a.get()).a());
        return multiRowAdapterRecyclerViewProxy;
    }

    public static TimelineScrollingViewProxyFactory m12066a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineScrollingViewProxyFactory b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12054d) {
                TimelineScrollingViewProxyFactory timelineScrollingViewProxyFactory;
                if (a2 != null) {
                    timelineScrollingViewProxyFactory = (TimelineScrollingViewProxyFactory) a2.a(f12054d);
                } else {
                    timelineScrollingViewProxyFactory = f12053c;
                }
                if (timelineScrollingViewProxyFactory == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12068b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12054d, b3);
                        } else {
                            f12053c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelineScrollingViewProxyFactory;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static void m12067a(ScrollingViewProxy scrollingViewProxy, TimelineAdapter timelineAdapter, TimelineFragmentView timelineFragmentView) {
        scrollingViewProxy.a(timelineAdapter);
        if (timelineAdapter.isEmpty()) {
            scrollingViewProxy.f(((ViewStub) timelineFragmentView.findViewById(2131567930)).inflate());
        }
    }
}
