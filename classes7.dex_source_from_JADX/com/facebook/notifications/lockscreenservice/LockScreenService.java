package com.facebook.notifications.lockscreenservice;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.CrossFbProcessBroadcast;
import com.facebook.base.broadcast.CrossProcessFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.service.FbService;
import com.facebook.common.android.KeyguardManagerMethodAutoProvider;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.android.TelephonyManagerMethodAutoProvider;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.hardware.ScreenPowerState;
import com.facebook.common.hardware.ScreenPowerState.PowerChangeListener;
import com.facebook.common.touch.DragDetector;
import com.facebook.common.touch.TouchSlopDetector;
import com.facebook.common.util.TriState;
import com.facebook.common.wakelock.FbWakeLockManager;
import com.facebook.common.wakelock.FbWakeLockManager.WakeLock;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.device.ScreenUtil;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.fbui.tooltip.Tooltip.OnTooltipClickListener;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.lockscreen.db.PushNotificationDbHelper;
import com.facebook.notifications.lockscreen.ui.LockScreenFrameLayout;
import com.facebook.notifications.lockscreen.ui.LockScreenFrameLayout.OnBackPressedListener;
import com.facebook.notifications.lockscreen.ui.LockScreenFrameLayout.OnSizeChangedListener;
import com.facebook.notifications.lockscreen.ui.LockScreenFrameLayout.SwipeCallback;
import com.facebook.notifications.lockscreen.ui.LockScreenSettingsDialog;
import com.facebook.notifications.lockscreen.util.LockScreenNotification;
import com.facebook.notifications.lockscreen.util.LockScreenUtil;
import com.facebook.notifications.lockscreen.util.PushNotification;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.sensor.ProximitySensor;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.springs.SpringUtil;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.animations.AnimationUtil;
import com.facebook.widget.dialog.CustomDialog;
import com.facebook.widget.dialog.CustomDialog.AnimationState;
import com.facebook.widget.dialog.CustomDialog.AnimationType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

@TargetApi(14)
/* compiled from: network_state_during_recording */
public class LockScreenService extends FbService {
    public static final String f8295a = LockScreenService.class.getSimpleName();
    public static final SpringConfig f8296b = SpringConfig.a(20.0d, 7.0d);
    private static final SpringConfig f8297y = SpringConfig.a(20.0d, 4.0d);
    public LockScreenFrameLayout f8298A;
    public ViewGroup f8299B;
    public View f8300C;
    public ListView f8301D;
    private ViewGroup f8302E;
    private TextView f8303F;
    public ViewGroup f8304G;
    public TextView f8305H;
    public ViewGroup f8306I;
    public Spring f8307J;
    public Spring f8308K;
    public Spring f8309L;
    public Spring f8310M;
    public float f8311N;
    public float f8312O;
    private DismissSpringListener f8313P;
    public GestureDetector f8314Q;
    public DragDetector f8315R;
    private PopupDragGestureListener f8316S;
    public LockScreenSettingsDialog f8317T;
    public final LockProximitySensorListener f8318U = new LockProximitySensorListener(this);
    public final RunnableProximitySensorTimeout f8319V = new RunnableProximitySensorTimeout(this);
    private SelfRegistrableReceiverImpl f8320W;
    private BroadcastReceiver f8321X;
    private DismissTouchListener f8322Y = new DismissTouchListener(this);
    private final LockPhoneStateListener f8323Z = new LockPhoneStateListener(this);
    private final LockScreenOnListener aa = new LockScreenOnListener(this);
    public WakeLock ab;
    private WakeLock ac;
    private CountDownTimer ad;
    public Tooltip ae;
    public boolean af = false;
    private int ag = 0;
    public int ah;
    public boolean ai = false;
    public boolean aj;
    public boolean ak;
    private boolean al = false;
    public boolean am = false;
    @Inject
    @CrossFbProcessBroadcast
    BaseFbBroadcastManager f8324c;
    @DefaultExecutorService
    @Inject
    ExecutorService f8325d;
    @Inject
    @ForUiThread
    Handler f8326e;
    @Inject
    AnalyticsLogger f8327f;
    @Inject
    DefaultAndroidThreadUtil f8328g;
    @Inject
    AnimationUtil f8329h;
    @Inject
    KeyguardManager f8330i;
    @Inject
    LayoutInflater f8331j;
    @Inject
    LockMessageLoader f8332k;
    @Inject
    LockScreenNotificationsAdapter f8333l;
    @Inject
    LockScreenUtil f8334m;
    @Inject
    FbWakeLockManager f8335n;
    @Inject
    ProximitySensor f8336o;
    @Inject
    PushNotificationDbHelper f8337p;
    @Inject
    ScreenPowerState f8338q;
    @Inject
    ScreenUtil f8339r;
    @Inject
    SecureContextHelper f8340s;
    @Inject
    SpringSystem f8341t;
    @Inject
    TelephonyManager f8342u;
    @Inject
    WindowManager f8343v;
    @Inject
    Lazy<PerformanceLogger> f8344w;
    @Inject
    AbstractFbErrorReporter f8345x;
    public TouchSlopDetector f8346z;

    /* compiled from: network_state_during_recording */
    class C06643 implements Comparator<LockScreenNotification> {
        final /* synthetic */ LockScreenService f8269a;

        C06643(LockScreenService lockScreenService) {
            this.f8269a = lockScreenService;
        }

        public int compare(Object obj, Object obj2) {
            return (int) (((LockScreenNotification) obj2).f8227a - ((LockScreenNotification) obj).f8227a);
        }
    }

    /* compiled from: network_state_during_recording */
    class C06654 implements OnClickListener {
        final /* synthetic */ LockScreenService f8270a;

