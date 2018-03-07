package com.facebook.orca.background;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Process;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.util.LruCache;
import com.facebook.analytics.CounterLogger;
import com.facebook.backgroundtasks.AbstractBackgroundTask;
import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.backgroundtasks.BackgroundTask.Prerequisite;
import com.facebook.common.android.LocalBroadcastManagerMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.Executor_SameThreadExecutorMethodAutoProvider;
import com.facebook.common.ratelimiter.RateLimiter;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.debugoverlay.DebugOverlayController;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.analytics.perf.MessagingPerformanceLogger;
import com.facebook.messaging.background.MessagesLocalTaskTag;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.debugoverlay.MessagesDebugOverlaySettingsTags;
import com.facebook.messaging.intents.MessagesBroadcastIntents;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadCriteria;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.service.model.FetchThreadParams;
import com.facebook.orca.server.module.MultiCacheThreadsQueue;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: logged_out_push */
public class FetchThreadsIntoMemoryCacheBackgroundTask extends AbstractBackgroundTask {
    private static volatile FetchThreadsIntoMemoryCacheBackgroundTask f8953v;
    protected final Executor f8954a;
    public final Provider<DataCache> f8955b;
    private final RateLimiter f8956c;
    private final DefaultBlueServiceOperationFactory f8957d;
    private final Provider<Boolean> f8958e;
    public final Clock f8959f;
    public final Set<ThreadKey> f8960g = new HashSet();
    public volatile List<ThreadKey> f8961h = Collections.emptyList();
    public final LruCache<String, String> f8962i = new LruCache(3);
    private final LruCache<String, String> f8963j = new LruCache(32);
    public final LruCache<String, String> f8964k = new LruCache(32);
    private final Provider<Boolean> f8965l;
    public final Provider<Boolean> f8966m;
    private final LocalBroadcastManager f8967n;
    private final DefaultAndroidThreadUtil f8968o;
    private final DebugOverlayController f8969p;
    public final MessagingPerformanceLogger f8970q;
    private final Random f8971r;
    private BroadcastReceiver f8972s;
    private final Provider<Boolean> f8973t;
    private final CounterLogger f8974u;

