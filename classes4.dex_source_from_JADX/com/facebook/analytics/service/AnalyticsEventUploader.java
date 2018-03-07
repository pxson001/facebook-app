package com.facebook.analytics.service;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.facebook.analytics.AnalyticsEvent;
import com.facebook.analytics.AnalyticsRunnable;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.Long_AnalyticsEventProcessorIdleTimeoutMethodAutoProvider;
import com.facebook.analytics.UserLoggedInStatus;
import com.facebook.analytics.db.AnalyticsDbProperties;
import com.facebook.analytics.db.AnalyticsPropertyUtil;
import com.facebook.analytics.db.AnalyticsStorage;
import com.facebook.analytics.logger.IAnalyticsPeriodicEventReporter;
import com.facebook.analytics.prefs.AnalyticsPrefKeys;
import com.facebook.analytics.service.AnalyticsService.EventProcessorListener;
import com.facebook.auth.event.AuthEvent;
import com.facebook.auth.event.AuthEventBus;
import com.facebook.auth.event.AuthEventSubscriber;
import com.facebook.auth.event.AuthLoggedInEvent;
import com.facebook.auth.event.AuthLoggedOutEvent;
import com.facebook.common.alarm.FbAlarmManager;
import com.facebook.common.alarm.FbAlarmManagerImpl;
import com.facebook.common.diagnostics.VMMemoryInfo;
import com.facebook.common.diagnostics.VMMemoryInfoMethodAutoProvider;
import com.facebook.common.executors.NamedRunnable;
import com.facebook.common.executors.ScheduledExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.hardware.ScreenPowerState;
import com.facebook.common.hardware.ScreenPowerState.PowerChangeListener;
import com.facebook.common.idleexecutor.IdleExecutor;
import com.facebook.common.idleexecutor.IdleExecutor_DefaultIdleExecutorMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.content.event.FbEvent;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Maps;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: titleMaxLines and subtitleMaxLines must both be specified if one is specified */
public class AnalyticsEventUploader {
    private static volatile AnalyticsEventUploader f933I;
    @VisibleForTesting
    static final String f934b = (AnalyticsEventUploader.class.getCanonicalName() + ".ACTION_ALARM");
    public static boolean f935d = false;
    private boolean f936A;
    public boolean f937B = false;
    public long f938C = -1;
    private int f939D = 0;
    private boolean f940E = false;
    private int f941F = 0;
    @GuardedBy("mIdleSync")
    public boolean f942G = true;
    private AnalyticsRunnable f943H;
    @VisibleForTesting
    Set<IAnalyticsPeriodicEventReporter> f944a = null;
    public long f945c = -1;
    private final Context f946e;
    public final AnalyticsPropertyUtil f947f;
    private final Lazy<AnalyticsStorage> f948g;
    private final Clock f949h;
    private final Lazy<HoneyAnalyticsPeriodicReporter> f950i;
    private final FbSharedPreferences f951j;
    public final Executor f952k;
    private final ScheduledExecutorService f953l;
    private final LinkedBlockingQueue<AnalyticsEvent> f954m;
    private final FbAlarmManagerImpl f955n;
    private final AuthEventBus f956o;
    private final UserLoggedInStatus f957p;
    public final ScreenPowerState f958q;
    private final Object f959r = new Object();
    public final ConcurrentMap<AnalyticsEventUploaderListener, Boolean> f960s;
    private AuthEventSubscriber<AuthLoggedOutEvent> f961t;
    private AuthEventSubscriber<AuthLoggedInEvent> f962u;
    public final PowerChangeListener f963v = new C00621(this);
    private final Long f964w;
    private ScheduledFuture<?> f965x;
    private boolean f966y = false;
    private long f967z = -1;

    /* compiled from: titleMaxLines and subtitleMaxLines must both be specified if one is specified */
    class C00621 implements PowerChangeListener {
        final /* synthetic */ AnalyticsEventUploader f980a;

        C00621(AnalyticsEventUploader analyticsEventUploader) {
            this.f980a = analyticsEventUploader;
        }

        public final void m1299a(boolean z) {
            this.f980a.m1286a(z);
        }
    }

    /* compiled from: titleMaxLines and subtitleMaxLines must both be specified if one is specified */
    final class EventProcessorRunnable extends NamedRunnable {
        final /* synthetic */ AnalyticsEventUploader f981c;

        public EventProcessorRunnable(AnalyticsEventUploader analyticsEventUploader) {
            this.f981c = analyticsEventUploader;
            super("AnalyticsEventUploader", "EventProcessor");
        }

