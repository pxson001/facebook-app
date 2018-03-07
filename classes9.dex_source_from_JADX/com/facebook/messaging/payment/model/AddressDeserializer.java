package com.facebook.messaging.payment.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: image_data */
public class AddressDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f13193a;

    static {
        GlobalAutoGenDeserializerCache.a(Address.class, new AddressDeserializer());
        m13463e();
    }

    public AddressDeserializer() {
        a(Address.class);
    }

    private static synchronized Map<String, FbJsonField> m13463e() {
        Map<String, FbJsonField> map;
        synchronized (AddressDeserializer.class) {
            if (f13193a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("postal_code", FbJsonField.jsonField(Address.class.getDeclaredField("mPostalCode")));
                    f13193a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f13193a;
        }
        return map;
    }

    public final FbJsonField m13464a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m13463e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m13463e().keySet());
    }
}
