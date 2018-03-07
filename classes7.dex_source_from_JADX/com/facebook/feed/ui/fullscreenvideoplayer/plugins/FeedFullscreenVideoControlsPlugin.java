package com.facebook.feed.ui.fullscreenvideoplayer.plugins;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.FullScreenCastPlugin.UiType;
import com.facebook.inject.FbInjector;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.environment.CanHandleOnVideoDeleted;
import com.facebook.video.player.environment.HasFeedMenuHelper;
import com.facebook.video.player.plugins.VideoControlsBasePlugin;
import com.facebook.video.videohome.abtest.ExperimentsForVideoHomeAbTestModule;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: TimelineInitialFetchUnits */
public class FeedFullscreenVideoControlsPlugin<E extends CanHandleOnVideoDeleted & HasFeedMenuHelper> extends VideoControlsBasePlugin<E> {
    @Inject
    public QeAccessor f22010m;
    private FeedFullscreenSeekBarPlugin f22011n;
    private FullScreenCastPlugin f22012o;

    public static void m24631a(Object obj, Context context) {
        ((FeedFullscreenVideoControlsPlugin) obj).f22010m = (QeAccessor) QeInternalImplMethodAutoProvider.a(FbInjector.get(context));
    }

    @DoNotStrip
    public FeedFullscreenVideoControlsPlugin(Context context) {
        this(context, null);
    }

    private FeedFullscreenVideoControlsPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FeedFullscreenVideoControlsPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22011n = (FeedFullscreenSeekBarPlugin) a(2131561909);
        this.f22012o = (FullScreenCastPlugin) a(2131561910);
        this.f22012o.f22090v = UiType.UI_VOD;
        this.f22012o.setOtherControls(this.f22011n);
    }

    protected int getContentView() {
        if (this.f22010m == null) {
            Class cls = FeedFullscreenVideoControlsPlugin.class;
            m24631a((Object) this, getContext());
        }
        if (this.f22010m.a(ExperimentsForVideoHomeAbTestModule.p, false)) {
            return 2130904301;
        }
        return 2130904300;
    }

    protected final void m24632a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        super.a(richVideoPlayerParams, z);
        this.f22011n.setEnvironment(this.c);
        this.f22011n.a(this.h, this.i, richVideoPlayerParams);
    }

    protected final void m24633c() {
        super.c();
        this.f22011n.b();
    }
}
