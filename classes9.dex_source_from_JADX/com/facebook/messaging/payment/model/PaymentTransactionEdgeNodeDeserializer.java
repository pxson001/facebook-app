package com.facebook.messaging.payment.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: iab_open_times */
public class PaymentTransactionEdgeNodeDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f13257a;

    static {
        GlobalAutoGenDeserializerCache.a(PaymentTransactionEdgeNode.class, new PaymentTransactionEdgeNodeDeserializer());
        m13535e();
    }

    public PaymentTransactionEdgeNodeDeserializer() {
        a(PaymentTransactionEdgeNode.class);
    }

    private static synchronized Map<String, FbJsonField> m13535e() {
        Map<String, FbJsonField> map;
        synchronized (PaymentTransactionEdgeNodeDeserializer.class) {
            if (f13257a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("node", FbJsonField.jsonField(PaymentTransactionEdgeNode.class.getDeclaredField("mPaymentTransaction")));
                    f13257a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f13257a;
        }
        return map;
    }

    public final FbJsonField m13536a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m13535e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m13535e().keySet());
    }
}
