package com.facebook.notifications.sync;

import android.os.Bundle;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.CollectionUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.controller.connectioncontroller.ConnectionControllerImpl;
import com.facebook.controller.connectioncontroller.PiecemealConnectionController;
import com.facebook.controller.connectioncontroller.common.ConnectionController;
import com.facebook.controller.connectioncontroller.common.ConnectionListener;
import com.facebook.controller.connectioncontroller.common.ConnectionLocation;
import com.facebook.controller.connectioncontroller.common.ConnectionOrder;
import com.facebook.controller.connectioncontroller.common.ConnectionPage;
import com.facebook.controller.connectioncontroller.common.ConnectionState;
import com.facebook.controller.connectioncontroller.common.ConnectionStore;
import com.facebook.controller.connectioncontroller.common.EmptyConnectionState;
import com.facebook.controller.connectioncontroller.common.ListViewConnectionListener;
import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.notifications.preferences.NotificationsPreferenceConstants;
import com.facebook.notifications.protocol.FetchGraphQLNotificationsParams;
import com.facebook.notifications.protocol.FetchGraphQLNotificationsParamsBuilder;
import com.facebook.notifications.protocol.FetchGraphQLNotificationsResult;
import com.facebook.notifications.protocol.FetchNotificationSeenStatesResult;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.facebook.notifications.server.FetchNotificationSeenStatesParams;
import com.facebook.notifications.subscription.NotificationSubscriptionsManager;
import com.facebook.notifications.sync.NotificationsSyncConstants.SyncSource;
import com.facebook.notifications.sync.NotificationsSyncConstants.SyncType;
import com.facebook.notifications.util.NotificationsConnectionControllerManager;
import com.facebook.notifications.util.NotificationsLikeCountHelper;
import com.facebook.notifications.util.NotificationsSeenStateMutator;
import com.facebook.notifications.util.NotificationsUtils;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.today.abtest.TodayExperimentController;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

@Singleton
/* compiled from: modules */
public class NotificationsSyncHelper {
    public static final ConcurrentMap<Long, ListenableFuture<OperationResult>> f7537a = new MapMaker().l();
    public static final ConcurrentMap<Long, ListenableFuture<OperationResult>> f7538b = new MapMaker().l();
    private static volatile NotificationsSyncHelper f7539t;
    private final Lazy<NotificationSubscriptionsManager> f7540c;
    private final AnalyticsLogger f7541d;
    public final DefaultBlueServiceOperationFactory f7542e;
    public final Clock f7543f;
    public final ListeningExecutorService f7544g;
    public final FbSharedPreferences f7545h;
    public final Lazy<GraphQLNotificationsContentProviderHelper> f7546i;
    private final NotificationsUtils f7547j;
    public final QuickPerformanceLogger f7548k;
    private final Lazy<UniqueIdForDeviceHolder> f7549l;
    public final AbstractFbErrorReporter f7550m;
    public final NotificationsLikeCountHelper f7551n;
    public final TodayExperimentController f7552o;
    public final NotificationsSeenStateMutator f7553p;
    public ConnectionState<FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel> f7554q = EmptyConnectionState.f7635a;
    public ConnectionController<FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel, Void> f7555r;
    public final ConnectionListener<FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel> f7556s = new C03731(this);

    /* compiled from: modules */
    class C03731 extends ListViewConnectionListener<FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel> {
        final /* synthetic */ NotificationsSyncHelper f7636a;

        C03731(NotificationsSyncHelper notificationsSyncHelper) {
            this.f7636a = notificationsSyncHelper;
        }

        public final void mo627a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
        }

        public final void mo630b(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
        }

