package com.facebook.notifications.util;

import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.controller.connectioncontroller.ConnectionControllerBuilder;
import com.facebook.controller.connectioncontroller.ConnectionControllerBuilderProvider;
import com.facebook.controller.connectioncontroller.PiecemealConnectionController;
import com.facebook.controller.connectioncontroller.common.ConnectionCachePolicy;
import com.facebook.controller.connectioncontroller.common.ConnectionController;
import com.facebook.controller.connectioncontroller.common.ConnectionInitialFetchPolicy;
import com.facebook.controller.connectioncontroller.common.ConnectionListener;
import com.facebook.controller.connectioncontroller.common.ConnectionLocation;
import com.facebook.controller.connectioncontroller.common.ConnectionOrder;
import com.facebook.controller.connectioncontroller.common.ConnectionState;
import com.facebook.controller.connectioncontroller.common.ListViewConnectionListener;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.common.JewelCounters;
import com.facebook.notifications.common.JewelCounters.Jewel;
import com.facebook.notifications.protocol.FetchGraphQLNotificationsParamsBuilder;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel;
import com.facebook.notifications.sync.NotificationsSyncConstants.SyncSource;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.collect.Lists;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: missing-package */
public class NotificationsConnectionControllerManager implements IHaveUserData {
    private static volatile NotificationsConnectionControllerManager f7625h;
    private final ConnectionControllerBuilderProvider f7626a;
    public final ViewerContextManager f7627b;
    private final NotificationsConnectionConfigurationProvider f7628c;
    private final Executor f7629d;
    public final JewelCounters f7630e;
    public ConnectionController f7631f;
    public ConnectionListener<FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel> f7632g;

    /* compiled from: missing-package */
    class C03871 extends ListViewConnectionListener<FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel> {
        final /* synthetic */ NotificationsConnectionControllerManager f7946a;

        C03871(NotificationsConnectionControllerManager notificationsConnectionControllerManager) {
            this.f7946a = notificationsConnectionControllerManager;
        }

        public final void mo627a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
        }

        public final void mo630b(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
            if (this.f7946a.f7631f != null) {
                NotificationsConnectionControllerManager notificationsConnectionControllerManager = this.f7946a;
                ConnectionState d = notificationsConnectionControllerManager.f7631f.mo644d();
                int i = 0;
                for (int i2 = 0; i2 < d.mo625d(); i2++) {
                    FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel fetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel = (FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel) d.mo622a(i2);
                    if (!(fetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel == null || fetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel.mo822k() == null || fetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel.mo822k().c() == null)) {
                        GraphQLStorySeenState au = fetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel.mo822k().au();
                        if (au != null && au != GraphQLStorySeenState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE && au != GraphQLStorySeenState.UNSEEN_AND_UNREAD) {
                            break;
                        }
                        i++;
                    }
                }
                notificationsConnectionControllerManager.f7630e.a(Jewel.NOTIFICATIONS, i);
            }
        }

        public final void mo628a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder, Throwable th) {
        }

        public final void mo629a(boolean z) {
        }
    }

    public static com.facebook.notifications.util.NotificationsConnectionControllerManager m7962a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7625h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.util.NotificationsConnectionControllerManager.class;
        monitor-enter(r1);
        r0 = f7625h;	 Catch:{ all -> 0x003a }
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
        r0 = m7963b(r0);	 Catch:{ all -> 0x0035 }
        f7625h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7625h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.util.NotificationsConnectionControllerManager.a(com.facebook.inject.InjectorLike):com.facebook.notifications.util.NotificationsConnectionControllerManager");
    }

    private static NotificationsConnectionControllerManager m7963b(InjectorLike injectorLike) {
        return new NotificationsConnectionControllerManager((ConnectionControllerBuilderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ConnectionControllerBuilderProvider.class), ViewerContextManagerProvider.b(injectorLike), (NotificationsConnectionConfigurationProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(NotificationsConnectionConfigurationProvider.class), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), JewelCounters.a(injectorLike));
    }

    @Inject
    public NotificationsConnectionControllerManager(ConnectionControllerBuilderProvider connectionControllerBuilderProvider, ViewerContextManager viewerContextManager, NotificationsConnectionConfigurationProvider notificationsConnectionConfigurationProvider, Executor executor, JewelCounters jewelCounters) {
        this.f7626a = connectionControllerBuilderProvider;
        this.f7627b = viewerContextManager;
        this.f7628c = notificationsConnectionConfigurationProvider;
        this.f7629d = executor;
        this.f7630e = jewelCounters;
    }

    public final ConnectionController<FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel, Void> m7964a() {
        if (this.f7631f != null) {
            return this.f7631f;
        }
        InjectorLike injectorLike = this.f7628c;
        FetchGraphQLNotificationsParamsBuilder fetchGraphQLNotificationsParamsBuilder = new FetchGraphQLNotificationsParamsBuilder();
        fetchGraphQLNotificationsParamsBuilder.f7659f = this.f7627b.d();
        fetchGraphQLNotificationsParamsBuilder = fetchGraphQLNotificationsParamsBuilder;
        fetchGraphQLNotificationsParamsBuilder.f7654a = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
        fetchGraphQLNotificationsParamsBuilder = fetchGraphQLNotificationsParamsBuilder.m8034a(Lists.a(new String[]{"null"}));
        fetchGraphQLNotificationsParamsBuilder.f7655b = 10;
        fetchGraphQLNotificationsParamsBuilder = fetchGraphQLNotificationsParamsBuilder;
        fetchGraphQLNotificationsParamsBuilder.f7660g = SyncSource.COLD_START.toString();
        ConnectionControllerBuilder a = this.f7626a.m7965a("notifications_session", new NotificationsConnectionConfiguration(fetchGraphQLNotificationsParamsBuilder.m8038p(), NotificationsQueryBuilder.m8051b(injectorLike)));
        a.f7814f = ConnectionCachePolicy.MEMORY_DISK;
        a = a;
        a.f7815g = ConnectionInitialFetchPolicy.CHECK_SERVER_FOR_NEWDATA;
        a = a;
        a.f7819k = new NotificationsEdgeDeduplicationKeyExtractor();
        this.f7631f = new PiecemealConnectionController(a.m8069a());
        this.f7632g = new C03871(this);
        this.f7631f.mo637a(this.f7632g);
        return this.f7631f;
    }

    public void clearUserData() {
        ExecutorDetour.a(this.f7629d, new 2(this), 1294091510);
    }
}
