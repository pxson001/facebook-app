package com.facebook.abtest.qe.cache;

import android.content.Context;
import android.content.Intent;
import com.facebook.abtest.qe.bootstrap.cache.QuickExperimentMemoryCache;
import com.facebook.abtest.qe.bootstrap.cache.QuickExperimentMemoryCache.QuickExperimentMemoryCacheInitializer;
import com.facebook.abtest.qe.bootstrap.cache.QuickExperimentMemoryCache.QuickExperimentMemoryCacheObserver;
import com.facebook.abtest.qe.bootstrap.data.BasicQuickExperimentInfo;
import com.facebook.abtest.qe.bootstrap.data.QuickExperimentInfo;
import com.facebook.abtest.qe.bootstrap.db.DataSource;
import com.facebook.abtest.qe.data.SerializedQuickExperimentInfo;
import com.facebook.abtest.qe.db.QuickExperimentDeserializer;
import com.facebook.abtest.qe.db.ReadExperimentsHandler;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryInterfaces.Configuration;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryModels.ConfigurationModel;
import com.facebook.abtest.qe.utils.LocaleUtil;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.CrossProcessFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.common.process.ProcessName;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: update_folder_counts */
public class QuickExperimentMemoryCacheImpl implements QuickExperimentMemoryCache {
    private static final Class<QuickExperimentMemoryCacheImpl> f1787a = QuickExperimentMemoryCacheImpl.class;
    private static volatile QuickExperimentMemoryCacheImpl f1788r;
    public final SettableFuture<QuickExperimentMemoryCache> f1789b = SettableFuture.m1547f();
    @GuardedBy("this")
    private final Map<String, BasicQuickExperimentInfo> f1790c = Maps.m838c();
    @GuardedBy("this")
    private final Map<String, BasicQuickExperimentInfo> f1791d = Maps.m838c();
    @GuardedBy("this")
    private final Map<String, QuickExperimentInfo> f1792e = Maps.m838c();
    private final ReadExperimentsHandler f1793f;
    public final BaseFbBroadcastManager f1794g;
    public final Lazy<ExecutorService> f1795h;
    public final Lazy<ProcessName> f1796i;
    private final Lazy<LocaleUtil> f1797j;
    private final Lazy<FbErrorReporter> f1798k;
    private final Lazy<QuickExperimentDeserializer> f1799l;
    public final QuickExperimentMemoryCacheObserverManager f1800m;
    private final Lazy<FbObjectMapper> f1801n;
    private volatile boolean f1802o;
    private Set<String> f1803p;
    private final Lazy<PerfTestConfig> f1804q;

    /* compiled from: update_folder_counts */
    class C01355 implements QuickExperimentMemoryCacheInitializer {
        final /* synthetic */ QuickExperimentMemoryCacheImpl f1851a;

        C01355(QuickExperimentMemoryCacheImpl quickExperimentMemoryCacheImpl) {
            this.f1851a = quickExperimentMemoryCacheImpl;
        }

        public final void mo556a() {
            QuickExperimentMemoryCacheImpl quickExperimentMemoryCacheImpl = this.f1851a;
            quickExperimentMemoryCacheImpl.f1794g.m2951a().mo506a("com.facebook.abtest.action.UPDATE_CACHE", new C01404(quickExperimentMemoryCacheImpl, new C01381(quickExperimentMemoryCacheImpl))).mo506a("com.facebook.abtest.action.CLEAR_CACHE", new C01413(quickExperimentMemoryCacheImpl, new C01392(quickExperimentMemoryCacheImpl))).mo503a().m3296b();
            this.f1851a.mo541b();
            if (!this.f1851a.f1789b.isDone()) {
                FutureDetour.a(this.f1851a.f1789b, this.f1851a, -558197393);
            }
        }
    }

    /* compiled from: update_folder_counts */
    public class C01381 implements Runnable {
        final /* synthetic */ QuickExperimentMemoryCacheImpl f1986a;

        public C01381(QuickExperimentMemoryCacheImpl quickExperimentMemoryCacheImpl) {
            this.f1986a = quickExperimentMemoryCacheImpl;
        }

        public void run() {
            this.f1986a.mo541b();
        }
    }

    /* compiled from: update_folder_counts */
    public class C01392 implements Runnable {
        final /* synthetic */ QuickExperimentMemoryCacheImpl f1987a;

        public C01392(QuickExperimentMemoryCacheImpl quickExperimentMemoryCacheImpl) {
            this.f1987a = quickExperimentMemoryCacheImpl;
        }

        public void run() {
            this.f1987a.m3624f();
        }
    }

    /* compiled from: update_folder_counts */
    public class C01404 implements ActionReceiver {
        final /* synthetic */ Runnable f1988a;
        final /* synthetic */ QuickExperimentMemoryCacheImpl f1989b;

