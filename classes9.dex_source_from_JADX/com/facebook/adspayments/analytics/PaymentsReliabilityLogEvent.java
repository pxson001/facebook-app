package com.facebook.adspayments.analytics;

import com.facebook.common.stringformat.StringFormatUtil;

/* compiled from: senderStatus */
public abstract class PaymentsReliabilityLogEvent extends BasePaymentsLogEvent<PaymentsReliabilityLogEvent> {
    public abstract String mo131x();

    protected PaymentsReliabilityLogEvent(PaymentsFlowContext paymentsFlowContext) {
        super("mobile_payments_reliability", paymentsFlowContext);
        b("flow", StringFormatUtil.formatStrLocaleSafe("android_mobile_payments_%s", this.f3975c.f3967b.getValue()));
        b("event_type", mo131x());
    }

    protected final PaymentsReliabilityLogEvent m3883p(String str) {
        b("step", str);
        return this;
    }

    protected final String mo130w() {
        return "payments_reliability";
    }
}
