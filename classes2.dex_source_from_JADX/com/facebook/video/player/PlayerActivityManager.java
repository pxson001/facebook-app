package com.facebook.video.player;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.VideoEngineUtils;
import com.facebook.video.player.plugins.PlaybackController;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.google.common.annotations.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: query does not contain token  */
public class PlayerActivityManager {
    private static PlayerActivityManager f8447e;
    private static final Object f8448f = new Object();
    @VisibleForTesting
    List<WeakReference<RichVideoPlayer>> f8449a = new ArrayList();
    List<WeakReference<RichVideoPlayer>> f8450b = new ArrayList();
    private final VideoEngineUtils f8451c;
    private final RichVideoPlayerPauseFrameCache f8452d;

    private static PlayerActivityManager m12996b(InjectorLike injectorLike) {
        return new PlayerActivityManager(VideoEngineUtils.m13007a(injectorLike), RichVideoPlayerPauseFrameCache.m13010a(injectorLike));
    }

    @Inject
    public PlayerActivityManager(VideoEngineUtils videoEngineUtils, RichVideoPlayerPauseFrameCache richVideoPlayerPauseFrameCache) {
        this.f8451c = videoEngineUtils;
        this.f8452d = richVideoPlayerPauseFrameCache;
    }

    public final synchronized void m12999a(RichVideoPlayer richVideoPlayer) {
        this.f8449a.add(new WeakReference(richVideoPlayer));
    }

    public final synchronized void m12997a() {
        VideoEngineUtils.m13008a(this.f8449a);
        for (WeakReference weakReference : this.f8449a) {
            RichVideoPlayer richVideoPlayer = (RichVideoPlayer) weakReference.get();
            if (richVideoPlayer != null) {
                richVideoPlayer.f();
            }
        }
    }

    public static PlayerActivityManager m12995a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PlayerActivityManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f8448f) {
                PlayerActivityManager playerActivityManager;
                if (a2 != null) {
                    playerActivityManager = (PlayerActivityManager) a2.mo818a(f8448f);
                } else {
                    playerActivityManager = f8447e;
                }
                if (playerActivityManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m12996b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f8448f, b3);
                        } else {
                            f8447e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = playerActivityManager;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final synchronized void m13001b() {
        VideoEngineUtils.m13008a(this.f8449a);
        for (WeakReference weakReference : this.f8449a) {
            RichVideoPlayer richVideoPlayer = (RichVideoPlayer) weakReference.get();
            if (richVideoPlayer != null) {
                richVideoPlayer.e();
            }
        }
    }

    public final synchronized void m13003c() {
        VideoEngineUtils.m13008a(this.f8449a);
        for (WeakReference weakReference : this.f8449a) {
            RichVideoPlayer richVideoPlayer = (RichVideoPlayer) weakReference.get();
            if (richVideoPlayer != null) {
                richVideoPlayer.iZ_();
            }
        }
    }

    public final synchronized void m13004d() {
        VideoEngineUtils.m13008a(this.f8449a);
        for (WeakReference weakReference : this.f8449a) {
            RichVideoPlayer richVideoPlayer = (RichVideoPlayer) weakReference.get();
            if (richVideoPlayer != null) {
                richVideoPlayer.c();
            }
        }
    }

    public final synchronized boolean m13000a(PlaybackController playbackController, boolean z) {
        boolean z2;
        if (playbackController.a()) {
            VideoEngineUtils.m13008a(this.f8449a);
            for (WeakReference weakReference : this.f8449a) {
                RichVideoPlayer richVideoPlayer = (RichVideoPlayer) weakReference.get();
                if (richVideoPlayer != null) {
                    PlaybackController playbackController2 = richVideoPlayer.getPlaybackController();
                    if (playbackController2 != null && playbackController2 != playbackController && playbackController2.a() && playbackController2.l()) {
                        if (!z) {
                            z2 = false;
                            break;
                        }
                        playbackController2.a(EventTriggerType.BY_MANAGER);
                    }
                }
            }
            z2 = true;
        } else {
            z2 = true;
        }
        return z2;
    }

    public final synchronized void m12998a(EventTriggerType eventTriggerType) {
        VideoEngineUtils.m13008a(this.f8449a);
        this.f8450b.clear();
        for (WeakReference weakReference : this.f8449a) {
            RichVideoPlayer richVideoPlayer = (RichVideoPlayer) weakReference.get();
            if (richVideoPlayer != null && (richVideoPlayer.getPlayerState() == State.ATTEMPT_TO_PLAY || richVideoPlayer.getPlayerState() == State.PLAYING)) {
                richVideoPlayer.b(eventTriggerType);
                this.f8450b.add(weakReference);
            }
        }
    }

    public final synchronized void m13002b(EventTriggerType eventTriggerType) {
        VideoEngineUtils.m13008a(this.f8450b);
        for (WeakReference weakReference : this.f8450b) {
            RichVideoPlayer richVideoPlayer = (RichVideoPlayer) weakReference.get();
            if (!(richVideoPlayer == null || richVideoPlayer.getPlayerState() == State.ATTEMPT_TO_PLAY || richVideoPlayer.getPlayerState() == State.PLAYING)) {
                richVideoPlayer.a(eventTriggerType);
            }
        }
        this.f8450b.clear();
    }
}
