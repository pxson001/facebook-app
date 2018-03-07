package com.facebook.prefs.shared;

import com.facebook.common.executors.C0061x63d21d68;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.tools.dextr.runtime.detour.ObjectDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: vnd.android.cursor.item/vnd.facebook.katana.bookmark_sync_status */
public class FbSharedPreferencesCache {
    private static final Class<?> f969b = FbSharedPreferencesCache.class;
    private static volatile FbSharedPreferencesCache f970m;
    private final FbSharedPreferencesStorage f971a;
    @GuardedBy("this")
    private final Map<PrefKey, Object> f972c = new HashMap();
    @GuardedBy("this")
    private final Map<PrefKey, Object> f973d = new HashMap(16);
    @GuardedBy("this")
    private final Collection<PrefKey> f974e = new HashSet(4);
    private final ScheduledExecutorService f975f;
    private final Object f976g = new Object();
    @GuardedBy("this")
    private boolean f977h;
    private volatile boolean f978i;
    private final List<OnChangesListener> f979j = new CopyOnWriteArrayList();
    private volatile long f980k = 0;
    private volatile boolean f981l = false;

    public static com.facebook.prefs.shared.FbSharedPreferencesCache m1978a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f970m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.prefs.shared.FbSharedPreferencesCache.class;
        monitor-enter(r1);
        r0 = f970m;	 Catch:{ all -> 0x003a }
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
        r0 = m1981b(r0);	 Catch:{ all -> 0x0035 }
        f970m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f970m;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.prefs.shared.FbSharedPreferencesCache.a(com.facebook.inject.InjectorLike):com.facebook.prefs.shared.FbSharedPreferencesCache");
    }

    private static FbSharedPreferencesCache m1981b(InjectorLike injectorLike) {
        return new FbSharedPreferencesCache(new FbSharedPreferencesDbStorage(SharedPrefsDatabaseSupplier.m2018a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 494), Random_InsecureRandomMethodAutoProvider.m2102a(injectorLike), new STATICDI_MULTIBIND_PROVIDER$FbSharedPreferencesDbUpgradeStep(injectorLike.getScopeAwareInjector())), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new C0060x8511322(injectorLike)), C0061x63d21d68.m2106b(injectorLike));
    }

    @Inject
    public FbSharedPreferencesCache(FbSharedPreferencesStorage fbSharedPreferencesStorage, Set<OnChangesListener> set, ScheduledExecutorService scheduledExecutorService) {
        this.f971a = fbSharedPreferencesStorage;
        this.f979j.addAll(set);
        this.f975f = scheduledExecutorService;
    }

    public final synchronized void m1990a() {
        TracerDetour.a("FbSharedPreferencesCache.init", 1480674892);
        try {
            TracerDetour.a("FbSharedPreferencesCache.loadInitialValues", -887961548);
            try {
                int i = this.f971a;
                i.mo315a(this.f972c);
                TracerDetour.a(i);
                this.f978i = true;
                ObjectDetour.c(this, 356393652);
                TracerDetour.a(2099955714);
            } finally {
                TracerDetour.a(-898275842);
            }
        } finally {
            TracerDetour.a(654033306);
        }
    }

    public final void m1992a(FbSharedPreferencesImpl fbSharedPreferencesImpl) {
        this.f979j.add(fbSharedPreferencesImpl);
    }

    public final void m1991a(long j) {
        this.f980k = j;
    }

    public final void m1996b() {
        this.f981l = true;
        m1983d();
    }

    private synchronized void m1983d() {
        if (!this.f977h && this.f981l) {
            this.f975f.schedule(new 1(this), this.f980k, TimeUnit.MILLISECONDS);
            this.f977h = true;
        }
    }

    public static void m1984e(FbSharedPreferencesCache fbSharedPreferencesCache) {
        synchronized (fbSharedPreferencesCache) {
            Map f = fbSharedPreferencesCache.m1985f();
            Collection g = fbSharedPreferencesCache.m1986g();
        }
        synchronized (fbSharedPreferencesCache.f976g) {
            fbSharedPreferencesCache.f971a.mo316a(f, g);
        }
    }

    public final void m1993a(Map<PrefKey, Object> map, Collection<PrefKey> collection) {
        if (!map.isEmpty() || !collection.isEmpty()) {
            Collection arrayList = new ArrayList(map.size() + collection.size());
            synchronized (this) {
                m1982b(map, arrayList);
                m1979a((Collection) collection, arrayList);
            }
            m1983d();
            for (FbSharedPreferencesImpl a : this.f979j) {
                a.m1840a(arrayList);
            }
        }
    }

    @GuardedBy("this")
    private Collection<PrefKey> m1982b(Map<PrefKey, Object> map, Collection<PrefKey> collection) {
        for (Entry entry : map.entrySet()) {
            PrefKey prefKey = (PrefKey) entry.getKey();
            Object value = entry.getValue();
            if (!Objects.equal(this.f972c.get(prefKey), value)) {
                collection.add(prefKey);
                this.f972c.put(prefKey, value);
                this.f973d.put(prefKey, value);
                this.f974e.remove(prefKey);
            }
        }
        return collection;
    }

    @GuardedBy("this")
    private Collection<PrefKey> m1979a(Collection<PrefKey> collection, Collection<PrefKey> collection2) {
        for (PrefKey prefKey : collection) {
            if (this.f972c.containsKey(prefKey)) {
                collection2.add(prefKey);
                this.f972c.remove(prefKey);
                this.f974e.add(prefKey);
                this.f973d.remove(prefKey);
            }
        }
        return collection2;
    }

    @GuardedBy("this")
    private Map<PrefKey, Object> m1985f() {
        if (this.f973d.isEmpty()) {
            return Collections.emptyMap();
        }
        Map<PrefKey, Object> hashMap = new HashMap(this.f973d);
        this.f973d.clear();
        return hashMap;
    }

    @GuardedBy("this")
    private Collection<PrefKey> m1986g() {
        if (this.f974e.isEmpty()) {
            return Collections.emptySet();
        }
        Collection<PrefKey> hashSet = new HashSet(this.f974e);
        this.f974e.clear();
        return hashSet;
    }

    public final void m1998c() {
        synchronized (this) {
            m1988i();
            Map hashMap = new HashMap(this.f972c);
        }
        for (Entry entry : hashMap.entrySet()) {
            entry.getKey();
            entry.getValue();
        }
    }

    private boolean m1987h() {
        return this.f978i;
    }

    private synchronized void m1988i() {
        Preconditions.checkState(this.f978i, "FbSharedPreferencesCache used before initialized");
    }

    private synchronized void m1989j() {
        while (!m1987h()) {
            ObjectDetour.a(this, -81469854);
        }
    }

    public final synchronized boolean m1994a(PrefKey prefKey) {
        m1988i();
        return this.f972c.containsKey(prefKey);
    }

    public final synchronized Object m1995b(PrefKey prefKey) {
        try {
            m1989j();
        } catch (Throwable e) {
            Thread.currentThread().interrupt();
            BLog.b(f969b, e, "Error while trying to initialize shared prefs", new Object[0]);
            Preconditions.checkState(this.f978i, "Interrupted before FbSharedPreferencesCache initialized");
        }
        return this.f972c.get(prefKey);
    }

    public final synchronized SortedMap<PrefKey, Object> m1997c(PrefKey prefKey) {
        m1988i();
        return PrefKeyUtil.m8910a(this.f972c, prefKey);
    }
}
