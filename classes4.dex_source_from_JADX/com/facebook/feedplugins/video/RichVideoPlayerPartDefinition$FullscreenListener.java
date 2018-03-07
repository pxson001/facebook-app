package com.facebook.feedplugins.video;

import com.facebook.attachments.utils.CallToActionUtil;
import com.facebook.debug.fps.FrameRateBlameMarkers;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.ui.fullscreenvideoplayer.FeedFullScreenVideoElapsedMonitor;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.StoryEvents.VideoClickedEvent;
import com.facebook.feed.video.FeedFullScreenParams.AugmentedAnalyticsParams;
import com.facebook.feedplugins.attachments.video.FullscreenTransitionListener;
import com.facebook.feedplugins.video.RichVideoPlayerPartDefinition.VideoSizeAndBackgroundOverride;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.engine.ExitFullScreenResult;
import com.facebook.video.engine.PlayPosition;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.player.FullScreenVideoListener;
import com.facebook.video.player.RichVideoPlayer;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* compiled from: pic */
class RichVideoPlayerPartDefinition$FullscreenListener implements FullScreenVideoListener {
    private final RichVideoPlayerPartDefinition$State f4990a;
    private final FrameRateBlameMarkers f4991b;
    private final VideoLoggingUtils f4992c;
    private final FeedFullScreenVideoElapsedMonitor f4993d;
    private final FeedEventBus f4994e;
    @Nullable
    private FullscreenTransitionListener f4995f;
    private final Optional<VideoSizeAndBackgroundOverride> f4996g;
    private final CallToActionUtil f4997h;
    private WeakReference<RichVideoPlayer> f4998i;

    public RichVideoPlayerPartDefinition$FullscreenListener(RichVideoPlayerPartDefinition$State richVideoPlayerPartDefinition$State, FrameRateBlameMarkers frameRateBlameMarkers, VideoLoggingUtils videoLoggingUtils, FeedFullScreenVideoElapsedMonitor feedFullScreenVideoElapsedMonitor, FeedEventBus feedEventBus, Optional<VideoSizeAndBackgroundOverride> optional, CallToActionUtil callToActionUtil) {
        this.f4990a = richVideoPlayerPartDefinition$State;
        this.f4991b = frameRateBlameMarkers;
        this.f4992c = videoLoggingUtils;
        this.f4993d = feedFullScreenVideoElapsedMonitor;
        this.f4994e = feedEventBus;
        this.f4996g = optional;
        this.f4997h = callToActionUtil;
    }

    public final void m5373a(RichVideoPlayer richVideoPlayer) {
        this.f4998i = new WeakReference(richVideoPlayer);
    }

    public final void m5370a(FullscreenTransitionListener fullscreenTransitionListener) {
        Preconditions.checkNotNull(fullscreenTransitionListener, "listener already set");
        this.f4995f = fullscreenTransitionListener;
    }

    public final void mo427a(EventTriggerType eventTriggerType) {
        this.f4993d.a(this.f4990a.f4983o);
        RichVideoPlayer richVideoPlayer = (RichVideoPlayer) this.f4998i.get();
        if (richVideoPlayer != null) {
            richVideoPlayer.setBackgroundResource(0);
            if (!this.f4990a.f4988t.g()) {
                this.f4992c.b(this.f4990a.f4983o.m5341m(), PlayerType.INLINE_PLAYER.value, eventTriggerType.value, this.f4990a.f4983o.m5339j(), this.f4990a.f4983o.m5345r(), this.f4990a.f4983o.f4946d.b, this.f4990a.f4983o.m5342o(), new AugmentedAnalyticsParams(this.f4990a.f4983o, this.f4990a.f4976h.f4962a));
            }
            FeedProps feedProps = this.f4990a.f4971c;
            if (feedProps != null) {
                GraphQLStory c = StoryProps.c(feedProps);
                this.f4994e.a(new VideoClickedEvent(((GraphQLStory) feedProps.a).g(), c != null ? c.g() : null));
            }
        }
    }

    public final void mo428a(EventTriggerType eventTriggerType, ExitFullScreenResult exitFullScreenResult) {
        if (!this.f4990a.f4988t.g()) {
            this.f4992c.a(this.f4990a.f4983o.m5341m(), PlayerType.INLINE_PLAYER.value, eventTriggerType.value, exitFullScreenResult.c, this.f4990a.f4983o.m5345r(), this.f4990a.f4983o.f4946d.b, this.f4990a.f4983o.m5342o(), new AugmentedAnalyticsParams(this.f4990a.f4983o, this.f4990a.f4976h.f4962a));
        }
        this.f4990a.f4986r = false;
        RichVideoPlayer richVideoPlayer = (RichVideoPlayer) this.f4998i.get();
        if (richVideoPlayer != null) {
            Object obj;
            richVideoPlayer.setBackgroundResource(RichVideoPlayerPartDefinition.a(this.f4996g));
            this.f4990a.f4977i.m5314a(exitFullScreenResult.b, exitFullScreenResult.a);
            this.f4990a.f4978j.mo421a(exitFullScreenResult.c);
            if (exitFullScreenResult.b || exitFullScreenResult.a || exitFullScreenResult.c <= 0) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                richVideoPlayer.setOriginalPlayReason(this.f4990a.f4975g.b);
                richVideoPlayer.setChannelEligibility(this.f4990a.f4975g.c);
                RichVideoPlayerPartDefinition.b(richVideoPlayer, this.f4990a, this.f4991b, EventTriggerType.BY_INLINE_FULLSCREEN_TRANSITION, new PlayPosition(exitFullScreenResult.c, exitFullScreenResult.d));
            } else if (exitFullScreenResult.b && this.f4997h.c(this.f4990a.f4970b)) {
                this.f4990a.f4978j.f4907a = true;
            }
            if (exitFullScreenResult.b) {
                RichVideoPlayerPartDefinition.c(this.f4990a, EventTriggerType.UNSET);
            }
            if (this.f4995f != null) {
                this.f4995f.mo438a(exitFullScreenResult);
            }
            this.f4993d.a();
        }
    }
}
