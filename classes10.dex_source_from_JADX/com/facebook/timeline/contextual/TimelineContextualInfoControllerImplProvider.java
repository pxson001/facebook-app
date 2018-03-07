package com.facebook.timeline.contextual;

import android.content.Context;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.timeline.datafetcher.TimelineDataFetcher;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.logging.TimelineAnalyticsLogger;

/* compiled from: group_notification_settings */
public class TimelineContextualInfoControllerImplProvider extends AbstractAssistedProvider<TimelineContextualInfoControllerImpl> {
    public final TimelineContextualInfoControllerImpl m10467a(Context context, TimelineAnalyticsLogger timelineAnalyticsLogger, TimelineContext timelineContext, TimelineContextualInfoData timelineContextualInfoData, TimelineDataFetcher timelineDataFetcher, TimelineHeaderUserData timelineHeaderUserData) {
        return new TimelineContextualInfoControllerImpl(context, timelineAnalyticsLogger, timelineContext, timelineContextualInfoData, timelineDataFetcher, timelineHeaderUserData, IdBasedSingletonScopeProvider.a(this, 11387), IdBasedSingletonScopeProvider.a(this, 11216));
    }
}
