package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.ComponentContext;
import com.facebook.components.Size;
import com.facebook.components.SizeSpec;
import com.facebook.components.annotations.MountSpec;
import com.facebook.components.utils.MeasureUtils;
import com.facebook.components.utils.MeasureUtils$MeasureException;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerBuilder;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.plugins.CoverImagePlugin;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.facebook.video.player.plugins.VideoPlugin;

@MountSpec
/* compiled from: Unknown viewType while creating in  */
public class ActorProfileVideoComponentSpec {
    protected static void m24031a(int i, int i2, Size size) {
        try {
            MeasureUtils.a(i, i2, size);
        } catch (MeasureUtils$MeasureException e) {
            int b = SizeSpec.b(i);
            size.a = b;
            size.b = b;
        }
    }

    protected static RichVideoPlayer m24030a(ComponentContext componentContext, RichVideoPlayer richVideoPlayer, RichVideoPlayerParams richVideoPlayerParams) {
        if (richVideoPlayer == null) {
            RichVideoPlayerBuilder richVideoPlayerBuilder = new RichVideoPlayerBuilder();
            richVideoPlayerBuilder.a = PlayerOrigin.ACTOR_PROFILE_VIDEO;
            richVideoPlayerBuilder = richVideoPlayerBuilder;
            richVideoPlayerBuilder.b = PlayerType.OTHERS;
            richVideoPlayerBuilder = richVideoPlayerBuilder;
            richVideoPlayerBuilder.d = false;
            richVideoPlayer = richVideoPlayerBuilder.a(new RichVideoPlayerPlugin[]{new VideoPlugin(componentContext), new CoverImagePlugin(componentContext)}).a(componentContext);
        }
        richVideoPlayer.a(richVideoPlayerParams);
        return richVideoPlayer;
    }
}
