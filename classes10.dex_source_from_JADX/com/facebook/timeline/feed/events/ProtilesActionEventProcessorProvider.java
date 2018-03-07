package com.facebook.timeline.feed.events;

import android.content.Context;
import com.facebook.analytics.NavigationLogger;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.logging.TimelineAnalyticsLogger;
import com.facebook.timeline.protiles.util.TimelineCollapsedProtilesExperimentHelper;
import com.facebook.timeline.taggedmediaset.TimelineTaggedMediaSetData;

/* compiled from: friends_nearby_invite */
public class ProtilesActionEventProcessorProvider extends AbstractAssistedProvider<ProtilesActionEventProcessor> {
    public final ProtilesActionEventProcessor m11300a(TimelineHeaderUserData timelineHeaderUserData, TimelineTaggedMediaSetData timelineTaggedMediaSetData, TimelineContext timelineContext, TimelineAnalyticsLogger timelineAnalyticsLogger) {
        return new ProtilesActionEventProcessor(timelineHeaderUserData, timelineTaggedMediaSetData, timelineContext, timelineAnalyticsLogger, NavigationLogger.a(this), FbUriIntentHandler.a(this), EventsStream.a(this), (Context) getInstance(Context.class), TimelineCollapsedProtilesExperimentHelper.m12438a((InjectorLike) this));
    }
}
