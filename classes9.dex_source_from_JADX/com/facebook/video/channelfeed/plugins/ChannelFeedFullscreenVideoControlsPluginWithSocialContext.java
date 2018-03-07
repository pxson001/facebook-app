package com.facebook.video.channelfeed.plugins;

import android.content.Context;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.video.player.plugins.VideoControlsBasePlugin;

@DoNotStrip
/* compiled from: stream_id */
public class ChannelFeedFullscreenVideoControlsPluginWithSocialContext extends VideoControlsBasePlugin {
    @DoNotStrip
    public ChannelFeedFullscreenVideoControlsPluginWithSocialContext(Context context) {
        super(context);
    }

    protected int getContentView() {
        return 2130903536;
    }
}
