package com.facebook.video.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.katana.app.module.Boolean_IsVideoSpecDisplayEnabledMethodAutoProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.video.analytics.ChannelEligibility;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.engine.Constants.VideoMediaState;
import com.facebook.video.engine.PlayPosition;
import com.facebook.video.engine.VideoPlayerListener;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.player.RichVideoPlayerParams.Builder;
import com.facebook.video.player.events.RVPErrorEvent;
import com.facebook.video.player.events.RVPRequestSubtitlesLanguageChangeEvent;
import com.facebook.video.player.events.RVPRequestSubtitlesVisibilityChangeEvent;
import com.facebook.video.player.events.RVPStreamCompleteEvent;
import com.facebook.video.player.plugins.CoverImagePlugin;
import com.facebook.video.player.plugins.DebugConsolePlugin;
import com.facebook.video.player.plugins.InlineSubtitlePlugin;
import com.facebook.video.player.plugins.LoadingSpinnerPlugin;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.facebook.video.player.plugins.SinglePlayIconPlugin;
import com.facebook.video.player.plugins.VideoPlugin;
import com.facebook.video.subtitles.controller.Subtitles;
import com.facebook.widget.CustomRelativeLayout;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

@TargetApi(14)
@Deprecated
/* compiled from: composer_open_privacy */
public class InlineVideoPlayer2 extends CustomRelativeLayout implements BaseInlineVideoPlayer, VideoTransitionNode {
    protected RichVideoPlayer f19123a;
    @Inject
    @IsVideoSpecDisplayEnabled
    public Boolean f19124b;
    private final LayoutParams f19125c;
    private String f19126d;
    private boolean f19127e;
    private Subtitles f19128f;
    private ChannelEligibility f19129g;
    private EventTriggerType f19130h;
    private boolean f19131i;

    private static <T extends View> void m27866a(Class<T> cls, T t) {
        m27867a((Object) t, t.getContext());
    }

    private static void m27867a(Object obj, Context context) {
        ((InlineVideoPlayer2) obj).f19124b = Boolean_IsVideoSpecDisplayEnabledMethodAutoProvider.b(FbInjector.get(context));
    }

    public InlineVideoPlayer2(Context context) {
        this(context, null);
    }

    public InlineVideoPlayer2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void m27865a(Boolean bool) {
        this.f19124b = bool;
    }

