package com.facebook.messaging.payment.value.input;

import android.os.Bundle;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent.Builder;
import com.facebook.messaging.payment.analytics.PaymentFlowType;
import javax.inject.Inject;

/* compiled from: event_reminder_timestamp ASC */
public class OrionMessengerPayLogger implements MessengerPayLogger {
    private AnalyticsLogger f15511a;

    @Inject
    public OrionMessengerPayLogger(AnalyticsLogger analyticsLogger) {
        this.f15511a = analyticsLogger;
    }

    public final void mo619a(String str, MessengerPayData messengerPayData, Bundle bundle) {
        boolean z;
        OrionMessengerPayParams orionMessengerPayParams = (OrionMessengerPayParams) bundle.getParcelable("orion_messenger_pay_params");
        AnalyticsLogger analyticsLogger = this.f15511a;
        Builder a = P2pPaymentsLogEvent.d(str, "p2p_send").o(messengerPayData.f15460q.b()).a(messengerPayData.f15462s.f15442a);
        if (orionMessengerPayParams.f15515d.equals("")) {
            z = false;
        } else {
            z = true;
        }
        analyticsLogger.a(a.a(z).a);
    }

    public final PaymentFlowType mo618a() {
        return PaymentFlowType.SEND;
    }
}
