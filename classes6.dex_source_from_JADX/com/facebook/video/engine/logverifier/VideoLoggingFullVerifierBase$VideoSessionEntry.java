package com.facebook.video.engine.logverifier;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.video.analytics.VideoAnalytics.VideoAnalyticsEvents;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: composer_text_ready */
public class VideoLoggingFullVerifierBase$VideoSessionEntry {
    public final String f18838a;
    public final long f18839b;
    public final List<VideoLoggingFullVerifierBase$LogEntry> f18840c = Lists.a(10);
    public boolean f18841d = true;
    public boolean f18842e = false;
    public VideoAnalyticsEvents f18843f = null;

    public VideoLoggingFullVerifierBase$VideoSessionEntry(String str, long j) {
        this.f18838a = str;
        this.f18839b = j;
    }

    public final String m27534c() {
        StringBuilder stringBuilder = new StringBuilder(500);
        stringBuilder.append(StringFormatUtil.formatStrLocaleSafe("VideoSession VideoID '%s' Time: %d\n", this.f18838a, Long.valueOf(this.f18839b)));
        for (VideoLoggingFullVerifierBase$LogEntry videoLoggingFullVerifierBase$LogEntry : this.f18840c) {
            stringBuilder.append(StringFormatUtil.a("- %d %s (%s, original: %s), video time: %d, origin: %s:%s\n", new Object[]{Long.valueOf(videoLoggingFullVerifierBase$LogEntry.f18832b), videoLoggingFullVerifierBase$LogEntry.f18831a, videoLoggingFullVerifierBase$LogEntry.f18834d, videoLoggingFullVerifierBase$LogEntry.f18835e, Long.valueOf(videoLoggingFullVerifierBase$LogEntry.f18833c), videoLoggingFullVerifierBase$LogEntry.f18836f, videoLoggingFullVerifierBase$LogEntry.f18837g}));
        }
        return stringBuilder.toString();
    }
}
