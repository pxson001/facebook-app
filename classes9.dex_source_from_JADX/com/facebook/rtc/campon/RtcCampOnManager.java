package com.facebook.rtc.campon;

import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.android.TelephonyManagerMethodAutoProvider;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.hardware.ScreenPowerState;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.push.mqtt.external.PushStateEvent;
import com.facebook.push.mqtt.service.ChannelConnectivityTracker;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rtc.ContactFetcherMethodAutoProvider;
import com.facebook.rtc.fbwebrtc.WebrtcSignalingSender;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler;
import com.facebook.rtc.interfaces.ContactFetcher;
import com.facebook.rti.shared.skywalker.SkywalkerSubscriptionConnector;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: audio_composer/ */
public class RtcCampOnManager {
    public static final String f19279a = RtcCampOnManager.class.getName();
    private static final Object f19280v = new Object();
    public final Context f19281b;
    public final ChannelConnectivityTracker f19282c;
    public final TelephonyManager f19283d;
    private final Provider<WebrtcUiHandler> f19284e;
    public final Provider<WebrtcSignalingSender> f19285f;
    private final ContactFetcher f19286g;
    private final Clock f19287h;
    public final DefaultAndroidThreadUtil f19288i;
    public final ScheduledExecutorService f19289j;
    private final ExecutorService f19290k;
    private final AppStateManager f19291l;
    private final ScreenPowerState f19292m;
    public final BaseFbBroadcastManager f19293n;
    public final RtcCamperStore f19294o;
    private final Random f19295p;
    private final QeAccessor f19296q;
    public PhoneStateListener f19297r;
    public SelfRegistrableReceiverImpl f19298s;
    public final Map<Long, RtcCallCamper> f19299t = Collections.synchronizedMap(new HashMap());
    public final Map<Long, RtcCallCamper> f19300u = Collections.synchronizedMap(new HashMap());

