package com.facebook.timeline.publisher;

import android.app.Activity;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.timeline.datafetcher.TimelineStoriesDataFetcher;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.logging.TimelineAnalyticsLogger;

/* compiled from: failed to load currency data */
public class TimelinePublishControllerImplProvider extends AbstractAssistedProvider<TimelinePublishControllerImpl> {
    public final TimelinePublishControllerImpl m12468a(Activity activity, TimelineAnalyticsLogger timelineAnalyticsLogger, TimelineContext timelineContext, TimelineHeaderUserData timelineHeaderUserData, TimelineStoriesDataFetcher timelineStoriesDataFetcher) {
        return new TimelinePublishControllerImpl(activity, timelineAnalyticsLogger, timelineContext, timelineHeaderUserData, timelineStoriesDataFetcher, IdBasedLazy.a(this, 2371), (ComposerLauncher) ComposerLauncherImpl.a(this), IdBasedSingletonScopeProvider.a(this, 137), IdBasedSingletonScopeProvider.a(this, 11389));
    }
}
