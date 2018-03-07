package com.facebook.orca.background;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.LruCache;
import com.facebook.analytics.CounterLogger;
import com.facebook.backgroundtasks.AbstractBackgroundTask;
import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.backgroundtasks.BackgroundTask.Prerequisite;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.ratelimiter.RateLimiter;
import com.facebook.common.time.SystemClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.background.MessagesLocalTaskTag;
import com.facebook.messaging.database.threads.DbCache;
import com.facebook.messaging.intents.MessagesBroadcastIntents;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadCriteria;
import com.facebook.messaging.service.model.FetchThreadParams;
import com.facebook.messaging.service.model.FetchThreadParamsBuilder;
import com.facebook.orca.server.module.MultiCacheThreadsQueue;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Annotation;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: failure_exception_message */
public class FetchOutOfDateThreadsBackgroundTask extends AbstractBackgroundTask {
    private static volatile FetchOutOfDateThreadsBackgroundTask f12262k;
    private final Provider<DbCache> f12263a;
    private final DefaultBlueServiceOperationFactory f12264b;
    public final LruCache<ThreadKey, Long> f12265c = new LruCache(32);
    private final RateLimiter f12266d;
    private final Provider<Boolean> f12267e;
    private final Provider<Boolean> f12268f;
    private final Provider<Boolean> f12269g;
    public final SystemClock f12270h;
    private final Provider<Boolean> f12271i;
    private final CounterLogger f12272j;

    /* compiled from: failure_exception_message */
    class C05851 implements ActionReceiver {
        final /* synthetic */ FetchOutOfDateThreadsBackgroundTask f12273a;

        C05851(FetchOutOfDateThreadsBackgroundTask fetchOutOfDateThreadsBackgroundTask) {
            this.f12273a = fetchOutOfDateThreadsBackgroundTask;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1007633343);
            this.f12273a.m7388g();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -317658955, a);
        }
    }

    public static com.facebook.orca.background.FetchOutOfDateThreadsBackgroundTask m12931a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12262k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.background.FetchOutOfDateThreadsBackgroundTask.class;
        monitor-enter(r1);
        r0 = f12262k;	 Catch:{ all -> 0x003a }
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
        r0 = m12932b(r0);	 Catch:{ all -> 0x0035 }
        f12262k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12262k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.background.FetchOutOfDateThreadsBackgroundTask.a(com.facebook.inject.InjectorLike):com.facebook.orca.background.FetchOutOfDateThreadsBackgroundTask");
    }

    private static FetchOutOfDateThreadsBackgroundTask m12932b(InjectorLike injectorLike) {
        return new FetchOutOfDateThreadsBackgroundTask(IdBasedProvider.a(injectorLike, 7803), DefaultBlueServiceOperationFactory.b(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), IdBasedProvider.a(injectorLike, 4075), IdBasedProvider.a(injectorLike, 4045), IdBasedProvider.a(injectorLike, 4095), SystemClockMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4163), CounterLogger.a(injectorLike));
    }

    @Inject
    public FetchOutOfDateThreadsBackgroundTask(Provider<DbCache> provider, BlueServiceOperationFactory blueServiceOperationFactory, FbBroadcastManager fbBroadcastManager, Provider<Boolean> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4, SystemClock systemClock, Provider<Boolean> provider5, CounterLogger counterLogger) {
        super("FETCH_OUT_OF_DATE_THREADS");
        this.f12263a = provider;
        this.f12264b = blueServiceOperationFactory;
        this.f12266d = new RateLimiter(systemClock, 25, 60000);
        this.f12267e = provider2;
        this.f12268f = provider3;
        this.f12269g = provider4;
        this.f12270h = systemClock;
        this.f12271i = provider5;
        this.f12272j = counterLogger;
        fbBroadcastManager.a().a(MessagesBroadcastIntents.b, new C05851(this)).a().b();
    }

    public final ImmutableSet<String> mo600c() {
        return ImmutableSet.of("FETCH_THREAD_LIST");
    }

    public final ImmutableSet<Class<? extends Annotation>> mo592d() {
        return ImmutableSet.of(MultiCacheThreadsQueue.class);
    }

    public final ImmutableSet<Class<? extends Annotation>> mo599b() {
        return ImmutableSet.of(MessagesLocalTaskTag.class);
    }

    public final Set<Prerequisite> mo594h() {
        return EnumSet.of(Prerequisite.NETWORK_CONNECTIVITY, Prerequisite.USER_LOGGED_IN);
    }

    public final boolean mo595i() {
        if (((Boolean) this.f12268f.get()).booleanValue() || !((Boolean) this.f12269g.get()).booleanValue()) {
            return false;
        }
        if (((Boolean) this.f12271i.get()).booleanValue()) {
            return false;
        }
        return m12933k() != null;
    }

    public final ListenableFuture<BackgroundResult> mo596j() {
        ThreadKey k = m12933k();
        if (k == null) {
            return null;
        }
        if (this.f12266d.a()) {
            FetchThreadParamsBuilder newBuilder = FetchThreadParams.newBuilder();
            newBuilder.a = ThreadCriteria.a(k);
            newBuilder = newBuilder;
            newBuilder.b = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
            newBuilder = newBuilder;
            newBuilder.f = 20;
            FetchThreadParams i = newBuilder.i();
            Bundle bundle = new Bundle();
            bundle.putParcelable("fetchThreadParams", i);
            OperationFuture a = BlueServiceOperationFactoryDetour.a(this.f12264b, "fetch_thread", bundle, CallerContext.a(FetchOutOfDateThreadsBackgroundTask.class), -1416229704).a();
            ListenableFuture<BackgroundResult> 2 = new 2(this, FetchOutOfDateThreadsBackgroundTask.class, k);
            Futures.a(a, 2);
            return 2;
        }
        BLog.c("FetchOutOfDateThreadsBackgroundTask", "Hit fetch thread rate limit. threadKey.type:%s", new Object[]{k.a});
        this.f12272j.a("android.messenger.fetch_out_of_date_threads_hit_ratelimit");
        return null;
    }

    private ThreadKey m12933k() {
        List c;
        if (((Boolean) this.f12267e.get()).booleanValue()) {
            c = ((DbCache) this.f12263a.get()).c(FolderName.INBOX);
        } else {
            c = ((DbCache) this.f12263a.get()).b(FolderName.INBOX);
        }
        long a = this.f12270h.a();
        for (ThreadKey threadKey : r0) {
            long j;
            Long l = (Long) this.f12265c.get(threadKey);
            if (l == null) {
                j = 0;
            } else {
                j = l.longValue();
            }
            if (j + 900000 < a) {
                return threadKey;
            }
        }
        return null;
    }
}
