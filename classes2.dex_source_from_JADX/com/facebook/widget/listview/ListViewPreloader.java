package com.facebook.widget.listview;

import android.support.annotation.Nullable;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.common.userinteraction.UserInteractionListener;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.listview.throttling.ThrottledOnScrollListenerFactory;
import com.google.common.base.Preconditions;

/* compiled from: messenger_send_video_android */
public abstract class ListViewPreloader {
    public static final PreloadDirection f13757a = PreloadDirection.CLOSEST_FIRST;
    public static final PreloadType f13758b = PreloadType.ALL_OFFSCREEN;
    public final OnScrollListener f13759c;
    private final ScrollingViewProxy f13760d;
    private final DefaultUserInteractionController f13761e;
    private final UserInteractionListener f13762f;
    private final boolean f13763g;
    private final PreloadBufferSizeCalculator f13764h;
    private final PreloadDirection f13765i;
    private final PreloadType f13766j;
    private boolean f13767k;
    private boolean f13768l;
    private int f13769m;
    private int f13770n;
    private int f13771o;
    private int f13772p;
    private int f13773q;

    /* compiled from: messenger_send_video_android */
    public enum PreloadDirection {
        FURTHEST_FIRST,
        CLOSEST_FIRST
    }

    /* compiled from: messenger_send_video_android */
    public enum PreloadType {
        ALL_ONSCREEN_AND_OFFSCREEN,
        ALL_OFFSCREEN
    }

    /* compiled from: messenger_send_video_android */
    class FixedSizePreloadBufferSizeCalculator implements PreloadBufferSizeCalculator {
        private final PreloadBufferSize f13794a;

        public FixedSizePreloadBufferSizeCalculator(int i) {
            this.f13794a = new PreloadBufferSize(i, i);
        }

        public final PreloadBufferSize mo2671a() {
            return this.f13794a;
        }
    }

    /* compiled from: messenger_send_video_android */
    public interface PreloadBufferSizeCalculator {
        PreloadBufferSize mo2671a();
    }

    /* compiled from: messenger_send_video_android */
    public class PreloadBufferSize {
        public final int f13795a;
        public final int f13796b;

        public PreloadBufferSize(int i, int i2) {
            boolean z = true;
            Preconditions.checkArgument(i >= 0);
            if (i2 < 0) {
                z = false;
            }
            Preconditions.checkArgument(z);
            this.f13795a = i;
            this.f13796b = i2;
        }
    }

    /* compiled from: messenger_send_video_android */
    public enum PreloadLocation {
        ONSCREEN,
        OFFSCREEN
    }

    protected abstract void mo2667a(int i);

    public abstract boolean mo2668b(int i);

    public abstract void mo2669c(int i);

    public ListViewPreloader(ScrollingViewProxy scrollingViewProxy, int i) {
        this(scrollingViewProxy, i, f13757a, f13758b, null, true, null, 0);
    }

    public ListViewPreloader(ScrollingViewProxy scrollingViewProxy, int i, PreloadDirection preloadDirection, PreloadType preloadType, DefaultUserInteractionController defaultUserInteractionController, boolean z, @Nullable ThrottledOnScrollListenerFactory throttledOnScrollListenerFactory, int i2) {
        this(scrollingViewProxy, new FixedSizePreloadBufferSizeCalculator(i), preloadDirection, preloadType, defaultUserInteractionController, z, throttledOnScrollListenerFactory, i2);
    }

