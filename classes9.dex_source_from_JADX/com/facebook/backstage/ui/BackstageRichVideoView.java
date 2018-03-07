package com.facebook.backstage.ui;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.engine.VideoDataSourceBuilder;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerParamsBuilder;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerParams.Builder;
import com.facebook.video.player.plugins.CoverImagePlugin;
import com.facebook.video.player.plugins.LoadingSpinnerPlugin;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.facebook.video.player.plugins.SinglePlayIconPlugin;
import com.facebook.video.player.plugins.VideoPlugin;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;

/* compiled from: reply */
public class BackstageRichVideoView extends RichVideoPlayer {
    public boolean f5479i;
    public boolean f5480j;

    public BackstageRichVideoView(Context context) {
        this(context, null);
    }

    public BackstageRichVideoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BackstageRichVideoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5479i = true;
        this.f5480j = false;
        setPlayerOrigin(PlayerOrigin.BACKSTAGE_VIDEOS);
        setPlayerType(PlayerType.OTHERS);
        a(new VideoPlugin(context));
        ImmutableList a = m5706a(context);
        if (a != null) {
            int size = a.size();
            for (int i2 = 0; i2 < size; i2++) {
                a((RichVideoPlayerPlugin) a.get(i2));
            }
        }
        setShouldCropToFit(true);
    }

    private static ImmutableList<? extends RichVideoPlayerPlugin> m5706a(Context context) {
        return ImmutableList.of(new CoverImagePlugin(context), new SinglePlayIconPlugin(context), new LoadingSpinnerPlugin(context));
    }

    protected PlayerType getDefaultPlayerType() {
        return PlayerType.OTHERS;
    }

    protected PlayerOrigin getDefaultPlayerOrigin() {
        return PlayerOrigin.BACKSTAGE_VIDEOS;
    }

    public final void m5711b(String str, String str2) {
        this.f5480j = true;
        m5708c(str, str2);
    }

    public final void m5709a() {
        this.f5480j = false;
        this.f5479i = true;
        g();
    }

    public final void m5710b() {
        this.f5479i = true;
        b(EventTriggerType.BY_USER);
    }

    public final void m5712t() {
        this.f5479i = false;
        a(false, EventTriggerType.BY_USER);
        a(EventTriggerType.BY_USER);
    }

    public final boolean m5713u() {
        return this.f5479i;
    }

    public final boolean m5714v() {
        return this.f5480j;
    }

    private void m5708c(String str, String str2) {
        VideoDataSourceBuilder videoDataSourceBuilder = new VideoDataSourceBuilder();
        videoDataSourceBuilder.a = Uri.parse(str);
        videoDataSourceBuilder = videoDataSourceBuilder;
        videoDataSourceBuilder.f = StreamSourceType.FROM_STREAM;
        VideoPlayerParamsBuilder a = new VideoPlayerParamsBuilder().a(videoDataSourceBuilder.i());
        a.g = true;
        VideoPlayerParams m = a.m();
        Builder builder = new Builder();
        builder.a = m;
        a(builder.a(m5707a(str2).b()).b());
    }

    private static ImmutableMap.Builder<String, Object> m5707a(String str) {
        ImmutableMap.Builder<String, Object> builder = new ImmutableMap.Builder();
        if (str != null) {
            builder.b("CoverImageParamsKey", ImageRequest.a(str));
        }
        return builder;
    }
}
