package com.facebook.feed.rows;

import android.content.Context;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.permalink.PermalinkEnvironment;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder.Builder;
import com.facebook.feed.rows.adapter.OneItemListItemCollection;
import com.facebook.feed.rows.adapter.api.MultiRowRecyclerViewAdapter;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.rows.permalink.PermalinkRootPartDefinition;
import com.facebook.feed.rows.permalink.StoryPermalinkAdapter;
import com.facebook.feed.workingrange.rows.FeedRangesController;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.widget.listview.ScrollingViewProxy;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: onPageScrolled did not call superclass implementation */
public class FeedAdapterFactory {
    private static FeedAdapterFactory f11115e;
    private static final Object f11116f = new Object();
    private final MultipleRowsStoriesRecycleCallback f11117a;
    private final MultiRowAdapterBuilder f11118b;
    private final Lazy<PermalinkRootPartDefinition> f11119c;
    private final Lazy<NewsFeedRootGroupPartDefinition> f11120d;

    private static FeedAdapterFactory m16448b(InjectorLike injectorLike) {
        return new FeedAdapterFactory(MultipleRowsStoriesRecycleCallback.m10040a(injectorLike), IdBasedLazy.m1808a(injectorLike, 1480), MultiRowAdapterBuilder.m15276b(injectorLike), IdBasedLazy.m1808a(injectorLike, 5913));
    }

    @Inject
    public FeedAdapterFactory(MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, Lazy<NewsFeedRootGroupPartDefinition> lazy, MultiRowAdapterBuilder multiRowAdapterBuilder, Lazy<PermalinkRootPartDefinition> lazy2) {
        this.f11117a = multipleRowsStoriesRecycleCallback;
        this.f11120d = lazy;
        this.f11118b = multiRowAdapterBuilder;
        this.f11119c = lazy2;
    }

    public final StoryPermalinkAdapter m16450a(PermalinkEnvironment permalinkEnvironment) {
        Object oneItemListItemCollection = new OneItemListItemCollection();
        Builder a = this.f11118b.m15277a(this.f11119c, oneItemListItemCollection);
        a.f12879f = permalinkEnvironment;
        return new StoryPermalinkAdapter(a.m18959e(), oneItemListItemCollection);
    }

    public static FeedAdapterFactory m16447a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedAdapterFactory b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f11116f) {
                FeedAdapterFactory feedAdapterFactory;
                if (a2 != null) {
                    feedAdapterFactory = (FeedAdapterFactory) a2.mo818a(f11116f);
                } else {
                    feedAdapterFactory = f11115e;
                }
                if (feedAdapterFactory == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m16448b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f11116f, b3);
                        } else {
                            f11115e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = feedAdapterFactory;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final MultiRowRecyclerViewAdapter m16449a(ListItemCollection<FeedEdge> listItemCollection, ScrollingViewProxy scrollingViewProxy, FeedEnvironment feedEnvironment, @Nullable FeedRangesController feedRangesController) {
        scrollingViewProxy.mo2359a(this.f11117a.m10043a());
        Builder a = this.f11118b.m15277a(this.f11120d, listItemCollection);
        a.f12879f = feedEnvironment;
        a = a.m18954a(scrollingViewProxy);
        a.f12882i = true;
        a = a;
        a.f12883j = true;
        return a.m18956a("MultiRowAdapter").m18955a(scrollingViewProxy, feedRangesController).m18957b(scrollingViewProxy).m18958d();
    }
}
