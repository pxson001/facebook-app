package com.facebook.video.channelfeed.plugins;

import android.content.Context;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.video.player.plugins.VideoControlsBasePlugin;

@DoNotStrip
/* compiled from: street1 */
public class ChannelFeedFullscreenVideoControlsPlugin extends VideoControlsBasePlugin {
    @DoNotStrip
    public ChannelFeedFullscreenVideoControlsPlugin(Context context) {
        super(context);
    }

    protected int getContentView() {
        return 2130903535;
    }
}