    public static com.facebook.orca.background.FetchThreadsIntoMemoryCacheBackgroundTask m9298a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8953v;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.background.FetchThreadsIntoMemoryCacheBackgroundTask.class;
        monitor-enter(r1);
        r0 = f8953v;	 Catch:{ all -> 0x003a }
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
        r0 = m9299b(r0);	 Catch:{ all -> 0x0035 }
        f8953v = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8953v;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.background.FetchThreadsIntoMemoryCacheBackgroundTask.a(com.facebook.inject.InjectorLike):com.facebook.orca.background.FetchThreadsIntoMemoryCacheBackgroundTask");
    }

    private static FetchThreadsIntoMemoryCacheBackgroundTask m9299b(InjectorLike injectorLike) {
        return new FetchThreadsIntoMemoryCacheBackgroundTask(IdBasedProvider.a(injectorLike, 2567), DefaultBlueServiceOperationFactory.b(injectorLike), LocalBroadcastManagerMethodAutoProvider.m7676a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4045), Executor_SameThreadExecutorMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4095), IdBasedProvider.a(injectorLike, 4349), DefaultAndroidThreadUtil.b(injectorLike), DebugOverlayController.m9307a(injectorLike), MessagingPerformanceLogger.m9038a(injectorLike), IdBasedProvider.a(injectorLike, 4163), CounterLogger.a(injectorLike));
    }

    @Inject
    public FetchThreadsIntoMemoryCacheBackgroundTask(Provider<DataCache> provider, BlueServiceOperationFactory blueServiceOperationFactory, LocalBroadcastManager localBroadcastManager, Clock clock, Provider<Boolean> provider2, Executor executor, Provider<Boolean> provider3, Provider<Boolean> provider4, AndroidThreadUtil androidThreadUtil, DebugOverlayController debugOverlayController, MessagingPerformanceLogger messagingPerformanceLogger, Provider<Boolean> provider5, CounterLogger counterLogger) {
        super("FETCH_THREADS_INTO_MEMORY_CACHE", 2);
        this.f8955b = provider;
        this.f8956c = new RateLimiter(clock, 30, 60000);
        this.f8957d = blueServiceOperationFactory;
        this.f8958e = provider2;
        this.f8965l = provider3;
        this.f8966m = provider4;
        this.f8959f = clock;
        this.f8954a = executor;
        this.f8967n = localBroadcastManager;
        this.f8968o = androidThreadUtil;
        this.f8969p = debugOverlayController;
        this.f8970q = messagingPerformanceLogger;
        this.f8971r = new Random();
        this.f8973t = provider5;
        this.f8974u = counterLogger;
    }

    public final void m9306k() {
        this.f8968o.a();
        if (this.f8972s == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(MessagesBroadcastIntents.i);
            this.f8972s = new 1(this);
            this.f8967n.a(this.f8972s, intentFilter);
        }
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
        return EnumSet.of(Prerequisite.USER_LOGGED_IN, Prerequisite.NETWORK_CONNECTIVITY);
    }

    public final boolean mo595i() {
        if (((Boolean) this.f8958e.get()).booleanValue() || !((Boolean) this.f8965l.get()).booleanValue()) {
            return false;
        }
        if (((Boolean) this.f8973t.get()).booleanValue()) {
            return false;
        }
        return m9297a(false) != null;
    }

    public final ListenableFuture<BackgroundResult> mo596j() {
        int nextInt = this.f8971r.nextInt();
        this.f8970q.m9057b(nextInt, "FetchThreadsIntoMemoryCacheBackgroundTask");
        ThreadKey a = m9297a(true);
        if (a == null) {
            return null;
        }
        if (this.f8956c.a()) {
            this.f8969p.m9309a(MessagesDebugOverlaySettingsTags.d, "FetchThreadsIntoMemoryCacheBackgroundTask " + a);
            synchronized (this.f8960g) {
                this.f8960g.add(a);
            }
            FetchThreadParams i = FetchThreadParams.newBuilder().a(ThreadCriteria.a(a)).a(DataFreshnessParam.STALE_DATA_OKAY).a(20).i();
            Bundle bundle = new Bundle();
            bundle.putParcelable("fetchThreadParams", i);
            bundle.putInt("logger_instance_key", nextInt);
            OperationFuture a2 = BlueServiceOperationFactoryDetour.a(this.f8957d, "fetch_thread", bundle, CallerContext.a(FetchThreadsIntoMemoryCacheBackgroundTask.class), 1742310160).a();
            ListenableFuture<BackgroundResult> 2 = new 2(this, FetchThreadsIntoMemoryCacheBackgroundTask.class, nextInt, a);
            Futures.a(a2, 2);
            a2.a(new 3(this, a), this.f8954a);
            return 2;
        }
        BLog.c("FetchThreadsIntoMemoryCacheBackgroundTask", "Hit ratelimit! in-view: %s\nRecent attempts: %s\nRecent results: %s\nRecent errors: %s", new Object[]{this.f8961h, this.f8963j.d().keySet(), this.f8964k.d().keySet(), this.f8962i.d().keySet()});
        this.f8974u.a("android.messenger.fetch_threads_into_memory_cache_hit_ratelimit");
        return null;
    }

    private ThreadKey m9297a(boolean z) {
        DataCache dataCache = (DataCache) this.f8955b.get();
        List list = this.f8961h;
        for (ThreadKey threadKey : this.f8961h) {
            synchronized (this.f8960g) {
                boolean contains = this.f8960g.contains(threadKey);
            }
            if (!contains) {
                ThreadSummary a = dataCache.m10348a(threadKey);
                MessagesCollection b = dataCache.m10360b(threadKey);
                if (a == null || b == null) {
                    if (!z) {
                        return threadKey;
                    }
                    String str = threadKey + "-" + this.f8959f.a() + "-" + (a == null ? 0 : 1) + "-" + Process.myTid();
                    this.f8963j.a(str, str);
                    return threadKey;
                }
            }
        }
        return null;
    }
}
