package com.facebook.feed.autoplay;

import android.os.Handler;
import android.view.View;
import com.facebook.common.util.StringUtil;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.video.abtest.AutoplayFeedRunnableConfig;
import com.facebook.video.abtest.VideoAbTestGatekeepers;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.channelfeed.ChannelFeedAutoscrollController.2;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: is_pushable */
public class VideoDisplayedCoordinator<V extends View> {
    public final VideoDisplayedSelector f18899a;
    private final VideoAutoplayVisibilityDecider f18900b;
    private final Handler f18901c;
    private final QeAccessor f18902d;
    private final GatekeeperStoreImpl f18903e;
    public final Map<V, VideoViewController<V>> f18904f = new WeakHashMap();
    public final List<VideoDisplayedChangedListener<V>> f18905g;
    private final Runnable f18906h;
    public boolean f18907i;
    private boolean f18908j = false;
    @Nullable
    public V f18909k = null;
    @Nullable
    private AutoplayFeedRunnableConfig f18910l;
    public final List<VideoVisibilityChangedListener<V>> f18911m;

    /* compiled from: is_pushable */
    class C07501 implements Runnable {
        final /* synthetic */ VideoDisplayedCoordinator f18912a;

        C07501(VideoDisplayedCoordinator videoDisplayedCoordinator) {
            this.f18912a = videoDisplayedCoordinator;
        }

        public void run() {
            TracerDetour.a("VideoDisplayedCoordinator.Runnable.run", 609629669);
            try {
                if (this.f18912a.f18907i) {
                    VideoDisplayedCoordinator.m26583e(this.f18912a);
                    View a = this.f18912a.f18899a.mo3042a(this.f18912a.f18904f.keySet());
                    if (a != this.f18912a.f18909k) {
                        View view = this.f18912a.f18909k;
                        VideoDisplayedCoordinator.m26581b(this.f18912a, a);
                        for (VideoDisplayedChangedListener a2 : new LinkedList(this.f18912a.f18905g)) {
                            a2.a(view, a);
                        }
                    }
                    if (this.f18912a.f18904f.isEmpty()) {
                        this.f18912a.f18907i = false;
                    } else {
                        VideoDisplayedCoordinator.m26584f(this.f18912a);
                    }
                    TracerDetour.a(1305401042);
                }
            } finally {
                TracerDetour.a(-1441118612);
            }
        }
    }

    @Inject
    public VideoDisplayedCoordinator(@Assisted VideoDisplayedSelector videoDisplayedSelector, @Assisted boolean z, VideoAutoplayVisibilityDecider videoAutoplayVisibilityDecider, Handler handler, QeAccessor qeAccessor, GatekeeperStoreImpl gatekeeperStoreImpl, FeedAutoplayActivityListener feedAutoplayActivityListener) {
        this.f18900b = videoAutoplayVisibilityDecider;
        this.f18901c = handler;
        this.f18902d = qeAccessor;
        this.f18903e = gatekeeperStoreImpl;
        this.f18899a = videoDisplayedSelector;
        this.f18905g = new LinkedList();
        this.f18906h = new C07501(this);
        if (!m26585g() || z) {
            feedAutoplayActivityListener.f8533b.add(new WeakReference(this));
        } else {
            this.f18908j = true;
        }
        this.f18911m = new LinkedList();
    }

    public final void m26587a(V v, VideoViewController<V> videoViewController) {
        synchronized (this) {
            if (this.f18904f.containsKey(v)) {
                if (!StringUtil.m3590a(videoViewController.a(), ((VideoViewController) this.f18904f.get(v)).a())) {
                    m26582c(v);
                }
            }
            this.f18904f.put(v, videoViewController);
            for (2 a : this.f18911m) {
                a.a(v);
            }
        }
        if (!this.f18907i && !this.f18908j) {
            this.f18907i = true;
            m26584f(this);
        }
    }

