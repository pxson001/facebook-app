package com.facebook.sequencelogger;

import android.content.Context;
import android.content.Intent;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.samplingpolicy.AnalyticsLoggingPolicy;
import com.facebook.analytics.samplingpolicy.AnalyticsLoggingPolicy.ConfigSnapShot;
import com.facebook.analytics.samplingpolicy.AnalyticsPerfUtils;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.lwperf.perfstats.BackgroundChecker;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.idleexecutor.DefaultProcessIdleExecutor;
import com.facebook.common.idleexecutor.IdleExecutor;
import com.facebook.common.idleexecutor.IdleExecutor_SingleThreadedExecutorServiceMethodAutoProvider;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.debug.log.BLog;
import com.facebook.http.common.CachedNetworkInfoCollector;
import com.facebook.http.observer.NetworkInfo;
import com.facebook.http.observer.NetworkInfoCollector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.core.TraceControl;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.loom.module.SequenceListenerForLoom;
import com.facebook.perftestutils.logger.PerfTestLogger;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.quicklog.DebugAndTestConfig;
import com.facebook.quicklog.identifiers.PerformanceEventFields;
import com.facebook.quicklog.module.StandardDebugAndTestConfig;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: updated_thread_key */
public class SequenceLoggerImpl implements SequenceLogger {
    private static final Class<?> f1721b = SequenceLoggerImpl.class;
    private static volatile SequenceLoggerImpl f1722v;
    @VisibleForTesting
    final LinkedBlockingQueue<SequenceImpl<?>> f1723a;
    private final MonotonicClock f1724c;
    private final Clock f1725d;
    private final AnalyticsLogger f1726e;
    private final AnalyticsLoggingPolicy f1727f;
    private final DefaultProcessIdleExecutor f1728g;
    public final AppStateManager f1729h;
    private final FbDataConnectionManager f1730i;
    private final FbNetworkManager f1731j;
    private final SequenceLoggerEventObservable f1732k;
    private final StandardDebugAndTestConfig f1733l;
    private final NetworkInfoCollector f1734m;
    private final UploadRunnable f1735n;
    private volatile ConcurrentMap<Object, SequenceImpl<?>> f1736o;
    private Set<SequenceListener> f1737p;
    public final AtomicBoolean f1738q;
    private long f1739r = 0;
    private long f1740s = 0;
    private final NoOpSequence f1741t;
    private TriState f1742u = TriState.UNSET;

    /* compiled from: updated_thread_key */
    class UploadRunnable implements Runnable {
        final /* synthetic */ SequenceLoggerImpl f2038a;

        public UploadRunnable(SequenceLoggerImpl sequenceLoggerImpl) {
            this.f2038a = sequenceLoggerImpl;
        }

        public void run() {
            this.f2038a.f1738q.set(false);
            Collection b = Lists.m1306b();
            while (true) {
                SequenceImpl sequenceImpl = (SequenceImpl) this.f2038a.f1723a.poll();
                if (sequenceImpl == null) {
                    this.f2038a.f1723a.addAll(b);
                    return;
                } else if (!SequenceLoggerImpl.m3469a(this.f2038a, sequenceImpl)) {
                    b.add(sequenceImpl);
                }
            }
        }
    }

    /* compiled from: updated_thread_key */
    class C01451 implements ActionReceiver {
        final /* synthetic */ SequenceLoggerImpl f2052a;

