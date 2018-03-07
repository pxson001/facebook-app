package com.facebook.orca.background;

import android.os.Bundle;
import com.facebook.backgroundtasks.AbstractBackgroundTask;
import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.backgroundtasks.BackgroundTask.Prerequisite;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.ratelimiter.RateLimiter;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.analytics.perf.MessagingPerformanceLogger;
import com.facebook.messaging.background.MessagesLocalTaskTag;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.cache.ThreadsCacheUpdateRateLimiter;
import com.facebook.messaging.database.threads.DbCache;
import com.facebook.messaging.database.threads.DbThreadProperties;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.folders.ThreadTypeFilter;
import com.facebook.messaging.service.model.FetchThreadListParams;
import com.facebook.messaging.service.model.FetchThreadListParamsBuilder;
import com.facebook.orca.server.module.MultiCacheThreadsQueue;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Annotation;
import java.util.EnumSet;
import java.util.Random;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: fa_suppression_on_pl_trigger */
public class FetchThreadListBackgroundTask extends AbstractBackgroundTask {
    private static volatile FetchThreadListBackgroundTask f12356m;
    private final Provider<DbCache> f12357a;
    private final Provider<ThreadsCacheUpdateRateLimiter> f12358b;
    private final DefaultBlueServiceOperationFactory f12359c;
    private final AppStateManager f12360d;
    private final Clock f12361e;
    private final RateLimiter f12362f;
    private final Provider<Boolean> f12363g;
    private final Provider<Boolean> f12364h;
    public final MessagingPerformanceLogger f12365i;
    private final Random f12366j = new Random();
    private final Provider<Boolean> f12367k;
    private final Provider<DataCache> f12368l;

    public static com.facebook.orca.background.FetchThreadListBackgroundTask m13057a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12356m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.background.FetchThreadListBackgroundTask.class;
        monitor-enter(r1);
        r0 = f12356m;	 Catch:{ all -> 0x003a }
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
        r0 = m13058b(r0);	 Catch:{ all -> 0x0035 }
        f12356m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12356m;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.background.FetchThreadListBackgroundTask.a(com.facebook.inject.InjectorLike):com.facebook.orca.background.FetchThreadListBackgroundTask");
    }

    private static FetchThreadListBackgroundTask m13058b(InjectorLike injectorLike) {
        return new FetchThreadListBackgroundTask(IdBasedProvider.a(injectorLike, 7803), IdBasedProvider.a(injectorLike, 7710), DefaultBlueServiceOperationFactory.b(injectorLike), AppStateManager.a(injectorLike), IdBasedProvider.a(injectorLike, 4075), IdBasedProvider.a(injectorLike, 4095), (Clock) SystemClockMethodAutoProvider.a(injectorLike), MessagingPerformanceLogger.m9038a(injectorLike), IdBasedProvider.a(injectorLike, 4045), IdBasedProvider.a(injectorLike, 2567));
    }

    @Inject
    public FetchThreadListBackgroundTask(Provider<DbCache> provider, Provider<ThreadsCacheUpdateRateLimiter> provider2, BlueServiceOperationFactory blueServiceOperationFactory, AppStateManager appStateManager, Provider<Boolean> provider3, Provider<Boolean> provider4, Clock clock, MessagingPerformanceLogger messagingPerformanceLogger, Provider<Boolean> provider5, Provider<DataCache> provider6) {
        super("FETCH_THREAD_LIST", 2);
        this.f12357a = provider;
        this.f12358b = provider2;
        this.f12359c = blueServiceOperationFactory;
        this.f12360d = appStateManager;
        this.f12363g = provider3;
        this.f12364h = provider4;
        this.f12361e = clock;
        this.f12368l = provider6;
        this.f12362f = new RateLimiter(clock, 10, 60000);
        this.f12365i = messagingPerformanceLogger;
        this.f12367k = provider5;
    }

    public final ImmutableSet<Class<? extends Annotation>> mo592d() {
        return ImmutableSet.of(MultiCacheThreadsQueue.class);
    }

    public final ImmutableSet<Class<? extends Annotation>> mo599b() {
        return ImmutableSet.of(MessagesLocalTaskTag.class);
    }

    public final Set<Prerequisite> mo594h() {
        return EnumSet.of(Prerequisite.USER_LOGGED_IN, Prerequisite.NETWORK_CONNECTIVITY);
    }

    public final boolean mo595i() {
        if (((Boolean) this.f12367k.get()).booleanValue()) {
            return false;
        }
        if (((Boolean) this.f12363g.get()).booleanValue() || !((Boolean) this.f12364h.get()).booleanValue()) {
            return false;
        }
        long a = this.f12361e.a() - ((DataCache) this.f12368l.get()).m10364c(FolderName.INBOX, ThreadTypeFilter.ALL);
        if (!this.f12360d.j() || a >= 21600000) {
            return m13056a(FolderName.INBOX) != null;
        } else {
            Long.valueOf(a);
            return false;
        }
    }

    public final ListenableFuture<BackgroundResult> mo596j() {
        int nextInt = this.f12366j.nextInt();
        this.f12365i.m9048a(nextInt, "FetchThreadListBackgroundTask");
        DataFreshnessParam a = m13056a(FolderName.INBOX);
        if (a == null) {
            return null;
        }
        if (this.f12362f.a()) {
            new StringBuilder("Starting fetch threads (").append(a).append(")");
            FetchThreadListParamsBuilder newBuilder = FetchThreadListParams.newBuilder();
            newBuilder.a = a;
            newBuilder = newBuilder;
            newBuilder.b = FolderName.INBOX;
            newBuilder = newBuilder;
            newBuilder.g = RequestPriority.CAN_WAIT;
            FetchThreadListParams h = newBuilder.h();
            Bundle bundle = new Bundle();
            bundle.putParcelable("fetchThreadListParams", h);
            bundle.putInt("logger_instance_key", nextInt);
            OperationFuture a2 = BlueServiceOperationFactoryDetour.a(this.f12359c, "fetch_thread_list", bundle, CallerContext.a(getClass()), 75613005).a();
            ListenableFuture<BackgroundResult> 1 = new 1(this, FetchThreadListBackgroundTask.class, nextInt);
            Futures.a(a2, 1);
            return 1;
        }
        BLog.c("FetchThreadListBackgroundTask", "Hit fetch thread list rate limit");
        return null;
    }

    private DataFreshnessParam m13056a(FolderName folderName) {
        boolean z = true;
        if (((DbCache) this.f12357a.get()).c.a(DbThreadProperties.c(folderName), true)) {
            z = false;
        }
        if (!z) {
            return DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
        }
        if (((ThreadsCacheUpdateRateLimiter) this.f12358b.get()).a(folderName)) {
            return DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE;
        }
        return null;
    }
}
