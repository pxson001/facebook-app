package com.facebook.graphql.executor.cache;

import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.util.concurrent.SettableFuture;
import java.util.HashSet;
import java.util.Set;

/* compiled from: legacyStoryId */
class GraphQLCacheManager$CacheDeleteRunner implements Runnable {
    final /* synthetic */ GraphQLCacheManager f3246a;

    GraphQLCacheManager$CacheDeleteRunner(GraphQLCacheManager graphQLCacheManager) {
        this.f3246a = graphQLCacheManager;
    }

    public void run() {
        Set hashSet;
        SettableFuture settableFuture;
        synchronized (this.f3246a.c) {
            hashSet = new HashSet(this.f3246a.d);
            settableFuture = this.f3246a.e;
            GraphQLCacheManager.a(this.f3246a, null);
            this.f3246a.d.clear();
        }
        GraphQLCacheManager.b(this.f3246a, hashSet);
        FutureDetour.a(settableFuture, null, -1811692072);
    }
}
