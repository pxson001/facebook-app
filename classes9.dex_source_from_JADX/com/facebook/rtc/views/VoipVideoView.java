package com.facebook.rtc.views;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.auth.annotations.LoggedInUserKey;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.common.executors.BackgroundExecutorService;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.executors.ScheduledExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClock;
import com.facebook.common.util.FindViewUtil;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.badges.BadgesExperimentController;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rtc.activities.WebrtcIncallActivity.AnonymousClass15;
import com.facebook.rtc.activities.WebrtcIncallActivity.C22604;
import com.facebook.rtc.customui.RtcActionableTooltip;
import com.facebook.rtc.customui.RtcActionableTooltip.OnActionClickListener;
import com.facebook.rtc.dialogs.RtcBluetoothSelectorDialog;
import com.facebook.rtc.dialogs.RtcBluetoothSelectorDialog.UpdateButtonsCallback;
import com.facebook.rtc.dialogs.RtcBluetoothSelectorDialogProvider;
import com.facebook.rtc.fbwebrtc.WebrtcPrefKeys;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler.NameChangedListener;
import com.facebook.rtc.fbwebrtc.abtests.ExperimentsForRtcModule;
import com.facebook.rtc.fbwebrtc.abtests.RtcRenderThreadExperiment.RtcRenderThreadMode;
import com.facebook.rtc.fragments.WebrtcVideoChatHeadNuxFragment;
import com.facebook.rtc.views.RtcActionBar.Listener;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileView;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.tiles.TileBadge;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.inject.Provider;
import org.webrtc.videoengine.ViEAndroidGLES20;
import org.webrtc.videoengine.ViEAndroidGLES20SurfaceView;

/* compiled from: app_fbid */
public class VoipVideoView extends RelativeLayout implements OnActionClickListener, WebrtcVideoChatHeadNuxFragment.OnActionClickListener {
    private static final Class<?> f20290m = VoipVideoView.class;
    public VoipConnectionBanner f20291A;
    public AwakeTimeSinceBootClock f20292B;
    public RtcActionBar f20293C;
    private UserTileView f20294D;
    private Animation f20295E;
    private Animation f20296F;
    private Animation f20297G;
    private Animation f20298H;
    public C22604 f20299I;
    private ScheduledFuture<?> f20300J;
    public boolean f20301K = false;
    public NameChangedListener f20302L;
    public long f20303M = 0;
    public boolean f20304N = false;
    @Inject
    @ForUiThread
    ScheduledExecutorService f20305a;
    @Inject
    WindowManager f20306b;
    @BackgroundExecutorService
    @Inject
    ScheduledExecutorService f20307c;
    @Inject
    @ForUiThread
    Executor f20308d;
    @Inject
    RtcBluetoothSelectorDialogProvider f20309e;
    @Inject
    BadgesExperimentController f20310f;
    @Inject
    public FbSharedPreferences f20311g;
    @Inject
    QeAccessor f20312h;
    @Inject
    @LoggedInUserKey
    Provider<UserKey> f20313i;
    @Inject
    FbHandlerThreadFactory f20314j;
    public Tooltip f20315k = null;
    WebrtcVideoChatHeadNuxFragment f20316l = null;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<WebrtcUiHandler> f20317n = UltralightRuntime.b;
    public RtcBluetoothSelectorDialog f20318o;
    public Future<?> f20319p;
    public ViEAndroidGLES20 f20320q;
    public ViEAndroidGLES20SurfaceView f20321r;
    public View f20322s;
    public TextView f20323t;
    public AnonymousClass15 f20324u;
    public IncallControlButtonsView f20325v;
    public View f20326w;
    public View f20327x;
    private TextView f20328y;
    public boolean f20329z;

    /* compiled from: app_fbid */
    class C23851 implements UpdateButtonsCallback {
        final /* synthetic */ VoipVideoView f20279a;

        C23851(VoipVideoView voipVideoView) {
            this.f20279a = voipVideoView;
        }

        public final void mo774a() {
            this.f20279a.m19927j();
        }
    }

    /* compiled from: app_fbid */
    class C23862 implements Runnable {
        final /* synthetic */ VoipVideoView f20280a;

        C23862(VoipVideoView voipVideoView) {
            this.f20280a = voipVideoView;
        }

        public void run() {
            if (((WebrtcUiHandler) this.f20280a.f20317n.get()).az()) {
                VoipVideoView.m19912s(this.f20280a);
            }
        }
    }

    /* compiled from: app_fbid */
    class C23873 implements NameChangedListener {
        final /* synthetic */ VoipVideoView f20281a;

