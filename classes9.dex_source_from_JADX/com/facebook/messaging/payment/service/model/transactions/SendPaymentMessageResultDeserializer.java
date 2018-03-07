package com.facebook.messaging.payment.service.model.transactions;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: fetchPaymentRequestsMethod */
public class SendPaymentMessageResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f14788a;

    static {
        GlobalAutoGenDeserializerCache.a(SendPaymentMessageResult.class, new SendPaymentMessageResultDeserializer());
        m15210e();
    }

    public SendPaymentMessageResultDeserializer() {
        a(SendPaymentMessageResult.class);
    }

    private static synchronized Map<String, FbJsonField> m15210e() {
        Map<String, FbJsonField> map;
        synchronized (SendPaymentMessageResultDeserializer.class) {
            if (f14788a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(SendPaymentMessageResult.class.getDeclaredField("id")));
                    builder.b("risk_result", FbJsonField.jsonField(SendPaymentMessageResult.class.getDeclaredField("riskResult")));
                    builder.b("verification_url", FbJsonField.jsonField(SendPaymentMessageResult.class.getDeclaredField("verificationUrl")));
                    f14788a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f14788a;
        }
        return map;
    }

    public final FbJsonField m15211a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m15210e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m15210e().keySet());
    }
}