    /* compiled from: audio_composer/ */
    /* synthetic */ class AnonymousClass11 {
        static final /* synthetic */ int[] f19265a = new int[PushStateEvent.values().length];

        static {
            try {
                f19265a[PushStateEvent.CHANNEL_DISCONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f19265a[PushStateEvent.CHANNEL_CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: audio_composer/ */
    class C22802 implements Runnable {
        final /* synthetic */ RtcCampOnManager f19268a;

        C22802(RtcCampOnManager rtcCampOnManager) {
            this.f19268a = rtcCampOnManager;
        }

        public void run() {
            RtcCampOnManager.m19317h(this.f19268a);
        }
    }

    /* compiled from: audio_composer/ */
    public class C22813 implements Runnable {
        final /* synthetic */ long f19269a;
        final /* synthetic */ RtcCallCamper f19270b;
        final /* synthetic */ RtcCampOnManager f19271c;

        public C22813(RtcCampOnManager rtcCampOnManager, long j, RtcCallCamper rtcCallCamper) {
            this.f19271c = rtcCampOnManager;
            this.f19269a = j;
            this.f19270b = rtcCallCamper;
        }

        public void run() {
            this.f19271c.f19299t.remove(Long.valueOf(this.f19269a));
            this.f19271c.f19294o.a(this.f19269a);
            WebrtcSignalingSender webrtcSignalingSender = (WebrtcSignalingSender) this.f19271c.f19285f.get();
            long j = this.f19269a;
            Long.valueOf(j);
            ((SkywalkerSubscriptionConnector) webrtcSignalingSender.f.get()).a("voip_camp_on/" + j);
            RtcCampOnManager rtcCampOnManager = this.f19271c;
            RtcCampOnManager.m19314e(this.f19270b);
            RtcCampOnManager.m19319k(this.f19271c);
        }
    }

    /* compiled from: audio_composer/ */
    public class C22825 implements ActionReceiver {
        final /* synthetic */ RtcCampOnManager f19272a;

        public C22825(RtcCampOnManager rtcCampOnManager) {
            this.f19272a = rtcCampOnManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1887856110);
            RtcCampOnManager rtcCampOnManager = this.f19272a;
            if (rtcCampOnManager.f19299t.size() != 0) {
                rtcCampOnManager.f19289j.schedule(new C22847(rtcCampOnManager), 10, TimeUnit.SECONDS);
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1761242141, a);
        }
    }

    /* compiled from: audio_composer/ */
    public class C22836 implements ActionReceiver {
        final /* synthetic */ RtcCampOnManager f19273a;

        public C22836(RtcCampOnManager rtcCampOnManager) {
            this.f19273a = rtcCampOnManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -895333790);
            switch (AnonymousClass11.f19265a[PushStateEvent.fromValue(intent.getIntExtra("event", -1)).ordinal()]) {
                case 1:
                    RtcCampOnManager rtcCampOnManager = this.f19273a;
                    break;
                case 2:
                    RtcCampOnManager.m19322o(this.f19273a);
                    break;
            }
            LogUtils.e(1063437926, a);
        }
    }

    /* compiled from: audio_composer/ */
    public class C22847 implements Runnable {
        final /* synthetic */ RtcCampOnManager f19274a;

        public void run() {
            String str = RtcCampOnManager.f19279a;
            this.f19274a.m19316g();
        }

        public C22847(RtcCampOnManager rtcCampOnManager) {
            this.f19274a = rtcCampOnManager;
        }
    }

    /* compiled from: audio_composer/ */
    public class C22858 implements Runnable {
        final /* synthetic */ long f19275a;
        final /* synthetic */ RtcCampOnManager f19276b;

        public C22858(RtcCampOnManager rtcCampOnManager, long j) {
            this.f19276b = rtcCampOnManager;
            this.f19275a = j;
        }

        public void run() {
            RtcCallCamper rtcCallCamper = (RtcCallCamper) this.f19276b.f19299t.get(Long.valueOf(this.f19275a));
            if (rtcCallCamper != null) {
                rtcCallCamper.mo815j();
                RtcCampOnManager.m19315f(this.f19276b, rtcCallCamper);
            }
        }
    }

    /* compiled from: audio_composer/ */
    public class C22869 implements Runnable {
        final /* synthetic */ long f19277a;
        final /* synthetic */ RtcCampOnManager f19278b;

        public C22869(RtcCampOnManager rtcCampOnManager, long j) {
            this.f19278b = rtcCampOnManager;
            this.f19277a = j;
        }

        public void run() {
            RtcCallCamper rtcCallCamper = (RtcCallCamper) this.f19278b.f19299t.get(Long.valueOf(this.f19277a));
            if (rtcCallCamper != null) {
                rtcCallCamper.mo815j();
                RtcCampOnManager.m19315f(this.f19278b, rtcCallCamper);
            }
        }
    }

    private static RtcCampOnManager m19311b(InjectorLike injectorLike) {
        return new RtcCampOnManager((Context) injectorLike.getInstance(Context.class), ChannelConnectivityTracker.a(injectorLike), TelephonyManagerMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 10375), IdBasedSingletonScopeProvider.a(injectorLike, 3308), ContactFetcherMethodAutoProvider.m19085a(injectorLike), AppStateManager.a(injectorLike), DefaultAndroidThreadUtil.a(injectorLike), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(injectorLike), ScreenPowerState.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), RtcCamperStore.a(injectorLike), Random_InsecureRandomMethodAutoProvider.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike));
    }

    public static void m19313d(RtcCampOnManager rtcCampOnManager, RtcCallCamper rtcCallCamper) {
        Long.valueOf(rtcCallCamper.f19247b);
        if (StringUtil.a(rtcCallCamper.f19249d)) {
            m19314e(rtcCallCamper);
            rtcCampOnManager.f19299t.remove(Long.valueOf(rtcCallCamper.f19247b));
            rtcCampOnManager.f19294o.a(rtcCallCamper.f19247b);
            return;
        }
        m19319k(rtcCampOnManager);
        rtcCallCamper.mo812g();
        m19315f(rtcCampOnManager, rtcCallCamper);
    }

