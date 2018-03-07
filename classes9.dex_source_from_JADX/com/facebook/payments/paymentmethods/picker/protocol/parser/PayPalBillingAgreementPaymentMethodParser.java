package com.facebook.payments.paymentmethods.picker.protocol.parser;

import com.facebook.common.util.JSONUtil;
import com.facebook.payments.paymentmethods.model.PayPalBillingAgreement;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.paymentmethods.model.PaymentMethodType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;

/* compiled from: be9890c8f9a3c51ee10f07ef447285f1 */
public class PayPalBillingAgreementPaymentMethodParser implements PaymentMethodParser<PayPalBillingAgreement> {
    public final PaymentMethodType mo755a() {
        return PaymentMethodType.PAYPAL_BILLING_AGREEMENT;
    }

    public final PaymentMethod mo754a(JsonNode jsonNode) {
        Preconditions.checkArgument(jsonNode.d("paypal_ba"));
        JsonNode b = jsonNode.b("paypal_ba");
        return new PayPalBillingAgreement(JSONUtil.b(b.b("id")), JSONUtil.b(b.b("email")));
    }
}