        public final void run() {
            AnalyticsEventUploader.m1275f(this.f981c);
        }
    }

    /* compiled from: titleMaxLines and subtitleMaxLines must both be specified if one is specified */
    class C00632 extends AuthEventSubscriber<AuthLoggedInEvent> {
        final /* synthetic */ AnalyticsEventUploader f982a;

        C00632(AnalyticsEventUploader analyticsEventUploader) {
            this.f982a = analyticsEventUploader;
        }

        public final /* synthetic */ void mo58a(AuthEvent authEvent) {
            m1300b();
        }

        public final /* bridge */ /* synthetic */ void mo59b(FbEvent fbEvent) {
            m1300b();
        }

        private void m1300b() {
            this.f982a.f958q.a(this.f982a.f963v);
        }

        public final Class<AuthLoggedInEvent> m1301a() {
            return AuthLoggedInEvent.class;
        }
    }

    /* compiled from: titleMaxLines and subtitleMaxLines must both be specified if one is specified */
    class C00643 extends AuthEventSubscriber<AuthLoggedOutEvent> {
        final /* synthetic */ AnalyticsEventUploader f983a;

        C00643(AnalyticsEventUploader analyticsEventUploader) {
            this.f983a = analyticsEventUploader;
        }

        public final /* synthetic */ void mo58a(AuthEvent authEvent) {
            m1304b();
        }

        public final /* bridge */ /* synthetic */ void mo59b(FbEvent fbEvent) {
            m1304b();
        }

        private void m1304b() {
            this.f983a.f958q.b(this.f983a.f963v);
            AnalyticsEventUploader.m1278i(this.f983a);
            ExecutorDetour.a(this.f983a.f952k, new 1(this, "AnalyticsEventUploader", "uploadOnLogout"), -1872272525);
        }

        public final Class<AuthLoggedOutEvent> m1305a() {
            return AuthLoggedOutEvent.class;
        }
    }

    /* compiled from: titleMaxLines and subtitleMaxLines must both be specified if one is specified */
    public class AlarmReceiver extends DynamicSecureBroadcastReceiver {
        final /* synthetic */ AnalyticsEventUploader f984a;

        public AlarmReceiver(AnalyticsEventUploader analyticsEventUploader) {
            this.f984a = analyticsEventUploader;
            super(AnalyticsEventUploader.f934b, new AlarmAction(analyticsEventUploader));
        }
    }

    /* compiled from: titleMaxLines and subtitleMaxLines must both be specified if one is specified */
    class AlarmAction implements ActionReceiver {
        final /* synthetic */ AnalyticsEventUploader f985a;

        public AlarmAction(AnalyticsEventUploader analyticsEventUploader) {
            this.f985a = analyticsEventUploader;
        }

