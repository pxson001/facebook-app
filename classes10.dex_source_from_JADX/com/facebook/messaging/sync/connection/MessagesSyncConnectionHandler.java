package com.facebook.messaging.sync.connection;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.debugoverlay.DebugOverlayController;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiException;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.cache.CacheInsertThreadsHandler;
import com.facebook.messaging.cache.MessagesBroadcaster;
import com.facebook.messaging.database.threads.DbThreadProperties;
import com.facebook.messaging.debugoverlay.MessagesDebugOverlaySettingsTags;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.montage.MontageTestHelper;
import com.facebook.messaging.notify.MessagesNotificationClient;
import com.facebook.messaging.omnipicker.abtest.ExperimentsForOmniPickerAbTestModule;
import com.facebook.messaging.service.model.FetchThreadListParams;
import com.facebook.messaging.service.model.FetchThreadListParamsBuilder;
import com.facebook.messaging.service.model.FetchThreadListResult;
import com.facebook.messaging.sync.MessagesSyncDbHandler;
import com.facebook.messaging.sync.connection.MessagesSyncGroupThreadsFetcher.C06481;
import com.facebook.messaging.sync.connection.MessagesSyncMqttPublisher.C06491;
import com.facebook.messaging.sync.connection.graphql.InitialThreadListDataQuery.InitialThreadListDataQueryString;
import com.facebook.messaging.sync.connection.graphql.InitialThreadListDataQueryModels.InitialThreadListDataQueryModel;
import com.facebook.messaging.sync.connection.graphql.InitialThreadListDataQueryModels.InitialThreadListDataQueryModel.MessageThreadsModel;
import com.facebook.messaging.threads.graphql.GQLThreadQueryHelper;
import com.facebook.push.mqtt.service.response.MqttResponse;
import com.facebook.sync.analytics.FullRefreshReason;
import com.facebook.sync.analytics.MessageSyncAnalyticsLogger;
import com.facebook.sync.analytics.SyncAnalyticsLogger;
import com.facebook.sync.connection.SyncConnectionHandler;
import com.facebook.sync.connection.SyncConnectionStateManager;
import com.facebook.sync.connection.SyncConnectionStateManager.QueueKey;
import com.facebook.sync.connection.SyncErrorRecoveryHandler;
import com.facebook.sync.connection.SyncMqttPublisher.CreateQueueResult;
import com.facebook.sync.connection.SyncQueueTrackerImpl;
import com.facebook.sync.model.IrisQueueTypes;
import com.facebook.sync.util.ExponentialBackoffHelper.ExecutionResult;
import com.facebook.sync.util.ExponentialBackoffHelper.ExponentialBackoffOperation;
import com.facebook.sync.util.ExponentialBackoffHelperFactory;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.annotations.VisibleForTesting;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: prompt_height */
public class MessagesSyncConnectionHandler extends SyncConnectionHandler {
    private static final Class<?> f4286a = MessagesSyncConnectionHandler.class;
    private static final Object f4287q = new Object();
    public final MessagesSyncMqttPublisher f4288b;
    private final SyncConnectionStateManager f4289c;
    private final MessagesSyncDbHandler f4290d;
    public final Lazy<MessagesSyncThreadsFetcher> f4291e;
    private final SyncAnalyticsLogger f4292f;
    private final SyncErrorRecoveryHandler f4293g;
    private final GraphQLQueryExecutor f4294h;
    public final AbstractFbErrorReporter f4295i;
    private final Lazy<ExponentialBackoffHelperFactory> f4296j;
    public final MessageSyncAnalyticsLogger f4297k;
    public final Provider<ViewerContext> f4298l;
    private final SyncQueueTrackerImpl f4299m;
    public final ExecutorService f4300n;
    public final MontageTestHelper f4301o;
    private final MessagesSyncGroupThreadsFetcher f4302p;

    /* compiled from: prompt_height */
    class C06431 implements Runnable {
        final /* synthetic */ MessagesSyncConnectionHandler f4274a;

        C06431(MessagesSyncConnectionHandler messagesSyncConnectionHandler) {
            this.f4274a = messagesSyncConnectionHandler;
        }

        public void run() {
            this.f4274a.e();
        }
    }

