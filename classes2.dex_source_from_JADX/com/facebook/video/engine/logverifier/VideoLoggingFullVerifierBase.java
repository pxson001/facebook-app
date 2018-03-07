package com.facebook.video.engine.logverifier;

import android.support.v4.util.LruCache;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.time.MonotonicClock;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.VideoAnalyticsAttributes;
import com.facebook.video.analytics.VideoAnalytics.VideoAnalyticsEvents;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableSet;
import java.util.Map;
import java.util.Set;

/* compiled from: is-live */
public abstract class VideoLoggingFullVerifierBase {
    public static final Map<VideoAnalyticsEvents, Set<VideoAnalyticsEvents>> f19396d;
    private final MonotonicClock f19397a;
    private final long f19398b;
    private LruCache<String, VideoSessionEntry> f19399c;

    protected abstract void mo3106a(VideoSessionEntry videoSessionEntry);

    public VideoLoggingFullVerifierBase(MonotonicClock monotonicClock, long j, int i) {
        this.f19397a = monotonicClock;
        this.f19399c = new LruCache(i);
        this.f19398b = j;
    }

    public boolean mo3107a() {
        return false;
    }

    public void mo3108a(HoneyClientEvent honeyClientEvent) {
        if (mo3107a()) {
            Object m = honeyClientEvent.m5101m(VideoAnalyticsAttributes.VIDEO_ID.value);
            if (m != null) {
                VideoSessionEntry a = m27112a((String) m);
                LogEntry b = m27111b(honeyClientEvent);
                a.c.add(b);
                if (f19396d.keySet().contains(b.a)) {
                    a.d = ((Set) f19396d.get(a.f)).contains(b.a);
                    a.f = b.a;
                    a.e = ((Set) f19396d.get(b.a)).isEmpty();
                }
                if (!a.d) {
                    mo3106a(a);
                }
                if (a.e) {
                    this.f19399c.m4438b(m);
                }
            }
        }
    }

    private LogEntry m27111b(HoneyClientEvent honeyClientEvent) {
        EventTriggerType eventTriggerType = null;
        VideoAnalyticsEvents asEvent = VideoAnalyticsEvents.asEvent(honeyClientEvent.f3111d);
        String m = honeyClientEvent.m5101m(VideoAnalyticsAttributes.VIDEO_PLAY_REASON.value);
        String m2 = honeyClientEvent.m5101m(VideoAnalyticsAttributes.VIDEO_CHANGE_REASON.value);
        String m3 = honeyClientEvent.m5101m(VideoAnalyticsAttributes.VIDEO_TIME_POSITION_PARAM.value);
        String m4 = honeyClientEvent.m5101m(VideoAnalyticsAttributes.PLAYER_ORIGIN.value);
        String m5 = honeyClientEvent.m5101m(VideoAnalyticsAttributes.PLAYER_SUBORIGIN.value);
        long parseDouble = m3 == null ? -1 : (long) (Double.parseDouble(m3) * 1000.0d);
        EventTriggerType asEventTriggerType = m == null ? null : EventTriggerType.asEventTriggerType(m);
        if (m2 != null) {
            eventTriggerType = EventTriggerType.asEventTriggerType(m2);
        }
        return new LogEntry(asEvent, this.f19397a.now(), parseDouble, eventTriggerType, asEventTriggerType, m4, m5);
    }

    protected final VideoSessionEntry m27112a(String str) {
        VideoSessionEntry videoSessionEntry = (VideoSessionEntry) this.f19399c.m4432a((Object) str);
        if (videoSessionEntry != null && this.f19397a.now() - videoSessionEntry.b > this.f19398b) {
            this.f19399c.m4438b((Object) str);
            videoSessionEntry = null;
        }
        if (videoSessionEntry != null) {
            return videoSessionEntry;
        }
        Object videoSessionEntry2 = new VideoSessionEntry(str, this.f19397a.now());
        this.f19399c.m4433a((Object) str, videoSessionEntry2);
        return videoSessionEntry2;
    }

    static {
        Map c = Maps.m838c();
        f19396d = c;
        c.put(null, ImmutableSet.of(VideoAnalyticsEvents.VIDEO_REQUESTED_PLAYING));
        f19396d.put(VideoAnalyticsEvents.VIDEO_REQUESTED_PLAYING, ImmutableSet.of(VideoAnalyticsEvents.VIDEO_CANCELLED_REQUESTED_PLAYING, VideoAnalyticsEvents.VIDEO_START, VideoAnalyticsEvents.VIDEO_UNPAUSED));
        f19396d.put(VideoAnalyticsEvents.VIDEO_START, ImmutableSet.of(VideoAnalyticsEvents.VIDEO_PAUSE, VideoAnalyticsEvents.VIDEO_COMPLETE));
        f19396d.put(VideoAnalyticsEvents.VIDEO_UNPAUSED, ImmutableSet.of(VideoAnalyticsEvents.VIDEO_PAUSE, VideoAnalyticsEvents.VIDEO_COMPLETE));
        RegularImmutableSet regularImmutableSet = RegularImmutableSet.f688a;
        f19396d.put(VideoAnalyticsEvents.VIDEO_CANCELLED_REQUESTED_PLAYING, regularImmutableSet);
        f19396d.put(VideoAnalyticsEvents.VIDEO_PAUSE, regularImmutableSet);
        f19396d.put(VideoAnalyticsEvents.VIDEO_COMPLETE, regularImmutableSet);
    }
}
