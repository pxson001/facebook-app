package com.facebook.abtest.qe.sessionlessqe;

import com.facebook.abtest.qe.service.background.AbstractSyncQuickExperimentBackgroundTask;
import com.facebook.abtest.qe.service.module.QuickExperimentQueue;
import com.facebook.abtest.qe.utils.LocaleUtil;
import com.facebook.backgroundtasks.BackgroundTask.Prerequisite;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
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
/* compiled from: fb_object_contents */
public class SyncSessionlessQuickExperimentBackgroundTask extends AbstractSyncQuickExperimentBackgroundTask {
    private static final Class<?> f11993a = SyncSessionlessQuickExperimentBackgroundTask.class;
    private static volatile SyncSessionlessQuickExperimentBackgroundTask f11994d;
    private final FbSharedPreferences f11995b;
    private final LocaleUtil f11996c;

    public static com.facebook.abtest.qe.sessionlessqe.SyncSessionlessQuickExperimentBackgroundTask m12652a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11994d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.abtest.qe.sessionlessqe.SyncSessionlessQuickExperimentBackgroundTask.class;
        monitor-enter(r1);
        r0 = f11994d;	 Catch:{ all -> 0x003a }
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
        r0 = m12653b(r0);	 Catch:{ all -> 0x0035 }
        f11994d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11994d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.abtest.qe.sessionlessqe.SyncSessionlessQuickExperimentBackgroundTask.a(com.facebook.inject.InjectorLike):com.facebook.abtest.qe.sessionlessqe.SyncSessionlessQuickExperimentBackgroundTask");
    }

    private static SyncSessionlessQuickExperimentBackgroundTask m12653b(InjectorLike injectorLike) {
        return new SyncSessionlessQuickExperimentBackgroundTask((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), LocaleUtil.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike.getApplicationInjector()), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SyncSessionlessQuickExperimentBackgroundTask(FbSharedPreferences fbSharedPreferences, Clock clock, LocaleUtil localeUtil, @NeedsApplicationInjector DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, ExecutorService executorService) {
        super("SyncSessionlessQuickExperimentBackgroundTask", f11993a, clock, executorService, defaultBlueServiceOperationFactory);
        this.f11996c = localeUtil;
        this.f11995b = fbSharedPreferences;
    }

    public final ImmutableSet<Class<? extends Annotation>> mo592d() {
        return ImmutableSet.of(QuickExperimentQueue.class);
    }

    public final Set<Prerequisite> mo594h() {
        return EnumSet.of(Prerequisite.NETWORK_CONNECTIVITY);
    }

    protected final long mo897k() {
        return this.f11995b.a(SessionlessQuickExperimentConfigPrefKeys.f13088b, 0);
    }

    protected final boolean mo898l() {
        String a = LocaleUtil.a();
        return !this.f11995b.a(SessionlessQuickExperimentConfigPrefKeys.f13089c, a).equals(a);
    }

    protected final long mo899m() {
        return 86400000;
    }

    protected final String mo900n() {
        return "sync_sessionless_qe";
    }

    protected final CallerContext mo901o() {
        return CallerContext.a(SyncSessionlessQuickExperimentBackgroundTask.class);
    }
}
