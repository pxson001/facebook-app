package com.facebook.feedplugins.musicstory.utils;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.feedplugins.musicstory.utils.MusicStoryLoggingParams.Param;
import com.facebook.inject.Assisted;
import com.google.common.base.Preconditions;
import java.util.HashSet;
import javax.inject.Inject;

/* compiled from: com.facebook.katana.settings.activity.SettingsActivity */
public class MusicStoryLogger {
    private final AnalyticsLogger f8406a;
    private final MusicStoryLoggingParams f8407b;

    /* compiled from: com.facebook.katana.settings.activity.SettingsActivity */
    public enum ActionType {
        deep_link,
        spotify_save,
        spotify_unsave,
        auth_success,
        auth_fail
    }

    /* compiled from: com.facebook.katana.settings.activity.SettingsActivity */
    enum Event {
        PLAY("music_play"),
        TAP_TO_PLAY("music_play_requested"),
        PAUSE("music_pause"),
        PLAYBACK_FINISHED("music_reached_end"),
        PLAYBACK_FAILED("music_error"),
        TAP_ON_CTA("music_cta_click");
        
        private final String name;

        private Event(String str) {
            this.name = str;
        }

        public final String toString() {
            return this.name;
        }
    }

    /* compiled from: com.facebook.katana.settings.activity.SettingsActivity */
    enum EventData {
        PLAYBACK_DURATION("play_duration_ms"),
        SONG_DURATION("audio_duration_ms"),
        STALL_DURATION("stall_duration_ms"),
        ERROR("error"),
        CTA_ACTION("cta_action");
        
        private final String name;

        private EventData(String str) {
            this.name = str;
        }

        public final String toString() {
            return this.name;
        }
    }

    @Inject
    public MusicStoryLogger(@Assisted MusicStoryLoggingParams musicStoryLoggingParams, AnalyticsLogger analyticsLogger) {
        this.f8407b = musicStoryLoggingParams;
        this.f8406a = analyticsLogger;
    }

    public final void m9315a(ActionType actionType) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Event.TAP_ON_CTA.toString());
        honeyClientEvent.c = "newsfeed_music_story_view";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.b(EventData.CTA_ACTION.toString(), actionType.toString());
        m9311a(honeyClientEvent);
    }

    public final void m9316a(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Event.PLAYBACK_FAILED.toString());
        honeyClientEvent.c = "newsfeed_music_story_view";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.b(EventData.ERROR.toString(), str);
        m9311a(honeyClientEvent);
    }

    public final void m9314a(long j, long j2) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Event.PLAY.toString());
        honeyClientEvent.c = "newsfeed_music_story_view";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.a(EventData.SONG_DURATION.toString(), j);
        honeyClientEvent.a(EventData.STALL_DURATION.toString(), j2);
        m9311a(honeyClientEvent);
    }

    public final void m9312a() {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Event.TAP_TO_PLAY.toString());
        honeyClientEvent.c = "newsfeed_music_story_view";
        m9311a(honeyClientEvent);
    }

    public final void m9313a(int i, int i2) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Event.PAUSE.toString());
        honeyClientEvent.c = "newsfeed_music_story_view";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.a(EventData.PLAYBACK_DURATION.toString(), i2);
        honeyClientEvent.a(EventData.SONG_DURATION.toString(), i);
        m9311a(honeyClientEvent);
    }

    public final void m9317b(int i, int i2) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Event.PLAYBACK_FINISHED.toString());
        honeyClientEvent.c = "newsfeed_music_story_view";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.a(EventData.PLAYBACK_DURATION.toString(), i2);
        honeyClientEvent.a(EventData.SONG_DURATION.toString(), i);
        m9311a(honeyClientEvent);
    }

    private void m9311a(HoneyClientEvent honeyClientEvent) {
        MusicStoryLoggingParams musicStoryLoggingParams = this.f8407b;
        for (Param param : new HashSet(musicStoryLoggingParams.f8408a.keySet())) {
            String param2 = param.toString();
            Preconditions.checkState(musicStoryLoggingParams.f8408a.containsKey(param));
            honeyClientEvent.b(param2, (String) musicStoryLoggingParams.f8408a.get(param));
        }
        this.f8406a.a(honeyClientEvent);
    }
}
