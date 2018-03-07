package com.facebook.video.engine.logverifier;

import android.util.Pair;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.MonotonicClock;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.VideoAnalyticsAttributes;
import com.facebook.video.analytics.VideoAnalytics.VideoAnalyticsEvents;
import com.facebook.video.engine.logverifier.VideoLoggingStateMachineVerifier.BasicVideoState;
import java.util.List;
import java.util.Set;

/* compiled from: composer_text_pasted */
class VideoLoggingStateMachineVerifier$VideoStateChecker {
    long f18845a = 0;
    long f18846b = 0;
    EventTriggerType f18847c;
    BasicVideoState f18848d = BasicVideoState.ERROR;
    private final MonotonicClock f18849e;
    private long f18850f;

    public VideoLoggingStateMachineVerifier$VideoStateChecker(MonotonicClock monotonicClock) {
        this.f18849e = monotonicClock;
    }

    public final boolean m27540a(HoneyClientEvent honeyClientEvent, boolean z, List<Pair<String, String>> list) {
        VideoAnalyticsEvents asEvent = VideoAnalyticsEvents.asEvent(honeyClientEvent.k());
        if (!m27537a(asEvent)) {
            return true;
        }
        boolean z2 = true;
        switch (VideoLoggingStateMachineVerifier$1.f18844a[this.f18848d.ordinal()]) {
            case 1:
                VideoLoggingStateMachineVerifier.h(asEvent);
                if (VideoLoggingStateMachineVerifier.g(asEvent) && asEvent != VideoAnalyticsEvents.VIDEO_CANCELLED_REQUESTED_PLAYING) {
                    list.add(new Pair("Invalid state transition: REQUESTED_PLAY -> PAUSED", StringFormatUtil.a("In REQUESTED_PLAY state but received a pause event that is not %s: %s", new Object[]{VideoAnalyticsEvents.VIDEO_CANCELLED_REQUESTED_PLAYING, asEvent.value})));
                    z2 = false;
                    break;
                }
            case 2:
                if (VideoLoggingStateMachineVerifier.f(asEvent)) {
                    list.add(new Pair("Invalid state transition: PLAYING -> PLAYING", StringFormatUtil.a("In PLAYING state but received a PLAYING event: %s", new Object[]{asEvent.value})));
                    z2 = false;
                }
                if (VideoLoggingStateMachineVerifier.h(asEvent)) {
                    list.add(new Pair("Invalid state transition: PLAYING -> REQUESTED_PLAY", StringFormatUtil.a("In PLAYING state but received a REQUESTED_PLAY event: %s", new Object[]{asEvent.value})));
                    z2 = false;
                }
                if (VideoLoggingStateMachineVerifier.i(asEvent)) {
                    list.add(new Pair("Invalid state transition: PLAYING -> SEEKING", StringFormatUtil.a("In PLAYING state but received SEEKING event: %s", new Object[]{asEvent.value})));
                    z2 = false;
                    break;
                }
                break;
            case 3:
                if (VideoLoggingStateMachineVerifier.f(asEvent)) {
                    list.add(new Pair("Invalid state transition: PAUSED -> PLAYING", StringFormatUtil.a("In PAUSED state but received PLAYING event: %s", new Object[]{asEvent.value})));
                    z2 = false;
                }
                if (VideoLoggingStateMachineVerifier.g(asEvent)) {
                    list.add(new Pair("Invalid state transition: PAUSED -> PAUSED", StringFormatUtil.a("In PAUSED state but received another PAUSED event: %s", new Object[]{asEvent.value})));
                    z2 = false;
                    break;
                }
                break;
        }
        BasicVideoState j = VideoLoggingStateMachineVerifier.j(asEvent);
        if (z && j != this.f18848d) {
            boolean z3;
            if (VideoLoggingStateMachineVerifier.f(asEvent)) {
                long a = m27535a(honeyClientEvent);
                if (a < 0) {
                    list.add(new Pair("Invalid metadata: " + VideoAnalyticsAttributes.VIDEO_TIME_POSITION_PARAM, StringFormatUtil.a("Video time position is negative on play event: %d", new Object[]{Long.valueOf(a)})));
                    z2 = false;
                }
                this.f18850f = this.f18849e.now();
                this.f18845a = a;
                this.f18846b = a;
                this.f18847c = m27539c(honeyClientEvent);
                if (!(this.f18847c == EventTriggerType.BY_AUTOPLAY || this.f18847c == EventTriggerType.BY_USER)) {
                    list.add(new Pair("Invalid metadata: " + VideoAnalyticsAttributes.VIDEO_PLAY_REASON, StringFormatUtil.a("Invalid value for Video Play Reason: %s", new Object[]{this.f18847c})));
                    z2 = false;
                }
            }
            if (VideoLoggingStateMachineVerifier.g(asEvent) && asEvent != VideoAnalyticsEvents.VIDEO_CANCELLED_REQUESTED_PLAYING) {
                this.f18846b = m27535a(honeyClientEvent);
                if (this.f18846b < this.f18845a) {
                    list.add(new Pair("Metadata inconcistency: Pause Time < Last Start Time", StringFormatUtil.a("Pause Time (%d) is smaller than Last Start Time (%d)", new Object[]{Long.valueOf(this.f18846b), Long.valueOf(this.f18845a)})));
                    z2 = false;
                }
                if (this.f18845a != m27538b(honeyClientEvent)) {
                    list.add(new Pair("Metadata inconcistency: Event LST != State Machine LST", StringFormatUtil.a("Event Last Start Time (%d) is different than state machine Last Start Time (%d)", new Object[]{Long.valueOf(m27538b(honeyClientEvent)), Long.valueOf(this.f18845a)})));
                    z2 = false;
                }
                if (((double) (this.f18846b - this.f18845a)) > 1.01d * ((double) (this.f18849e.now() - this.f18850f))) {
                    list.add(new Pair("Metadata inconcistency: Watch time interval > system clock difference", StringFormatUtil.a("Watch Time interval duration (%d) is greater than system clock difference for the period (%d)", new Object[]{Long.valueOf(this.f18846b - this.f18845a), Long.valueOf(this.f18849e.now() - this.f18850f)})));
                    z3 = false;
                    if (((Set) VideoLoggingStateMachineVerifier.h.get(VideoAnalyticsAttributes.PLAYER_ORIGIN)).contains(m27536a(honeyClientEvent, VideoAnalyticsAttributes.PLAYER_ORIGIN))) {
                        list.add(new Pair("Invalid metadata: " + VideoAnalyticsAttributes.PLAYER_ORIGIN, StringFormatUtil.a("Invalid value for Player Origin: %s", new Object[]{r3})));
                        z2 = false;
                    } else {
                        z2 = z3;
                    }
                }
            }
            z3 = z2;
            if (((Set) VideoLoggingStateMachineVerifier.h.get(VideoAnalyticsAttributes.PLAYER_ORIGIN)).contains(m27536a(honeyClientEvent, VideoAnalyticsAttributes.PLAYER_ORIGIN))) {
                z2 = z3;
            } else {
                list.add(new Pair("Invalid metadata: " + VideoAnalyticsAttributes.PLAYER_ORIGIN, StringFormatUtil.a("Invalid value for Player Origin: %s", new Object[]{r3})));
                z2 = false;
            }
        }
        this.f18848d = j;
        return z2;
    }

