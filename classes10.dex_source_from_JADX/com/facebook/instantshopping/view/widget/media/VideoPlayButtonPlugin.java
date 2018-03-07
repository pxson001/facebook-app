package com.facebook.instantshopping.view.widget.media;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.content.event.FbEvent;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.richdocument.gk.RichDocumentGatekeepers;
import com.facebook.richdocument.view.widget.video.VideoControlIcon;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPPlayIconStateEvent;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import javax.inject.Inject;

/* compiled from: SERIALIZATION_ERROR */
public class VideoPlayButtonPlugin extends RichVideoPlayerPlugin {
    @Inject
    public GatekeeperStoreImpl f23954a;
    public VideoControlIcon f23955b;
    public boolean f23956c;
    private boolean f23957d;

    /* compiled from: SERIALIZATION_ERROR */
    /* synthetic */ class C34331 {
        static final /* synthetic */ int[] f23951a = new int[State.values().length];

        static {
            try {
                f23951a[State.UNPREPARED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23951a[State.PREPARED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f23951a[State.SEEKING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* compiled from: SERIALIZATION_ERROR */
    class PlayIconStateEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayIconStateEvent> {
        final /* synthetic */ VideoPlayButtonPlugin f23952a;

        public PlayIconStateEventSubscriber(VideoPlayButtonPlugin videoPlayButtonPlugin) {
            this.f23952a = videoPlayButtonPlugin;
        }

        public final void m25222b(FbEvent fbEvent) {
            if (this.f23952a.h != null) {
                VideoPlayButtonPlugin.m25225a(this.f23952a, this.f23952a.h.l);
            }
        }

        public final Class<RVPPlayIconStateEvent> m25221a() {
            return RVPPlayIconStateEvent.class;
        }
    }

    /* compiled from: SERIALIZATION_ERROR */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ VideoPlayButtonPlugin f23953a;

        public PlayerStateChangedEventSubscriber(VideoPlayButtonPlugin videoPlayButtonPlugin) {
            this.f23953a = videoPlayButtonPlugin;
        }

        public final void m25224b(FbEvent fbEvent) {
            VideoPlayButtonPlugin.m25225a(this.f23953a, ((RVPPlayerStateChangedEvent) fbEvent).b);
        }

        public final Class<RVPPlayerStateChangedEvent> m25223a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    public static void m25226a(Object obj, Context context) {
        ((VideoPlayButtonPlugin) obj).f23954a = GatekeeperStoreImplMethodAutoProvider.a(FbInjector.get(context));
    }

    public VideoPlayButtonPlugin(Context context) {
        this(context, null);
    }

    private VideoPlayButtonPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private VideoPlayButtonPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23956c = true;
        Class cls = VideoPlayButtonPlugin.class;
        m25226a((Object) this, getContext());
        this.f23957d = this.f23954a.a(RichDocumentGatekeepers.b, false);
        setContentView(2130904985);
        this.f.add(new PlayerStateChangedEventSubscriber(this));
        this.f.add(new PlayIconStateEventSubscriber(this));
        this.f23955b = (VideoControlIcon) a(2131563319);
    }

    protected final void m25227a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        m25225a(this, this.h.l);
    }

    public static void m25225a(VideoPlayButtonPlugin videoPlayButtonPlugin, State state) {
        if (videoPlayButtonPlugin.f23956c) {
            switch (C34331.f23951a[state.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    videoPlayButtonPlugin.f23955b.setVisibility(0);
                    videoPlayButtonPlugin.f23955b.setLoading(videoPlayButtonPlugin.f23957d);
                    return;
                default:
                    if (state.isPlayingState()) {
                        videoPlayButtonPlugin.f23955b.setVisibility(8);
                        return;
                    }
                    videoPlayButtonPlugin.f23955b.setLoading(false);
                    videoPlayButtonPlugin.f23955b.setVisibility(0);
                    return;
            }
        }
    }
}
