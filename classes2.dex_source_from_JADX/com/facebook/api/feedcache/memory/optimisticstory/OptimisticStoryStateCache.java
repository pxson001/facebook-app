package com.facebook.api.feedcache.memory.optimisticstory;

import android.support.v4.util.LruCache;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.GraphQLStory;
import javax.inject.Singleton;

@Singleton
/* compiled from: send_endpoint_capabilities */
public class OptimisticStoryStateCache {
    private static volatile OptimisticStoryStateCache f5647b;
    private final LruCache<String, GraphQLFeedOptimisticPublishState> f5648a = new LruCache(16);

    public static com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache m9726a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f5647b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache.class;
        monitor-enter(r1);
        r0 = f5647b;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x0039 }
        r3 = r2.m1503b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m9725a();	 Catch:{ all -> 0x0034 }
        f5647b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f5647b;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache.a(com.facebook.inject.InjectorLike):com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache");
    }

    private static OptimisticStoryStateCache m9725a() {
        return new OptimisticStoryStateCache();
    }

    public final GraphQLFeedOptimisticPublishState m9728a(GraphQLStory graphQLStory) {
        Object c = m9727c(graphQLStory);
        if (c == null) {
            return GraphQLFeedOptimisticPublishState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        GraphQLFeedOptimisticPublishState graphQLFeedOptimisticPublishState = (GraphQLFeedOptimisticPublishState) this.f5648a.m4432a(c);
        return graphQLFeedOptimisticPublishState == null ? GraphQLFeedOptimisticPublishState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE : graphQLFeedOptimisticPublishState;
    }

    public final void m9729a(GraphQLStory graphQLStory, GraphQLFeedOptimisticPublishState graphQLFeedOptimisticPublishState) {
        this.f5648a.m4433a(m9727c(graphQLStory), (Object) graphQLFeedOptimisticPublishState);
    }

    public final boolean m9730b(GraphQLStory graphQLStory) {
        GraphQLFeedOptimisticPublishState a = m9728a(graphQLStory);
        return a == GraphQLFeedOptimisticPublishState.SUCCESS || a == GraphQLFeedOptimisticPublishState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }

    private static String m9727c(GraphQLStory graphQLStory) {
        return graphQLStory.m22334T() != null ? graphQLStory.m22334T() : graphQLStory.ai();
    }
}
