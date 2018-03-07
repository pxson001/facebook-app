package com.facebook.adspayments.analytics;

/* compiled from: sender_hmac */
public class PaymentsLogEvent extends BasePaymentsLogEvent<PaymentsLogEvent> {
    public PaymentsLogEvent(String str, PaymentsFlowContext paymentsFlowContext) {
        super(str, paymentsFlowContext);
        b("flow_name", paymentsFlowContext.f3966a);
        a("flow_type", paymentsFlowContext.f3970e);
        b("flow_step", this.d);
        b("external_reference_id", paymentsFlowContext.f3969d);
        b("item_type", paymentsFlowContext.f3967b.getValue());
        m3867c("external_reference_id", paymentsFlowContext.f3971f);
    }

    public final PaymentsLogEvent m3870p(String str) {
        b("card_issuer", str);
        return this;
    }

    public final PaymentsLogEvent m3871q(String str) {
        b("credential_id", str);
        return this;
    }

    protected final String mo130w() {
        return "payments_flow";
    }
}
