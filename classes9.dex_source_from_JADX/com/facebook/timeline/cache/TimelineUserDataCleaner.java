package com.facebook.timeline.cache;

import com.facebook.analytics.timeline.TimelineDiskCacheEvictionCounters;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.inject.InjectorLike;
import com.facebook.timeline.cache.db.TimelineDatabaseSupplier;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.collect.ImmutableSet;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: use_default_settings */
public class TimelineUserDataCleaner implements IHaveUserData {
    private static volatile TimelineUserDataCleaner f799e;
    private final TimelineDatabaseSupplier f800a;
    private final ExecutorService f801b;
    private final TimelineDiskCacheEvictionCounters f802c;
    private final GraphQLCacheManager f803d;

    /* compiled from: use_default_settings */
    class C00721 implements Runnable {
        final /* synthetic */ TimelineUserDataCleaner f798a;

        C00721(TimelineUserDataCleaner timelineUserDataCleaner) {
            this.f798a = timelineUserDataCleaner;
        }

        public void run() {
            this.f798a.m843a();
        }
    }

    public static com.facebook.timeline.cache.TimelineUserDataCleaner m841a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f799e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.cache.TimelineUserDataCleaner.class;
        monitor-enter(r1);
        r0 = f799e;	 Catch:{ all -> 0x003a }
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
        r0 = m842b(r0);	 Catch:{ all -> 0x0035 }
        f799e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f799e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.cache.TimelineUserDataCleaner.a(com.facebook.inject.InjectorLike):com.facebook.timeline.cache.TimelineUserDataCleaner");
    }

    private static TimelineUserDataCleaner m842b(InjectorLike injectorLike) {
        return new TimelineUserDataCleaner(TimelineDatabaseSupplier.m845a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), TimelineDiskCacheEvictionCounters.a(injectorLike), GraphQLCacheManager.a(injectorLike));
    }

    @Inject
    public TimelineUserDataCleaner(TimelineDatabaseSupplier timelineDatabaseSupplier, ExecutorService executorService, TimelineDiskCacheEvictionCounters timelineDiskCacheEvictionCounters, GraphQLCacheManager graphQLCacheManager) {
        this.f800a = timelineDatabaseSupplier;
        this.f801b = executorService;
        this.f802c = timelineDiskCacheEvictionCounters;
        this.f803d = graphQLCacheManager;
    }

    public final void m843a() {
        this.f800a.e();
        this.f803d.a(ImmutableSet.of("timeline_fetch_info_review", "timeline_fetch_header", "timeline_fetch_first_units_classic", "timeline_fetch_first_units_plutonium", "timeline_fetch_section"));
    }

    public final void m844a(String str) {
        this.f802c.a(str, 1);
        ExecutorDetour.a(this.f801b, new C00721(this), 2117091522);
    }

    public void clearUserData() {
        this.f802c.a("TimelineDBEvictionLogout", 1);
        m843a();
    }
}
