package com.facebook.api.feedcache.db;

import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.feed.FetchFeedParams.FetchTypeForLogging;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbInsertionRequest;
import com.facebook.api.feedcache.db.FeedDbMutationService.FeedDbRequest;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: sanitized_display_refresh_rate */
public class FeedDbInsertionCoordinator {
    private static volatile FeedDbInsertionCoordinator f6301b;
    public final FeedDbMutationService f6302a;

    public static com.facebook.api.feedcache.db.FeedDbInsertionCoordinator m10538a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6301b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.api.feedcache.db.FeedDbInsertionCoordinator.class;
        monitor-enter(r1);
        r0 = f6301b;	 Catch:{ all -> 0x003a }
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
        r0 = m10539b(r0);	 Catch:{ all -> 0x0035 }
        f6301b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6301b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.db.FeedDbInsertionCoordinator.a(com.facebook.inject.InjectorLike):com.facebook.api.feedcache.db.FeedDbInsertionCoordinator");
    }

    private static FeedDbInsertionCoordinator m10539b(InjectorLike injectorLike) {
        return new FeedDbInsertionCoordinator(FeedDbMutationService.m9091a(injectorLike));
    }

    @Inject
    public FeedDbInsertionCoordinator(FeedDbMutationService feedDbMutationService) {
        this.f6302a = feedDbMutationService;
    }

    public final void m10540a(FetchFeedResult fetchFeedResult) {
        Object obj;
        FeedDbRequest feedDbInsertionRequest = new FeedDbInsertionRequest(fetchFeedResult);
        FetchFeedParams fetchFeedParams = fetchFeedResult.f15756a;
        if (fetchFeedParams == null || FetchTypeForLogging.TAIL != fetchFeedParams.f5798p) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            this.f6302a.m9111a((FeedDbInsertionRequest) feedDbInsertionRequest);
        } else {
            this.f6302a.m9112a(feedDbInsertionRequest);
        }
    }
}
