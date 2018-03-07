package com.facebook.payments.paymentmethods.picker.protocol.parser;

import com.facebook.payments.paymentmethods.model.NewPayPalOption;
import com.facebook.payments.paymentmethods.model.NewPaymentOption;
import com.facebook.payments.paymentmethods.model.NewPaymentOptionType;
import com.fasterxml.jackson.databind.JsonNode;

/* compiled from: before_time_ms */
public class MORNewPayPalOptionParser implements MORNewPaymentOptionParser<NewPayPalOption> {
    public final NewPaymentOptionType mo757a() {
        return NewPaymentOptionType.NEW_PAYPAL;
    }

    public final NewPaymentOption mo756a(JsonNode jsonNode) {
        return new NewPayPalOption();
    }
}
