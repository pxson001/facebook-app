package com.facebook.payments.paymentmethods.picker.protocol.parser;

import com.facebook.common.util.JSONUtil;
import com.facebook.payments.model.FormFieldProperty;
import com.facebook.payments.paymentmethods.model.FbPaymentCardType;
import com.facebook.payments.paymentmethods.model.NewCreditCardOption;
import com.facebook.payments.paymentmethods.model.NewPaymentOption;
import com.facebook.payments.paymentmethods.model.NewPaymentOptionType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.RegularImmutableSet;
import java.util.Iterator;

/* compiled from: bed093603f6f79d676672f9fa36bfd38 */
public class NMORNewCreditCardOptionParser implements NMORNewPaymentOptionParser<NewCreditCardOption> {
    public final NewPaymentOption mo596a(JsonNode jsonNode) {
        FormFieldProperty formFieldProperty;
        boolean z = true;
        Preconditions.checkArgument(jsonNode.d("type"));
        Preconditions.checkArgument(NewPaymentOptionType.forValue(JSONUtil.b(jsonNode.b("type"))) == NewPaymentOptionType.NEW_CREDIT_CARD);
        String b = JSONUtil.b(jsonNode.b("provider"));
        FormFieldProperty formFieldProperty2 = FormFieldProperty.REQUIRED;
        ImmutableSet immutableSet = RegularImmutableSet.a;
        if (jsonNode.d("card_features")) {
            JsonNode b2 = jsonNode.b("card_features");
            formFieldProperty2 = FormFieldProperty.forValue(JSONUtil.b(b2.b("zipcode")));
            b2 = b2.b("available_card_types");
            Preconditions.checkNotNull(b2);
            Preconditions.checkArgument(b2.h());
            if (b2.e() == 0) {
                z = false;
            }
            Preconditions.checkArgument(z);
            Builder builder = new Builder();
            Iterator it = b2.iterator();
            while (it.hasNext()) {
                builder.c(FbPaymentCardType.forValue(JSONUtil.b((JsonNode) it.next())));
            }
            immutableSet = builder.b();
            formFieldProperty = formFieldProperty2;
        } else {
            formFieldProperty = formFieldProperty2;
        }
        return new NewCreditCardOption(b, formFieldProperty, immutableSet);
    }

    public final NewPaymentOptionType mo597a() {
        return NewPaymentOptionType.NEW_CREDIT_CARD;
    }
}
