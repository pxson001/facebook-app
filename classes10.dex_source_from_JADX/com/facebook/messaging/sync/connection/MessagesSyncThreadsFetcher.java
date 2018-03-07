package com.facebook.messaging.sync.connection;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.debug.debugoverlay.DebugOverlayController;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiMethodRunner;
import com.facebook.http.protocol.ApiMethodRunner.Batch;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.cache.CacheInsertThreadsHandler;
import com.facebook.messaging.cache.FacebookMessages;
import com.facebook.messaging.cache.MessagesBroadcaster;
import com.facebook.messaging.database.handlers.DbInsertThreadsHandler;
import com.facebook.messaging.debugoverlay.MessagesDebugOverlaySettingsTags;
import com.facebook.messaging.deliveryreceipt.DefaultSendDeliveryReceiptManager;
import com.facebook.messaging.deliveryreceipt.SendDeliveryReceiptManager;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadCriteria;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.notify.MessagesNotificationClient;
import com.facebook.messaging.service.methods.FetchMessageMethod;
import com.facebook.messaging.service.methods.FetchThreadListMethod;
import com.facebook.messaging.service.methods.FetchThreadMethod;
import com.facebook.messaging.service.model.FetchMessageParams;
import com.facebook.messaging.service.model.FetchMessageResult;
import com.facebook.messaging.service.model.FetchThreadListParams;
import com.facebook.messaging.service.model.FetchThreadListParamsBuilder;
import com.facebook.messaging.service.model.FetchThreadListResult;
import com.facebook.messaging.service.model.FetchThreadParams;
import com.facebook.messaging.service.model.FetchThreadParamsBuilder;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.messaging.service.model.NewMessageResult;
import com.facebook.messaging.sync.delta.DeltaUiChangesCache;
import com.facebook.messaging.sync.delta.NewMessageHandlerHelper;
import com.facebook.messaging.threads.graphql.GQLThreadQueryHelper;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: promo_code */
public class MessagesSyncThreadsFetcher {
    private static final Object f4329p = new Object();
    public final Lazy<ApiMethodRunner> f4330a;
    public final Lazy<FetchThreadListMethod> f4331b;
    private final Lazy<FetchThreadMethod> f4332c;
    private final Lazy<FetchMessageMethod> f4333d;
    public final DebugOverlayController f4334e;
    public final DbInsertThreadsHandler f4335f;
    private final Lazy<NewMessageHandlerHelper> f4336g;
    public final Lazy<MessagesBroadcaster> f4337h;
    public final Lazy<MessagesNotificationClient> f4338i;
    private final DeltaUiChangesCache f4339j;
    private final Clock f4340k;
    public final DefaultSendDeliveryReceiptManager f4341l;
    public final Provider<Boolean> f4342m;
    @Inject
    @com.facebook.ultralight.Lazy
    @FacebookMessages
    public Lazy<CacheInsertThreadsHandler> f4343n = UltralightRuntime.b;
    @Inject
    @com.facebook.ultralight.Lazy
    public Lazy<GQLThreadQueryHelper> f4344o = UltralightRuntime.b();

    /* compiled from: promo_code */
    public class FetchThreadsAndMessagesResult {
        public final ImmutableMap<ThreadKey, ThreadSummary> f4327a;
        public final ImmutableSet<ThreadKey> f4328b;

        public FetchThreadsAndMessagesResult(ImmutableMap<ThreadKey, ThreadSummary> immutableMap, ImmutableSet<ThreadKey> immutableSet) {
            this.f4327a = immutableMap;
            this.f4328b = immutableSet;
        }
    }

