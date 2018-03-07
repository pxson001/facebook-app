package com.facebook.video.channelfeed;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.facebook.common.collect.WeakHashSets;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.event.FbEvent;
import com.facebook.device.ScreenUtil;
import com.facebook.feed.autoplay.VideoAutoplayVisibilityDecider;
import com.facebook.feed.autoplay.VideoDisplayedCoordinator.VideoDisplayedChangedListener;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.video.channelfeed.ChannelFeedRootView.AnonymousClass15;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.google.common.base.Function;
import java.lang.ref.WeakReference;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: tending_items */
public class ChannelFeedAutoscrollController {
    private static ChannelFeedAutoscrollController f2090k;
    private static final Object f2091l = new Object();
    public final AutoscrollHandler f2092a = new AutoscrollHandler(this);
    public final PlayerStateChangedEventSubscriber f2093b = new PlayerStateChangedEventSubscriber(this);
    private final ScreenUtil f2094c;
    private final VideoAutoplayVisibilityDecider f2095d;
    public final VideoDisplayedChangedListener f2096e;
    public final C02042 f2097f;
    public final Set<ChannelFeedVideoAttachmentView> f2098g;
    @Nullable
    public AnonymousClass15 f2099h;
    public WeakReference<ChannelFeedVideoAttachmentView> f2100i;
    @Nullable
    public Function<String, GraphQLStory> f2101j;

    /* compiled from: tending_items */
    class C02031 implements VideoDisplayedChangedListener<ChannelFeedVideoAttachmentView> {
        final /* synthetic */ ChannelFeedAutoscrollController f2085a;

        C02031(ChannelFeedAutoscrollController channelFeedAutoscrollController) {
            this.f2085a = channelFeedAutoscrollController;
        }

        public final void m2101a(View view, View view2) {
            ChannelFeedVideoAttachmentView channelFeedVideoAttachmentView = (ChannelFeedVideoAttachmentView) view;
            ChannelFeedVideoAttachmentView channelFeedVideoAttachmentView2 = (ChannelFeedVideoAttachmentView) view2;
            if (channelFeedVideoAttachmentView != null) {
                ChannelFeedAutoscrollController channelFeedAutoscrollController = this.f2085a;
                channelFeedAutoscrollController.f2100i = null;
                channelFeedVideoAttachmentView.getRichVideoPlayer().b(channelFeedAutoscrollController.f2093b);
                channelFeedAutoscrollController.f2093b.f2089b = null;
            }
            if (channelFeedVideoAttachmentView2 != null) {
                channelFeedAutoscrollController = this.f2085a;
                channelFeedAutoscrollController.f2100i = new WeakReference(channelFeedVideoAttachmentView2);
                channelFeedVideoAttachmentView2.getRichVideoPlayer().a(channelFeedAutoscrollController.f2093b);
            }
        }
    }

    /* compiled from: tending_items */
    public class C02042 {
        final /* synthetic */ ChannelFeedAutoscrollController f2086a;

        C02042(ChannelFeedAutoscrollController channelFeedAutoscrollController) {
            this.f2086a = channelFeedAutoscrollController;
        }

        public final void m2102a(View view) {
            ChannelFeedVideoAttachmentView channelFeedVideoAttachmentView = (ChannelFeedVideoAttachmentView) view;
            if (channelFeedVideoAttachmentView != null) {
                synchronized (this.f2086a) {
                    this.f2086a.f2098g.add(channelFeedVideoAttachmentView);
                }
            }
        }

        public final void m2103b(View view) {
            ChannelFeedVideoAttachmentView channelFeedVideoAttachmentView = (ChannelFeedVideoAttachmentView) view;
            if (channelFeedVideoAttachmentView != null) {
                synchronized (this.f2086a) {
                    this.f2086a.f2098g.remove(channelFeedVideoAttachmentView);
                }
            }
        }
    }

    /* compiled from: tending_items */
    class AutoscrollHandler extends Handler {
        private final WeakReference<ChannelFeedAutoscrollController> f2087a;

        public AutoscrollHandler(ChannelFeedAutoscrollController channelFeedAutoscrollController) {
            this.f2087a = new WeakReference(channelFeedAutoscrollController);
        }

