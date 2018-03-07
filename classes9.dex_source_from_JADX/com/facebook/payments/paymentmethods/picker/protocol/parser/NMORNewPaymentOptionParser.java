package com.facebook.payments.paymentmethods.picker.protocol.parser;

import com.facebook.payments.paymentmethods.model.NewPaymentOption;
import com.facebook.payments.paymentmethods.model.NewPaymentOptionType;
import com.fasterxml.jackson.databind.JsonNode;

/* compiled from: follow_up_action_type */
public interface NMORNewPaymentOptionParser<NEW_PAYMENT_OPTION extends NewPaymentOption> {
    NEW_PAYMENT_OPTION mo596a(JsonNode jsonNode);

    NewPaymentOptionType mo597a();
}
