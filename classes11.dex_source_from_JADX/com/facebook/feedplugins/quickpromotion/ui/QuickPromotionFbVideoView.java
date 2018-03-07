package com.facebook.feedplugins.quickpromotion.ui;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.engine.VideoDataSourceBuilder;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerParamsBuilder;
import com.facebook.video.player.FbVideoView;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.plugins.CoverImagePlugin;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

/* compiled from: card_context_items */
public class QuickPromotionFbVideoView extends FbVideoView {
    public QuickPromotionFbVideoView(Context context) {
        this(context, null);
    }

    public QuickPromotionFbVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QuickPromotionFbVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final ImmutableList<? extends RichVideoPlayerPlugin> m9713a(Context context) {
        return ImmutableList.of(new CoverImagePlugin(context));
    }

    protected PlayerOrigin getDefaultPlayerOrigin() {
        return PlayerOrigin.QUICK_PROMOTION_FEED;
    }

    public final void m9714a(String str, String str2, String str3, double d) {
        VideoDataSourceBuilder videoDataSourceBuilder = new VideoDataSourceBuilder();
        videoDataSourceBuilder.a = Uri.parse(str);
        videoDataSourceBuilder = videoDataSourceBuilder;
        videoDataSourceBuilder.f = StreamSourceType.FROM_STREAM;
        VideoPlayerParamsBuilder a = new VideoPlayerParamsBuilder().a(videoDataSourceBuilder.i());
        a.g = true;
        a = a;
        a.b = str2;
        VideoPlayerParams m = a.m();
        ImmutableMap b = new Builder().b("CoverImageParamsKey", ImageRequest.a(Uri.parse(str3))).b("VideoAspectRatioKey", Double.valueOf(d)).b();
        RichVideoPlayerParams.Builder builder = new RichVideoPlayerParams.Builder();
        builder.a = m;
        a(builder.a(b).b());
    }

    public final void iE_() {
        a(EventTriggerType.BY_AUTOPLAY);
    }

    public final void m9715f() {
        super.f();
        iE_();
    }
}
