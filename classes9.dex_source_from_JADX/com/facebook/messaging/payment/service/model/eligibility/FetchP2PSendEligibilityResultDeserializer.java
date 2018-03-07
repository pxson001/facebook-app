package com.facebook.messaging.payment.service.model.eligibility;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: fetch_thread_failure */
public class FetchP2PSendEligibilityResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f14663a;

    static {
        GlobalAutoGenDeserializerCache.a(FetchP2PSendEligibilityResult.class, new FetchP2PSendEligibilityResultDeserializer());
        m15171e();
    }

    public FetchP2PSendEligibilityResultDeserializer() {
        a(FetchP2PSendEligibilityResult.class);
    }

    private static synchronized Map<String, FbJsonField> m15171e() {
        Map<String, FbJsonField> map;
        synchronized (FetchP2PSendEligibilityResultDeserializer.class) {
            if (f14663a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("can_viewer_send_money", FbJsonField.jsonField(FetchP2PSendEligibilityResult.class.getDeclaredField("mCanSend")));
                    f14663a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f14663a;
        }
        return map;
    }

    public final FbJsonField m15172a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m15171e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m15171e().keySet());
    }
}
