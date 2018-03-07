package com.facebook.video.channelfeed.plugins;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.environment.CanOpenFullscreen;
import com.facebook.video.player.plugins.VideoControlsBasePlugin;
import com.facebook.video.player.plugins.VideoControlsBasePlugin.InitialChromeBehavior;

/* compiled from: street_number */
public class ChannelFeedInlineVideoControlsPlugin<E extends CanOpenFullscreen> extends VideoControlsBasePlugin<E> {
    @DoNotStrip
    public ChannelFeedInlineVideoControlsPlugin(Context context) {
        super(context);
    }

    public ChannelFeedInlineVideoControlsPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected int getContentView() {
        return 2130903540;
    }

    protected final void m2609a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        if (z) {
            a(((Boolean) richVideoPlayerParams.b.get("IsAutoplayKey")).booleanValue() ? InitialChromeBehavior.AUTO_WITH_INITIALLY_HIDDEN : InitialChromeBehavior.AUTO_WITH_INITIALLY_VISIBLE);
        }
    }
}
