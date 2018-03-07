package com.facebook.video.channelfeed;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.Window;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.channelfeed.ChannelFeedRootView.C02225;
import com.facebook.video.engine.VideoResolution;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.plugins.PlaybackController;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: targeting_data */
public class ChannelFeedFullscreenManager {
    private static ChannelFeedFullscreenManager f2195k;
    private static final Object f2196l = new Object();
    private final Handler f2197a;
    @Nullable
    public Window f2198b;
    @Nullable
    public WeakReference<ChannelFeedFullscreenPlayer> f2199c;
    @Nullable
    public WeakReference<ChannelFeedVideoAttachmentView> f2200d;
    @Nullable
    public C02225 f2201e;
    public int f2202f = 1;
    public boolean f2203g;
    public boolean f2204h;
    public boolean f2205i;
    public boolean f2206j;

    /* compiled from: targeting_data */
    class C02111 implements Runnable {
        final /* synthetic */ ChannelFeedFullscreenManager f2194a;

        C02111(ChannelFeedFullscreenManager channelFeedFullscreenManager) {
            this.f2194a = channelFeedFullscreenManager;
        }

        public void run() {
            ChannelFeedFullscreenManager.m2205n(this.f2194a);
        }
    }

    private static ChannelFeedFullscreenManager m2198b(InjectorLike injectorLike) {
        return new ChannelFeedFullscreenManager(Handler_ForUiThreadMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public ChannelFeedFullscreenManager(Handler handler) {
        this.f2197a = handler;
    }

    public final void m2209a(ChannelFeedVideoAttachmentView channelFeedVideoAttachmentView) {
        this.f2200d = new WeakReference(channelFeedVideoAttachmentView);
        if (this.f2205i) {
            m2200h();
            this.f2205i = false;
        }
    }

    public final void m2208a(ChannelFeedFullscreenPlayer channelFeedFullscreenPlayer) {
        this.f2199c = new WeakReference(channelFeedFullscreenPlayer);
    }

    public static ChannelFeedFullscreenManager m2197a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedFullscreenManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2196l) {
                ChannelFeedFullscreenManager channelFeedFullscreenManager;
                if (a2 != null) {
                    channelFeedFullscreenManager = (ChannelFeedFullscreenManager) a2.a(f2196l);
                } else {
                    channelFeedFullscreenManager = f2195k;
                }
                if (channelFeedFullscreenManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2198b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2196l, b3);
                        } else {
                            f2195k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = channelFeedFullscreenManager;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m2207a(int i) {
        if (this.f2202f != i) {
            this.f2202f = i;
            if (!this.f2203g || !this.f2204h) {
                if (i == 2) {
                    m2200h();
                } else if (this.f2203g && !m2199g()) {
                    m2201i();
                }
            }
        }
    }

    private boolean m2199g() {
        ChannelFeedVideoAttachmentView k = m2203k();
        if (k == null || k.f2523g == null || k.f2523g.a == null) {
            return false;
        }
        return k.f2523g.a.h;
    }

    public final void m2206a() {
        this.f2204h = true;
        m2200h();
    }

    public final boolean m2210b() {
        if (this.f2203g) {
            m2201i();
            if (this.f2202f == 1) {
                this.f2204h = false;
                return true;
            }
        }
        return false;
    }

    private void m2200h() {
        boolean z = true;
        ChannelFeedFullscreenPlayer j = m2202j();
        ChannelFeedVideoAttachmentView k = m2203k();
        if (j != null) {
            if (!(this.f2201e == null || this.f2205i)) {
                this.f2201e.f2425a.f2447P.ix_().setVisibility(4);
            }
            if (k == null) {
                this.f2205i = true;
                return;
            }
            this.f2203g = true;
            RichVideoPlayerParams richVideoPlayerParams = k.f2523g;
            int currentPositionMs = k.getRichVideoPlayer().getCurrentPositionMs();
            int lastStartPosition = k.getRichVideoPlayer().getLastStartPosition();
            PlaybackController playbackController = k.getRichVideoPlayer().u;
            VideoResolution e = playbackController != null ? playbackController.e() : VideoResolution.STANDARD_DEFINITION;
            if (k.f2522f.o()) {
                k.f2522f.b(EventTriggerType.BY_USER);
            }
            if (this.f2206j) {
                z = false;
            }
            j.m2241a(richVideoPlayerParams, currentPositionMs, lastStartPosition, z, e);
            m2204l();
            m2205n(this);
        }
    }

    private void m2201i() {
        ChannelFeedFullscreenPlayer j = m2202j();
        ChannelFeedVideoAttachmentView k = m2203k();
        if (j != null && k != null && j.getVisibility() == 0) {
            if (this.f2201e != null) {
                this.f2201e.f2425a.f2447P.ix_().setVisibility(0);
            }
            this.f2203g = false;
            int currentPositionMs = j.getCurrentPositionMs();
            boolean b = j.m2242b();
            VideoResolution videoResolution = j.getVideoResolution();
            if (videoResolution == null) {
                videoResolution = VideoResolution.STANDARD_DEFINITION;
            }
            j.m2240a();
            k.f2522f.a(videoResolution, EventTriggerType.BY_USER);
            k.f2522f.a(currentPositionMs, EventTriggerType.BY_USER);
            if (b) {
                k.f2522f.a(EventTriggerType.BY_USER);
            }
            this.f2197a.removeCallbacksAndMessages(null);
            if (this.f2198b != null) {
                if (VERSION.SDK_INT < 16) {
                    this.f2198b.clearFlags(1024);
                } else {
                    this.f2198b.getDecorView().setSystemUiVisibility(0);
                }
            }
        }
    }

    @Nullable
    private ChannelFeedFullscreenPlayer m2202j() {
        return this.f2199c == null ? null : (ChannelFeedFullscreenPlayer) this.f2199c.get();
    }

    @Nullable
    private ChannelFeedVideoAttachmentView m2203k() {
        return this.f2200d == null ? null : (ChannelFeedVideoAttachmentView) this.f2200d.get();
    }

    private void m2204l() {
        if (this.f2198b == null) {
            return;
        }
        if (VERSION.SDK_INT < 16) {
            this.f2198b.addFlags(1024);
        } else {
            this.f2198b.getDecorView().setSystemUiVisibility(1284);
        }
    }

    public static void m2205n(ChannelFeedFullscreenManager channelFeedFullscreenManager) {
        if (channelFeedFullscreenManager.f2198b != null) {
            if (VERSION.SDK_INT < 16) {
                if ((channelFeedFullscreenManager.f2198b.getAttributes().flags & 1024) == 0) {
                    channelFeedFullscreenManager.m2204l();
                }
            } else if ((channelFeedFullscreenManager.f2198b.getDecorView().getSystemUiVisibility() & 4) == 0) {
                channelFeedFullscreenManager.m2204l();
            }
            HandlerDetour.b(channelFeedFullscreenManager.f2197a, new C02111(channelFeedFullscreenManager), 2000, 1947881410);
        }
    }
}
