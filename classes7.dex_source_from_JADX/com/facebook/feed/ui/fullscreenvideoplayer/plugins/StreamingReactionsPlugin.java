package com.facebook.feed.ui.fullscreenvideoplayer.plugins;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.ViewPropertyAnimator;
import com.facebook.content.event.FbEvent;
import com.facebook.facecastdisplay.streamingreactions.StreamingReactionsView;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPCommercialBreakStateChangeEvent;
import com.facebook.video.player.events.RVPLiveReactionClickedEvent;
import com.facebook.video.player.events.RVPLiveVideoControlFadeEvent;
import com.facebook.video.player.events.RVPLiveVideoControlFadeEvent.State;
import com.facebook.video.player.events.RVPOrientationChangedEvent;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* compiled from: This thread doesn't have a MessageQueueThread registered to it! */
public class StreamingReactionsPlugin extends RichVideoPlayerPlugin {
    public final StreamingReactionsView f22156a;
    public final VideoTimeUpdateHandler f22157b;
    @Nullable
    public String f22158c;
    private boolean f22159d;
    public boolean f22160l;
    public boolean f22161m;
    public boolean f22162n;

    /* compiled from: This thread doesn't have a MessageQueueThread registered to it! */
    class C18921 extends AnimatorListenerAdapter {
        final /* synthetic */ StreamingReactionsPlugin f22147a;

