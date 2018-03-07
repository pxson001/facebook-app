package com.facebook.messaging.payment.value.input;

import android.os.Bundle;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent.Builder;
import com.facebook.messaging.payment.analytics.PaymentFlowType;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: eta_in_minutes */
public class OrionRequestMessengerPayLogger implements MessengerPayLogger {
    private final AnalyticsLogger f15647a;

    public static OrionRequestMessengerPayLogger m15830b(InjectorLike injectorLike) {
        return new OrionRequestMessengerPayLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public OrionRequestMessengerPayLogger(AnalyticsLogger analyticsLogger) {
        this.f15647a = analyticsLogger;
    }

    public final void mo619a(String str, MessengerPayData messengerPayData, Bundle bundle) {
    }

    public final PaymentFlowType mo618a() {
        return PaymentFlowType.REQUEST;
    }

    public final void m15832a(String str, MessengerPayData messengerPayData) {
        m15834a(str, messengerPayData, null);
    }

    public final void m15834a(String str, MessengerPayData messengerPayData, @Nullable String str2) {
        Builder d = P2pPaymentsLogEvent.d(str, "p2p_request");
        Object obj = -1;
        switch (str.hashCode()) {
            case -570732417:
                if (str.equals("p2p_request_fail")) {
                    obj = 2;
                    break;
                }
                break;
            case 305610498:
                if (str.equals("p2p_request_success")) {
                    obj = 1;
                    break;
                }
                break;
            case 1679303871:
                if (str.equals("p2p_confirm_request")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                this.f15647a.a(d.a);
                return;
            case 1:
                Preconditions.checkNotNull(str2);
                this.f15647a.a(d.f(str2).o(messengerPayData.f15460q.b()).a);
                return;
            case 2:
                this.f15647a.a(d.o(messengerPayData.f15460q.b()).a);
                return;
            default:
                return;
        }
    }
}
