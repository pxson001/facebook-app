package com.facebook.payments.paymentmethods.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: subviews */
public class PayPalBillingAgreementDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f1948a;

    static {
        GlobalAutoGenDeserializerCache.a(PayPalBillingAgreement.class, new PayPalBillingAgreementDeserializer());
        m2182e();
    }

    public PayPalBillingAgreementDeserializer() {
        a(PayPalBillingAgreement.class);
    }

    private static synchronized Map<String, FbJsonField> m2182e() {
        Map<String, FbJsonField> map;
        synchronized (PayPalBillingAgreementDeserializer.class) {
            if (f1948a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(PayPalBillingAgreement.class.getDeclaredField("mId")));
                    builder.b("email", FbJsonField.jsonField(PayPalBillingAgreement.class.getDeclaredField("mEmailId")));
                    f1948a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f1948a;
        }
        return map;
    }

    public final FbJsonField m2183a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m2182e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m2182e().keySet());
    }
}
