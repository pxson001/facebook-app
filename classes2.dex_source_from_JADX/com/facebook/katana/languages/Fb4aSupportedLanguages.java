package com.facebook.katana.languages;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.build.config.BuildConfig;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.idleexecutor.DefaultProcessIdleExecutor;
import com.facebook.common.idleexecutor.IdleExecutor;
import com.facebook.common.idleexecutor.IdleExecutor_DefaultIdleExecutorMethodAutoProvider;
import com.facebook.common.locale.MemoizedSupportedLanguages;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.module.AppVersionInfoMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.sessionless.GatekeeperStoreImpl_SessionlessMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.RegularImmutableSet;
import com.google.common.collect.Sets;
import java.util.Collection;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: validateRegistrationData */
public class Fb4aSupportedLanguages extends MemoizedSupportedLanguages {
    private static final String f1365a = Fb4aSupportedLanguages.class.getSimpleName();
    private static volatile Fb4aSupportedLanguages f1366i;
    public final Lazy<AnalyticsLogger> f1367b;
    public final AppVersionInfo f1368c;
    private final AbstractFbErrorReporter f1369d;
    private final GatekeeperStoreImpl f1370e;
    private final GatekeeperStoreImpl f1371f;
    private final DefaultProcessIdleExecutor f1372g;
    public boolean f1373h = false;

    public static com.facebook.katana.languages.Fb4aSupportedLanguages m2617a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1366i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.languages.Fb4aSupportedLanguages.class;
        monitor-enter(r1);
        r0 = f1366i;	 Catch:{ all -> 0x003a }
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
        r0 = m2618b(r0);	 Catch:{ all -> 0x0035 }
        f1366i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1366i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.languages.Fb4aSupportedLanguages.a(com.facebook.inject.InjectorLike):com.facebook.katana.languages.Fb4aSupportedLanguages");
    }

    private static Fb4aSupportedLanguages m2618b(InjectorLike injectorLike) {
        return new Fb4aSupportedLanguages(IdBasedSingletonScopeProvider.m1810b(injectorLike, 175), AppVersionInfoMethodAutoProvider.m2629a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), GatekeeperStoreImpl_SessionlessMethodAutoProvider.m2714a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), IdleExecutor_DefaultIdleExecutorMethodAutoProvider.m2724a(injectorLike));
    }

    @Inject
    public Fb4aSupportedLanguages(Lazy<AnalyticsLogger> lazy, AppVersionInfo appVersionInfo, FbErrorReporter fbErrorReporter, GatekeeperStore gatekeeperStore, GatekeeperStore gatekeeperStore2, IdleExecutor idleExecutor) {
        this.f1367b = lazy;
        this.f1368c = appVersionInfo;
        this.f1369d = fbErrorReporter;
        this.f1370e = gatekeeperStore;
        this.f1371f = gatekeeperStore2;
        this.f1372g = idleExecutor;
    }

    protected final ImmutableSet<String> mo361b() {
        Builder builder = ImmutableSet.builder();
        if (1 != 0) {
            builder.m4809b(mo363d());
            builder.m4813c("en");
        } else {
            this.f1372g.mo269a(new 1(this));
            builder.m4809b(ImmutableSet.copyOf((Object[]) BuildConfig.f));
        }
        return builder.m4812b();
    }

    protected final ImmutableSet<String> mo362c() {
        if (null == null) {
            return RegularImmutableSet.f688a;
        }
        Collection a = Sets.m1315a((Object[]) BuildConfig.f);
        a.remove("en");
        return ImmutableSet.copyOf(a);
    }

    protected final ImmutableSet<String> mo363d() {
        if (1 == 0 || !this.f1370e.m2189a(12, true)) {
            return RegularImmutableSet.f688a;
        }
        Builder builder = ImmutableSet.builder();
        builder.m4809b(Fb4aGeneratedSupportedLanguages.f2792a);
        if (this.f1370e.m2189a(11, false)) {
            builder.m4813c("my");
        }
        if (this.f1371f.m2189a(674, false)) {
            builder.m4813c("fb");
        }
        return builder.m4812b();
    }
}
