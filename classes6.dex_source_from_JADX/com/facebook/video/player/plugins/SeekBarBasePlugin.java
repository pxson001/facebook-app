package com.facebook.video.player.plugins;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoResolution;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.Utils;
import com.facebook.video.player.environment.AnyPlayerEnvironment;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RVPRequestPausingEvent;
import com.facebook.video.player.events.RVPRequestPlayingEvent;
import com.facebook.video.player.events.RVPRequestSeekingEvent;
import com.facebook.video.player.events.RVPSeekBarStateEvent;
import com.facebook.video.player.events.RVPSeekBarStateEvent.State;
import com.facebook.video.player.events.RVPVideoResolutionChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

/* compiled from: composer_attach_movie_failure */
public abstract class SeekBarBasePlugin<E extends AnyPlayerEnvironment> extends RichVideoPlayerPluginWithEnv<E> {
    protected VideoPlayerParams f19333a;
    @VisibleForTesting
    public SeekBar f19334b;
    @Inject
    public VideoLoggingUtils f19335d;
    public int f19336l;
    private int f19337m;
    private final ProgressHandler f19338n;
    private int f19339o;
    private int f19340p;
    public FbTextView f19341q;
    public FbTextView f19342r;
    public Drawable f19343s;
    public Drawable f19344t;

    /* compiled from: composer_attach_movie_failure */
    class PlayerSeekBarStateSubscriber extends RichVideoPlayerEventSubscriber<RVPSeekBarStateEvent> {
        final /* synthetic */ SeekBarBasePlugin f19372a;

        public PlayerSeekBarStateSubscriber(SeekBarBasePlugin seekBarBasePlugin) {
            this.f19372a = seekBarBasePlugin;
        }

        public final void m28148b(FbEvent fbEvent) {
            if (((RVPSeekBarStateEvent) fbEvent).f19295a == State.ALWAYS_INVISIBLE) {
                this.f19372a.setSeekBarVisibility(4);
            } else {
                this.f19372a.setSeekBarVisibility(0);
            }
        }

        public final Class<RVPSeekBarStateEvent> m28147a() {
            return RVPSeekBarStateEvent.class;
        }
    }

    /* compiled from: composer_attach_movie_failure */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ SeekBarBasePlugin f19373a;

        public PlayerStateChangedEventSubscriber(SeekBarBasePlugin seekBarBasePlugin) {
            this.f19373a = seekBarBasePlugin;
        }

        public final void m28150b(FbEvent fbEvent) {
            RVPPlayerStateChangedEvent rVPPlayerStateChangedEvent = (RVPPlayerStateChangedEvent) fbEvent;
            if (this.f19373a.h != null) {
                if (rVPPlayerStateChangedEvent.b == PlaybackController.State.PLAYING) {
                    if (this.f19373a.f19336l <= 0) {
                        this.f19373a.f19336l = this.f19373a.h.h();
                    }
                    this.f19373a.mo1493d();
                } else if (rVPPlayerStateChangedEvent.b == PlaybackController.State.PAUSED) {
                    this.f19373a.m28118o();
                }
            }
        }

        public final Class<RVPPlayerStateChangedEvent> m28149a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    /* compiled from: composer_attach_movie_failure */
    class ProgressHandler extends Handler {
        private final WeakReference<SeekBarBasePlugin> f19374a;

        public ProgressHandler(SeekBarBasePlugin seekBarBasePlugin) {
            this.f19374a = new WeakReference(seekBarBasePlugin);
        }