        @SuppressLint({"InvalidAccessToGuardedField"})
        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -450477624);
            if (this.f985a.f942G) {
                this.f985a.f937B = false;
                AnalyticsEventUploader.f935d = false;
                ExecutorDetour.a(this.f985a.f952k, new UploadLogsRunnable(this), -406725928);
            } else {
                this.f985a.f937B = true;
                AnalyticsEventUploader.f935d = true;
            }
            LogUtils.e(442196841, a);
        }
    }

    public static com.facebook.analytics.service.AnalyticsEventUploader m1267a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f933I;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.service.AnalyticsEventUploader.class;
        monitor-enter(r1);
        r0 = f933I;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m1269b(r0);	 Catch:{ all -> 0x0035 }
        f933I = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f933I;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.service.AnalyticsEventUploader.a(com.facebook.inject.InjectorLike):com.facebook.analytics.service.AnalyticsEventUploader");
    }

    private static AnalyticsEventUploader m1269b(InjectorLike injectorLike) {
        return new AnalyticsEventUploader((Context) injectorLike.getInstance(Context.class), AnalyticsPropertyUtil.m1289a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 166), IdBasedSingletonScopeProvider.b(injectorLike, 189), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdleExecutor_DefaultIdleExecutorMethodAutoProvider.a(injectorLike), ScheduledExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), VMMemoryInfoMethodAutoProvider.a(injectorLike), FbAlarmManagerImpl.a(injectorLike), AuthEventBus.a(injectorLike), UserLoggedInStatus.a(injectorLike), Long_AnalyticsEventProcessorIdleTimeoutMethodAutoProvider.m1297a(injectorLike), ScreenPowerState.a(injectorLike), IdBasedProvider.a(injectorLike, 3882));
    }

    @Inject
    public AnalyticsEventUploader(Context context, AnalyticsPropertyUtil analyticsPropertyUtil, Lazy<AnalyticsStorage> lazy, Lazy<HoneyAnalyticsPeriodicReporter> lazy2, FbSharedPreferences fbSharedPreferences, Clock clock, IdleExecutor idleExecutor, ScheduledExecutorService scheduledExecutorService, VMMemoryInfo vMMemoryInfo, FbAlarmManager fbAlarmManager, AuthEventBus authEventBus, UserLoggedInStatus userLoggedInStatus, Long l, ScreenPowerState screenPowerState, Provider<Boolean> provider) {
        this.f946e = context;
        this.f947f = analyticsPropertyUtil;
        this.f948g = lazy;
        this.f949h = clock;
        this.f950i = lazy2;
        this.f951j = fbSharedPreferences;
        this.f952k = idleExecutor;
        this.f953l = scheduledExecutorService;
        this.f955n = fbAlarmManager;
        this.f956o = authEventBus;
        this.f957p = userLoggedInStatus;
        this.f958q = screenPowerState;
        this.f960s = Maps.e();
        this.f964w = l;
        this.f954m = new LinkedBlockingQueue();
        this.f943H = new AnalyticsRunnable(vMMemoryInfo, provider, scheduledExecutorService, new EventProcessorRunnable(this));
    }

    public final void m1285a(List<? extends AnalyticsEvent> list) {
        m1271b((List) list);
    }

    public final void m1282a() {
        m1271b(null);
    }

    private void m1271b(@Nullable List<? extends AnalyticsEvent> list) {
        synchronized (this.f959r) {
            if (list != null) {
                if (!list.isEmpty()) {
                    this.f954m.addAll(list);
                }
            }
            if (this.f942G) {
                this.f942G = false;
                m1273d();
                ExecutorDetour.a(this.f952k, this.f943H, -296934945);
            }
            this.f943H.m810a(this.f954m.size());
        }
    }

    public final void m1287b() {
        this.f962u = new C00632(this);
        this.f961t = new C00643(this);
        this.f956o.a(this.f962u);
        this.f956o.a(this.f961t);
        if (this.f957p.a() == TriState.YES) {
            this.f958q.a(this.f963v);
        }
        this.f946e.registerReceiver(new AlarmReceiver(this), new IntentFilter(f934b));
        m1281m();
    }

    public final void m1283a(EventProcessorListener eventProcessorListener) {
        this.f960s.put(eventProcessorListener, Boolean.valueOf(true));
    }

    public final void m1288b(EventProcessorListener eventProcessorListener) {
        this.f960s.remove(eventProcessorListener);
    }

    private synchronized void m1272c() {
        this.f965x = this.f953l.schedule(new NamedRunnable(this, "AnalyticsEventUploader", "scheduledIdleNotify") {
            final /* synthetic */ AnalyticsEventUploader f1200c;

            public void run() {
                for (EventProcessorListener a : this.f1200c.f960s.keySet()) {
                    a.m1409a();
                }
            }
        }, this.f964w.longValue(), TimeUnit.MILLISECONDS);
    }

    private synchronized void m1273d() {
        if (this.f965x != null) {
            this.f965x.cancel(false);
            this.f965x = null;
        }
    }

    private long m1274e() {
        return this.f951j.a(AnalyticsPrefKeys.c, 60000);
    }

    @VisibleForTesting
    public static void m1275f(AnalyticsEventUploader analyticsEventUploader) {
        analyticsEventUploader.f939D = ((AnalyticsStorage) analyticsEventUploader.f948g.get()).m1425a();
        Integer.valueOf(analyticsEventUploader.f939D);
        while (true) {
            if (analyticsEventUploader.f954m.size() > 0) {
                HoneyAnalyticsEvent honeyAnalyticsEvent = (HoneyAnalyticsEvent) analyticsEventUploader.f954m.remove();
                if (honeyAnalyticsEvent.b("resume_upload")) {
                    analyticsEventUploader.f966y = false;
                }
                if (honeyAnalyticsEvent.b("upload_batch_now")) {
                    analyticsEventUploader.f937B = true;
                }
                if (honeyAnalyticsEvent.b("pause_upload")) {
                    try {
                        long parseLong = Long.parseLong(honeyAnalyticsEvent.c("pause_upload"));
                        analyticsEventUploader.f967z = Math.max(analyticsEventUploader.f967z, analyticsEventUploader.f949h.a() + parseLong);
                        Long.valueOf(parseLong);
                    } catch (Throwable e) {
                        BLog.a("AnalyticsEventUploader", "Invalid pause upload duration tag.", e);
                    }
                }
                if (honeyAnalyticsEvent.b("unpause_upload")) {
                    analyticsEventUploader.f967z = -1;
                }
                if (honeyAnalyticsEvent.b("flush_tag_upload_now")) {
                    analyticsEventUploader.m1268a(honeyAnalyticsEvent.c("flush_tag_upload_now"));
                }
                if (analyticsEventUploader.m1276g()) {
                    m1280k(analyticsEventUploader);
                }
                if (honeyAnalyticsEvent.b("stop_upload")) {
                    analyticsEventUploader.f966y = true;
                }
            } else {
                boolean z;
                synchronized (analyticsEventUploader.f959r) {
                    if (analyticsEventUploader.f954m.size() == 0) {
                        analyticsEventUploader.f942G = true;
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    analyticsEventUploader.m1272c();
                    return;
                }
            }
        }
    }

    @VisibleForTesting
    private boolean m1276g() {
        if (this.f940E) {
            return false;
        }
        if (this.f967z != -1 && this.f967z > this.f949h.a()) {
            return false;
        }
        if (this.f937B) {
            return true;
        }
        if (this.f966y || !this.f936A) {
            return false;
        }
        long a = this.f949h.a();
        if (this.f945c == -1) {
            if (this.f938C == -1) {
                this.f938C = this.f947f.m8550a(AnalyticsDbProperties.f1031a, 0);
            }
            if (a - this.f938C > m1274e()) {
                return true;
            }
            return false;
        } else if (a - this.f945c > 10000) {
            return true;
        } else {
            return false;
        }
    }

    private void m1277h() {
        if (this.f957p.a() == TriState.YES) {
            this.f955n.a(0, this.f949h.a(), 3600000, m1279j());
        } else {
            m1278i(this);
        }
    }

    public static void m1278i(AnalyticsEventUploader analyticsEventUploader) {
        analyticsEventUploader.f955n.a(analyticsEventUploader.m1279j());
    }

    private PendingIntent m1279j() {
        return PendingIntent.getBroadcast(this.f946e, 0, new Intent(f934b), 0);
    }

    public static void m1280k(AnalyticsEventUploader analyticsEventUploader) {
        long a = analyticsEventUploader.f949h.a();
        analyticsEventUploader.f938C = a;
        analyticsEventUploader.f945c = -1;
        analyticsEventUploader.f947f.m8557b(AnalyticsDbProperties.f1031a, a);
        Integer.valueOf(analyticsEventUploader.f939D);
        ((DefaultHoneyAnalyticsPeriodicReporter) analyticsEventUploader.f950i.get()).m1454a(null);
        analyticsEventUploader.f939D = 0;
        if (f935d) {
            f935d = false;
            analyticsEventUploader.m1277h();
        }
        analyticsEventUploader.f937B = false;
    }

    private void m1268a(String str) {
        ((DefaultHoneyAnalyticsPeriodicReporter) this.f950i.get()).m1454a(str);
    }

    private static String m1270b(long j) {
        return StringFormatUtil.formatStrLocaleSafe("%02d:%02d.%03d", Long.valueOf(j / 60000), Long.valueOf((j / 1000) % 60), Long.valueOf(j % 1000));
    }

    public final void m1284a(PrintWriter printWriter) {
        printWriter.println("AnalyticsEventUploader: ");
        synchronized (this.f959r) {
            printWriter.println(" idle: " + this.f942G);
        }
        printWriter.println(" pending upload event count: " + this.f939D);
        printWriter.println(" total count: " + this.f941F);
        printWriter.println(" upload disabled: " + this.f966y);
        printWriter.println(" force disable upload: " + this.f940E);
        printWriter.println(StringFormatUtil.formatStrLocaleSafe(" last sent: %s ago", m1270b(this.f949h.a() - this.f938C)));
    }

    @VisibleForTesting
    private void m1281m() {
        this.f936A = ((PowerManager) this.f946e.getSystemService("power")).isScreenOn();
    }

    @VisibleForTesting
    final void m1286a(boolean z) {
        if (z) {
            m1278i(this);
            this.f936A = true;
            this.f945c = this.f949h.a();
            m1271b(null);
            return;
        }
        m1277h();
        this.f945c = -1;
        this.f936A = false;
    }
}
