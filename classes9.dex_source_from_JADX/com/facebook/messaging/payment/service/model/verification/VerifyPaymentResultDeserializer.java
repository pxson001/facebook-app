package com.facebook.messaging.payment.service.model.verification;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: fetchPaymentMethods */
public class VerifyPaymentResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f14795a;

    static {
        GlobalAutoGenDeserializerCache.a(VerifyPaymentResult.class, new VerifyPaymentResultDeserializer());
        m15216e();
    }

    public VerifyPaymentResultDeserializer() {
        a(VerifyPaymentResult.class);
    }

    private static synchronized Map<String, FbJsonField> m15216e() {
        Map<String, FbJsonField> map;
        synchronized (VerifyPaymentResultDeserializer.class) {
            if (f14795a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("fallback_msite", FbJsonField.jsonField(VerifyPaymentResult.class.getDeclaredField("mFallbackMSite")));
                    builder.b("fallback_uri", FbJsonField.jsonField(VerifyPaymentResult.class.getDeclaredField("mFallbackUri")));
                    builder.b("screen", FbJsonField.jsonField(VerifyPaymentResult.class.getDeclaredField("mScreen")));
                    builder.b("screen_data", FbJsonField.jsonField(VerifyPaymentResult.class.getDeclaredField("mScreenData")));
                    f14795a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f14795a;
        }
        return map;
    }

    public final FbJsonField m15217a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m15216e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m15216e().keySet());
    }
}