        C06654(LockScreenService lockScreenService) {
            this.f8270a = lockScreenService;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -832792268);
            this.f8270a.f8309L.b(1.0d);
            Logger.a(2, EntryType.UI_INPUT_END, 4429854, a);
        }
    }

    /* compiled from: network_state_during_recording */
    class C06666 implements SwipeCallback {
        final /* synthetic */ LockScreenService f8271a;

        C06666(LockScreenService lockScreenService) {
            this.f8271a = lockScreenService;
        }

        public final boolean mo451a() {
            return !this.f8271a.f8301D.canScrollVertically(-1);
        }

        public final boolean mo452b() {
            return !this.f8271a.f8301D.canScrollVertically(1);
        }
    }

    /* compiled from: network_state_during_recording */
    class C06677 implements OnSizeChangedListener {
        final /* synthetic */ LockScreenService f8272a;

        C06677(LockScreenService lockScreenService) {
            this.f8272a = lockScreenService;
        }

        public final void mo453a() {
            this.f8272a.f8307J.a(0.0d).l();
            this.f8272a.f8308K.a(0.0d).l();
            this.f8272a.f8309L.a(1.0d).l();
        }
    }

    /* compiled from: network_state_during_recording */
    class C06688 implements OnTouchListener {
        final /* synthetic */ LockScreenService f8273a;

        C06688(LockScreenService lockScreenService) {
            this.f8273a = lockScreenService;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    /* compiled from: network_state_during_recording */
    public class C06699 {
        final /* synthetic */ LockScreenService f8274a;

        C06699(LockScreenService lockScreenService) {
            this.f8274a = lockScreenService;
        }

        public final boolean m9841a(View view) {
            this.f8274a.m9873a(this.f8274a.f8298A, this.f8274a.f8301D.getPositionForView(view));
            return false;
        }
    }

    /* compiled from: network_state_during_recording */
    class BounceDownSpringListener extends SimpleSpringListener {
        int f8275a;
        final /* synthetic */ LockScreenService f8276b;

        public BounceDownSpringListener(LockScreenService lockScreenService) {
            this.f8276b = lockScreenService;
            this.f8275a = this.f8276b.getResources().getDimensionPixelOffset(2131429158);
        }

        public final void m9842a(Spring spring) {
            float d = (float) spring.d();
            float a = (float) SpringUtil.a((double) d, 0.0d, 1.0d, 0.0d, (double) this.f8275a);
            float a2 = (float) SpringUtil.a((double) d, 0.0d, 1.0d, 0.699999988079071d, 1.0d);
            this.f8276b.f8304G.setTranslationY(a);
            this.f8276b.f8305H.setAlpha(a2);
            if (this.f8276b.ai) {
                this.f8276b.f8309L.a(0.0d);
                this.f8276b.f8299B.setTranslationY((float) SpringUtil.a((double) d, 0.0d, 1.0d, (double) (-this.f8276b.ah), 0.0d));
            }
        }

        public final void m9843b(Spring spring) {
            this.f8276b.ai = false;
            if (spring.d() > 0.0d) {
                spring.b(0.0d);
            }
        }
    }

    /* compiled from: network_state_during_recording */
    class CloseSystemDialogsActionReceiver implements ActionReceiver {
        final /* synthetic */ LockScreenService f8277a;

        public CloseSystemDialogsActionReceiver(LockScreenService lockScreenService) {
            this.f8277a = lockScreenService;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 883050466);
            this.f8277a.stopSelf();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 339740961, a);
        }
    }

    /* compiled from: network_state_during_recording */
    class DismissSpringListener extends SimpleSpringListener {
        final /* synthetic */ LockScreenService f8278a;

        public DismissSpringListener(LockScreenService lockScreenService) {
            this.f8278a = lockScreenService;
        }

        public final void m9844a(Spring spring) {
            this.f8278a.f8308K.l();
            float round = (float) Math.round(spring.d());
            if (this.f8278a.aj) {
                this.f8278a.f8304G.setTranslationX(round);
            } else if (this.f8278a.ak) {
                this.f8278a.f8304G.setTranslationY(round);
            }
            round = Math.abs(round);
            if (this.f8278a.aj) {
                round = (float) SpringUtil.a((double) round, 0.0d, (double) this.f8278a.f8311N, 1.0d, 0.5d);
            } else {
                round = (float) SpringUtil.a((double) round, 0.0d, (double) this.f8278a.f8312O, 1.0d, 0.25d);
            }
            if (this.f8278a.f8298A != null) {
                this.f8278a.f8298A.setAlpha(round);
            }
        }

        public final void m9845b(Spring spring) {
            if (Math.abs(spring.d()) >= ((double) (this.f8278a.aj ? this.f8278a.f8311N : this.f8278a.f8312O))) {
                this.f8278a.m9908d(true);
                return;
            }
            this.f8278a.aj = false;
            this.f8278a.ak = false;
        }
    }

    /* compiled from: network_state_during_recording */
    class DismissTouchListener implements OnTouchListener {
        final /* synthetic */ LockScreenService f8279a;

        public DismissTouchListener(LockScreenService lockScreenService) {
            this.f8279a = lockScreenService;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f8279a.ab.e()) {
                this.f8279a.ab.d();
            }
            this.f8279a.ab.a(3000);
            this.f8279a.f8314Q.onTouchEvent(motionEvent);
            this.f8279a.f8315R.a(motionEvent);
            this.f8279a.f8346z.a(motionEvent);
            return true;
        }
    }

    /* compiled from: network_state_during_recording */
    class HideBannerSpringListener extends SimpleSpringListener {
        final /* synthetic */ LockScreenService f8280a;

        public HideBannerSpringListener(LockScreenService lockScreenService) {
            this.f8280a = lockScreenService;
        }

        public final void m9846a(Spring spring) {
            this.f8280a.f8299B.setTranslationY(((float) spring.d()) * ((float) (-this.f8280a.ah)));
        }
    }

    /* compiled from: network_state_during_recording */
    class LockPhoneStateListener extends PhoneStateListener {
        final /* synthetic */ LockScreenService f8281a;
        private TriState f8282b;

        public LockPhoneStateListener(LockScreenService lockScreenService) {
            this.f8281a = lockScreenService;
            this.f8282b = TriState.UNSET;
        }

        public final boolean m9848a() {
            if (!this.f8282b.isSet()) {
                m9847a(this.f8281a.f8342u.getCallState());
            }
            return this.f8282b.asBoolean();
        }

        public void onCallStateChanged(int i, String str) {
            m9847a(i);
            if (m9848a()) {
                this.f8281a.stopSelf();
            }
        }

        private void m9847a(int i) {
            this.f8282b = TriState.valueOf(i != 0);
        }
    }

    /* compiled from: network_state_during_recording */
    public class LockProximitySensorListener {
        final /* synthetic */ LockScreenService f8283a;

        public LockProximitySensorListener(LockScreenService lockScreenService) {
            this.f8283a = lockScreenService;
        }

        public final void m9849a(boolean z) {
            HandlerDetour.a(this.f8283a.f8326e, this.f8283a.f8319V);
            this.f8283a.f8336o.b(this);
            if (!z) {
                this.f8283a.f8307J;
            }
        }
    }

    /* compiled from: network_state_during_recording */
    class LockScreenOnListener implements PowerChangeListener {
        final /* synthetic */ LockScreenService f8284a;

        public LockScreenOnListener(LockScreenService lockScreenService) {
            this.f8284a = lockScreenService;
        }

        public final void m9851a(boolean z) {
            if (z) {
                AdapterDetour.a(this.f8284a.f8333l, 1209869790);
            } else if (this.f8284a.am) {
                this.f8284a.stopSelf();
                return;
            }
            m9850a();
        }

        private void m9850a() {
            if (this.f8284a.f8298A != null && this.f8284a.af) {
                this.f8284a.f8298A.requestFocus();
            }
        }
    }

    /* compiled from: network_state_during_recording */
    class LockscreenNotificationsDismissActionReceiver implements ActionReceiver {
        final /* synthetic */ LockScreenService f8285a;

        public LockscreenNotificationsDismissActionReceiver(LockScreenService lockScreenService) {
            this.f8285a = lockScreenService;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1291284717);
            this.f8285a.stopSelf();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1359160893, a);
        }
    }

    /* compiled from: network_state_during_recording */
    public class PopupDragGestureListener {
        final /* synthetic */ LockScreenService f8286a;
        private final int f8287b;
        private final int f8288c;

        public PopupDragGestureListener(LockScreenService lockScreenService, Context context) {
            this.f8286a = lockScreenService;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f8287b = viewConfiguration.getScaledMaximumFlingVelocity();
            this.f8288c = viewConfiguration.getScaledMinimumFlingVelocity();
        }

        public final void m9854b(float f) {
            this.f8286a.f8346z.j = true;
            this.f8286a.m9869a(f);
            if (this.f8286a.ae != null) {
                this.f8286a.f8300C;
            }
        }

        public final void m9856d(float f) {
            this.f8286a.m9899c(m9852e(f));
            this.f8286a.f8346z.j = false;
        }

        public final void m9853a(float f) {
            this.f8286a.f8346z.i = true;
            this.f8286a.m9892b(f);
            if (this.f8286a.ae != null) {
                this.f8286a.f8300C;
            }
        }

        public final void m9855c(float f) {
            this.f8286a.m9904d(m9852e(f));
            this.f8286a.f8346z.i = false;
        }

        private float m9852e(float f) {
            float f2 = 0.0f;
            float abs = Math.abs(f);
            if (abs >= ((float) this.f8288c)) {
                if (abs <= ((float) this.f8287b)) {
                    return f;
                }
                f2 = f > 0.0f ? (float) this.f8287b : (float) (-this.f8287b);
            }
            return f2;
        }
    }

    /* compiled from: network_state_during_recording */
    class RunnableProximitySensorTimeout implements Runnable {
        final /* synthetic */ LockScreenService f8289a;

        public RunnableProximitySensorTimeout(LockScreenService lockScreenService) {
            this.f8289a = lockScreenService;
        }

        public void run() {
            this.f8289a.f8328g.a();
            this.f8289a.f8336o.b(this.f8289a.f8318U);
            this.f8289a.f8307J;
        }
    }

    /* compiled from: network_state_during_recording */
    class ScreenOrientationChangeActionReceiver implements ActionReceiver {
        final /* synthetic */ LockScreenService f8290a;
        private int f8291b;

        public ScreenOrientationChangeActionReceiver(LockScreenService lockScreenService, int i) {
            this.f8290a = lockScreenService;
            this.f8291b = i;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1108885774);
            if (context.getResources().getConfiguration().orientation != this.f8291b) {
                this.f8291b = context.getResources().getConfiguration().orientation;
                this.f8290a.f8309L;
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1690728555, a);
        }
    }

    /* compiled from: network_state_during_recording */
    class SettingsSpringListener extends SimpleSpringListener {
        final /* synthetic */ LockScreenService f8292a;

        public SettingsSpringListener(LockScreenService lockScreenService) {
            this.f8292a = lockScreenService;
        }

        public final void m9857a(Spring spring) {
            float d = (float) spring.d();
            if (((double) d) != 0.0d) {
                this.f8292a.f8300C.setPadding((int) (this.f8292a.getResources().getDimension(2131429170) * d), 0, (int) ((1.0f - d) * this.f8292a.getResources().getDimension(2131429152)), 0);
            }
        }
    }

    /* compiled from: network_state_during_recording */
    class SimpleGestureListener extends SimpleOnGestureListener {
        final /* synthetic */ LockScreenService f8293a;

        public SimpleGestureListener(LockScreenService lockScreenService) {
            this.f8293a = lockScreenService;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (LockScreenService.m9944r(this.f8293a) == 3 && this.f8293a.f8299B.getTranslationY() < 0.0f) {
                this.f8293a.ai = true;
            }
            if (this.f8293a.ae != null) {
                this.f8293a.f8300C;
            } else {
                this.f8293a.f8308K.a(0.0d).b(1.0d);
            }
            return true;
        }
    }

    /* compiled from: network_state_during_recording */
    class UserPresentActionReceiver implements ActionReceiver {
        final /* synthetic */ LockScreenService f8294a;

        public UserPresentActionReceiver(LockScreenService lockScreenService) {
            this.f8294a = lockScreenService;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1920577816);
            this.f8294a.stopSelf();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 235193986, a);
        }
    }

    private static <T extends Context> void m9884a(Class<T> cls, T t) {
        m9885a((Object) t, (Context) t);
    }

    public static void m9885a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((LockScreenService) obj).m9877a((BaseFbBroadcastManager) CrossProcessFbBroadcastManager.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), Handler_ForUiThreadMethodAutoProvider.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), DefaultAndroidThreadUtil.a(injectorLike), AnimationUtil.a(injectorLike), KeyguardManagerMethodAutoProvider.a(injectorLike), LayoutInflaterMethodAutoProvider.a(injectorLike), LockMessageLoader.a(injectorLike), LockScreenNotificationsAdapter.m9828a(injectorLike), LockScreenUtil.a(injectorLike), FbWakeLockManager.a(injectorLike), ProximitySensor.a(injectorLike), PushNotificationDbHelper.m9796a(injectorLike), ScreenPowerState.a(injectorLike), ScreenUtil.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), SpringSystem.a(injectorLike), TelephonyManagerMethodAutoProvider.a(injectorLike), WindowManagerMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2952), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    static /* synthetic */ int m9944r(LockScreenService lockScreenService) {
        int i = lockScreenService.ag + 1;
        lockScreenService.ag = i;
        return i;
    }

    public final void m9956a() {
        super.a();
        Class cls = LockScreenService.class;
        m9885a((Object) this, (Context) this);
        this.f8321X = new DynamicSecureBroadcastReceiver(ImmutableMap.of("android.intent.action.CLOSE_SYSTEM_DIALOGS", new CloseSystemDialogsActionReceiver(this), "android.intent.action.USER_PRESENT", new UserPresentActionReceiver(this), "android.intent.action.CONFIGURATION_CHANGED", new ScreenOrientationChangeActionReceiver(this, getResources().getConfiguration().orientation)));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.CONFIGURATION_CHANGED");
        registerReceiver(this.f8321X, intentFilter);
        this.f8320W = this.f8324c.a().a("com.facebook.notifications.lockscreen.ACTION_LOCKSCREEN_NOTIFICATIONS_DISMISS", new LockscreenNotificationsDismissActionReceiver(this)).a();
        this.f8320W.b();
        this.f8342u.listen(this.f8323Z, 32);
        this.f8338q.a(this.aa);
        this.ab = this.f8335n.a(10, "LockscreenOnTouchWakeLock");
        this.ac = this.f8335n.a(1, "LockscreenScreenOnWakeLock");
        this.ad = new CountDownTimer(this, (long) -1, (long) -1) {
            final /* synthetic */ LockScreenService f8264a;

            public void onTick(long j) {
            }

            public void onFinish() {
                this.f8264a.f8308K;
            }
        };
    }

    private void m9877a(FbBroadcastManager fbBroadcastManager, ExecutorService executorService, Handler handler, AnalyticsLogger analyticsLogger, AndroidThreadUtil androidThreadUtil, AnimationUtil animationUtil, KeyguardManager keyguardManager, LayoutInflater layoutInflater, LockMessageLoader lockMessageLoader, LockScreenNotificationsAdapter lockScreenNotificationsAdapter, LockScreenUtil lockScreenUtil, FbWakeLockManager fbWakeLockManager, ProximitySensor proximitySensor, PushNotificationDbHelper pushNotificationDbHelper, ScreenPowerState screenPowerState, ScreenUtil screenUtil, SecureContextHelper secureContextHelper, SpringSystem springSystem, TelephonyManager telephonyManager, WindowManager windowManager, Lazy<PerformanceLogger> lazy, FbErrorReporter fbErrorReporter) {
        this.f8324c = fbBroadcastManager;
        this.f8325d = executorService;
        this.f8326e = handler;
        this.f8327f = analyticsLogger;
        this.f8328g = androidThreadUtil;
        this.f8329h = animationUtil;
        this.f8330i = keyguardManager;
        this.f8331j = layoutInflater;
        this.f8332k = lockMessageLoader;
        this.f8333l = lockScreenNotificationsAdapter;
        this.f8334m = lockScreenUtil;
        this.f8335n = fbWakeLockManager;
        this.f8336o = proximitySensor;
        this.f8337p = pushNotificationDbHelper;
        this.f8338q = screenPowerState;
        this.f8339r = screenUtil;
        this.f8340s = secureContextHelper;
        this.f8341t = springSystem;
        this.f8342u = telephonyManager;
        this.f8343v = windowManager;
        this.f8344w = lazy;
        this.f8345x = fbErrorReporter;
    }

    public final void m9957k() {
        super.k();
        m9908d(false);
        unregisterReceiver(this.f8321X);
        this.f8320W.c();
        this.f8342u.listen(this.f8323Z, 0);
        this.f8338q.b(this.aa);
        if (this.ab.e()) {
            this.ab.d();
        }
        if (this.ac.e()) {
            this.ac.d();
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public final int m9955a(@Nullable Intent intent, int i, int i2) {
        boolean z = false;
        if (intent == null || intent.getAction() == null) {
            boolean z2 = false;
        } else {
            int i3 = 1;
        }
        if (i3 != 0 && !this.f8334m.a(true, m9942q(this))) {
            stopSelf();
            return 2;
        } else if (this.f8323Z.m9848a()) {
            stopSelf();
            return 2;
        } else if (this.am) {
            this.f8334m.a("dismissed", m9945r());
            return 1;
        } else {
            if (i3 != 0 && this.f8334m.c()) {
                z = true;
            }
            m9887a(z);
            return 1;
        }
    }

    private void m9887a(final boolean z) {
        Boolean.valueOf(z);
        LockScreenUtil.a();
        ExecutorDetour.a(this.f8325d, new Runnable(this) {
            final /* synthetic */ LockScreenService f8268b;

            public void run() {
                if (this.f8268b.f8334m.a(true, LockScreenService.m9942q(this.f8268b))) {
                    final List b = LockScreenService.m9942q(this.f8268b);
                    if (b.isEmpty()) {
                        this.f8268b.stopSelf();
                        return;
                    } else {
                        this.f8268b.f8328g.b(new Runnable(this) {
                            final /* synthetic */ C06632 f8266b;

                            public void run() {
                                try {
                                    this.f8266b.f8268b.m9886a(b, z);
                                } catch (Exception e) {
                                    this.f8266b.f8268b.f8345x.a(LockScreenService.f8295a, e.getMessage());
                                    this.f8266b.f8268b.stopSelf();
                                }
                            }
                        });
                        return;
                    }
                }
                this.f8268b.stopSelf();
            }
        }, -1966476826);
    }

    private void m9886a(List<LockScreenNotification> list, boolean z) {
        if (!this.f8330i.inKeyguardRestrictedInputMode()) {
            return;
        }
        if (this.f8333l.isEmpty()) {
            this.f8333l.m9832a((List) list);
            m9888a(z, this.f8334m.e());
            this.ag = 0;
            return;
        }
        this.f8333l.m9832a((List) list);
        if (this.f8298A == null) {
            m9888a(z, false);
            return;
        }
        m9875a(this.f8303F);
        m9928i();
        if (this.af) {
            if (z) {
                this.f8307J;
            }
            this.f8298A.requestLayout();
            return;
        }
        this.f8301D.smoothScrollToPosition(0);
        m9902c(z);
        if (!this.f8346z.a()) {
            return;
        }
        if (this.f8346z.e) {
            m9915f(0.0f);
        } else {
            m9911e(0.0f);
        }
    }

    public static List m9891b(LockScreenService lockScreenService) {
        List a = Lists.a();
        LockScreenUtil lockScreenUtil = lockScreenService.f8334m;
        boolean a2 = lockScreenUtil.d.a(NotificationsPreferenceConstants.C, true);
        if (!(a2 || null == null)) {
            lockScreenUtil.a("user turned off facebook notification setting", new String[0]);
        }
        if (a2) {
            Collection a3 = lockScreenService.f8337p.m9798a();
            Integer.valueOf(a3.size());
            a.addAll(a3);
        }
        lockScreenUtil = lockScreenService.f8334m;
        a2 = lockScreenUtil.d.a(NotificationsPreferenceConstants.D, true);
        if (!(a2 || null == null)) {
            lockScreenUtil.a("user turned off message notification setting", new String[0]);
        }
        if (a2) {
            ImmutableList copyOf = ImmutableList.copyOf(lockScreenService.f8332k.c.values());
            Integer.valueOf(copyOf.size());
            a.addAll(copyOf);
        }
        Collections.sort(a, new C06643(lockScreenService));
        return a;
    }

    private void m9898c() {
        this.f8324c.a(new Intent("com.facebook.notifications.lockscreen.ACTION_LOCKSCREEN_NOTIFICATIONS_VIEW_ATTACHED"));
    }

    private void m9871a(View view) {
        int c = this.f8339r.c();
        this.f8299B = (ViewGroup) view;
        this.f8299B.measure(MeasureSpec.makeMeasureSpec(c, 1073741824), 0);
        this.ah = this.f8299B.getMeasuredHeight();
        TextView textView = (TextView) this.f8299B.findViewById(2131564287);
        if (textView.getLineCount() == 2) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop() / 2, textView.getPaddingRight(), textView.getPaddingBottom() / 2);
            this.f8299B.measure(MeasureSpec.makeMeasureSpec(c, 1073741824), 0);
            this.ah = this.f8299B.getMeasuredHeight();
        }
        this.f8299B.findViewById(2131559948).setOnClickListener(new C06654(this));
        this.f8299B.setTranslationY((float) (-this.ah));
        this.f8299B.setVisibility(0);
    }

    public static void m9905d(LockScreenService lockScreenService) {
        if (lockScreenService.f8298A != null) {
            int dimensionPixelSize = lockScreenService.getResources().getDimensionPixelSize(2131429178);
            if (dimensionPixelSize == 0) {
                dimensionPixelSize = -1;
            }
            int e = lockScreenService.m9909e();
            lockScreenService.f8299B.getLayoutParams().width = dimensionPixelSize;
            lockScreenService.f8304G.getLayoutParams().width = e;
            if (lockScreenService.f8317T != null) {
                lockScreenService.f8317T.m9824a(e);
            }
            lockScreenService.f8298A.requestLayout();
        }
    }

    private int m9909e() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131429177);
        return dimensionPixelSize == 0 ? -1 : dimensionPixelSize;
    }

    private void m9888a(boolean z, boolean z2) {
        if (this.f8298A == null) {
            this.f8298A = (LockScreenFrameLayout) this.f8331j.inflate(2130905495, null);
            this.f8298A.f8185h = new C06666(this);
        }
        this.f8298A.f8184g = new C06677(this);
        m9871a(this.f8298A.findViewById(2131564279));
        this.f8304G = (ViewGroup) this.f8298A.findViewById(2131564281);
        this.f8302E = (ViewGroup) this.f8298A.findViewById(2131564282);
        this.f8306I = (ViewGroup) this.f8298A.findViewById(2131564280);
        this.f8303F = (TextView) this.f8298A.findViewById(2131563640);
        m9875a(this.f8303F);
        this.f8302E.setOnTouchListener(new C06688(this));
        this.f8301D = (ListView) this.f8298A.findViewById(2131564283);
        this.f8301D.setAdapter(this.f8333l);
        this.f8333l.f8242b = new C06699(this);
        m9928i();
        this.f8305H = (TextView) this.f8298A.findViewById(2131564284);
        this.f8305H.setText(getApplicationContext().getResources().getString(2131233684));
        this.f8300C = this.f8298A.findViewById(2131563641);
        this.f8300C.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LockScreenService f8251a;

            {
                this.f8251a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1814611489);
                this.f8251a.ae;
                Logger.a(2, EntryType.UI_INPUT_END, -872179310, a);
            }
        });
        this.f8298A.setOnTouchListener(this.f8322Y);
        m9902c(z);
        m9896b(z2);
        if (z2) {
            this.f8300C.post(new Runnable(this) {
                final /* synthetic */ LockScreenService f8253a;

                /* compiled from: network_state_during_recording */
                class C06601 implements OnTooltipClickListener {
                    final /* synthetic */ AnonymousClass11 f8252a;

                    C06601(AnonymousClass11 anonymousClass11) {
                        this.f8252a = anonymousClass11;
                    }

                    public final void m9833a() {
                        this.f8252a.f8253a.f8300C;
                    }
                }

                {
                    this.f8253a = r1;
                }

                public void run() {
                    this.f8253a.f8300C.setPadding((int) this.f8253a.getResources().getDimension(2131429151), 0, (int) this.f8253a.getResources().getDimension(2131429152), 0);
                    int[] iArr = new int[2];
                    this.f8253a.f8304G.getLocationOnScreen(iArr);
                    DisplayMetrics displayMetrics = this.f8253a.f8300C.getResources().getDisplayMetrics();
                    int i = iArr[0];
                    this.f8253a.f8310M.a(0.0d).l();
                    this.f8253a.ae = new Tooltip(this.f8253a.f8300C.getContext(), 2);
                    this.f8253a.ae.a(i, 0, (displayMetrics.widthPixels - i) - this.f8253a.f8304G.getMeasuredWidth(), 0);
                    this.f8253a.ae.s = 2010;
                    this.f8253a.ae.d(false);
                    this.f8253a.ae.b(0.0f);
                    this.f8253a.ae.t = -1;
                    this.f8253a.ae.b(2131233669);
                    this.f8253a.ae.a(Position.ABOVE);
                    this.f8253a.ae.f(this.f8253a.f8300C);
                    this.f8253a.ae.a(new C06601(this));
                    this.f8253a.f8334m.d.edit().putBoolean(NotificationsPreferenceConstants.B, false).commit();
                }
            });
        }
        final int dimension = (int) getResources().getDimension(2131429144);
        final int i = (int) ((getResources().getDisplayMetrics().density * 25.0f) + 0.5f);
        this.f8300C.addOnLayoutChangeListener(new OnLayoutChangeListener(this) {
            final /* synthetic */ LockScreenService f8256c;

            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (i2 != i6 || i3 != i7) {
                    Rect rect = new Rect();
                    View view2 = (View) this.f8256c.f8300C.getParent();
                    this.f8256c.f8300C.getHitRect(rect);
                    rect.right += view2.getLeft() + dimension;
                    rect.top = (view2.getTop() - i) + rect.top;
                    this.f8256c.f8304G.setTouchDelegate(new TouchDelegate(rect, this.f8256c.f8300C));
                }
            }
        });
        this.f8298A.f8186i = new OnBackPressedListener(this) {
            final /* synthetic */ LockScreenService f8257a;

            {
                this.f8257a = r1;
            }

            public final boolean mo450a() {
                if (this.f8257a.f8317T == null) {
                    return false;
                }
                Object obj;
                if (this.f8257a.f8317T.f8216r == AnimationState.REVEALING) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    return false;
                }
                LockScreenService.m9917f(this.f8257a, false);
                return true;
            }
        };
    }

    private void m9896b(boolean z) {
        float d = (float) this.f8339r.d();
        this.f8311N = ((float) this.f8339r.c()) / 4.0f;
        this.f8312O = d / 4.0f;
        this.f8314Q = new GestureDetector(this, new SimpleGestureListener(this));
        this.f8346z = new TouchSlopDetector();
        this.f8346z.a = ViewConfiguration.get(getBaseContext()).getScaledTouchSlop();
        this.f8316S = new PopupDragGestureListener(this, this);
        this.f8315R = new DragDetector(this.f8316S, this.f8346z);
        this.f8313P = new DismissSpringListener(this);
        Spring a = this.f8341t.a().a(f8296b);
        a.l = 0.1d;
        a = a;
        a.k = 0.1d;
        a = a;
        a.c = true;
        this.f8307J = a;
        this.f8307J.a(this.f8313P);
        a = this.f8341t.a().a(f8296b);
        a.l = 0.1d;
        a = a;
        a.k = 0.1d;
        a = a;
        a.c = true;
        this.f8308K = a;
        this.f8308K.a(new BounceDownSpringListener(this));
        a = this.f8341t.a().a(f8296b);
        a.l = 0.1d;
        a = a;
        a.k = 0.1d;
        a = a;
        a.c = true;
        this.f8309L = a.a(0.0d);
        this.f8309L.a(new HideBannerSpringListener(this));
        if (z) {
            a = this.f8341t.a().a(f8296b);
            a.l = 0.1d;
            a = a;
            a.k = 0.1d;
            a = a;
            a.c = true;
            this.f8310M = a.a(0.0d);
            this.f8310M.a(new SettingsSpringListener(this));
        }
    }

    private void m9873a(ViewGroup viewGroup, int i) {
        m9874a(viewGroup, (LockScreenNotification) this.f8333l.getItem(i));
    }

    private void m9874a(ViewGroup viewGroup, LockScreenNotification lockScreenNotification) {
        if (viewGroup != null) {
            m9878a(lockScreenNotification);
        }
    }

    private void m9902c(boolean z) {
        if (!this.f8323Z.m9848a()) {
            this.f8304G.setVisibility(0);
            this.f8306I.setVisibility(8);
            if (!z || this.f8338q.a()) {
                this.f8343v.addView(this.f8298A, m9927i(false));
                this.af = true;
                m9872a(this.f8298A);
                m9898c();
                m9921g(false);
            } else if (this.f8336o.a(this.f8318U)) {
                HandlerDetour.b(this.f8326e, this.f8319V, 1000, -1815976578);
            } else {
                this.f8307J;
            }
        }
    }

    private void m9872a(ViewGroup viewGroup) {
        viewGroup.setFocusableInTouchMode(true);
        viewGroup.requestFocus();
        viewGroup.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ LockScreenService f8258a;

            {
                this.f8258a = r1;
            }

            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                switch (i) {
                    case 4:
                        LockScreenService.m9925h(this.f8258a, false);
                        this.f8258a.m9908d(true);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    public static void m9916f(LockScreenService lockScreenService) {
        if ((!lockScreenService.af || VERSION.SDK_INT >= 19) && !lockScreenService.f8338q.a() && !lockScreenService.f8323Z.m9848a()) {
            if (lockScreenService.af) {
                try {
                    lockScreenService.f8343v.removeView(lockScreenService.f8298A);
                } catch (Exception e) {
                }
            }
            lockScreenService.f8343v.addView(lockScreenService.f8298A, m9927i(true));
            lockScreenService.af = true;
            lockScreenService.m9872a(lockScreenService.f8298A);
            if (lockScreenService.ae != null) {
                lockScreenService.ae.l();
                if (lockScreenService.f8300C != null) {
                    lockScreenService.ae.f(lockScreenService.f8300C);
                }
            }
            lockScreenService.m9898c();
            if (LockScreenUtil.f() == -1 || LockScreenUtil.g()) {
                lockScreenService.ac.a(10000);
            } else {
                lockScreenService.ac.c();
                lockScreenService.ad.start();
            }
            lockScreenService.m9941p();
        }
    }

    public static void m9920g(LockScreenService lockScreenService) {
        LockScreenFrameLayout lockScreenFrameLayout = lockScreenService.f8298A;
        lockScreenService.ac.d();
        LayoutParams i = m9927i(false);
        lockScreenService.f8343v.removeView(lockScreenFrameLayout);
        lockScreenService.f8343v.addView(lockScreenFrameLayout, i);
        lockScreenService.m9898c();
    }

    private synchronized void m9908d(boolean z) {
        this.am = true;
        if (this.ae != null) {
            this.ae.l();
            this.ae = null;
        }
        this.f8317T = null;
        if (z) {
            this.f8332k.b();
            m9939o();
        }
        if (this.f8298A != null && this.af) {
            try {
                this.f8343v.removeView(this.f8298A);
            } catch (Throwable e) {
                BLog.c(f8295a, e, "Notification View already removed", new Object[0]);
            }
            this.f8298A = null;
            this.af = false;
        }
        if (this.f8307J != null) {
            this.f8307J.m();
        }
        if (this.f8315R != null) {
            this.f8315R.a();
        }
    }

    private void m9878a(LockScreenNotification lockScreenNotification) {
        if (VERSION.SDK_INT >= 18 && !this.f8330i.isKeyguardSecure()) {
            ((PerformanceLogger) this.f8344w.get()).d(3473415, "NotifLockscreenPermalinkLoadTime");
        }
        HoneyClientEvent a = this.f8333l.m9831a(lockScreenNotification);
        if (a != null) {
            a.a("lockscreen_notification_count", this.f8333l.getCount());
            this.f8327f.c(a);
        }
        m9908d(true);
        if (VERSION.SDK_INT >= 18) {
            m9924h();
        }
    }

    @TargetApi(18)
    private void m9924h() {
        if (this.f8330i.isKeyguardLocked() && !this.f8330i.isKeyguardSecure()) {
            Intent intent = new Intent(this, LockScreenDismissKeyguardActivity.class);
            intent.setFlags(268435456);
            this.f8340s.a(intent, this);
        }
    }

    private void m9928i() {
        if (this.f8301D != null && this.f8333l.getCount() > 3) {
            View view = this.f8333l.getView(0, null, this.f8301D);
            if (view != null) {
                view.measure(0, 0);
                int measuredHeight = view.getMeasuredHeight();
                this.f8301D.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) ((((float) measuredHeight) * 0.75f) + ((float) (measuredHeight * 3)))));
            }
        }
    }

    private void m9875a(TextView textView) {
        int count = this.f8333l.getCount();
        textView.setText(getApplicationContext().getResources().getQuantityString(2131689557, count, new Object[]{Integer.valueOf(count)}));
    }

    public static void m9931j(LockScreenService lockScreenService) {
        if (lockScreenService.ae != null) {
            lockScreenService.ae.l();
            lockScreenService.ae = null;
        }
        lockScreenService.f8310M.b(1.0d);
    }

    public static void m9935m(LockScreenService lockScreenService) {
        lockScreenService.m9947s();
        if (lockScreenService.f8317T == null) {
            lockScreenService.f8317T = new LockScreenSettingsDialog(lockScreenService);
            CustomDialog customDialog = lockScreenService.f8317T;
            ViewGroup viewGroup = lockScreenService.f8306I;
            if (customDialog.f8215q != viewGroup) {
                if (customDialog.f8215q != null) {
                    customDialog.f8215q.removeView(customDialog);
                }
                customDialog.f8215q = viewGroup;
                customDialog.f8215q.addView(customDialog, new FrameLayout.LayoutParams(-1, -1));
            }
            customDialog = customDialog;
            customDialog.f8214p = AnimationType.HOOK_SHOT_BOTTOM;
            customDialog = customDialog;
            customDialog.f8202d.a(f8297y);
            customDialog.f8213o = new Object(lockScreenService) {
                final /* synthetic */ LockScreenService f8259a;

                {
                    this.f8259a = r1;
                }

                public final void m9835a() {
                    this.f8259a.f8306I.setVisibility(4);
                }

                public final void m9836b() {
                    LockScreenService.m9942q(this.f8259a);
                }

                public final void m9837c() {
                    LockScreenService.m9942q(this.f8259a);
                }
            };
            lockScreenService.f8317T.setBackground(null);
            CustomDialog.m9810a(lockScreenService.f8317T.f8201c, null);
            lockScreenService.f8317T.f8225i = new OnClickListener(lockScreenService) {
                final /* synthetic */ LockScreenService f8260a;

                {
                    this.f8260a = r1;
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1687994225);
                    this.f8260a.m9913e(false);
                    LockScreenService.m9942q(this.f8260a);
                    Logger.a(2, EntryType.UI_INPUT_END, 1583414982, a);
                }
            };
            lockScreenService.f8317T.m9824a(lockScreenService.m9909e());
        } else {
            lockScreenService.f8317T.m9825b();
        }
        lockScreenService.f8317T.m9818b(false);
        lockScreenService.m9913e(true);
        AnimatorSet animatorSet = new AnimatorSet();
        r1 = new Animator[3];
        r1[0] = ObjectAnimator.ofFloat(lockScreenService.f8304G, "scaleX", new float[]{0.85f});
        r1[1] = ObjectAnimator.ofFloat(lockScreenService.f8304G, "scaleY", new float[]{0.85f});
        r1[2] = ObjectAnimator.ofFloat(lockScreenService.f8304G, "alpha", new float[]{0.0f});
        animatorSet.playTogether(r1);
        animatorSet.addListener(new AnimatorListenerAdapter(lockScreenService) {
            final /* synthetic */ LockScreenService f8261a;

            {
                this.f8261a = r1;
            }

            public void onAnimationEnd(Animator animator) {
                this.f8261a.f8304G.setVisibility(4);
                this.f8261a.f8306I.setVisibility(0);
                if (this.f8261a.f8317T != null) {
                    this.f8261a.f8317T.m9817a(true);
                }
            }
        });
        animatorSet.setDuration(150).start();
    }

    private void m9913e(boolean z) {
        if (this.f8298A != null) {
            this.f8298A.m9805a(z);
        }
    }

    private void m9936n() {
        m9917f(this, true);
    }

    public static void m9917f(LockScreenService lockScreenService, boolean z) {
        if (lockScreenService.f8317T != null) {
            lockScreenService.f8317T.m9818b(z);
            if (lockScreenService.f8334m.b(false)) {
                lockScreenService.f8304G.setVisibility(0);
                AnimatorSet animatorSet = new AnimatorSet();
                r1 = new Animator[3];
                r1[0] = ObjectAnimator.ofFloat(lockScreenService.f8304G, "scaleX", new float[]{1.0f});
                r1[1] = ObjectAnimator.ofFloat(lockScreenService.f8304G, "scaleY", new float[]{1.0f});
                r1[2] = ObjectAnimator.ofFloat(lockScreenService.f8304G, "alpha", new float[]{1.0f});
                animatorSet.playTogether(r1);
                animatorSet.addListener(new AnimatorListenerAdapter(lockScreenService) {
                    final /* synthetic */ LockScreenService f8262a;

                    {
                        this.f8262a = r1;
                    }

                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        this.f8262a.m9887a(this.f8262a.f8334m.c());
                    }
                });
                animatorSet.setDuration(150).start();
                return;
            }
            lockScreenService.stopSelf();
        }
    }

    private void m9939o() {
        ExecutorDetour.a(this.f8325d, new Runnable(this) {
            final /* synthetic */ LockScreenService f8263a;

            {
                this.f8263a = r1;
            }

            public void run() {
                this.f8263a.f8337p.m9799b();
            }
        }, 278372469);
    }

    private void m9921g(boolean z) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("lockscreen_notification_displayed");
        honeyClientEvent.c = "notifications";
        honeyClientEvent = honeyClientEvent.a("lockscreen_notification_count", this.f8333l.getCount()).a("nux", z);
        m9876a(honeyClientEvent);
        this.f8327f.c(honeyClientEvent);
    }

    private void m9941p() {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("lockscreen_notification_screen_on");
        honeyClientEvent.c = "notifications";
        this.f8327f.c(honeyClientEvent.a("lockscreen_notification_count", this.f8333l.getCount()));
    }

    public static void m9925h(LockScreenService lockScreenService, boolean z) {
        HoneyClientEvent a = new HoneyClientEvent("lockscreen_notification_dismiss").a("lockscreen_notification_count", lockScreenService.f8333l.getCount()).a("swipe", z);
        lockScreenService.m9876a(a);
        lockScreenService.f8327f.c(a);
    }

    private void m9876a(HoneyClientEvent honeyClientEvent) {
        String[] r = m9945r();
        int length = r.length;
        for (int i = 0; i < length; i += 2) {
            honeyClientEvent.b(r[i], r[i + 1]);
        }
    }

    @Nullable
    public static String m9942q(LockScreenService lockScreenService) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = lockScreenService.f8333l.getCount();
        int i = 0;
        while (i < count) {
            try {
                LockScreenNotification lockScreenNotification = (LockScreenNotification) lockScreenService.f8333l.getItem(i);
                if (lockScreenNotification instanceof PushNotification) {
                    PushNotification pushNotification = (PushNotification) lockScreenNotification;
                    if (pushNotification.f8236i != null) {
                        if (stringBuilder.length() > 0) {
                            stringBuilder.append(',');
                        }
                        stringBuilder.append(pushNotification.f8236i);
                    }
                }
                i++;
            } catch (Throwable th) {
                return null;
            }
        }
        return stringBuilder.toString();
    }

    private String[] m9945r() {
        int i = 2;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        int count = this.f8333l.getCount();
        for (int i2 = 0; i2 < count; i2++) {
            LockScreenNotification lockScreenNotification = (LockScreenNotification) this.f8333l.getItem(i2);
            if (lockScreenNotification instanceof PushNotification) {
                PushNotification pushNotification = (PushNotification) lockScreenNotification;
                if (pushNotification.f8236i != null) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(',');
                    }
                    stringBuilder.append(pushNotification.f8236i);
                }
                if (!(pushNotification.f8234g == null || TrackableFeedProps.a(pushNotification.f8234g) == null)) {
                    if (stringBuilder2.length() > 0) {
                        stringBuilder2.append(',');
                    }
                    stringBuilder2.append(TrackableFeedProps.a(pushNotification.f8234g));
                }
            }
        }
        if (stringBuilder.length() == 0 && stringBuilder2.length() == 0) {
            return new String[0];
        }
        int i3 = (stringBuilder.length() <= 0 || stringBuilder2.length() <= 0) ? 2 : 4;
        String[] strArr = new String[i3];
        if (stringBuilder.length() > 0) {
            strArr[0] = "ndid";
            strArr[1] = stringBuilder.toString();
        } else {
            i = 0;
        }
        if (stringBuilder2.length() <= 0) {
            return strArr;
        }
        int i4 = i + 1;
        strArr[i] = "notification_tracking";
        strArr[i4] = stringBuilder2.toString();
        return strArr;
    }

    private void m9947s() {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("lockscreen_notification_setting_click");
        honeyClientEvent.c = "notifications";
        this.f8327f.c(honeyClientEvent);
    }

    private void m9869a(float f) {
        if (!this.al) {
            if (this.f8307J.k() || !this.aj) {
                this.aj = false;
                this.ak = true;
                this.f8307J.a((double) (((float) this.f8307J.d()) - f)).l();
            }
        }
    }

    private void m9892b(float f) {
        if (!this.al) {
            if (this.f8307J.k() || !this.ak) {
                this.aj = true;
                this.ak = false;
                this.f8307J.a((double) (((float) this.f8307J.d()) - f)).l();
            }
        }
    }

    private void m9899c(float f) {
        boolean z = true;
        double d = this.f8307J.d();
        double abs = Math.abs(this.f8307J.d());
        if (f != 0.0f) {
            float abs2 = Math.abs(f);
            if (!m9889a((double) f, d) || (abs2 <= 3500.0f && abs <= ((double) this.f8312O))) {
                m9911e(f);
                return;
            }
            if (d < 0.0d) {
                z = false;
            }
            m9870a(f, z);
        } else if (abs > ((double) this.f8312O)) {
            if (d < 0.0d) {
                z = false;
            }
            m9870a(0.0f, z);
        } else {
            m9911e(f);
        }
    }

    private void m9904d(float f) {
        boolean z = true;
        double d = this.f8307J.d();
        double abs = Math.abs(this.f8307J.d());
        if (f != 0.0f) {
            float abs2 = Math.abs(f);
            if (!m9889a((double) f, d) || (abs2 <= 3500.0f && abs <= ((double) this.f8311N))) {
                m9915f(f);
                return;
            }
            if (d < 0.0d) {
                z = false;
            }
            m9893b(f, z);
        } else if (abs > ((double) this.f8311N)) {
            if (d < 0.0d) {
                z = false;
            }
            m9893b(0.0f, z);
        } else {
            m9915f(f);
        }
    }

    private void m9870a(float f, boolean z) {
        float d = (float) this.f8339r.d();
        if (!z) {
            d = -d;
        }
        this.f8307J.c((double) f).b((double) d);
        m9925h(this, true);
        this.al = true;
    }

    private void m9893b(float f, boolean z) {
        float c = (float) this.f8339r.c();
        if (!z) {
            c = -c;
        }
        this.f8307J.c((double) f).b((double) c);
        m9925h(this, true);
        this.al = true;
    }

    private void m9911e(float f) {
        this.f8307J.c((double) f).b(0.0d);
    }

    private void m9915f(float f) {
        this.f8307J.c((double) f).b(0.0d);
    }

    private static boolean m9889a(double d, double d2) {
        return ((d > 0.0d ? 1 : (d == 0.0d ? 0 : -1)) >= 0) == ((d2 > 0.0d ? 1 : (d2 == 0.0d ? 0 : -1)) >= 0);
    }

    private static WindowManager.LayoutParams m9927i(boolean z) {
        int i = 16779296;
        if (VERSION.SDK_INT >= 19) {
            i = 218105888;
        }
        if (z) {
            i |= 2097152;
        }
        return new WindowManager.LayoutParams(-1, -1, 2010, i, -3);
    }
}
