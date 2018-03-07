package com.facebook.apptab.state;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: profile/%s/activitylog_search/%s */
public class NavigationMemoryConfigDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f8942a;

    static {
        GlobalAutoGenDeserializerCache.m11718a(NavigationMemoryConfig.class, new NavigationMemoryConfigDeserializer());
        m13804e();
    }

    public NavigationMemoryConfigDeserializer() {
        m13809a(NavigationMemoryConfig.class);
    }

    private static synchronized Map<String, FbJsonField> m13804e() {
        Map<String, FbJsonField> map;
        synchronized (NavigationMemoryConfigDeserializer.class) {
            if (f8942a == null) {
                try {
                    Builder builder = new Builder();
                    builder.m609b("experiment_name", FbJsonField.jsonField(NavigationMemoryConfig.class.getDeclaredField("experimentName")));
                    builder.m609b("experiment_group_name", FbJsonField.jsonField(NavigationMemoryConfig.class.getDeclaredField("experimentGroupName")));
                    builder.m609b("low_memory_optimization_threshold_mb", FbJsonField.jsonField(NavigationMemoryConfig.class.getDeclaredField("lowMemoryOptimizationThresholdMb")));
                    f8942a = builder.m610b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f8942a;
        }
        return map;
    }

    public final FbJsonField mo1880a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m13804e().get(str);
        return fbJsonField != null ? fbJsonField : super.mo1880a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.m1324b(m13804e().keySet());
    }
}