    /* compiled from: prompt_height */
    class GraphQLSequenceIdResult {
        public final long f4284a;
        public final int f4285b;

        public GraphQLSequenceIdResult(long j, int i) {
            this.f4284a = j;
            this.f4285b = i;
        }
    }

    private static MessagesSyncConnectionHandler m3907b(InjectorLike injectorLike) {
        return new MessagesSyncConnectionHandler(DebugOverlayController.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), ExponentialBackoffHelperFactory.a(injectorLike), (ScheduledExecutorService) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(injectorLike), MessagesSyncMqttPublisher.m3923a(injectorLike), SyncConnectionStateManager.a(injectorLike), MessagesSyncDbHandler.m3882a(injectorLike), IdBasedLazy.a(injectorLike, 8496), SyncAnalyticsLogger.a(injectorLike), SyncErrorRecoveryHandler.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 11065), MessageSyncAnalyticsLogger.a(injectorLike), IdBasedProvider.a(injectorLike, 372), SyncQueueTrackerImpl.a(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4345), MontageTestHelper.a(injectorLike), MessagesSyncGroupThreadsFetcher.m3914a(injectorLike));
    }

    private GraphQLSequenceIdResult m3910g() {
        GraphQLRequest a = GraphQLRequest.a(new InitialThreadListDataQueryString());
        a.s = (ViewerContext) this.f4298l.get();
        MessageThreadsModel a2 = ((InitialThreadListDataQueryModel) ((GraphQLResult) FutureDetour.a(this.f4294h.a(a), -284553055)).e).m3957a();
        return new GraphQLSequenceIdResult(Long.parseLong(a2.m3953b()), a2.m3949a());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.connection.MessagesSyncConnectionHandler m3905a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f4287q;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m3907b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4287q;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.connection.MessagesSyncConnectionHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.connection.MessagesSyncConnectionHandler) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f4287q;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.connection.MessagesSyncConnectionHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.connection.MessagesSyncConnectionHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.connection.MessagesSyncConnectionHandler");
    }

    @Inject
    public MessagesSyncConnectionHandler(DebugOverlayController debugOverlayController, Clock clock, ExponentialBackoffHelperFactory exponentialBackoffHelperFactory, ScheduledExecutorService scheduledExecutorService, MessagesSyncMqttPublisher messagesSyncMqttPublisher, SyncConnectionStateManager syncConnectionStateManager, MessagesSyncDbHandler messagesSyncDbHandler, Lazy<MessagesSyncThreadsFetcher> lazy, SyncAnalyticsLogger syncAnalyticsLogger, SyncErrorRecoveryHandler syncErrorRecoveryHandler, GraphQLQueryExecutor graphQLQueryExecutor, FbErrorReporter fbErrorReporter, Lazy<ExponentialBackoffHelperFactory> lazy2, MessageSyncAnalyticsLogger messageSyncAnalyticsLogger, Provider<ViewerContext> provider, SyncQueueTrackerImpl syncQueueTrackerImpl, ExecutorService executorService, Provider<Boolean> provider2, MontageTestHelper montageTestHelper, MessagesSyncGroupThreadsFetcher messagesSyncGroupThreadsFetcher) {
        super(syncErrorRecoveryHandler, messagesSyncMqttPublisher, syncConnectionStateManager, syncAnalyticsLogger, debugOverlayController, clock, exponentialBackoffHelperFactory, scheduledExecutorService, ((ViewerContext) provider.get()).a(), messagesSyncDbHandler, provider2);
        this.f4288b = messagesSyncMqttPublisher;
        this.f4289c = syncConnectionStateManager;
        this.f4290d = messagesSyncDbHandler;
        this.f4291e = lazy;
        this.f4292f = syncAnalyticsLogger;
        this.f4293g = syncErrorRecoveryHandler;
        this.f4294h = graphQLQueryExecutor;
        this.f4295i = fbErrorReporter;
        this.f4296j = lazy2;
        this.f4297k = messageSyncAnalyticsLogger;
        this.f4298l = provider;
        this.f4299m = syncQueueTrackerImpl;
        this.f4300n = executorService;
        this.f4301o = montageTestHelper;
        this.f4302p = messagesSyncGroupThreadsFetcher;
        m3909f();
    }

    private void m3909f() {
        this.f4299m.a(b(), this);
        ExecutorDetour.a(this.f4300n, new C06431(this), 406817813);
    }

    public final void m3913e() {
        if (!this.f4299m.d() && this.f4288b.a(this.f4299m)) {
            this.f4299m.c();
        }
    }

    public final OperationResult m3912a(FullRefreshReason fullRefreshReason, @Nullable final CallerContext callerContext) {
        this.f4292f.a(IrisQueueTypes.MESSAGES_QUEUE_TYPE, fullRefreshReason);
        this.f4299m.a(b());
        String str = ((ViewerContext) this.f4298l.get()).mUserId;
        Long d = m3908d(callerContext);
        if (d == null) {
            String str2 = "Failed to fetch initial sequence id from the server.  viewerContextUserId = " + str;
            BLog.a(f4286a, str2);
            return OperationResult.a(ErrorCode.API_ERROR, str2);
        }
        MqttResponse a = m3906a(d.longValue(), str);
        if (a.a) {
            this.f4290d.f4264b.b(DbThreadProperties.i, ((CreateQueueResult) a.b).b);
            this.f4290d.m3888a(d.longValue());
            this.f4293g.d(this.f4290d);
            this.f4289c.a(QueueKey.a(str, IrisQueueTypes.MESSAGES_QUEUE_TYPE), a.e);
            this.f4299m.a(b(), this);
            if (this.f4301o.b()) {
                ExecutorDetour.a(this.f4300n, new Runnable(this) {
                    final /* synthetic */ MessagesSyncConnectionHandler f4276b;

                    public void run() {
                        try {
                            ((MessagesSyncThreadsFetcher) this.f4276b.f4291e.get()).m3944b(callerContext);
                        } catch (Exception e) {
                            this.f4276b.f4295i.a("messages_sync_montage_fetch_error", "Montage threads fetch failed");
                        }
                    }
                }, 779900384);
            }
            ExecutorDetour.a(this.f4300n, new Runnable(this) {
                final /* synthetic */ MessagesSyncConnectionHandler f4278b;

                public void run() {
                    try {
                        ((MessagesSyncThreadsFetcher) this.f4278b.f4291e.get()).m3945c(callerContext);
                    } catch (Exception e) {
                        this.f4278b.f4295i.a("messages_sync_message_requests_fetch_error", "Message requests fetch failed");
                    }
                }
            }, -276033821);
            MessagesSyncGroupThreadsFetcher messagesSyncGroupThreadsFetcher = this.f4302p;
            if (messagesSyncGroupThreadsFetcher.f4313g.a(246, false)) {
                ExecutorDetour.a(messagesSyncGroupThreadsFetcher.f4308b, new C06481(messagesSyncGroupThreadsFetcher, callerContext, messagesSyncGroupThreadsFetcher.f4307a.a(ExperimentsForOmniPickerAbTestModule.f3415b, 20)), 900485383);
            }
            return OperationResult.a;
        }
        BLog.a(f4286a, "Failed to create queue with sequenceId %d, viewerContextUserId = %s", new Object[]{d, str});
        return a.a();
    }

    @VisibleForTesting
    private MqttResponse<CreateQueueResult> m3906a(final long j, final String str) {
        return (MqttResponse) ((ExponentialBackoffHelperFactory) this.f4296j.get()).a(300000, 250, new ExponentialBackoffOperation<MqttResponse<CreateQueueResult>>(this) {
            final /* synthetic */ MessagesSyncConnectionHandler f4281c;

            public final ExecutionResult<MqttResponse<CreateQueueResult>> m3901a() {
                MessagesSyncMqttPublisher messagesSyncMqttPublisher = this.f4281c.f4288b;
                long j = j;
                String str = str;
                Long.valueOf(j);
                C06491 c06491 = new C06491(messagesSyncMqttPublisher);
                MqttResponse a = messagesSyncMqttPublisher.a(((Integer) messagesSyncMqttPublisher.f4323e.get()).intValue(), j, messagesSyncMqttPublisher.f4321c.a("/t_ms", c06491), str);
                if (a.a && ((CreateQueueResult) a.b).a) {
                    return new ExecutionResult(false, a);
                }
                return new ExecutionResult(true, a);
            }

            public final void m3902a(long j) {
                MessageSyncAnalyticsLogger messageSyncAnalyticsLogger = this.f4281c.f4297k;
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent("sync_create_queue_error");
                honeyClientEvent.a("backOffAmount", j);
                messageSyncAnalyticsLogger.a.a(honeyClientEvent, IrisQueueTypes.MESSAGES_QUEUE_TYPE);
            }
        }).a();
    }

    @Nullable
    @VisibleForTesting
    private Long m3908d(final CallerContext callerContext) {
        return (Long) ((ExponentialBackoffHelperFactory) this.f4296j.get()).a(300000, 250, new ExponentialBackoffOperation<Long>(this) {
            final /* synthetic */ MessagesSyncConnectionHandler f4283b;

            public final ExecutionResult<Long> m3903a() {
                long a;
                long j = -1;
                try {
                    a = this.f4283b.m3911a(callerContext);
                } catch (ApiException e) {
                    a = j;
                }
                if (a >= 0) {
                    return new ExecutionResult(false, Long.valueOf(a));
                }
                return new ExecutionResult(true, null);
            }

            public final void m3904a(long j) {
                this.f4283b.f4295i.a("messages_sync_initial_fetch_error", "Failed to do initial fetch, backing off by " + j + " ms. viewerContextUserId=" + ((ViewerContext) this.f4283b.f4298l.get()).mUserId);
            }
        }).a();
    }

    @VisibleForTesting
    final long m3911a(CallerContext callerContext) {
        int i = 1;
        int i2 = 250;
        while (i <= 3) {
            FetchThreadListResult b;
            MessagesSyncThreadsFetcher messagesSyncThreadsFetcher = (MessagesSyncThreadsFetcher) this.f4291e.get();
            messagesSyncThreadsFetcher.f4334e.a(MessagesDebugOverlaySettingsTags.a, "fetchThreadList (Sync)");
            FetchThreadListParamsBuilder newBuilder = FetchThreadListParams.newBuilder();
            newBuilder.a = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
            newBuilder = newBuilder;
            newBuilder.b = FolderName.INBOX;
            newBuilder = newBuilder;
            newBuilder.g = RequestPriority.INTERACTIVE;
            FetchThreadListParams h = newBuilder.h();
            if (((Boolean) messagesSyncThreadsFetcher.f4342m.get()).booleanValue()) {
                b = ((GQLThreadQueryHelper) messagesSyncThreadsFetcher.f4344o.get()).b(h, callerContext);
            } else {
                b = (FetchThreadListResult) ((ApiMethodRunnerImpl) messagesSyncThreadsFetcher.f4330a.get()).a((ApiMethod) messagesSyncThreadsFetcher.f4331b.get(), h, null, callerContext);
            }
            messagesSyncThreadsFetcher.f4335f.a(b);
            ((CacheInsertThreadsHandler) messagesSyncThreadsFetcher.f4343n.get()).a();
            ((CacheInsertThreadsHandler) messagesSyncThreadsFetcher.f4343n.get()).a(b);
            ((MessagesBroadcaster) messagesSyncThreadsFetcher.f4337h.get()).a();
            ((MessagesNotificationClient) messagesSyncThreadsFetcher.f4338i.get()).a(b.g);
            messagesSyncThreadsFetcher.f4341l.a(b.c.c, "FETCH_THREAD_LIST");
            FetchThreadListResult fetchThreadListResult = b;
            long j = fetchThreadListResult.k;
            if (fetchThreadListResult.c.e() > 0) {
                return j;
            }
            GraphQLSequenceIdResult g = m3910g();
            if (g.f4285b == 0) {
                return g.f4284a;
            }
            MessageSyncAnalyticsLogger messageSyncAnalyticsLogger = this.f4297k;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("sync_sequence_id_difference");
            honeyClientEvent.a("attemptNumber", i);
            messageSyncAnalyticsLogger.a.a(honeyClientEvent, IrisQueueTypes.MESSAGES_QUEUE_TYPE);
            Thread.sleep((long) i2);
            short s = (short) (((short) (i + 1)) + 1);
            i2 *= 2;
        }
        return -1;
    }
}
