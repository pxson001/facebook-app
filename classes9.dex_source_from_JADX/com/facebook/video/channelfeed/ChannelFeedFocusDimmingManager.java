package com.facebook.video.channelfeed;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.video.engine.VideoEngineUtils;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerScheduledRunnable;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController.State;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: task finished before it started? */
public class ChannelFeedFocusDimmingManager {
    private static ChannelFeedFocusDimmingManager f2179h;
    private static final Object f2180i = new Object();
    public final FocusDimmingHandler f2181a = new FocusDimmingHandler(this);
    private final RichVideoPlayerScheduledRunnable f2182b;
    private final PlayerStateChangedEventSubscriber f2183c;
    public final List<WeakReference<CanFocusDim>> f2184d = new LinkedList();
    private final VideoEngineUtils f2185e;
    private WeakReference<ChannelFeedDimmingController> f2186f;
    private WeakReference<RichVideoPlayer> f2187g;

    /* compiled from: task finished before it started? */
    class FocusDimmingHandler extends Handler {
        private final WeakReference<ChannelFeedFocusDimmingManager> f2177a;

        public FocusDimmingHandler(ChannelFeedFocusDimmingManager channelFeedFocusDimmingManager) {
            this.f2177a = new WeakReference(channelFeedFocusDimmingManager);
        }

        public void handleMessage(Message message) {
            ChannelFeedFocusDimmingManager channelFeedFocusDimmingManager = (ChannelFeedFocusDimmingManager) this.f2177a.get();
            if (channelFeedFocusDimmingManager != null) {
                switch (message.what) {
                    case 1:
                        ChannelFeedFocusDimmingManager.m2181c(channelFeedFocusDimmingManager);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* compiled from: task finished before it started? */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ ChannelFeedFocusDimmingManager f2178a;

        public PlayerStateChangedEventSubscriber(ChannelFeedFocusDimmingManager channelFeedFocusDimmingManager) {
            this.f2178a = channelFeedFocusDimmingManager;
        }

        public final void m2176b(FbEvent fbEvent) {
            ChannelFeedFocusDimmingManager.m2178a(this.f2178a, ((RVPPlayerStateChangedEvent) fbEvent).b);
        }

        public final Class<RVPPlayerStateChangedEvent> m2175a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    private static ChannelFeedFocusDimmingManager m2179b(InjectorLike injectorLike) {
        return new ChannelFeedFocusDimmingManager(VideoEngineUtils.a(injectorLike));
    }

    @Inject
    public ChannelFeedFocusDimmingManager(VideoEngineUtils videoEngineUtils) {
        this.f2185e = videoEngineUtils;
        this.f2182b = new RichVideoPlayerScheduledRunnable(this, 0.7f, 1.0f) {
            final /* synthetic */ ChannelFeedFocusDimmingManager f2176a;

            public void run() {
                this.f2176a.f2181a.removeMessages(1);
                ChannelFeedFocusDimmingManager.m2182d(this.f2176a);
            }
        };
        this.f2183c = new PlayerStateChangedEventSubscriber(this);
    }

    public final void m2187a(ChannelFeedDimmingController channelFeedDimmingController, RichVideoPlayer richVideoPlayer) {
        this.f2186f = new WeakReference(channelFeedDimmingController);
        this.f2187g = new WeakReference(richVideoPlayer);
        richVideoPlayer.a(this.f2182b);
        richVideoPlayer.a(this.f2183c);
        m2180b();
    }

    public static ChannelFeedFocusDimmingManager m2177a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedFocusDimmingManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2180i) {
                ChannelFeedFocusDimmingManager channelFeedFocusDimmingManager;
                if (a2 != null) {
                    channelFeedFocusDimmingManager = (ChannelFeedFocusDimmingManager) a2.a(f2180i);
                } else {
                    channelFeedFocusDimmingManager = f2179h;
                }
                if (channelFeedFocusDimmingManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2179b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2180i, b3);
                        } else {
                            f2179h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = channelFeedFocusDimmingManager;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m2188b(ChannelFeedDimmingController channelFeedDimmingController, RichVideoPlayer richVideoPlayer) {
        if (m2183e() == channelFeedDimmingController) {
            this.f2181a.removeMessages(1);
            channelFeedDimmingController.m2137d();
            this.f2186f = null;
            richVideoPlayer.b(this.f2182b);
            richVideoPlayer.b(this.f2183c);
            this.f2187g = null;
        }
    }

    public final void m2186a(CanFocusDim canFocusDim) {
        this.f2184d.add(new WeakReference(canFocusDim));
    }

    public final void m2184a() {
        this.f2181a.removeMessages(1);
        m2182d(this);
        m2180b();
    }

    public final void m2185a(int i) {
        if (i == 0) {
            m2180b();
            return;
        }
        this.f2181a.removeMessages(1);
        m2182d(this);
    }

    private void m2180b() {
        Object obj;
        WeakReference weakReference = this.f2187g;
        RichVideoPlayer richVideoPlayer = weakReference != null ? (RichVideoPlayer) weakReference.get() : null;
        if (richVideoPlayer == null || !richVideoPlayer.m() || richVideoPlayer.getPlaybackPercentage() >= 0.7f) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            this.f2181a.sendEmptyMessageDelayed(1, 3000);
        }
    }

    public static void m2181c(ChannelFeedFocusDimmingManager channelFeedFocusDimmingManager) {
        ChannelFeedDimmingController e = channelFeedFocusDimmingManager.m2183e();
        if (e != null) {
            e.m2136c();
        }
        VideoEngineUtils.a(channelFeedFocusDimmingManager.f2184d);
        for (WeakReference weakReference : channelFeedFocusDimmingManager.f2184d) {
            if (weakReference.get() != null) {
                ((CanFocusDim) weakReference.get()).mo66a();
            }
        }
    }

    public static void m2182d(ChannelFeedFocusDimmingManager channelFeedFocusDimmingManager) {
        ChannelFeedDimmingController e = channelFeedFocusDimmingManager.m2183e();
        if (e != null) {
            e.m2137d();
        }
        VideoEngineUtils.a(channelFeedFocusDimmingManager.f2184d);
        for (WeakReference weakReference : channelFeedFocusDimmingManager.f2184d) {
            if (weakReference.get() != null) {
                ((CanFocusDim) weakReference.get()).mo67b();
            }
        }
    }

    @Nullable
    private ChannelFeedDimmingController m2183e() {
        return this.f2186f != null ? (ChannelFeedDimmingController) this.f2186f.get() : null;
    }

    public static void m2178a(ChannelFeedFocusDimmingManager channelFeedFocusDimmingManager, State state) {
        if (state == State.PLAYING) {
            channelFeedFocusDimmingManager.m2180b();
            return;
        }
        channelFeedFocusDimmingManager.f2181a.removeMessages(1);
        m2182d(channelFeedFocusDimmingManager);
    }
}
