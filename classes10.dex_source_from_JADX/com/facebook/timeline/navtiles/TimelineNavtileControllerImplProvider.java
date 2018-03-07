package com.facebook.timeline.navtiles;

import android.content.Context;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.logging.TimelineAnalyticsLogger;
import com.facebook.timeline.taggedmediaset.TimelineTaggedMediaSetData;

/* compiled from: feedback_confirm_dialog */
public class TimelineNavtileControllerImplProvider extends AbstractAssistedProvider<TimelineNavtileControllerImpl> {
    public final TimelineNavtileControllerImpl m12083a(Context context, TimelineAnalyticsLogger timelineAnalyticsLogger, TimelineContext timelineContext, TimelineTaggedMediaSetData timelineTaggedMediaSetData, TimelineHeaderUserData timelineHeaderUserData) {
        return new TimelineNavtileControllerImpl(context, timelineAnalyticsLogger, timelineContext, timelineTaggedMediaSetData, timelineHeaderUserData, IdBasedSingletonScopeProvider.a(this, 616), IdBasedSingletonScopeProvider.a(this, 137));
    }
}
