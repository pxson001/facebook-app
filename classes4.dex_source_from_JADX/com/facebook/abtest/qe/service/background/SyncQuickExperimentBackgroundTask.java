package com.facebook.abtest.qe.service.background;

import com.facebook.abtest.qe.data.QuickExperimentConfigPrefKeys;
import com.facebook.abtest.qe.service.module.QuickExperimentQueue;
import com.facebook.abtest.qe.utils.LocaleUtil;
import com.facebook.backgroundtasks.BackgroundTask.Prerequisite;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.NeedsApplicationInjector;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.google.common.collect.ImmutableSet;
import java.lang.annotation.Annotation;
import java.util.EnumSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: fb_server_build */
public class SyncQuickExperimentBackgroundTask extends AbstractSyncQuickExperimentBackgroundTask {
    private static final Class<?> f11981a = SyncQuickExperimentBackgroundTask.class;
    private static volatile SyncQuickExperimentBackgroundTask f11982e;
    private final FbSharedPreferences f11983b;
    private final LocaleUtil f11984c;
    private final GatekeeperStoreImpl f11985d;

    public static com.facebook.abtest.qe.service.background.SyncQuickExperimentBackgroundTask m12634a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11982e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.abtest.qe.service.background.SyncQuickExperimentBackgroundTask.class;
        monitor-enter(r1);
        r0 = f11982e;	 Catch:{ all -> 0x003a }
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
        r0 = m12635b(r0);	 Catch:{ all -> 0x0035 }
        f11982e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11982e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.abtest.qe.service.background.SyncQuickExperimentBackgroundTask.a(com.facebook.inject.InjectorLike):com.facebook.abtest.qe.service.background.SyncQuickExperimentBackgroundTask");
    }

    private static SyncQuickExperimentBackgroundTask m12635b(InjectorLike injectorLike) {
        return new SyncQuickExperimentBackgroundTask((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike.getApplicationInjector()), LocaleUtil.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SyncQuickExperimentBackgroundTask(FbSharedPreferences fbSharedPreferences, @NeedsApplicationInjector DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, LocaleUtil localeUtil, Clock clock, ExecutorService executorService, GatekeeperStoreImpl gatekeeperStoreImpl) {
        super("SYNC_QUICK_EXPERIMENT", f11981a, clock, executorService, defaultBlueServiceOperationFactory);
        this.f11983b = fbSharedPreferences;
        this.f11984c = localeUtil;
        this.f11985d = gatekeeperStoreImpl;
    }

    public final ImmutableSet<Class<? extends Annotation>> mo592d() {
        return ImmutableSet.of(QuickExperimentQueue.class);
    }

    public final Set<Prerequisite> mo594h() {
        return EnumSet.of(Prerequisite.USER_LOGGED_IN);
    }

    protected final long mo897k() {
        return this.f11983b.a(QuickExperimentConfigPrefKeys.f12799c, 0);
    }

    protected final boolean mo898l() {
        String a = LocaleUtil.a();
        return !this.f11983b.a(QuickExperimentConfigPrefKeys.f12800d, a).equals(a);
    }

    public final boolean mo595i() {
        boolean a = this.f11985d.a(295, false);
        boolean a2 = this.f11985d.a(519, false);
        if (a || a2) {
            return false;
        }
        return super.mo595i();
    }

    protected final long mo899m() {
        return 14400000;
    }

    protected final String mo900n() {
        return "sync_qe";
    }

    protected final CallerContext mo901o() {
        return CallerContext.a(SyncQuickExperimentBackgroundTask.class);
    }
}
