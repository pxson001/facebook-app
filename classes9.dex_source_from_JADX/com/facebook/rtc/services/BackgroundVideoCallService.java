package com.facebook.rtc.services;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.TransitionDrawable;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.text.Spannable.Factory;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import com.facebook.base.service.FbService;
import com.facebook.chatheads.view.ChatHeadSimpleFullView;
import com.facebook.chatheads.view.ChatHeadSimpleFullWindow;
import com.facebook.chatheads.view.ChatHeadTextBubbleView;
import com.facebook.chatheads.view.ChatHeadTextBubbleView.Origin;
import com.facebook.chatheads.view.ChatHeadTextBubbleWindow;
import com.facebook.chatheads.view.ChatHeadTextBubbleWindowProvider;
import com.facebook.chatheads.view.FloatingChatWindow;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.chatheads.ipc.ChatHeadsBroadcaster;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rtc.activities.WebrtcIncallActivity;
import com.facebook.rtc.fbwebrtc.WebrtcPrefKeys;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler.LocalVideoState;
import com.facebook.rtc.fbwebrtc.abtests.ExperimentsForRtcModule;
import com.facebook.rtc.interfaces.DefaultRtcUiCallback;
import com.facebook.rtc.logging.WebrtcLoggingHandler;
import com.facebook.rtc.opengl.RenderHandler;
import com.facebook.rtc.opengl.RenderThread;
import com.facebook.rtc.views.RtcFloatingSelfView.SelfViewFrameChecker;
import com.facebook.rtc.views.RtcVideoChatHeadView;
import com.facebook.rtc.views.RtcVideoChatHeadView.C23818;
import com.facebook.rtc.views.RtcVideoChatHeadView.RtcVideoChatHeadViewActionHandler;
import com.facebook.rtc.views.RtcVideoChatHeadView.ViewType;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.webrtc.IWebrtcUiInterface.EndCallReason;
import com.facebook.widget.CustomViewUtils;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import org.webrtc.videoengine.VideoCaptureAndroid;
import org.webrtc.videoengine.VideoCaptureAndroid.CaptureErrorCallback;

@TargetApi(15)
/* compiled from: application/smil */
public class BackgroundVideoCallService extends FbService implements SurfaceTextureListener, RtcVideoChatHeadViewActionHandler, CaptureErrorCallback {
    public static final Class<?> f19960s = BackgroundVideoCallService.class;
    private static final SpringConfig f19961u = SpringConfig.a(40.0d, 7.0d);
    public int f19962A;
    public float f19963B;
    private int f19964C;
    public Spring f19965D;
    public Spring f19966E;
    public int f19967F;
    public int f19968G;
    public int f19969H;
    public int f19970I;
    public int f19971J;
    public int f19972K;
    public int f19973L;
    public int f19974M;
    public int f19975N;
    public int f19976O;
    public boolean f19977P;
    public boolean f19978Q = false;
    private DynamicSecureBroadcastReceiver f19979R;
    public RenderThread f19980S = null;
    public boolean f19981T;
    public ChatHeadTextBubbleWindow f19982U;
    public boolean f19983V;
    public boolean f19984W;
    private long f19985X = -1;
    private boolean f19986Y = false;
    private boolean f19987Z = true;
    final String f19988a = "homekey";
    private boolean aa = false;
    public LinearLayout ab = null;
    public boolean ac = false;
    private boolean ad = false;
    private SimpleSpringListener ae = null;
    private long af = 0;
    private long ag = 0;
    private long ah = -1;
    public long ai = -1;
    private int aj = 0;
    @Inject
    public WindowManager f19989b;
    @Inject
    SpringSystem f19990c;
    @Inject
    public Context f19991d;
    @Inject
    SecureContextHelper f19992e;
    @Inject
    public ChatHeadTextBubbleWindowProvider f19993f;
    @Inject
    @ForUiThread
    Executor f19994g;
    @Inject
    FbSharedPreferences f19995h;
    @Inject
    ChatHeadSimpleFullWindow f19996i;
    @Inject
    WebrtcLoggingHandler f19997j;
    @Inject
    QeAccessor f19998k;
    @Inject
    @ForUiThread
    ScheduledExecutorService f19999l;
    @Inject
    ChatHeadsBroadcaster f20000m;
    @Inject
    MonotonicClock f20001n;
    ScheduledFuture f20002o;
    ScheduledFuture f20003p;
    ScheduledFuture f20004q;
    public ChatHeadSimpleFullWindow f20005r = null;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<WebrtcUiHandler> f20006t = UltralightRuntime.b;
    public DefaultRtcUiCallback f20007v;
    public RtcVideoChatHeadView f20008w;
    private final IBinder f20009x = new RtcCallBinder(this);
    public LayoutParams f20010y;
    public int f20011z;

    /* compiled from: application/smil */
    class C23341 implements Runnable {
        final /* synthetic */ BackgroundVideoCallService f19937a;

        C23341(BackgroundVideoCallService backgroundVideoCallService) {
            this.f19937a = backgroundVideoCallService;
        }

        public void run() {
            if (BackgroundVideoCallService.m19647G(this.f19937a)) {
                BackgroundVideoCallService.m19655O(this.f19937a);
                ((WebrtcUiHandler) this.f19937a.f20006t.get()).ao = true;
                BackgroundVideoCallService.m19658T(this.f19937a);
            }
        }
    }

    /* compiled from: application/smil */
    class C23372 extends DefaultRtcUiCallback {
        final /* synthetic */ BackgroundVideoCallService f19940a;

        /* compiled from: application/smil */
        class C23351 implements Runnable {
            final /* synthetic */ C23372 f19938a;

            C23351(C23372 c23372) {
                this.f19938a = c23372;
            }

            public void run() {
                if (this.f19938a.f19940a.f20008w != null && this.f19938a.f19940a.f19981T) {
                    RtcVideoChatHeadView rtcVideoChatHeadView = this.f19938a.f19940a.f20008w;
                    if (((WebrtcUiHandler) this.f19938a.f19940a.f20006t.get()).bS && rtcVideoChatHeadView.f20221j != null && rtcVideoChatHeadView.f20223l == null) {
                        TransitionDrawable transitionDrawable = (TransitionDrawable) rtcVideoChatHeadView.f20221j.getDrawable();
                        transitionDrawable.setCrossFadeEnabled(true);
                        transitionDrawable.startTransition(500);
                        rtcVideoChatHeadView.f20223l = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
                        rtcVideoChatHeadView.f20223l.setDuration(250);
                        rtcVideoChatHeadView.f20223l.setStartOffset(1500);
                        rtcVideoChatHeadView.f20223l.setAnimationListener(new C23818(rtcVideoChatHeadView));
                        rtcVideoChatHeadView.f20223l.setFillAfter(true);
                        rtcVideoChatHeadView.f20223l.setFillBefore(true);
                        rtcVideoChatHeadView.f20221j.startAnimation(rtcVideoChatHeadView.f20223l);
                    }
                }
            }
        }

        /* compiled from: application/smil */
        class C23362 implements Runnable {
            final /* synthetic */ C23372 f19939a;

            C23362(C23372 c23372) {
                this.f19939a = c23372;
            }

            public void run() {
                if (this.f19939a.f19940a.f20008w != null && this.f19939a.f19940a.f19981T) {
                    RtcVideoChatHeadView rtcVideoChatHeadView = this.f19939a.f19940a.f20008w;
                    rtcVideoChatHeadView.f20214c.setCaptureVideoPortraitRatio(((WebrtcUiHandler) this.f19939a.f19940a.f20006t.get()).m19448a(0.0f));
                    BackgroundVideoCallService.m19659U(this.f19939a.f19940a);
                }
            }
        }

        C23372(BackgroundVideoCallService backgroundVideoCallService) {
            this.f19940a = backgroundVideoCallService;
        }

        public final void mo793i() {
            if (!this.f19940a.f19981T) {
                return;
            }
            if (((WebrtcUiHandler) this.f19940a.f20006t.get()).az() || ((WebrtcUiHandler) this.f19940a.f20006t.get()).aB()) {
                this.f19940a.f20008w.m19845a(this.f19940a.getString(2131232003));
            } else if (BackgroundVideoCallService.m19648H(this.f19940a)) {
                this.f19940a.f20008w.m19845a(null);
            } else if (((WebrtcUiHandler) this.f19940a.f20006t.get()).m19442S()) {
                this.f19940a.f20008w.m19845a(((WebrtcUiHandler) this.f19940a.f20006t.get()).m19438O());
            }
        }

