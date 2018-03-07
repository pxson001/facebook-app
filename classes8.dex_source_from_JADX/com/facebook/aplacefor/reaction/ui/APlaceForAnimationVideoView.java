package com.facebook.aplacefor.reaction.ui;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.engine.VideoDataSourceBuilder;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerParamsBuilder;
import com.facebook.video.player.FbVideoView;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.plugins.CoverViewPlugin;
import com.facebook.video.player.plugins.ICoverView;
import com.facebook.video.player.plugins.PlaybackController;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

/* compiled from: isoCountryCode */
public class APlaceForAnimationVideoView extends FbVideoView {
    private CoverViewPlugin f10551i;

    /* compiled from: isoCountryCode */
    class CoverImage implements ICoverView {
        final /* synthetic */ APlaceForAnimationVideoView f10550a;

        CoverImage(APlaceForAnimationVideoView aPlaceForAnimationVideoView) {
            this.f10550a = aPlaceForAnimationVideoView;
        }

        public final void m12448a() {
            this.f10550a.setVisibility(0);
        }

        public final void m12449b() {
            this.f10550a.setVisibility(4);
        }

        public final void m12450c() {
        }
    }

    public APlaceForAnimationVideoView(Context context) {
        this(context, null);
    }

    public APlaceForAnimationVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public APlaceForAnimationVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final ImmutableList<? extends RichVideoPlayerPlugin> m12451a(Context context) {
        this.f10551i = new CoverViewPlugin(context);
        return ImmutableList.of(this.f10551i);
    }

    protected PlayerOrigin getDefaultPlayerOrigin() {
        return PlayerOrigin.A_PLACE_FOR;
    }

    public final void m12452a(String str, double d) {
        VideoDataSourceBuilder videoDataSourceBuilder = new VideoDataSourceBuilder();
        videoDataSourceBuilder.a = Uri.parse(str);
        videoDataSourceBuilder = videoDataSourceBuilder;
        videoDataSourceBuilder.f = StreamSourceType.FROM_STREAM;
        VideoPlayerParamsBuilder a = new VideoPlayerParamsBuilder().a(videoDataSourceBuilder.i());
        a.g = true;
        VideoPlayerParams m = a.m();
        ImmutableMap b = new Builder().b("VideoAspectRatioKey", Double.valueOf(d)).b();
        this.f10551i.setCoverView(new CoverImage(this));
        RichVideoPlayerParams.Builder builder = new RichVideoPlayerParams.Builder();
        builder.a = m;
        a(builder.a(b).b());
    }

    public final void iE_() {
        PlaybackController playbackController = this.u;
        if (playbackController != null) {
            playbackController.a(0, EventTriggerType.BY_PLAYER);
        }
        a(EventTriggerType.BY_AUTOPLAY);
    }
}