        C01451(SequenceLoggerImpl sequenceLoggerImpl) {
            this.f2052a = sequenceLoggerImpl;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1459244520);
            SequenceLoggerImpl.m3468a(this.f2052a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1315797929, a);
        }
    }

    /* compiled from: updated_thread_key */
    class InternalSequenceKey {
        public final String f14500a;
        public final String f14501b;
        private final int f14502c;

        public InternalSequenceKey(String str, String str2) {
            this.f14500a = (String) Preconditions.checkNotNull(str);
            this.f14501b = (String) Preconditions.checkNotNull(str2);
            this.f14502c = (str.hashCode() * 100003) + str2.hashCode();
        }

        public int hashCode() {
            return this.f14502c;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof InternalSequenceKey)) {
                return false;
            }
            InternalSequenceKey internalSequenceKey = (InternalSequenceKey) obj;
            if (this.f14500a.equals(internalSequenceKey.f14500a) && this.f14501b.equals(internalSequenceKey.f14501b)) {
                return true;
            }
            return false;
        }
    }

    public static com.facebook.sequencelogger.SequenceLoggerImpl m3464a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f1722v;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.sequencelogger.SequenceLoggerImpl.class;
        monitor-enter(r1);
        r0 = f1722v;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m3470b(r0);	 Catch:{ all -> 0x0035 }
        f1722v = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1722v;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.sequencelogger.SequenceLoggerImpl.a(com.facebook.inject.InjectorLike):com.facebook.sequencelogger.SequenceLoggerImpl");
    }

    private static SequenceLoggerImpl m3470b(InjectorLike injectorLike) {
        return new SequenceLoggerImpl(AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), StandardDebugAndTestConfig.m2930a(injectorLike), AnalyticsLoggingPolicy.m2863a(injectorLike), IdleExecutor_SingleThreadedExecutorServiceMethodAutoProvider.m3688a(injectorLike), AppStateManager.m2245a(injectorLike), FbDataConnectionManager.m3787a(injectorLike), SequenceLoggerEventObservableImpl.m4118a(injectorLike), LocalFbBroadcastManager.m2946a(injectorLike), CachedNetworkInfoCollector.m3227a(injectorLike), FbNetworkManager.m3811a(injectorLike), STATICDI_MULTIBIND_PROVIDER$SequenceListener.m4121a(injectorLike));
    }

    @Inject
    public SequenceLoggerImpl(MonotonicClock monotonicClock, Clock clock, AnalyticsLogger analyticsLogger, DebugAndTestConfig debugAndTestConfig, AnalyticsLoggingPolicy analyticsLoggingPolicy, IdleExecutor idleExecutor, AppStateManager appStateManager, FbDataConnectionManager fbDataConnectionManager, SequenceLoggerEventObservable sequenceLoggerEventObservable, FbBroadcastManager fbBroadcastManager, NetworkInfoCollector networkInfoCollector, FbNetworkManager fbNetworkManager, @Nullable Set<SequenceListener> set) {
        this.f1725d = clock;
        this.f1724c = monotonicClock;
        this.f1726e = analyticsLogger;
        this.f1733l = debugAndTestConfig;
        this.f1727f = analyticsLoggingPolicy;
        this.f1728g = idleExecutor;
        this.f1729h = appStateManager;
        this.f1730i = fbDataConnectionManager;
        this.f1731j = fbNetworkManager;
        this.f1732k = sequenceLoggerEventObservable;
        this.f1734m = networkInfoCollector;
        this.f1723a = new LinkedBlockingQueue();
        this.f1735n = new UploadRunnable(this);
        this.f1738q = new AtomicBoolean(false);
        this.f1741t = new NoOpSequence();
        this.f1737p = set;
        SequenceImpl.f2043b = this.f1733l.m2933b();
        m3465a((BaseFbBroadcastManager) fbBroadcastManager);
    }

    private void m3465a(BaseFbBroadcastManager baseFbBroadcastManager) {
        baseFbBroadcastManager.m2951a().mo506a(AppStateManager.f1111c, new C01451(this)).mo503a().m3296b();
    }

    public final <T extends SequenceDefinition> Sequence<T> mo510a(T t) {
        return mo513a(t, null, null, this.f1724c.now());
    }

    public final <T extends SequenceDefinition> Sequence<T> mo511a(T t, ImmutableMap<String, String> immutableMap) {
        return mo513a(t, null, immutableMap, this.f1724c.now());
    }

    public final <T extends SequenceDefinition> Sequence<T> mo512a(T t, @Nullable ImmutableMap<String, String> immutableMap, long j) {
        return mo513a(t, null, immutableMap, j);
    }

    public final <T extends SequenceDefinition> Sequence<T> mo513a(T t, String str, ImmutableMap<String, String> immutableMap, long j) {
        return mo514a((AbstractSequenceDefinition) t, str, (ImmutableMap) immutableMap, j, null);
    }

    public final <T extends SequenceDefinition> Sequence<T> mo514a(T t, String str, ImmutableMap<String, String> immutableMap, long j, @Nullable Boolean bool) {
        int d;
        boolean z;
        boolean z2;
        Preconditions.checkNotNull(t);
        Object c = m3474c(t, str);
        SequenceImpl sequenceImpl = (SequenceImpl) m3475c().get(c);
        boolean e;
        boolean f;
        if (sequenceImpl != null) {
            sequenceImpl.m4197j();
            e = sequenceImpl.m4193e();
            f = sequenceImpl.m4194f();
            d = sequenceImpl.m4190d();
            z = f;
            z2 = e;
        } else {
            ConfigSnapShot c2 = this.f1727f.m2874c();
            f = c2 == null;
            if (f || (this.f1733l.m2933b() && !this.f1733l.m2934d())) {
                e = true;
                d = 1;
            } else {
                d = AnalyticsPerfUtils.m4442a(c2, t.m1017e(), this.f1727f.m2875d());
                e = c2.m4374a();
            }
            if (d == Integer.MAX_VALUE) {
                m3476d(t, str);
                return this.f1741t;
            }
            z = f;
            z2 = e;
        }
        SequenceImpl a = m3463a((AbstractSequenceDefinition) t, str, j, (ImmutableMap) immutableMap, bool);
        if (m3475c().put(c, a) != null) {
            a.m4196g("Sequence was restarted");
        } else if (m3477d()) {
            BLog.a(t.m1015b(), "Starting Sequence");
        }
        a.m4176a(d);
        a.m4177a(z2);
        a.m4184b(z);
        m3476d(t, str);
        return a;
    }

    public final <T extends SequenceDefinition> void mo518b(T t) {
        mo521b(t, null, null, this.f1724c.now());
    }

    public final <T extends SequenceDefinition> void mo519b(T t, ImmutableMap<String, String> immutableMap) {
        mo521b(t, null, immutableMap, this.f1724c.now());
    }

    public final <T extends SequenceDefinition> void mo520b(T t, ImmutableMap<String, String> immutableMap, long j) {
        mo521b(t, null, immutableMap, j);
    }

    public final <T extends SequenceDefinition> void mo521b(T t, String str, ImmutableMap<String, String> immutableMap, long j) {
        m3472b(t, str, immutableMap, j, null);
    }

    private <T extends SequenceDefinition> void m3472b(T t, String str, ImmutableMap<String, String> immutableMap, long j, @Nullable Boolean bool) {
        Preconditions.checkNotNull(t);
        SequenceImpl sequenceImpl = (SequenceImpl) m3475c().remove(m3474c(t, str));
        m3467a((AbstractSequenceDefinition) t, str, (short) 2);
        if (sequenceImpl != null) {
            m3466a((AbstractSequenceDefinition) t, sequenceImpl, (ImmutableMap) immutableMap, j, bool);
        }
    }

    private <T extends SequenceDefinition> void m3466a(T t, SequenceImpl<?> sequenceImpl, ImmutableMap<String, String> immutableMap, long j, @Nullable Boolean bool) {
        List list = null;
        if (m3473b((SequenceImpl) sequenceImpl)) {
            NetworkInfo a = this.f1734m.mo495a();
            if (a != null) {
                list = a.m27417b();
            }
        }
        long a2 = sequenceImpl.m4167a(j, (ImmutableMap) immutableMap, bool, list);
        if (!this.f1733l.m2935e()) {
            this.f1723a.add(sequenceImpl);
            m3471b();
        } else if (!m3469a(this, (SequenceImpl) sequenceImpl)) {
            BLog.a(t.m1015b(), "Could not deliver event at this time!");
        }
        if (this.f1733l.m2933b()) {
            PerfTestLogger.a(t.m1015b(), j, a2);
        } else if (m3477d()) {
            BLog.a(t.m1015b(), "Stopped sequence; Monotonic Timestamp (ms): %d; Total Elapsed: %d ms", new Object[]{Long.valueOf(j), Long.valueOf(a2)});
        }
    }

    public final <T extends SequenceDefinition> void mo522c(T t) {
        Preconditions.checkNotNull(t);
        SequenceImpl sequenceImpl = (SequenceImpl) m3475c().remove(m3474c(t, null));
        m3467a((AbstractSequenceDefinition) t, null, (short) 3);
        if (sequenceImpl == null) {
            BLog.a(t.f486a, "Tried to fail a sequence that wasn't in progress");
            return;
        }
        sequenceImpl.f2051j = true;
        m3466a((AbstractSequenceDefinition) t, sequenceImpl, null, this.f1724c.now(), null);
    }

    public final <T extends SequenceDefinition> void mo523d(T t) {
        mo515a((AbstractSequenceDefinition) t, null);
    }

    public final <T extends SequenceDefinition> void mo515a(T t, @Nullable String str) {
        Preconditions.checkNotNull(t);
        SequenceImpl sequenceImpl = (SequenceImpl) m3475c().remove(m3474c(t, str));
        m3478e(t, str);
        if (sequenceImpl != null) {
            sequenceImpl.m4197j();
        }
    }

    public static void m3468a(SequenceLoggerImpl sequenceLoggerImpl) {
        Iterator it = sequenceLoggerImpl.m3475c().entrySet().iterator();
        while (it.hasNext()) {
            SequenceImpl sequenceImpl = (SequenceImpl) ((Entry) it.next()).getValue();
            if (sequenceImpl != null && sequenceImpl.f2044c.f487b) {
                sequenceLoggerImpl.m3478e(sequenceImpl.f2044c, sequenceImpl.mo617a());
                it.remove();
            }
        }
    }

    public final <T extends SequenceDefinition> Sequence<T> mo524e(T t) {
        return mo517b((AbstractSequenceDefinition) t, null);
    }

    public final <T extends SequenceDefinition> Sequence<T> mo517b(T t, @Nullable String str) {
        Preconditions.checkNotNull(t);
        return (Sequence) m3475c().get(m3474c(t, str));
    }

    public final void mo516a(String str) {
        Iterator it = m3475c().entrySet().iterator();
        while (it.hasNext()) {
            SequenceImpl sequenceImpl = (SequenceImpl) ((Entry) it.next()).getValue();
            if (sequenceImpl != null) {
                ImmutableSet immutableSet = sequenceImpl.f2044c.f488c;
                if (!(immutableSet == null || immutableSet.isEmpty() || immutableSet.contains(str))) {
                    m3478e(sequenceImpl.f2044c, sequenceImpl.mo617a());
                    it.remove();
                }
            }
        }
    }

    private void m3471b() {
        if (this.f1738q.compareAndSet(false, true)) {
            ExecutorDetour.a(this.f1728g, this.f1735n, 1319515120);
        }
    }

    public static boolean m3469a(SequenceLoggerImpl sequenceLoggerImpl, SequenceImpl sequenceImpl) {
        TriState k;
        int[] iArr = 2.a;
        if (sequenceImpl.f2044c.f487b) {
            k = sequenceLoggerImpl.f1729h.m2263k();
        } else {
            k = TriState.NO;
        }
        switch (iArr[k.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                Boolean c = sequenceImpl.f2047f.c();
                c = BackgroundChecker.b.e;
                return true;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                HoneyAnalyticsEvent b = sequenceImpl.f2047f.b();
                b.m5086a("connqual", sequenceLoggerImpl.f1730i.m3801c());
                b.m5090b("network_type", sequenceLoggerImpl.f1731j.m3835k());
                b.m5090b("network_subtype", sequenceLoggerImpl.f1731j.m3836l());
                b.m5083a("sample_rate", sequenceImpl.f2048g);
                b.m5090b("method", PerformanceEventFields.m12724a(sequenceImpl.f2050i, sequenceImpl.f2049h));
                if (sequenceImpl.f2051j) {
                    b.m5090b("status", "failed");
                }
                b.m5083a("marker_id", sequenceImpl.f2044c.f490e);
                sequenceLoggerImpl.f1726e.mo531b(b);
                sequenceLoggerImpl.f1732k.mo609a(b);
                return true;
            case 3:
                return false;
            default:
                return true;
        }
    }

    private boolean m3473b(SequenceImpl<?> sequenceImpl) {
        Object obj;
        if (sequenceImpl.f2044c.f491f != Integer.MAX_VALUE) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            return false;
        }
        ConfigSnapShot c = this.f1727f.m2874c();
        if (c != null) {
            if (AnalyticsPerfUtils.m4442a(c, 6094849, this.f1727f.f1478d) != Integer.MAX_VALUE) {
                return true;
            }
            return false;
        } else if (AnalyticsPerfUtils.m4441a(sequenceImpl.f2044c.f491f, this.f1727f.f1478d) != Integer.MAX_VALUE) {
            return true;
        } else {
            return false;
        }
    }

    private ConcurrentMap<Object, SequenceImpl<?>> m3475c() {
        ConcurrentMap<Object, SequenceImpl<?>> concurrentMap = this.f1736o;
        if (concurrentMap == null) {
            synchronized (this) {
                concurrentMap = this.f1736o;
                if (concurrentMap == null) {
                    concurrentMap = Maps.m843e();
                    this.f1736o = concurrentMap;
                }
            }
        }
        return concurrentMap;
    }

    private <T extends SequenceDefinition> SequenceImpl<T> m3463a(T t, @Nullable String str, long j, @Nullable ImmutableMap<String, String> immutableMap, @Nullable Boolean bool) {
        return new SequenceImpl(t, str, this.f1724c, this.f1725d, j, immutableMap, bool);
    }

    private static Object m3474c(AbstractSequenceDefinition abstractSequenceDefinition, @Nullable String str) {
        return str == null ? abstractSequenceDefinition.f486a : new InternalSequenceKey(abstractSequenceDefinition.f486a, str);
    }

    private boolean m3477d() {
        if (this.f1742u == TriState.UNSET) {
            this.f1742u = this.f1733l.m2932a();
            SequenceImpl.f2042a = this.f1742u.asBoolean(false);
        }
        return this.f1742u.asBoolean(false);
    }

    private void m3476d(AbstractSequenceDefinition abstractSequenceDefinition, String str) {
        if (this.f1737p != null) {
            int hashCode = str == null ? 0 : str.hashCode();
            for (SequenceListenerForLoom sequenceListenerForLoom : this.f1737p) {
                boolean a;
                TraceControl traceControl = TraceControl.b;
                if (traceControl != null) {
                    a = traceControl.a(16, 0, abstractSequenceDefinition, hashCode);
                } else {
                    a = false;
                }
                long j = (((long) hashCode) << 16) & 281474976645120L;
                if (a) {
                    j |= 562949953421312L;
                }
                Logger.a(4, EntryType.QPL_START, abstractSequenceDefinition.f490e, j);
            }
        }
    }

    private void m3467a(AbstractSequenceDefinition abstractSequenceDefinition, String str, short s) {
        if (this.f1737p != null) {
            int hashCode = str == null ? 0 : str.hashCode();
            for (SequenceListenerForLoom sequenceListenerForLoom : this.f1737p) {
                Logger.a(4, EntryType.QPL_END, abstractSequenceDefinition.f490e, (((long) hashCode) << 16) | ((long) s));
                TraceControl traceControl = TraceControl.b;
                if (traceControl != null) {
                    traceControl.a(16, abstractSequenceDefinition, hashCode);
                }
            }
        }
    }

    private void m3478e(AbstractSequenceDefinition abstractSequenceDefinition, String str) {
        if (this.f1737p != null) {
            int hashCode = str == null ? 0 : str.hashCode();
            for (SequenceListenerForLoom sequenceListenerForLoom : this.f1737p) {
                Logger.a(4, EntryType.QPL_CANCEL, abstractSequenceDefinition.f490e, ((long) hashCode) << 16);
                TraceControl traceControl = TraceControl.b;
                if (traceControl != null) {
                    traceControl.b(16, abstractSequenceDefinition, hashCode);
                }
            }
        }
    }
}
