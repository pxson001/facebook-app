package com.facebook.interstitial.manager;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.idleexecutor.DefaultProcessIdleExecutor;
import com.facebook.common.idleexecutor.IdleExecutor;
import com.facebook.common.idleexecutor.IdleExecutor_DefaultIdleExecutorMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.debug.log.BLog;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.analytics.InterstitialAnalyticsLogger;
import com.facebook.interstitial.api.FetchInterstitialResult;
import com.facebook.interstitial.logging.LogInterstitialMethod;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.prefs.InterstitialPrefKeys;
import com.facebook.loom.logger.api.LoomLogger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.tools.dextr.runtime.detour.LoomLoggerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: social_context_middle_ellipsizing */
public class InterstitialManager implements IHaveUserData {
    private static final Class<?> f4390a = InterstitialManager.class;
    private static volatile InterstitialManager f4391s;
    private final InterstitialControllersHolder f4392b;
    private final InterstitialRepository f4393c;
    private final FbSharedPreferences f4394d;
    private final AbstractFbErrorReporter f4395e;
    private final Clock f4396f;
    private final Lazy<AppVersionInfo> f4397g;
    private final InterstitialAnalyticsLogger f4398h;
    private final DefaultProcessIdleExecutor f4399i;
    private final Lazy<SingleMethodRunner> f4400j;
    private final Lazy<LogInterstitialMethod> f4401k;
    private final Lazy<QuickPerformanceLogger> f4402l;
    @GuardedBy("this")
    private final Map<InterstitialTrigger, TriggerLazyInterstitialControllerHolders> f4403m;
    @GuardedBy("this")
    private final Map<String, LazyInterstitialControllerHolder> f4404n;
    private InterstitialLogger f4405o;
    @GuardedBy("this")
    private int f4406p = Integer.MIN_VALUE;
    @GuardedBy("this")
    private int f4407q = Integer.MIN_VALUE;
    @GuardedBy("this")
    private boolean f4408r;

    /* compiled from: social_context_middle_ellipsizing */
    public enum DataSource {
        CACHE,
        SERVER
    }

