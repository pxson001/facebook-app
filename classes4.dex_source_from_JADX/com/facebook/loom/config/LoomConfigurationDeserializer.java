package com.facebook.loom.config;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: getTopPhoneContacts */
public class LoomConfigurationDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f11093a;

    static {
        GlobalAutoGenDeserializerCache.a(LoomConfiguration.class, new LoomConfigurationDeserializer());
        m11520e();
    }

    public LoomConfigurationDeserializer() {
        a(LoomConfiguration.class);
    }

    private static synchronized Map<String, FbJsonField> m11520e() {
        Map<String, FbJsonField> map;
        synchronized (LoomConfigurationDeserializer.class) {
            if (f11093a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("system_control", FbJsonField.jsonField(LoomConfiguration.class.getDeclaredField("mSystemControl")));
                    builder.b("trace_control", FbJsonField.jsonField(LoomConfiguration.class.getDeclaredField("mTraceControl")));
                    builder.b("id", FbJsonField.jsonField(LoomConfiguration.class.getDeclaredField("mID")));
                    f11093a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f11093a;
        }
        return map;
    }

    public final FbJsonField m11521a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m11520e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m11520e().keySet());
    }
}
