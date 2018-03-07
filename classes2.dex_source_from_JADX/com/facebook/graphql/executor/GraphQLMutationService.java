package com.facebook.graphql.executor;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Pair;
import com.facebook.base.service.FbService;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.C0275x5d33d28;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ForegroundExecutorService;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.wakelock.FbWakeLockManager;
import com.facebook.common.wakelock.FbWakeLockManager.WakeLock;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: save_info.viewer_save_state */
public class GraphQLMutationService extends FbService {
    @Inject
    MutationRunner f6267a;
    @Inject
    MutationServiceManager f6268b;
    @Inject
    @ForUiThread
    ExecutorService f6269c;
    @Inject
    @ForegroundExecutorService
    ListeningExecutorService f6270d;
    @Inject
    FbWakeLockManager f6271e;
    @Inject
    AbstractFbErrorReporter f6272f;
    @Inject
    QuickPerformanceLogger f6273g;
    @GuardedBy("this")
    public int f6274h = 0;
    @GuardedBy("this")
    public int f6275i = 0;
    @GuardedBy("this")
    private WakeLock f6276j;

    private static <T extends Context> void m10473a(Class<T> cls, T t) {
        m10474a((Object) t, (Context) t);
    }

    public static void m10474a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((GraphQLMutationService) obj).m10471a(MutationRunner.b(injectorLike), MutationServiceManager.m10461a(injectorLike), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(injectorLike), C0275x5d33d28.m10458a(injectorLike), FbWakeLockManager.m31678a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike));
    }

    private void m10471a(MutationRunner mutationRunner, MutationServiceManager mutationServiceManager, ExecutorService executorService, ListeningExecutorService listeningExecutorService, FbWakeLockManager fbWakeLockManager, AbstractFbErrorReporter abstractFbErrorReporter, QuickPerformanceLogger quickPerformanceLogger) {
        this.f6267a = mutationRunner;
        this.f6268b = mutationServiceManager;
        this.f6269c = executorService;
        this.f6270d = listeningExecutorService;
        this.f6271e = fbWakeLockManager;
        this.f6272f = abstractFbErrorReporter;
        this.f6273g = quickPerformanceLogger;
    }

    public final void mo1459a() {
        super.mo1459a();
        Class cls = GraphQLMutationService.class;
        m10474a((Object) this, (Context) this);
    }

    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not meant to bind() to this service");
    }

    public final int mo1458a(Intent intent, int i, int i2) {
        boolean z = true;
        if (intent == null) {
            synchronized (this) {
                if (this.f6274h != 0) {
                    z = false;
                }
                Preconditions.checkState(z, "Got null intent while processing a comment");
            }
            stopSelf(i2);
        } else {
            long longExtra = intent.getLongExtra("MUTATION_ID_KEY", -1);
            if (longExtra == -1) {
                z = false;
            }
            Preconditions.checkState(z, "Missing extra in service Intent");
            Long.valueOf(longExtra);
            Integer.valueOf(i2);
            m10466a(i2, longExtra);
        }
        return 2;
    }

    private synchronized void m10466a(int i, long j) {
        if (this.f6274h == 0) {
            this.f6276j = m10478c();
        }
        this.f6274h++;
        this.f6275i = i;
        ExecutorDetour.a(this.f6270d, new 1(this, j, i), 1164669716);
    }

    private void m10467a(long j) {
        Pair a = this.f6268b.m10463a(j);
        if (a == null) {
            this.f6272f.m2340a("GraphQLMutationService_Invalid_ID", StringFormatUtil.a("Unknown operation ID %d", new Object[]{Long.valueOf(j)}));
            return;
        }
        SettableFuture settableFuture = (SettableFuture) a.first;
        MutationRunnerParams mutationRunnerParams = (MutationRunnerParams) a.second;
        this.f6273g.mo445a(3211305, mutationRunnerParams.g, (short) 15);
        m10472a(mutationRunnerParams.b, j);
        MutationRunner mutationRunner = this.f6267a;
        mutationRunner.n.m1655b();
        MutationRunner.b(mutationRunner, mutationRunnerParams, settableFuture, "_withservice");
    }

    private static void m10472a(MutationRequest mutationRequest, long j) {
        Long.valueOf(j);
        if (mutationRequest != null) {
            mutationRequest.a.getClass().getSimpleName();
        }
    }

    public static synchronized void m10477b(GraphQLMutationService graphQLMutationService, int i, long j) {
        synchronized (graphQLMutationService) {
            Long.valueOf(j);
            Integer.valueOf(i);
            graphQLMutationService.f6274h--;
            if (graphQLMutationService.f6274h == 0) {
                m10468a(graphQLMutationService.f6276j);
                graphQLMutationService.f6276j = null;
                graphQLMutationService.m10476b();
            }
        }
    }

    private void m10476b() {
        ExecutorDetour.a(this.f6269c, new 2(this), -573286652);
    }

    @Nullable
    private WakeLock m10478c() {
        try {
            WakeLock a = this.f6271e.m31680a(1, "GraphQLMutationService");
            a.m31690a(false);
            a.m31692c();
            return a;
        } catch (Throwable e) {
            BLog.a(GraphQLMutationService.class, "Failed to create WakeLock, continuing without it.", e);
            return null;
        }
    }

    private static void m10468a(@Nullable WakeLock wakeLock) {
        if (wakeLock != null && wakeLock.m31694e()) {
            wakeLock.m31693d();
        }
    }
}
