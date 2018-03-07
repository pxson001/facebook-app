package com.facebook.events.dashboard;

import android.content.Context;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.dashboard.multirow.EventsDashboardItemCollectionProvider;
import com.facebook.events.dashboard.multirow.environment.EventsDashboardEnvironmentGeneratedProvider;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherFactory;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.common.ReactionInteractionTracker;

/* compiled from: com.google.android.gms.ads.identifier.AdvertisingIdClient */
public class EventsDiscoveryDashboardViewAdapterProvider extends AbstractAssistedProvider<EventsDiscoveryDashboardViewAdapter> {
    public final EventsDiscoveryDashboardViewAdapter m17247a(DashboardFilterType dashboardFilterType, Boolean bool, Context context, EventAnalyticsParams eventAnalyticsParams, EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment, ReactionSession reactionSession, String str, ReactionInteractionTracker reactionInteractionTracker) {
        return new EventsDiscoveryDashboardViewAdapter(dashboardFilterType, bool, context, eventAnalyticsParams, eventsDiscoveryDashboardFragment, reactionSession, str, reactionInteractionTracker, (EventsDashboardEnvironmentGeneratedProvider) getOnDemandAssistedProviderForStaticDi(EventsDashboardEnvironmentGeneratedProvider.class), (EventsDashboardItemCollectionProvider) getOnDemandAssistedProviderForStaticDi(EventsDashboardItemCollectionProvider.class), EventsDashboardPerformanceLogger.m17093a((InjectorLike) this), EventsDashboardSequenceLogger.m17147a((InjectorLike) this), EventEventLogger.m18116a((InjectorLike) this), GraphQLSubscriptionHolder.a(this), MultiRowImagePrefetcherFactory.a(this), MultiRowAdapterBuilder.a(this), MultipleRowsStoriesRecycleCallback.a(this), IdBasedLazy.a(this, 5572));
    }
}
