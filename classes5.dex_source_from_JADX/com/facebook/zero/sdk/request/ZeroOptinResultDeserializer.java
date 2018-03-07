package com.facebook.zero.sdk.request;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: com.facebook.adinterfaces.AdInterfacesObjectiveActivity */
public class ZeroOptinResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f5904a;

    static {
        GlobalAutoGenDeserializerCache.a(ZeroOptinResult.class, new ZeroOptinResultDeserializer());
        m10688e();
    }

    public ZeroOptinResultDeserializer() {
        a(ZeroOptinResult.class);
    }

    private static synchronized Map<String, FbJsonField> m10688e() {
        Map<String, FbJsonField> map;
        synchronized (ZeroOptinResultDeserializer.class) {
            if (f5904a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("status", FbJsonField.jsonField(ZeroOptinResult.class.getDeclaredField("mStatus")));
                    f5904a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f5904a;
        }
        return map;
    }

    public final FbJsonField m10689a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m10688e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m10688e().keySet());
    }
}
