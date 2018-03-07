package com.facebook.messaging.payment.prefs;

import com.facebook.conditionalworker.ConditionalWorker;
import com.facebook.conditionalworker.ConditionalWorkerRunner;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.messaging.payment.service.model.request.FetchPaymentRequestsParams.QueryType;
import javax.inject.Inject;

/* compiled from: group_thread_id */
public class FetchIncomingPaymentRequestsConditionalWorker implements ConditionalWorker {
    private static final Class<?> f13769a = FetchIncomingPaymentRequestsConditionalWorker.class;
    private final PaymentProtocolUtil f13770b;

    @Inject
    public FetchIncomingPaymentRequestsConditionalWorker(PaymentProtocolUtil paymentProtocolUtil) {
        this.f13770b = paymentProtocolUtil;
    }

    public final boolean m14340a(ConditionalWorkerRunner conditionalWorkerRunner) {
        if (!conditionalWorkerRunner.a()) {
            return false;
        }
        this.f13770b.m14951a(QueryType.INCOMING);
        return true;
    }
}
