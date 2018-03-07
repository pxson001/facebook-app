package com.facebook.feedplugins.pyml.fetcher;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.hscroll.HScrollFeedUnitFetcher;
import com.facebook.feed.hscroll.PaginatedHScrollFeedUnitCursorHelper;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feedplugins.pyml.prefs.PymlPrefKeys;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnit;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.Sets;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: onError MEDIA_ERROR_TIMED_OUT */
public class PaginatedPYMLWithLargeImageFeedUnitFetcher extends HScrollFeedUnitFetcher<GraphQLPYMLWithLargeImageFeedUnit> {
    private static volatile PaginatedPYMLWithLargeImageFeedUnitFetcher f6211n;
    public final Set<String> f6212a = Sets.a();
    public final Set<String> f6213b = Sets.a();
    public final Set<String> f6214c = Sets.a();
    public final GraphQLQueryExecutor f6215d;
    public final Executor f6216e;
    public final AnalyticsLogger f6217f;
    private final NewsFeedAnalyticsEventBuilder f6218g;
    public final FeedEventBus f6219h;
    public final FeedStoryMutator f6220i;
    public TasksManager<Void> f6221j;
    public final PaginatedHScrollFeedUnitCursorHelper f6222k;
    private final ScheduledExecutorService f6223l;
    public final QeAccessor f6224m;

    public static com.facebook.feedplugins.pyml.fetcher.PaginatedPYMLWithLargeImageFeedUnitFetcher m6678a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6211n;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedplugins.pyml.fetcher.PaginatedPYMLWithLargeImageFeedUnitFetcher.class;
        monitor-enter(r1);
        r0 = f6211n;	 Catch:{ all -> 0x003a }
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
        r0 = m6679b(r0);	 Catch:{ all -> 0x0035 }
        f6211n = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6211n;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.pyml.fetcher.PaginatedPYMLWithLargeImageFeedUnitFetcher.a(com.facebook.inject.InjectorLike):com.facebook.feedplugins.pyml.fetcher.PaginatedPYMLWithLargeImageFeedUnitFetcher");
    }

    private static PaginatedPYMLWithLargeImageFeedUnitFetcher m6679b(InjectorLike injectorLike) {
        return new PaginatedPYMLWithLargeImageFeedUnitFetcher(GraphQLQueryExecutor.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike), FeedStoryMutator.b(injectorLike), FeedEventBus.a(injectorLike), TasksManager.b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PaginatedPYMLWithLargeImageFeedUnitFetcher(GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, AnalyticsLogger analyticsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, FeedStoryMutator feedStoryMutator, FeedEventBus feedEventBus, TasksManager tasksManager, FbSharedPreferences fbSharedPreferences, ScheduledExecutorService scheduledExecutorService, QeAccessor qeAccessor) {
        this.f6215d = graphQLQueryExecutor;
        this.f6216e = executorService;
        this.f6217f = analyticsLogger;
        this.f6218g = newsFeedAnalyticsEventBuilder;
        this.f6220i = feedStoryMutator;
        this.f6219h = feedEventBus;
        this.f6221j = tasksManager;
        this.f6222k = new PaginatedHScrollFeedUnitCursorHelper(fbSharedPreferences, PymlPrefKeys.f6228a);
        this.f6223l = scheduledExecutorService;
        this.f6224m = qeAccessor;
    }
}
