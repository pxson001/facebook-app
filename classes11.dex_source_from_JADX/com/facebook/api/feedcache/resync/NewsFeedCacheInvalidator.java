package com.facebook.api.feedcache.resync;

import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.api.feedcache.resync.analytics.NewsFeedCacheSyncAnalyticLogger;
import com.facebook.api.graphql.fetchstories.FetchInvalidStoriesGraphQl;
import com.facebook.api.graphql.fetchstories.FetchInvalidStoriesGraphQl.FetchInvalidStoriesString;
import com.facebook.api.graphql.fetchstories.FetchInvalidStoriesGraphQlModels.FetchInvalidStoriesModel;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: message_button_nux_mutation_success */
public class NewsFeedCacheInvalidator {
    private static volatile NewsFeedCacheInvalidator f5424e;
    private GraphQLQueryExecutor f5425a;
    public NewsFeedCacheSyncAnalyticLogger f5426b;
    public NewsFeedCacheSynchonizerHelper f5427c;
    private ExecutorService f5428d;

    public static com.facebook.api.feedcache.resync.NewsFeedCacheInvalidator m6644a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5424e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.api.feedcache.resync.NewsFeedCacheInvalidator.class;
        monitor-enter(r1);
        r0 = f5424e;	 Catch:{ all -> 0x003a }
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
        r0 = m6645b(r0);	 Catch:{ all -> 0x0035 }
        f5424e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5424e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.resync.NewsFeedCacheInvalidator.a(com.facebook.inject.InjectorLike):com.facebook.api.feedcache.resync.NewsFeedCacheInvalidator");
    }

    private static NewsFeedCacheInvalidator m6645b(InjectorLike injectorLike) {
        return new NewsFeedCacheInvalidator(GraphQLQueryExecutor.a(injectorLike), NewsFeedCacheSyncAnalyticLogger.m6678b(injectorLike), NewsFeedCacheSynchonizerHelper.m6663b(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public NewsFeedCacheInvalidator(GraphQLQueryExecutor graphQLQueryExecutor, NewsFeedCacheSyncAnalyticLogger newsFeedCacheSyncAnalyticLogger, NewsFeedCacheSynchonizerHelper newsFeedCacheSynchonizerHelper, ExecutorService executorService) {
        this.f5425a = graphQLQueryExecutor;
        this.f5426b = newsFeedCacheSyncAnalyticLogger;
        this.f5427c = newsFeedCacheSynchonizerHelper;
        this.f5428d = executorService;
    }

    public final boolean m6646a() {
        final HoneyClientEventFast b = this.f5426b.m6682b();
        try {
            final Map a = this.f5427c.m6664a();
            if (a == null || a.isEmpty()) {
                this.f5426b.m6683b(b, "no_cache_found");
                return false;
            }
            List arrayList = new ArrayList();
            for (GraphQLFeedUnitEdge c : a.values()) {
                arrayList.add(((GraphQLStory) c.c()).c());
            }
            FetchInvalidStoriesString a2 = FetchInvalidStoriesGraphQl.a();
            a2.a("ids", arrayList);
            Futures.a(GraphQLQueryExecutor.b(this.f5425a.a(GraphQLRequest.a(a2))), new FutureCallback<List<FetchInvalidStoriesModel>>(this) {
                final /* synthetic */ NewsFeedCacheInvalidator f5423c;

                public void onSuccess(@Nullable Object obj) {
                    List<FetchInvalidStoriesModel> list = (List) obj;
                    if (list != null) {
                        int i;
                        int size = a.size();
                        for (FetchInvalidStoriesModel j : list) {
                            String j2 = j.j();
                            if (j2 != null) {
                                a.remove(j2);
                            }
                        }
                        int size2 = a.size();
                        long j3 = 0;
                        if (size2 > 0) {
                            int nextInt = new Random().nextInt(size2);
                            int i2 = 0;
                            i = 0;
                            for (Entry entry : a.entrySet()) {
                                int i3;
                                if (i2 == nextInt) {
                                    j3 = ((GraphQLFeedUnitEdge) entry.getValue()).c().T_() / 60000;
                                }
                                if (((GraphQLFeedUnitEdge) entry.getValue()).j().equals("1")) {
                                    i3 = i + 1;
                                } else {
                                    i3 = i;
                                }
                                i2++;
                                i = i3;
                            }
                        } else {
                            i = 0;
                        }
                        this.f5423c.f5427c.m6665a(a);
                        this.f5423c.f5426b.m6680a(b, size, size2, i, j3);
                    }
                }

                public void onFailure(Throwable th) {
                    this.f5423c.f5426b.m6683b(b, th.getMessage());
                }
            }, this.f5428d);
            return true;
        } catch (Exception e) {
            this.f5426b.m6683b(b, e.getMessage());
            return false;
        }
    }
}
