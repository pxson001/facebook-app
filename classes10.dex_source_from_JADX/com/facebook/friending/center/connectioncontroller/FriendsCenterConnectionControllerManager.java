package com.facebook.friending.center.connectioncontroller;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.controller.connectioncontroller.ConnectionControllerBuilder;
import com.facebook.controller.connectioncontroller.ConnectionControllerBuilderProvider;
import com.facebook.controller.connectioncontroller.common.ConnectionCachePolicy;
import com.facebook.controller.connectioncontroller.common.ConnectionCacheRetainingPolicy.Builder;
import com.facebook.controller.connectioncontroller.common.ConnectionController;
import com.facebook.friending.center.abtest.ExperimentsForFriendsCenterABTestModule;
import com.facebook.friending.center.abtest.FriendsCenterGateKeepers;
import com.facebook.friending.center.protocol.FriendsCenterDefaultFieldsGraphQLModels.FriendsCenterDefaultNodeModel;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: all_items_state */
public class FriendsCenterConnectionControllerManager {
    private static volatile FriendsCenterConnectionControllerManager f19956g;
    public final ConnectionControllerBuilderProvider f19957a;
    public final FriendsCenterGateKeepers f19958b;
    public final QeAccessor f19959c;
    public final DefaultAndroidThreadUtil f19960d;
    public final ConnectionControllerHandler<FriendsCenterDefaultNodeModel, Void> f19961e;
    public final ConnectionControllerHandler<FriendsCenterDefaultNodeModel, Void> f19962f;

    /* compiled from: all_items_state */
    public class ConnectionControllerHandler<TEdge, TUserInfo> {
        private final ConnectionControllerBuilder<TEdge, TUserInfo> f19953a;
        private ConnectionController<TEdge, TUserInfo> f19954b;
        private boolean f19955c;

        ConnectionControllerHandler(ConnectionControllerBuilder<TEdge, TUserInfo> connectionControllerBuilder) {
            this.f19953a = connectionControllerBuilder;
        }

        public final ConnectionController<TEdge, TUserInfo> m20126a() {
            if (this.f19954b == null) {
                this.f19954b = this.f19953a.a();
            } else {
                this.f19954b.a();
            }
            return this.f19954b;
        }

        public final void m20127b() {
            Preconditions.checkState(this.f19954b != null);
            if (this.f19955c) {
                this.f19954b.c();
                this.f19955c = false;
            }
            this.f19954b.b();
            this.f19954b = null;
        }

        final void m20128c() {
            if (this.f19954b != null) {
                this.f19955c = true;
                return;
            }
            this.f19954b = this.f19953a.b();
            this.f19954b.c();
        }
    }

    public static com.facebook.friending.center.connectioncontroller.FriendsCenterConnectionControllerManager m20129a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19956g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.friending.center.connectioncontroller.FriendsCenterConnectionControllerManager.class;
        monitor-enter(r1);
        r0 = f19956g;	 Catch:{ all -> 0x003a }
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
        r0 = m20130b(r0);	 Catch:{ all -> 0x0035 }
        f19956g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19956g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.friending.center.connectioncontroller.FriendsCenterConnectionControllerManager.a(com.facebook.inject.InjectorLike):com.facebook.friending.center.connectioncontroller.FriendsCenterConnectionControllerManager");
    }

    private static FriendsCenterConnectionControllerManager m20130b(InjectorLike injectorLike) {
        return new FriendsCenterConnectionControllerManager((ConnectionControllerBuilderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ConnectionControllerBuilderProvider.class), FriendsCenterGateKeepers.m20124b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike));
    }

    @Inject
    public FriendsCenterConnectionControllerManager(ConnectionControllerBuilderProvider connectionControllerBuilderProvider, FriendsCenterGateKeepers friendsCenterGateKeepers, QeAccessor qeAccessor, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f19957a = connectionControllerBuilderProvider;
        this.f19958b = friendsCenterGateKeepers;
        this.f19959c = qeAccessor;
        this.f19960d = defaultAndroidThreadUtil;
        ConnectionControllerBuilder a = this.f19957a.a("FriendsCenterSuggestions", new SuggestionsConnectionConfiguration());
        a.f = ConnectionCachePolicy.MEMORY_DISK;
        a = a;
        Builder builder = new Builder();
        builder.a = 600;
        a.h = builder.a();
        this.f19961e = new ConnectionControllerHandler(a);
        this.f19962f = new ConnectionControllerHandler(m20131h());
    }

    public final void m20132c() {
        this.f19960d.a();
        if (this.f19958b.m20125b()) {
            this.f19961e.m20128c();
        }
    }

    private ConnectionControllerBuilder<FriendsCenterDefaultNodeModel, Void> m20131h() {
        ConnectionCachePolicy connectionCachePolicy;
        GraphQLCachePolicy graphQLCachePolicy;
        boolean a = this.f19959c.a(ExperimentsForFriendsCenterABTestModule.f19949a, false);
        long a2 = this.f19959c.a(ExperimentsForFriendsCenterABTestModule.f19951c, 600);
        ConnectionControllerBuilder<FriendsCenterDefaultNodeModel, Void> a3 = this.f19957a.a("FriendsCenter", new FriendsConnectionConfiguration());
        if (a) {
            connectionCachePolicy = ConnectionCachePolicy.MEMORY_DISK;
        } else {
            connectionCachePolicy = ConnectionCachePolicy.MEMORY_ONLY;
        }
        a3.f = connectionCachePolicy;
        a3 = a3;
        Builder builder = new Builder();
        builder.a = a2;
        Builder builder2 = builder;
        if (a) {
            graphQLCachePolicy = null;
        } else {
            graphQLCachePolicy = GraphQLCachePolicy.a;
        }
        builder2.b = graphQLCachePolicy;
        a3.h = builder2.a();
        ConnectionControllerBuilder<FriendsCenterDefaultNodeModel, Void> connectionControllerBuilder = a3;
        connectionControllerBuilder.i = true;
        connectionControllerBuilder = connectionControllerBuilder;
        connectionControllerBuilder.l = 500;
        return connectionControllerBuilder;
    }

    public final void m20133f() {
        this.f19960d.a();
        if (this.f19959c.a(ExperimentsForFriendsCenterABTestModule.f19950b, false)) {
            this.f19962f.m20128c();
        }
    }
}
