package com.facebook.aldrin.task;

import android.content.Context;
import com.facebook.aldrin.prefs.AldrinPrefKeys;
import com.facebook.aldrin.service.FetchAldrinUserStatusClient;
import com.facebook.aldrin.status.AldrinUserStatus;
import com.facebook.backgroundtasks.AbstractBackgroundTask;
import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.backgroundtasks.BackgroundTask.Prerequisite;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: fb_logo_badge_style */
public class UpdateAldrinUserStatusBackgroundTask extends AbstractBackgroundTask {
    private static volatile UpdateAldrinUserStatusBackgroundTask f11997h;
    private final Context f11998a;
    private final Clock f11999b;
    private final Provider<Boolean> f12000c;
    public final FbSharedPreferences f12001d;
    private final Lazy<FetchAldrinUserStatusClient> f12002e;
    private final ExecutorService f12003f;
    public ListenableFuture<AldrinUserStatus> f12004g;

    public static com.facebook.aldrin.task.UpdateAldrinUserStatusBackgroundTask m12661a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11997h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.aldrin.task.UpdateAldrinUserStatusBackgroundTask.class;
        monitor-enter(r1);
        r0 = f11997h;	 Catch:{ all -> 0x003a }
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
        r0 = m12662b(r0);	 Catch:{ all -> 0x0035 }
        f11997h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11997h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.aldrin.task.UpdateAldrinUserStatusBackgroundTask.a(com.facebook.inject.InjectorLike):com.facebook.aldrin.task.UpdateAldrinUserStatusBackgroundTask");
    }

    private static UpdateAldrinUserStatusBackgroundTask m12662b(InjectorLike injectorLike) {
        return new UpdateAldrinUserStatusBackgroundTask((Context) injectorLike.getInstance(Context.class, ForAppContext.class), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3873), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedLazy.a(injectorLike, 4768), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public UpdateAldrinUserStatusBackgroundTask(@ForAppContext Context context, Clock clock, Provider<Boolean> provider, FbSharedPreferences fbSharedPreferences, Lazy<FetchAldrinUserStatusClient> lazy, ExecutorService executorService) {
        super(UpdateAldrinUserStatusBackgroundTask.class.getSimpleName());
        this.f11998a = context;
        this.f11999b = clock;
        this.f12000c = provider;
        this.f12001d = fbSharedPreferences;
        this.f12002e = lazy;
        this.f12003f = executorService;
    }

    public final Set<Prerequisite> mo594h() {
        return ImmutableSet.of(Prerequisite.NETWORK_CONNECTIVITY);
    }

    public final boolean mo595i() {
        if (!((Boolean) this.f12000c.get()).booleanValue()) {
            return false;
        }
        return this.f12004g == null && m12664l() <= 0;
    }

    public final long mo593f() {
        if (((Boolean) this.f12000c.get()).booleanValue()) {
            return this.f11999b.a() + m12664l();
        }
        return -1;
    }

    public final ListenableFuture<BackgroundResult> mo596j() {
        m12663k();
        return Futures.a(new BackgroundResult(true));
    }

    private synchronized void m12663k() {
        if (this.f12004g == null) {
            this.f12004g = ((FetchAldrinUserStatusClient) this.f12002e.get()).a(CallerContext.a(getClass()));
            Futures.a(this.f12004g, new 1(this), this.f12003f);
        }
    }

    private long m12664l() {
        long a = this.f11999b.a();
        long a2 = this.f12001d.a(AldrinPrefKeys.a, 0);
        if (a < a2 + 7200000) {
            return (a2 + 7200000) - a;
        }
        a2 = this.f12001d.a(AldrinPrefKeys.b, 0);
        long m = m12665m(this);
        if (a < a2 + m) {
            return (a2 + m) - a;
        }
        return 0;
    }

    public static long m12665m(UpdateAldrinUserStatusBackgroundTask updateAldrinUserStatusBackgroundTask) {
        return Math.min(Math.max(updateAldrinUserStatusBackgroundTask.f12001d.a(AldrinPrefKeys.c, 1000), 1000), 7200000);
    }
}