        C18921(StreamingReactionsPlugin streamingReactionsPlugin) {
            this.f22147a = streamingReactionsPlugin;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f22147a.f22162n) {
                this.f22147a.f22156a.setVisibility(8);
            }
        }
    }

    /* compiled from: This thread doesn't have a MessageQueueThread registered to it! */
    /* synthetic */ class C18932 {
        static final /* synthetic */ int[] f22148a = new int[State.values().length];
        static final /* synthetic */ int[] f22149b = new int[RVPCommercialBreakStateChangeEvent.State.values().length];

        static {
            try {
                f22149b[RVPCommercialBreakStateChangeEvent.State.LIVE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22149b[RVPCommercialBreakStateChangeEvent.State.TRANSITION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f22149b[RVPCommercialBreakStateChangeEvent.State.WAIT_FOR_ADS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f22149b[RVPCommercialBreakStateChangeEvent.State.STATIC_COUNTDOWN.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f22149b[RVPCommercialBreakStateChangeEvent.State.VIDEO_AD.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f22148a[State.FADE_IN.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f22148a[State.FADE_OUT.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* compiled from: This thread doesn't have a MessageQueueThread registered to it! */
    class CommercialBreakStateChangeEventSubscriber extends RichVideoPlayerEventSubscriber<RVPCommercialBreakStateChangeEvent> {
        final /* synthetic */ StreamingReactionsPlugin f22150a;

        public CommercialBreakStateChangeEventSubscriber(StreamingReactionsPlugin streamingReactionsPlugin) {
            this.f22150a = streamingReactionsPlugin;
        }

        public final void m24801b(FbEvent fbEvent) {
            switch (C18932.f22149b[((RVPCommercialBreakStateChangeEvent) fbEvent).a.ordinal()]) {
                case 1:
                    this.f22150a.f22160l = false;
                    StreamingReactionsPlugin.m24812e(this.f22150a);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    this.f22150a.f22156a.m4150e();
                    this.f22150a.f22160l = true;
                    return;
                default:
                    return;
            }
        }

        public final Class<RVPCommercialBreakStateChangeEvent> m24800a() {
            return RVPCommercialBreakStateChangeEvent.class;
        }
    }

    /* compiled from: This thread doesn't have a MessageQueueThread registered to it! */
    class LiveReactionClickedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPLiveReactionClickedEvent> {
        final /* synthetic */ StreamingReactionsPlugin f22151a;

        public LiveReactionClickedEventSubscriber(StreamingReactionsPlugin streamingReactionsPlugin) {
            this.f22151a = streamingReactionsPlugin;
        }

        public final void m24803b(FbEvent fbEvent) {
            RVPLiveReactionClickedEvent rVPLiveReactionClickedEvent = (RVPLiveReactionClickedEvent) fbEvent;
            this.f22151a.f22156a.m4144a(rVPLiveReactionClickedEvent.a, rVPLiveReactionClickedEvent.b);
        }

        public final Class<RVPLiveReactionClickedEvent> m24802a() {
            return RVPLiveReactionClickedEvent.class;
        }
    }

    /* compiled from: This thread doesn't have a MessageQueueThread registered to it! */
    class LiveVideoControlFadeSubscriber extends RichVideoPlayerEventSubscriber<RVPLiveVideoControlFadeEvent> {
        final /* synthetic */ StreamingReactionsPlugin f22152a;

        public LiveVideoControlFadeSubscriber(StreamingReactionsPlugin streamingReactionsPlugin) {
            this.f22152a = streamingReactionsPlugin;
        }

        public final void m24805b(FbEvent fbEvent) {
            switch (C18932.f22148a[((RVPLiveVideoControlFadeEvent) fbEvent).a.ordinal()]) {
                case 1:
                    StreamingReactionsPlugin.m24810a(this.f22152a, false);
                    return;
                case 2:
                    StreamingReactionsPlugin.m24810a(this.f22152a, true);
                    return;
                default:
                    return;
            }
        }

        public final Class<RVPLiveVideoControlFadeEvent> m24804a() {
            return RVPLiveVideoControlFadeEvent.class;
        }
    }

    /* compiled from: This thread doesn't have a MessageQueueThread registered to it! */
    class OrientationChangeEventSubscriber extends RichVideoPlayerEventSubscriber<RVPOrientationChangedEvent> {
        final /* synthetic */ StreamingReactionsPlugin f22153a;

        public OrientationChangeEventSubscriber(StreamingReactionsPlugin streamingReactionsPlugin) {
            this.f22153a = streamingReactionsPlugin;
        }

        public final void m24807b(FbEvent fbEvent) {
            if (((RVPOrientationChangedEvent) fbEvent).a == 2) {
                this.f22153a.f22156a.setVisibility(8);
                this.f22153a.f22161m = true;
                this.f22153a.f22156a.m4150e();
                return;
            }
            this.f22153a.f22161m = false;
            StreamingReactionsPlugin.m24812e(this.f22153a);
        }

        public final Class<RVPOrientationChangedEvent> m24806a() {
            return RVPOrientationChangedEvent.class;
        }
    }

    /* compiled from: This thread doesn't have a MessageQueueThread registered to it! */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ StreamingReactionsPlugin f22154a;

        public PlayerStateChangedEventSubscriber(StreamingReactionsPlugin streamingReactionsPlugin) {
            this.f22154a = streamingReactionsPlugin;
        }

        public final void m24809b(FbEvent fbEvent) {
            RVPPlayerStateChangedEvent rVPPlayerStateChangedEvent = (RVPPlayerStateChangedEvent) fbEvent;
            if (this.f22154a.f22158c != null && this.f22154a.f22158c.equals(rVPPlayerStateChangedEvent.a)) {
                this.f22154a.f22157b.removeMessages(1);
                if (rVPPlayerStateChangedEvent.b == PlaybackController.State.PLAYBACK_COMPLETE) {
                    this.f22154a.f22156a.m4152g();
                } else if (rVPPlayerStateChangedEvent.b == PlaybackController.State.PLAYING) {
                    if (!this.f22154a.f22156a.m4153h()) {
                        this.f22154a.f22156a.m4148b();
                    }
                    StreamingReactionsPlugin.m24811d(this.f22154a);
                }
            }
        }

        public final Class<RVPPlayerStateChangedEvent> m24808a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    /* compiled from: This thread doesn't have a MessageQueueThread registered to it! */
    class VideoTimeUpdateHandler extends Handler {
        private final WeakReference<StreamingReactionsPlugin> f22155a;

        public VideoTimeUpdateHandler(StreamingReactionsPlugin streamingReactionsPlugin) {
            this.f22155a = new WeakReference(streamingReactionsPlugin);
        }

        public void handleMessage(Message message) {
            StreamingReactionsPlugin streamingReactionsPlugin = (StreamingReactionsPlugin) this.f22155a.get();
            if (streamingReactionsPlugin != null) {
                switch (message.what) {
                    case 1:
                        StreamingReactionsPlugin.m24811d(streamingReactionsPlugin);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public StreamingReactionsPlugin(Context context) {
        this(context, null);
    }

    private StreamingReactionsPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private StreamingReactionsPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130907284);
        this.f22156a = (StreamingReactionsView) a(2131561710);
        this.f22157b = new VideoTimeUpdateHandler(this);
        this.f.add(new LiveReactionClickedEventSubscriber(this));
        this.f.add(new LiveVideoControlFadeSubscriber(this));
        this.f.add(new CommercialBreakStateChangeEventSubscriber(this));
        this.f.add(new PlayerStateChangedEventSubscriber(this));
        this.f.add(new OrientationChangeEventSubscriber(this));
    }

    protected final void m24813a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        if (richVideoPlayerParams.b != null && richVideoPlayerParams.b.containsKey("GraphQLStoryProps") && (richVideoPlayerParams.b.get("GraphQLStoryProps") instanceof FeedProps)) {
            FeedProps feedProps = (FeedProps) richVideoPlayerParams.b.get("GraphQLStoryProps");
            if (!(feedProps == null || StoryAttachmentHelper.o((GraphQLStory) feedProps.a) == null || StoryAttachmentHelper.o((GraphQLStory) feedProps.a).r() == null)) {
                String z_;
                GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
                this.f22158c = StoryAttachmentHelper.o(graphQLStory).r().b();
                this.f22159d = richVideoPlayerParams.a.h;
                if (StoryAttachmentHelper.o(graphQLStory).r().I() != null) {
                    z_ = StoryAttachmentHelper.o(graphQLStory).r().I().z_();
                } else {
                    z_ = null;
                }
                this.f22156a.m4146a(this.f22158c, z_, this.f22159d);
                this.f22156a.m4148b();
            }
            if (getResources().getConfiguration().orientation == 2) {
                this.f22156a.setVisibility(8);
                this.f22156a.m4150e();
                this.f22161m = true;
            }
        }
    }

    protected final void m24814c() {
        this.f22157b.removeMessages(1);
        this.f22156a.m4152g();
        this.f22158c = null;
        this.f22160l = false;
        this.f22161m = false;
        this.f22162n = false;
    }

    public static void m24811d(StreamingReactionsPlugin streamingReactionsPlugin) {
        if (streamingReactionsPlugin.h != null) {
            streamingReactionsPlugin.f22156a.setVideoTime((int) ((streamingReactionsPlugin.f22159d ? (long) streamingReactionsPlugin.h.g() : (long) streamingReactionsPlugin.h.f()) / 1000));
        }
        streamingReactionsPlugin.f22157b.removeMessages(1);
        streamingReactionsPlugin.f22157b.sendEmptyMessageDelayed(1, 200);
    }

    public static void m24812e(StreamingReactionsPlugin streamingReactionsPlugin) {
        if (!streamingReactionsPlugin.f22160l && !streamingReactionsPlugin.f22161m) {
            streamingReactionsPlugin.f22156a.setVisibility(0);
            streamingReactionsPlugin.f22156a.m4151f();
        }
    }

    public static void m24810a(StreamingReactionsPlugin streamingReactionsPlugin, boolean z) {
        float f;
        AnimatorListener animatorListener;
        streamingReactionsPlugin.f22162n = z;
        if (streamingReactionsPlugin.f22158c != null && z) {
            m24812e(streamingReactionsPlugin);
        }
        ViewPropertyAnimator animate = streamingReactionsPlugin.f22156a.animate();
        if (z) {
            f = 1.0f;
        } else {
            f = 0.0f;
        }
        animate = animate.alpha(f).setDuration(200);
        if (z) {
            animatorListener = null;
        } else {
            animatorListener = new C18921(streamingReactionsPlugin);
        }
        animate.setListener(animatorListener).start();
    }
}