    public static com.facebook.interstitial.manager.InterstitialManager m8082a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4391s;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.interstitial.manager.InterstitialManager.class;
        monitor-enter(r1);
        r0 = f4391s;	 Catch:{ all -> 0x003a }
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
        r0 = m8094b(r0);	 Catch:{ all -> 0x0035 }
        f4391s = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4391s;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.interstitial.manager.InterstitialManager.a(com.facebook.inject.InjectorLike):com.facebook.interstitial.manager.InterstitialManager");
    }

    private static InterstitialManager m8094b(InjectorLike injectorLike) {
        return new InterstitialManager(InterstitialControllersHolderImpl.m8129b(injectorLike), InterstitialRepository.m8140a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), IdleExecutor_DefaultIdleExecutorMethodAutoProvider.m2724a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2289), IdBasedSingletonScopeProvider.m1810b(injectorLike, 7268), SystemClockMethodAutoProvider.m1498a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 879), InterstitialAnalyticsLogger.m8167a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3229));
    }

    @Inject
    public InterstitialManager(InterstitialControllersHolder interstitialControllersHolder, InterstitialRepository interstitialRepository, FbSharedPreferences fbSharedPreferences, FbErrorReporter fbErrorReporter, IdleExecutor idleExecutor, Lazy<SingleMethodRunner> lazy, Lazy<LogInterstitialMethod> lazy2, Clock clock, Lazy<AppVersionInfo> lazy3, InterstitialAnalyticsLogger interstitialAnalyticsLogger, Lazy<QuickPerformanceLogger> lazy4) {
        this.f4392b = interstitialControllersHolder;
        this.f4393c = interstitialRepository;
        this.f4394d = fbSharedPreferences;
        this.f4395e = fbErrorReporter;
        this.f4399i = idleExecutor;
        this.f4400j = lazy;
        this.f4401k = lazy2;
        this.f4397g = lazy3;
        this.f4398h = interstitialAnalyticsLogger;
        this.f4402l = lazy4;
        this.f4403m = Maps.m838c();
        this.f4404n = Maps.m838c();
        this.f4396f = clock;
    }

    public final synchronized InterstitialController m8119a(String str) {
        return m8120a(str, InterstitialController.class);
    }

    public final synchronized <T extends InterstitialController> T m8120a(String str, Class<T> cls) {
        InterstitialController a;
        int i = 2057741871;
        TracerDetour.a("InterstitialManager#getInterstitialControllerForId", 2057741871);
        try {
            a = this.f4392b.m8135a(str, cls);
            m8097b(a);
            TracerDetour.a(i);
        } finally {
            i = -965557473;
            TracerDetour.a(-965557473);
        }
        return a;
    }

    public final synchronized InterstitialLogger m8121a() {
        if (this.f4405o == null) {
            this.f4405o = new InterstitialLogger(this, this.f4399i, this.f4400j, this.f4401k);
        }
        return this.f4405o;
    }

    public final synchronized void m8123a(List<FetchInterstitialResult> list) {
        if (list != null) {
            TracerDetour.a("InterstitialManager#resetEligibleInterstitialsWithFetchResults", 275771896);
            try {
                Editor edit = this.f4394d.edit();
                m8105c(edit);
                this.f4403m.clear();
                m8109d(m8096b((List) list));
                m8089a(edit, (List) list, this.f4403m);
                edit.commit();
                int i = this.f4398h;
                i.m8171a((List) list);
                TracerDetour.a(i);
            } finally {
                TracerDetour.a(1842593948);
            }
        }
    }

    public final synchronized void m8124a(List<String> list, List<FetchInterstitialResult> list2) {
        if (list2 != null) {
            TracerDetour.a("InterstitialManager#updateEligibleInterstitialsWithFetchResults", 1423619854);
            try {
                m8115j();
                Editor edit = this.f4394d.edit();
                Set<String> b = Sets.m1324b(list);
                for (FetchInterstitialResult fetchInterstitialResult : list2) {
                    String str = fetchInterstitialResult.interstitialId;
                    if (this.f4392b.mo1202a(str) != null) {
                        LazyInterstitialControllerHolder lazyInterstitialControllerHolder = (LazyInterstitialControllerHolder) this.f4404n.get(str);
                        if (lazyInterstitialControllerHolder == null || !lazyInterstitialControllerHolder.m13464a()) {
                            if (m8091a(fetchInterstitialResult)) {
                                b.remove(fetchInterstitialResult.interstitialId);
                            }
                        } else if (m8092a(fetchInterstitialResult, lazyInterstitialControllerHolder)) {
                            b.remove(fetchInterstitialResult.interstitialId);
                        }
                    }
                }
                if (!b.isEmpty()) {
                    Collection a = Sets.m1313a();
                    for (String str2 : b) {
                        edit.mo1271a(InterstitialPrefKeys.m12488a(str2));
                        LazyInterstitialControllerHolder lazyInterstitialControllerHolder2 = (LazyInterstitialControllerHolder) this.f4404n.remove(str2);
                        if (lazyInterstitialControllerHolder2 != null) {
                            a.add(lazyInterstitialControllerHolder2);
                        }
                    }
                    for (TriggerLazyInterstitialControllerHolders a2 : this.f4403m.values()) {
                        a2.m13476a(a);
                    }
                }
                m8089a(edit, (List) list2, this.f4403m);
                edit.commit();
                int i = this.f4398h;
                i.m8173b((List) list2);
                TracerDetour.a(i);
            } finally {
                TracerDetour.a(1154449940);
            }
        }
    }

    private synchronized boolean m8091a(FetchInterstitialResult fetchInterstitialResult) {
        boolean z = true;
        synchronized (this) {
            Collection b = m8096b(Arrays.asList(new FetchInterstitialResult[]{fetchInterstitialResult}));
            if (b == null || b.isEmpty()) {
                z = false;
            }
            m8109d(b);
        }
        return z;
    }

    private synchronized boolean m8092a(FetchInterstitialResult fetchInterstitialResult, LazyInterstitialControllerHolder lazyInterstitialControllerHolder) {
        boolean z;
        ImmutableList d = lazyInterstitialControllerHolder.m13468d();
        if (lazyInterstitialControllerHolder.m13465a(fetchInterstitialResult, this.f4395e)) {
            m8086a(fetchInterstitialResult, lazyInterstitialControllerHolder, d);
            z = true;
        } else {
            String str = fetchInterstitialResult.interstitialId;
            z = false;
        }
        return z;
    }

    private void m8086a(FetchInterstitialResult fetchInterstitialResult, LazyInterstitialControllerHolder lazyInterstitialControllerHolder, ImmutableList<InterstitialTrigger> immutableList) {
        Preconditions.checkArgument(lazyInterstitialControllerHolder.m13464a());
        Set copyOf = ImmutableSet.copyOf((Collection) immutableList);
        Set copyOf2 = ImmutableSet.copyOf(lazyInterstitialControllerHolder.m13469e());
        for (InterstitialTrigger interstitialTrigger : Sets.m1326c(copyOf, copyOf2)) {
            TriggerLazyInterstitialControllerHolders triggerLazyInterstitialControllerHolders = (TriggerLazyInterstitialControllerHolders) this.f4403m.get(interstitialTrigger);
            if (triggerLazyInterstitialControllerHolders != null) {
                triggerLazyInterstitialControllerHolders.m13479b(lazyInterstitialControllerHolder.f8657a);
            }
        }
        for (InterstitialTrigger interstitialTrigger2 : Sets.m1326c(copyOf2, copyOf)) {
            triggerLazyInterstitialControllerHolders = m8083a(interstitialTrigger2, fetchInterstitialResult.interstitialId);
            triggerLazyInterstitialControllerHolders.m13474a(lazyInterstitialControllerHolder, fetchInterstitialResult.rank);
            triggerLazyInterstitialControllerHolders.m13480c();
        }
        for (InterstitialTrigger interstitialTrigger22 : Sets.m1323b(copyOf, copyOf2)) {
            m8083a(interstitialTrigger22, fetchInterstitialResult.interstitialId).m13478b(lazyInterstitialControllerHolder, fetchInterstitialResult.rank);
        }
    }

    public final synchronized <T extends InterstitialController> T m8118a(InterstitialTrigger interstitialTrigger, Class<T> cls) {
        InterstitialController c;
        c = m8100c(interstitialTrigger, cls);
        if (c != null) {
            ((QuickPerformanceLogger) this.f4402l.get()).mo448a(2293779, "interstitial=" + c.mo1173b());
            m8122a(c);
        }
        return c;
    }

    public final synchronized InterstitialController m8117a(InterstitialTrigger interstitialTrigger) {
        return m8118a(interstitialTrigger, InterstitialController.class);
    }

    public final synchronized <T extends InterstitialController> boolean m8128b(InterstitialTrigger interstitialTrigger, Class<T> cls) {
        boolean c;
        TracerDetour.a("InterstitialManager#hasInterstitialForTrigger " + interstitialTrigger.toString(), -32342887);
        LoomLogger.a(LoomLoggerDetour.a(-558505983), "InterstitialManager#hasInterstitialForTrigger", interstitialTrigger.toString());
        try {
            c = m8100c(interstitialTrigger, cls);
            if (!c) {
                c = false;
            }
            TracerDetour.a(-710501245);
        } finally {
            TracerDetour.a(595809512);
        }
        return c;
    }

    public final synchronized boolean m8127b(InterstitialTrigger interstitialTrigger) {
        return m8128b(interstitialTrigger, InterstitialController.class);
    }

    private <T extends InterstitialController> T m8100c(InterstitialTrigger interstitialTrigger, Class<T> cls) {
        TracerDetour.a("InterstitialManager#getBestInterstitialForTrigger(%s)", interstitialTrigger, 283968547);
        LoomLogger.a(LoomLoggerDetour.a(585217461), "InterstitialManager#getBestInterstitialForTrigger", interstitialTrigger.toString());
        try {
            m8104c(interstitialTrigger);
            m8108d(interstitialTrigger, cls);
            TriggerLazyInterstitialControllerHolders triggerLazyInterstitialControllerHolders = (TriggerLazyInterstitialControllerHolders) this.f4403m.get(interstitialTrigger);
            if (triggerLazyInterstitialControllerHolders == null) {
                return null;
            }
            triggerLazyInterstitialControllerHolders.m13473a();
            for (LazyInterstitialControllerHolder lazyInterstitialControllerHolder : triggerLazyInterstitialControllerHolders.m13482e()) {
                T b = lazyInterstitialControllerHolder.m13466b();
                if (b == null) {
                    BLog.b(f4390a, "Interstitial with id %s is not initialized!", new Object[]{lazyInterstitialControllerHolder.f8657a});
                } else {
                    QuickPerformanceLogger quickPerformanceLogger = (QuickPerformanceLogger) this.f4402l.get();
                    quickPerformanceLogger.mo462b(196627);
                    quickPerformanceLogger.mo448a(196627, interstitialTrigger.toString());
                    quickPerformanceLogger.mo448a(196627, lazyInterstitialControllerHolder.f8657a);
                    boolean b2 = m8099b((InterstitialController) b, interstitialTrigger);
                    quickPerformanceLogger.mo468b(196627, (short) 2);
                    if (b2) {
                        T t = cls.isInstance(b) ? b : null;
                        TracerDetour.a(-757022247);
                        return t;
                    }
                }
            }
            TracerDetour.a(-352871777);
            return null;
        } finally {
            TracerDetour.a(1931156057);
        }
    }

    public final synchronized boolean m8125a(InterstitialController interstitialController, InterstitialTrigger interstitialTrigger) {
        boolean z = false;
        synchronized (this) {
            TracerDetour.a("InterstitialManager#canShowInterstitialForTrigger", -1046767498);
            try {
                m8104c(interstitialTrigger);
                TriggerLazyInterstitialControllerHolders triggerLazyInterstitialControllerHolders = (TriggerLazyInterstitialControllerHolders) this.f4403m.get(interstitialTrigger);
                if (triggerLazyInterstitialControllerHolders == null) {
                    TracerDetour.a(-1772900242);
                } else {
                    boolean z2;
                    triggerLazyInterstitialControllerHolders.m13473a();
                    if (triggerLazyInterstitialControllerHolders.m13475a(interstitialController.mo1173b()) && m8099b(interstitialController, interstitialTrigger)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    TracerDetour.a(-1743867055);
                    z = z2;
                }
            } catch (Throwable th) {
                TracerDetour.a(796498928);
            }
        }
        return z;
    }

    public final void m8122a(InterstitialController interstitialController) {
        m8087a(this, interstitialController.mo1173b(), this.f4396f.mo211a());
    }

    public static synchronized void m8087a(InterstitialManager interstitialManager, String str, long j) {
        synchronized (interstitialManager) {
            interstitialManager.f4394d.edit().mo1275a(InterstitialPrefKeys.m12489b(str), j).commit();
        }
    }

    private boolean m8099b(InterstitialController interstitialController, InterstitialTrigger interstitialTrigger) {
        boolean z = true;
        if (interstitialController.mo1170a(interstitialTrigger) != InterstitialControllerState.ELIGIBLE) {
            return false;
        }
        long a = this.f4396f.mo211a();
        PrefKey b = InterstitialPrefKeys.m12489b(interstitialController.mo1173b());
        long hI_ = interstitialController.hI_();
        if (hI_ <= 0) {
            return true;
        }
        long a2 = this.f4394d.mo277a(b, 0);
        if (a < a2 + hI_) {
            z = false;
        }
        if (z) {
            return z;
        }
        this.f4398h.m8170a(interstitialController.mo1173b(), interstitialTrigger, a, a2, hI_);
        return z;
    }

    private Set<TriggerLazyInterstitialControllerHolders> m8096b(List<FetchInterstitialResult> list) {
        if (list == null || list.isEmpty()) {
            return Collections.EMPTY_SET;
        }
        Set<TriggerLazyInterstitialControllerHolders> a = Sets.m1313a();
        TracerDetour.a("InterstitialManager#forceRestoreTriggerStateFromInsterstitialResult", -30583007);
        QuickPerformanceLogger quickPerformanceLogger = (QuickPerformanceLogger) this.f4402l.get();
        try {
            for (FetchInterstitialResult fetchInterstitialResult : list) {
                String str = fetchInterstitialResult.interstitialId;
                quickPerformanceLogger.mo462b(196628);
                if (str != null) {
                    try {
                        quickPerformanceLogger.mo448a(196628, str);
                    } catch (Throwable th) {
                        quickPerformanceLogger.mo468b(196628, (short) 2);
                    }
                }
                InterstitialController a2 = this.f4392b.mo1202a(str);
                if (a2 == null) {
                    quickPerformanceLogger.mo468b(196628, (short) 2);
                } else {
                    LazyInterstitialControllerHolder c = m8101c(a2);
                    if (c.m13465a(fetchInterstitialResult, this.f4395e)) {
                        ImmutableList c2 = a2.mo1174c();
                        int size = c2.size();
                        for (int i = 0; i < size; i++) {
                            TriggerLazyInterstitialControllerHolders a3 = m8083a((InterstitialTrigger) c2.get(i), str);
                            a3.m13474a(c, fetchInterstitialResult.rank);
                            a.add(a3);
                        }
                        quickPerformanceLogger.mo468b(196628, (short) 2);
                    } else {
                        quickPerformanceLogger.mo468b(196628, (short) 2);
                    }
                }
            }
            return a;
        } finally {
            TracerDetour.a(933062451);
        }
    }

    private <T extends InterstitialController> void m8108d(InterstitialTrigger interstitialTrigger, Class<T> cls) {
        for (String a : this.f4392b.mo1204a(interstitialTrigger.action)) {
            InterstitialControllerNeedsCouldShowLogging interstitialControllerNeedsCouldShowLogging = (InterstitialControllerNeedsCouldShowLogging) this.f4392b.m8135a(a, InterstitialControllerNeedsCouldShowLogging.class);
            if (interstitialControllerNeedsCouldShowLogging != null && cls.isInstance(interstitialControllerNeedsCouldShowLogging)) {
                interstitialControllerNeedsCouldShowLogging.mo1690b(interstitialTrigger);
            }
        }
    }

    private TriggerLazyInterstitialControllerHolders m8084a(InterstitialTrigger interstitialTrigger, List<String> list) {
        TriggerLazyInterstitialControllerHolders a = m8083a(interstitialTrigger, "FromTriggerIds");
        m8085a((Collection) list);
        a.m13480c();
        return a;
    }

    private synchronized void m8104c(InterstitialTrigger interstitialTrigger) {
        TracerDetour.a("InterstitialManager#restoreLazyTriggerIds", -811844073);
        try {
            if (m8093a((TriggerLazyInterstitialControllerHolders) this.f4403m.get(interstitialTrigger))) {
                TracerDetour.a(1428490328);
            } else {
                m8103c();
                QuickPerformanceLogger quickPerformanceLogger = (QuickPerformanceLogger) this.f4402l.get();
                quickPerformanceLogger.mo462b(196630);
                List a = this.f4393c.m8162a(interstitialTrigger);
                quickPerformanceLogger.mo448a(196630, interstitialTrigger.toString());
                quickPerformanceLogger.mo448a(196630, InterstitialRepository.m8143a(a));
                if (a == null) {
                    TriggerLazyInterstitialControllerHolders triggerLazyInterstitialControllerHolders = (TriggerLazyInterstitialControllerHolders) this.f4403m.get(interstitialTrigger);
                    if (triggerLazyInterstitialControllerHolders == null || triggerLazyInterstitialControllerHolders.m13477b()) {
                        quickPerformanceLogger.mo468b(196630, (short) 4);
                        TracerDetour.a(1082769599);
                    } else {
                        this.f4395e.m2351b("InterstitialManagerBadTriggerMapping", StringFormatUtil.formatStrLocaleSafe("Inconsistent Interstitial Trigger %s state on disk. Debug Info: %s", interstitialTrigger, triggerLazyInterstitialControllerHolders.m13483f()), new Throwable("Could not restore trigger " + interstitialTrigger, triggerLazyInterstitialControllerHolders.m13484g()));
                        m8115j();
                        quickPerformanceLogger.mo468b(196630, (short) 3);
                        TracerDetour.a(-1768542674);
                    }
                } else {
                    m8084a(interstitialTrigger, a);
                    quickPerformanceLogger.mo468b(196630, (short) 2);
                    TracerDetour.a(1468554335);
                }
            }
        } catch (Throwable th) {
            TracerDetour.a(-2008523939);
        }
    }

    private synchronized void m8103c() {
        m8110e();
        m8107d();
    }

    private synchronized void m8107d() {
        if (!this.f4408r) {
            int g = m8112g();
            int h = m8113h();
            if (g != h) {
                Integer.valueOf(g);
                Integer.valueOf(h);
                m8126b();
            }
        }
    }

    final synchronized void m8126b() {
        if (!this.f4408r) {
            TracerDetour.a("InterstitialManager#forceOnAppUpgrade", -1088354371);
            try {
                Editor edit = this.f4394d.edit();
                m8115j();
                m8090a(edit, this.f4403m);
                m8088a(edit);
                edit.commit();
                this.f4408r = true;
                TracerDetour.a(1);
            } finally {
                TracerDetour.a(2112933532);
            }
        }
    }

    private synchronized void m8110e() {
        boolean z = true;
        synchronized (this) {
            int i = m8114i();
            if (i != 1) {
                TracerDetour.a("InterstitialManager#maybeUpgradePreviousStore", -1407351403);
                if (i > 0) {
                    z = false;
                }
                try {
                    Preconditions.checkArgument(z, "We have no upgrade logic for version " + i);
                    Editor edit = this.f4394d.edit();
                    if (i >= 0 && i <= 0) {
                        m8115j();
                        m8089a(edit, m8111f(), this.f4403m);
                    }
                    edit.commit();
                    TracerDetour.a(edit);
                } finally {
                    TracerDetour.a(1933487547);
                }
            }
        }
    }

    private synchronized List<FetchInterstitialResult> m8111f() {
        List<FetchInterstitialResult> a;
        a = Lists.m1296a();
        for (LazyInterstitialControllerHolder c : this.f4404n.values()) {
            FetchInterstitialResult c2 = c.m13467c();
            if (c2 != null) {
                a.add(c2);
            }
        }
        return a;
    }

    private synchronized int m8112g() {
        if (this.f4406p == Integer.MIN_VALUE) {
            this.f4406p = this.f4394d.mo276a(InterstitialPrefKeys.f7899h, Integer.MIN_VALUE);
        }
        return this.f4406p;
    }

    private synchronized void m8088a(Editor editor) {
        editor.mo1274a(InterstitialPrefKeys.f7899h, m8113h());
        this.f4406p = Integer.MIN_VALUE;
    }

    private int m8113h() {
        return ((AppVersionInfo) this.f4397g.get()).mo368b();
    }

    private synchronized int m8114i() {
        if (this.f4407q == Integer.MIN_VALUE) {
            this.f4407q = this.f4394d.mo276a(InterstitialPrefKeys.f7898g, 0);
        }
        return this.f4407q;
    }

    private synchronized void m8098b(Editor editor) {
        editor.mo1274a(InterstitialPrefKeys.f7898g, 1);
        this.f4407q = Integer.MIN_VALUE;
    }

    private synchronized void m8115j() {
        TracerDetour.a("InterstitialManager#RestoreInterstitialDataFromPreferences", 2032718624);
        try {
            Collection a = this.f4392b.mo1203a();
            m8085a(a);
            m8116k();
            TracerDetour.a(a);
        } finally {
            TracerDetour.a(964253413);
        }
    }

    private synchronized Set<TriggerLazyInterstitialControllerHolders> m8085a(Collection<String> collection) {
        Set<TriggerLazyInterstitialControllerHolders> b;
        if (collection != null) {
            if (!collection.isEmpty()) {
                TracerDetour.a("InterstitialManager#restoreControllerIdsIfNeeded", 1617497135);
                int a;
                try {
                    a = Lists.m1296a();
                    for (String str : collection) {
                        if (!m8106c(str)) {
                            a.add(str);
                        }
                    }
                    b = m8095b((Collection) a);
                    TracerDetour.a(a);
                } finally {
                    a = -1063466436;
                    TracerDetour.a(-1063466436);
                }
            }
        }
        b = Collections.EMPTY_SET;
        return b;
    }

    private synchronized void m8097b(InterstitialController interstitialController) {
        Preconditions.checkNotNull(interstitialController);
        TracerDetour.a("InterstitialManager#restoreControllersIfNeeded", 1131016405);
        try {
            String b = interstitialController.mo1173b();
            if (!m8106c(b)) {
                m8095b(Collections.singletonList(b));
            }
            TracerDetour.a(-88213470);
        } catch (Throwable th) {
            TracerDetour.a(-485201310);
        }
    }

    private synchronized boolean m8106c(String str) {
        boolean z;
        LazyInterstitialControllerHolder lazyInterstitialControllerHolder = (LazyInterstitialControllerHolder) this.f4404n.get(str);
        z = lazyInterstitialControllerHolder != null && lazyInterstitialControllerHolder.m13464a();
        return z;
    }

    private synchronized Set<TriggerLazyInterstitialControllerHolders> m8095b(Collection<String> collection) {
        Set<TriggerLazyInterstitialControllerHolders> b;
        if (collection != null) {
            if (!collection.isEmpty()) {
                b = m8096b(m8102c((Collection) collection));
            }
        }
        b = Collections.EMPTY_SET;
        return b;
    }

    private List<FetchInterstitialResult> m8102c(Collection<String> collection) {
        Preconditions.checkNotNull(collection);
        List<FetchInterstitialResult> a = Lists.m1296a();
        List list = null;
        QuickPerformanceLogger quickPerformanceLogger = (QuickPerformanceLogger) this.f4402l.get();
        quickPerformanceLogger.mo462b(196632);
        for (String str : collection) {
            FetchInterstitialResult a2 = this.f4393c.m8159a(str);
            if (a2 != null) {
                a.add(a2);
            } else {
                if (list == null) {
                    list = Lists.m1296a();
                }
                list.add(str);
            }
        }
        quickPerformanceLogger.mo468b(196632, (short) 2);
        return a;
    }

    private synchronized void m8105c(Editor editor) {
        InterstitialRepository.m8147a(editor, this.f4392b.mo1203a());
        Collection b = this.f4393c.m8164b();
        InterstitialRepository.m8144a(editor);
        if (b != null) {
            InterstitialRepository.m8153b(editor, b);
        }
    }

    private void m8089a(Editor editor, List<FetchInterstitialResult> list, Map<InterstitialTrigger, TriggerLazyInterstitialControllerHolders> map) {
        TracerDetour.a("InterstitialManager#cacheInterstitialData", 1747042734);
        try {
            this.f4393c.m8163a(editor, (List) list);
            m8090a(editor, (Map) map);
            m8098b(editor);
            m8088a(editor);
        } finally {
            TracerDetour.a(-1206392805);
        }
    }

    private void m8090a(Editor editor, Map<InterstitialTrigger, TriggerLazyInterstitialControllerHolders> map) {
        InterstitialRepository.m8156c(editor, this.f4393c.m8165d(editor, map.keySet()));
        InterstitialRepository.m8148a(editor, (Map) map);
    }

    private static boolean m8093a(TriggerLazyInterstitialControllerHolders triggerLazyInterstitialControllerHolders) {
        return triggerLazyInterstitialControllerHolders != null && triggerLazyInterstitialControllerHolders.f8662b;
    }

    private TriggerLazyInterstitialControllerHolders m8083a(InterstitialTrigger interstitialTrigger, String str) {
        TriggerLazyInterstitialControllerHolders triggerLazyInterstitialControllerHolders = (TriggerLazyInterstitialControllerHolders) this.f4403m.get(interstitialTrigger);
        if (triggerLazyInterstitialControllerHolders != null) {
            return triggerLazyInterstitialControllerHolders;
        }
        triggerLazyInterstitialControllerHolders = new TriggerLazyInterstitialControllerHolders(interstitialTrigger, str);
        this.f4403m.put(interstitialTrigger, triggerLazyInterstitialControllerHolders);
        return triggerLazyInterstitialControllerHolders;
    }

    private synchronized LazyInterstitialControllerHolder m8101c(InterstitialController interstitialController) {
        LazyInterstitialControllerHolder lazyInterstitialControllerHolder;
        String b = interstitialController.mo1173b();
        lazyInterstitialControllerHolder = (LazyInterstitialControllerHolder) this.f4404n.get(b);
        if (lazyInterstitialControllerHolder == null) {
            lazyInterstitialControllerHolder = new LazyInterstitialControllerHolder(interstitialController);
            this.f4404n.put(b, lazyInterstitialControllerHolder);
        }
        return lazyInterstitialControllerHolder;
    }

    private synchronized void m8116k() {
        for (TriggerLazyInterstitialControllerHolders c : this.f4403m.values()) {
            c.m13480c();
        }
    }

    private synchronized void m8109d(Collection<TriggerLazyInterstitialControllerHolders> collection) {
        if (collection != null) {
            for (TriggerLazyInterstitialControllerHolders c : collection) {
                c.m13480c();
            }
        }
    }

    public synchronized void clearUserData() {
        this.f4403m.clear();
        this.f4404n.clear();
    }
}
