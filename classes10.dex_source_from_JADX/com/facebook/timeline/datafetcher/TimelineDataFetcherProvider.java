package com.facebook.timeline.datafetcher;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.connection.ConnectionTailLoaderManagerProvider;
import com.facebook.graphql.cursor.LocalModelCursorLoaderManagerProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.TimelineFragment;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.cursor.TimelineAllSectionsCursor;
import com.facebook.timeline.cursor.TimelineCursorHelper;
import com.facebook.timeline.cursor.TimelineSelfFirstUnitsBatchConfigurationProvider;
import com.facebook.timeline.logging.TimelinePerformanceLogger;
import com.facebook.timeline.profileprotocol.FetchTimelineFirstUnitsParams.QueryType;
import com.facebook.timeline.protiles.model.TimelinePromptData;
import com.facebook.timeline.taggedmediaset.TimelineTaggedMediaSetData;
import com.facebook.timeline.units.model.TimelineAllSectionsData;

/* compiled from: groupInformation or groupId is null in unfavoriteGroup */
public class TimelineDataFetcherProvider extends AbstractAssistedProvider<TimelineDataFetcher> {
    public final TimelineDataFetcher m10572a(Context context, TimelineFragment timelineFragment, TimelineUserContext timelineUserContext, QueryType queryType, TimelineAllSectionsData timelineAllSectionsData, TimelineAllSectionsCursor timelineAllSectionsCursor, TimelineTaggedMediaSetData timelineTaggedMediaSetData, TimelinePromptData timelinePromptData, TimelinePerformanceLogger timelinePerformanceLogger, CallerContext callerContext) {
        return new TimelineDataFetcher(context, timelineFragment, timelineUserContext, queryType, timelineAllSectionsData, timelineAllSectionsCursor, timelineTaggedMediaSetData, timelinePromptData, timelinePerformanceLogger, callerContext, (TimelineHeaderDataFetcherProvider) getOnDemandAssistedProviderForStaticDi(TimelineHeaderDataFetcherProvider.class), (TimelineStoriesDataFetcherProvider) getOnDemandAssistedProviderForStaticDi(TimelineStoriesDataFetcherProvider.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), IdBasedSingletonScopeProvider.a(this, 609), TimelineCursorHelper.m10500a((InjectorLike) this), (ConnectionTailLoaderManagerProvider) getOnDemandAssistedProviderForStaticDi(ConnectionTailLoaderManagerProvider.class), (TimelineSelfFirstUnitsBatchConfigurationProvider) getOnDemandAssistedProviderForStaticDi(TimelineSelfFirstUnitsBatchConfigurationProvider.class), (LocalModelCursorLoaderManagerProvider) getOnDemandAssistedProviderForStaticDi(LocalModelCursorLoaderManagerProvider.class));
    }
}
