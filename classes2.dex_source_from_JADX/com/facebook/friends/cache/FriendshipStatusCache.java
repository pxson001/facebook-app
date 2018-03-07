package com.facebook.friends.cache;

import com.facebook.cache.FactoryMethodAutoProvider;
import com.facebook.cache.TrackedLruCache;
import com.facebook.cache.TrackedLruCache.Factory;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.inject.InjectorLike;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Deprecated
@ThreadSafe
/* compiled from: frame_drop_by_autoblame */
public class FriendshipStatusCache {
    private static volatile FriendshipStatusCache f23318b;
    @GuardedBy("this")
    private final TrackedLruCache<Long, GraphQLFriendshipStatus> f23319a;

    public static com.facebook.friends.cache.FriendshipStatusCache m31471a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23318b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.friends.cache.FriendshipStatusCache.class;
        monitor-enter(r1);
        r0 = f23318b;	 Catch:{ all -> 0x003a }
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
        r0 = m31473b(r0);	 Catch:{ all -> 0x0035 }
        f23318b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23318b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.friends.cache.FriendshipStatusCache.a(com.facebook.inject.InjectorLike):com.facebook.friends.cache.FriendshipStatusCache");
    }

    private static FriendshipStatusCache m31473b(InjectorLike injectorLike) {
        return new FriendshipStatusCache(FactoryMethodAutoProvider.m9805a(injectorLike));
    }

    @Inject
    public FriendshipStatusCache(Factory factory) {
        this.f23319a = factory.m9821a(100, "friendship_status");
    }

    public final void m31475a(long j, GraphQLFriendshipStatus graphQLFriendshipStatus) {
        synchronized (this) {
            this.f23319a.m9842a(Long.valueOf(j), (Object) graphQLFriendshipStatus);
        }
    }

    public final GraphQLFriendshipStatus m31474a(String str) {
        return m31472a(Long.parseLong(str));
    }

    private GraphQLFriendshipStatus m31472a(long j) {
        GraphQLFriendshipStatus graphQLFriendshipStatus;
        synchronized (this) {
            graphQLFriendshipStatus = (GraphQLFriendshipStatus) this.f23319a.m9841a(Long.valueOf(j));
        }
        return graphQLFriendshipStatus;
    }
}
