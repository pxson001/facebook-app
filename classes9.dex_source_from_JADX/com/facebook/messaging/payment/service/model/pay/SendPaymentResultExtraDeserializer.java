package com.facebook.messaging.payment.service.model.pay;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: fetch_former_users */
public class SendPaymentResultExtraDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f14703a;

    static {
        GlobalAutoGenDeserializerCache.a(SendPaymentResultExtra.class, new SendPaymentResultExtraDeserializer());
        m15193e();
    }

    public SendPaymentResultExtraDeserializer() {
        a(SendPaymentResultExtra.class);
    }

    private static synchronized Map<String, FbJsonField> m15193e() {
        Map<String, FbJsonField> map;
        synchronized (SendPaymentResultExtraDeserializer.class) {
            if (f14703a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("pay_over_counter_info", FbJsonField.jsonField(SendPaymentResultExtra.class.getDeclaredField("mSendPaymentBarCodeDetails")));
                    builder.b("net_banking_info", FbJsonField.jsonField(SendPaymentResultExtra.class.getDeclaredField("mSendPaymentBankDetails")));
                    f14703a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f14703a;
        }
        return map;
    }

    public final FbJsonField m15194a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m15193e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m15193e().keySet());
    }
}
