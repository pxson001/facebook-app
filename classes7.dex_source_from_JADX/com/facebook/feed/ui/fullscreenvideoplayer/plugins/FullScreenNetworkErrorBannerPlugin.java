package com.facebook.feed.ui.fullscreenvideoplayer.plugins;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;

@DoNotStrip
/* compiled from: TimelineFetchInitialUnitsWaitTime */
public class FullScreenNetworkErrorBannerPlugin extends RichVideoPlayerPlugin {
    private FeedFullScreenNetworkBanner f22095a;

    @DoNotStrip
    public FullScreenNetworkErrorBannerPlugin(Context context) {
        this(context, null);
    }

    private FullScreenNetworkErrorBannerPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FullScreenNetworkErrorBannerPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130904553);
        this.f22095a = (FeedFullScreenNetworkBanner) a(2131562432);
    }

    protected final void m24721a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        this.f22095a.m24602d();
        this.f22095a.m24600b();
    }

    public final void m24722c() {
        this.f22095a.m24601c();
    }
}
