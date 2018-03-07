package com.facebook.loom.config;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: ticket_tier_id */
public class HTTPTraceControlConfigurationDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f1431a;

    static {
        GlobalAutoGenDeserializerCache.a(HTTPTraceControlConfiguration.class, new HTTPTraceControlConfigurationDeserializer());
        m1429e();
    }

    public HTTPTraceControlConfigurationDeserializer() {
        a(HTTPTraceControlConfiguration.class);
    }

    private static synchronized Map<String, FbJsonField> m1429e() {
        Map<String, FbJsonField> map;
        synchronized (HTTPTraceControlConfigurationDeserializer.class) {
            if (f1431a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("enabled_event_providers", FbJsonField.jsonField(HTTPTraceControlConfiguration.class.getDeclaredField("mEnabledEventProviders"), String.class));
                    f1431a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f1431a;
        }
        return map;
    }

    public final FbJsonField m1430a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m1429e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m1429e().keySet());
    }
}
