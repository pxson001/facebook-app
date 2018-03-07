package com.facebook.timeline.datafetcher;

import android.content.Context;
import com.facebook.analytics.InteractionLogger;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.feed.ui.feedprefetch.VideoPrefetchVisitorProvider;
import com.facebook.graphql.executor.ObservableThreadUtil;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.timeline.datafetcher.TimelineStoriesDataFetcher.ViewCallback;
import com.facebook.timeline.logging.TimelinePerformanceLogger;
import com.facebook.timeline.profileprotocol.FetchTimelineFirstUnitsParams.QueryType;
import com.facebook.timeline.protiles.model.ProtilesData;
import com.facebook.timeline.protiles.model.TimelinePromptData;
import com.facebook.timeline.pymk.PeopleYouMayKnowData;
import com.facebook.timeline.taggedmediaset.TimelineTaggedMediaSetData;
import com.facebook.timeline.units.model.TimelineAllSectionsData;
import com.facebook.timeline.units.model.TimelineFeedStoryLinkifyUtil;
import com.facebook.timeline.units.model.TimelineFilterHandler;
import com.facebook.timeline.viewfeaturedcontainers.data.FeaturedContainersHeaderData;

/* compiled from: greeting_card_edit */
public class TimelineStoriesDataFetcherProvider extends AbstractAssistedProvider<TimelineStoriesDataFetcher> {
    public final TimelineStoriesDataFetcher m10729a(Context context, ViewCallback viewCallback, TimelineContext timelineContext, QueryType queryType, TimelineAllSectionsData timelineAllSectionsData, TimelineTaggedMediaSetData timelineTaggedMediaSetData, TimelinePromptData timelinePromptData, CallerContext callerContext) {
        return new TimelineStoriesDataFetcher(context, viewCallback, timelineContext, queryType, timelineAllSectionsData, timelineTaggedMediaSetData, timelinePromptData, callerContext, ProtilesData.m12116a((InjectorLike) this), FeaturedContainersHeaderData.m12779a(this), PeopleYouMayKnowData.m12492a((InjectorLike) this), (TimelineGenericDataFetcherProvider) getOnDemandAssistedProviderForStaticDi(TimelineGenericDataFetcherProvider.class), IdBasedSingletonScopeProvider.a(this, 11187), IdBasedSingletonScopeProvider.a(this, 11183), IdBasedProvider.a(this, 11171), IdBasedProvider.a(this, 11185), ObservableThreadUtil.a(this), TimelinePerformanceLogger.a(this), TimelineFilterHandler.m12732a((InjectorLike) this), TimelineFeedStoryLinkifyUtil.m12730a((InjectorLike) this), InteractionLogger.a(this), GraphQLCacheManager.a(this), (Clock) SystemClockMethodAutoProvider.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), (VideoPrefetchVisitorProvider) getOnDemandAssistedProviderForStaticDi(VideoPrefetchVisitorProvider.class));
    }
}