    private static boolean m27537a(VideoAnalyticsEvents videoAnalyticsEvents) {
        return VideoLoggingStateMachineVerifier.g.contains(videoAnalyticsEvents);
    }

    private static String m27536a(HoneyClientEvent honeyClientEvent, VideoAnalyticsAttributes videoAnalyticsAttributes) {
        return honeyClientEvent.m(videoAnalyticsAttributes.value);
    }

    private long m27535a(HoneyClientEvent honeyClientEvent) {
        String a = m27536a(honeyClientEvent, VideoAnalyticsAttributes.VIDEO_TIME_POSITION_PARAM);
        return a == null ? -1 : (long) (Double.parseDouble(a) * 1000.0d);
    }

    private long m27538b(HoneyClientEvent honeyClientEvent) {
        String a = m27536a(honeyClientEvent, VideoAnalyticsAttributes.LAST_START_POSITION_PARAM);
        return a == null ? -1 : (long) (Double.parseDouble(a) * 1000.0d);
    }

    private EventTriggerType m27539c(HoneyClientEvent honeyClientEvent) {
        String a = m27536a(honeyClientEvent, VideoAnalyticsAttributes.VIDEO_PLAY_REASON);
        return a == null ? null : EventTriggerType.asEventTriggerType(a);
    }
}
