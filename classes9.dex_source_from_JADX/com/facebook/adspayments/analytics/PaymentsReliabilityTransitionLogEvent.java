package com.facebook.adspayments.analytics;

/* compiled from: senderId */
public class PaymentsReliabilityTransitionLogEvent extends PaymentsReliabilityLogEvent {
    public String f3983c;

    PaymentsReliabilityTransitionLogEvent(String str, PaymentsFlowContext paymentsFlowContext) {
        super(paymentsFlowContext);
        this.f3983c = str;
        b("transition", str);
    }

    public final String mo131x() {
        return "transition";
    }
}
