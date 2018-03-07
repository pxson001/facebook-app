package com.facebook.messaging.payment.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: idpTokenType */
public class P2pCreditCardDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f13200a;

    static {
        GlobalAutoGenDeserializerCache.a(P2pCreditCard.class, new P2pCreditCardDeserializer());
        m13486e();
    }

    public P2pCreditCardDeserializer() {
        a(P2pCreditCard.class);
    }

    private static synchronized Map<String, FbJsonField> m13486e() {
        Map<String, FbJsonField> map;
        synchronized (P2pCreditCardDeserializer.class) {
            if (f13200a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("credential_id", FbJsonField.jsonField(P2pCreditCard.class.getDeclaredField("mCredentialId")));
                    builder.b("number", FbJsonField.jsonField(P2pCreditCard.class.getDeclaredField("mLastFourDigits")));
                    builder.b("expire_month", FbJsonField.jsonField(P2pCreditCard.class.getDeclaredField("mExpirationMonth")));
                    builder.b("expire_year", FbJsonField.jsonField(P2pCreditCard.class.getDeclaredField("mExpirationYear")));
                    builder.b("address", FbJsonField.jsonField(P2pCreditCard.class.getDeclaredField("mAddress")));
                    builder.b("association", FbJsonField.jsonField(P2pCreditCard.class.getDeclaredField("mAssociation")));
                    f13200a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f13200a;
        }
        return map;
    }

    public final FbJsonField m13487a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m13486e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m13486e().keySet());
    }
}
