package com.facebook.abtest.qe.framework;

import com.facebook.abtest.qe.bootstrap.cache.QuickExperimentMemoryCache;
import com.facebook.abtest.qe.bootstrap.data.QuickExperimentInfo;
import com.facebook.abtest.qe.bootstrap.data.QuickExperimentInfo.Builder;
import com.facebook.abtest.qe.bootstrap.framework.BaseQuickExperiment;
import com.facebook.abtest.qe.bootstrap.framework.DeprecatedQuickExperiment;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperiment;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperimentConfigRequestObserver;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperimentController;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperimentMetadata;
import com.facebook.abtest.qe.cache.QuickExperimentMemoryCacheImpl;
import com.facebook.abtest.qe.log.QuickExperimentLogger;
import com.facebook.abtest.qe.utils.LocaleUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.collect.RegularImmutableBiMap;
import java.util.Arrays;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: scheduling */
public class QuickExperimentControllerImpl implements QuickExperimentController {
    private static volatile QuickExperimentControllerImpl f6021f;
    private final QuickExperimentMemoryCache f6022a;
    private final QuickExperimentLogger f6023b;
    private final EmptyQuickExperimentConfigRequestObserver f6024c;
    private final Provider<String> f6025d;
    private final LocaleUtil f6026e;

    public static com.facebook.abtest.qe.framework.QuickExperimentControllerImpl m10166a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6021f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.abtest.qe.framework.QuickExperimentControllerImpl.class;
        monitor-enter(r1);
        r0 = f6021f;	 Catch:{ all -> 0x003a }
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
        r0 = m10168b(r0);	 Catch:{ all -> 0x0035 }
        f6021f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6021f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.abtest.qe.framework.QuickExperimentControllerImpl.a(com.facebook.inject.InjectorLike):com.facebook.abtest.qe.framework.QuickExperimentControllerImpl");
    }

    private static QuickExperimentControllerImpl m10168b(InjectorLike injectorLike) {
        return new QuickExperimentControllerImpl(QuickExperimentMemoryCacheImpl.m3605a(injectorLike), QuickExperimentLogger.m3771a(injectorLike), EmptyQuickExperimentConfigRequestObserver.m10177a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4442), LocaleUtil.m10178a(injectorLike));
    }

    @Inject
    public QuickExperimentControllerImpl(QuickExperimentMemoryCache quickExperimentMemoryCache, QuickExperimentLogger quickExperimentLogger, QuickExperimentConfigRequestObserver quickExperimentConfigRequestObserver, Provider<String> provider, LocaleUtil localeUtil) {
        this.f6022a = quickExperimentMemoryCache;
        this.f6023b = quickExperimentLogger;
        this.f6024c = quickExperimentConfigRequestObserver;
        this.f6025d = provider;
        this.f6026e = localeUtil;
    }

    public final <CONFIG> CONFIG mo1436a(BaseQuickExperiment<CONFIG> baseQuickExperiment) {
        Preconditions.checkNotNull(baseQuickExperiment);
        return m10167a(baseQuickExperiment, m10169d(baseQuickExperiment));
    }

    public final <CONFIG> void mo1437b(BaseQuickExperiment<CONFIG> baseQuickExperiment) {
        Preconditions.checkNotNull(baseQuickExperiment);
        if (this.f6025d.get() != null || baseQuickExperiment.mo1959a().startsWith("sessionless__")) {
            this.f6023b.m3778a(m10169d(baseQuickExperiment), "QuickExperimentControllerImplLoggingContext", null);
            return;
        }
        BLog.a("QuickExperimentControllerImpl", "Exposure of experiment %s occurred when no user was logged in", new Object[]{baseQuickExperiment});
    }

    private static <CONFIG> CONFIG m10167a(BaseQuickExperiment<CONFIG> baseQuickExperiment, QuickExperimentInfo quickExperimentInfo) {
        if (baseQuickExperiment instanceof QuickExperiment) {
            return ((QuickExperiment) baseQuickExperiment).mo1958a(quickExperimentInfo.f10003h);
        }
        if (baseQuickExperiment instanceof DeprecatedQuickExperiment) {
            return ((DeprecatedQuickExperiment) baseQuickExperiment).b();
        }
        throw new IllegalArgumentException(baseQuickExperiment.getClass() + " must be an instance of either DeprecatedQuickExperiment or NewQuickExperiment, but had signature: " + Arrays.toString(baseQuickExperiment.getClass().getClasses()));
    }

    private <CONFIG> QuickExperimentInfo m10169d(BaseQuickExperiment<CONFIG> baseQuickExperiment) {
        String a = baseQuickExperiment.mo1959a();
        if (a != null) {
            return this.f6022a.mo540b(a);
        }
        Builder h = new Builder().m15040e("").m15042g("").m15041f("local_default_group").m15037c(false).m15039d(false).m15043h(LocaleUtil.m10179a());
        h.f9995g = RegularImmutableBiMap.f695a;
        return h.m15033a();
    }

    public final <CONFIG> QuickExperimentMetadata mo1438c(BaseQuickExperiment<CONFIG> baseQuickExperiment) {
        Preconditions.checkNotNull(baseQuickExperiment);
        return new QuickExperimentMetadata(m10169d(baseQuickExperiment).f10008e);
    }
}
