package com.facebook.messaging.payment.sync.delta.handler;

import android.os.Bundle;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLPeerToPeerPaymentRequestStatus;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.cache.PaymentRequestCache;
import com.facebook.messaging.payment.database.handler.DbInsertPaymentRequestsHandler;
import com.facebook.messaging.payment.database.handler.DbPaymentsUtil;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentCurrencyQuantityModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel.Builder;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentUserModel;
import com.facebook.messaging.payment.protocol.PaymentsBroadcaster;
import com.facebook.messaging.payment.protocol.request.FetchPaymentRequestMethod;
import com.facebook.messaging.payment.service.model.request.FetchPaymentRequestParams;
import com.facebook.messaging.payment.sync.delta.handlerbase.PaymentsDeltaHandler;
import com.facebook.messaging.payment.util.PaymentRequestUtil;
import com.facebook.messaging.paymentsync.model.thrift.DeltaNewPaymentRequest;
import com.facebook.messaging.paymentsync.model.thrift.DeltaPaymentWrapper;
import com.facebook.messaging.paymentsync.model.thrift.PaymentRequestStatus;
import com.facebook.sync.delta.DeltaWithSequenceId;
import javax.inject.Inject;

@UserScoped
/* compiled from: fetchMoreMessages */
public class DeltaNewPaymentRequestHandler extends PaymentsDeltaHandler {
    private static final Class<?> f14867a = DeltaNewPaymentRequestHandler.class;
    private static final Object f14868k = new Object();
    private final AbstractFbErrorReporter f14869b;
    private final FetchPaymentRequestMethod f14870c;
    private final PaymentsBroadcaster f14871d;
    private final ApiMethodRunnerImpl f14872e;
    private final PaymentRequestCache f14873f;
    private final AnalyticsLogger f14874g;
    private final PaymentRequestUtil f14875h;
    private final DbPaymentsUtil f14876i;
    private final DbInsertPaymentRequestsHandler f14877j;

    private static DeltaNewPaymentRequestHandler m15278b(InjectorLike injectorLike) {
        return new DeltaNewPaymentRequestHandler((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), FetchPaymentRequestMethod.m15072a(injectorLike), PaymentsBroadcaster.m15003a(injectorLike), ApiMethodRunnerImpl.a(injectorLike), PaymentRequestCache.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), PaymentRequestUtil.a(injectorLike), DbPaymentsUtil.m13275a(injectorLike), DbInsertPaymentRequestsHandler.m13258a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.payment.sync.delta.handler.DeltaNewPaymentRequestHandler m15276a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f14868k;	 Catch:{ all -> 0x006c }
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
        r1 = m15278b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f14868k;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.sync.delta.handler.DeltaNewPaymentRequestHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.payment.sync.delta.handler.DeltaNewPaymentRequestHandler) r0;	 Catch:{  }
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
        r0 = f14868k;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.sync.delta.handler.DeltaNewPaymentRequestHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.sync.delta.handler.DeltaNewPaymentRequestHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.sync.delta.handler.DeltaNewPaymentRequestHandler");
    }

    @Inject
    public DeltaNewPaymentRequestHandler(AbstractFbErrorReporter abstractFbErrorReporter, FetchPaymentRequestMethod fetchPaymentRequestMethod, PaymentsBroadcaster paymentsBroadcaster, ApiMethodRunnerImpl apiMethodRunnerImpl, PaymentRequestCache paymentRequestCache, AnalyticsLogger analyticsLogger, PaymentRequestUtil paymentRequestUtil, DbPaymentsUtil dbPaymentsUtil, DbInsertPaymentRequestsHandler dbInsertPaymentRequestsHandler) {
        this.f14869b = abstractFbErrorReporter;
        this.f14870c = fetchPaymentRequestMethod;
        this.f14871d = paymentsBroadcaster;
        this.f14872e = apiMethodRunnerImpl;
        this.f14873f = paymentRequestCache;
        this.f14874g = analyticsLogger;
        this.f14875h = paymentRequestUtil;
        this.f14876i = dbPaymentsUtil;
        this.f14877j = dbInsertPaymentRequestsHandler;
    }

    protected final Bundle mo599a(DeltaWithSequenceId<DeltaPaymentWrapper> deltaWithSequenceId) {
        PaymentRequestModel paymentRequestModel;
        DeltaNewPaymentRequest h = ((DeltaPaymentWrapper) deltaWithSequenceId.a).m16097h();
        if (m15277a(h)) {
            try {
                paymentRequestModel = (PaymentRequestModel) this.f14872e.a(this.f14870c, new FetchPaymentRequestParams(String.valueOf(h.requestFbId)));
            } catch (Exception e) {
                this.f14869b.b(f14867a.getSimpleName(), "Failed to fetch payment request with id " + h.requestFbId);
                paymentRequestModel = null;
            }
        } else {
            PaymentUserModel a = this.f14876i.m13277a(String.valueOf(h.requesteeFbId));
            PaymentUserModel a2 = this.f14876i.m13277a(String.valueOf(h.requesterFbId));
            GraphQLPeerToPeerPaymentRequestStatus valueOf = GraphQLPeerToPeerPaymentRequestStatus.valueOf((String) PaymentRequestStatus.f15973b.get(h.initialStatus));
            paymentRequestModel = new Builder().m13797b(String.valueOf(h.requestFbId)).m13791a(valueOf).m13792a(new PaymentCurrencyQuantityModel.Builder().m13697a(h.currency).m13696a(h.amount.intValue()).m13699b(h.amountOffset.intValue()).m13698a()).m13790a(h.timestampMs.longValue() / 1000).m13794a(String.valueOf(h.groupThreadFbId)).m13798c(h.memoText).m13793a(a).m13796b(a2).m13795a();
        }
        if (this.f14875h.d(paymentRequestModel)) {
            this.f14877j.m13261a(paymentRequestModel);
        } else if (this.f14875h.e(paymentRequestModel)) {
            this.f14877j.m13263b(paymentRequestModel);
        }
        m15279b(h);
        Bundle bundle = new Bundle();
        FlatBufferModelHelper.a(bundle, "payment_request", paymentRequestModel);
        return bundle;
    }

    public final void m15281a(Bundle bundle, DeltaWithSequenceId<DeltaPaymentWrapper> deltaWithSequenceId) {
        PaymentRequestModel paymentRequestModel = (PaymentRequestModel) FlatBufferModelHelper.a(bundle, "payment_request");
        this.f14873f.a(paymentRequestModel);
        this.f14871d.m15008a(paymentRequestModel.lw_());
    }

    private static boolean m15277a(DeltaNewPaymentRequest deltaNewPaymentRequest) {
        return deltaNewPaymentRequest.hasMemoMultimedia.booleanValue() || deltaNewPaymentRequest.themeId != null;
    }

    private void m15279b(DeltaNewPaymentRequest deltaNewPaymentRequest) {
        this.f14874g.a(P2pPaymentsLogEvent.d("p2p_sync_delta", "p2p_request").w("DeltaNewPaymentRequest").a(deltaNewPaymentRequest.irisSeqId).a);
    }
}
