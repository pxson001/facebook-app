package com.facebook.messaging.payment.value.input;

import android.os.Bundle;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent.Builder;
import com.facebook.messaging.payment.analytics.PaymentFlowType;
import com.facebook.messaging.payment.currency.CurrencyFormatType;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import javax.inject.Inject;

/* compiled from: event type must match accumulator type */
public class OrionRequestAckMessengerPayLogger implements MessengerPayLogger {
    private final AnalyticsLogger f15596a;
    private final PaymentCurrencyUtil f15597b;

    public static OrionRequestAckMessengerPayLogger m15811b(InjectorLike injectorLike) {
        return new OrionRequestAckMessengerPayLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), PaymentCurrencyUtil.m13192a(injectorLike));
    }

    @Inject
    public OrionRequestAckMessengerPayLogger(AnalyticsLogger analyticsLogger, PaymentCurrencyUtil paymentCurrencyUtil) {
        this.f15596a = analyticsLogger;
        this.f15597b = paymentCurrencyUtil;
    }

    public final void mo619a(String str, MessengerPayData messengerPayData, Bundle bundle) {
        m15813a(str, (PaymentRequestModel) FlatBufferModelHelper.a(bundle, "payment_request"));
    }

    public final PaymentFlowType mo618a() {
        return PaymentFlowType.REQUEST_ACK;
    }

    public static OrionRequestAckMessengerPayLogger m15810a(InjectorLike injectorLike) {
        return m15811b(injectorLike);
    }

    public final void m15813a(String str, PaymentRequestModel paymentRequestModel) {
        if (paymentRequestModel != null) {
            Builder d = P2pPaymentsLogEvent.d(str, "p2p_request");
            d.f(String.valueOf(paymentRequestModel.lw_()));
            if ("p2p_send_money_cancelled".equals(str)) {
                d.o(String.valueOf(paymentRequestModel.m13816k().m13879c())).a(this.f15597b.m13199a(CurrencyFormatType.NO_CURRENCY_SYMBOL, paymentRequestModel.m13811b().m13703a(), paymentRequestModel.m13811b().m13707b()));
            }
            this.f15596a.a(d.a);
        }
    }
}
