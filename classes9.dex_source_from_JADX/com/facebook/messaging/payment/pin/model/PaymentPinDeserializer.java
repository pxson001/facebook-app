package com.facebook.messaging.payment.pin.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: handleFetchThreadList upgraded to  */
public class PaymentPinDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f13712a;

    static {
        GlobalAutoGenDeserializerCache.a(PaymentPin.class, new PaymentPinDeserializer());
        m14263e();
    }

    public PaymentPinDeserializer() {
        a(PaymentPin.class);
    }

    private static synchronized Map<String, FbJsonField> m14263e() {
        Map<String, FbJsonField> map;
        synchronized (PaymentPinDeserializer.class) {
            if (f13712a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(PaymentPin.class.getDeclaredField("mPinId")));
                    f13712a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f13712a;
        }
        return map;
    }

    public final FbJsonField m14264a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m14263e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m14263e().keySet());
    }
}
