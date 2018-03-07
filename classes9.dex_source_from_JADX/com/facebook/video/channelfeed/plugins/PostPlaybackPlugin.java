package com.facebook.video.channelfeed.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.facebook.content.event.FbEvent;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.channelfeed.ChannelFeedFullscreenPlayer.FullscreenPlayerEnvironment;
import com.facebook.video.player.CountdownRingContainer;
import com.facebook.video.player.CountdownRingContainer.CountdownRingContainerListener;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.environment.CanHandlePostPlaybackPluginRequests;
import com.facebook.video.player.events.RVPDialogEvent;
import com.facebook.video.player.events.RVPPlayIconStateEvent;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RVPSeekBarStateEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.facebook.video.player.plugins.RichVideoPlayerPluginWithEnv;

@DoNotStrip
/* compiled from: storyRenderLocation */
public class PostPlaybackPlugin<E extends CanHandlePostPlaybackPluginRequests> extends RichVideoPlayerPluginWithEnv<E> {
    public View f2732a;
    public View f2733b;
    public View f2734d;
    public CountdownRingContainer f2735l;
    public RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> f2736m;
    public RichVideoPlayerEventSubscriber<RVPDialogEvent> f2737n;

    /* compiled from: storyRenderLocation */
    public class C02491 implements OnClickListener {
        final /* synthetic */ PostPlaybackPlugin f2725a;

