package com.facebook.messaging.payment.value.input;

import android.os.Bundle;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.analytics.PaymentFlowType;
import javax.inject.Inject;

/* compiled from: extra_click_download_ids */
public class GroupCommerceMessengerPayLogger implements MessengerPayLogger {
    private final AnalyticsLogger f15322a;

    @Inject
    public GroupCommerceMessengerPayLogger(AnalyticsLogger analyticsLogger) {
        this.f15322a = analyticsLogger;
    }

    public final void mo619a(String str, MessengerPayData messengerPayData, Bundle bundle) {
        this.f15322a.a(P2pPaymentsLogEvent.d(str, mo618a().analyticsModule).o(messengerPayData.f15460q.b()).a(messengerPayData.f15462s.f15442a).a);
    }

    public final PaymentFlowType mo618a() {
        return PaymentFlowType.GROUP_COMMERCE;
    }
}
