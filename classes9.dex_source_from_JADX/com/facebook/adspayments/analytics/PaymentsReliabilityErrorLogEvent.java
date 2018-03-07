package com.facebook.adspayments.analytics;

/* compiled from: senderInfo */
public class PaymentsReliabilityErrorLogEvent extends PaymentsReliabilityLogEvent {
    public PaymentsReliabilityErrorLogEvent(Throwable th, PaymentsFlowContext paymentsFlowContext) {
        super(paymentsFlowContext);
        m3866a(th);
    }

    public PaymentsReliabilityErrorLogEvent(String str, PaymentsFlowContext paymentsFlowContext) {
        super(paymentsFlowContext);
        m3868o(str);
    }

    public final String mo131x() {
        return "process_error";
    }
}