        public void handleMessage(Message message) {
            SeekBarBasePlugin seekBarBasePlugin = (SeekBarBasePlugin) this.f19374a.get();
            if (seekBarBasePlugin != null) {
                switch (message.what) {
                    case 2:
                        seekBarBasePlugin.mo1493d();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* compiled from: composer_attach_movie_failure */
    public class SeekBarListener implements OnSeekBarChangeListener {
        final /* synthetic */ SeekBarBasePlugin f19375a;
        private boolean f19376b;
        private int f19377c;

        public SeekBarListener(SeekBarBasePlugin seekBarBasePlugin) {
            this.f19375a = seekBarBasePlugin;
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            this.f19375a.m28110c(i);
            if (z) {
                int max = (int) ((((long) this.f19375a.f19336l) * ((long) i)) / ((long) this.f19375a.f19334b.getMax()));
                if (this.f19375a.g != null) {
                    this.f19375a.g.a(new RVPRequestSeekingEvent(max, EventTriggerType.BY_USER));
                }
                this.f19375a.m28105a(max, this.f19375a.f19336l);
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            if (this.f19375a.h != null) {
                if (this.f19375a.f19344t != null) {
                    this.f19375a.f19334b.setThumb(this.f19375a.f19344t);
                }
                this.f19375a.m28115l();
                this.f19376b = this.f19375a.h.i();
                this.f19377c = this.f19375a.h.f();
                if (this.f19376b) {
                    this.f19375a.g.a(new RVPRequestPausingEvent(EventTriggerType.BY_SEEKBAR_CONTROLLER));
                }
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            if (this.f19375a.h != null) {
                if (this.f19375a.f19343s != null) {
                    this.f19375a.f19334b.setThumb(this.f19375a.f19343s);
                }
                if (this.f19375a.g != null) {
                    this.f19375a.m28116m();
                    int f = this.f19375a.h.f();
                    if (!(this.f19375a.f19333a.e == null || this.f19375a.f19333a.b == null)) {
                        this.f19375a.f19335d.a(this.f19375a.f19333a.e, this.f19375a.h.q.value, EventTriggerType.BY_USER.value, this.f19377c, f, this.f19375a.f19333a.b, this.f19375a.h.o(), this.f19375a.f19333a.f);
                    }
                    if (this.f19376b) {
                        this.f19375a.g.a(new RVPRequestPlayingEvent(EventTriggerType.BY_SEEKBAR_CONTROLLER));
                    }
                }
            }
        }
    }

    /* compiled from: composer_attach_movie_failure */
    class VideoResolutionChangedSubscriber extends RichVideoPlayerEventSubscriber<RVPVideoResolutionChangedEvent> {
        final /* synthetic */ SeekBarBasePlugin f19378a;

        public VideoResolutionChangedSubscriber(SeekBarBasePlugin seekBarBasePlugin) {
            this.f19378a = seekBarBasePlugin;
        }

        public final void m28152b(FbEvent fbEvent) {
            RVPVideoResolutionChangedEvent rVPVideoResolutionChangedEvent = (RVPVideoResolutionChangedEvent) fbEvent;
            if (this.f19378a.h != null) {
                this.f19378a.mo1487a(rVPVideoResolutionChangedEvent.a);
            }
        }

        public final Class<RVPVideoResolutionChangedEvent> m28151a() {
            return RVPVideoResolutionChangedEvent.class;
        }
    }

    public static void m28103a(Object obj, Context context) {
        ((SeekBarBasePlugin) obj).f19335d = VideoLoggingUtils.a(FbInjector.get(context));
    }

    public abstract int getActiveThumbResource();

    protected abstract int getContentView();

    public SeekBarBasePlugin(Context context) {
        this(context, null);
    }

    public SeekBarBasePlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SeekBarBasePlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19339o = -1;
        this.f19340p = -1;
        Class cls = SeekBarBasePlugin.class;
        m28103a((Object) this, getContext());
        this.f19338n = new ProgressHandler(this);
        setContentView(getContentView());
        m28112e();
        if (VERSION.SDK_INT >= 16 && getActiveThumbResource() != 0) {
            this.f19343s = this.f19334b.getThumb();
            this.f19344t = getResources().getDrawable(getActiveThumbResource());
        }
        m28113f();
        m28114k();
    }

    protected void m28112e() {
        this.f19341q = (FbTextView) a(2131562400);
        this.f19342r = (FbTextView) a(2131562402);
        this.f19334b = (SeekBar) a(2131562401);
    }

    protected void m28113f() {
        this.f.add(new PlayerStateChangedEventSubscriber(this));
        this.f.add(new PlayerSeekBarStateSubscriber(this));
        this.f.add(new VideoResolutionChangedSubscriber(this));
    }

    protected void m28114k() {
        this.f19334b.setOnSeekBarChangeListener(new SeekBarListener(this));
    }

    protected void mo1488a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        this.f19333a = richVideoPlayerParams.a;
        if (z && richVideoPlayerParams.b != null && richVideoPlayerParams.b.containsKey("SeekPositionMsKey")) {
            Object obj = richVideoPlayerParams.b.get("SeekPositionMsKey");
            if (obj instanceof Integer) {
                this.f19337m = ((Integer) obj).intValue();
            }
        }
        int i = richVideoPlayerParams.a.c;
        if (i > 0) {
            this.f19336l = i;
            String str = "-" + Utils.m28005a((long) this.f19336l);
            Rect rect = new Rect();
            this.f19342r.getPaint().getTextBounds(str, 0, str.length(), rect);
            int width = rect.width() + 5;
            this.f19341q.setMinWidth(width);
            this.f19342r.setMinWidth(width);
        }
        m28104a(true);
    }

    public void mo1489c() {
        this.f19338n.removeMessages(2);
        this.f19336l = 0;
        this.f19337m = 0;
    }

    protected void setSeekBarVisibility(int i) {
        this.f19341q.setVisibility(i);
        this.f19342r.setVisibility(i);
        this.f19334b.setVisibility(i);
    }

    protected void mo1487a(VideoResolution videoResolution) {
    }

    protected void m28110c(int i) {
    }

    protected void m28115l() {
    }

    protected void m28116m() {
    }

    private void m28104a(boolean z) {
        Preconditions.checkNotNull(this.h);
        int f = this.h.f();
        if (this.f19337m == 0 || f != 0) {
            this.f19337m = 0;
        } else {
            f = this.f19337m;
        }
        m28105a(f, this.f19336l);
        if (this.h.l() || z) {
            this.f19334b.setProgress(m28108b(this.f19336l, f));
            m28117n();
        }
    }

    protected void mo1493d() {
        m28104a(false);
    }

    protected final void m28117n() {
        this.f19338n.sendEmptyMessageDelayed(2, 42);
    }

    public final void m28118o() {
        mo1493d();
        this.f19338n.removeMessages(2);
    }

    public void m28105a(int i, int i2) {
        int i3 = i / 1000;
        int i4 = (i2 / 1000) - i3;
        if (i3 != this.f19339o || i4 != this.f19340p) {
            this.f19339o = i3;
            this.f19340p = i4;
            CharSequence a = Utils.m28005a((long) (i3 * 1000));
            CharSequence charSequence = "-" + Utils.m28005a((long) (i4 * 1000));
            this.f19341q.setText(a);
            this.f19342r.setText(charSequence);
        }
    }

    protected final int m28108b(int i, int i2) {
        if (i == 0) {
            return 0;
        }
        int max = this.f19334b.getMax();
        return Math.min(Math.max(0, (int) ((((long) i2) * ((long) max)) / ((long) i))), max);
    }
}
