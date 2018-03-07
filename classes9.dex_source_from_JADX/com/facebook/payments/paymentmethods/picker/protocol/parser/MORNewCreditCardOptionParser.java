package com.facebook.payments.paymentmethods.picker.protocol.parser;

import com.facebook.common.util.JSONUtil;
import com.facebook.payments.model.FormFieldProperty;
import com.facebook.payments.paymentmethods.model.FbPaymentCardType;
import com.facebook.payments.paymentmethods.model.NewCreditCardOption;
import com.facebook.payments.paymentmethods.model.NewPaymentOption;
import com.facebook.payments.paymentmethods.model.NewPaymentOptionType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet.Builder;
import java.util.Iterator;

/* compiled from: begin_journeys */
public class MORNewCreditCardOptionParser implements MORNewPaymentOptionParser<NewCreditCardOption> {
    public final NewPaymentOptionType mo757a() {
        return NewPaymentOptionType.NEW_CREDIT_CARD;
    }

    public final NewPaymentOption mo756a(JsonNode jsonNode) {
        JsonNode b = jsonNode.b("available_card_types");
        Preconditions.checkNotNull(b);
        Preconditions.checkArgument(b.h());
        Preconditions.checkArgument(b.e() != 0);
        Builder builder = new Builder();
        Iterator it = b.iterator();
        while (it.hasNext()) {
            builder.c(FbPaymentCardType.forValue(JSONUtil.b((JsonNode) it.next())));
        }
        return new NewCreditCardOption(null, FormFieldProperty.REQUIRED, builder.b());
    }
}
