package com.facebook.notifications.util;

import android.os.Bundle;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.friends.protocol.FetchFriendRequestJewelCountGraphQL;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.abtest.ExperimentsForNotificationsAbtestModule;
import com.facebook.notifications.common.JewelCounters;
import com.facebook.notifications.common.JewelCounters.Jewel;
import com.facebook.notifications.protocol.FetchJewelCountsResult;
import com.facebook.notifications.protocol.FetchMessengerJewelCountsGraphQL.FetchMessengerJewelCountsString;
import com.facebook.notifications.sync.NotificationsSyncConstants.SyncSource;
import com.facebook.notifications.sync.NotificationsSyncManager;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: montageThreadFBID */
public class JewelCountHelper {
    public static final CallerContext f7519a = CallerContext.a(JewelCountHelper.class);
    private static volatile JewelCountHelper f7520k;
    public final DefaultBlueServiceOperationFactory f7521b;
    public final GraphQLQueryExecutor f7522c;
    private final JewelCounters f7523d;
    public final NotificationsSyncManager f7524e;
    private final Provider<ViewerContext> f7525f;
    public final QuickPerformanceLogger f7526g;
    public final InboxJewelCountSourceController f7527h;
    public final ListeningExecutorService f7528i;
    public final QeAccessor f7529j;

    /* compiled from: montageThreadFBID */
    public class C03821 extends OperationResultFutureCallback {
        final /* synthetic */ JewelCountHelper f7834a;

        public C03821(JewelCountHelper jewelCountHelper) {
            this.f7834a = jewelCountHelper;
        }

        protected final void m8086a(Object obj) {
            FetchJewelCountsResult fetchJewelCountsResult = (FetchJewelCountsResult) ((OperationResult) obj).k();
            if (fetchJewelCountsResult != null) {
                JewelCountHelper.m7818a(this.f7834a, Jewel.INBOX, this.f7834a.f7527h.m8009a() ? fetchJewelCountsResult.m10002d() : fetchJewelCountsResult.m10000b());
                JewelCountHelper.m7818a(this.f7834a, Jewel.FRIEND_REQUESTS, fetchJewelCountsResult.m9999a());
                this.f7834a.f7526g.b(3473412, (short) 2);
            }
        }

        protected final void mo148a(ServiceException serviceException) {
            this.f7834a.f7526g.b(3473412, (short) 3);
        }
    }

    public static com.facebook.notifications.util.JewelCountHelper m7817a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7520k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.util.JewelCountHelper.class;
        monitor-enter(r1);
        r0 = f7520k;	 Catch:{ all -> 0x003a }
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
        r0 = m7819b(r0);	 Catch:{ all -> 0x0035 }
        f7520k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7520k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.util.JewelCountHelper.a(com.facebook.inject.InjectorLike):com.facebook.notifications.util.JewelCountHelper");
    }

    private static JewelCountHelper m7819b(InjectorLike injectorLike) {
        return new JewelCountHelper(DefaultBlueServiceOperationFactory.b(injectorLike), GraphQLQueryExecutor.a(injectorLike), JewelCounters.a(injectorLike), NotificationsSyncManager.m7821a(injectorLike), IdBasedProvider.a(injectorLike, 372), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), InboxJewelCountSourceController.m8008b(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public JewelCountHelper(BlueServiceOperationFactory blueServiceOperationFactory, GraphQLQueryExecutor graphQLQueryExecutor, JewelCounters jewelCounters, NotificationsSyncManager notificationsSyncManager, Provider<ViewerContext> provider, QuickPerformanceLogger quickPerformanceLogger, InboxJewelCountSourceController inboxJewelCountSourceController, ListeningExecutorService listeningExecutorService, QeAccessor qeAccessor) {
        this.f7521b = blueServiceOperationFactory;
        this.f7522c = graphQLQueryExecutor;
        this.f7523d = jewelCounters;
        this.f7524e = notificationsSyncManager;
        this.f7525f = provider;
        this.f7526g = quickPerformanceLogger;
        this.f7527h = inboxJewelCountSourceController;
        this.f7528i = listeningExecutorService;
        this.f7529j = qeAccessor;
    }

    public final void m7820a() {
        this.f7524e.m7829a((ViewerContext) this.f7525f.get(), SyncSource.BACKGROUND);
        this.f7526g.b(3473412);
        if (this.f7529j.a(ExperimentsForNotificationsAbtestModule.f7759H, true)) {
            Bundle bundle = new Bundle();
            Futures.a(BlueServiceOperationFactoryDetour.a(this.f7521b, "fetchJewelCount", bundle, 1280207107).c(), new C03821(this), this.f7528i);
            return;
        }
        if (this.f7529j.a(ExperimentsForNotificationsAbtestModule.f7760I, false)) {
            GraphQLRequest a = GraphQLRequest.a(FetchFriendRequestJewelCountGraphQL.a());
            a.f = f7519a;
            Futures.a(this.f7522c.a(a), new 2(this), this.f7528i);
        }
        if (this.f7529j.a(ExperimentsForNotificationsAbtestModule.f7761J, false)) {
            a = GraphQLRequest.a(new FetchMessengerJewelCountsString());
            a.f = f7519a;
            Futures.a(this.f7522c.a(a), new 3(this), this.f7528i);
        }
    }

    public static void m7818a(JewelCountHelper jewelCountHelper, Jewel jewel, int i) {
        jewelCountHelper.f7523d.a(jewel, i);
    }
}
