package com.facebook.caspian.ui.standardheader;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.player.FbVideoView;
import com.facebook.video.player.plugins.CoverViewPlugin;
import com.facebook.video.player.plugins.OverlayImagePlugin;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.facebook.video.player.plugins.TrimmedVideoLoopingPlugin;
import com.google.common.collect.ImmutableList;

/* compiled from: crop_task */
public class ProfileVideoView extends FbVideoView {
    public CoverViewPlugin f16540i;

    public ProfileVideoView(Context context) {
        super(context);
        m20600t();
    }

    public ProfileVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20600t();
    }

    public ProfileVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20600t();
    }

    private void m20600t() {
        setShouldCropToFit(true);
    }

    protected PlayerOrigin getDefaultPlayerOrigin() {
        return PlayerOrigin.PROFILE_VIDEO;
    }

    protected final ImmutableList<? extends RichVideoPlayerPlugin> m20601a(Context context) {
        this.f16540i = new CoverViewPlugin(context);
        return ImmutableList.of(this.f16540i, new TrimmedVideoLoopingPlugin(context), new OverlayImagePlugin(context));
    }

    public CoverViewPlugin getCoverViewPlugin() {
        return this.f16540i;
    }

    public final void m20602f() {
        super.f();
        a(EventTriggerType.BY_PLAYER);
    }
}
