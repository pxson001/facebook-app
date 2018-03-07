package com.facebook.messaging.service.methods;

import com.facebook.common.util.JSONUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.payment.PaymentTransactionData;
import com.fasterxml.jackson.databind.JsonNode;

/* compiled from: current_rtt */
public class PaymentTransactionLogDataDeserializer {
    public static PaymentTransactionLogDataDeserializer m16994a(InjectorLike injectorLike) {
        return new PaymentTransactionLogDataDeserializer();
    }

    public static PaymentTransactionData m16993a(JsonNode jsonNode) {
        return new PaymentTransactionData(JSONUtil.b(jsonNode.b("transfer_id")), JSONUtil.c(jsonNode.b("senderId")), JSONUtil.c(jsonNode.b("receiverId")), JSONUtil.d(jsonNode.b("amount")), JSONUtil.b(jsonNode.b("currency")));
    }
}
