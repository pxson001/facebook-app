package com.facebook.adspayments.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: firstCodePoint */
public class AddPaymentCardResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f23695a;

    static {
        GlobalAutoGenDeserializerCache.a(AddPaymentCardResult.class, new AddPaymentCardResultDeserializer());
        m25707e();
    }

    public AddPaymentCardResultDeserializer() {
        a(AddPaymentCardResult.class);
    }

    private static synchronized Map<String, FbJsonField> m25707e() {
        Map<String, FbJsonField> map;
        synchronized (AddPaymentCardResultDeserializer.class) {
            if (f23695a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(AddPaymentCardResult.class.getDeclaredField("mCredentialId")));
                    builder.b("is_prepay_eligible", FbJsonField.jsonField(AddPaymentCardResult.class.getDeclaredField("mIsPrepayEligible")));
                    builder.b("cached_csc_token", FbJsonField.jsonField(AddPaymentCardResult.class.getDeclaredField("mCvvToken")));
                    f23695a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f23695a;
        }
        return map;
    }

    public final FbJsonField m25708a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m25707e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m25707e().keySet());
    }
}
