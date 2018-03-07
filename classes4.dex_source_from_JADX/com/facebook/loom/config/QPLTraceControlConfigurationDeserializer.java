package com.facebook.loom.config;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: getScript */
public class QPLTraceControlConfigurationDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f11104a;

    static {
        GlobalAutoGenDeserializerCache.a(QPLTraceControlConfiguration.class, new QPLTraceControlConfigurationDeserializer());
        m11546e();
    }

    public QPLTraceControlConfigurationDeserializer() {
        a(QPLTraceControlConfiguration.class);
    }

    private static synchronized Map<String, FbJsonField> m11546e() {
        Map<String, FbJsonField> map;
        synchronized (QPLTraceControlConfigurationDeserializer.class) {
            if (f11104a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("coinflip_sample_rate", FbJsonField.jsonField(QPLTraceControlConfiguration.class.getDeclaredField("mCoinflipSampleRate")));
                    builder.b("enabled_event_providers", FbJsonField.jsonField(QPLTraceControlConfiguration.class.getDeclaredField("mEnabledEventProviders"), String.class));
                    f11104a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f11104a;
        }
        return map;
    }

    public final FbJsonField m11547a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m11546e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m11546e().keySet());
    }
}