        public C02491(PostPlaybackPlugin postPlaybackPlugin) {
            this.f2725a = postPlaybackPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1147292299);
            this.f2725a.f2735l.b();
            PostPlaybackPlugin.m2623o(this.f2725a);
            Logger.a(2, EntryType.UI_INPUT_END, 829010310, a);
        }
    }

    /* compiled from: storyRenderLocation */
    public class C02502 implements OnClickListener {
        final /* synthetic */ PostPlaybackPlugin f2726a;

        public C02502(PostPlaybackPlugin postPlaybackPlugin) {
            this.f2726a = postPlaybackPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1745720307);
            this.f2726a.f2735l.b();
            PostPlaybackPlugin.m2621a(this.f2726a, EventTriggerType.BY_USER);
            Logger.a(2, EntryType.UI_INPUT_END, 1141810825, a);
        }
    }

    /* compiled from: storyRenderLocation */
    public class C02513 implements OnClickListener {
        final /* synthetic */ PostPlaybackPlugin f2727a;

        public C02513(PostPlaybackPlugin postPlaybackPlugin) {
            this.f2727a = postPlaybackPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -958455363);
            this.f2727a.f2735l.b();
            PostPlaybackPlugin.m2624p(this.f2727a);
            Logger.a(2, EntryType.UI_INPUT_END, 1530132707, a);
        }
    }

    /* compiled from: storyRenderLocation */
    public class C02524 implements CountdownRingContainerListener {
        final /* synthetic */ PostPlaybackPlugin f2728a;

        public C02524(PostPlaybackPlugin postPlaybackPlugin) {
            this.f2728a = postPlaybackPlugin;
        }

        public final void m2616a() {
            PostPlaybackPlugin.m2621a(this.f2728a, EventTriggerType.BY_AUTOPLAY);
        }
    }

    /* compiled from: storyRenderLocation */
    public class C02535 implements OnTouchListener {
        final /* synthetic */ PostPlaybackPlugin f2729a;

        public C02535(PostPlaybackPlugin postPlaybackPlugin) {
            this.f2729a = postPlaybackPlugin;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f2729a.f2735l.b();
            return false;
        }
    }

    /* compiled from: storyRenderLocation */
    public class C02546 extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        public final /* synthetic */ PostPlaybackPlugin f2730a;

        public C02546(PostPlaybackPlugin postPlaybackPlugin) {
            this.f2730a = postPlaybackPlugin;
        }

        public final void m2618b(FbEvent fbEvent) {
            if (((RVPPlayerStateChangedEvent) fbEvent).b == State.PLAYBACK_COMPLETE) {
                int i;
                this.f2730a.f2732a.setVisibility(0);
                int i2 = 0;
                View view = this.f2730a.f2733b;
                if (this.f2730a.c == null || !((FullscreenPlayerEnvironment) this.f2730a.c).m2225d()) {
                    i = 4;
                } else {
                    i = 0;
                }
                view.setVisibility(i);
                view = this.f2730a.f2734d;
                if (this.f2730a.c == null || !((FullscreenPlayerEnvironment) this.f2730a.c).m2224c()) {
                    i2 = 4;
                }
                view.setVisibility(i2);
                PostPlaybackPlugin postPlaybackPlugin = this.f2730a;
                if (postPlaybackPlugin.g != null) {
                    postPlaybackPlugin.g.a(new RVPPlayIconStateEvent(RVPPlayIconStateEvent.State.HIDE));
                }
                postPlaybackPlugin = this.f2730a;
                if (postPlaybackPlugin.g != null) {
                    postPlaybackPlugin.g.a(new RVPSeekBarStateEvent(RVPSeekBarStateEvent.State.ALWAYS_INVISIBLE));
                }
                if (this.f2730a.c != null && ((FullscreenPlayerEnvironment) this.f2730a.c).m2222b() && ((FullscreenPlayerEnvironment) this.f2730a.c).m2224c()) {
                    this.f2730a.f2735l.a();
                }
            }
        }

        public final Class<RVPPlayerStateChangedEvent> m2617a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    /* compiled from: storyRenderLocation */
    public class C02557 extends RichVideoPlayerEventSubscriber<RVPDialogEvent> {
        final /* synthetic */ PostPlaybackPlugin f2731a;

        public C02557(PostPlaybackPlugin postPlaybackPlugin) {
            this.f2731a = postPlaybackPlugin;
        }

        public final void m2620b(FbEvent fbEvent) {
            this.f2731a.f2735l.b();
        }

        public final Class<RVPDialogEvent> m2619a() {
            return RVPDialogEvent.class;
        }
    }

    @DoNotStrip
    public PostPlaybackPlugin(Context context) {
        this(context, null, 0);
    }

    private PostPlaybackPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130903544);
        this.f2732a = a(2131559223);
        this.f2733b = a(2131560282);
        this.f2734d = a(2131559872);
        this.f2735l = (CountdownRingContainer) a(2131560283);
        this.f2733b.setOnClickListener(new C02491(this));
        this.f2734d.setOnClickListener(new C02502(this));
        this.f2735l.setOnClickListener(new C02513(this));
        this.f2735l.l = 5000;
        this.f2735l.j = new C02524(this);
        this.f2732a.setOnTouchListener(new C02535(this));
        this.f2736m = new C02546(this);
        this.f2737n = new C02557(this);
    }

    private void m2622n() {
        if (this.g != null) {
            this.g.a(new RVPSeekBarStateEvent(RVPSeekBarStateEvent.State.DEFAULT));
        }
    }

    protected final void m2626a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        if (z) {
            m2625q();
            this.g.a(this.f2736m);
            this.g.a(this.f2737n);
        }
    }

    protected final void m2627c() {
        this.g.b(this.f2736m);
        this.g.b(this.f2737n);
        this.f2735l.b();
    }

    public static void m2621a(PostPlaybackPlugin postPlaybackPlugin, EventTriggerType eventTriggerType) {
        if (postPlaybackPlugin.c != null && ((FullscreenPlayerEnvironment) postPlaybackPlugin.c).m2224c()) {
            postPlaybackPlugin.m2625q();
            ((FullscreenPlayerEnvironment) postPlaybackPlugin.c).m2221b(eventTriggerType);
            postPlaybackPlugin.m2622n();
        }
    }

    public static void m2623o(PostPlaybackPlugin postPlaybackPlugin) {
        if (postPlaybackPlugin.c != null && ((FullscreenPlayerEnvironment) postPlaybackPlugin.c).m2225d()) {
            postPlaybackPlugin.m2625q();
            ((FullscreenPlayerEnvironment) postPlaybackPlugin.c).m2223c(EventTriggerType.BY_USER);
            postPlaybackPlugin.m2622n();
        }
    }

    public static void m2624p(PostPlaybackPlugin postPlaybackPlugin) {
        if (postPlaybackPlugin.c != null) {
            postPlaybackPlugin.m2625q();
            ((FullscreenPlayerEnvironment) postPlaybackPlugin.c).m2220a(EventTriggerType.BY_USER);
            postPlaybackPlugin.m2622n();
        }
    }

    private void m2625q() {
        this.f2732a.setVisibility(8);
    }
}
