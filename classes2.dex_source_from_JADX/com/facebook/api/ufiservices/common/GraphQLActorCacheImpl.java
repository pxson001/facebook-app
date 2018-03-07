package com.facebook.api.ufiservices.common;

import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLActor.Builder;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.inject.InjectorLike;
import com.facebook.user.model.User;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: play.google.com */
public class GraphQLActorCacheImpl {
    private static volatile GraphQLActorCacheImpl f9550b;
    private final LoggedInUserSessionManager f9551a;

    public static com.facebook.api.ufiservices.common.GraphQLActorCacheImpl m14532a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9550b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.api.ufiservices.common.GraphQLActorCacheImpl.class;
        monitor-enter(r1);
        r0 = f9550b;	 Catch:{ all -> 0x003a }
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
        r0 = m14533b(r0);	 Catch:{ all -> 0x0035 }
        f9550b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9550b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.ufiservices.common.GraphQLActorCacheImpl.a(com.facebook.inject.InjectorLike):com.facebook.api.ufiservices.common.GraphQLActorCacheImpl");
    }

    private static GraphQLActorCacheImpl m14533b(InjectorLike injectorLike) {
        return new GraphQLActorCacheImpl(LoggedInUserSessionManager.m2511a(injectorLike));
    }

    @Inject
    public GraphQLActorCacheImpl(LoggedInUserSessionManager loggedInUserSessionManager) {
        this.f9551a = loggedInUserSessionManager;
    }

    public final GraphQLActor m14534a() {
        if (!this.f9551a.m2522b()) {
            return null;
        }
        GraphQLActor graphQLActor;
        User c = this.f9551a.m2523c();
        String str = c.f3598a;
        String j = c.m5845j();
        String x = c.m5856x();
        if (j == null || x == null) {
            graphQLActor = null;
        } else {
            GraphQLImage a = GraphQLHelper.m22457a(x, 0, 0);
            Builder builder = new Builder();
            builder.B = str;
            builder.V = j;
            builder.ad = a;
            builder.aH = new GraphQLObjectType(2645995);
            graphQLActor = builder.a();
        }
        return graphQLActor;
    }
}
