package com.facebook.messaging.payment.service.model.moneypenny;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: fetch_saved_audiences_task_key */
public class MoneyPennyPlaceOrderResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f14671a;

    static {
        GlobalAutoGenDeserializerCache.a(MoneyPennyPlaceOrderResult.class, new MoneyPennyPlaceOrderResultDeserializer());
        m15175e();
    }

    public MoneyPennyPlaceOrderResultDeserializer() {
        a(MoneyPennyPlaceOrderResult.class);
    }

    private static synchronized Map<String, FbJsonField> m15175e() {
        Map<String, FbJsonField> map;
        synchronized (MoneyPennyPlaceOrderResultDeserializer.class) {
            if (f14671a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("payment_id", FbJsonField.jsonField(MoneyPennyPlaceOrderResult.class.getDeclaredField("mTransactionId")));
                    f14671a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f14671a;
        }
        return map;
    }

    public final FbJsonField m15176a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m15175e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m15175e().keySet());
    }
}
