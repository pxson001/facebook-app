package com.facebook.video.engine;

import android.view.View;
import com.facebook.common.eventbus.TypedEventBus;
import com.facebook.video.analytics.ChannelEligibility;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.api.VideoMetadata;
import com.facebook.video.api.playersession.VideoPlayerBase;
import com.facebook.video.engine.texview.VideoSurfaceTarget;
import com.facebook.video.subtitles.controller.Subtitles;
import javax.annotation.Nullable;

/* compiled from: pending_jewel_ids */
public interface VideoPlayer extends VideoPlayerBase {

    /* compiled from: pending_jewel_ids */
    public enum PlayerState {
        STATE_ERROR("state_error"),
        STATE_IDLE("state_idle"),
        STATE_PREPARING("state_preparing"),
        STATE_PREPARED("state_prepared"),
        STATE_PLAYING("state_playing"),
        STATE_PAUSED("state_paused"),
        STATE_PLAYBACK_COMPLETED("state_playback_completed");
        
        public final String value;

        private PlayerState(String str) {
            this.value = str;
        }

        public final String toString() {
            return this.value;
        }
    }

    void mo471a(float f);

    void mo473a(int i, EventTriggerType eventTriggerType);

    void mo499a(ChannelEligibility channelEligibility);

    void mo474a(EventTriggerType eventTriggerType);

    void mo476a(EventTriggerType eventTriggerType, PlayPosition playPosition);

    void mo500a(PlayerOrigin playerOrigin);

    void mo501a(PlayerType playerType);

    void mo477a(VideoSourceType videoSourceType, @Nullable String str, EventTriggerType eventTriggerType);

    void mo478a(VideoPlayerParams videoPlayerParams);

    void mo479a(VideoResolution videoResolution, EventTriggerType eventTriggerType);

    void mo481a(VideoSurfaceTarget videoSurfaceTarget);

    void mo483a(Subtitles subtitles);

    void mo485a(boolean z, EventTriggerType eventTriggerType);

    void mo489b(EventTriggerType eventTriggerType);

    void mo490c(EventTriggerType eventTriggerType);

    void mo491d();

    @Deprecated
    void mo502d(EventTriggerType eventTriggerType);

    @Nullable
    VideoResolution mo492e();

    void mo503e(EventTriggerType eventTriggerType);

    void mo493f();

    PlayerOrigin mo504g();

    boolean mo505h();

    boolean mo506i();

    boolean mo507j();

    View mo495k();

    int mo508l();

    int mo509m();

    void mo510n();

    Subtitles mo511o();

    VideoMetadata mo512p();

    TypedEventBus mo513q();

    String mo496r();

    int mo514s();

    long mo515t();
}
