package com.facebook.messaging.payment.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: image/x-ms-bmp */
public class AmountDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f13196a;

    static {
        GlobalAutoGenDeserializerCache.a(Amount.class, new AmountDeserializer());
        m13471e();
    }

    public AmountDeserializer() {
        a(Amount.class);
    }

    private static synchronized Map<String, FbJsonField> m13471e() {
        Map<String, FbJsonField> map;
        synchronized (AmountDeserializer.class) {
            if (f13196a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("currency", FbJsonField.jsonField(Amount.class.getDeclaredField("mCurrency")));
                    builder.b("offset", FbJsonField.jsonField(Amount.class.getDeclaredField("mOffset")));
                    builder.b("amount_with_offset", FbJsonField.jsonField(Amount.class.getDeclaredField("mAmountWithOffset")));
                    f13196a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f13196a;
        }
        return map;
    }

    public final FbJsonField m13472a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m13471e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m13471e().keySet());
    }
}
