package com.facebook.common.memory;

import android.content.Context;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.dextricks.BackgroundFadviseHack;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.init.INeedInit;
import com.facebook.common.process.DefaultProcessUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.debug.log.BLog;
import com.facebook.device.resourcemonitor.ResourceManager;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMaker;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: sem_install_referrer_use_graphql_mutation */
public class MemoryManager implements INeedInit, MemoryTrimmableRegistry {
    private static final Class<?> f5686b = MemoryManager.class;
    private static volatile MemoryManager f5687q;
    @VisibleForTesting
    boolean f5688a = false;
    private final AppStateManager f5689c;
    private final ExecutorService f5690d;
    private final Clock f5691e;
    private final DefaultProcessUtil f5692f;
    private final QeAccessor f5693g;
    private final BaseFbBroadcastManager f5694h;
    private final String f5695i;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<ResourceManager> f5696j = UltralightRuntime.f368b;
    private final Map<MemoryTrimmable, Boolean> f5697k;
    private SelfRegistrableReceiverImpl f5698l;
    private ActionReceiver f5699m;
    private 1 f5700n;
    private long f5701o = 0;
    private AtomicBoolean f5702p = new AtomicBoolean(false);

    public static com.facebook.common.memory.MemoryManager m9807a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5687q;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.common.memory.MemoryManager.class;
        monitor-enter(r1);
        r0 = f5687q;	 Catch:{ all -> 0x003a }
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
        r0 = m9809b(r0);	 Catch:{ all -> 0x0035 }
        f5687q = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5687q;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.memory.MemoryManager.a(com.facebook.inject.InjectorLike):com.facebook.common.memory.MemoryManager");
    }

    private static MemoryManager m9809b(InjectorLike injectorLike) {
        MemoryManager memoryManager = new MemoryManager(AppStateManager.m2245a(injectorLike), LocalFbBroadcastManager.m2946a(injectorLike), C0055x2995691a.m1881a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), DefaultProcessUtil.m2387a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), (Context) injectorLike.getInstance(Context.class, ForAppContext.class));
        memoryManager.f5696j = IdBasedSingletonScopeProvider.m1810b(injectorLike, 1066);
        return memoryManager;
    }

    @Inject
    public MemoryManager(AppStateManager appStateManager, BaseFbBroadcastManager baseFbBroadcastManager, ExecutorService executorService, Clock clock, DefaultProcessUtil defaultProcessUtil, QeAccessor qeAccessor, @ForAppContext Context context) {
        this.f5689c = appStateManager;
        this.f5694h = baseFbBroadcastManager;
        this.f5690d = executorService;
        this.f5691e = clock;
        this.f5692f = defaultProcessUtil;
        this.f5693g = qeAccessor;
        this.f5695i = m9808a(context);
        this.f5697k = new MapMaker().m1485e().m1489l();
    }

    private static String m9808a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.dataDir;
        } catch (Exception e) {
            return "";
        }
    }

    public void init() {
        if (!this.f5688a) {
            this.f5700n = new 1(this);
            ResourceManager resourceManager = (ResourceManager) this.f5696j.get();
            resourceManager.f5321g.put(this.f5700n, Integer.valueOf(1));
            if (this.f5692f.m2389a().e()) {
                this.f5699m = new 2(this);
                this.f5698l = this.f5694h.m2951a().mo506a(AppStateManager.f1111c, this.f5699m).mo503a();
                this.f5698l.m3296b();
            }
            this.f5688a = true;
        }
    }

    public final synchronized void mo1390a(MemoryTrimmable memoryTrimmable) {
        Preconditions.checkNotNull(memoryTrimmable, "MemoryTrimmable cannot be null.");
        this.f5697k.put(memoryTrimmable, Boolean.TRUE);
        memoryTrimmable.getClass().getName();
    }

    public final void m9812a() {
        m9810b(this.f5689c.m2262j() ? MemoryTrimType.OnSystemLowMemoryWhileAppInBackground : MemoryTrimType.OnSystemLowMemoryWhileAppInForeground);
    }

    public final void m9815b() {
        m9810b(MemoryTrimType.OnAppBackgrounded);
    }

    public final void m9816c() {
        if (m9811d()) {
            m9813a(MemoryTrimType.OnCloseToDalvikHeapLimit);
        }
    }

    private void m9810b(MemoryTrimType memoryTrimType) {
        if (m9811d()) {
            ExecutorDetour.a(this.f5690d, new 3(this, memoryTrimType), -1905866682);
        }
    }

    @VisibleForTesting
    final synchronized void m9813a(MemoryTrimType memoryTrimType) {
        try {
            for (MemoryTrimmable a : this.f5697k.keySet()) {
                a.mo1395a(memoryTrimType);
            }
            memoryTrimType.name();
            this.f5702p.set(false);
            if (this.f5693g.mo596a(ExperimentsForMemoryModule.a, false)) {
                try {
                    BackgroundFadviseHack.pageOutNativeLibs(this.f5695i);
                } catch (Throwable e) {
                    BLog.b(f5686b, "Couldn't apply fadvise", e);
                }
            }
        } catch (Throwable th) {
            this.f5702p.set(false);
        }
    }

    @VisibleForTesting
    private boolean m9811d() {
        long j = this.f5689c.m2262j() ? 5000 : 60000;
        long a = this.f5691e.mo211a();
        if (a - this.f5701o < j || !this.f5702p.compareAndSet(false, true)) {
            return false;
        }
        this.f5701o = a;
        return true;
    }
}
