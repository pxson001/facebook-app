package com.facebook.video.player.plugins;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.FbInjector;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.abtest.ExperimentsForVideoAbTestModule;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPLoadingSpinnerStateEvent;
import com.facebook.video.player.events.RVPLoadingSpinnerStateEvent.State;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RVPStreamDriedOutEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.widget.FacebookProgressCircleViewAnimated;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: post_processing */
public class LoadingSpinnerPlugin extends RichVideoPlayerPlugin {
    public final DelaySpinnerHandler f4375a;
    private final FrameLayout f4376b;
    public final FacebookProgressCircleViewAnimated f4377c;
    private final ProgressBar f4378d;
    private final ProgressPoller f4379l;
    private final boolean f4380m;
    public final long f4381n;
    public final int f4382o;
    public State f4383p;
    @Inject
    public QeAccessor f4384q;
    @Inject
    public DefaultAndroidThreadUtil f4385r;
    @Inject
    public MonotonicClock f4386s;

    /* compiled from: post_processing */
    public class ProgressPoller implements Runnable {
        public final /* synthetic */ LoadingSpinnerPlugin f4387a;
        public boolean f4388b = false;
        private long f4389c = 0;
        public long f4390d = 0;

        public ProgressPoller(LoadingSpinnerPlugin loadingSpinnerPlugin) {
            this.f4387a = loadingSpinnerPlugin;
        }

        public void run() {
            if (this.f4388b) {
                try {
                    if (this.f4387a.f14096h != null) {
                        long s = this.f4387a.f14096h.m5488s();
                        if (s == -1) {
                            LoadingSpinnerPlugin.m4912e(this.f4387a);
                        } else if (s > this.f4389c) {
                            LoadingSpinnerPlugin.m4913f(this.f4387a);
                            this.f4389c = s;
                            this.f4390d = this.f4387a.f4386s.now();
                            this.f4387a.f4377c.setProgress(this.f4389c);
                        } else if (this.f4387a.f4386s.now() >= this.f4390d + ((long) this.f4387a.f4382o)) {
                            LoadingSpinnerPlugin.m4912e(this.f4387a);
                        }
                    }
                    this.f4387a.f4385r.a(this, this.f4387a.f4381n);
                } catch (Throwable th) {
                    this.f4387a.f4385r.a(this, this.f4387a.f4381n);
                }
            }
        }

        public static void m4916b(ProgressPoller progressPoller) {
            progressPoller.f4388b = false;
            progressPoller.f4387a.f4377c.setProgress(0);
            progressPoller.f4389c = 0;
        }
    }

    /* compiled from: post_processing */
    class DelaySpinnerHandler extends Handler {
        WeakReference<LoadingSpinnerPlugin> f4413a;

        public DelaySpinnerHandler(LoadingSpinnerPlugin loadingSpinnerPlugin) {
            this.f4413a = new WeakReference(loadingSpinnerPlugin);
        }

        public void handleMessage(Message message) {
            LoadingSpinnerPlugin loadingSpinnerPlugin = (LoadingSpinnerPlugin) this.f4413a.get();
            if (loadingSpinnerPlugin != null && loadingSpinnerPlugin.f14096h != null) {
                boolean z;
                if (loadingSpinnerPlugin.f14096h.f5115l == PlaybackController.State.ATTEMPT_TO_PLAY) {
                    z = true;
                } else {
                    z = false;
                }
                LoadingSpinnerPlugin.m4909a(loadingSpinnerPlugin, z);
            }
        }
    }

    /* compiled from: post_processing */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ LoadingSpinnerPlugin f4414a;

        public PlayerStateChangedEventSubscriber(LoadingSpinnerPlugin loadingSpinnerPlugin) {
            this.f4414a = loadingSpinnerPlugin;
        }

        public final void m4926b(FbEvent fbEvent) {
            if (((RVPPlayerStateChangedEvent) fbEvent).f14079b == PlaybackController.State.ATTEMPT_TO_PLAY) {
                LoadingSpinnerPlugin.m4911d(this.f4414a);
                this.f4414a.f4375a.sendEmptyMessageDelayed(0, 1000);
                return;
            }
            LoadingSpinnerPlugin.m4909a(this.f4414a, false);
        }

        public final Class<RVPPlayerStateChangedEvent> m4925a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    /* compiled from: post_processing */
    class LoadingSpinnerStateEventSubscriber extends RichVideoPlayerEventSubscriber<RVPLoadingSpinnerStateEvent> {
        final /* synthetic */ LoadingSpinnerPlugin f4415a;

        public LoadingSpinnerStateEventSubscriber(LoadingSpinnerPlugin loadingSpinnerPlugin) {
            this.f4415a = loadingSpinnerPlugin;
        }

        public final void m4928b(FbEvent fbEvent) {
            RVPLoadingSpinnerStateEvent rVPLoadingSpinnerStateEvent = (RVPLoadingSpinnerStateEvent) fbEvent;
            this.f4415a.f4383p = rVPLoadingSpinnerStateEvent.f5098a;
            if (this.f4415a.f14096h != null && this.f4415a.f14096h.f5115l != PlaybackController.State.ATTEMPT_TO_PLAY) {
                LoadingSpinnerPlugin.m4909a(this.f4415a, false);
            } else if (!this.f4415a.f4375a.hasMessages(0)) {
                LoadingSpinnerPlugin.m4909a(this.f4415a, true);
            }
        }

