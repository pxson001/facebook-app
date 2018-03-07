package com.facebook.messaging.send.service;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbtrace.FbTraceEvent;
import com.facebook.fbtrace.FbTraceEventAnnotations;
import com.facebook.fbtrace.FbTraceEventAnnotationsUtil;
import com.facebook.fbtrace.FbTraceNode;
import com.facebook.fbtrace.FbTracer;
import com.facebook.http.protocol.ApiException;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiMethodRunner;
import com.facebook.http.protocol.ApiMethodRunner.Batch;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.messageclassifier.MessageClassifier;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.Message.SendChannel;
import com.facebook.messaging.model.messages.MessageBuilder;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.payment.SentPayment;
import com.facebook.messaging.model.send.PendingSendQueueKey;
import com.facebook.messaging.model.share.SentShareAttachment.Type;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadCriteria;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.cache.PaymentTransactionCache;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.protocol.transactions.SendPaymentMessageMethod;
import com.facebook.messaging.payment.service.model.transactions.SendPaymentMessageParams;
import com.facebook.messaging.payment.service.model.transactions.SendPaymentMessageParamsBuilder;
import com.facebook.messaging.payment.service.model.transactions.SendPaymentMessageResult;
import com.facebook.messaging.payment.utils.PaymentRiskFlowHelper;
import com.facebook.messaging.requestrouting.RequestRoutingHelper;
import com.facebook.messaging.send.common.SendMessageException;
import com.facebook.messaging.service.methods.CreateThreadMethod;
import com.facebook.messaging.service.methods.FetchMessageGQLMethod;
import com.facebook.messaging.service.methods.FetchMessageMethod;
import com.facebook.messaging.service.methods.FetchMoreMessagesGQLMethod;
import com.facebook.messaging.service.methods.FetchMoreMessagesMethod;
import com.facebook.messaging.service.methods.FetchThreadGQLMethod;
import com.facebook.messaging.service.methods.FetchThreadMethod;
import com.facebook.messaging.service.methods.MessagingServiceGatekeeper;
import com.facebook.messaging.service.methods.SendMessageMethod;
import com.facebook.messaging.service.methods.SendMessageToPendingThreadMethod;
import com.facebook.messaging.service.model.FetchMessageParams;
import com.facebook.messaging.service.model.FetchMessageResult;
import com.facebook.messaging.service.model.FetchMoreMessagesParams;
import com.facebook.messaging.service.model.FetchMoreMessagesResult;
import com.facebook.messaging.service.model.FetchThreadParamsBuilder;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.messaging.service.model.NewMessageResult;
import com.facebook.messaging.service.model.SendMessageByRecipientsParams;
import com.facebook.messaging.service.model.SendMessageParams;
import com.facebook.messaging.service.model.SendMessageToPendingThreadParams;
import com.facebook.messaging.service.model.SendMessageToPendingThreadResult;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import org.apache.http.message.BasicHeader;

@UserScoped
/* compiled from: recently_used_stickers */
public class SendViaGraphHandler {
    private static final Object f3929u = new Object();
    private final ApiMethodRunnerImpl f3930a;
    private final SendMessageMethod f3931b;
    private final Lazy<SendMessageToPendingThreadMethod> f3932c;
    private final SendPaymentMessageMethod f3933d;
    private final CreateThreadMethod f3934e;
    private final FetchMessageMethod f3935f;
    private final FetchMessageGQLMethod f3936g;
    private final FetchMoreMessagesMethod f3937h;
    private final FetchMoreMessagesGQLMethod f3938i;
    private final FetchThreadMethod f3939j;
    private final SendMessageExceptionHelper f3940k;
    private final Lazy<AnalyticsLogger> f3941l;
    private final Clock f3942m;
    private final FbTracer f3943n;
    private final Provider<Boolean> f3944o;
    private final Lazy<PaymentTransactionCache> f3945p;
    private final RequestRoutingHelper f3946q;
    private final MessageClassifier f3947r;
    private final Lazy<FetchThreadGQLMethod> f3948s;
    private final Lazy<MessagingServiceGatekeeper> f3949t;

