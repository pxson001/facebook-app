package com.facebook.api.feedcache.resync;

import android.content.Context;
import com.facebook.api.feed.xconfig.AsyncFeedXConfigReader;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.jobscheduler.compat.JobRequest;
import com.facebook.common.jobscheduler.compat.JobRequest.Builder;
import com.facebook.common.jobscheduler.compat.JobSchedulerCompat;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mostRecentTopLevelComments */
public class NewsFeedCacheSyncScheduler {
    private static volatile NewsFeedCacheSyncScheduler f7515d;
    private final Context f7516a;
    private final AsyncFeedXConfigReader f7517b;
    private final ExecutorService f7518c;

    public static com.facebook.api.feedcache.resync.NewsFeedCacheSyncScheduler m7810a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7515d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.api.feedcache.resync.NewsFeedCacheSyncScheduler.class;
        monitor-enter(r1);
        r0 = f7515d;	 Catch:{ all -> 0x003a }
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
        r0 = m7812b(r0);	 Catch:{ all -> 0x0035 }
        f7515d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7515d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.resync.NewsFeedCacheSyncScheduler.a(com.facebook.inject.InjectorLike):com.facebook.api.feedcache.resync.NewsFeedCacheSyncScheduler");
    }

    private static NewsFeedCacheSyncScheduler m7812b(InjectorLike injectorLike) {
        return new NewsFeedCacheSyncScheduler((Context) injectorLike.getInstance(Context.class), AsyncFeedXConfigReader.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public NewsFeedCacheSyncScheduler(Context context, AsyncFeedXConfigReader asyncFeedXConfigReader, ExecutorService executorService) {
        this.f7516a = context;
        this.f7517b = asyncFeedXConfigReader;
        this.f7518c = executorService;
    }

    public final synchronized void m7813a() {
        JobSchedulerCompat a = JobSchedulerCompat.m8273a(this.f7516a);
        if (a != null) {
            a.m8274a(2131558842);
        }
    }

    public final synchronized void m7814a(Runnable runnable) {
        ExecutorDetour.a(this.f7518c, runnable, -615815273);
        m7815b();
    }

    public final synchronized void m7815b() {
        long j = 60;
        synchronized (this) {
            long d = (long) this.f7517b.d(240);
            if (d >= 60) {
                j = d;
            }
            JobSchedulerCompat a = JobSchedulerCompat.m8273a(this.f7516a);
            if (a != null) {
                a.m8276a(m7811a(j));
            }
        }
    }

    private static JobRequest m7811a(long j) {
        Builder builder = new Builder(2131558842);
        builder.d = TimeUnit.MINUTES.toMillis(j);
        builder = builder;
        builder.e = TimeUnit.MINUTES.toMillis(30 + j);
        builder = builder;
        builder.b = 1;
        builder = builder;
        builder.c = false;
        return new JobRequest(builder);
    }
}
