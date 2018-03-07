package com.facebook.payments.paymentmethods.picker.protocol.parser;

import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.paymentmethods.model.PaymentMethodType;
import com.fasterxml.jackson.databind.JsonNode;

/* compiled from: bid_amount */
public interface PaymentMethodParser<PAYMENT_METHOD extends PaymentMethod> {
    PAYMENT_METHOD mo754a(JsonNode jsonNode);

    PaymentMethodType mo755a();
}
