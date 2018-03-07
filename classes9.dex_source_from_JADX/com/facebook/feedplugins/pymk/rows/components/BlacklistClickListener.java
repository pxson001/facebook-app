package com.facebook.feedplugins.pymk.rows.components;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.PeopleYouMayKnowEvents.BlacklistPeopleYouMayKnowItemEvent;
import com.facebook.feedplugins.pymk.PeopleYouMayKnowPersistentState.QPContextStateKey;
import com.facebook.feedplugins.pymk.PeopleYouMayKnowPersistentState.QPPersistentState;
import com.facebook.feedplugins.pymk.quickpromotion.QuickPromotionFeedPYMKController;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.PYMKBlacklistedEvent;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.PeopleYouMayKnowFeedUnit;
import com.facebook.graphql.model.PeopleYouMayKnowFeedUnitItem;
import com.facebook.graphql.model.conversion.FeedUnitItemProfileHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.fasterxml.jackson.databind.node.ArrayNode;
import javax.inject.Inject;

@ContextScoped
/* compiled from: THREAD_MARKED_READ */
public class BlacklistClickListener<E extends HasInvalidate & HasPersistentState> {
    public static final CallerContext f24880a = CallerContext.a(BlacklistClickListener.class, "native_newsfeed");
    private static BlacklistClickListener f24881g;
    private static final Object f24882h = new Object();
    public final FeedEventBus f24883b;
    public final FriendingEventBus f24884c;
    public final FriendingClient f24885d;
    private final AnalyticsLogger f24886e;
    private final NewsFeedAnalyticsEventBuilder f24887f;

    private static BlacklistClickListener m26662b(InjectorLike injectorLike) {
        return new BlacklistClickListener(FeedEventBus.a(injectorLike), FriendingEventBus.a(injectorLike), FriendingClient.b(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike));
    }

    @Inject
    public BlacklistClickListener(FeedEventBus feedEventBus, FriendingEventBus friendingEventBus, FriendingClient friendingClient, AnalyticsLogger analyticsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder) {
        this.f24883b = feedEventBus;
        this.f24884c = friendingEventBus;
        this.f24885d = friendingClient;
        this.f24886e = analyticsLogger;
        this.f24887f = newsFeedAnalyticsEventBuilder;
    }

    public final void m26663a(PeopleYouMayKnowFeedUnit peopleYouMayKnowFeedUnit, PeopleYouMayKnowFeedUnitItem peopleYouMayKnowFeedUnitItem, E e) {
        HoneyAnalyticsEvent honeyAnalyticsEvent;
        ArrayNode a = GraphQLHelper.a(peopleYouMayKnowFeedUnitItem, peopleYouMayKnowFeedUnit);
        if (NewsFeedAnalyticsEventBuilder.B(a)) {
            honeyAnalyticsEvent = null;
        } else {
            HoneyClientEvent a2 = new HoneyClientEvent("pymk_xout").a("tracking", a);
            a2.c = "native_newsfeed";
            honeyAnalyticsEvent = a2;
        }
        this.f24886e.c(honeyAnalyticsEvent);
        QPContextStateKey qPContextStateKey = new QPContextStateKey(peopleYouMayKnowFeedUnit.g(), new QPPersistentState(true, QuickPromotionFeedPYMKController.c));
        ((HasPersistentState) e).a(qPContextStateKey, peopleYouMayKnowFeedUnit);
        ((HasPersistentState) e).a(qPContextStateKey, new QPPersistentState(true, QuickPromotionFeedPYMKController.c));
        e.a(new Object[]{peopleYouMayKnowFeedUnit});
        String b = FeedUnitItemProfileHelper.a(peopleYouMayKnowFeedUnitItem).b();
        this.f24885d.a(Long.parseLong(b), f24880a);
        this.f24884c.a(new PYMKBlacklistedEvent(Long.parseLong(b)));
        this.f24883b.a(new BlacklistPeopleYouMayKnowItemEvent(peopleYouMayKnowFeedUnit.g(), b));
    }

    public static BlacklistClickListener m26661a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BlacklistClickListener b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24882h) {
                BlacklistClickListener blacklistClickListener;
                if (a2 != null) {
                    blacklistClickListener = (BlacklistClickListener) a2.a(f24882h);
                } else {
                    blacklistClickListener = f24881g;
                }
                if (blacklistClickListener == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26662b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24882h, b3);
                        } else {
                            f24881g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = blacklistClickListener;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
