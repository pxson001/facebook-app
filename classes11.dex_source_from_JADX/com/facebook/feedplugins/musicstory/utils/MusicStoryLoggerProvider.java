package com.facebook.feedplugins.musicstory.utils;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: com.facebook.katana.profile.type */
public class MusicStoryLoggerProvider extends AbstractAssistedProvider<MusicStoryLogger> {
    public final MusicStoryLogger m9318a(MusicStoryLoggingParams musicStoryLoggingParams) {
        return new MusicStoryLogger(musicStoryLoggingParams, AnalyticsLoggerMethodAutoProvider.a(this));
    }
}
