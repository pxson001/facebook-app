package com.facebook.loom.config;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: getTopFriends */
public class SystemControlConfigurationDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f11095a;

    static {
        GlobalAutoGenDeserializerCache.a(SystemControlConfiguration.class, new SystemControlConfigurationDeserializer());
        m11527e();
    }

    public SystemControlConfigurationDeserializer() {
        a(SystemControlConfiguration.class);
    }

    private static synchronized Map<String, FbJsonField> m11527e() {
        Map<String, FbJsonField> map;
        synchronized (SystemControlConfigurationDeserializer.class) {
            if (f11095a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("upload_max_bytes", FbJsonField.jsonField(SystemControlConfiguration.class.getDeclaredField("mUploadMaxBytes")));
                    builder.b("upload_bytes_per_update", FbJsonField.jsonField(SystemControlConfiguration.class.getDeclaredField("mUploadBytesPerUpdate")));
                    builder.b("upload_time_period_sec", FbJsonField.jsonField(SystemControlConfiguration.class.getDeclaredField("mUploadTimePeriodSec")));
                    f11095a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f11095a;
        }
        return map;
    }

    public final FbJsonField m11528a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m11527e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m11527e().keySet());
    }
}
