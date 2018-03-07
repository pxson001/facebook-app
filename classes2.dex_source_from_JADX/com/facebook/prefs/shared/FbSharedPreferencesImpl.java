package com.facebook.prefs.shared;

import android.annotation.SuppressLint;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.internal.config.FbSharedPreferencesDefaultConfigModule;
import com.facebook.prefs.shared.internal.config.FbSharedPreferencesInitializer;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.ObjectDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.collect.Queues;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@SuppressLint({"SharedPreferencesUse"})
@ThreadSafe
/* compiled from: waiters */
public class FbSharedPreferencesImpl implements FbSharedPreferences {
    private static final Class<?> f914a = FbSharedPreferencesImpl.class;
    private static final String f915b = (f914a.getSimpleName() + "_NULL_PREF");
    private static volatile FbSharedPreferencesImpl f916l;
    private final FbSharedPreferencesInitializer f917c;
    private final int f918d;
    private final ExecutorService f919e;
    private final ExecutorService f920f;
    private final Lazy<FbErrorReporter> f921g;
    private final PrefsListeners f922h;
    public final Queue<Runnable> f923i;
    private final FbSharedPreferencesCache f924j;
    private volatile boolean f925k;

    /* compiled from: waiters */
    class C01741 implements Runnable {
        final /* synthetic */ FbSharedPreferencesImpl f2681a;

        C01741(FbSharedPreferencesImpl fbSharedPreferencesImpl) {
            this.f2681a = fbSharedPreferencesImpl;
        }

        public void run() {
            Runnable runnable = (Runnable) this.f2681a.f923i.poll();
            while (runnable != null) {
                runnable.run();
                runnable = (Runnable) this.f2681a.f923i.poll();
            }
        }
    }

    /* compiled from: waiters */
    public class EditorImpl implements Editor {
        final /* synthetic */ FbSharedPreferencesImpl f4976a;
        private final Map<PrefKey, Object> f4977b = new HashMap(4);
        public Set<PrefKey> f4978c;

        public EditorImpl(FbSharedPreferencesImpl fbSharedPreferencesImpl) {
            this.f4976a = fbSharedPreferencesImpl;
        }

        private Set<PrefKey> m8898a() {
            if (this.f4978c == null) {
                this.f4978c = new HashSet(4);
            }
            return this.f4978c;
        }

        private void m8899a(Collection<PrefKey> collection) {
            for (PrefKey remove : collection) {
                this.f4977b.remove(remove);
            }
        }

        private Editor m8897a(PrefKey prefKey, Object obj) {
            this.f4977b.put(prefKey, obj);
            if (this.f4978c != null) {
                this.f4978c.remove(prefKey);
            }
            return this;
        }

        public final synchronized Editor mo1276a(PrefKey prefKey, String str) {
            if (str == null) {
                mo1271a(prefKey);
                FbSharedPreferencesImpl.m1830f(this.f4976a, prefKey);
            } else {
                m8897a(prefKey, (Object) str);
            }
            return this;
        }

        public synchronized Editor putBoolean(PrefKey prefKey, boolean z) {
            return m8897a(prefKey, Boolean.valueOf(z));
        }

        public final synchronized Editor mo1274a(PrefKey prefKey, int i) {
            return m8897a(prefKey, Integer.valueOf(i));
        }

        public final synchronized Editor mo1275a(PrefKey prefKey, long j) {
            return m8897a(prefKey, Long.valueOf(j));
        }

        public final synchronized Editor mo1273a(PrefKey prefKey, float f) {
            return m8897a(prefKey, Float.valueOf(f));
        }

        public final synchronized Editor mo1272a(PrefKey prefKey, double d) {
            return m8897a(prefKey, Double.valueOf(d));
        }

        public final synchronized Editor mo1271a(PrefKey prefKey) {
            m8898a().add(prefKey);
            this.f4977b.remove(prefKey);
            return this;
        }

        public final synchronized Editor mo1278b(PrefKey prefKey) {
            Collection d = this.f4976a.mo294d(prefKey);
            m8898a().addAll(d);
            m8899a(d);
            return this;
        }

