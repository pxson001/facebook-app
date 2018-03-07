package com.facebook.messaging.database.serialization;

import com.facebook.common.json.ObjectMapperWithUncheckedException;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.payment.PaymentRequestData;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: login_state_passcode_entry */
public class DbPaymentRequestDataSerialization {
    private final ObjectMapperWithUncheckedException f8842a;

    public static DbPaymentRequestDataSerialization m9186a(InjectorLike injectorLike) {
        return new DbPaymentRequestDataSerialization(ObjectMapperWithUncheckedException.a(injectorLike));
    }

    @Inject
    public DbPaymentRequestDataSerialization(ObjectMapperWithUncheckedException objectMapperWithUncheckedException) {
        this.f8842a = objectMapperWithUncheckedException;
    }

    @Nullable
    public static String m9187a(@Nullable PaymentRequestData paymentRequestData) {
        if (paymentRequestData == null) {
            return null;
        }
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("id", paymentRequestData.a);
        objectNode.a("from", paymentRequestData.b);
        objectNode.a("to", paymentRequestData.c);
        objectNode.a("amount", paymentRequestData.d);
        objectNode.a("currency", paymentRequestData.e);
        return objectNode.toString();
    }

    @Nullable
    public final PaymentRequestData m9188a(@Nullable String str) {
        long j = 0;
        if (StringUtil.a(str)) {
            return null;
        }
        JsonNode a = this.f8842a.a(str);
        String s = a.b("id") == null ? null : a.b("id").s();
        long x = a.b("from") == null ? 0 : a.b("from").x();
        if (a.b("to") != null) {
            j = a.b("to").x();
        }
        return new PaymentRequestData(s, x, j, a.b("amount") == null ? 0 : a.b("amount").w(), a.b("currency") == null ? null : a.b("currency").s());
    }
}
