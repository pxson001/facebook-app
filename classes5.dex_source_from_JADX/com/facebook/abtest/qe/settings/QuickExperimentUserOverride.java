package com.facebook.abtest.qe.settings;

import com.facebook.abtest.qe.bootstrap.cache.QuickExperimentMemoryCache;
import com.facebook.abtest.qe.bootstrap.data.QuickExperimentInfo;
import com.facebook.abtest.qe.bootstrap.data.QuickExperimentInfo.Builder;
import com.facebook.abtest.qe.bootstrap.db.DataSource;
import com.facebook.abtest.qe.cache.QuickExperimentMemoryCacheImpl;
import com.facebook.abtest.qe.db.WriteExperimentsHandler;
import com.facebook.abtest.qe.multiprocess.QuickExperimentBroadcastManager;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationModelUtils;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryModels.ConfigurationModel;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryModels.ConfigurationParameterSetModel;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryModels.ConfigurationParameterSetsConnectionModel;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryModels.QueryStringConfigurationParameterModel;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.manager.QeManager;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: top_category_name */
public final class QuickExperimentUserOverride {
    private static volatile QuickExperimentUserOverride f1813f;
    public final QuickExperimentMemoryCache f1814a;
    public final WriteExperimentsHandler f1815b;
    public final QuickExperimentBroadcastManager f1816c;
    private final ListeningExecutorService f1817d;
    public final QeManager f1818e;

    public static com.facebook.abtest.qe.settings.QuickExperimentUserOverride m2501a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1813f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.abtest.qe.settings.QuickExperimentUserOverride.class;
        monitor-enter(r1);
        r0 = f1813f;	 Catch:{ all -> 0x003a }
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
        r0 = m2503b(r0);	 Catch:{ all -> 0x0035 }
        f1813f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1813f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.abtest.qe.settings.QuickExperimentUserOverride.a(com.facebook.inject.InjectorLike):com.facebook.abtest.qe.settings.QuickExperimentUserOverride");
    }

    private static QuickExperimentUserOverride m2503b(InjectorLike injectorLike) {
        return new QuickExperimentUserOverride((QuickExperimentMemoryCache) QuickExperimentMemoryCacheImpl.a(injectorLike), WriteExperimentsHandler.b(injectorLike), QuickExperimentBroadcastManager.b(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (QeManager) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public QuickExperimentUserOverride(QuickExperimentMemoryCache quickExperimentMemoryCache, WriteExperimentsHandler writeExperimentsHandler, QuickExperimentBroadcastManager quickExperimentBroadcastManager, ListeningExecutorService listeningExecutorService, QeManager qeManager) {
        this.f1814a = quickExperimentMemoryCache;
        this.f1815b = writeExperimentsHandler;
        this.f1816c = quickExperimentBroadcastManager;
        this.f1817d = listeningExecutorService;
        this.f1818e = qeManager;
    }

    public final void m2505a(String str, String str2) {
        m2504c(str, str2);
    }

    private QuickExperimentInfo m2502b(String str, String str2) {
        QuickExperimentInfo b = this.f1814a.b(str);
        ConfigurationModel a = this.f1814a.a(str);
        if (a == null) {
            throw new IllegalStateException("The meta info has not been sync'd");
        }
        ConfigurationParameterSetModel configurationParameterSetModel = (ConfigurationParameterSetModel) Preconditions.checkNotNull(ViewerConfigurationModelUtils.m2384a((ConfigurationParameterSetsConnectionModel) Preconditions.checkNotNull(a.l_(), "Parameter sets not found. Missing GraphQL data."), str2), "Parameter set with name %s not found.", new Object[]{str2});
        Map hashMap = new HashMap();
        ImmutableList m_ = configurationParameterSetModel.m_();
        int size = m_.size();
        for (int i = 0; i < size; i++) {
            QueryStringConfigurationParameterModel queryStringConfigurationParameterModel = (QueryStringConfigurationParameterModel) m_.get(i);
            hashMap.put(queryStringConfigurationParameterModel.m2430a(), queryStringConfigurationParameterModel.n_());
        }
        Builder h = new Builder().e(b.a).g(b.b).f(str2).c(true).d(false).h(b.f);
        h.g = hashMap;
        return h.a();
    }

    public final void m2506b(String str) {
        m2504c(str, null);
    }

    private void m2504c(String str, @Nullable String str2) {
        QuickExperimentInfo b;
        boolean b2 = this.f1818e.b(str);
        if (str2 != null) {
            b = m2502b(str, str2);
            if (b2) {
                this.f1818e.a(b);
            }
        } else {
            QuickExperimentInfo b3 = this.f1814a.b(str);
            Builder h = new Builder().e(str).g(b3.b).f("local_default_group").c(false).d(false).h(b3.f);
            h.g = RegularImmutableBiMap.a;
            b = h.a();
            if (b2) {
                this.f1818e.e(str);
            }
        }
        if (!b2) {
            this.f1815b.a(b, DataSource.FROM_USER);
            this.f1814a.c();
            this.f1816c.a(false);
        }
    }
}
