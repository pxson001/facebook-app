package com.facebook.messaging.database.serialization;

import com.facebook.common.json.ObjectMapperWithUncheckedException;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.payment.PaymentTransactionData;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: login_start */
public class DbPaymentTransactionDataSerialization {
    private final ObjectMapperWithUncheckedException f8843a;

    public static DbPaymentTransactionDataSerialization m9189a(InjectorLike injectorLike) {
        return new DbPaymentTransactionDataSerialization(ObjectMapperWithUncheckedException.a(injectorLike));
    }

    @Inject
    public DbPaymentTransactionDataSerialization(ObjectMapperWithUncheckedException objectMapperWithUncheckedException) {
        this.f8843a = objectMapperWithUncheckedException;
    }

    @Nullable
    public static String m9190a(@Nullable PaymentTransactionData paymentTransactionData) {
        if (paymentTransactionData == null) {
            return null;
        }
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("id", paymentTransactionData.a);
        objectNode.a("from", paymentTransactionData.b);
        objectNode.a("to", paymentTransactionData.c);
        objectNode.a("amount", paymentTransactionData.d);
        objectNode.a("currency", paymentTransactionData.e);
        return objectNode.toString();
    }

    @Nullable
    public final PaymentTransactionData m9191a(@Nullable String str) {
        if (StringUtil.a(str)) {
            return null;
        }
        JsonNode a = this.f8843a.a(str);
        return new PaymentTransactionData(a.b("id").s(), a.b("from").x(), a.b("to").x(), a.b("amount").w(), a.b("currency").s());
    }
}