        public C01404(QuickExperimentMemoryCacheImpl quickExperimentMemoryCacheImpl, Runnable runnable) {
            this.f1989b = quickExperimentMemoryCacheImpl;
            this.f1988a = runnable;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1068012154);
            String stringExtra = intent.getStringExtra("process_name");
            if (stringExtra == null || !stringExtra.equals(((ProcessName) this.f1989b.f1796i.get()).b)) {
                ExecutorDetour.a((ExecutorService) this.f1989b.f1795h.get(), this.f1988a, -699527601);
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -684293416, a);
        }
    }

    /* compiled from: update_folder_counts */
    public class C01413 implements ActionReceiver {
        final /* synthetic */ Runnable f1990a;
        final /* synthetic */ QuickExperimentMemoryCacheImpl f1991b;

        public C01413(QuickExperimentMemoryCacheImpl quickExperimentMemoryCacheImpl, Runnable runnable) {
            this.f1991b = quickExperimentMemoryCacheImpl;
            this.f1990a = runnable;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1305093667);
            ExecutorDetour.a((ExecutorService) this.f1991b.f1795h.get(), this.f1990a, 224665664);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1353962052, a);
        }
    }

    /* compiled from: update_folder_counts */
    /* synthetic */ class C04216 {
        static final /* synthetic */ int[] f9994a = new int[DataSource.values().length];

        static {
            try {
                f9994a[DataSource.FROM_SERVER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9994a[DataSource.FROM_USER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static com.facebook.abtest.qe.cache.QuickExperimentMemoryCacheImpl m3605a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1788r;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.abtest.qe.cache.QuickExperimentMemoryCacheImpl.class;
        monitor-enter(r1);
        r0 = f1788r;	 Catch:{ all -> 0x003a }
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
        r0 = m3608b(r0);	 Catch:{ all -> 0x0035 }
        f1788r = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1788r;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.abtest.qe.cache.QuickExperimentMemoryCacheImpl.a(com.facebook.inject.InjectorLike):com.facebook.abtest.qe.cache.QuickExperimentMemoryCacheImpl");
    }

    private static QuickExperimentMemoryCacheImpl m3608b(InjectorLike injectorLike) {
        return new QuickExperimentMemoryCacheImpl(ReadExperimentsHandler.m3635b(injectorLike), CrossProcessFbBroadcastManager.m3644a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3834), IdBasedLazy.m1808a(injectorLike, 595), IdBasedLazy.m1808a(injectorLike, 98), IdBasedSingletonScopeProvider.m1810b(injectorLike, 494), IdBasedSingletonScopeProvider.m1810b(injectorLike, 4563), QuickExperimentMemoryCacheObserverManager.m3652a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 593), IdBasedSingletonScopeProvider.m1810b(injectorLike, 572));
    }

    @Inject
    public QuickExperimentMemoryCacheImpl(ReadExperimentsHandler readExperimentsHandler, FbBroadcastManager fbBroadcastManager, Lazy<ExecutorService> lazy, Lazy<ProcessName> lazy2, Lazy<LocaleUtil> lazy3, Lazy<FbErrorReporter> lazy4, Lazy<QuickExperimentDeserializer> lazy5, QuickExperimentMemoryCacheObserverManager quickExperimentMemoryCacheObserverManager, Lazy<PerfTestConfig> lazy6, Lazy<FbObjectMapper> lazy7) {
        this.f1793f = readExperimentsHandler;
        this.f1794g = fbBroadcastManager;
        this.f1795h = lazy;
        this.f1796i = lazy2;
        this.f1797j = lazy3;
        this.f1798k = lazy4;
        this.f1799l = lazy5;
        this.f1800m = quickExperimentMemoryCacheObserverManager;
        this.f1802o = false;
        this.f1803p = null;
        this.f1804q = lazy6;
        this.f1801n = lazy7;
    }

    private void m3607a(boolean z) {
        if (z) {
            try {
                ReadExperimentsHandler readExperimentsHandler = this.f1793f;
                DataSource dataSource = DataSource.FROM_SERVER;
                Set b = readExperimentsHandler.m3638b();
                ReadExperimentsHandler readExperimentsHandler2 = this.f1793f;
                DataSource dataSource2 = DataSource.FROM_USER;
                m3606a(b, readExperimentsHandler2.m3638b());
            } catch (Throwable e) {
                ((AbstractFbErrorReporter) this.f1798k.get()).m2343a("QuickExperimentCache", "Can't load quick experiment data from disk. Clean all content from memory cache", e);
                m3624f();
                return;
            }
        }
        readExperimentsHandler = this.f1793f;
        dataSource = DataSource.FROM_SERVER;
        b = readExperimentsHandler.m3639c();
        readExperimentsHandler2 = this.f1793f;
        dataSource2 = DataSource.FROM_USER;
        m3606a(b, readExperimentsHandler2.m3638b());
        m3613g();
    }

    public final ListenableFuture<QuickExperimentMemoryCache> mo538a() {
        return this.f1789b;
    }

    public final void mo541b() {
        m3607a(false);
    }

    public final void mo542c() {
        m3607a(true);
    }

    public final Map<String, Configuration> mo543d() {
        Map<String, Configuration> hashMap = new HashMap();
        for (Entry entry : this.f1793f.m3637a().entrySet()) {
            ConfigurationModel c = m3610c((String) entry.getValue());
            if (c != null) {
                hashMap.put(entry.getKey(), c);
            }
        }
        return hashMap;
    }

    @Nullable
    public final ConfigurationModel mo537a(String str) {
        return m3610c(this.f1793f.m3636a(str));
    }

    private ConfigurationModel m3610c(@Nullable String str) {
        if (str == null) {
            return null;
        }
        try {
            return (ConfigurationModel) ((FbObjectMapper) this.f1801n.get()).m6657a(str, ConfigurationModel.class);
        } catch (Throwable e) {
            BLog.a(f1787a, e, "Error parsing %s", new Object[]{str});
            return null;
        }
    }

    @VisibleForTesting
    private synchronized void m3606a(Set<SerializedQuickExperimentInfo> set, Set<SerializedQuickExperimentInfo> set2) {
        this.f1790c.clear();
        this.f1791d.clear();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            m3609b((BasicQuickExperimentInfo) it.next(), DataSource.FROM_SERVER);
        }
        it = set2.iterator();
        while (it.hasNext()) {
            m3609b((BasicQuickExperimentInfo) it.next(), DataSource.FROM_USER);
        }
        if (BLog.b(3)) {
            new StringBuilder("Load quick experiment data from disk.\nProcess (").append(((ProcessName) this.f1796i.get()).f()).append(")\nUser defined(").append(this.f1791d.size()).append(")\nServer define(").append(this.f1790c.size()).append(").\n");
            this.f1804q.get();
            if (PerfTestConfigBase.m2938a()) {
                Iterator it2 = ImmutableSortedSet.m4689d().c(this.f1790c.keySet()).c(this.f1791d.keySet()).c().iterator();
                while (it2.hasNext()) {
                    BasicQuickExperimentInfo basicQuickExperimentInfo;
                    String str = (String) it2.next();
                    BasicQuickExperimentInfo basicQuickExperimentInfo2 = (BasicQuickExperimentInfo) this.f1791d.get(str);
                    if (basicQuickExperimentInfo2 == null) {
                        basicQuickExperimentInfo = (BasicQuickExperimentInfo) this.f1790c.get(str);
                    } else {
                        basicQuickExperimentInfo = basicQuickExperimentInfo2;
                    }
                    if (basicQuickExperimentInfo != null) {
                    }
                }
            }
        }
        this.f1802o = true;
    }

    public final QuickExperimentInfo mo540b(@Nonnull String str) {
        Preconditions.checkNotNull(str);
        if (!this.f1802o) {
            m3611d(str);
        }
        QuickExperimentInfo a = mo536a(str, DataSource.FROM_USER);
        if (a == null) {
            a = mo536a(str, DataSource.FROM_SERVER);
        }
        if (a == null) {
            return m3612e(str);
        }
        return a;
    }

    private synchronized void m3611d(String str) {
        if (this.f1803p == null) {
            this.f1803p = Sets.m1313a();
        }
        if (!this.f1803p.contains(str)) {
            this.f1803p.add(str);
            ((AbstractFbErrorReporter) this.f1798k.get()).mo336a(SoftError.a("MissingQuickExperimentInfo", "QE info for experiment " + str + " was requested before caching was complete").b(true).g());
        }
    }

    public final synchronized QuickExperimentInfo mo536a(@Nonnull String str, @Nonnull DataSource dataSource) {
        QuickExperimentInfo a;
        Preconditions.checkNotNull(str);
        switch (C04216.f9994a[dataSource.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                a = m3604a((BasicQuickExperimentInfo) this.f1790c.get(str), dataSource);
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                a = m3604a((BasicQuickExperimentInfo) this.f1791d.get(str), dataSource);
                break;
            default:
                throw new IllegalStateException("Unknown experiment data source " + dataSource);
        }
        return a;
    }

    private synchronized QuickExperimentInfo m3604a(@Nullable BasicQuickExperimentInfo basicQuickExperimentInfo, DataSource dataSource) {
        if (basicQuickExperimentInfo != null) {
            if (!(basicQuickExperimentInfo instanceof QuickExperimentInfo)) {
                basicQuickExperimentInfo = ((QuickExperimentDeserializer) this.f1799l.get()).a((SerializedQuickExperimentInfo) basicQuickExperimentInfo);
                m3609b(basicQuickExperimentInfo, dataSource);
            }
        }
        basicQuickExperimentInfo = (QuickExperimentInfo) basicQuickExperimentInfo;
        return basicQuickExperimentInfo;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @com.google.common.annotations.VisibleForTesting
    private synchronized com.facebook.abtest.qe.bootstrap.data.QuickExperimentInfo m3612e(java.lang.String r4) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.f1792e;	 Catch:{ all -> 0x005d }
        r0 = r0.get(r4);	 Catch:{ all -> 0x005d }
        r0 = (com.facebook.abtest.qe.bootstrap.data.QuickExperimentInfo) r0;	 Catch:{ all -> 0x005d }
        if (r0 == 0) goto L_0x001e;
    L_0x000b:
        r1 = r3.f1797j;	 Catch:{ all -> 0x005d }
        r1.get();	 Catch:{ all -> 0x005d }
        r1 = com.facebook.abtest.qe.utils.LocaleUtil.m10179a();	 Catch:{ all -> 0x005d }
        r2 = r0.m15057j();	 Catch:{ all -> 0x005d }
        r1 = r1.equals(r2);	 Catch:{ all -> 0x005d }
        if (r1 != 0) goto L_0x005b;
    L_0x001e:
        r0 = new com.facebook.abtest.qe.bootstrap.data.QuickExperimentInfo$Builder;	 Catch:{ all -> 0x005d }
        r0.<init>();	 Catch:{ all -> 0x005d }
        r0 = r0.m15040e(r4);	 Catch:{ all -> 0x005d }
        r1 = "";
        r0 = r0.m15042g(r1);	 Catch:{ all -> 0x005d }
        r1 = "local_default_group";
        r0 = r0.m15041f(r1);	 Catch:{ all -> 0x005d }
        r1 = 0;
        r0 = r0.m15037c(r1);	 Catch:{ all -> 0x005d }
        r1 = 0;
        r0 = r0.m15039d(r1);	 Catch:{ all -> 0x005d }
        r1 = r3.f1797j;	 Catch:{ all -> 0x005d }
        r1.get();	 Catch:{ all -> 0x005d }
        r1 = com.facebook.abtest.qe.utils.LocaleUtil.m10179a();	 Catch:{ all -> 0x005d }
        r0 = r0.m15043h(r1);	 Catch:{ all -> 0x005d }
        r1 = com.google.common.collect.ImmutableBiMap.m976a();	 Catch:{ all -> 0x005d }
        r0 = r0.m15032a(r1);	 Catch:{ all -> 0x005d }
        r0 = r0.m15033a();	 Catch:{ all -> 0x005d }
        r1 = r3.f1792e;	 Catch:{ all -> 0x005d }
        r1.put(r4, r0);	 Catch:{ all -> 0x005d }
    L_0x005b:
        monitor-exit(r3);
        return r0;
    L_0x005d:
        r0 = move-exception;
        monitor-exit(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.abtest.qe.cache.QuickExperimentMemoryCacheImpl.e(java.lang.String):com.facebook.abtest.qe.bootstrap.data.QuickExperimentInfo");
    }

    @VisibleForTesting
    private synchronized void m3609b(BasicQuickExperimentInfo basicQuickExperimentInfo, DataSource dataSource) {
        switch (C04216.f9994a[dataSource.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                this.f1790c.put(basicQuickExperimentInfo.m15055g(), basicQuickExperimentInfo);
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                this.f1791d.put(basicQuickExperimentInfo.m15055g(), basicQuickExperimentInfo);
                break;
            default:
                throw new IllegalStateException("Unknown experiment data source " + dataSource);
        }
    }

    public final void mo539a(QuickExperimentMemoryCacheObserver quickExperimentMemoryCacheObserver) {
        this.f1800m.m3655a(quickExperimentMemoryCacheObserver);
    }

    private void m3613g() {
        this.f1800m.m3654a();
    }

    private synchronized void m3614i() {
        this.f1802o = false;
        this.f1790c.clear();
        this.f1791d.clear();
        if (BLog.b(3)) {
            new StringBuilder("Clear memory cache in process (").append(((ProcessName) this.f1796i.get()).f()).append(")");
        }
    }

    @VisibleForTesting
    public final void m3624f() {
        m3614i();
        this.f1800m.m3656b();
    }

    public final QuickExperimentMemoryCacheInitializer mo544e() {
        return new C01355(this);
    }
}
