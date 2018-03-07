package com.facebook.video.engine.logverifier;

import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.VideoAnalyticsEvents;
import javax.annotation.Nullable;

/* compiled from: composer_text_ready */
public class VideoLoggingFullVerifierBase$LogEntry {
    public final VideoAnalyticsEvents f18831a;
    public final long f18832b;
    public final long f18833c;
    public final EventTriggerType f18834d;
    public final EventTriggerType f18835e;
    public final String f18836f;
    public final String f18837g;

    public VideoLoggingFullVerifierBase$LogEntry(VideoAnalyticsEvents videoAnalyticsEvents, long j, long j2, @Nullable EventTriggerType eventTriggerType, @Nullable EventTriggerType eventTriggerType2, @Nullable String str, @Nullable String str2) {
        this.f18831a = videoAnalyticsEvents;
        this.f18832b = j;
        this.f18833c = j2;
        this.f18834d = eventTriggerType;
        this.f18835e = eventTriggerType2;
        this.f18836f = str;
        this.f18837g = str2;
    }
}
