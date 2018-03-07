package com.facebook.feed.autoplay;

import android.view.View;
import com.facebook.inject.Assisted;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoDisplayedInfo;
import com.facebook.video.analytics.VideoFeedStoryInfo;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: nearRight */
public class DefaultVideoAutoplayController<V extends View & VideoPlayerView> extends VideoViewController<V> {
    private final VideoStoryPersistentState f10134a;
    private final AutoplayStateManager f10135b;
    public final VideoDisplayedInfo f10136c;
    public final VideoPlayerParams f10137d;
    public final VideoFeedStoryInfo f10138e;
    public final PlayerOrigin f10139f;
    public final VideoAutoPlaySettingsChecker f10140g;
    public final VideoLoggingUtils f10141h;
    private boolean f10142i = false;

    public final void mo1035a(Object obj) {
        m15811a((View) obj, EventTriggerType.BY_AUTOPLAY);
    }

    public final void mo1037b(Object obj) {
        View view = (View) obj;
        boolean z = true;
        if (!this.f10142i) {
            this.f10142i = true;
            Set hashSet = new HashSet();
            if (this.f10135b == null || !this.f10135b.a(hashSet)) {
                z = false;
            }
            this.f10136c.a(hashSet, this.f10140g.c());
            this.f10141h.a(this.f10136c, this.f10137d.e, this.f10133a, this.f10139f, this.f10137d.f, this.f10138e.c, this.f10137d);
            this.f10136c.b(true);
            if (z) {
                m15813c(view);
            }
        }
    }

    @Inject
    public DefaultVideoAutoplayController(@Assisted String str, @Assisted VideoStoryPersistentState videoStoryPersistentState, @Assisted VideoDisplayedInfo videoDisplayedInfo, @Assisted VideoPlayerParams videoPlayerParams, @Assisted VideoFeedStoryInfo videoFeedStoryInfo, @Assisted PlayerOrigin playerOrigin, VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker, VideoLoggingUtils videoLoggingUtils) {
        super(str);
        this.f10134a = videoStoryPersistentState;
        this.f10135b = videoStoryPersistentState.b();
        this.f10136c = videoDisplayedInfo;
        this.f10137d = videoPlayerParams;
        this.f10138e = videoFeedStoryInfo;
        this.f10139f = playerOrigin;
        this.f10140g = videoAutoPlaySettingsChecker;
        this.f10141h = videoLoggingUtils;
    }

    private void m15811a(V v, EventTriggerType eventTriggerType) {
        if (this.f10142i) {
            this.f10142i = false;
            this.f10134a.a(((VideoPlayerView) v).getSeekPosition());
            this.f10136c.b(false);
            m15812b(v, eventTriggerType);
        }
    }

    private void m15813c(V v) {
        ((VideoPlayerView) v).a(EventTriggerType.BY_AUTOPLAY, this.f10134a.a());
    }

    private static void m15812b(V v, EventTriggerType eventTriggerType) {
        ((VideoPlayerView) v).a(eventTriggerType);
    }
}