    public ListViewPreloader(ScrollingViewProxy scrollingViewProxy, PreloadBufferSizeCalculator preloadBufferSizeCalculator, PreloadDirection preloadDirection, PreloadType preloadType, DefaultUserInteractionController defaultUserInteractionController, boolean z, @Nullable ThrottledOnScrollListenerFactory throttledOnScrollListenerFactory, final int i) {
        boolean z2 = false;
        this.f13767k = false;
        this.f13768l = false;
        this.f13769m = -1;
        this.f13770n = -1;
        this.f13771o = -1;
        this.f13772p = -1;
        this.f13773q = -1;
        Preconditions.checkNotNull(scrollingViewProxy);
        Preconditions.checkNotNull(preloadBufferSizeCalculator);
        if (z || defaultUserInteractionController != null) {
            z2 = true;
        }
        Preconditions.checkArgument(z2);
        Preconditions.checkNotNull(preloadDirection);
        Preconditions.checkNotNull(preloadType);
        this.f13760d = scrollingViewProxy;
        this.f13764h = preloadBufferSizeCalculator;
        this.f13765i = preloadDirection;
        this.f13766j = preloadType;
        OnScrollListener c05601 = new ScrollListenerWithThrottlingSupport(this) {
            final /* synthetic */ ListViewPreloader f13798b;

            public final void mo1262a(ScrollingViewProxy scrollingViewProxy, int i) {
            }

            public final void mo1263a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
                ListViewPreloader.m20183a(this.f13798b, i, i2, i3);
            }

            public final int mo1974a() {
                return i;
            }
        };
        if (throttledOnScrollListenerFactory != null) {
            c05601 = throttledOnScrollListenerFactory.m14481b(c05601);
        }
        this.f13759c = c05601;
        this.f13760d.mo2369b(this.f13759c);
        this.f13761e = defaultUserInteractionController;
        this.f13763g = z;
        if (this.f13763g) {
            this.f13762f = null;
            return;
        }
        this.f13762f = new 2(this);
        this.f13761e.m1754a(this.f13762f);
    }

    public final void m20186a() {
        this.f13760d.mo2374c(this.f13759c);
        if (this.f13761e != null) {
            this.f13761e.m1756b(this.f13762f);
        }
    }

    private void m20182a(int i, PreloadLocation preloadLocation) {
        if (!mo2668b(i)) {
            mo2667a(i);
        }
    }

    public static void m20183a(ListViewPreloader listViewPreloader, int i, int i2, int i3) {
        if (i3 != 0) {
            if (listViewPreloader.f13770n != i || listViewPreloader.f13771o != (i + i2) - 1 || listViewPreloader.f13773q != i3) {
                listViewPreloader.f13770n = i;
                listViewPreloader.f13771o = (i + i2) - 1;
                listViewPreloader.f13773q = i3;
                PreloadBufferSize a = listViewPreloader.f13764h.mo2671a();
                int i4 = listViewPreloader.f13769m;
                int i5 = listViewPreloader.f13772p;
                listViewPreloader.f13769m = Math.max(listViewPreloader.f13770n - a.f13795a, 0);
                listViewPreloader.f13772p = Math.min(a.f13796b + listViewPreloader.f13771o, i3 - 1);
                if (listViewPreloader.f13769m != i4 || listViewPreloader.f13772p != i5) {
                    listViewPreloader.f13768l = true;
                    int i6 = i4;
                    while (i6 < listViewPreloader.f13769m) {
                        if (i6 >= 0 && i6 < listViewPreloader.f13773q) {
                            listViewPreloader.mo2669c(i6);
                        }
                        i6++;
                    }
                    i6 = listViewPreloader.f13772p + 1;
                    while (i6 <= i5) {
                        if (i6 >= 0 && i6 < listViewPreloader.f13773q) {
                            listViewPreloader.mo2669c(i6);
                        }
                        i6++;
                    }
                    if (listViewPreloader.f13769m < i4 || listViewPreloader.f13772p > i5) {
                        listViewPreloader.m20185b();
                    }
                }
            }
        }
    }

    public static void m20184a(ListViewPreloader listViewPreloader, boolean z) {
        listViewPreloader.f13767k = z;
        listViewPreloader.m20185b();
    }

    private void m20185b() {
        if (!this.f13768l) {
            return;
        }
        if (!this.f13767k || this.f13763g) {
            int i;
            boolean z;
            if (this.f13766j == PreloadType.ALL_ONSCREEN_AND_OFFSCREEN && this.f13765i == PreloadDirection.CLOSEST_FIRST) {
                for (i = this.f13770n; i <= this.f13771o; i++) {
                    m20182a(i, PreloadLocation.ONSCREEN);
                }
            }
            boolean max = Math.max(this.f13770n - this.f13769m, this.f13772p - this.f13771o);
            boolean z2 = max + 1;
            if (this.f13765i == PreloadDirection.FURTHEST_FIRST) {
                i = -1;
                z = false;
            } else {
                max = true;
                boolean z3 = z2;
                i = 1;
                z = z3;
            }
            while (max != z) {
                if (this.f13770n - max >= this.f13769m) {
                    m20182a(this.f13770n - max, PreloadLocation.OFFSCREEN);
                }
                if (this.f13771o + max <= this.f13772p) {
                    m20182a(this.f13771o + max, PreloadLocation.OFFSCREEN);
                }
                max += i;
            }
            if (this.f13766j == PreloadType.ALL_ONSCREEN_AND_OFFSCREEN && this.f13765i == PreloadDirection.FURTHEST_FIRST) {
                for (i = this.f13770n; i <= this.f13771o; i++) {
                    m20182a(i, PreloadLocation.ONSCREEN);
                }
            }
            this.f13768l = false;
        }
    }
}
