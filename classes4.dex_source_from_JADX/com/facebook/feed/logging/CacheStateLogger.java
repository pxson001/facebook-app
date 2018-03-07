package com.facebook.feed.logging;

import android.os.Handler;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.api.feedtype.FeedType;
import com.facebook.common.executors.ForNonUiThread;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.Random;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: use_led */
public class CacheStateLogger {
    private static volatile CacheStateLogger f446f;
    @ForNonUiThread
    private final Handler f447a;
    public final DbFeedHomeStoriesHandler f448b;
    public final AnalyticsLogger f449c;
    public final Random f450d;
    private final Provider<Boolean> f451e;

    public static com.facebook.feed.logging.CacheStateLogger m752a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f446f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.logging.CacheStateLogger.class;
        monitor-enter(r1);
        r0 = f446f;	 Catch:{ all -> 0x003a }
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
        r0 = m753b(r0);	 Catch:{ all -> 0x0035 }
        f446f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f446f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.logging.CacheStateLogger.a(com.facebook.inject.InjectorLike):com.facebook.feed.logging.CacheStateLogger");
    }

    private static CacheStateLogger m753b(InjectorLike injectorLike) {
        return new CacheStateLogger(Handler_ForNonUiThreadMethodAutoProvider.b(injectorLike), DbFeedHomeStoriesHandler.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), Random_InsecureRandomMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3978));
    }

    @Inject
    public CacheStateLogger(Handler handler, DbFeedHomeStoriesHandler dbFeedHomeStoriesHandler, AnalyticsLogger analyticsLogger, Random random, Provider<Boolean> provider) {
        this.f447a = handler;
        this.f448b = dbFeedHomeStoriesHandler;
        this.f449c = analyticsLogger;
        this.f450d = random;
        this.f451e = provider;
    }

    public final void m754a(FeedType feedType, int i) {
        if (((Boolean) this.f451e.get()).booleanValue()) {
            Object obj;
            if (this.f450d.nextInt() % 200 == 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                HandlerDetour.a(this.f447a, new CacheStateLoggingTask(this, feedType, i), 111212458);
            }
        }
    }

    private static HoneyClientEvent m750a(FeedType feedType, int i, int i2, int i3, long j) {
        HoneyClientEvent a = new HoneyClientEvent("feed_db_cache_state").a("feed_type", feedType).a("num_new_stories", i).a("num_unseen_stories_in_cache", i2).a("num_total_stories_in_cache", j).a("num_gap_rows_in_cache", i3);
        a.c = "native_newsfeed";
        return a;
    }
}