        public final void mo628a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder, Throwable th) {
        }

        public final void mo629a(boolean z) {
            if (this.f7636a.f7555r != null) {
                this.f7636a.f7554q = this.f7636a.f7555r.mo644d();
            }
        }
    }

    /* compiled from: modules */
    public class C03766 implements Callable<FetchNotificationSeenStatesParams> {
        final /* synthetic */ long f7788a;
        final /* synthetic */ NotificationsSyncHelper f7789b;

        public C03766(NotificationsSyncHelper notificationsSyncHelper, long j) {
            this.f7789b = notificationsSyncHelper;
            this.f7788a = j;
        }

        public Object call() {
            Collection b;
            if (this.f7789b.f7552o.v()) {
                NotificationsSyncHelper notificationsSyncHelper = this.f7789b;
                int min = Math.min(30, notificationsSyncHelper.f7554q.mo625d());
                Builder builder = new Builder();
                for (int i = 0; i < min; i++) {
                    builder.c(((FetchNotificationsGraphQLModels$NotificationsEdgeFieldsModel) notificationsSyncHelper.f7554q.mo622a(i)).mo822k().c());
                }
                b = builder.b();
            } else {
                b = ((GraphQLNotificationsContentProviderHelper) this.f7789b.f7546i.get()).m7896a(this.f7788a);
            }
            return new FetchNotificationSeenStatesParams(b);
        }
    }

    /* compiled from: modules */
    public class C03777 implements AsyncFunction<FetchNotificationSeenStatesParams, OperationResult> {
        final /* synthetic */ String f7790a;
        final /* synthetic */ NotificationsSyncHelper f7791b;

        public C03777(NotificationsSyncHelper notificationsSyncHelper, String str) {
            this.f7791b = notificationsSyncHelper;
            this.f7790a = str;
        }

        public final ListenableFuture m8062a(Object obj) {
            FetchNotificationSeenStatesParams fetchNotificationSeenStatesParams = (FetchNotificationSeenStatesParams) obj;
            Bundle bundle = new Bundle();
            bundle.putParcelable("notificationsFetchSeenStatesParams", fetchNotificationSeenStatesParams);
            return BlueServiceOperationFactoryDetour.a(this.f7791b.f7542e, this.f7790a, bundle, -876486431).a();
        }
    }

    /* compiled from: modules */
    public class C03788 extends NotificationAsyncRequestCompletionListener {
        final /* synthetic */ NotificationsSyncHelper f7800a;

        public C03788(NotificationsSyncHelper notificationsSyncHelper, Long l, ConcurrentMap concurrentMap) {
            this.f7800a = notificationsSyncHelper;
            super(l, concurrentMap);
        }

        public /* synthetic */ void onSuccess(Object obj) {
            mo648a((OperationResult) obj);
        }

        public final void mo648a(OperationResult operationResult) {
            super.mo648a(operationResult);
            if (this.f7800a.f7552o.v()) {
                this.f7800a.f7553p.m7967b(((FetchNotificationSeenStatesResult) operationResult.h()).a.notificationSeenStatesList);
            }
        }
    }

    /* compiled from: modules */
    public class NotificationAsyncRequestCompletionListener implements FutureCallback<OperationResult> {
        private final Long f7801a;
        private final ConcurrentMap<Long, ListenableFuture<OperationResult>> f7802b;

        public /* synthetic */ void onSuccess(Object obj) {
            mo648a((OperationResult) obj);
        }

        public NotificationAsyncRequestCompletionListener(Long l) {
            this.f7801a = l;
            this.f7802b = NotificationsSyncHelper.f7537a;
        }

        public NotificationAsyncRequestCompletionListener(Long l, ConcurrentMap<Long, ListenableFuture<OperationResult>> concurrentMap) {
            this.f7801a = l;
            this.f7802b = concurrentMap;
        }

        public void mo648a(OperationResult operationResult) {
            m8066a();
        }

        public void onFailure(Throwable th) {
            m8066a();
        }

        private synchronized void m8066a() {
            this.f7802b.remove(this.f7801a);
        }
    }

    public static com.facebook.notifications.sync.NotificationsSyncHelper m7834a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7539t;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.sync.NotificationsSyncHelper.class;
        monitor-enter(r1);
        r0 = f7539t;	 Catch:{ all -> 0x003a }
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
        r0 = m7837b(r0);	 Catch:{ all -> 0x0035 }
        f7539t = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7539t;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.sync.NotificationsSyncHelper.a(com.facebook.inject.InjectorLike):com.facebook.notifications.sync.NotificationsSyncHelper");
    }

    private static NotificationsSyncHelper m7837b(InjectorLike injectorLike) {
        return new NotificationsSyncHelper(IdBasedSingletonScopeProvider.b(injectorLike, 8735), AnalyticsLoggerMethodAutoProvider.a(injectorLike), DefaultBlueServiceOperationFactory.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2820), NotificationsUtils.m7841a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 1077), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), NotificationsLikeCountHelper.m7851a(injectorLike), TodayExperimentController.a(injectorLike), NotificationsConnectionControllerManager.m7962a(injectorLike), NotificationsSeenStateMutator.m7966a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public NotificationsSyncHelper(Lazy<NotificationSubscriptionsManager> lazy, AnalyticsLogger analyticsLogger, BlueServiceOperationFactory blueServiceOperationFactory, Clock clock, ListeningExecutorService listeningExecutorService, FbSharedPreferences fbSharedPreferences, Lazy<GraphQLNotificationsContentProviderHelper> lazy2, NotificationsUtils notificationsUtils, QuickPerformanceLogger quickPerformanceLogger, Lazy<UniqueIdForDeviceHolder> lazy3, FbErrorReporter fbErrorReporter, NotificationsLikeCountHelper notificationsLikeCountHelper, TodayExperimentController todayExperimentController, NotificationsConnectionControllerManager notificationsConnectionControllerManager, NotificationsSeenStateMutator notificationsSeenStateMutator, Executor executor) {
        this.f7540c = lazy;
        this.f7541d = analyticsLogger;
        this.f7542e = blueServiceOperationFactory;
        this.f7543f = clock;
        this.f7544g = listeningExecutorService;
        this.f7545h = fbSharedPreferences;
        this.f7546i = lazy2;
        this.f7547j = notificationsUtils;
        this.f7548k = quickPerformanceLogger;
        this.f7549l = lazy3;
        this.f7550m = fbErrorReporter;
        this.f7551n = notificationsLikeCountHelper;
        this.f7552o = todayExperimentController;
        this.f7553p = notificationsSeenStateMutator;
        final NotificationsConnectionControllerManager notificationsConnectionControllerManager2 = notificationsConnectionControllerManager;
        ExecutorDetour.a(executor, new Runnable(this) {
            final /* synthetic */ NotificationsSyncHelper f7638b;

            public void run() {
                this.f7638b.f7555r = notificationsConnectionControllerManager2.m7964a();
                this.f7638b.f7555r.mo637a(this.f7638b.f7556s);
                this.f7638b.f7554q = this.f7638b.f7555r.mo644d();
            }
        }, 1322852801);
    }

    final ListenableFuture<OperationResult> m7839a(ViewerContext viewerContext, SyncType syncType, SyncSource syncSource, @Nullable CallerContext callerContext, int i, @Nullable String str) {
        final long parseLong = Long.parseLong(viewerContext.a());
        ListenableFuture<OperationResult> listenableFuture = (ListenableFuture) f7537a.get(Long.valueOf(parseLong));
        if (listenableFuture != null) {
            return listenableFuture;
        }
        final ViewerContext viewerContext2 = viewerContext;
        final SyncType syncType2 = syncType;
        final SyncSource syncSource2 = syncSource;
        final int i2 = i;
        final String str2 = str;
        final CallerContext callerContext2 = callerContext;
        ListenableFuture<OperationResult> b = Futures.b(this.f7544g.a(new Callable<FetchGraphQLNotificationsParams>(this) {
            final /* synthetic */ NotificationsSyncHelper f7808f;

            public Object call() {
                return this.f7808f.m7838a(viewerContext2, syncType2, syncSource2, i2, str2);
            }
        }), new AsyncFunction<FetchGraphQLNotificationsParams, OperationResult>(this) {
            final /* synthetic */ NotificationsSyncHelper f7822b;

            public final ListenableFuture m8072a(Object obj) {
                FetchGraphQLNotificationsParams fetchGraphQLNotificationsParams = (FetchGraphQLNotificationsParams) obj;
                if (!this.f7822b.f7552o.v()) {
                    return this.f7822b.m7840a(fetchGraphQLNotificationsParams, callerContext2);
                }
                NotificationsSyncHelper notificationsSyncHelper = this.f7822b;
                CallerContext callerContext = callerContext2;
                Bundle bundle = new Bundle();
                bundle.putParcelable("fetchGraphQLNotificationsParams", fetchGraphQLNotificationsParams);
                if (fetchGraphQLNotificationsParams.f7679f != null) {
                    bundle.putParcelable("overridden_viewer_context", fetchGraphQLNotificationsParams.f7679f);
                }
                return BlueServiceOperationFactoryDetour.a(notificationsSyncHelper.f7542e, "force_fetch_gql_notifications_from_server", bundle, callerContext, 276826379).a();
            }
        }, this.f7544g);
        if (f7537a.putIfAbsent(Long.valueOf(parseLong), b) == null) {
            final SyncType syncType3 = syncType;
            final SyncSource syncSource3 = syncSource;
            final ViewerContext viewerContext3 = viewerContext;
            final CallerContext callerContext3 = callerContext;
            final int i3 = i;
            final String str3 = str;
            Futures.a(b, new NotificationAsyncRequestCompletionListener(this, Long.valueOf(parseLong)) {
                final /* synthetic */ NotificationsSyncHelper f7830h;

                public /* synthetic */ void onSuccess(Object obj) {
                    mo648a((OperationResult) obj);
                }

                public final void mo648a(OperationResult operationResult) {
                    super.mo648a(operationResult);
                    this.f7830h.f7548k.b(SyncType.FULL == syncType3 ? 3473410 : 3473411, (short) 2);
                    NotificationsSyncHelper.m7836a(this.f7830h, syncSource3, syncType3, true);
                    PrefKey prefKey = syncType3 == SyncType.FULL ? NotificationsPreferenceConstants.f7712A : NotificationsPreferenceConstants.f7749z;
                    long a = this.f7830h.f7543f.a();
                    this.f7830h.f7545h.edit().a(prefKey, a).commit();
                    FetchGraphQLNotificationsResult fetchGraphQLNotificationsResult = (FetchGraphQLNotificationsResult) operationResult.k();
                    if (fetchGraphQLNotificationsResult != null) {
                        if (fetchGraphQLNotificationsResult.f10826a == null) {
                            this.f7830h.f7550m.a("NotificationsSyncHelper_syncNotifications", "notificationStories was null, syncType: " + syncType3 + ", syncSource: " + syncSource3 + ", syncTime: " + a);
                            return;
                        }
                        List<FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields> a2 = fetchGraphQLNotificationsResult.f10826a.m11244a();
                        if (CollectionUtil.b(a2)) {
                            for (FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields a3 : a2) {
                                NotificationsSyncHelper.m7835a(this.f7830h, a3);
                            }
                            if (this.f7830h.f7552o.v() && this.f7830h.f7555r != null) {
                                ConnectionStore connectionStore;
                                ConnectionPage connectionPage = new ConnectionPage(fetchGraphQLNotificationsResult.f10826a.m11245b(), ((FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) a2.get(0)).mo813a(), ((FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) a2.get(a2.size() - 1)).mo813a(), true, true);
                                PiecemealConnectionController piecemealConnectionController = (PiecemealConnectionController) this.f7830h.f7555r;
                                if (piecemealConnectionController.f7639a instanceof ConnectionControllerImpl) {
                                    connectionStore = ((ConnectionControllerImpl) piecemealConnectionController.f7639a).f7919j;
                                } else {
                                    connectionStore = null;
                                }
                                connectionStore.mo653a(this.f7830h.f7554q.mo623b(), ConnectionOrder.FIRST, connectionPage, fetchGraphQLNotificationsResult.clientTimeMs, true);
                            }
                        }
                        if (fetchGraphQLNotificationsResult.f10826a.pageInfo == null) {
                            this.f7830h.f7550m.a("NotificationsSyncHelper_syncNotifications", "pageInfo was null, syncType: " + syncType3 + ", syncSource: " + syncSource3 + ", syncTime: " + a);
                        } else if (fetchGraphQLNotificationsResult.f10826a.pageInfo.c()) {
                            if (fetchGraphQLNotificationsResult.f10826a.newStories == null || fetchGraphQLNotificationsResult.f10826a.newStories.isEmpty()) {
                                this.f7830h.f7550m.a("NotificationsSyncHelper_syncNotifications", "hasPreviousPage was true but newStories was empty, syncType " + syncType3 + ", syncSource: " + syncSource3 + ", syncTime: " + a);
                            } else {
                                this.f7830h.m7839a(viewerContext3, syncType3, syncSource3, callerContext3, i3, str3);
                            }
                        } else if (syncType3 == SyncType.FULL && this.f7830h.f7551n.m7854a()) {
                            this.f7830h.f7551n.m7853a(parseLong);
                        }
                    }
                }

                public void onFailure(Throwable th) {
                    this.f7830h.f7548k.b(SyncType.FULL == syncType3 ? 3473410 : 3473411, (short) 3);
                    NotificationsSyncHelper.m7836a(this.f7830h, syncSource3, syncType3, false);
                    super.onFailure(th);
                }
            }, this.f7544g);
        }
        this.f7548k.b(SyncType.FULL == syncType ? 3473410 : 3473411);
        return b;
    }

    public static void m7835a(NotificationsSyncHelper notificationsSyncHelper, FetchNotificationsGraphQLInterfaces$NotificationsEdgeFields fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields) {
        if (fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields != null) {
            GraphQLStory k = fetchNotificationsGraphQLInterfaces$NotificationsEdgeFields.mo822k();
            if (k != null && k.k() != null) {
                try {
                    JSONObject jSONObject = new JSONObject(k.k());
                    if (jSONObject.has("notif_type")) {
                        ((NotificationSubscriptionsManager) notificationsSyncHelper.f7540c.get()).a(jSONObject.get("notif_type").toString(), k);
                    }
                } catch (JSONException e) {
                    new Object[1][0] = "notif_type";
                }
            }
        }
    }

    final ListenableFuture<OperationResult> m7840a(FetchGraphQLNotificationsParams fetchGraphQLNotificationsParams, @Nullable CallerContext callerContext) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchGraphQLNotificationsParams", fetchGraphQLNotificationsParams);
        if (fetchGraphQLNotificationsParams.f7679f != null) {
            bundle.putParcelable("overridden_viewer_context", fetchGraphQLNotificationsParams.f7679f);
        }
        return BlueServiceOperationFactoryDetour.a(this.f7542e, "fetch_gql_notifications", bundle, callerContext, -1425649168).c();
    }

    final FetchGraphQLNotificationsParams m7838a(ViewerContext viewerContext, SyncType syncType, SyncSource syncSource, int i, @Nullable String str) {
        long parseLong = Long.parseLong(viewerContext.mUserId);
        FetchGraphQLNotificationsParamsBuilder fetchGraphQLNotificationsParamsBuilder = new FetchGraphQLNotificationsParamsBuilder();
        fetchGraphQLNotificationsParamsBuilder.f7654a = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
        fetchGraphQLNotificationsParamsBuilder = fetchGraphQLNotificationsParamsBuilder;
        fetchGraphQLNotificationsParamsBuilder.f7659f = viewerContext;
        FetchGraphQLNotificationsParamsBuilder fetchGraphQLNotificationsParamsBuilder2 = fetchGraphQLNotificationsParamsBuilder;
        fetchGraphQLNotificationsParamsBuilder2.f7666m = ((UniqueIdForDeviceHolderImpl) this.f7549l.get()).a();
        fetchGraphQLNotificationsParamsBuilder = fetchGraphQLNotificationsParamsBuilder2;
        fetchGraphQLNotificationsParamsBuilder.f7660g = syncSource.toString();
        fetchGraphQLNotificationsParamsBuilder = fetchGraphQLNotificationsParamsBuilder;
        fetchGraphQLNotificationsParamsBuilder.f7656c = i;
        fetchGraphQLNotificationsParamsBuilder2 = fetchGraphQLNotificationsParamsBuilder;
        if (str != null) {
            fetchGraphQLNotificationsParamsBuilder2.f7667n = true;
            fetchGraphQLNotificationsParamsBuilder2.f7668o = str;
        }
        Object obj = null;
        if (!this.f7552o.v()) {
            NotificationsUtils notificationsUtils = this.f7547j;
            notificationsUtils.f7563f.b();
            String d = ((GraphQLNotificationsContentProviderHelper) notificationsUtils.f7560c.get()).m7916d(parseLong);
        } else if (this.f7555r != null) {
            this.f7554q = this.f7555r.mo644d();
            obj = this.f7554q.mo623b().f7942b;
        }
        if (StringUtil.a(obj)) {
            fetchGraphQLNotificationsParamsBuilder2.m8034a(Lists.a(new String[]{"null"}));
        } else {
            fetchGraphQLNotificationsParamsBuilder2.f7658e = obj;
            if (syncType == SyncType.FULL) {
                fetchGraphQLNotificationsParamsBuilder2.m8034a(this.f7547j.m7843a(parseLong));
            }
        }
        return fetchGraphQLNotificationsParamsBuilder2.m8038p();
    }

    public static void m7836a(NotificationsSyncHelper notificationsSyncHelper, SyncSource syncSource, SyncType syncType, boolean z) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("notification_sync");
        honeyClientEvent.c = "notifications";
        notificationsSyncHelper.f7541d.a(honeyClientEvent.b("syncSource", syncSource.name).b("syncType", syncType.name()).a("syncSuccess", z));
    }
}
