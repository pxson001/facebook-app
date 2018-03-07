package com.facebook.payments.paymentmethods.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: suggestifier_question_vote */
public class FbPaymentCardTypeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(FbPaymentCardType.class, new FbPaymentCardTypeDeserializer());
    }

    public Object m2173a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return FbPaymentCardType.forValue(jsonParser.o());
    }
}