        public final boolean mo781a(long j, boolean z, boolean z2, boolean z3) {
            if (j != 0 && z3) {
                this.f19940a.f19997j.h();
            }
            return true;
        }

        public final void mo786c(boolean z) {
            if (this.f19940a.f19981T) {
                if (z) {
                    BackgroundVideoCallService.m19652L(this.f19940a);
                    if (BackgroundVideoCallService.m19647G(this.f19940a)) {
                        BackgroundVideoCallService.m19654N(this.f19940a);
                    }
                } else {
                    BackgroundVideoCallService.m19655O(this.f19940a);
                }
                BackgroundVideoCallService.m19658T(this.f19940a);
            }
        }

        public final void mo797m() {
            if (this.f19940a.f19981T) {
                if (((WebrtcUiHandler) this.f19940a.f20006t.get()).as()) {
                    if (BackgroundVideoCallService.m19646F(this.f19940a)) {
                        BackgroundVideoCallService.m19652L(this.f19940a);
                    }
                    if (BackgroundVideoCallService.m19647G(this.f19940a)) {
                        BackgroundVideoCallService.m19654N(this.f19940a);
                    }
                }
                BackgroundVideoCallService.m19658T(this.f19940a);
            }
        }

        public final void mo779a(boolean z) {
            if (z && this.f19940a.f19981T) {
                if (BackgroundVideoCallService.m19646F(this.f19940a)) {
                    BackgroundVideoCallService.m19652L(this.f19940a);
                }
                if (BackgroundVideoCallService.m19647G(this.f19940a)) {
                    BackgroundVideoCallService.m19654N(this.f19940a);
                }
                BackgroundVideoCallService.m19658T(this.f19940a);
                if (this.f19940a.ai < 0) {
                    this.f19940a.ai = this.f19940a.f20001n.now();
                }
            }
        }

        public final void mo795k() {
            if (((WebrtcUiHandler) this.f19940a.f20006t.get()).as() && this.f19940a.f19981T) {
                if (this.f19940a.f19981T) {
                    BackgroundVideoCallService.m19652L(this.f19940a);
                }
                BackgroundVideoCallService.m19658T(this.f19940a);
            }
        }

        public final void mo796l() {
            if (this.f19940a.f19981T) {
                BackgroundVideoCallService.m19653M(this.f19940a);
                BackgroundVideoCallService.m19658T(this.f19940a);
                BackgroundVideoCallService.m19675d(this.f19940a, this.f19940a.ac);
            }
        }

        public final void mo820t() {
            ExecutorDetour.a(this.f19940a.f19994g, new C23351(this), 2058865123);
        }

        public final void mo783b(int i, int i2) {
            ExecutorDetour.a(this.f19940a.f19994g, new C23362(this), -1957981308);
        }

