package com.facebook.analytics;

import com.facebook.analytics.client.AnalyticsEventSender;
import com.facebook.analytics.event.HoneyClientEventFastInternal;
import com.facebook.analytics.logger.AnalyticsConfig;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.throttling.AnalyticsHighEventsRateReporter;
import com.facebook.analytics.util.EventAutoSetter;
import com.facebook.common.diagnostics.VMMemoryInfo;
import com.facebook.common.diagnostics.VMMemoryInfoMethodAutoProvider;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.NamedRunnable;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.katana.orca.FbAnalyticsConfig;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: updateTimestamp */
public class DefaultAnalyticsLogger extends AbstractAnalyticsLogger {
    public static final String f460b = DefaultAnalyticsLogger.class.getSimpleName();
    private static volatile DefaultAnalyticsLogger f461r;
    Queue<HoneyAnalyticsEvent> f462a;
    private final Provider<String> f463c;
    private final BaseAnalyticsConfig f464d;
    private final DefaultAndroidThreadUtil f465e;
    private final ExecutorService f466f;
    private final AnalyticsEventSender f467g;
    private final Provider<Boolean> f468h;
    private final AnalyticsHighEventsRateReporter f469i;
    private final EventAutoSetter f470j;
    private final Lazy<NavigationLogger> f471k;
    public AtomicBoolean f472l;
    private final AnalyticsRunnable f473m;
    private final PerfTestConfig f474n;
    private final LoggingTestConfig f475o;
    public final Lazy<ClientEventGenerator> f476p;
    public boolean f477q = false;

    /* compiled from: updateTimestamp */
    class BackgroundEventProcessorRunnable extends NamedRunnable {
        final /* synthetic */ DefaultAnalyticsLogger f523c;

        public BackgroundEventProcessorRunnable(DefaultAnalyticsLogger defaultAnalyticsLogger) {
            this.f523c = defaultAnalyticsLogger;
            super(DefaultAnalyticsLogger.f460b, "BackgroundEventProcessor");
        }

