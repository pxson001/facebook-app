package com.facebook.messaging.service.methods;

import com.facebook.common.util.JSONUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.payment.PaymentTransactionData;
import com.fasterxml.jackson.databind.JsonNode;

/* compiled from: current_time */
public class PaymentTransactionDataDeserializer {
    public static PaymentTransactionDataDeserializer m16992a(InjectorLike injectorLike) {
        return new PaymentTransactionDataDeserializer();
    }

    public static PaymentTransactionData m16991a(JsonNode jsonNode) {
        if (jsonNode == null || !jsonNode.i()) {
            return null;
        }
        return new PaymentTransactionData(JSONUtil.b(jsonNode.b("id")), JSONUtil.c(jsonNode.b("from")), JSONUtil.c(jsonNode.b("to")), JSONUtil.d(jsonNode.b("amount")), JSONUtil.b(jsonNode.b("currency")));
    }
}