        public void handleMessage(Message message) {
            ChannelFeedAutoscrollController channelFeedAutoscrollController = (ChannelFeedAutoscrollController) this.f2087a.get();
            if (channelFeedAutoscrollController != null) {
                switch (message.what) {
                    case 1:
                        Object obj = (channelFeedAutoscrollController.f2101j == null || channelFeedAutoscrollController.f2100i == null || channelFeedAutoscrollController.f2100i.get() == null) ? null : channelFeedAutoscrollController.f2101j.apply(((ChannelFeedVideoAttachmentView) channelFeedAutoscrollController.f2100i.get()).f2524h) != null ? 1 : null;
                        if (obj != null) {
                            channelFeedAutoscrollController.m2110d();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* compiled from: tending_items */
    public class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ ChannelFeedAutoscrollController f2088a;
        public State f2089b;

        public PlayerStateChangedEventSubscriber(ChannelFeedAutoscrollController channelFeedAutoscrollController) {
            this.f2088a = channelFeedAutoscrollController;
        }

        public final void m2105b(FbEvent fbEvent) {
            RVPPlayerStateChangedEvent rVPPlayerStateChangedEvent = (RVPPlayerStateChangedEvent) fbEvent;
            if (rVPPlayerStateChangedEvent.b == State.PLAYBACK_COMPLETE && this.f2089b != rVPPlayerStateChangedEvent.b) {
                this.f2088a.f2092a.sendEmptyMessageDelayed(1, 2000);
            }
            this.f2089b = rVPPlayerStateChangedEvent.b;
        }

        public final Class<RVPPlayerStateChangedEvent> m2104a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    private static ChannelFeedAutoscrollController m2109b(InjectorLike injectorLike) {
        return new ChannelFeedAutoscrollController(ScreenUtil.a(injectorLike), VideoAutoplayVisibilityDecider.a(injectorLike));
    }

    @Inject
    public ChannelFeedAutoscrollController(ScreenUtil screenUtil, VideoAutoplayVisibilityDecider videoAutoplayVisibilityDecider) {
        this.f2094c = screenUtil;
        this.f2095d = videoAutoplayVisibilityDecider;
        this.f2096e = new C02031(this);
        this.f2098g = WeakHashSets.a();
        this.f2097f = new C02042(this);
    }

    public static ChannelFeedAutoscrollController m2107a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedAutoscrollController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2091l) {
                ChannelFeedAutoscrollController channelFeedAutoscrollController;
                if (a2 != null) {
                    channelFeedAutoscrollController = (ChannelFeedAutoscrollController) a2.a(f2091l);
                } else {
                    channelFeedAutoscrollController = f2090k;
                }
                if (channelFeedAutoscrollController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2109b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2091l, b3);
                        } else {
                            f2090k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = channelFeedAutoscrollController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m2110d() {
        if (this.f2099h != null && this.f2100i != null && this.f2100i.get() != null) {
            int a;
            synchronized (this) {
                a = m2106a(m2108a(true), true);
            }
            this.f2099h.m2354a(a);
        }
    }

    public final void m2111e() {
        if (this.f2099h != null && this.f2100i != null && this.f2100i.get() != null) {
            int a;
            synchronized (this) {
                a = m2106a(m2108a(false), false);
            }
            this.f2099h.m2354a(a);
        }
    }

    @Nullable
    private ChannelFeedVideoAttachmentView m2108a(boolean z) {
        ChannelFeedVideoAttachmentView channelFeedVideoAttachmentView = null;
        if (this.f2098g.size() != 0) {
            ChannelFeedVideoAttachmentView channelFeedVideoAttachmentView2 = (ChannelFeedVideoAttachmentView) this.f2100i.get();
            if (channelFeedVideoAttachmentView2 != null) {
                int top = channelFeedVideoAttachmentView2.getTop();
                int i = Integer.MAX_VALUE;
                for (ChannelFeedVideoAttachmentView channelFeedVideoAttachmentView22 : this.f2098g) {
                    if (!(channelFeedVideoAttachmentView22 == null || this.f2095d.b(channelFeedVideoAttachmentView22))) {
                        int top2 = channelFeedVideoAttachmentView22.getTop();
                        if (!z || top2 <= top || top2 - top >= i) {
                            int i2;
                            if (z || top2 >= top || top - top2 >= i) {
                                channelFeedVideoAttachmentView22 = channelFeedVideoAttachmentView;
                                i2 = i;
                            } else {
                                i2 = top - top2;
                            }
                            i = i2;
                            channelFeedVideoAttachmentView = channelFeedVideoAttachmentView22;
                        } else {
                            i = top2 - top;
                            channelFeedVideoAttachmentView = channelFeedVideoAttachmentView22;
                        }
                    }
                }
            }
        }
        return channelFeedVideoAttachmentView;
    }

    private int m2106a(ChannelFeedVideoAttachmentView channelFeedVideoAttachmentView, boolean z) {
        if (channelFeedVideoAttachmentView == null) {
            return z ? ((ChannelFeedVideoAttachmentView) this.f2100i.get()).getBottom() : -((ChannelFeedVideoAttachmentView) this.f2100i.get()).getBottom();
        } else {
            return ((channelFeedVideoAttachmentView.getBottom() + channelFeedVideoAttachmentView.getTop()) / 2) - (this.f2094c.d() / 2);
        }
    }
}