    private static SendViaGraphHandler m3687b(InjectorLike injectorLike) {
        return new SendViaGraphHandler(ApiMethodRunnerImpl.a(injectorLike), SendMessageMethod.a(injectorLike), IdBasedLazy.a(injectorLike, 8411), SendPaymentMessageMethod.a(injectorLike), CreateThreadMethod.a(injectorLike), FetchMessageMethod.a(injectorLike), FetchMessageGQLMethod.a(injectorLike), FetchMoreMessagesMethod.a(injectorLike), FetchMoreMessagesGQLMethod.a(injectorLike), FetchThreadMethod.a(injectorLike), SendMessageExceptionHelper.m3648a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 175), (Clock) SystemClockMethodAutoProvider.a(injectorLike), FbTracer.a(injectorLike), IdBasedProvider.a(injectorLike, 4206), IdBasedLazy.a(injectorLike, 8016), RequestRoutingHelper.a(injectorLike), MessageClassifier.a(injectorLike), IdBasedLazy.a(injectorLike, 8382), IdBasedLazy.a(injectorLike, 8394));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.send.service.SendViaGraphHandler m3682a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f3929u;	 Catch:{ all -> 0x006c }
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
        r1 = m3687b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f3929u;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.send.service.SendViaGraphHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.send.service.SendViaGraphHandler) r0;	 Catch:{  }
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
        r0 = f3929u;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.send.service.SendViaGraphHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.send.service.SendViaGraphHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.send.service.SendViaGraphHandler");
    }

    @Inject
    public SendViaGraphHandler(ApiMethodRunner apiMethodRunner, SendMessageMethod sendMessageMethod, Lazy<SendMessageToPendingThreadMethod> lazy, SendPaymentMessageMethod sendPaymentMessageMethod, CreateThreadMethod createThreadMethod, FetchMessageMethod fetchMessageMethod, FetchMessageGQLMethod fetchMessageGQLMethod, FetchMoreMessagesMethod fetchMoreMessagesMethod, FetchMoreMessagesGQLMethod fetchMoreMessagesGQLMethod, FetchThreadMethod fetchThreadMethod, SendMessageExceptionHelper sendMessageExceptionHelper, Lazy<AnalyticsLogger> lazy2, Clock clock, FbTracer fbTracer, Provider<Boolean> provider, Lazy<PaymentTransactionCache> lazy3, RequestRoutingHelper requestRoutingHelper, MessageClassifier messageClassifier, Lazy<FetchThreadGQLMethod> lazy4, Lazy<MessagingServiceGatekeeper> lazy5) {
        this.f3930a = apiMethodRunner;
        this.f3931b = sendMessageMethod;
        this.f3932c = lazy;
        this.f3933d = sendPaymentMessageMethod;
        this.f3934e = createThreadMethod;
        this.f3935f = fetchMessageMethod;
        this.f3936g = fetchMessageGQLMethod;
        this.f3937h = fetchMoreMessagesMethod;
        this.f3938i = fetchMoreMessagesGQLMethod;
        this.f3939j = fetchThreadMethod;
        this.f3940k = sendMessageExceptionHelper;
        this.f3941l = lazy2;
        this.f3942m = clock;
        this.f3943n = fbTracer;
        this.f3944o = provider;
        this.f3945p = lazy3;
        this.f3946q = requestRoutingHelper;
        this.f3947r = messageClassifier;
        this.f3948s = lazy4;
        this.f3949t = lazy5;
    }

    public final NewMessageResult m3691a(SendMessageParams sendMessageParams) {
        Message message = sendMessageParams.a;
        if (message.u == null || message.u.a != Type.PAYMENT) {
            return m3689c(sendMessageParams);
        }
        return m3688b(sendMessageParams);
    }

    public final NewMessageResult m3692a(SendMessageToPendingThreadParams sendMessageToPendingThreadParams) {
        Message message = sendMessageToPendingThreadParams.a;
        Preconditions.checkArgument(message != null);
        Preconditions.checkArgument(ThreadKey.f(message.b));
        FbTraceNode a = FbTracer.a(sendMessageToPendingThreadParams.c);
        FbTraceEventAnnotations a2 = FbTraceEventAnnotationsUtil.a(a);
        a2.put("op", "send_to_pending_thread");
        this.f3943n.a(a, FbTraceEvent.REQUEST_SEND, a2);
        ApiMethodRunnerParams apiMethodRunnerParams = new ApiMethodRunnerParams();
        apiMethodRunnerParams.h = a;
        SendMessageToPendingThreadResult sendMessageToPendingThreadResult = (SendMessageToPendingThreadResult) this.f3930a.a((ApiMethod) this.f3932c.get(), sendMessageToPendingThreadParams, apiMethodRunnerParams);
        this.f3943n.a(a, FbTraceEvent.RESPONSE_RECEIVE, null);
        MessageBuilder a3 = Message.newBuilder().a(message);
        a3.b = sendMessageToPendingThreadResult.a;
        a3 = a3;
        a3.A = new PendingSendQueueKey(sendMessageToPendingThreadResult.a, message.A.b);
        return new NewMessageResult(DataFreshnessResult.FROM_CACHE_UP_TO_DATE, m3681a(a3.R()), null, null, this.f3942m.a());
    }

    private NewMessageResult m3688b(SendMessageParams sendMessageParams) {
        SendPaymentMessageParams b = m3686b(sendMessageParams.a);
        try {
            FbTraceNode a = FbTracer.a(sendMessageParams.c);
            FbTraceEventAnnotations a2 = FbTraceEventAnnotationsUtil.a(a);
            a2.put("op", "send_payment_message_via_graph");
            this.f3943n.a(a, FbTraceEvent.REQUEST_SEND, a2);
            ApiMethodRunnerParams apiMethodRunnerParams = new ApiMethodRunnerParams();
            apiMethodRunnerParams.a(a);
            SendPaymentMessageResult sendPaymentMessageResult = (SendPaymentMessageResult) this.f3930a.a(this.f3933d, b, apiMethodRunnerParams);
            ((AnalyticsLogger) this.f3941l.get()).a(P2pPaymentsLogEvent.d("p2p_send_success", b.k.analyticsModule).o(sendMessageParams.a.u.c.d).c(sendMessageParams.a.n).a());
            this.f3943n.a(a, FbTraceEvent.RESPONSE_RECEIVE, null);
            if (!PaymentRiskFlowHelper.a(sendPaymentMessageResult)) {
                return new NewMessageResult(DataFreshnessResult.FROM_CACHE_UP_TO_DATE, m3681a(sendMessageParams.a), null, null, this.f3942m.a());
            }
            throw this.f3940k.m3652a(sendMessageParams.a, sendPaymentMessageResult.d(), sendPaymentMessageResult.b(), SendChannel.GRAPH);
        } catch (SendMessageException e) {
            throw e;
        } catch (ApiException e2) {
            SendMessageException a3 = this.f3940k.m3651a(e2, sendMessageParams.a, m3683a(sendMessageParams.a.n), SendChannel.GRAPH);
            ((AnalyticsLogger) this.f3941l.get()).a(P2pPaymentsLogEvent.d("p2p_send_fail", b.k.analyticsModule).o(String.valueOf(sendMessageParams.a.b.d)).k(a3.a().c).l(ApiException.class.getName()).c(sendMessageParams.a.n).a());
            throw a3;
        } catch (Exception e3) {
            Exception exception = e3;
            ((AnalyticsLogger) this.f3941l.get()).a(P2pPaymentsLogEvent.d("p2p_send_fail", b.k.analyticsModule).o(String.valueOf(sendMessageParams.a.b.d)).k(exception.getMessage()).l(exception.getClass().getName()).c(sendMessageParams.a.n).a());
            throw exception;
        }
    }

    private NewMessageResult m3689c(SendMessageParams sendMessageParams) {
        boolean z;
        CallerContext b;
        int i = 1;
        Message message = sendMessageParams.a;
        Preconditions.checkArgument(message != null);
        if (ThreadKey.d(message.b)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        Batch a = this.f3930a.a();
        Builder a2 = BatchOperation.a(this.f3931b, message);
        a2.c = "send";
        a.a(a2.a());
        if (((Boolean) this.f3944o.get()).booleanValue()) {
            a2 = BatchOperation.a(this.f3936g, new FetchMessageParams("{result=send:$.uuid}", message.b));
            a2.c = "fetch_sent";
            a2 = a2;
            a2.d = "send";
            a.a(a2.a());
            a2 = BatchOperation.a(this.f3938i, new FetchMoreMessagesParams(message.b, null, 0, 2));
            a2.c = "fetch";
            a2 = a2;
            a2.d = "send";
            a.a(a2.a());
        } else {
            a2 = BatchOperation.a(this.f3935f, new FetchMessageParams("{result=send:$.id}", message.b));
            a2.c = "fetch_sent";
            a2 = a2;
            a2.d = "send";
            a.a(a2.a());
            a2 = BatchOperation.a(this.f3937h, new FetchMoreMessagesParams(message.b, null, -1, 2));
            a2.c = "fetch";
            a2 = a2;
            a2.d = "send";
            a.a(a2.a());
        }
        ImmutableList immutableList = message.t;
        if (immutableList != null && immutableList.size() == 1 && ((MediaResource) immutableList.get(0)).d.equals(MediaResource.Type.AUDIO)) {
            b = CallerContext.b(getClass(), "audio_upload");
        } else {
            b = CallerContext.a(getClass());
        }
        FbTraceNode a3 = FbTracer.a(sendMessageParams.c);
        FbTraceEventAnnotations a4 = FbTraceEventAnnotationsUtil.a(a3);
        a4.put("op", "send_message_via_graph");
        this.f3943n.a(a3, FbTraceEvent.REQUEST_SEND, a4);
        ApiMethodRunnerParams apiMethodRunnerParams = new ApiMethodRunnerParams();
        apiMethodRunnerParams.h = a3;
        m3684a(apiMethodRunnerParams);
        a.a("sendMessage", b, apiMethodRunnerParams);
        String str = (String) a.a("send");
        FetchMessageResult fetchMessageResult = (FetchMessageResult) a.a("fetch_sent");
        FetchMoreMessagesResult fetchMoreMessagesResult = (FetchMoreMessagesResult) a.a("fetch");
        if (fetchMessageResult == null) {
            m3685a(str, message);
            throw new NullPointerException();
        }
        MessagesCollection messagesCollection;
        FbTraceEventAnnotationsUtil.a(a3).put("message_id", str);
        this.f3943n.a(a3, FbTraceEvent.RESPONSE_RECEIVE, null);
        Message message2 = fetchMessageResult.a;
        MessagesCollection messagesCollection2 = fetchMoreMessagesResult.c;
        ImmutableList immutableList2 = messagesCollection2.b;
        int size = immutableList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (Objects.equal(((Message) immutableList2.get(i2)).a, message2.a)) {
                break;
            }
        }
        i = 0;
        if (i == 0) {
            messagesCollection = null;
        } else {
            messagesCollection = messagesCollection2;
        }
        return new NewMessageResult(DataFreshnessResult.FROM_SERVER, m3681a(message2), messagesCollection, null, this.f3942m.a());
    }

    private void m3685a(String str, Message message) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("missing_sent_msg");
        honeyClientEvent.b("server_received_msg_id", str);
        honeyClientEvent.b("offline_threading_id", message.n);
        honeyClientEvent.b("thread_type", message.b.a.dbValue);
        honeyClientEvent.a("thread_fbid", message.b.i());
        honeyClientEvent.b("msg_type", this.f3947r.b(message));
        ((AnalyticsLogger) this.f3941l.get()).a(honeyClientEvent);
    }

    private static Message m3681a(Message message) {
        return Message.newBuilder().a(message).a(SendChannel.GRAPH).R();
    }

    public final FetchThreadResult m3690a(SendMessageByRecipientsParams sendMessageByRecipientsParams) {
        Batch a = this.f3930a.a();
        Builder a2 = BatchOperation.a(this.f3934e, sendMessageByRecipientsParams);
        a2.c = "create-thread";
        a.a(a2.a());
        FetchThreadParamsBuilder fetchThreadParamsBuilder = new FetchThreadParamsBuilder();
        fetchThreadParamsBuilder.b = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
        fetchThreadParamsBuilder = fetchThreadParamsBuilder;
        fetchThreadParamsBuilder.f = 3;
        FetchThreadParamsBuilder fetchThreadParamsBuilder2 = fetchThreadParamsBuilder;
        if (((MessagingServiceGatekeeper) this.f3949t.get()).a()) {
            fetchThreadParamsBuilder2.a = ThreadCriteria.b("{result=create-thread:$.thread_fbid}");
            a2 = BatchOperation.a((ApiMethod) this.f3948s.get(), fetchThreadParamsBuilder2.i());
        } else {
            fetchThreadParamsBuilder2.a = ThreadCriteria.a("{result=create-thread:$.tid}");
            a2 = BatchOperation.a(this.f3939j, fetchThreadParamsBuilder2.i());
        }
        a2.c = "fetch-thread";
        a2 = a2;
        a2.d = "create-thread";
        a.a(a2.a());
        a.a("createThread", CallerContext.a(getClass()));
        return (FetchThreadResult) a.a("fetch-thread");
    }

    @Nullable
    private String m3683a(String str) {
        Optional a = ((PaymentTransactionCache) this.f3945p.get()).a(Long.parseLong(str));
        return a.isPresent() ? ((PaymentTransaction) a.get()).b : null;
    }

    private void m3684a(ApiMethodRunnerParams apiMethodRunnerParams) {
        Object a = this.f3946q.a();
        if (!StringUtil.c(a)) {
            apiMethodRunnerParams.a(ImmutableList.of(new BasicHeader("X-MSGR-Region", a)));
        }
    }

    private static SendPaymentMessageParams m3686b(Message message) {
        SentPayment sentPayment = message.u.c;
        boolean z = message.b.a == ThreadKey.Type.ONE_TO_ONE || (message.b.a == ThreadKey.Type.GROUP && sentPayment.j != null);
        Preconditions.checkArgument(z);
        SendPaymentMessageParamsBuilder newBuilder = SendPaymentMessageParams.newBuilder();
        newBuilder.a = sentPayment.a;
        newBuilder = newBuilder;
        newBuilder.b = sentPayment.b;
        newBuilder = newBuilder;
        newBuilder.c = String.valueOf(sentPayment.c);
        newBuilder = newBuilder;
        newBuilder.d = sentPayment.d;
        newBuilder = newBuilder;
        newBuilder.e = sentPayment.e;
        newBuilder = newBuilder;
        newBuilder.f = sentPayment.f;
        newBuilder = newBuilder;
        newBuilder.g = sentPayment.j;
        newBuilder = newBuilder;
        newBuilder.h = message.n;
        newBuilder = newBuilder;
        newBuilder.i = sentPayment.h;
        newBuilder = newBuilder;
        newBuilder.j = sentPayment.i;
        newBuilder = newBuilder;
        newBuilder.n = sentPayment.k;
        return newBuilder.o();
    }
}