        public final Class<RVPLoadingSpinnerStateEvent> m4927a() {
            return RVPLoadingSpinnerStateEvent.class;
        }
    }

    /* compiled from: post_processing */
    class StreamDriedOutEventSubscriber extends RichVideoPlayerEventSubscriber<RVPStreamDriedOutEvent> {
        final /* synthetic */ LoadingSpinnerPlugin f4416a;

        public StreamDriedOutEventSubscriber(LoadingSpinnerPlugin loadingSpinnerPlugin, RichVideoPlayerPlugin richVideoPlayerPlugin) {
            this.f4416a = loadingSpinnerPlugin;
            super(richVideoPlayerPlugin);
        }

        public final void m4930b(FbEvent fbEvent) {
            LoadingSpinnerPlugin.m4909a(this.f4416a, false);
        }

        public final Class<RVPStreamDriedOutEvent> m4929a() {
            return RVPStreamDriedOutEvent.class;
        }
    }

    public static void m4910a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        LoadingSpinnerPlugin loadingSpinnerPlugin = (LoadingSpinnerPlugin) obj;
        QeAccessor qeAccessor = (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector);
        DefaultAndroidThreadUtil b = DefaultAndroidThreadUtil.b(fbInjector);
        MonotonicClock monotonicClock = (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(fbInjector);
        loadingSpinnerPlugin.f4384q = qeAccessor;
        loadingSpinnerPlugin.f4385r = b;
        loadingSpinnerPlugin.f4386s = monotonicClock;
    }

    @DoNotStrip
    public LoadingSpinnerPlugin(Context context) {
        this(context, null);
    }

    private LoadingSpinnerPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private LoadingSpinnerPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4379l = new ProgressPoller(this);
        this.f4383p = State.DEFAULT;
        Class cls = LoadingSpinnerPlugin.class;
        m4910a((Object) this, getContext());
        setContentView(2130905115);
        this.f4376b = (FrameLayout) m14861a(2131563535);
        this.f4377c = (FacebookProgressCircleViewAnimated) m14861a(2131563536);
        this.f4378d = (ProgressBar) m14861a(2131563537);
        this.f4380m = this.f4384q.a(ExperimentsForVideoAbTestModule.ct, false);
        this.f4382o = this.f4384q.a(ExperimentsForVideoAbTestModule.cu, 5000);
        this.f4381n = this.f4384q.a(ExperimentsForVideoAbTestModule.cv, 100);
        if (this.f4380m) {
            this.f4378d.setVisibility(8);
        } else {
            this.f4377c.setVisibility(8);
        }
        this.f4375a = new DelaySpinnerHandler(this);
        this.f14094f.add(new PlayerStateChangedEventSubscriber(this));
        this.f14094f.add(new LoadingSpinnerStateEventSubscriber(this));
        this.f14094f.add(new StreamDriedOutEventSubscriber(this, this));
    }

    public final void mo376a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        boolean z2;
        if (z) {
            this.f4383p = State.DEFAULT;
        }
        if (this.f14096h.f5115l == PlaybackController.State.ATTEMPT_TO_PLAY) {
            z2 = true;
        } else {
            z2 = false;
        }
        m4909a(this, z2);
    }

    public final void mo378c() {
        m4911d(this);
        m4909a(this, false);
    }

    public static void m4911d(LoadingSpinnerPlugin loadingSpinnerPlugin) {
        loadingSpinnerPlugin.f4375a.removeMessages(0);
    }

    public static void m4909a(LoadingSpinnerPlugin loadingSpinnerPlugin, boolean z) {
        int i = 8;
        switch (loadingSpinnerPlugin.f4383p) {
            case DEFAULT:
                FrameLayout frameLayout = loadingSpinnerPlugin.f4376b;
                if (z) {
                    i = 0;
                }
                frameLayout.setVisibility(i);
                if (!loadingSpinnerPlugin.f4380m) {
                    return;
                }
                if (z) {
                    Runnable runnable = loadingSpinnerPlugin.f4379l;
                    runnable.f4388b = true;
                    runnable.f4390d = runnable.f4387a.f4386s.now();
                    runnable.f4387a.f4385r.b(runnable);
                    return;
                }
                ProgressPoller.m4916b(loadingSpinnerPlugin.f4379l);
                return;
            case HIDE:
                loadingSpinnerPlugin.f4376b.setVisibility(8);
                if (loadingSpinnerPlugin.f4380m) {
                    ProgressPoller.m4916b(loadingSpinnerPlugin.f4379l);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public static void m4912e(LoadingSpinnerPlugin loadingSpinnerPlugin) {
        loadingSpinnerPlugin.f4377c.setVisibility(8);
        loadingSpinnerPlugin.f4378d.setVisibility(0);
    }

    public static void m4913f(LoadingSpinnerPlugin loadingSpinnerPlugin) {
        loadingSpinnerPlugin.f4377c.setVisibility(0);
        loadingSpinnerPlugin.f4378d.setVisibility(8);
    }
}
