package com.facebook.feedplugins.pymk.rows.components;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.widget.PagerBinder;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feedplugins.pymk.rows.PeopleYouMayKnowHScrollPartDefinition.HScrollProps;
import com.facebook.graphql.model.GraphQLPaginatedPeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge;
import com.facebook.graphql.model.ItemListFeedUnitImpl;
import com.google.common.collect.ImmutableList;

/* compiled from: THREAD_LIST_INTERSTITIAL */
public class PeopleYouMayKnowComponentPagerBinder<E extends HasContext & HasFeedListType & HasIsAsync & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey> extends PagerBinder {
    private final ImmutableList<GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge> f24888a = ItemListFeedUnitImpl.a((GraphQLPaginatedPeopleYouMayKnowFeedUnit) this.f24889b.m26624f().a);
    private HScrollProps f24889b;
    private E f24890c;

    protected final /* synthetic */ void m26667f(ViewGroup viewGroup) {
        a((ViewPager) viewGroup);
    }

    protected final /* synthetic */ void m26668g(ViewGroup viewGroup) {
        b((ViewPager) viewGroup);
    }

    public PeopleYouMayKnowComponentPagerBinder(Context context, int i, float f, HScrollProps hScrollProps, E e) {
        super(context, i, f);
        this.f24890c = e;
        this.f24889b = hScrollProps;
    }

    protected final int m26664a() {
        return this.f24888a.size();
    }

    public final Component<?> m26665a(ComponentContext componentContext, int i) {
        return null;
    }

    protected final boolean m26666c() {
        return false;
    }
}