        private synchronized Editor m8900b(PrefKey prefKey, Object obj) {
            if (obj == null) {
                mo1271a(prefKey);
                FbSharedPreferencesImpl.m1830f(this.f4976a, prefKey);
            } else if (obj instanceof String) {
                mo1276a(prefKey, (String) obj);
            } else if (obj instanceof Boolean) {
                putBoolean(prefKey, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                mo1274a(prefKey, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                mo1275a(prefKey, ((Long) obj).longValue());
            } else if (obj instanceof Float) {
                mo1273a(prefKey, ((Float) obj).floatValue());
            } else if (obj instanceof Double) {
                mo1272a(prefKey, ((Double) obj).doubleValue());
            }
            return this;
        }

        public final synchronized Editor mo1277a(Map<PrefKey, Object> map) {
            for (Entry entry : map.entrySet()) {
                m8900b((PrefKey) entry.getKey(), entry.getValue());
            }
            return this;
        }

        public synchronized void commit() {
            Map emptyMap;
            if (this.f4977b == null) {
                emptyMap = Collections.emptyMap();
            } else {
                Object hashMap = new HashMap(this.f4977b);
            }
            FbSharedPreferencesImpl.m1827a(this.f4976a, emptyMap, this.f4978c == null ? Collections.emptySet() : new HashSet(this.f4978c));
        }
    }

    public static com.facebook.prefs.shared.FbSharedPreferencesImpl m1826a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f916l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.prefs.shared.FbSharedPreferencesImpl.class;
        monitor-enter(r1);
        r0 = f916l;	 Catch:{ all -> 0x003a }
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
        r0 = m1828b(r0);	 Catch:{ all -> 0x0035 }
        f916l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f916l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.prefs.shared.FbSharedPreferencesImpl.a(com.facebook.inject.InjectorLike):com.facebook.prefs.shared.FbSharedPreferencesImpl");
    }

    private static FbSharedPreferencesImpl m1828b(InjectorLike injectorLike) {
        return new FbSharedPreferencesImpl((FbSharedPreferencesInitializer) null, C0055x2995691a.m1881a(injectorLike), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 494), FbSharedPreferencesDefaultConfigModule.m1977a(), FbSharedPreferencesCache.m1978a(injectorLike));
    }

    @Inject
    public FbSharedPreferencesImpl(FbSharedPreferencesInitializer fbSharedPreferencesInitializer, ExecutorService executorService, ExecutorService executorService2, Lazy<FbErrorReporter> lazy, Integer num, FbSharedPreferencesCache fbSharedPreferencesCache) {
        this.f919e = executorService2;
        TracerDetour.a("FbSharedPreferences.ctor", 521027968);
        try {
            this.f917c = fbSharedPreferencesInitializer;
            this.f918d = num.intValue();
            this.f920f = executorService;
            this.f921g = lazy;
            this.f922h = new PrefsListeners();
            this.f923i = Queues.m2123b();
            this.f924j = fbSharedPreferencesCache;
        } finally {
            TracerDetour.a(-1191429524);
        }
    }

    public final boolean mo284a() {
        return this.f925k;
    }

    public final synchronized void mo288b() {
        this.f924j.m1990a();
        this.f924j.m1992a(this);
        this.f924j.m1991a((long) this.f918d);
        this.f925k = true;
        m1829e();
        ObjectDetour.c(this, -1353787889);
    }

    private void m1829e() {
        ExecutorDetour.a(this.f920f, new C01741(this), 1225607241);
    }

    public static void m1830f(FbSharedPreferencesImpl fbSharedPreferencesImpl, PrefKey prefKey) {
        ((AbstractFbErrorReporter) fbSharedPreferencesImpl.f921g.get()).m2340a(f915b, "Wrote null pref to " + prefKey);
    }

    public final boolean mo285a(PrefKey prefKey) {
        return this.f924j.m1994a(prefKey);
    }

    public final String mo278a(PrefKey prefKey, @Nullable String str) {
        String str2 = (String) this.f924j.m1995b(prefKey);
        return str2 != null ? str2 : str;
    }

