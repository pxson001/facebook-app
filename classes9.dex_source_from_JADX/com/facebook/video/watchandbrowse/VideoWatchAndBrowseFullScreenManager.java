package com.facebook.video.watchandbrowse;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.WatchAndBrowseFullscreenVideoControlsPlugin.DismissVideoCallback;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.VideoResolution;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.plugins.Video360Plugin;
import com.facebook.video.watchandbrowse.VideoWatchAndBrowseRootView.C03121;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

@ContextScoped
/* compiled from: showMomentsTab */
public class VideoWatchAndBrowseFullScreenManager {
    private static VideoWatchAndBrowseFullScreenManager f3369g;
    private static final Object f3370h = new Object();
    @Nullable
    public WeakReference<WatchAndBrowseVideoPlayer> f3371a;
    @Nullable
    public WeakReference<WatchAndBrowseFullScreenVideoPlayer> f3372b;
    @Nullable
    public WeakReference<DismissVideoCallback> f3373c;
    public int f3374d = 1;
    public boolean f3375e;
    public boolean f3376f;

    private static VideoWatchAndBrowseFullScreenManager m3206h() {
        return new VideoWatchAndBrowseFullScreenManager();
    }

    public final void m3207a(int i) {
        if (this.f3374d != i) {
            this.f3374d = i;
            if (!this.f3376f) {
                if (i == 2 && !this.f3375e) {
                    m3202d();
                } else if (this.f3375e) {
                    m3203e();
                }
            }
        }
    }

    public static VideoWatchAndBrowseFullScreenManager m3201a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoWatchAndBrowseFullScreenManager h;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3370h) {
                VideoWatchAndBrowseFullScreenManager videoWatchAndBrowseFullScreenManager;
                if (a2 != null) {
                    videoWatchAndBrowseFullScreenManager = (VideoWatchAndBrowseFullScreenManager) a2.a(f3370h);
                } else {
                    videoWatchAndBrowseFullScreenManager = f3369g;
                }
                if (videoWatchAndBrowseFullScreenManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        h = m3206h();
                        if (a2 != null) {
                            a2.a(f3370h, h);
                        } else {
                            f3369g = h;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    h = videoWatchAndBrowseFullScreenManager;
                }
            }
            return h;
        } finally {
            a.c(b);
        }
    }

    public final boolean m3208a() {
        if (!this.f3375e) {
            return false;
        }
        m3203e();
        if (this.f3374d == 1) {
            return true;
        }
        return false;
    }

    public final void m3209c() {
        this.f3376f = true;
        m3202d();
    }

    private void m3202d() {
        WatchAndBrowseVideoPlayer g = m3205g();
        WatchAndBrowseFullScreenVideoPlayer f = m3204f();
        if (g != null && f != null) {
            VideoResolution videoResolution;
            int i;
            this.f3375e = true;
            RichVideoPlayerParams richVideoPlayerParams = g.f3439f;
            if (g.f3438e == null || g.f3438e.u == null) {
                videoResolution = null;
            } else {
                videoResolution = g.f3438e.u.e();
            }
            VideoResolution videoResolution2 = videoResolution;
            if (g.f3438e == null) {
                i = 0;
            } else {
                i = g.f3438e.getCurrentPositionMs();
            }
            int i2 = i;
            if (g.f3438e == null) {
                i = 0;
            } else {
                i = g.f3438e.getLastStartPosition();
            }
            int i3 = i;
            if (g.f3438e.o()) {
                g.f3438e.b(EventTriggerType.BY_USER);
            }
            if (!(g.f3438e.t == null || g.f3438e.t.a.s == null)) {
                Video360Plugin video360Plugin = (Video360Plugin) g.f3438e.a(Video360Plugin.class);
                if (video360Plugin != null) {
                    video360Plugin.k();
                }
            }
            g.f3438e.g();
            f.m3254a(richVideoPlayerParams, i2, i3, videoResolution2);
        }
    }

    private void m3203e() {
        WatchAndBrowseVideoPlayer g = m3205g();
        WatchAndBrowseFullScreenVideoPlayer f = m3204f();
        if (g != null && f != null) {
            this.f3375e = false;
            this.f3376f = false;
            f.m3253a();
            int currentPositionMs = f.getCurrentPositionMs();
            VideoResolution videoResolution = f.getVideoResolution();
            if (videoResolution == null) {
                videoResolution = VideoResolution.STANDARD_DEFINITION;
            }
            g.m3257a(currentPositionMs, videoResolution);
            if (this.f3373c != null && this.f3373c.get() != null) {
                g.setupDismissPlayerButton((C03121) this.f3373c.get());
            }
        }
    }

    @Nullable
    private WatchAndBrowseFullScreenVideoPlayer m3204f() {
        return this.f3372b == null ? null : (WatchAndBrowseFullScreenVideoPlayer) this.f3372b.get();
    }

    @Nullable
    private WatchAndBrowseVideoPlayer m3205g() {
        return this.f3371a == null ? null : (WatchAndBrowseVideoPlayer) this.f3371a.get();
    }
}
