package com.facebook.messaging.payment.protocol.cards.parser;

import com.facebook.common.util.JSONUtil;
import com.facebook.messaging.payment.service.model.cards.NewPayOverCounterOption;
import com.facebook.payments.paymentmethods.model.NewPaymentOption;
import com.facebook.payments.paymentmethods.model.NewPaymentOptionType;
import com.facebook.payments.paymentmethods.picker.protocol.parser.NMORNewPaymentOptionParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;

/* compiled from: followUpActionType */
public class NMORNewPayOverCounterOptionParser implements NMORNewPaymentOptionParser<NewPayOverCounterOption> {
    public final NewPaymentOptionType mo597a() {
        return NewPaymentOptionType.NEW_PAY_OVER_COUNTER;
    }

    public final NewPaymentOption mo596a(JsonNode jsonNode) {
        Preconditions.checkArgument(jsonNode.d("type"));
        Preconditions.checkArgument(NewPaymentOptionType.forValue(JSONUtil.b(jsonNode.b("type"))) == NewPaymentOptionType.NEW_PAY_OVER_COUNTER);
        return new NewPayOverCounterOption(JSONUtil.b(jsonNode.b("provider")));
    }
}
