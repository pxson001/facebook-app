package com.facebook.video.watchandbrowse;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.katana.app.module.Boolean_IsVideoSpecDisplayEnabledMethodAutoProvider;
import com.facebook.video.abtest.Video360PlayerConfig;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.channelfeed.abtest.ChannelFeedConfig;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoResolution;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.plugins.Video360Plugin;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: should_show_to_buyer */
public class WatchAndBrowseFullScreenVideoPlayer extends CustomFrameLayout {
    @Inject
    VideoLoggingUtils f3428a;
    @Inject
    VideoWatchAndBrowseFullScreenVideoPlayerPluginSelector f3429b;
    private final RichVideoPlayer f3430c;
    private RichVideoPlayerParams f3431d;
    public PlayerOrigin f3432e;

    private static <T extends View> void m3251a(Class<T> cls, T t) {
        m3252a((Object) t, t.getContext());
    }

    private static void m3252a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((WatchAndBrowseFullScreenVideoPlayer) obj).m3250a(VideoLoggingUtils.a(fbInjector), new VideoWatchAndBrowseFullScreenVideoPlayerPluginSelector((Context) fbInjector.getInstance(Context.class), Video360PlayerConfig.b(fbInjector), ChannelFeedConfig.a(fbInjector), Boolean_IsVideoSpecDisplayEnabledMethodAutoProvider.b(fbInjector)));
    }

    public WatchAndBrowseFullScreenVideoPlayer(Context context) {
        this(context, null);
    }

    public WatchAndBrowseFullScreenVideoPlayer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WatchAndBrowseFullScreenVideoPlayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3432e = PlayerOrigin.UNKNOWN;
        m3251a(WatchAndBrowseFullScreenVideoPlayer.class, (View) this);
        setContentView(2130904554);
        this.f3430c = new RichVideoPlayer(context);
        this.f3430c.setPlayerType(PlayerType.FULL_SCREEN_PLAYER);
        addView(this.f3430c);
    }

    public final void m3254a(RichVideoPlayerParams richVideoPlayerParams, int i, int i2, VideoResolution videoResolution) {
        this.f3431d = richVideoPlayerParams;
        this.f3430c.setPlayerOrigin(this.f3432e);
        this.f3429b.a(this.f3430c, richVideoPlayerParams, null);
        this.f3430c.a(richVideoPlayerParams);
        if (richVideoPlayerParams.a.s != null) {
            Video360Plugin video360Plugin = (Video360Plugin) this.f3430c.a(Video360Plugin.class);
            if (video360Plugin != null) {
                video360Plugin.f();
            }
        }
        this.f3428a.a(richVideoPlayerParams.a.e, PlayerType.FULL_SCREEN_PLAYER.value, PlayerType.WATCH_AND_BROWSE.value, richVideoPlayerParams.a.b, this.f3432e, EventTriggerType.BY_USER.value, i, i2, richVideoPlayerParams.a.f, richVideoPlayerParams.a, null, null);
        this.f3430c.a(false, EventTriggerType.BY_USER);
        this.f3430c.a(videoResolution, EventTriggerType.BY_USER);
        this.f3430c.a(i, EventTriggerType.BY_USER);
        this.f3430c.a(EventTriggerType.BY_USER);
        setVisibility(0);
    }

    public final void m3253a() {
        if (this.f3431d != null && this.f3431d.a != null) {
            int currentPositionMs = this.f3430c.getCurrentPositionMs();
            if (this.f3430c.o()) {
                this.f3430c.b(EventTriggerType.BY_USER);
            }
            if (!(this.f3430c.t == null || this.f3430c.t.a.s == null)) {
                Video360Plugin video360Plugin = (Video360Plugin) this.f3430c.a(Video360Plugin.class);
                if (video360Plugin != null) {
                    video360Plugin.k();
                }
            }
            this.f3428a.a(this.f3431d.a.e, PlayerType.WATCH_AND_BROWSE.value, PlayerType.FULL_SCREEN_PLAYER.value, this.f3431d.a.b, this.f3432e, EventTriggerType.BY_USER.value, currentPositionMs, this.f3430c.getLastStartPosition(), this.f3431d.a.f, this.f3431d.a, null, null);
            this.f3430c.g();
            setVisibility(8);
        }
    }

    public int getCurrentPositionMs() {
        return this.f3430c.getCurrentPositionMs();
    }

    public void setPlayerOrigin(PlayerOrigin playerOrigin) {
        this.f3432e = playerOrigin;
    }

    @Nullable
    public VideoResolution getVideoResolution() {
        if (this.f3430c.u == null) {
            return null;
        }
        return this.f3430c.u.e();
    }

    private void m3250a(VideoLoggingUtils videoLoggingUtils, VideoWatchAndBrowseFullScreenVideoPlayerPluginSelector videoWatchAndBrowseFullScreenVideoPlayerPluginSelector) {
        this.f3428a = videoLoggingUtils;
        this.f3429b = videoWatchAndBrowseFullScreenVideoPlayerPluginSelector;
    }
}