        C23873(VoipVideoView voipVideoView) {
            this.f20281a = voipVideoView;
        }

        public final void mo804a() {
            VoipVideoView.m19912s(this.f20281a);
        }
    }

    /* compiled from: app_fbid */
    class C23884 implements OnClickListener {
        final /* synthetic */ VoipVideoView f20282a;

        C23884(VoipVideoView voipVideoView) {
            this.f20282a = voipVideoView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 43806681);
            if (((WebrtcUiHandler) this.f20282a.f20317n.get()).az()) {
                Logger.a(2, EntryType.UI_INPUT_END, 1925904751, a);
                return;
            }
            if (this.f20282a.f20325v.isShown()) {
                VoipVideoView.m19902B(this.f20282a);
            } else {
                VoipVideoView.m19909d(this.f20282a, 5000);
            }
            VoipVideoView.m19915w(this.f20282a);
            LogUtils.a(-1928390081, a);
        }
    }

    /* compiled from: app_fbid */
    public class C23895 implements OnGlobalLayoutListener {
        final /* synthetic */ VoipVideoView f20283a;

        public C23895(VoipVideoView voipVideoView) {
            this.f20283a = voipVideoView;
        }

        public void onGlobalLayout() {
            CustomViewUtils.a(this.f20283a.f20325v, this);
            VoipVideoView.m19915w(this.f20283a);
        }
    }

    /* compiled from: app_fbid */
    public class C23906 implements Listener {
        final /* synthetic */ VoipVideoView f20284a;

        public C23906(VoipVideoView voipVideoView) {
            this.f20284a = voipVideoView;
        }

        public final void mo771a() {
            this.f20284a.f20299I.m19130e();
        }

        public final void mo772b() {
            this.f20284a.m19929p();
        }

        public final void mo773c() {
            this.f20284a.f20318o.m19340a();
        }
    }

    /* compiled from: app_fbid */
    class C23917 implements Runnable {
        final /* synthetic */ VoipVideoView f20285a;

        C23917(VoipVideoView voipVideoView) {
            this.f20285a = voipVideoView;
        }

        public void run() {
            long lastRedrawTime;
            VoipVideoView voipVideoView = this.f20285a;
            if (voipVideoView.f20304N) {
                lastRedrawTime = voipVideoView.f20321r.getLastRedrawTime();
            } else {
                lastRedrawTime = voipVideoView.f20320q.getLastRedrawTime();
            }
            long j = lastRedrawTime;
            int i = (j <= 0 || this.f20285a.f20292B.now() - j <= 5000) ? 0 : 1;
            if ((j != 0 || this.f20285a.f20301K) && i == 0) {
                VoipVideoView.m19905a(this.f20285a, 8, 0);
            } else {
                VoipVideoView.m19905a(this.f20285a, 0, 2131232087);
            }
        }
    }

    /* compiled from: app_fbid */
    class C23939 implements Runnable {
        final /* synthetic */ VoipVideoView f20289a;

        C23939(VoipVideoView voipVideoView) {
            this.f20289a = voipVideoView;
        }

        public void run() {
            VoipVideoView.m19902B(this.f20289a);
            VoipVideoView.m19915w(this.f20289a);
            this.f20289a.f20319p = null;
        }
    }

    public static void m19906a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((VoipVideoView) obj).m19907a((ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), WindowManagerMethodAutoProvider.b(fbInjector), ScheduledExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(fbInjector), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), (RtcBluetoothSelectorDialogProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(RtcBluetoothSelectorDialogProvider.class), BadgesExperimentController.m8365b(fbInjector), (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), IdBasedProvider.a(fbInjector, 3597), FbHandlerThreadFactory.a(fbInjector), IdBasedLazy.a(fbInjector, 10375));
    }

    public VoipVideoView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(2130907757, this);
        this.f20320q = (ViEAndroidGLES20) FindViewUtil.b(this, 2131568483);
        this.f20321r = (ViEAndroidGLES20SurfaceView) FindViewUtil.b(this, 2131568484);
        this.f20322s = FindViewUtil.b(this, 2131568486);
        this.f20323t = (TextView) FindViewUtil.b(this, 2131568487);
        this.f20328y = (TextView) FindViewUtil.b(this, 2131568489);
        this.f20326w = FindViewUtil.b(this, 2131568488);
        this.f20294D = (UserTileView) FindViewUtil.b(this, 2131568490);
        this.f20291A = (VoipConnectionBanner) FindViewUtil.b(this, 2131568491);
        this.f20325v = (IncallControlButtonsView) FindViewUtil.b(this, 2131568493);
        this.f20327x = FindViewUtil.b(this, 2131568485);
        this.f20295E = AnimationUtils.loadAnimation(context, 2130968651);
        this.f20296F = AnimationUtils.loadAnimation(context, 2130968653);
        this.f20297G = AnimationUtils.loadAnimation(context, 2130968771);
        this.f20298H = AnimationUtils.loadAnimation(context, 2130968773);
    }

    public View getPeerVideoView() {
        if (this.f20304N) {
            return this.f20321r;
        }
        return this.f20320q;
    }

    public final void m19922c() {
        Class cls = VoipVideoView.class;
        m19906a((Object) this, getContext());
        int a = this.f20312h.a(Liveness.Cached, ExperimentsForRtcModule.bT, 0);
        this.f20304N = a == RtcRenderThreadMode.SURFACE_VIEW.ordinal();
        if (this.f20304N) {
            this.f20321r.f21115n = false;
        } else {
            this.f20320q.f21062C = false;
            this.f20320q.m21556a(a, this.f20314j);
        }
        this.f20318o = this.f20309e.m19341a(Boolean.FALSE, new C23851(this));
        this.f20292B = AwakeTimeSinceBootClock.INSTANCE;
        m19911r();
        if (m19904D()) {
            m19920a(getContext().getString(2131232002), true);
            m19923d();
            this.f20305a.schedule(new C23862(this), (long) getDeferredMillisecondsForVideoCall(), TimeUnit.MILLISECONDS);
        } else if (((WebrtcUiHandler) this.f20317n.get()).az()) {
            m19920a(getContext().getString(2131232001), true);
        }
        this.f20302L = new C23873(this);
        ((WebrtcUiHandler) this.f20317n.get()).m19455a(this.f20302L);
        if (this.f20293C == null) {
            this.f20293C = (RtcActionBar) FindViewUtil.b(this, 2131568492);
            this.f20293C.f20099u = new C23906(this);
        }
        this.f20291A.bringToFront();
        Display defaultDisplay = this.f20306b.getDefaultDisplay();
        LayoutParams layoutParams = (LayoutParams) this.f20325v.getLayoutParams();
        layoutParams.width = Math.min(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        this.f20325v.setLayoutParams(layoutParams);
        m19909d(this, 5000);
        setOnClickListener(new C23884(this));
        m19926h();
    }

    public final void m19923d() {
        this.f20303M = ((WebrtcUiHandler) this.f20317n.get()).aE() + ((long) this.f20312h.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.c, 0));
    }

    private void m19911r() {
        this.f20294D.setParams(UserTileViewParams.a(new UserKey(Type.FACEBOOK, Long.toString(((WebrtcUiHandler) this.f20317n.get()).ai)), this.f20310f.m8366a() ? TileBadge.NONE : TileBadge.MESSENGER));
    }

    public void onWindowFocusChanged(boolean z) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -895076987);
        super.onWindowFocusChanged(z);
        if (z) {
            m19915w(this);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1375569414, a);
    }

    public final void m19924e() {
        if (((WebrtcUiHandler) this.f20317n.get()).m19435G()) {
            m19916z();
            this.f20326w.setVisibility(8);
            return;
        }
        m19901A();
        if (this.f20322s.isShown()) {
            this.f20322s.setVisibility(8);
        }
        m19912s(this);
        this.f20326w.setVisibility(0);
    }

    public static void m19912s(VoipVideoView voipVideoView) {
        if (!((WebrtcUiHandler) voipVideoView.f20317n.get()).aB()) {
            voipVideoView.m19920a(voipVideoView.getContext().getString(2131231979, new Object[]{((WebrtcUiHandler) voipVideoView.f20317n.get()).aj()}), false);
        } else if (voipVideoView.m19904D()) {
            Object obj;
            if (((WebrtcUiHandler) voipVideoView.f20317n.get()).aE() > voipVideoView.f20303M) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                voipVideoView.m19913t();
            }
        } else {
            voipVideoView.m19913t();
        }
    }

    private void m19913t() {
        if (((WebrtcUiHandler) this.f20317n.get()).aA()) {
            m19920a(getContext().getString(2131232003), true);
        } else {
            m19920a(getContext().getString(2131232001), true);
        }
    }

    public final void m19920a(String str, boolean z) {
        this.f20328y.setText(str);
        this.f20294D.setVisibility(z ? 0 : 8);
        m19927j();
    }

    public final void m19925g() {
        if (this.f20329z) {
            this.f20327x.setVisibility(0);
            if (this.f20304N) {
                this.f20321r.setVisibility(8);
            } else {
                this.f20320q.setVisibility(8);
            }
            this.f20329z = false;
            m19903C();
            m19928k();
            m19901A();
        }
    }

    public final void m19926h() {
        int i = ((WebrtcUiHandler) this.f20317n.get()).ar;
        int i2 = ((WebrtcUiHandler) this.f20317n.get()).as;
        if (this.f20304N) {
            this.f20321r.m21565a(i, i2);
        } else {
            this.f20320q.m21555a(i, i2);
        }
    }

    public final void m19927j() {
        if (this.f20325v != null) {
            this.f20325v.m19730a();
        }
    }

    public final void m19928k() {
        if (this.f20315k != null) {
            this.f20315k.l();
            this.f20315k = null;
        }
        if (this.f20316l != null) {
            this.f20316l.b();
            this.f20316l = null;
        }
    }

    private int m19914u() {
        int a = this.f20311g.a(WebrtcPrefKeys.f19405f, 0);
        if (a >= 3) {
            return 0;
        }
        RtcActionableTooltip rtcActionableTooltip = new RtcActionableTooltip(getContext(), 2131624620, 2130906926, ((WebrtcUiHandler) this.f20317n.get()).ai, Long.parseLong(((UserKey) this.f20313i.get()).b()));
        rtcActionableTooltip.b(getContext().getString(2131232154));
        rtcActionableTooltip.a(getContext().getString(2131232152));
        rtcActionableTooltip.t = 20000;
        rtcActionableTooltip.f19314a = this;
        rtcActionableTooltip.a(this.f20325v.f20071o);
        this.f20315k = rtcActionableTooltip;
        this.f20311g.edit().a(WebrtcPrefKeys.f19405f, a + 1).commit();
        return 20000;
    }

    private int m19908b(FragmentManager fragmentManager) {
        int a = this.f20311g.a(WebrtcPrefKeys.f19406g, 0);
        if (a >= 3) {
            return 0;
        }
        if (this.f20316l == null) {
            long j = ((WebrtcUiHandler) this.f20317n.get()).ai;
            long parseLong = Long.parseLong(((UserKey) this.f20313i.get()).b());
            WebrtcVideoChatHeadNuxFragment webrtcVideoChatHeadNuxFragment = new WebrtcVideoChatHeadNuxFragment();
            webrtcVideoChatHeadNuxFragment.ap = j;
            webrtcVideoChatHeadNuxFragment.aq = parseLong;
            this.f20316l = webrtcVideoChatHeadNuxFragment;
            this.f20316l.am = this;
            fragmentManager.a().a(this.f20316l, "video_chat_head_nux_fragment_tag").c();
        }
        this.f20311g.edit().a(WebrtcPrefKeys.f19406g, a + 1).commit();
        return 20000;
    }

    public final int m19917a(FragmentManager fragmentManager) {
        switch (this.f20312h.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.cv, 1)) {
            case 1:
                int i = 20000;
                int a = this.f20311g.a(WebrtcPrefKeys.f19404e, 0);
                if (a < 3) {
                    String string = getContext().getString(2131230720);
                    this.f20315k = new Tooltip(getContext(), 2131624619);
                    this.f20315k.b(getContext().getString(2131232151, new Object[]{string}));
                    this.f20315k.t = 20000;
                    this.f20315k.a(this.f20293C.f20085g);
                    this.f20311g.edit().a(WebrtcPrefKeys.f19404e, a + 1).commit();
                } else {
                    i = 0;
                }
                return i;
            case 2:
            case 3:
                return m19914u();
            case 4:
                return m19908b(fragmentManager);
            default:
                return 0;
        }
    }

    public static void m19915w(VoipVideoView voipVideoView) {
        if (voipVideoView.isShown()) {
            int height;
            int height2;
            int height3 = (voipVideoView.f20291A.isShown() ? voipVideoView.f20291A.getHeight() : 0) + 0;
            if (voipVideoView.f20293C.isShown()) {
                height = voipVideoView.f20293C.getHeight();
            } else {
                height = 0;
            }
            int i = height3 + height;
            if (voipVideoView.f20325v.isShown()) {
                Object obj;
                if (voipVideoView.getResources().getConfiguration().orientation == 2) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    height2 = voipVideoView.f20325v.getHeight();
                    voipVideoView.f20324u.m19117a(0, 0, i, height2, false);
                }
            }
            height2 = 0;
            voipVideoView.f20324u.m19117a(0, 0, i, height2, false);
        }
    }

    private void m19916z() {
        m19901A();
        this.f20300J = this.f20307c.scheduleAtFixedRate(new C23917(this), 0, 500, TimeUnit.MILLISECONDS);
    }

    public static void m19905a(VoipVideoView voipVideoView, final int i, final int i2) {
        ExecutorDetour.a(voipVideoView.f20308d, new Runnable(voipVideoView) {
            final /* synthetic */ VoipVideoView f20288c;

            public void run() {
                if (!((WebrtcUiHandler) this.f20288c.f20317n.get()).aH()) {
                    if (i2 > 0) {
                        this.f20288c.f20323t.setText(this.f20288c.getResources().getString(i2));
                    }
                    if (this.f20288c.f20326w.isShown()) {
                        this.f20288c.f20322s.setVisibility(8);
                    } else {
                        this.f20288c.f20322s.setVisibility(i);
                    }
                }
            }
        }, -497598656);
    }

    private void m19901A() {
        if (this.f20300J != null) {
            this.f20300J.cancel(true);
            this.f20300J = null;
        }
    }

    public static void m19909d(VoipVideoView voipVideoView, int i) {
        if (voipVideoView.f20319p == null) {
            voipVideoView.f20325v.startAnimation(voipVideoView.f20295E);
            voipVideoView.f20325v.setVisibility(0);
            voipVideoView.f20293C.startAnimation(voipVideoView.f20297G);
            voipVideoView.f20293C.setVisibility(0);
            voipVideoView.m19910e(i);
        }
    }

    public static void m19902B(VoipVideoView voipVideoView) {
        voipVideoView.f20325v.startAnimation(voipVideoView.f20296F);
        voipVideoView.f20325v.setVisibility(8);
        voipVideoView.f20293C.startAnimation(voipVideoView.f20298H);
        voipVideoView.f20293C.setVisibility(8);
        voipVideoView.m19903C();
    }

    private void m19903C() {
        if (this.f20319p != null) {
            this.f20319p.cancel(false);
            this.f20319p = null;
        }
    }

    public final void m19921b(int i) {
        if (this.f20325v.isShown()) {
            m19910e(i);
            return;
        }
        m19903C();
        if (!((WebrtcUiHandler) this.f20317n.get()).az()) {
            m19909d(this, i);
        }
    }

    public final void m19929p() {
        m19910e(5000);
    }

    private void m19910e(int i) {
        m19903C();
        if (!((WebrtcUiHandler) this.f20317n.get()).az()) {
            this.f20319p = this.f20305a.schedule(new C23939(this), (long) i, TimeUnit.MILLISECONDS);
        }
    }

    private void m19907a(ScheduledExecutorService scheduledExecutorService, WindowManager windowManager, ScheduledExecutorService scheduledExecutorService2, Executor executor, RtcBluetoothSelectorDialogProvider rtcBluetoothSelectorDialogProvider, BadgesExperimentController badgesExperimentController, FbSharedPreferences fbSharedPreferences, QeAccessor qeAccessor, Provider<UserKey> provider, FbHandlerThreadFactory fbHandlerThreadFactory, com.facebook.inject.Lazy<WebrtcUiHandler> lazy) {
        this.f20305a = scheduledExecutorService;
        this.f20306b = windowManager;
        this.f20307c = scheduledExecutorService2;
        this.f20308d = executor;
        this.f20309e = rtcBluetoothSelectorDialogProvider;
        this.f20310f = badgesExperimentController;
        this.f20311g = fbSharedPreferences;
        this.f20312h = qeAccessor;
        this.f20313i = provider;
        this.f20314j = fbHandlerThreadFactory;
        this.f20317n = lazy;
    }

    public final void mo837a(int i) {
        if (i == 2131567191) {
            m19928k();
        } else if (i == 2131567192) {
            m19928k();
            mo836a();
        }
    }

    public final void mo836a() {
        switch (this.f20312h.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.cv, 1)) {
            case 2:
            case 3:
                this.f20293C.f20085g.callOnClick();
                return;
            case 4:
                WebrtcUiHandler webrtcUiHandler = (WebrtcUiHandler) this.f20317n.get();
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.HOME");
                intent.setFlags(268435456);
                webrtcUiHandler.f19574i.b(intent, webrtcUiHandler.f19572g);
                return;
            default:
                return;
        }
    }

    public int getDeferredMillisecondsForVideoCall() {
        return this.f20312h.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.c, 0);
    }

    private boolean m19904D() {
        return getDeferredMillisecondsForVideoCall() > 0;
    }
}
