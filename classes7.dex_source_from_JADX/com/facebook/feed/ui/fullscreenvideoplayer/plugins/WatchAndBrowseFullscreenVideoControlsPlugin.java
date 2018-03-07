package com.facebook.feed.ui.fullscreenvideoplayer.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.environment.CanOpenFullscreen;
import com.facebook.video.player.plugins.PlaybackController;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.facebook.video.player.plugins.VideoControlsBasePlugin;
import com.facebook.video.watchandbrowse.VideoWatchAndBrowseRootView.1;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: This method is not supported for ReactViewGroup instances */
public class WatchAndBrowseFullscreenVideoControlsPlugin<E extends CanOpenFullscreen> extends VideoControlsBasePlugin<E> {
    @Inject
    public VideoLoggingUtils f22184m;
    private final View f22185n;
    public VideoPlayerParams f22186o;
    public 1 f22187p;

    /* compiled from: This method is not supported for ReactViewGroup instances */
    class C18961 implements OnClickListener {
        final /* synthetic */ WatchAndBrowseFullscreenVideoControlsPlugin f22183a;

        C18961(WatchAndBrowseFullscreenVideoControlsPlugin watchAndBrowseFullscreenVideoControlsPlugin) {
            this.f22183a = watchAndBrowseFullscreenVideoControlsPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -183804704);
            if (this.f22183a.h != null) {
                this.f22183a.h.a(EventTriggerType.BY_USER);
                this.f22183a.f22184m.a(this.f22183a.f22186o.e, this.f22183a.f22186o.b, this.f22183a.h.f(), this.f22183a.h.o(), this.f22183a.h.i(), this.f22183a.h.m());
            }
            if (this.f22183a.f22187p != null) {
                1 1 = this.f22183a.f22187p;
                1.a.f.setVisibility(8);
                1.a.m.e();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -845764318, a);
        }
    }

    public static void m24835a(Object obj, Context context) {
        ((WatchAndBrowseFullscreenVideoControlsPlugin) obj).f22184m = VideoLoggingUtils.a(FbInjector.get(context));
    }

    @DoNotStrip
    public WatchAndBrowseFullscreenVideoControlsPlugin(Context context) {
        this(context, null);
    }

    private WatchAndBrowseFullscreenVideoControlsPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private WatchAndBrowseFullscreenVideoControlsPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = WatchAndBrowseFullscreenVideoControlsPlugin.class;
        m24835a((Object) this, getContext());
        this.f22185n = findViewById(2131568509);
    }

    public final void m24837a(PlaybackController playbackController, RichVideoPlayer richVideoPlayer, RichVideoPlayerParams richVideoPlayerParams) {
        super.a(playbackController, richVideoPlayer, richVideoPlayerParams);
        for (RichVideoPlayerPlugin a : this.a) {
            a.a(playbackController, richVideoPlayer, richVideoPlayerParams);
        }
    }

    protected int getContentView() {
        return 2130907763;
    }

    protected final void m24836a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        super.a(richVideoPlayerParams, z);
        this.f22186o = richVideoPlayerParams.a;
        this.f22185n.setOnClickListener(new C18961(this));
    }

    protected final void m24838c() {
        super.c();
        if (this.f22185n != null) {
            this.f22185n.setOnClickListener(null);
        }
    }
}
