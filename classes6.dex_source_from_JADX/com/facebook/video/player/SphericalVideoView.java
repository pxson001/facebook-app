package com.facebook.video.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.video.abtest.Video360PlayerConfig;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.player.events.RVP360IndicatorEvent;
import com.facebook.video.player.events.RVP360IndicatorEvent.State;
import com.facebook.video.player.events.RVPRequestPausingEvent;
import com.facebook.video.player.plugins.CoverImagePlugin;
import com.facebook.video.player.plugins.InlineSubtitlePlugin;
import com.facebook.video.player.plugins.LoadingSpinnerPlugin;
import com.facebook.video.player.plugins.SinglePlayIconPlugin;
import com.facebook.video.player.plugins.Static360IndicatorPlugin;
import com.facebook.video.player.plugins.Video360HeadingPlugin;
import com.facebook.video.player.plugins.Video360IndicatorPlugin;
import com.facebook.video.player.plugins.Video360NuxAnimationPlugin;
import com.facebook.video.player.plugins.Video360Plugin;
import com.facebook.video.player.plugins.VideoVRCastPlugin;
import javax.inject.Inject;

@TargetApi(18)
/* compiled from: composer_media_picker_selection_change */
public class SphericalVideoView extends RichVideoPlayer {
    @Inject
    public Video360PlayerConfig f19207i;
    private Video360Plugin f19208j;
    private final VideoVRCastPlugin f19209k;

    private static <T extends View> void m28002a(Class<T> cls, T t) {
        m28003a((Object) t, t.getContext());
    }

    private static void m28003a(Object obj, Context context) {
        ((SphericalVideoView) obj).f19207i = Video360PlayerConfig.b(FbInjector.get(context));
    }

    public SphericalVideoView(Context context) {
        this(context, null);
    }

    public SphericalVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SphericalVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m28002a(SphericalVideoView.class, (View) this);
        this.f19208j = new Video360Plugin(context, attributeSet, i);
        this.f19209k = new VideoVRCastPlugin(context, attributeSet, i);
        a(this.f19208j);
        a(new CoverImagePlugin(context));
        a(new InlineSubtitlePlugin(getContext()));
        a(new LoadingSpinnerPlugin(context));
        a(new SinglePlayIconPlugin(context));
        if (this.f19207i.l) {
            a(new Video360HeadingPlugin(getContext()));
        }
        if (this.f19207i.k) {
            a(new Video360NuxAnimationPlugin(context));
        } else {
            a(new Video360IndicatorPlugin(context));
            a(new Static360IndicatorPlugin(context));
        }
        a(this.f19209k);
    }

    private void m28001a(Video360PlayerConfig video360PlayerConfig) {
        this.f19207i = video360PlayerConfig;
    }

    public final void m28004b(EventTriggerType eventTriggerType) {
        this.b.a(new RVP360IndicatorEvent(State.INDICATOR_STOP));
        this.b.a(new RVPRequestPausingEvent(eventTriggerType));
    }
}
