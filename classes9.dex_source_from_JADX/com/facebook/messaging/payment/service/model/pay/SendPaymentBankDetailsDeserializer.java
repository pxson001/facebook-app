package com.facebook.messaging.payment.service.model.pay;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: fetch_remote_typeahead */
public class SendPaymentBankDetailsDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f14672a;

    static {
        GlobalAutoGenDeserializerCache.a(SendPaymentBankDetails.class, new SendPaymentBankDetailsDeserializer());
        m15182e();
    }

    public SendPaymentBankDetailsDeserializer() {
        a(SendPaymentBankDetails.class);
    }

    private static synchronized Map<String, FbJsonField> m15182e() {
        Map<String, FbJsonField> map;
        synchronized (SendPaymentBankDetailsDeserializer.class) {
            if (f14672a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("code", FbJsonField.jsonField(SendPaymentBankDetails.class.getDeclaredField("mCode")));
                    builder.b("image", FbJsonField.jsonField(SendPaymentBankDetails.class.getDeclaredField("mImage")));
                    builder.b("redirect_url", FbJsonField.jsonField(SendPaymentBankDetails.class.getDeclaredField("mRedirectUrl")));
                    builder.b("dismiss_url", FbJsonField.jsonField(SendPaymentBankDetails.class.getDeclaredField("mDismissUrl")));
                    builder.b("name", FbJsonField.jsonField(SendPaymentBankDetails.class.getDeclaredField("mName")));
                    f14672a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f14672a;
        }
        return map;
    }

    public final FbJsonField m15183a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m15182e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m15182e().keySet());
    }
}
