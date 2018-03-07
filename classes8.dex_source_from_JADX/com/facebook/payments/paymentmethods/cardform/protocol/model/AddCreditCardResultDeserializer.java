package com.facebook.payments.paymentmethods.cardform.protocol.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: survey_config_id */
public class AddCreditCardResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f1924a;

    static {
        GlobalAutoGenDeserializerCache.a(AddCreditCardResult.class, new AddCreditCardResultDeserializer());
        m2120e();
    }

    public AddCreditCardResultDeserializer() {
        a(AddCreditCardResult.class);
    }

    private static synchronized Map<String, FbJsonField> m2120e() {
        Map<String, FbJsonField> map;
        synchronized (AddCreditCardResultDeserializer.class) {
            if (f1924a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(AddCreditCardResult.class.getDeclaredField("mCredentialId")));
                    f1924a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f1924a;
        }
        return map;
    }

    public final FbJsonField m2121a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m2120e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m2120e().keySet());
    }
}