        public final void mo777a(int i, int i2) {
            float f;
            BackgroundVideoCallService backgroundVideoCallService = this.f19940a;
            if (i > 0) {
                f = ((float) i2) / ((float) i);
            } else {
                f = 1.6666666f;
            }
            backgroundVideoCallService.f19963B = f;
            BackgroundVideoCallService.m19668a(this.f19940a, i, i2, this.f19940a.ac);
            Class cls = BackgroundVideoCallService.f19960s;
            Object[] objArr = new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.f19940a.f20011z), Integer.valueOf(this.f19940a.f19962A), Float.valueOf(this.f19940a.f19963B)};
            if (((WebrtcUiHandler) this.f19940a.f20006t.get()).bQ) {
                BackgroundVideoCallService.m19677e(this.f19940a, this.f19940a.f20008w.m19854h());
                return;
            }
            BackgroundVideoCallService.m19659U(this.f19940a);
            BackgroundVideoCallService.ae(this.f19940a);
        }

        public final int mo802r() {
            return 2;
        }
    }

    /* compiled from: application/smil */
    class C23383 implements SelfViewFrameChecker {
        final /* synthetic */ BackgroundVideoCallService f19941a;

        C23383(BackgroundVideoCallService backgroundVideoCallService) {
            this.f19941a = backgroundVideoCallService;
        }

        public final long mo821a() {
            return this.f19941a.f19980S.f19896s;
        }
    }

    /* compiled from: application/smil */
    public class C23404 {
        final /* synthetic */ BackgroundVideoCallService f19944a;

        C23404(BackgroundVideoCallService backgroundVideoCallService) {
            this.f19944a = backgroundVideoCallService;
        }

        public final void m19632a(final SurfaceTexture surfaceTexture) {
            ExecutorDetour.a(this.f19944a.f19994g, new Runnable(this) {
                final /* synthetic */ C23404 f19943b;

                public void run() {
                    VideoCaptureAndroid.m21574a(surfaceTexture);
                    ((WebrtcUiHandler) this.f19943b.f19944a.f20006t.get()).m19454a(LocalVideoState.STARTED);
                    BackgroundVideoCallService.m19658T(this.f19943b.f19944a);
                }
            }, 1102334343);
        }
    }

    /* compiled from: application/smil */
    class C23415 implements Runnable {
        final /* synthetic */ BackgroundVideoCallService f19945a;

        C23415(BackgroundVideoCallService backgroundVideoCallService) {
            this.f19945a = backgroundVideoCallService;
        }

        public void run() {
            if (!this.f19945a.f19981T) {
                Class cls = BackgroundVideoCallService.f19960s;
                BackgroundVideoCallService.m19653M(this.f19945a);
                BackgroundVideoCallService.m19655O(this.f19945a);
            }
            this.f19945a.f20003p = null;
        }
    }

    /* compiled from: application/smil */
    class C23426 implements ActionReceiver {
        final /* synthetic */ BackgroundVideoCallService f19946a;

        C23426(BackgroundVideoCallService backgroundVideoCallService) {
            this.f19946a = backgroundVideoCallService;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1990344711);
            BackgroundVideoCallService.m19682z(this.f19946a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -629388988, a);
        }
    }

    /* compiled from: application/smil */
    class C23437 implements ActionReceiver {
        final /* synthetic */ BackgroundVideoCallService f19947a;

        C23437(BackgroundVideoCallService backgroundVideoCallService) {
            this.f19947a = backgroundVideoCallService;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1560466);
            BackgroundVideoCallService.m19671b(this.f19947a, intent.getStringExtra("reason"));
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1817220264, a);
        }
    }

    /* compiled from: application/smil */
    class C23448 implements OnGlobalLayoutListener {
        final /* synthetic */ BackgroundVideoCallService f19948a;

        C23448(BackgroundVideoCallService backgroundVideoCallService) {
            this.f19948a = backgroundVideoCallService;
        }

        public void onGlobalLayout() {
            BackgroundVideoCallService.m19658T(this.f19948a);
            CustomViewUtils.a(this.f19948a.f20008w, this);
        }
    }

    /* compiled from: application/smil */
    public class C23459 {
        public final /* synthetic */ BackgroundVideoCallService f19949a;

        C23459(BackgroundVideoCallService backgroundVideoCallService) {
            this.f19949a = backgroundVideoCallService;
        }
    }

    /* compiled from: application/smil */
    class DragTouchListener implements OnTouchListener {
        final /* synthetic */ BackgroundVideoCallService f19950a;
        private GestureDetector f19951b;

        public DragTouchListener(BackgroundVideoCallService backgroundVideoCallService) {
            this.f19950a = backgroundVideoCallService;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f19950a.f19984W) {
                return false;
            }
            if (motionEvent.getAction() == 0) {
                this.f19950a.f20008w.setPeerViewFreeze(true);
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                this.f19950a.f20008w.setPeerViewFreeze(false);
            }
            if (motionEvent.getAction() == 0) {
                this.f19951b = new GestureDetector(this.f19950a.f19991d, new GestureDetectorListener(this.f19950a));
                this.f19951b.setIsLongpressEnabled(false);
                BackgroundVideoCallService.ad(this.f19950a);
                if (this.f19950a.f20005r != null) {
                    this.f19950a.f20005r.lI_().m6007b();
                }
            }
            if (this.f19950a.ac) {
                if (this.f19950a.f20008w.m19854h()) {
                    this.f19950a.f20008w.m19848a(true, false, BackgroundVideoCallService.m19651K(this.f19950a), false);
                }
                BackgroundVideoCallService.m19673c(this.f19950a, true);
            }
            float rawX = motionEvent.getRawX() - motionEvent.getX();
            float rawY = motionEvent.getRawY() - motionEvent.getY();
            motionEvent.offsetLocation(rawX, rawY);
            boolean z = this.f19951b != null && this.f19951b.onTouchEvent(motionEvent);
            motionEvent.offsetLocation(-rawX, -rawY);
            if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && !z) {
                if (this.f19950a.f20005r != null) {
                    this.f19950a.f20005r.lI_().m6004a();
                    if (this.f19950a.f20005r.lI_().m6008b(((float) this.f19950a.f19971J) + ((float) (BackgroundVideoCallService.m19656P(this.f19950a) / 2)), ((float) this.f19950a.f19972K) + ((float) (BackgroundVideoCallService.m19657Q(this.f19950a) / 2)))) {
                        ((WebrtcUiHandler) this.f19950a.f20006t.get()).m19458a(EndCallReason.CallEndHangupCall);
                        ((WebrtcUiHandler) this.f19950a.f20006t.get()).m19482q();
                        this.f19950a.f19997j.logCallAction(((WebrtcUiHandler) this.f19950a.f20006t.get()).ad, ((WebrtcUiHandler) this.f19950a.f20006t.get()).ai, "end_call_in_background", "drag");
                    } else {
                        BackgroundVideoCallService.ae(this.f19950a);
                    }
                } else {
                    BackgroundVideoCallService.ae(this.f19950a);
                }
            }
            return z;
        }
    }

    /* compiled from: application/smil */
    class GestureDetectorListener extends SimpleOnGestureListener {
        final /* synthetic */ BackgroundVideoCallService f19954a;

        /* compiled from: application/smil */
        class C23461 extends SimpleSpringListener {
            final /* synthetic */ GestureDetectorListener f19952a;
            private double f19953b = -1.0d;

            C23461(GestureDetectorListener gestureDetectorListener) {
                this.f19952a = gestureDetectorListener;
            }

            public final void m19633a(Spring spring) {
                if (this.f19953b < 0.0d || this.f19953b > spring.e()) {
                    this.f19953b = spring.e();
                    return;
                }
                this.f19952a.f19954a.f19966E.m();
                ((WebrtcUiHandler) this.f19952a.f19954a.f20006t.get()).m19458a(EndCallReason.CallEndHangupCall);
                ((WebrtcUiHandler) this.f19952a.f19954a.f20006t.get()).m19482q();
                this.f19952a.f19954a.f19997j.logCallAction(((WebrtcUiHandler) this.f19952a.f19954a.f20006t.get()).ad, ((WebrtcUiHandler) this.f19952a.f19954a.f20006t.get()).ai, "end_call_in_background", "fling");
            }
        }

        public GestureDetectorListener(BackgroundVideoCallService backgroundVideoCallService) {
            this.f19954a = backgroundVideoCallService;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            this.f19954a.f19967F = (int) motionEvent2.getX();
            this.f19954a.f19968G = (int) motionEvent2.getY();
            this.f19954a.f19971J = this.f19954a.f19967F - this.f19954a.f19969H;
            this.f19954a.f19972K = this.f19954a.f19968G - this.f19954a.f19970I;
            this.f19954a.f19972K = this.f19954a.m19665a(this.f19954a.f19972K);
            float P = ((float) this.f19954a.f19971J) + ((float) (BackgroundVideoCallService.m19656P(this.f19954a) / 2));
            float Q = ((float) this.f19954a.f19972K) + ((float) (BackgroundVideoCallService.m19657Q(this.f19954a) / 2));
            if (this.f19954a.f20005r != null) {
                this.f19954a.f20005r.lI_().m6005a(P, Q);
            }
            this.f19954a.f19977P = true;
            this.f19954a.f19983V = true;
            BackgroundVideoCallService.m19663Y(this.f19954a);
            return false;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return this.f19954a.m19701s();
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            int P = this.f19954a.f19974M - BackgroundVideoCallService.m19656P(this.f19954a);
            int Q = (this.f19954a.f19973L - BackgroundVideoCallService.m19657Q(this.f19954a)) - this.f19954a.f19975N;
            double sqrt = Math.sqrt((double) ((f * f) + (f2 * f2)));
            double sqrt2 = Math.sqrt((double) (f * f));
            if (Math.sqrt((double) (f2 * f2)) < 3000.0d && sqrt2 < 3000.0d) {
                return false;
            }
            float f3;
            int i;
            int i2;
            if (sqrt2 < 1000.0d) {
                f = 0.0f;
            }
            float f4 = 0.0f;
            if (f > 0.0f) {
                f4 = P - this.f19954a.f19971J > 0 ? ((float) (P - this.f19954a.f19971J)) / f : 0.0f;
            } else if (f < 0.0f) {
                f4 = ((float) this.f19954a.f19971J) / (-1.0f * f);
            }
            if (f2 > 0.0f) {
                f3 = ((float) (Q - this.f19954a.f19972K)) / f2;
            } else if (f2 < 0.0f) {
                f3 = ((float) this.f19954a.f19972K) / (-1.0f * f2);
            } else {
                f3 = 0.0f;
            }
            if (f3 > f4) {
                if (f4 > 0.0f) {
                    f3 = f4;
                }
                i = (int) ((f3 * f2) + ((float) this.f19954a.f19972K));
                i2 = f > 0.0f ? P : 0;
            } else {
                i = f2 > 0.0f ? Q : this.f19954a.f19975N - this.f19954a.f19976O;
                i2 = f > 0.0f ? P : 0;
            }
            if (f == 0.0f && this.f19954a.f19965D != null) {
                i2 = (int) this.f19954a.f19965D.d();
            }
            if (this.f19954a.f19971J < 0 || this.f19954a.f19971J >= P) {
                i = this.f19954a.f19972K;
            }
            if (this.f19954a.f19972K < this.f19954a.f19975N || this.f19954a.f19972K >= Q) {
                i2 = this.f19954a.f19971J;
            }
            Q = Math.min(this.f19954a.m19665a(i), Q);
            if (i2 > P / 2) {
                i = P - this.f19954a.f20008w.getRightMarginInPixels();
            } else {
                i = this.f19954a.f20008w.getLeftMarginInPixels();
            }
            i2 = sqrt >= 3000.0d ? 1 : 0;
            int i3 = (this.f19954a.f20005r == null || !this.f19954a.f20005r.lI_().m6006a(motionEvent2.getRawX(), motionEvent2.getRawY(), f, f2)) ? 0 : 1;
            if (i3 & i2) {
                i2 = P / 2;
                i = (int) (this.f19954a.f20005r.lI_().getRestingCloseBaubleCenterYInScreen() - ((float) BackgroundVideoCallService.m19657Q(this.f19954a)));
                this.f19954a.f20008w.m19850d();
                if (this.f19954a.f19966E != null) {
                    this.f19954a.f19966E.a(new C23461(this));
                }
            } else {
                if (this.f19954a.f20005r != null) {
                    this.f19954a.f20005r.lI_().m6004a();
                }
                i2 = i;
                i = Q;
            }
            this.f19954a.f19977P = false;
            Class cls = BackgroundVideoCallService.f19960s;
            Object[] objArr = new Object[]{Integer.valueOf(this.f19954a.f19971J), Integer.valueOf(this.f19954a.f19972K), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf((int) f), Integer.valueOf((int) f2), Boolean.valueOf(r4)};
            if (this.f19954a.f19965D != null) {
                this.f19954a.f19965D.a((double) this.f19954a.f19971J);
                this.f19954a.f19965D.c((double) f);
                this.f19954a.f19965D.b((double) i2);
            }
            if (this.f19954a.f19966E != null) {
                this.f19954a.f19966E.a((double) this.f19954a.f19972K);
                this.f19954a.f19966E.c((double) f2);
                this.f19954a.f19966E.b((double) i);
            }
            return true;
        }

        public boolean onDown(MotionEvent motionEvent) {
            this.f19954a.f19967F = (int) motionEvent.getX();
            this.f19954a.f19968G = (int) motionEvent.getY();
            this.f19954a.f19969H = this.f19954a.f19967F - this.f19954a.f19971J;
            this.f19954a.f19970I = this.f19954a.f19968G - this.f19954a.f19972K;
            return true;
        }
    }

    /* compiled from: application/smil */
    class MySpringListener extends SimpleSpringListener {
        final /* synthetic */ BackgroundVideoCallService f19955a;

        public MySpringListener(BackgroundVideoCallService backgroundVideoCallService) {
            this.f19955a = backgroundVideoCallService;
        }

        public final void m19634a(Spring spring) {
            if (!this.f19955a.f19977P) {
                if (!(this.f19955a.f19965D == null || this.f19955a.f19966E == null)) {
                    if (this.f19955a.f19965D.equals(spring)) {
                        this.f19955a.f19971J = (int) this.f19955a.f19965D.d();
                    } else {
                        this.f19955a.f19972K = (int) this.f19955a.f19966E.d();
                    }
                }
                BackgroundVideoCallService.m19663Y(this.f19955a);
            }
        }

        public final void m19635b(Spring spring) {
            if (this.f19955a.f19978Q) {
                this.f19955a.f19978Q = false;
                BackgroundVideoCallService.ac(this.f19955a);
            }
        }
    }

    /* compiled from: application/smil */
    public class RtcCallBinder extends Binder {
        public final /* synthetic */ BackgroundVideoCallService f19956a;

        public RtcCallBinder(BackgroundVideoCallService backgroundVideoCallService) {
            this.f19956a = backgroundVideoCallService;
        }
    }

    /* compiled from: application/smil */
    public class VideoChatHeadResizeAnimation extends Animation {
        final Point f19957a;
        final Point f19958b;
        View f19959c;

        public VideoChatHeadResizeAnimation(View view, Point point, Point point2) {
            this.f19959c = view;
            this.f19957a = point;
            this.f19958b = point2;
        }

        protected void applyTransformation(float f, Transformation transformation) {
            int i = (int) (((float) this.f19957a.y) + (((float) (this.f19958b.y - this.f19957a.y)) * f));
            this.f19959c.getLayoutParams().width = (int) (((float) this.f19957a.x) + (((float) (this.f19958b.x - this.f19957a.x)) * f));
            this.f19959c.getLayoutParams().height = i;
            this.f19959c.requestLayout();
        }

        public boolean willChangeBounds() {
            return true;
        }
    }

    public static void m19669a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((BackgroundVideoCallService) obj).m19667a(IdBasedLazy.a(fbInjector, 10375), WindowManagerMethodAutoProvider.b(fbInjector), SpringSystem.b(fbInjector), (Context) fbInjector.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), (ChatHeadTextBubbleWindowProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ChatHeadTextBubbleWindowProvider.class), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), ChatHeadSimpleFullWindow.m6014b(fbInjector), WebrtcLoggingHandler.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), ChatHeadsBroadcaster.a(fbInjector), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(fbInjector));
    }

    private void m19667a(com.facebook.inject.Lazy<WebrtcUiHandler> lazy, WindowManager windowManager, SpringSystem springSystem, Context context, SecureContextHelper secureContextHelper, ChatHeadTextBubbleWindowProvider chatHeadTextBubbleWindowProvider, Executor executor, FbSharedPreferences fbSharedPreferences, ChatHeadSimpleFullWindow chatHeadSimpleFullWindow, WebrtcLoggingHandler webrtcLoggingHandler, QeAccessor qeAccessor, ScheduledExecutorService scheduledExecutorService, ChatHeadsBroadcaster chatHeadsBroadcaster, MonotonicClock monotonicClock) {
        this.f20006t = lazy;
        this.f19989b = windowManager;
        this.f19990c = springSystem;
        this.f19991d = context;
        this.f19992e = secureContextHelper;
        this.f19993f = chatHeadTextBubbleWindowProvider;
        this.f19994g = executor;
        this.f19995h = fbSharedPreferences;
        this.f19996i = chatHeadSimpleFullWindow;
        this.f19997j = webrtcLoggingHandler;
        this.f19998k = qeAccessor;
        this.f19999l = scheduledExecutorService;
        this.f20000m = chatHeadsBroadcaster;
        this.f20001n = monotonicClock;
    }

    public final void mo823c() {
        if (((WebrtcUiHandler) this.f20006t.get()).m19478k() && !((WebrtcUiHandler) this.f20006t.get()).aB && !((WebrtcUiHandler) this.f20006t.get()).bL) {
            ((WebrtcUiHandler) this.f20006t.get()).m19468b(true);
        } else if (!((WebrtcUiHandler) this.f20006t.get()).aB) {
            boolean z;
            if (((WebrtcUiHandler) this.f20006t.get()).as()) {
                ((WebrtcUiHandler) this.f20006t.get()).aM();
                m19652L(this);
                m19702t();
            } else {
                ((WebrtcUiHandler) this.f20006t.get()).aN();
            }
            this.f20008w.f20207F = false;
            RtcVideoChatHeadView rtcVideoChatHeadView = this.f20008w;
            if (((WebrtcUiHandler) this.f20006t.get()).m19484u()) {
                z = false;
            } else {
                z = true;
            }
            rtcVideoChatHeadView.m19847a(z, !m19647G(this));
        }
        this.f20008w.m19848a(true, true, true, false);
    }

    public final void mo824d() {
        ((WebrtcUiHandler) this.f20006t.get()).m19460a(true);
        ((WebrtcUiHandler) this.f20006t.get()).m19481n();
    }

    public final void mo825e() {
        ((WebrtcUiHandler) this.f20006t.get()).m19458a(EndCallReason.CallEndHangupCall);
        ((WebrtcUiHandler) this.f20006t.get()).m19482q();
    }

    public final void mo826f() {
        if (m19647G(this)) {
            m19655O(this);
            ((WebrtcUiHandler) this.f20006t.get()).ao = true;
        } else {
            ((WebrtcUiHandler) this.f20006t.get()).ao = false;
            m19654N(this);
        }
        m19658T(this);
        if (this.f19981T) {
            this.f20008w.m19848a(true, true, true, false);
        }
    }

    public final void mo827g() {
        boolean z;
        if (this.f19981T && this.f20008w != null) {
            this.f20008w.m19847a(!((WebrtcUiHandler) this.f20006t.get()).m19484u(), !m19647G(this));
        }
        WebrtcUiHandler webrtcUiHandler = (WebrtcUiHandler) this.f20006t.get();
        if (((WebrtcUiHandler) this.f20006t.get()).m19484u()) {
            z = false;
        } else {
            z = true;
        }
        webrtcUiHandler.m19469e(z);
        this.f20008w.m19848a(true, true, true, false);
    }

    public final void mo828h() {
        ((WebrtcUiHandler) this.f20006t.get()).m19432C();
        this.f20008w.m19848a(true, true, true, false);
    }

    private int m19679w() {
        if (((WebrtcUiHandler) this.f20006t.get()).bQ) {
            return 150;
        }
        return 120;
    }

    public final void mo822b() {
        ExecutorDetour.a(this.f19994g, new C23341(this), 1665637983);
    }

    public final void m19684a() {
        Class cls = BackgroundVideoCallService.class;
        m19669a((Object) this, (Context) this);
        m19681y();
    }

    public final int m19683a(Intent intent, int i, int i2) {
        return 1;
    }

    public final long m19693i() {
        return this.af;
    }

    public final int m19694j() {
        return this.aj;
    }

    public final long m19696m() {
        return this.ag;
    }

    private boolean m19680x() {
        return (this.aa || ((WebrtcUiHandler) this.f20006t.get()).bQ) ? false : true;
    }

    private void m19666a(int i, boolean z) {
        int i2;
        if (z) {
            i2 = this.f20010y.flags | i;
        } else {
            i2 = this.f20010y.flags & (i ^ -1);
        }
        if (i2 != this.f20010y.flags) {
            this.f20010y.flags = i2;
            this.f19989b.updateViewLayout(this.ab, this.f20010y);
        }
    }

    private void m19681y() {
        if (this.f20007v == null) {
            int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                this.f19975N = getResources().getDimensionPixelSize(identifier);
            }
            m19644C();
            this.f19963B = 1.6666666f;
            Spring a = this.f19990c.a().a(f19961u);
            a.k = 0.3d;
            a = a;
            a.l = 0.3d;
            this.f19965D = a.a(new MySpringListener(this));
            a = this.f19990c.a().a(f19961u);
            a.k = 0.3d;
            a = a;
            a.l = 0.3d;
            this.f19966E = a.a(new MySpringListener(this));
            this.f19971J = 0;
            this.f19972K = this.f19975N - this.f19976O;
            this.f19986Y = this.f19998k.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.ct, false);
            this.f19987Z = this.f19998k.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.cr, true);
            this.aa = this.f19998k.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.cq, false);
            if (!((WebrtcUiHandler) this.f20006t.get()).bQ) {
                this.f20005r = this.f19996i;
            }
            if (VERSION.SDK_INT < 18 || ((WebrtcUiHandler) this.f20006t.get()).bQ) {
                this.aa = false;
            }
            this.f20007v = new C23372(this);
            ((WebrtcUiHandler) this.f20006t.get()).m19456a(this.f20007v);
            this.f20008w = new RtcVideoChatHeadView(this, ((WebrtcUiHandler) this.f20006t.get()).bQ, ((WebrtcUiHandler) this.f20006t.get()).ai);
            RtcVideoChatHeadView rtcVideoChatHeadView = this.f20008w;
            rtcVideoChatHeadView.f20237z = this.aa;
            if (rtcVideoChatHeadView.f20214c != null) {
                rtcVideoChatHeadView.f20214c.f20134i = rtcVideoChatHeadView.f20237z;
            }
            this.f20008w.f20205D = ((WebrtcUiHandler) this.f20006t.get()).aj();
            if (((WebrtcUiHandler) this.f20006t.get()).bQ) {
                this.f20008w.f20209H = 50;
            } else {
                this.f20008w.f20209H = 36;
            }
            this.f20008w.f20212K = this;
            this.f20008w.setOnTouchListener(new DragTouchListener(this));
            this.f20010y = new LayoutParams(-2, -2, 2003, 20972072, -2);
            this.f20010y.gravity = 51;
            LayoutParams layoutParams = this.f20010y;
            RtcVideoChatHeadView rtcVideoChatHeadView2 = this.f20008w;
            layoutParams.x = 0;
            this.f20010y.y = this.f19975N - this.f19976O;
            m19668a(this, m19679w(), (int) (((float) m19679w()) * this.f19963B), false);
            this.ab = new LinearLayout(this);
            this.f20008w.setLayoutParams(new ViewGroup.LayoutParams(m19656P(this), m19657Q(this)));
            this.ab.addView(this.f20008w);
            if (m19680x()) {
                this.f20008w.f20211J = new C23383(this);
            }
            this.f20008w.setVisibility(8);
            m19643A();
            this.f19989b.addView(this.ab, this.f20010y);
            if (m19680x()) {
                this.f19980S = new RenderThread(this.f19989b);
                this.f19980S.setName("TexFromCam Render");
                this.f19980S.f19892o = new C23404(this);
                this.f19980S.start();
            }
        }
    }

    public static void m19682z(BackgroundVideoCallService backgroundVideoCallService) {
        backgroundVideoCallService.m19644C();
        if (backgroundVideoCallService.f20008w.f20228q) {
            backgroundVideoCallService.f20008w.m19851e();
            ae(backgroundVideoCallService);
            backgroundVideoCallService.f20008w.m19852f();
        } else {
            ae(backgroundVideoCallService);
        }
        m19658T(backgroundVideoCallService);
        m19675d(backgroundVideoCallService, backgroundVideoCallService.ac);
    }

    public static void m19671b(BackgroundVideoCallService backgroundVideoCallService, String str) {
        if (str != null && "homekey".contentEquals(str)) {
            backgroundVideoCallService.f19985X = backgroundVideoCallService.f20001n.now();
            backgroundVideoCallService.af();
            m19673c(backgroundVideoCallService, false);
            backgroundVideoCallService.ag();
            if (m19651K(backgroundVideoCallService) && ((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).bQ) {
                m19675d(backgroundVideoCallService, false);
            }
            backgroundVideoCallService.f20003p = backgroundVideoCallService.f19999l.schedule(new C23415(backgroundVideoCallService), 1000, TimeUnit.MILLISECONDS);
        }
        Long.valueOf(backgroundVideoCallService.f19985X);
    }

    private void m19643A() {
        this.f19979R = new DynamicSecureBroadcastReceiver(new Builder().b("android.intent.action.CLOSE_SYSTEM_DIALOGS", new C23437(this)).b("android.intent.action.CONFIGURATION_CHANGED", new C23426(this)).b());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        intentFilter.addAction("android.intent.action.CONFIGURATION_CHANGED");
        registerReceiver(this.f19979R, intentFilter);
    }

    @TargetApi(14)
    private void m19644C() {
        Display defaultDisplay = this.f19989b.getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        if (getResources().getConfiguration().orientation == 1) {
            this.f19973L = Math.max(point.x, point.y);
            this.f19974M = Math.min(point.x, point.y);
        } else {
            this.f19973L = Math.min(point.x, point.y);
            this.f19974M = Math.max(point.x, point.y);
        }
        if (this.f20008w != null) {
            int[] iArr = new int[2];
            this.f20008w.getLocationOnScreen(iArr);
            if (iArr[1] > 0) {
                this.f19976O = iArr[1] - this.f20010y.y;
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return this.f20009x;
    }

    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public final void m19695k() {
        this.f19989b.removeView(this.ab);
        af();
        ag();
        m19673c(this, false);
        this.f20005r = null;
        if (this.f20008w.getSelfTextureView() != null) {
            this.f20008w.getSelfTextureView().setSurfaceTextureListener(null);
        }
        this.f20008w.setOnTouchListener(null);
        this.f20008w.f20212K = null;
        this.f20008w = null;
        if (this.f19980S != null) {
            this.f19980S.f19879a = null;
            RenderHandler renderHandler = this.f19980S.f19881d;
            renderHandler.sendMessage(renderHandler.obtainMessage(3));
            this.f19980S = null;
        }
        this.f19965D.a();
        this.f19966E.a();
        this.f19965D = null;
        this.f19966E = null;
        ((WebrtcUiHandler) this.f20006t.get()).m19467b(this.f20007v);
        this.f20007v = null;
        unregisterReceiver(this.f19979R);
        this.f19979R = null;
    }

    public final boolean m19697n() {
        if (!((WebrtcUiHandler) this.f20006t.get()).m19437M()) {
            return false;
        }
        boolean z;
        if (!this.f19986Y) {
            if (!m19648H(this) && !((WebrtcUiHandler) this.f20006t.get()).az() && !m19661W()) {
                return false;
            }
            if (((WebrtcUiHandler) this.f20006t.get()).az() && !((WebrtcUiHandler) this.f20006t.get()).aB) {
                return false;
            }
        }
        if (!this.f19981T) {
            this.ah = this.f20001n.now();
            if (((WebrtcUiHandler) this.f20006t.get()).m19441R()) {
                this.ai = this.f20001n.now();
            }
            this.aj++;
        }
        this.f20008w.f20207F = ((WebrtcUiHandler) this.f20006t.get()).aL();
        RtcVideoChatHeadView rtcVideoChatHeadView = this.f20008w;
        if (((WebrtcUiHandler) this.f20006t.get()).au()) {
            z = false;
        } else {
            z = true;
        }
        rtcVideoChatHeadView.f20206E = z;
        m19645E();
        return true;
    }

    private void m19645E() {
        this.f20008w.setVisibility(0);
        this.f20008w.m19851e();
        m19666a(16, false);
        ((WebrtcUiHandler) this.f20006t.get()).m19471f(true);
        if (!this.f19987Z) {
            this.f20000m.c();
        }
        if (((WebrtcUiHandler) this.f20006t.get()).bQ) {
            this.ab.setBackground(getResources().getDrawable(2130843222));
        }
        this.f19981T = true;
        this.ac = false;
        this.f19984W = false;
        if (m19646F(this)) {
            m19652L(this);
        }
        if (m19647G(this)) {
            m19654N(this);
        }
        VideoCaptureAndroid.m21577a((CaptureErrorCallback) this);
        if (((WebrtcUiHandler) this.f20006t.get()).az() || ((WebrtcUiHandler) this.f20006t.get()).aB()) {
            this.f20008w.m19845a(getString(2131232003));
        }
        if (this.f20005r != null) {
            if (this.f20005r != null && this.f20005r.f5795c == null) {
                this.f20005r.m6012a(new ChatHeadSimpleFullView(this.f19991d, true));
            }
            this.f20005r.mo229a();
        }
        m19658T(this);
        this.f20008w.getViewTreeObserver().addOnGlobalLayoutListener(new C23448(this));
        m19678f(true);
    }

    public static boolean m19646F(BackgroundVideoCallService backgroundVideoCallService) {
        return ((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).m19435G() && ((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).as();
    }

    public static boolean m19647G(BackgroundVideoCallService backgroundVideoCallService) {
        if (!((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).m19437M() || ((!((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).m19433D() && !((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).m19434F()) || ((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).ao)) {
            return false;
        }
        return true;
    }

    public static boolean m19648H(BackgroundVideoCallService backgroundVideoCallService) {
        return m19647G(backgroundVideoCallService) || m19646F(backgroundVideoCallService);
    }

    public final void m19698o() {
        m19700r();
        m19672b(false);
        if (this.ah > 0) {
            this.af += this.f20001n.now() - this.ah;
            this.ah = -1;
        }
        if (this.ai > 0) {
            this.ag += this.f20001n.now() - this.ai;
            this.ai = -1;
        }
    }

    private void m19672b(boolean z) {
        if (this.f19981T) {
            af();
            m19673c(this, false);
            VideoCaptureAndroid.m21577a(null);
            this.f20008w.m19852f();
            this.f20008w.m19844a(ViewType.HIDDEN, ((WebrtcUiHandler) this.f20006t.get()).m19435G(), ((WebrtcUiHandler) this.f20006t.get()).m19433D());
            m19666a(16, true);
            ((WebrtcUiHandler) this.f20006t.get()).m19471f(false);
            if (!this.f19987Z) {
                this.f20000m.d();
            }
            this.f19981T = false;
            if (this.f20005r != null) {
                this.f20005r.mo230b();
            }
            if (z) {
                m19653M(this);
                m19655O(this);
            }
            ad(this);
            this.f20008w.m19848a(false, false, false, false);
            this.ab.setBackgroundResource(0);
        }
    }

    private boolean m19649I() {
        if (m19660V() || m19661W() || !this.ac) {
            return false;
        }
        return true;
    }

    public static boolean m19650J(BackgroundVideoCallService backgroundVideoCallService) {
        if (!((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).m19442S() || backgroundVideoCallService.m19660V() || backgroundVideoCallService.m19661W() || !backgroundVideoCallService.ac) {
            return false;
        }
        return true;
    }

    public static boolean m19651K(BackgroundVideoCallService backgroundVideoCallService) {
        if (!((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).m19442S()) {
            return false;
        }
        if (backgroundVideoCallService.m19660V() || backgroundVideoCallService.m19661W()) {
            return false;
        }
        return true;
    }

    public final boolean m19699q() {
        return this.f19983V;
    }

    public static void m19652L(BackgroundVideoCallService backgroundVideoCallService) {
        if (backgroundVideoCallService.f20008w != null) {
            ((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).m19452a(backgroundVideoCallService.f20008w.getPeerView());
        }
    }

    public final void m19700r() {
        if (this.f20008w != null) {
            boolean z = m19651K(this) && this.f20008w.getAnimation() == null && this.ac;
            Boolean.valueOf(z);
            if (m19651K(this) && this.f20008w.getAnimation() == null && this.ac) {
                m19675d(this, false);
            }
        }
    }

    public static void m19653M(BackgroundVideoCallService backgroundVideoCallService) {
        if (backgroundVideoCallService.f20008w != null) {
            ((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).m19464b(backgroundVideoCallService.f20008w.getPeerView());
        }
    }

    public static void m19654N(BackgroundVideoCallService backgroundVideoCallService) {
        synchronized (backgroundVideoCallService) {
            if (backgroundVideoCallService.m19680x()) {
                backgroundVideoCallService.f19980S.m19610a(((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).aI());
                backgroundVideoCallService.f19980S.m19611b(((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).aJ());
                backgroundVideoCallService.f19980S.m19607a();
            }
            if (backgroundVideoCallService.f20008w.getSelfTextureView().isAvailable()) {
                if (backgroundVideoCallService.m19680x()) {
                    backgroundVideoCallService.f19980S.m19612c().m19604a(backgroundVideoCallService.f20008w.getSelfTextureView().getSurfaceTexture());
                } else {
                    VideoCaptureAndroid.m21574a(backgroundVideoCallService.f20008w.getSelfTextureView().getSurfaceTexture());
                    ((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).m19454a(LocalVideoState.STARTED);
                }
            }
            backgroundVideoCallService.f20008w.getSelfTextureView().setSurfaceTextureListener(backgroundVideoCallService);
        }
    }

    public static synchronized void m19655O(BackgroundVideoCallService backgroundVideoCallService) {
        synchronized (backgroundVideoCallService) {
            if (((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).m19433D()) {
                ((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).m19454a(LocalVideoState.STOPPED);
            }
        }
    }

    public static int m19656P(BackgroundVideoCallService backgroundVideoCallService) {
        if (((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).bQ) {
            return backgroundVideoCallService.f20011z;
        }
        return Math.min(backgroundVideoCallService.f20011z, backgroundVideoCallService.f19962A);
    }

    public static int m19657Q(BackgroundVideoCallService backgroundVideoCallService) {
        if (((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).bQ) {
            return backgroundVideoCallService.f19962A;
        }
        return Math.min(backgroundVideoCallService.f20011z, backgroundVideoCallService.f19962A);
    }

    public static void m19658T(BackgroundVideoCallService backgroundVideoCallService) {
        m19663Y(backgroundVideoCallService);
        m19659U(backgroundVideoCallService);
        backgroundVideoCallService.m19662X();
        if (backgroundVideoCallService.f20008w != null) {
            backgroundVideoCallService.f20008w.m19847a(((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).m19484u(), !m19647G(backgroundVideoCallService));
        }
        if (backgroundVideoCallService.f19980S != null) {
            backgroundVideoCallService.f19980S.f19879a = new C23459(backgroundVideoCallService);
        }
    }

    public static void m19668a(BackgroundVideoCallService backgroundVideoCallService, int i, int i2, boolean z) {
        if (backgroundVideoCallService.f20008w != null) {
            int g;
            if (m19647G(backgroundVideoCallService) && !m19646F(backgroundVideoCallService)) {
                if (backgroundVideoCallService.getResources().getConfiguration().orientation == 1) {
                    i = backgroundVideoCallService.m19679w();
                    i2 = (int) (((float) backgroundVideoCallService.m19679w()) * 1.4f);
                    backgroundVideoCallService.f19963B = 1.6666666f;
                } else {
                    i = (int) (((float) backgroundVideoCallService.m19679w()) * 1.4f);
                    i2 = backgroundVideoCallService.m19679w();
                    backgroundVideoCallService.f19963B = 0.6f;
                }
            }
            if (z) {
                g = backgroundVideoCallService.f20008w.m19853g();
            } else {
                g = 0;
            }
            if (g == 2) {
                g++;
            }
            int max = Math.max(backgroundVideoCallService.m19679w(), g * 60);
            if (((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).bQ && i > i2) {
                max += 30;
            }
            backgroundVideoCallService.f19964C = backgroundVideoCallService.m19670b(max);
            if (i <= i2) {
                backgroundVideoCallService.f19962A = (int) (((float) backgroundVideoCallService.f19964C) * 1.4f);
                backgroundVideoCallService.f20011z = backgroundVideoCallService.f19964C;
            } else if (!((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).bQ || max <= backgroundVideoCallService.m19679w()) {
                backgroundVideoCallService.f20011z = (int) (((float) backgroundVideoCallService.f19964C) * 1.4f);
                backgroundVideoCallService.f19962A = backgroundVideoCallService.f19964C;
            } else {
                backgroundVideoCallService.f20011z = backgroundVideoCallService.f19964C;
                backgroundVideoCallService.f19962A = (int) (((float) backgroundVideoCallService.f19964C) * 0.71428573f);
            }
            Object[] objArr = new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(backgroundVideoCallService.f20011z), Integer.valueOf(backgroundVideoCallService.f19962A), Float.valueOf(backgroundVideoCallService.f19963B), Boolean.valueOf(z)};
        }
    }

    public static void m19673c(BackgroundVideoCallService backgroundVideoCallService, boolean z) {
        if (backgroundVideoCallService.f20004q != null) {
            backgroundVideoCallService.f20004q.cancel(false);
            backgroundVideoCallService.f20004q = null;
        }
        if (z && backgroundVideoCallService.ac && !((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).aQ()) {
            backgroundVideoCallService.f20004q = backgroundVideoCallService.f19999l.schedule(new Runnable(backgroundVideoCallService) {
                final /* synthetic */ BackgroundVideoCallService f19930a;

                {
                    this.f19930a = r1;
                }

                public void run() {
                    if (this.f19930a.ac && BackgroundVideoCallService.m19651K(this.f19930a) && !((WebrtcUiHandler) this.f19930a.f20006t.get()).aQ()) {
                        BackgroundVideoCallService.m19675d(this.f19930a, false);
                    }
                    this.f19930a.f20004q = null;
                }
            }, 5000, TimeUnit.MILLISECONDS);
        }
    }

    public static void m19675d(BackgroundVideoCallService backgroundVideoCallService, boolean z) {
        Boolean.valueOf(z);
        if (((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).bQ && backgroundVideoCallService.f20008w != null && backgroundVideoCallService.f19981T) {
            backgroundVideoCallService.ac = z;
            m19668a(backgroundVideoCallService, backgroundVideoCallService.f20011z, backgroundVideoCallService.f19962A, backgroundVideoCallService.ac);
            m19677e(backgroundVideoCallService, z);
            m19673c(backgroundVideoCallService, true);
        }
    }

    public static void m19677e(BackgroundVideoCallService backgroundVideoCallService, final boolean z) {
        boolean z2 = false;
        Integer.valueOf(backgroundVideoCallService.f20011z);
        Integer.valueOf(backgroundVideoCallService.f19962A);
        Boolean.valueOf(z);
        Boolean.valueOf(backgroundVideoCallService.f20008w.getAnimation() != null);
        if (backgroundVideoCallService.f20008w.getAnimation() == null) {
            int measuredHeight = backgroundVideoCallService.f20008w.getMeasuredHeight();
            int measuredWidth = backgroundVideoCallService.f20008w.getMeasuredWidth();
            if (measuredHeight > 0 && measuredWidth > 0 && (measuredHeight != backgroundVideoCallService.f19962A || measuredWidth != backgroundVideoCallService.f20011z)) {
                Animation videoChatHeadResizeAnimation = new VideoChatHeadResizeAnimation(backgroundVideoCallService.f20008w, new Point(measuredWidth, measuredHeight), new Point(backgroundVideoCallService.f20011z, backgroundVideoCallService.f19962A));
                videoChatHeadResizeAnimation.setDuration(100);
                if (measuredHeight < backgroundVideoCallService.f19962A) {
                    z2 = true;
                }
                if (!z) {
                    backgroundVideoCallService.f20008w.m19848a(z, true, m19651K(backgroundVideoCallService), m19650J(backgroundVideoCallService));
                    videoChatHeadResizeAnimation.setStartTime(100);
                }
                videoChatHeadResizeAnimation.setAnimationListener(new AnimationListener(backgroundVideoCallService) {
                    final /* synthetic */ BackgroundVideoCallService f19933c;

                    public void onAnimationStart(Animation animation) {
                        this.f19933c.f20008w.setPeerViewFreeze(true);
                        BackgroundVideoCallService.m19659U(this.f19933c);
                        if (z2) {
                            BackgroundVideoCallService.ae(this.f19933c);
                        } else {
                            this.f19933c.ab.setBackgroundResource(0);
                        }
                    }

                    public void onAnimationEnd(Animation animation) {
                        if (!z2) {
                            BackgroundVideoCallService.ae(this.f19933c);
                        }
                        if (this.f19933c.f20008w != null) {
                            if (z) {
                                this.f19933c.f20008w.m19848a(z, true, BackgroundVideoCallService.m19651K(this.f19933c), BackgroundVideoCallService.m19650J(this.f19933c));
                            }
                            this.f19933c.f20008w.setPeerViewFreeze(false);
                            if (!z2 && this.f19933c.f19981T && ((WebrtcUiHandler) this.f19933c.f20006t.get()).bQ) {
                                this.f19933c.ab.setBackground(this.f19933c.getResources().getDrawable(2130843222));
                            }
                        }
                    }

                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                backgroundVideoCallService.f20008w.startAnimation(videoChatHeadResizeAnimation);
            } else if (((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).bQ) {
                backgroundVideoCallService.f20008w.m19848a(z, true, m19651K(backgroundVideoCallService), m19650J(backgroundVideoCallService));
            } else {
                m19659U(backgroundVideoCallService);
                ae(backgroundVideoCallService);
            }
        }
    }

    public static void m19659U(BackgroundVideoCallService backgroundVideoCallService) {
        if (backgroundVideoCallService.f20008w != null && backgroundVideoCallService.f19981T && backgroundVideoCallService.f20008w.isShown() && !backgroundVideoCallService.f20008w.f20228q) {
            backgroundVideoCallService.m19644C();
            backgroundVideoCallService.f20008w.m19843a(new Point(m19656P(backgroundVideoCallService), m19657Q(backgroundVideoCallService)), backgroundVideoCallService.f19963B, ((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).m19435G(), ((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).m19433D());
            backgroundVideoCallService.m19664Z();
        }
    }

    private boolean m19660V() {
        return ((WebrtcUiHandler) this.f20006t.get()).m19478k() && ((WebrtcUiHandler) this.f20006t.get()).aB && !m19646F(this) && !this.ad;
    }

    private boolean m19661W() {
        return (!((WebrtcUiHandler) this.f20006t.get()).m19478k() || ((WebrtcUiHandler) this.f20006t.get()).aB || ((WebrtcUiHandler) this.f20006t.get()).bL || this.ad) ? false : true;
    }

    private void m19662X() {
        if (this.f20008w != null && this.f19981T) {
            boolean z;
            boolean h = this.f20008w.m19854h();
            if (m19660V()) {
                this.f20008w.m19844a(ViewType.OUTGOING_INSTANT, ((WebrtcUiHandler) this.f20006t.get()).m19435G(), ((WebrtcUiHandler) this.f20006t.get()).m19433D());
                if (!h) {
                    m19675d(this, true);
                    z = h;
                }
                z = h;
            } else if (m19661W()) {
                this.f20008w.m19844a(ViewType.INCOMING_INSTANT, ((WebrtcUiHandler) this.f20006t.get()).m19435G(), ((WebrtcUiHandler) this.f20006t.get()).m19433D());
                if (!h) {
                    m19675d(this, true);
                    z = h;
                }
                z = h;
            } else if (((WebrtcUiHandler) this.f20006t.get()).az() || ((WebrtcUiHandler) this.f20006t.get()).aB()) {
                this.f20008w.m19844a(ViewType.NONE, ((WebrtcUiHandler) this.f20006t.get()).m19435G(), ((WebrtcUiHandler) this.f20006t.get()).m19433D());
                if (!h) {
                    m19675d(this, true);
                    z = h;
                }
                z = h;
            } else if (m19646F(this) && m19647G(this)) {
                this.f20008w.m19844a(ViewType.BOTH, ((WebrtcUiHandler) this.f20006t.get()).m19435G(), ((WebrtcUiHandler) this.f20006t.get()).m19433D());
                if (((WebrtcUiHandler) this.f20006t.get()).m19478k()) {
                    this.ad = true;
                    z = h;
                }
                z = h;
            } else if (m19646F(this) || m19647G(this)) {
                this.f20008w.m19844a(m19646F(this) ? ViewType.PEER : ViewType.SELF, ((WebrtcUiHandler) this.f20006t.get()).m19435G(), ((WebrtcUiHandler) this.f20006t.get()).m19433D());
                z = h;
            } else if (!((WebrtcUiHandler) this.f20006t.get()).m19441R() || this.f19986Y) {
                this.f20008w.m19844a(ViewType.NONE, ((WebrtcUiHandler) this.f20006t.get()).m19435G(), ((WebrtcUiHandler) this.f20006t.get()).m19433D());
                z = h;
            } else {
                z = false;
                ah();
            }
            if (z) {
                m19675d(this, z);
            }
        }
    }

    public static void m19663Y(BackgroundVideoCallService backgroundVideoCallService) {
        backgroundVideoCallService.f20010y.x = backgroundVideoCallService.f19971J;
        backgroundVideoCallService.f20010y.y = backgroundVideoCallService.f19972K;
        if (backgroundVideoCallService.f19981T && backgroundVideoCallService.f20008w != null) {
            backgroundVideoCallService.f19989b.updateViewLayout(backgroundVideoCallService.ab, backgroundVideoCallService.f20010y);
        }
    }

    private void m19664Z() {
        if (this.f19982U != null) {
            int i;
            int P = m19656P(this) + this.f20010y.x;
            if (((WebrtcUiHandler) this.f20006t.get()).bQ) {
                i = P;
                P = (this.f20010y.y + (m19657Q(this) / 2)) + this.f19976O;
            } else {
                i = P - m19670b(6);
                P = (this.f20010y.y + (this.f19964C / 2)) + this.f19976O;
            }
            if (((ChatHeadTextBubbleView) this.f19982U.f5795c).isShown()) {
                FloatingChatWindow floatingChatWindow = this.f19982U;
                Origin origin = Origin.LEFT;
                ChatHeadTextBubbleView chatHeadTextBubbleView = (ChatHeadTextBubbleView) floatingChatWindow.f5795c;
                if (!(origin == chatHeadTextBubbleView.f5821n && floatingChatWindow.getLayoutParams().x == i && floatingChatWindow.f5830b == P)) {
                    chatHeadTextBubbleView.setOrigin(origin);
                    floatingChatWindow.f5797e.removeCallbacksAndMessages(null);
                    LayoutParams layoutParams = floatingChatWindow.getLayoutParams();
                    if (layoutParams.x != i) {
                        layoutParams.x = i;
                        floatingChatWindow.setLayoutParams(layoutParams);
                    }
                    floatingChatWindow.f5830b = P;
                    floatingChatWindow.setY(floatingChatWindow.f5830b - (((ChatHeadTextBubbleView) floatingChatWindow.f5795c).getMeasuredHeight() / 2));
                    LayoutParams layoutParams2 = floatingChatWindow.getLayoutParams();
                    if (origin == Origin.LEFT) {
                        layoutParams2.gravity = 51;
                    } else if (origin == Origin.RIGHT) {
                        layoutParams2.gravity = 53;
                    }
                    floatingChatWindow.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    private void m19674c(String str) {
        if (this.f19982U == null) {
            ChatHeadTextBubbleWindowProvider chatHeadTextBubbleWindowProvider = this.f19993f;
            this.f19982U = new ChatHeadTextBubbleWindow(WindowManagerMethodAutoProvider.b(chatHeadTextBubbleWindowProvider), IdBasedProvider.a(chatHeadTextBubbleWindowProvider, 4129), false);
            ChatHeadTextBubbleView chatHeadTextBubbleView = new ChatHeadTextBubbleView(this.f19991d);
            chatHeadTextBubbleView.setMaxLines(4);
            this.f19982U.m6012a(chatHeadTextBubbleView);
            FloatingChatWindow floatingChatWindow = this.f19982U;
            ((ChatHeadTextBubbleView) floatingChatWindow.f5795c).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ BackgroundVideoCallService f19934a;

                {
                    this.f19934a = r1;
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 660594629);
                    BackgroundVideoCallService.ad(this.f19934a);
                    if (!((WebrtcUiHandler) this.f19934a.f20006t.get()).m19478k()) {
                        this.f19934a.m19701s();
                    }
                    Logger.a(2, EntryType.UI_INPUT_END, 2123597499, a);
                }
            });
            this.f19982U.mo229a();
        }
        m19664Z();
        ((ChatHeadTextBubbleView) this.f19982U.f5795c).setMessage(Factory.getInstance().newSpannable(str));
        ((ChatHeadTextBubbleView) this.f19982U.f5795c).m6043a();
        ((ChatHeadTextBubbleView) this.f19982U.f5795c).m6045e();
    }

    public static void ac(BackgroundVideoCallService backgroundVideoCallService) {
        if (!backgroundVideoCallService.f19981T) {
            return;
        }
        if (((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).m19478k()) {
            if (((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).aB || ((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).bL) {
                backgroundVideoCallService.m19674c(backgroundVideoCallService.getString(2131232176));
            }
        } else if (!((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).bQ) {
            r0 = backgroundVideoCallService.f19995h.a(WebrtcPrefKeys.f19407h, 0);
            if (r0 < 3) {
                backgroundVideoCallService.m19674c(backgroundVideoCallService.getString(2131232156) + "\n" + backgroundVideoCallService.getString(2131232157));
                backgroundVideoCallService.f19995h.edit().a(WebrtcPrefKeys.f19407h, r0 + 1).commit();
            }
        } else if (((WebrtcUiHandler) backgroundVideoCallService.f20006t.get()).bQ) {
            r0 = backgroundVideoCallService.f19995h.a(WebrtcPrefKeys.f19408i, 0);
            if (r0 < 3) {
                backgroundVideoCallService.m19674c(backgroundVideoCallService.getString(2131232156) + "\n" + backgroundVideoCallService.getString(2131232159));
                backgroundVideoCallService.f19995h.edit().a(WebrtcPrefKeys.f19408i, r0 + 1).commit();
            }
        }
    }

    public static void ad(BackgroundVideoCallService backgroundVideoCallService) {
        if (backgroundVideoCallService.f19982U != null) {
            if (((ChatHeadTextBubbleView) backgroundVideoCallService.f19982U.f5795c).isShown()) {
                ((ChatHeadTextBubbleView) backgroundVideoCallService.f19982U.f5795c).m6044b();
            }
            backgroundVideoCallService.f19982U.mo230b();
            backgroundVideoCallService.f19982U = null;
        }
    }

    public static void ae(BackgroundVideoCallService backgroundVideoCallService) {
        backgroundVideoCallService.m19678f(false);
    }

    private void m19678f(boolean z) {
        if (this.f20008w != null) {
            int P = this.f19974M - m19656P(this);
            RtcVideoChatHeadView rtcVideoChatHeadView = this.f20008w;
            double d = (double) 0;
            if (this.f19971J > P / 2) {
                d = (double) (P - this.f20008w.getRightMarginInPixels());
            }
            this.f19977P = false;
            this.f19978Q = z;
            this.f19972K = m19665a(this.f19972K);
            if (this.f19966E != null) {
                this.f19966E.a((double) this.f19972K);
                this.f19966E.b((double) this.f19972K);
            }
            if (this.f19965D != null) {
                this.f19965D.a((double) this.f19971J);
                this.f19965D.b(d);
            }
        }
    }

    private void af() {
        if (this.f20002o != null) {
            this.f20002o.cancel(false);
            this.f20002o = null;
            if (this.f20008w != null) {
                this.f20008w.m19846a(false);
            }
        }
    }

    private void ag() {
        if (this.f20003p != null) {
            this.f20003p.cancel(false);
            this.f20003p = null;
        }
    }

    private void ah() {
        m19685a(false);
    }

    public final void m19685a(final boolean z) {
        long now = this.f20001n.now() - this.f19985X;
        if (((WebrtcUiHandler) this.f20006t.get()).aQ() || this.f19985X < 0 || now > 5000) {
            this.f19984W = true;
            m19644C();
            m19698o();
            if (((WebrtcUiHandler) this.f20006t.get()).m19433D()) {
                ((WebrtcUiHandler) this.f20006t.get()).m19471f(false);
            }
            this.f19992e.a(new Intent(this, WebrtcIncallActivity.class).setAction("com.facebook.rtc.fbwebrtc.intent.action.SHOW_UI").putExtra("CONTACT_ID", ((WebrtcUiHandler) this.f20006t.get()).ai).putExtra("AUTO_ACCEPT", z).setFlags(268500992), this.f19991d);
        } else if (this.f20002o != null) {
            af();
        } else if (this.f20008w != null) {
            this.f20002o = this.f19999l.schedule(new Runnable(this) {
                final /* synthetic */ BackgroundVideoCallService f19936b;

                public void run() {
                    Class cls = BackgroundVideoCallService.f19960s;
                    this.f19936b.f20008w.m19846a(false);
                    this.f19936b.f20002o = null;
                    this.f19936b.m19685a(z);
                }
            }, 5000 - now, TimeUnit.MILLISECONDS);
            this.f20008w.m19846a(true);
            Long.valueOf(now);
        }
    }

    private int ai() {
        return m19670b(20);
    }

    private int m19665a(int i) {
        if (i < this.f19975N - this.f19976O) {
            i = this.f19975N - this.f19976O;
        }
        if (m19657Q(this) + i > this.f19973L - ai()) {
            return (this.f19973L - ai()) - m19657Q(this);
        }
        return i;
    }

    protected final boolean m19701s() {
        if (this.f20008w != null) {
            if (!((WebrtcUiHandler) this.f20006t.get()).bQ) {
                ah();
            } else if (!this.f20008w.m19854h()) {
                m19675d(this, !this.f20008w.m19854h());
            } else if (m19649I()) {
                ah();
            } else {
                m19675d(this, true);
            }
        }
        return true;
    }

    public synchronized void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.f19980S != null) {
            this.f19980S.m19612c().m19604a(surfaceTexture);
        }
        if (!m19680x()) {
            VideoCaptureAndroid.m21574a(this.f20008w.getSelfTextureView().getSurfaceTexture());
            ((WebrtcUiHandler) this.f20006t.get()).m19454a(LocalVideoState.STARTED);
        }
    }

    public synchronized void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.f19980S != null) {
            this.f19980S.m19612c().m19603a(i, i2);
        }
    }

    public synchronized boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        if (VideoCaptureAndroid.m21569a() != null && VideoCaptureAndroid.m21569a().equals(surfaceTexture)) {
            VideoCaptureAndroid.m21574a(null);
        }
        if (this.f19980S != null) {
            this.f19980S.m19612c().m19602a();
        }
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    private int m19670b(int i) {
        return ((int) getResources().getDisplayMetrics().scaledDensity) * i;
    }

    public final void m19702t() {
        ((WebrtcUiHandler) this.f20006t.get()).m19454a(LocalVideoState.STARTED);
        m19654N(this);
        m19658T(this);
    }
}
