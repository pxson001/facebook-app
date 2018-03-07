package com.facebook.payments.paymentmethods.picker.protocol.parser;

import com.facebook.payments.paymentmethods.model.NewPaymentOption;
import com.facebook.payments.paymentmethods.model.NewPaymentOptionType;
import com.fasterxml.jackson.databind.JsonNode;

/* compiled from: best */
public interface MORNewPaymentOptionParser<NEW_PAYMENT_OPTION extends NewPaymentOption> {
    NEW_PAYMENT_OPTION mo756a(JsonNode jsonNode);

    NewPaymentOptionType mo757a();
}