    public InlineVideoPlayer2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19129g = ChannelEligibility.NO_INFO;
        this.f19130h = EventTriggerType.BY_AUTOPLAY;
        this.f19131i = true;
        m27866a(InlineVideoPlayer2.class, (View) this);
        setContentView(2130904927);
        this.f19123a = (RichVideoPlayer) a(2131560290);
        this.f19123a.a(new VideoPlugin(context));
        ImmutableList additionalPlugins = getAdditionalPlugins();
        int size = additionalPlugins.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f19123a.a((RichVideoPlayerPlugin) additionalPlugins.get(i2));
        }
        this.f19123a.setShouldCropToFit(true);
        this.f19127e = false;
        this.f19128f = null;
        this.f19125c = new LayoutParams(-1, -1);
    }

    public final void m27873a(RichVideoPlayer richVideoPlayer) {
        if (this.f19123a != richVideoPlayer) {
            m27885i();
        }
        if (!this.f19131i) {
            if (!(richVideoPlayer.getLayoutParams() instanceof LayoutParams)) {
                richVideoPlayer.setLayoutParams(new LayoutParams(richVideoPlayer.getLayoutParams()));
            }
            attachRecyclableViewToParent(richVideoPlayer, 0, this.f19125c);
        }
        this.f19123a = richVideoPlayer;
        this.f19131i = true;
    }

    public final RichVideoPlayer m27885i() {
        if (this.f19131i) {
            detachRecyclableViewFromParent(this.f19123a);
        }
        this.f19131i = false;
        return this.f19123a;
    }

    public final RichVideoPlayer m27886j() {
        return this.f19123a;
    }

    public void setAlwaysPlayVideoUnmuted(boolean z) {
        this.f19127e = z;
    }

    public final void mo1452a(int i, String str) {
    }

    public final void mo1455a(String str, String str2, String str3) {
    }

    public void setEndScreenVideoPlayerListener(OnClickListener onClickListener) {
    }

    public final void mo1459c() {
    }

    public final boolean mo1457a() {
        return false;
    }

    @Nullable
    public View getEndScreenCallToActionView() {
        return null;
    }

    public void setOnClickPlayerListener(@Nullable OnClickListener onClickListener) {
        this.f19123a.setOnClickListener(onClickListener);
    }

    public boolean callOnClick() {
        return this.f19123a.callOnClick();
    }

    public void setShowVideoDuration(boolean z) {
    }

    @Nullable
    public FbDraweeView getCoverImage() {
        return this.f19123a == null ? null : this.f19123a.getCoverImage();
    }

    public final void mo1464g() {
    }

    public final void mo1456a(boolean z, EventTriggerType eventTriggerType) {
        if (this.f19131i && !this.f19127e) {
            this.f19123a.a(z, eventTriggerType);
        }
    }

    public final boolean mo1458b() {
        return this.f19123a.m();
    }

    public int getCurrentPosition() {
        return this.f19123a.getCurrentPositionMs();
    }

    public int getLastStartPosition() {
        return this.f19123a.getLastStartPosition();
    }

    public InlineVideoView getInlineVideoView() {
        return null;
    }

    public final void mo1451a(int i, int i2) {
    }

    public final void m27871a(EventTriggerType eventTriggerType, PlayPosition playPosition) {
        if (this.f19131i) {
            this.f19123a.a(!this.f19127e, EventTriggerType.BY_PLAYER);
            if (eventTriggerType != EventTriggerType.BY_INLINE_FULLSCREEN_TRANSITION) {
                this.f19123a.a(playPosition.c, eventTriggerType);
            }
            this.f19123a.a(eventTriggerType, playPosition.d);
        }
    }

    public void setPlayerOrigin(PlayerOrigin playerOrigin) {
        this.f19123a.setPlayerOrigin(playerOrigin);
    }

    public void setChannelEligibility(ChannelEligibility channelEligibility) {
        this.f19129g = channelEligibility;
        this.f19123a.setChannelEligibility(channelEligibility);
    }

    @Deprecated
    public void setOriginalPlayReason(EventTriggerType eventTriggerType) {
        this.f19130h = eventTriggerType;
        this.f19123a.setOriginalPlayReason(eventTriggerType);
    }

    public final void mo1453a(EventTriggerType eventTriggerType, VideoMediaState videoMediaState) {
        if (this.f19131i) {
            this.f19123a.b(eventTriggerType);
        }
    }

    public final boolean m27887k() {
        return this.f19123a.o();
    }

    public void setVideoListener(final VideoPlayerListener videoPlayerListener) {
        if (this.f19131i) {
            this.f19123a.v = new RichVideoPlayerCallbackListener(this) {
                final /* synthetic */ InlineVideoPlayer2 f19122b;

                public final void m27864a(RVPStreamCompleteEvent rVPStreamCompleteEvent) {
                    if (videoPlayerListener != null) {
                        videoPlayerListener.a(rVPStreamCompleteEvent.a);
                    }
                }

                public final void m27862a() {
                }

                public final void m27863a(RVPErrorEvent rVPErrorEvent) {
                    if (videoPlayerListener != null) {
                        videoPlayerListener.a(rVPErrorEvent.a, rVPErrorEvent.b);
                    }
                }
            };
        }
    }

    public boolean getIsVideoCompleted() {
        return false;
    }

    public void setIsVideoCompleted(boolean z) {
    }

    public void setVideoData(VideoPlayerParams videoPlayerParams) {
        if (this.f19131i) {
            if (videoPlayerParams.b != this.f19126d) {
                if (this.f19123a.m()) {
                    this.f19123a.b(EventTriggerType.BY_PLAYER);
                }
                this.f19123a.g();
                this.f19126d = videoPlayerParams.b;
            }
            Builder builder = new Builder();
            builder.a = videoPlayerParams;
            this.f19123a.a(builder.b());
        }
    }

    public final void mo1454a(VideoPlayerParams videoPlayerParams, ImmutableMap<String, ? extends Object> immutableMap) {
        if (this.f19131i) {
            if (videoPlayerParams.b != this.f19126d) {
                if (this.f19123a.m()) {
                    this.f19123a.b(EventTriggerType.BY_PLAYER);
                }
                this.f19123a.g();
                this.f19126d = videoPlayerParams.b;
            }
            Builder builder = new Builder();
            builder.a = videoPlayerParams;
            this.f19123a.a(builder.a(immutableMap).b());
        }
    }

    public final void mo1461d() {
    }

    public final void mo1469h() {
    }

    public final void mo1462e() {
    }

    public final void mo1463f() {
    }

    public void setPauseMediaPlayerOnVideoPause(boolean z) {
    }

    public final void m27874a(Subtitles subtitles) {
        if (this.f19128f != subtitles) {
            this.f19128f = subtitles;
            this.f19123a.b.a(new RVPRequestSubtitlesLanguageChangeEvent(subtitles));
            this.f19123a.b.a(new RVPRequestSubtitlesVisibilityChangeEvent(subtitles != null));
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 890234462);
        super.onAttachedToWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1428055301, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1821458398);
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -2045207801, a);
    }

    public RichVideoPlayer getRichVideoPlayer() {
        return this.f19123a;
    }

    public PlayerType getPlayerType() {
        return PlayerType.INLINE_PLAYER;
    }

    public ImmutableList<RichVideoPlayerPlugin> getAdditionalPlugins() {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        builder.c(new CoverImagePlugin(getContext())).c(new InlineSubtitlePlugin(getContext())).c(new LoadingSpinnerPlugin(getContext())).c(new SinglePlayIconPlugin(getContext()));
        if (this.f19124b.booleanValue()) {
            builder.c(new DebugConsolePlugin(getContext()));
        }
        return builder.b();
    }
}
