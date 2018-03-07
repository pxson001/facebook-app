package com.facebook.abtest.qe.bootstrap.registry;

import com.facebook.abtest.qe.bootstrap.framework.BaseQuickExperiment;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderLazy;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: last_seen_version */
public class QuickExperimentRegistry {
    private static volatile QuickExperimentRegistry f9547i;
    @GuardedBy("this")
    @Nullable
    private Lazy<Set<QuickExperimentSpecificationHolder>> f9548a;
    private Lazy<Set<SessionlessQuickExperimentSpecificationHolder>> f9549b;
    private FbAppType f9550c;
    private Lazy<FbErrorReporter> f9551d;
    @Nullable
    private ImmutableSet<String> f9552e;
    private ImmutableSet<String> f9553f;
    @Nullable
    private ImmutableMap<Class<? extends BaseQuickExperiment>, String> f9554g;
    private ImmutableMap<Class<? extends BaseQuickExperiment>, String> f9555h;

    public static com.facebook.abtest.qe.bootstrap.registry.QuickExperimentRegistry m9928a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9547i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.abtest.qe.bootstrap.registry.QuickExperimentRegistry.class;
        monitor-enter(r1);
        r0 = f9547i;	 Catch:{ all -> 0x003a }
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
        r0 = m9930b(r0);	 Catch:{ all -> 0x0035 }
        f9547i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9547i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.abtest.qe.bootstrap.registry.QuickExperimentRegistry.a(com.facebook.inject.InjectorLike):com.facebook.abtest.qe.bootstrap.registry.QuickExperimentRegistry");
    }

    private static QuickExperimentRegistry m9930b(InjectorLike injectorLike) {
        return new QuickExperimentRegistry(ProviderLazy.a(new STATICDI_MULTIBIND_PROVIDER$QuickExperimentSpecificationHolder(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()), (FbAppType) injectorLike.getInstance(FbAppType.class), ProviderLazy.a(new C0432xbd949b36(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()), IdBasedSingletonScopeProvider.b(injectorLike, 494));
    }

    @Inject
    public QuickExperimentRegistry(Lazy<Set<QuickExperimentSpecificationHolder>> lazy, FbAppType fbAppType, Lazy<Set<SessionlessQuickExperimentSpecificationHolder>> lazy2, Lazy<FbErrorReporter> lazy3) {
        this.f9548a = lazy;
        this.f9550c = fbAppType;
        this.f9551d = lazy3;
        this.f9549b = lazy2;
    }

    public final ImmutableSet<String> m9933a() {
        m9931c();
        return this.f9552e;
    }

    public final ImmutableSet<String> m9934b() {
        m9932d();
        return this.f9553f;
    }

    private synchronized void m9931c() {
        if (this.f9552e == null) {
            Set<QuickExperimentSpecificationHolder> set = (Set) this.f9548a.get();
            Builder builder = ImmutableSet.builder();
            Map a = Maps.a(set.size() * 2);
            for (QuickExperimentSpecificationHolder a2 : set) {
                m9929a(builder, a, a2.mo765a());
            }
            this.f9552e = builder.b();
            this.f9554g = ImmutableMap.copyOf(a);
            this.f9548a = null;
        }
    }

    private synchronized void m9932d() {
        if (this.f9553f == null) {
            Set<SessionlessQuickExperimentSpecificationHolder> set = (Set) this.f9549b.get();
            Builder builder = ImmutableSet.builder();
            Map a = Maps.a(set.size() * 2);
            for (SessionlessQuickExperimentSpecificationHolder a2 : set) {
                m9929a(builder, a, a2.a());
            }
            this.f9553f = builder.b();
            this.f9555h = ImmutableMap.copyOf(a);
            this.f9549b = null;
        }
    }

    private void m9929a(Builder<String> builder, Map<Class<? extends BaseQuickExperiment>, String> map, ImmutableSet<QuickExperimentSpecification> immutableSet) {
        Iterator it = immutableSet.iterator();
        while (it.hasNext()) {
            QuickExperimentSpecification quickExperimentSpecification = (QuickExperimentSpecification) it.next();
            if (!quickExperimentSpecification.f9569b || this.f9550c.j != Product.MESSENGER) {
                Iterator it2 = quickExperimentSpecification.m9951a().iterator();
                while (it2.hasNext()) {
                    map.put((Class) it2.next(), quickExperimentSpecification.f9568a);
                }
                builder.c(quickExperimentSpecification.f9568a);
            }
        }
    }
}
