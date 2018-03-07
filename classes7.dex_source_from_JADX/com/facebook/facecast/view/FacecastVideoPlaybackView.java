package com.facebook.facecast.view;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.content.event.FbEvent;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.engine.VideoDataSource;
import com.facebook.video.engine.VideoDataSourceBuilder;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerParamsBuilder;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerParams.Builder;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.ClickToPlayAnimationPlugin;
import com.facebook.video.player.plugins.FullscreenSeekBarPlugin;
import com.facebook.video.player.plugins.LoadingSpinnerPlugin;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.facebook.video.player.plugins.VideoPlugin;

/* compiled from: auxiliary_action */
public class FacecastVideoPlaybackView extends RichVideoPlayer {
    private FullscreenSeekBarPlugin f18836i;
    private ClickToPlayAnimationPlugin f18837j;
    public RVPPlayerStateChangedEventSubscriber f18838k;

    /* compiled from: auxiliary_action */
    class RVPPlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ FacecastVideoPlaybackView f18835a;

        public RVPPlayerStateChangedEventSubscriber(FacecastVideoPlaybackView facecastVideoPlaybackView) {
            this.f18835a = facecastVideoPlaybackView;
        }

        public final void m22431b(FbEvent fbEvent) {
            if (((RVPPlayerStateChangedEvent) fbEvent).b == State.PREPARED) {
                this.f18835a.b(this.f18835a.f18838k);
                this.f18835a.m22434a();
            }
        }

        public final Class<RVPPlayerStateChangedEvent> m22430a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    public FacecastVideoPlaybackView(Context context) {
        this(context, null);
    }

    public FacecastVideoPlaybackView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m22433v();
    }

    private void m22433v() {
        this.f18836i = new FullscreenSeekBarPlugin(getContext());
        this.f18837j = new ClickToPlayAnimationPlugin(getContext());
        a(new VideoPlugin(getContext()));
        a(new LoadingSpinnerPlugin(getContext()));
        a(this.f18837j);
        a(this.f18836i);
        m22438u();
        this.f18838k = new RVPPlayerStateChangedEventSubscriber(this);
        a(this.f18838k);
    }

    public final void m22435a(Uri uri) {
        setPlayerOrigin(PlayerOrigin.LIVE_VIDEO_END_SCREEN);
        VideoDataSourceBuilder newBuilder = VideoDataSource.newBuilder();
        newBuilder.a = uri;
        newBuilder = newBuilder;
        newBuilder.f = StreamSourceType.FROM_LOCAL_STORAGE;
        VideoPlayerParamsBuilder a = VideoPlayerParams.newBuilder().a(newBuilder.i());
        a.r = true;
        a = a;
        a.g = true;
        a = a;
        Builder builder = new Builder();
        builder.a = a.m();
        a(builder.a("VideoAspectRatioKey", Double.valueOf(1.0d)).b());
        a(false, EventTriggerType.BY_PLAYER);
    }

    public final void m22434a() {
        if (!m()) {
            a(EventTriggerType.BY_PLAYER);
        }
    }

    public final void m22436b() {
        if (m()) {
            b(EventTriggerType.BY_PLAYER);
        }
    }

    public final void m22437t() {
        this.f18837j.a(this);
        this.f18836i.a(this);
    }

    public final void m22438u() {
        this.f18836i.b(this);
        this.f18837j.b(this);
    }
}
