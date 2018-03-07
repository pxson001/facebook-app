package com.facebook.messaging.payment.service.model.cards;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: fetch_users_separately */
public class ValidatePaymentCardBinResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f14659a;

    static {
        GlobalAutoGenDeserializerCache.a(ValidatePaymentCardBinResult.class, new ValidatePaymentCardBinResultDeserializer());
        m15168e();
    }

    public ValidatePaymentCardBinResultDeserializer() {
        a(ValidatePaymentCardBinResult.class);
    }

    private static synchronized Map<String, FbJsonField> m15168e() {
        Map<String, FbJsonField> map;
        synchronized (ValidatePaymentCardBinResultDeserializer.class) {
            if (f14659a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(ValidatePaymentCardBinResult.class.getDeclaredField("mCardBinId")));
                    f14659a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f14659a;
        }
        return map;
    }

    public final FbJsonField m15169a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m15168e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m15168e().keySet());
    }
}
