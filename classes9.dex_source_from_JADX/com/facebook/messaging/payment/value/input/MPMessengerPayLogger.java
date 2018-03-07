package com.facebook.messaging.payment.value.input;

import android.os.Bundle;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.analytics.PaymentFlowType;
import javax.inject.Inject;

/* compiled from: exp */
public class MPMessengerPayLogger implements MessengerPayLogger {
    private AnalyticsLogger f15399a;

    public static MPMessengerPayLogger m15716b(InjectorLike injectorLike) {
        return new MPMessengerPayLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MPMessengerPayLogger(AnalyticsLogger analyticsLogger) {
        this.f15399a = analyticsLogger;
    }

    public final void mo619a(String str, MessengerPayData messengerPayData, Bundle bundle) {
        m15718a(str, messengerPayData);
    }

    public final PaymentFlowType mo618a() {
        return PaymentFlowType.MONEY_PENNY;
    }

    public final void m15718a(String str, MessengerPayData messengerPayData) {
        this.f15399a.a(P2pPaymentsLogEvent.d(str, "mp_pay").o(String.valueOf(messengerPayData.f15456m.f15477a)).a(messengerPayData.f15456m.f15482f).a);
    }
}