    public final boolean mo286a(PrefKey prefKey, boolean z) {
        Boolean bool = (Boolean) this.f924j.m1995b(prefKey);
        return bool != null ? bool.booleanValue() : z;
    }

    public final TriState mo287b(PrefKey prefKey) {
        Boolean bool = (Boolean) this.f924j.m1995b(prefKey);
        return bool != null ? TriState.valueOf(bool) : TriState.UNSET;
    }

    public final int mo276a(PrefKey prefKey, int i) {
        Integer num = (Integer) this.f924j.m1995b(prefKey);
        return num != null ? num.intValue() : i;
    }

    public final long mo277a(PrefKey prefKey, long j) {
        Long l = (Long) this.f924j.m1995b(prefKey);
        return l != null ? l.longValue() : j;
    }

    public final float mo275a(PrefKey prefKey, float f) {
        Float f2 = (Float) this.f924j.m1995b(prefKey);
        return f2 != null ? f2.floatValue() : f;
    }

    public final double mo274a(PrefKey prefKey, double d) {
        Double d2 = (Double) this.f924j.m1995b(prefKey);
        return d2 != null ? d2.doubleValue() : d;
    }

    public final Object mo291c(PrefKey prefKey) {
        return this.f924j.m1995b(prefKey);
    }

    public final Set<PrefKey> mo294d(PrefKey prefKey) {
        return m1831g(prefKey).keySet();
    }

    public final SortedMap<PrefKey, Object> mo297e(PrefKey prefKey) {
        return m1831g(prefKey);
    }

    private SortedMap<PrefKey, Object> m1831g(PrefKey prefKey) {
        return this.f924j.m1997c(prefKey);
    }

    public Editor edit() {
        return new EditorImpl(this);
    }

    public final void mo283a(Set<PrefKey> set, OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f922h.m2110a((Set) set, onSharedPreferenceChangeListener);
    }

    public final void mo290b(Set<PrefKey> set, OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        PrefsListeners prefsListeners = this.f922h;
        for (PrefKey b : set) {
            prefsListeners.m2111b(b, onSharedPreferenceChangeListener);
        }
    }

    public final void mo279a(PrefKey prefKey, OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f922h.m2109a(prefKey, onSharedPreferenceChangeListener);
    }

    public final void mo289b(PrefKey prefKey, OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f922h.m2111b(prefKey, onSharedPreferenceChangeListener);
    }

    public final void mo281a(String str, OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f922h.f1038a.m2115a(new PrefKey(str), (Object) onSharedPreferenceChangeListener);
    }

    public final void mo293c(PrefKey prefKey, OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f922h.f1039b.m2115a((Object) prefKey, (Object) onSharedPreferenceChangeListener);
    }

    public final void mo296d(PrefKey prefKey, OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f922h.f1039b.m2120b(prefKey, onSharedPreferenceChangeListener);
    }

    public final void mo280a(Runnable runnable) {
        if (mo284a()) {
            ExecutorDetour.a(this.f920f, runnable, -1063282296);
        } else {
            this.f923i.offer(runnable);
        }
    }

    public final synchronized void mo292c() {
        while (!mo284a()) {
            ObjectDetour.a(this, -488086244);
        }
    }

    public static void m1827a(FbSharedPreferencesImpl fbSharedPreferencesImpl, Map map, Set set) {
        fbSharedPreferencesImpl.f924j.m1993a(map, (Collection) set);
    }

    public final void m1840a(Collection<PrefKey> collection) {
        PrefsListeners prefsListeners = this.f922h;
        Executor executor = this.f919e;
        prefsListeners.f1038a.m2118a((Collection) collection, (Object) this, executor);
        prefsListeners.f1039b.m2118a((Collection) collection, (Object) this, executor);
    }

    public final void mo295d() {
        this.f924j.m1998c();
    }

    public final void mo282a(Set<PrefKey> set) {
        Editor edit = edit();
        for (PrefKey b : set) {
            edit.mo1278b(b);
        }
        edit.commit();
    }
}
