package com.facebook.video.videohome.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.feed.autoplay.VideoPlayerView;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.katana.app.module.Boolean_IsVideoSpecDisplayEnabledMethodAutoProvider;
import com.facebook.video.analytics.ChannelEligibility;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.player.IsVideoSpecDisplayEnabled;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerBuilder;
import com.facebook.video.player.VideoTransitionNode;
import com.facebook.video.player.plugins.DebugConsolePlugin;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.facebook.video.videohome.audio.VideoHomeInlineAudioManager;
import com.facebook.video.videohome.plugins.VideoHomePlayerPluginSelector;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.recyclerview.keepattached.RecyclerViewKeepAttached;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

/* compiled from: show_composer */
public class VideoHomeVideoPlayerView extends CustomRelativeLayout implements VideoPlayerView, VideoTransitionNode, RecyclerViewKeepAttached {
    @Inject
    @IsVideoSpecDisplayEnabled
    Boolean f3363a;
    @Inject
    public VideoHomePlayerPluginSelector f3364b;
    @Inject
    VideoHomeInlineAudioManager f3365c;
    private boolean f3366d;
    private RichVideoPlayer f3367e;
    private View f3368f;

    private static <T extends View> void m3194a(Class<T> cls, T t) {
        m3195a((Object) t, t.getContext());
    }

    private static void m3195a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((VideoHomeVideoPlayerView) obj).m3193a(Boolean_IsVideoSpecDisplayEnabledMethodAutoProvider.b(fbInjector), new VideoHomePlayerPluginSelector((Context) fbInjector.getInstance(Context.class), GatekeeperStoreImplMethodAutoProvider.a(fbInjector), Boolean_IsVideoSpecDisplayEnabledMethodAutoProvider.b(fbInjector)), VideoHomeInlineAudioManager.m2658a(fbInjector));
    }

    public VideoHomeVideoPlayerView(Context context) {
        this(context, null);
    }

    public VideoHomeVideoPlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void m3193a(Boolean bool, VideoHomePlayerPluginSelector videoHomePlayerPluginSelector, VideoHomeInlineAudioManager videoHomeInlineAudioManager) {
        this.f3363a = bool;
        this.f3364b = videoHomePlayerPluginSelector;
        this.f3365c = videoHomeInlineAudioManager;
    }

    public VideoHomeVideoPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3366d = true;
        m3194a(VideoHomeVideoPlayerView.class, (View) this);
        setContentView(2130907734);
        this.f3368f = a(2131567025);
        this.f3367e = (RichVideoPlayer) a(2131560290);
        RichVideoPlayerBuilder richVideoPlayerBuilder = new RichVideoPlayerBuilder();
        richVideoPlayerBuilder.a = PlayerOrigin.VIDEO_HOME;
        richVideoPlayerBuilder = richVideoPlayerBuilder;
        richVideoPlayerBuilder.b = getPlayerType();
        this.f3367e = richVideoPlayerBuilder.a(getAdditionalPlugins()).a(this.f3367e);
        this.f3367e.setChannelEligibility(ChannelEligibility.ELIGIBLE);
    }

    public final boolean gK_() {
        return true;
    }

    public ImmutableList<RichVideoPlayerPlugin> getAdditionalPlugins() {
        Builder builder = new Builder();
        if (this.f3363a.booleanValue()) {
            builder.c(new DebugConsolePlugin(getContext()));
        }
        return builder.b();
    }

    public RichVideoPlayer getRichVideoPlayer() {
        return this.f3367e;
    }

    public final void m3198a(RichVideoPlayer richVideoPlayer) {
        if (this.f3367e != richVideoPlayer) {
            m3199i();
        }
        if (!this.f3366d) {
            this.f3368f.setVisibility(8);
            if (!(richVideoPlayer.getLayoutParams() instanceof LayoutParams)) {
                richVideoPlayer.setLayoutParams(new LayoutParams(richVideoPlayer.getLayoutParams()));
            }
            attachViewToParent(richVideoPlayer, 0, this.f3368f.getLayoutParams());
        }
        this.f3367e = richVideoPlayer;
        this.f3366d = true;
        requestLayout();
    }

    public final RichVideoPlayer m3199i() {
        if (this.f3366d) {
            ViewGroup.LayoutParams layoutParams = this.f3368f.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.f3367e.getLayoutParams();
            layoutParams.height = layoutParams2.height;
            layoutParams.width = layoutParams2.width;
            this.f3368f.setLayoutParams(layoutParams);
            this.f3368f.setVisibility(4);
            detachViewFromParent(this.f3367e);
            requestLayout();
        }
        this.f3366d = false;
        return this.f3367e;
    }

    public final RichVideoPlayer m3200j() {
        return this.f3367e;
    }

    public VideoHomePlayerPluginSelector getPluginSelector() {
        return this.f3364b;
    }

    public PlayerType getPlayerType() {
        return PlayerType.INLINE_PLAYER;
    }

    public final void m3197a(EventTriggerType eventTriggerType, int i) {
        RichVideoPlayer richVideoPlayer = getRichVideoPlayer();
        richVideoPlayer.setOriginalPlayReason(eventTriggerType);
        richVideoPlayer.a(i, eventTriggerType);
        boolean z = !this.f3365c.m2661d();
        richVideoPlayer.a(z, eventTriggerType);
        if (!z) {
            int i2;
            if (this.f3365c.f2787d) {
                i2 = 1000;
            } else {
                i2 = 3000;
            }
            richVideoPlayer.d(i2);
        }
        this.f3365c.f2787d = true;
        richVideoPlayer.a(eventTriggerType);
        this.f3365c.f2789f = new WeakReference(richVideoPlayer);
    }

    public final void m3196a(EventTriggerType eventTriggerType) {
        getRichVideoPlayer().b(eventTriggerType);
    }

    public int getSeekPosition() {
        return getRichVideoPlayer().getCurrentPositionMs();
    }
}
