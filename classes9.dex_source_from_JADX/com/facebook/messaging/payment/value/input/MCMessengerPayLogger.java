package com.facebook.messaging.payment.value.input;

import android.os.Bundle;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.analytics.PaymentFlowType;
import com.facebook.messaging.payment.currency.CurrencyFormatType;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import javax.inject.Inject;

/* compiled from: external_intent */
public class MCMessengerPayLogger implements MessengerPayLogger {
    private AnalyticsLogger f15338a;
    private PaymentCurrencyUtil f15339b;

    public static MCMessengerPayLogger m15683b(InjectorLike injectorLike) {
        return new MCMessengerPayLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), PaymentCurrencyUtil.m13192a(injectorLike));
    }

    @Inject
    public MCMessengerPayLogger(AnalyticsLogger analyticsLogger, PaymentCurrencyUtil paymentCurrencyUtil) {
        this.f15338a = analyticsLogger;
        this.f15339b = paymentCurrencyUtil;
    }

    public final void mo619a(String str, MessengerPayData messengerPayData, Bundle bundle) {
        m15685a(str, messengerPayData);
    }

    public final PaymentFlowType mo618a() {
        return PaymentFlowType.MESSENGER_COMMERCE;
    }

    public final void m15685a(String str, MessengerPayData messengerPayData) {
        this.f15338a.a(P2pPaymentsLogEvent.d(str, "mc_pay").o(String.valueOf(messengerPayData.f15455l.m13779b())).a(this.f15339b.m13199a(CurrencyFormatType.CURRENCY_SYMBOL_AND_EMPTY_DECIMALS, messengerPayData.f15455l.lu_().m13691a(), messengerPayData.f15455l.lu_().m13695b())).a);
    }
}