    private static MessagesSyncThreadsFetcher m3942b(InjectorLike injectorLike) {
        MessagesSyncThreadsFetcher messagesSyncThreadsFetcher = new MessagesSyncThreadsFetcher(IdBasedSingletonScopeProvider.b(injectorLike, 2279), IdBasedLazy.a(injectorLike, 8383), IdBasedLazy.a(injectorLike, 8384), IdBasedLazy.a(injectorLike, 8376), DebugOverlayController.a(injectorLike), DbInsertThreadsHandler.a(injectorLike), IdBasedLazy.a(injectorLike, 8502), IdBasedSingletonScopeProvider.b(injectorLike, 2568), IdBasedLazy.a(injectorLike, 8006), DeltaUiChangesCache.m3961a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4209), DefaultSendDeliveryReceiptManager.b(injectorLike));
        Lazy a = IdBasedLazy.a(injectorLike, 7693);
        Lazy a2 = IdBasedLazy.a(injectorLike, 8547);
        messagesSyncThreadsFetcher.f4343n = a;
        messagesSyncThreadsFetcher.f4344o = a2;
        return messagesSyncThreadsFetcher;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.connection.MessagesSyncThreadsFetcher m3933a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f4329p;	 Catch:{ all -> 0x006c }
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
        r1 = m3942b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4329p;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.connection.MessagesSyncThreadsFetcher) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.connection.MessagesSyncThreadsFetcher) r0;	 Catch:{  }
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
        r0 = f4329p;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.connection.MessagesSyncThreadsFetcher) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.connection.MessagesSyncThreadsFetcher.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.connection.MessagesSyncThreadsFetcher");
    }

    @Inject
    public MessagesSyncThreadsFetcher(Lazy<ApiMethodRunner> lazy, Lazy<FetchThreadListMethod> lazy2, Lazy<FetchThreadMethod> lazy3, Lazy<FetchMessageMethod> lazy4, DebugOverlayController debugOverlayController, DbInsertThreadsHandler dbInsertThreadsHandler, Lazy<NewMessageHandlerHelper> lazy5, Lazy<MessagesBroadcaster> lazy6, Lazy<MessagesNotificationClient> lazy7, DeltaUiChangesCache deltaUiChangesCache, Clock clock, Provider<Boolean> provider, SendDeliveryReceiptManager sendDeliveryReceiptManager) {
        this.f4330a = lazy;
        this.f4331b = lazy2;
        this.f4332c = lazy3;
        this.f4333d = lazy4;
        this.f4334e = debugOverlayController;
        this.f4335f = dbInsertThreadsHandler;
        this.f4336g = lazy5;
        this.f4337h = lazy6;
        this.f4338i = lazy7;
        this.f4339j = deltaUiChangesCache;
        this.f4340k = clock;
        this.f4341l = sendDeliveryReceiptManager;
        this.f4342m = provider;
    }

    final FetchThreadListResult m3944b(CallerContext callerContext) {
        FetchThreadListParamsBuilder newBuilder = FetchThreadListParams.newBuilder();
        newBuilder.a = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
        FetchThreadListResult c = ((GQLThreadQueryHelper) this.f4344o.get()).c(newBuilder.h(), callerContext);
        this.f4335f.b(c);
        ((CacheInsertThreadsHandler) this.f4343n.get()).a(c);
        return c;
    }

    final FetchThreadListResult m3945c(CallerContext callerContext) {
        this.f4334e.a(MessagesDebugOverlaySettingsTags.a, "fetchThreadList - Message Requests");
        FetchThreadListParamsBuilder newBuilder = FetchThreadListParams.newBuilder();
        newBuilder.a = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
        newBuilder = newBuilder;
        newBuilder.b = FolderName.PENDING;
        FetchThreadListResult b = ((GQLThreadQueryHelper) this.f4344o.get()).b(newBuilder.h(), callerContext);
        this.f4335f.b(b);
        ((CacheInsertThreadsHandler) this.f4343n.get()).a(b);
        return b;
    }

    public final FetchThreadsAndMessagesResult m3943a(Set<ThreadKey> set, Set<FetchMessageParams> set2, long j) {
        if (((Boolean) this.f4342m.get()).booleanValue()) {
            try {
                return m3941b(set, set2, j);
            } catch (Throwable e) {
                BLog.b("MessagesSyncThreadsFetcher", "Failed graphql query fetch: ", e);
                throw e;
            }
        }
        this.f4334e.a(MessagesDebugOverlaySettingsTags.a, m3934a((Set) set, (Set) set2));
        Batch a = ((ApiMethodRunnerImpl) this.f4330a.get()).a();
        for (ThreadKey a2 : set) {
            m3935a(a, a2);
        }
        for (FetchMessageParams a3 : set2) {
            m3936a(a, a3);
        }
        a.a("fetchThreadsForSync", CallerContext.a(getClass()));
        Builder builder = ImmutableMap.builder();
        ImmutableSet.Builder builder2 = ImmutableSet.builder();
        for (ThreadKey a22 : set) {
            ThreadSummary b = m3940b(a, a22);
            if (b != null) {
                builder.b(a22, b);
            } else {
                builder2.c(a22);
            }
            this.f4339j.m3964a(a22);
        }
        for (FetchMessageParams a32 : set2) {
            m3937a(a, a32, j);
        }
        return new FetchThreadsAndMessagesResult(builder.b(), builder2.b());
    }

    private FetchThreadsAndMessagesResult m3941b(Set<ThreadKey> set, Set<FetchMessageParams> set2, long j) {
        CallerContext b = CallerContext.b(getClass(), "fetchThreadsAndMessages");
        this.f4334e.a(MessagesDebugOverlaySettingsTags.a, m3934a((Set) set, (Set) set2));
        ImmutableSet.Builder builder = ImmutableSet.builder();
        Builder builder2 = ImmutableMap.builder();
        if (!set.isEmpty()) {
            ImmutableMap a = ((GQLThreadQueryHelper) this.f4344o.get()).a(set, 20, b, true);
            for (ThreadKey threadKey : set) {
                FetchThreadResult fetchThreadResult = (FetchThreadResult) a.get(threadKey);
                m3938a(threadKey, fetchThreadResult);
                if (fetchThreadResult == null || fetchThreadResult.c == null) {
                    builder.c(threadKey);
                } else {
                    builder2.b(threadKey, fetchThreadResult.c);
                    this.f4339j.m3964a(threadKey);
                }
            }
        }
        if (!set2.isEmpty()) {
            ImmutableMap a2 = ((GQLThreadQueryHelper) this.f4344o.get()).a(set2, b);
            for (FetchMessageParams fetchMessageParams : set2) {
                FetchMessageResult fetchMessageResult = (FetchMessageResult) a2.get(fetchMessageParams.a);
                if (fetchMessageResult != null) {
                    m3939a(fetchMessageResult, j);
                }
            }
        }
        return new FetchThreadsAndMessagesResult(builder2.b(), builder.b());
    }

    private static String m3934a(Set<ThreadKey> set, Set<FetchMessageParams> set2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fetch (sync); ");
        if (!set.isEmpty()) {
            stringBuilder.append("threads ").append(set).append(";");
        }
        if (!set2.isEmpty()) {
            stringBuilder.append("messages ").append(set2);
        }
        return stringBuilder.toString();
    }

    private void m3935a(Batch batch, ThreadKey threadKey) {
        FetchThreadParamsBuilder newBuilder = FetchThreadParams.newBuilder();
        newBuilder.b = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
        newBuilder = newBuilder;
        newBuilder.f = 20;
        newBuilder = newBuilder;
        newBuilder.a = ThreadCriteria.a(threadKey);
        BatchOperation.Builder a = BatchOperation.a((ApiMethod) this.f4332c.get(), newBuilder.i());
        a.c = "fetchThread-" + threadKey.g();
        batch.a(a.a());
    }

    private ThreadSummary m3940b(Batch batch, ThreadKey threadKey) {
        FetchThreadResult fetchThreadResult = (FetchThreadResult) batch.a("fetchThread-" + threadKey.g());
        this.f4335f.a(threadKey);
        ((CacheInsertThreadsHandler) this.f4343n.get()).b(FolderName.INBOX, threadKey);
        if (fetchThreadResult.c == null) {
            return null;
        }
        this.f4335f.a(FetchThreadResult.a, fetchThreadResult);
        ((CacheInsertThreadsHandler) this.f4343n.get()).a(20, fetchThreadResult);
        this.f4341l.a(ImmutableList.of(fetchThreadResult.c), "FETCH_THREAD");
        return fetchThreadResult.c;
    }

    private void m3938a(ThreadKey threadKey, FetchThreadResult fetchThreadResult) {
        this.f4335f.a(threadKey);
        ((CacheInsertThreadsHandler) this.f4343n.get()).b(FolderName.INBOX, threadKey);
        if (fetchThreadResult != null) {
            this.f4335f.a(FetchThreadResult.a, fetchThreadResult);
            ((CacheInsertThreadsHandler) this.f4343n.get()).a(20, fetchThreadResult);
            this.f4341l.a(ImmutableList.of(fetchThreadResult.c), "FETCH_THREAD");
        }
    }

    private void m3936a(Batch batch, FetchMessageParams fetchMessageParams) {
        BatchOperation.Builder a = BatchOperation.a((ApiMethod) this.f4333d.get(), fetchMessageParams);
        a.c = "fetchMessage-" + fetchMessageParams.a;
        batch.a(a.a());
    }

    private void m3937a(Batch batch, FetchMessageParams fetchMessageParams, long j) {
        ThreadSummary threadSummary = null;
        ((NewMessageHandlerHelper) this.f4336g.get()).m3993a(this.f4335f.a(new NewMessageResult(DataFreshnessResult.FROM_SERVER, ((FetchMessageResult) batch.a("fetchMessage-" + fetchMessageParams.a)).a, null, threadSummary, this.f4340k.a()), j), j, TriState.UNSET);
    }

    private void m3939a(FetchMessageResult fetchMessageResult, long j) {
        ((NewMessageHandlerHelper) this.f4336g.get()).m3993a(this.f4335f.a(new NewMessageResult(DataFreshnessResult.FROM_SERVER, fetchMessageResult.a, null, null, this.f4340k.a()), j), j, TriState.UNSET);
    }
}
