package com.facebook.zero.sdk.request;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: com.facebook */
public class ZeroOptoutResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f5905a;

    static {
        GlobalAutoGenDeserializerCache.a(ZeroOptoutResult.class, new ZeroOptoutResultDeserializer());
        m10692e();
    }

    public ZeroOptoutResultDeserializer() {
        a(ZeroOptoutResult.class);
    }

    private static synchronized Map<String, FbJsonField> m10692e() {
        Map<String, FbJsonField> map;
        synchronized (ZeroOptoutResultDeserializer.class) {
            if (f5905a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("status", FbJsonField.jsonField(ZeroOptoutResult.class.getDeclaredField("mStatus")));
                    f5905a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f5905a;
        }
        return map;
    }

    public final FbJsonField m10693a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m10692e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m10692e().keySet());
    }
}