        public void run() {
            this.f523c.f472l.set(false);
            ClientEventGenerator clientEventGenerator = (ClientEventGenerator) this.f523c.f476p.get();
            DefaultAnalyticsLogger defaultAnalyticsLogger = this.f523c;
            List<HoneyAnalyticsEvent> a = clientEventGenerator.a();
            if (!(a == null || a.isEmpty())) {
                for (HoneyAnalyticsEvent b : a) {
                    defaultAnalyticsLogger.m778b(b);
                }
            }
            while (true) {
                HoneyAnalyticsEvent honeyAnalyticsEvent = (HoneyAnalyticsEvent) this.f523c.f462a.poll();
                if (honeyAnalyticsEvent != null) {
                    DefaultAnalyticsLogger.m771i(this.f523c, honeyAnalyticsEvent);
                    if (!this.f523c.f477q) {
                        int i;
                        DefaultAnalyticsLogger defaultAnalyticsLogger2 = this.f523c;
                        if (honeyAnalyticsEvent.b("upload_this_event_now")) {
                            i = 1;
                        } else {
                            i = 2;
                        }
                        List<HoneyAnalyticsEvent> a2 = clientEventGenerator.a(i);
                        if (!(a2 == null || a2.isEmpty())) {
                            for (HoneyAnalyticsEvent b2 : a2) {
                                DefaultAnalyticsLogger.m771i(defaultAnalyticsLogger2, b2);
                            }
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public static com.facebook.analytics.DefaultAnalyticsLogger m764a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f461r;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.DefaultAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f461r;	 Catch:{ all -> 0x003a }
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
        r0 = m766b(r0);	 Catch:{ all -> 0x0035 }
        f461r = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f461r;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.DefaultAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.analytics.DefaultAnalyticsLogger");
    }

    private static DefaultAnalyticsLogger m766b(InjectorLike injectorLike) {
        return new DefaultAnalyticsLogger(IdBasedProvider.a(injectorLike, 4442), (BaseAnalyticsConfig) FbAnalyticsConfig.a(injectorLike), DefaultAndroidThreadUtil.a(injectorLike), (ExecutorService) IdleExecutor_AnalyticsThreadExecutorOnIdleMethodAutoProvider.m782a(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), VMMemoryInfoMethodAutoProvider.a(injectorLike), AnalyticsEventSender.m784a(injectorLike), IdBasedProvider.a(injectorLike, 3883), IdBasedProvider.a(injectorLike, 3882), AnalyticsHighEventsRateReporter.m797a(injectorLike), EventAutoSetter.m802a(injectorLike), PerfTestConfig.a(injectorLike), LoggingTestConfig.m804a(injectorLike), Random_InsecureRandomMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 137), IdBasedSingletonScopeProvider.b(injectorLike, 122), AnalyticsStats.a(injectorLike));
    }

    @Inject
    public DefaultAnalyticsLogger(Provider<String> provider, AnalyticsConfig analyticsConfig, AndroidThreadUtil androidThreadUtil, ExecutorService executorService, ExecutorService executorService2, VMMemoryInfo vMMemoryInfo, AnalyticsEventSender analyticsEventSender, Provider<Boolean> provider2, Provider<Boolean> provider3, AnalyticsHighEventsRateReporter analyticsHighEventsRateReporter, EventAutoSetter eventAutoSetter, PerfTestConfig perfTestConfig, LoggingTestConfig loggingTestConfig, Random random, Lazy<NavigationLogger> lazy, Lazy<ClientEventGenerator> lazy2, AnalyticsStats analyticsStats) {
        super(random, analyticsConfig, analyticsStats);
        this.f463c = provider;
        this.f464d = analyticsConfig;
        this.f465e = androidThreadUtil;
        this.f466f = executorService;
        this.f467g = analyticsEventSender;
        this.f468h = provider2;
        this.f469i = analyticsHighEventsRateReporter;
        this.f470j = eventAutoSetter;
        this.f471k = lazy;
        this.f462a = new ConcurrentLinkedQueue();
        this.f472l = new AtomicBoolean(false);
        this.f473m = new AnalyticsRunnable(vMMemoryInfo, provider3, executorService2, new BackgroundEventProcessorRunnable(this));
        this.f474n = perfTestConfig;
        this.f475o = loggingTestConfig;
        this.f476p = lazy2;
    }

    public final String m772a() {
        return "analytics1";
    }

    private void m767e(HoneyAnalyticsEvent honeyAnalyticsEvent) {
        String str = (String) this.f463c.get();
        if (((Boolean) this.f468h.get()).booleanValue() && str != null) {
            honeyAnalyticsEvent.f = str;
        }
        EventAutoSetter eventAutoSetter = this.f470j;
        if (-1 == honeyAnalyticsEvent.e) {
            honeyAnalyticsEvent.e = eventAutoSetter.f510b.a();
        }
        honeyAnalyticsEvent.g = ((NavigationLogger) this.f471k.get()).z;
    }

    public final synchronized void m773a(HoneyAnalyticsEvent honeyAnalyticsEvent) {
        if (!(PerfTestConfigBase.k() || honeyAnalyticsEvent == null)) {
            m767e(honeyAnalyticsEvent);
            m768f(honeyAnalyticsEvent);
            if (this.f475o.m806a()) {
                honeyAnalyticsEvent.e();
            }
        }
    }

    public final synchronized void m778b(HoneyAnalyticsEvent honeyAnalyticsEvent) {
        if (!(PerfTestConfigBase.k() || honeyAnalyticsEvent == null)) {
            m767e(honeyAnalyticsEvent);
            m769g(honeyAnalyticsEvent);
        }
    }

    @Deprecated
    public final void m774a(HoneyAnalyticsEvent honeyAnalyticsEvent, int i) {
        if (c(honeyAnalyticsEvent, i)) {
            m773a(honeyAnalyticsEvent);
        }
    }

    private boolean m765a(HoneyAnalyticsEvent honeyAnalyticsEvent, boolean z) {
        if (honeyAnalyticsEvent instanceof HoneyClientEventFastInternal) {
            return ((HoneyClientEventFastInternal) honeyAnalyticsEvent).l();
        }
        return this.f464d.a(honeyAnalyticsEvent.d, z);
    }

    private void m768f(HoneyAnalyticsEvent honeyAnalyticsEvent) {
        if (m765a(honeyAnalyticsEvent, false)) {
            this.f462a.add(honeyAnalyticsEvent);
            b(honeyAnalyticsEvent.d);
            if (this.f472l.compareAndSet(false, true)) {
                ExecutorDetour.a(this.f466f, this.f473m, -1277343911);
            }
            this.f473m.m810a(this.f462a.size());
        }
    }

    private void m769g(HoneyAnalyticsEvent honeyAnalyticsEvent) {
        this.f462a.add(honeyAnalyticsEvent);
        b(honeyAnalyticsEvent.d);
        if (this.f472l.compareAndSet(false, true)) {
            ExecutorDetour.a(this.f466f, this.f473m, -676550102);
        }
        this.f473m.m810a(this.f462a.size());
    }

    @Deprecated
    public final synchronized void m780c(HoneyAnalyticsEvent honeyAnalyticsEvent) {
        if (!(PerfTestConfigBase.k() || honeyAnalyticsEvent == null)) {
            m767e(honeyAnalyticsEvent);
            m770h(honeyAnalyticsEvent);
            if (this.f475o.m806a()) {
                honeyAnalyticsEvent.e();
            }
        }
    }

    @Deprecated
    public final synchronized void m779b(HoneyAnalyticsEvent honeyAnalyticsEvent, int i) {
        if (c(honeyAnalyticsEvent, i)) {
            m780c(honeyAnalyticsEvent);
        }
    }

    public final void m781d(HoneyAnalyticsEvent honeyAnalyticsEvent) {
        if (honeyAnalyticsEvent != null) {
            honeyAnalyticsEvent.a("upload_this_event_now", "true");
            m780c(honeyAnalyticsEvent);
        }
    }

    private void m770h(HoneyAnalyticsEvent honeyAnalyticsEvent) {
        if (m765a(honeyAnalyticsEvent, true)) {
            b(honeyAnalyticsEvent.d);
            this.f462a.add(honeyAnalyticsEvent);
            if (this.f472l.compareAndSet(false, true)) {
                ExecutorDetour.a(this.f466f, this.f473m, 1203009600);
            }
            this.f473m.m810a(this.f462a.size());
        }
    }

    public final void m775a(HoneyClientEvent honeyClientEvent) {
        if (honeyClientEvent != null) {
            if (honeyClientEvent.j) {
                m781d(honeyClientEvent);
            } else {
                m780c(honeyClientEvent);
            }
        }
    }

    public final synchronized void m776a(String str) {
        m777a(str, null);
    }

    public final synchronized void m777a(String str, Map<String, String> map) {
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent(str);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                honeyClientEvent.b((String) entry.getKey(), (String) entry.getValue());
            }
        }
        m773a(honeyClientEvent);
    }

    public static void m771i(DefaultAnalyticsLogger defaultAnalyticsLogger, HoneyAnalyticsEvent honeyAnalyticsEvent) {
        defaultAnalyticsLogger.f465e.b();
        if (defaultAnalyticsLogger.f464d.b()) {
            defaultAnalyticsLogger.f469i.m801a(honeyAnalyticsEvent);
        }
        EventAutoSetter eventAutoSetter = defaultAnalyticsLogger.f470j;
        Provider provider = defaultAnalyticsLogger.f463c;
        if ("AUTO_SET".equals(honeyAnalyticsEvent.f)) {
            honeyAnalyticsEvent.f = (String) provider.get();
        }
        if (honeyAnalyticsEvent.i == "AUTO_SET" && eventAutoSetter.f511c.a()) {
            honeyAnalyticsEvent.i = eventAutoSetter.f509a.a().b;
        }
        defaultAnalyticsLogger.f467g.m794a(honeyAnalyticsEvent);
    }
}