    public final void m26586a(V v) {
        boolean z = (v instanceof KeepRegisteredVideoPlayerView) && ((KeepRegisteredVideoPlayerView) v).d();
        Preconditions.checkState(z, "Unregister should only be called for views that have keep registered enabled.");
        synchronized (this) {
            if (this.f18904f.containsKey(v)) {
                m26582c(v);
                this.f18904f.remove(v);
            }
            for (2 b : this.f18911m) {
                b.b(v);
            }
        }
    }

    public final void m26588a(VideoDisplayedChangedListener<V> videoDisplayedChangedListener) {
        this.f18905g.add(videoDisplayedChangedListener);
    }

    public final void m26591b(VideoDisplayedChangedListener<V> videoDisplayedChangedListener) {
        this.f18905g.remove(videoDisplayedChangedListener);
    }

    public static void m26583e(VideoDisplayedCoordinator videoDisplayedCoordinator) {
        synchronized (videoDisplayedCoordinator) {
            for (Object obj : videoDisplayedCoordinator.f18904f.keySet().toArray()) {
                View view = (View) obj;
                if (videoDisplayedCoordinator.f18900b.m26578b(view)) {
                    videoDisplayedCoordinator.m26582c(view);
                    if (!((view instanceof KeepRegisteredVideoPlayerView) && ((KeepRegisteredVideoPlayerView) view).d())) {
                        videoDisplayedCoordinator.f18904f.remove(view);
                    }
                    for (2 b : videoDisplayedCoordinator.f18911m) {
                        b.b(view);
                    }
                }
            }
        }
    }

    public final void m26590b() {
        synchronized (this) {
            for (Object obj : this.f18904f.keySet().toArray()) {
                View view = (View) obj;
                m26582c(view);
                this.f18904f.remove(view);
            }
        }
        this.f18909k = null;
    }

    public static synchronized void m26581b(VideoDisplayedCoordinator videoDisplayedCoordinator, View view) {
        synchronized (videoDisplayedCoordinator) {
            if (((VideoViewController) videoDisplayedCoordinator.f18904f.get(videoDisplayedCoordinator.f18909k)) != null) {
                videoDisplayedCoordinator.m26582c(videoDisplayedCoordinator.f18909k);
            }
            videoDisplayedCoordinator.f18909k = view;
            VideoViewController videoViewController = (VideoViewController) videoDisplayedCoordinator.f18904f.get(view);
            if (videoViewController != null) {
                videoViewController.b(view);
            }
        }
    }

    private void m26582c(V v) {
        if (this.f18909k == v) {
            ((VideoViewController) this.f18904f.get(v)).a(v);
            this.f18909k = null;
        }
    }

    public final void m26592c() {
        m26589a(EventTriggerType.BY_AUTOPLAY);
    }

    public final void m26589a(EventTriggerType eventTriggerType) {
        if (this.f18907i) {
            if (this.f18909k != null) {
                View view = this.f18909k;
                if (this.f18909k == view) {
                    ((VideoViewController) this.f18904f.get(view)).a(view, eventTriggerType);
                    this.f18909k = null;
                }
            }
            this.f18907i = false;
            if (!m26585g()) {
                this.f18908j = true;
            }
        }
        if (m26585g()) {
            this.f18908j = true;
        }
    }

    public final void m26593d() {
        if (m26585g()) {
            this.f18908j = false;
        }
        if (!this.f18907i) {
            this.f18907i = true;
            if (!m26585g()) {
                this.f18908j = false;
            }
            m26584f(this);
        }
    }

    public static void m26584f(VideoDisplayedCoordinator videoDisplayedCoordinator) {
        if (videoDisplayedCoordinator.f18910l == null) {
            videoDisplayedCoordinator.f18910l = new AutoplayFeedRunnableConfig(videoDisplayedCoordinator.f18902d);
        }
        HandlerDetour.b(videoDisplayedCoordinator.f18901c, videoDisplayedCoordinator.f18906h, (long) videoDisplayedCoordinator.f18910l.b, 732523459);
    }

    private boolean m26585g() {
        return this.f18903e.m2189a(VideoAbTestGatekeepers.f18922j, false);
    }
}
