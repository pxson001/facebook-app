package com.facebook.messaging.payment.service.model.pay;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: fetch_invitable_contacts */
public class SendPaymentResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f14702a;

    static {
        GlobalAutoGenDeserializerCache.a(SendPaymentResult.class, new SendPaymentResultDeserializer());
        m15189e();
    }

    public SendPaymentResultDeserializer() {
        a(SendPaymentResult.class);
    }

    private static synchronized Map<String, FbJsonField> m15189e() {
        Map<String, FbJsonField> map;
        synchronized (SendPaymentResultDeserializer.class) {
            if (f14702a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(SendPaymentResult.class.getDeclaredField("mId")));
                    builder.b("extra_data", FbJsonField.jsonField(SendPaymentResult.class.getDeclaredField("mSendPaymentResultExtra")));
                    f14702a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f14702a;
        }
        return map;
    }

    public final FbJsonField m15190a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m15189e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m15189e().keySet());
    }
}
