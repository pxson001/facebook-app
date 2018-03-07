package com.facebook.abtest.qe.bootstrap.utils;

import com.facebook.abtest.qe.bootstrap.cache.QuickExperimentMemoryCache;
import com.facebook.abtest.qe.bootstrap.data.QuickExperimentInfo;
import com.facebook.abtest.qe.bootstrap.db.DataSource;
import com.facebook.abtest.qe.bootstrap.registry.QuickExperimentRegistry;
import com.facebook.abtest.qe.cache.QuickExperimentMemoryCacheImpl;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryModels.ConfigurationModel;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryModels.ConfigurationParameterSetsConnectionModel.EdgesModel;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.manager.Authority;
import com.facebook.qe.api.manager.QeManager;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: total_quota */
public class QuickExperimentUtil {
    private static volatile QuickExperimentUtil f1716d;
    public final QuickExperimentMemoryCache f1717a;
    private final QuickExperimentRegistry f1718b;
    public final QeManager f1719c;

    public static com.facebook.abtest.qe.bootstrap.utils.QuickExperimentUtil m2363a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1716d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.abtest.qe.bootstrap.utils.QuickExperimentUtil.class;
        monitor-enter(r1);
        r0 = f1716d;	 Catch:{ all -> 0x003a }
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
        r0 = m2364b(r0);	 Catch:{ all -> 0x0035 }
        f1716d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1716d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.abtest.qe.bootstrap.utils.QuickExperimentUtil.a(com.facebook.inject.InjectorLike):com.facebook.abtest.qe.bootstrap.utils.QuickExperimentUtil");
    }

    private static QuickExperimentUtil m2364b(InjectorLike injectorLike) {
        return new QuickExperimentUtil((QuickExperimentMemoryCache) QuickExperimentMemoryCacheImpl.a(injectorLike), QuickExperimentRegistry.a(injectorLike), (QeManager) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public QuickExperimentUtil(QuickExperimentMemoryCache quickExperimentMemoryCache, QuickExperimentRegistry quickExperimentRegistry, QeManager qeManager) {
        this.f1717a = quickExperimentMemoryCache;
        this.f1718b = quickExperimentRegistry;
        this.f1719c = qeManager;
    }

    public final ImmutableList<ExperimentData> m2365a() {
        Builder builder = ImmutableList.builder();
        this.f1717a.c();
        Map d = this.f1717a.d();
        List<String> a = Lists.a(this.f1718b.a());
        a.addAll(this.f1718b.b());
        for (String add : this.f1719c.c()) {
            a.add(add);
        }
        Collections.sort(a);
        for (String add2 : a) {
            ConfigurationModel configurationModel = (ConfigurationModel) d.get(add2);
            if (configurationModel != null) {
                builder.c(m2362a(add2, configurationModel));
            }
        }
        return builder.b();
    }

    private ExperimentData m2362a(String str, ConfigurationModel configurationModel) {
        boolean a;
        int i;
        String b;
        int indexOf;
        boolean b2 = this.f1719c.b(str);
        if (b2) {
            a = this.f1719c.a(Authority.EFFECTIVE, str);
        } else {
            a = this.f1717a.b(str).c;
        }
        Builder builder = ImmutableList.builder();
        ImmutableList a2 = configurationModel.l_().m2425a();
        int size = a2.size();
        for (int i2 = 0; i2 < size; i2++) {
            builder.c(((EdgesModel) a2.get(i2)).m2420a().m2414a());
        }
        ImmutableList b3 = builder.b();
        String str2 = null;
        if (!(configurationModel.m2397a() == null || configurationModel.m2397a().m2425a().isEmpty())) {
            str2 = ((EdgesModel) configurationModel.m2397a().m2425a().get(0)).m2420a().m2414a();
        }
        if (!a || str2 == null || str2.equals("local_default_group")) {
            i = -1;
        } else {
            i = b3.indexOf(str2);
        }
        if (this.f1719c.b(str)) {
            b = this.f1719c.b(Authority.OVERRIDE, str);
        } else {
            QuickExperimentInfo a3 = this.f1717a.a(str, DataSource.FROM_USER);
            b = a3 == null ? null : a3.e;
        }
        str2 = b;
        if (str2 != null) {
            indexOf = b3.indexOf(str2);
        } else {
            indexOf = -1;
        }
        return new ExperimentData(str, a, b3, i, indexOf, b2);
    }
}