    public static void m19314e(RtcCallCamper rtcCallCamper) {
        if (rtcCallCamper.f19252g != null) {
            rtcCallCamper.f19252g.cancel(false);
            rtcCallCamper.f19252g = null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.rtc.campon.RtcCampOnManager m19310a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f19280v;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m19311b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f19280v;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.rtc.campon.RtcCampOnManager) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.rtc.campon.RtcCampOnManager) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f19280v;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.rtc.campon.RtcCampOnManager) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.rtc.campon.RtcCampOnManager.a(com.facebook.inject.InjectorLike):com.facebook.rtc.campon.RtcCampOnManager");
    }

    @Inject
    public RtcCampOnManager(Context context, ChannelConnectivityTracker channelConnectivityTracker, TelephonyManager telephonyManager, Clock clock, Provider<WebrtcUiHandler> provider, Provider<WebrtcSignalingSender> provider2, ContactFetcher contactFetcher, AppStateManager appStateManager, AndroidThreadUtil androidThreadUtil, ScheduledExecutorService scheduledExecutorService, ExecutorService executorService, ScreenPowerState screenPowerState, QeAccessor qeAccessor, RtcCamperStore rtcCamperStore, Random random, FbBroadcastManager fbBroadcastManager) {
        this.f19281b = context;
        this.f19282c = channelConnectivityTracker;
        this.f19283d = telephonyManager;
        this.f19287h = clock;
        this.f19284e = provider;
        this.f19285f = provider2;
        this.f19286g = contactFetcher;
        this.f19291l = appStateManager;
        this.f19288i = androidThreadUtil;
        this.f19289j = scheduledExecutorService;
        this.f19290k = executorService;
        this.f19292m = screenPowerState;
        this.f19294o = rtcCamperStore;
        this.f19295p = random;
        this.f19293n = fbBroadcastManager;
        this.f19296q = qeAccessor;
    }

    final Context m19325a() {
        return this.f19281b;
    }

    private boolean m19312c(final RtcCallCamper rtcCallCamper) {
        if (!StringUtil.a(rtcCallCamper.f19249d)) {
            return true;
        }
        Object a = this.f19286g.m19557a();
        if (StringUtil.a(a)) {
            Long valueOf = Long.valueOf(rtcCallCamper.f19247b);
            ContactFetcher contactFetcher = this.f19286g;
            valueOf.longValue();
            ListenableFuture b = contactFetcher.m19558b();
            rtcCallCamper.f19252g = b;
            Futures.a(b, new ResultFutureCallback<String>(this) {
                final /* synthetic */ RtcCampOnManager f19267b;

                protected final void m19308a(ServiceException serviceException) {
                    String str = RtcCampOnManager.f19279a;
                    Long.valueOf(rtcCallCamper.f19247b);
                    rtcCallCamper.f19252g = null;
                    RtcCampOnManager.m19313d(this.f19267b, rtcCallCamper);
                }

                public final void m19309a(Object obj) {
                    String str = (String) obj;
                    String str2 = RtcCampOnManager.f19279a;
                    Long.valueOf(rtcCallCamper.f19247b);
                    rtcCallCamper.f19252g = null;
                    rtcCallCamper.m19290a(null, str);
                    RtcCampOnManager.m19313d(this.f19267b, rtcCallCamper);
                }
            }, this.f19289j);
            return false;
        }
        rtcCallCamper.m19290a(null, a);
        return true;
    }

    private void m19316g() {
        if (!this.f19299t.isEmpty()) {
            this.f19288i.a(new C22802(this));
        }
    }

    public static void m19317h(RtcCampOnManager rtcCampOnManager) {
        if (rtcCampOnManager.f19299t.isEmpty()) {
            rtcCampOnManager.m19320l();
            return;
        }
        Iterator it = rtcCampOnManager.f19299t.entrySet().iterator();
        Object obj = null;
        while (it.hasNext()) {
            try {
                RtcCallCamper rtcCallCamper = (RtcCallCamper) ((Entry) it.next()).getValue();
                if (rtcCallCamper.m19292d()) {
                    it.remove();
                    rtcCampOnManager.f19294o.a(rtcCallCamper.m19289a());
                    m19314e(rtcCallCamper);
                    obj = 1;
                } else if (rtcCallCamper.m19291c() == null) {
                    if (rtcCallCamper.mo811e()) {
                        it.remove();
                        rtcCampOnManager.f19294o.a(rtcCallCamper.m19289a());
                        rtcCallCamper.mo813h();
                        m19314e(rtcCallCamper);
                        obj = 1;
                    } else if (!RtcCallCamper.m19288f()) {
                        it.remove();
                        rtcCampOnManager.f19294o.a(rtcCallCamper.m19289a());
                        m19314e(rtcCallCamper);
                        obj = 1;
                    }
                }
            } catch (Throwable e) {
                BLog.a(f19279a, "campers map is modified, waiting for next round of check.", e);
                return;
            }
        }
        if (rtcCampOnManager.f19299t.isEmpty()) {
            rtcCampOnManager.m19320l();
        } else if (obj != null) {
            m19319k(rtcCampOnManager);
        }
    }

    public static void m19315f(RtcCampOnManager rtcCampOnManager, RtcCallCamper rtcCallCamper) {
        if (rtcCampOnManager.f19299t.get(Long.valueOf(rtcCallCamper.f19247b)) == rtcCallCamper) {
            if (rtcCallCamper.m19292d()) {
                rtcCampOnManager.f19299t.remove(Long.valueOf(rtcCallCamper.f19247b));
                rtcCampOnManager.f19294o.a(rtcCallCamper.f19247b);
                m19314e(rtcCallCamper);
            } else if (rtcCallCamper.f19252g != null) {
            } else {
                if (rtcCallCamper.mo811e()) {
                    rtcCampOnManager.f19299t.remove(Long.valueOf(rtcCallCamper.f19247b));
                    rtcCampOnManager.f19294o.a(rtcCallCamper.f19247b);
                    rtcCallCamper.mo813h();
                    m19314e(rtcCallCamper);
                } else if (1 == 0) {
                    rtcCampOnManager.f19299t.remove(Long.valueOf(rtcCallCamper.f19247b));
                    rtcCampOnManager.f19294o.a(rtcCallCamper.f19247b);
                    m19314e(rtcCallCamper);
                }
            }
        }
    }

    public final void m19326a(long j) {
        RtcCallCamper rtcIncomingMissedCallCamper = new RtcIncomingMissedCallCamper(this, j, this.f19287h.a(), 600000);
        this.f19299t.put(Long.valueOf(j), rtcIncomingMissedCallCamper);
        if (m19312c(rtcIncomingMissedCallCamper)) {
            m19313d(this, rtcIncomingMissedCallCamper);
        }
    }

    public final boolean m19327a(long j, String str, String str2, boolean z, long j2) {
        long a = this.f19287h.a();
        if (!m19328a(j, str, str2, z, a, j2, 86400000)) {
            return false;
        }
        this.f19294o.a(z ? 4 : 3, j, str, str2, a, 86400000);
        ((WebrtcSignalingSender) this.f19285f.get()).a(j);
        return true;
    }

    public final boolean m19328a(long j, String str, String str2, boolean z, long j2, long j3, long j4) {
        RtcCallCamper rtcCallerCamper = new RtcCallerCamper(this, j, z, j2, j3, j4);
        this.f19299t.put(Long.valueOf(j), rtcCallerCamper);
        if (!StringUtil.a(str2)) {
            rtcCallerCamper.m19290a(str, str2);
            m19313d(this, rtcCallerCamper);
        } else if (m19312c(rtcCallerCamper)) {
            m19313d(this, rtcCallerCamper);
        }
        return true;
    }

    public static void m19319k(RtcCampOnManager rtcCampOnManager) {
        if (rtcCampOnManager.f19299t.isEmpty()) {
            rtcCampOnManager.m19320l();
            return;
        }
        Object obj;
        Iterator it = rtcCampOnManager.f19299t.values().iterator();
        while (it.hasNext()) {
            it.next();
            if (null != null) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj != null) {
            if (rtcCampOnManager.f19298s == null) {
                rtcCampOnManager.f19298s = rtcCampOnManager.f19293n.a().a("com.facebook.push.mqtt.ACTION_CHANNEL_STATE_CHANGED", new C22836(rtcCampOnManager)).a(AppStateManager.b, new C22825(rtcCampOnManager)).a();
            }
            if (!rtcCampOnManager.f19298s.a()) {
                rtcCampOnManager.f19298s.b();
            }
        } else {
            rtcCampOnManager.m19321m();
        }
        for (RtcCallCamper l : rtcCampOnManager.f19299t.values()) {
            if (l.mo816l()) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj != null) {
            if (rtcCampOnManager.f19283d != null && rtcCampOnManager.f19297r == null) {
                rtcCampOnManager.f19297r = new PhoneStateListener(rtcCampOnManager) {
                    final /* synthetic */ RtcCampOnManager f19264a;

                    {
                        this.f19264a = r1;
                    }

                    public void onCallStateChanged(int i, String str) {
                        super.onCallStateChanged(i, str);
                        if (i == 0) {
                            RtcCampOnManager.m19324s(this.f19264a);
                        }
                    }
                };
                rtcCampOnManager.f19283d.listen(rtcCampOnManager.f19297r, 32);
            }
            return;
        }
        rtcCampOnManager.m19323q();
    }

    private void m19320l() {
        m19323q();
        m19321m();
    }

    private void m19321m() {
        if (this.f19298s != null && this.f19298s.a()) {
            this.f19298s.c();
        }
    }

    public static void m19322o(RtcCampOnManager rtcCampOnManager) {
        rtcCampOnManager.m19316g();
    }

    public final void m19329b() {
        m19316g();
    }

    public final boolean m19330c() {
        return (this.f19283d == null || this.f19283d.getCallState() == 0) ? false : true;
    }

    public final boolean m19331d() {
        return ((WebrtcUiHandler) this.f19284e.get()).aD();
    }

    private void m19323q() {
        if (this.f19283d != null && this.f19297r != null) {
            this.f19283d.listen(this.f19297r, 0);
            this.f19297r = null;
        }
    }

    public static void m19324s(RtcCampOnManager rtcCampOnManager) {
        rtcCampOnManager.m19316g();
    }
}
