package com.facebook.video.videohome.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.feed.autoplay.AutoplayStateManager;
import com.facebook.feed.video.util.RichVideoPlayerParamsUtil;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;

@DoNotStrip
/* compiled from: sig_to */
public class VideoHomeNonPlayingOverlayPlugin extends RichVideoPlayerPlugin {
    private final View f3275a;
    private final View f3276b;
    private AutoplayStateManager f3277c;
    private C03021 f3278d;
    private boolean f3279l;
    private boolean f3280m;

    /* compiled from: sig_to */
    public class C03021 {
        public final /* synthetic */ VideoHomeNonPlayingOverlayPlugin f3274a;

        C03021(VideoHomeNonPlayingOverlayPlugin videoHomeNonPlayingOverlayPlugin) {
            this.f3274a = videoHomeNonPlayingOverlayPlugin;
        }
    }

    @DoNotStrip
    public VideoHomeNonPlayingOverlayPlugin(Context context) {
        this(context, null);
    }

    private VideoHomeNonPlayingOverlayPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private VideoHomeNonPlayingOverlayPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3279l = false;
        setContentView(2130907679);
        this.f3275a = a(2131567761);
        this.f3276b = a(2131562409);
        this.f3278d = new C03021(this);
    }

    protected final void m3122a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        this.f3277c = (AutoplayStateManager) richVideoPlayerParams.b.get("AutoplayStateManager");
        this.f3277c.a(this.f3278d);
        GraphQLMedia a = RichVideoPlayerParamsUtil.a(richVideoPlayerParams);
        boolean z2 = a != null && a.aq() && (a.br() == GraphQLVideoBroadcastStatus.LIVE_STOPPED || a.br() == GraphQLVideoBroadcastStatus.SEAL_STARTED);
        this.f3279l = z2;
        this.f3280m = Boolean.TRUE.equals(richVideoPlayerParams.b.get("IsSmallVideoKey"));
        m3121d(this);
    }

    protected final void m3123c() {
        if (this.f3277c != null) {
            this.f3277c.a(null);
        }
    }

    public static void m3121d(VideoHomeNonPlayingOverlayPlugin videoHomeNonPlayingOverlayPlugin) {
        int i;
        int i2 = 0;
        if (videoHomeNonPlayingOverlayPlugin.f3277c.j() || videoHomeNonPlayingOverlayPlugin.f3279l || videoHomeNonPlayingOverlayPlugin.f3280m) {
            i = 0;
        } else {
            i = 1;
        }
        View view = videoHomeNonPlayingOverlayPlugin.f3275a;
        if (i == 0) {
            i2 = 8;
        }
        view.setVisibility(i2);
    }
}
