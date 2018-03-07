package com.facebook.share.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: server_sync/ */
public class ComposerAppAttributionDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f4898a;

    static {
        GlobalAutoGenDeserializerCache.a(ComposerAppAttribution.class, new ComposerAppAttributionDeserializer());
        m7693e();
    }

    public ComposerAppAttributionDeserializer() {
        a(ComposerAppAttribution.class);
    }

    private static synchronized Map<String, FbJsonField> m7693e() {
        Map<String, FbJsonField> map;
        synchronized (ComposerAppAttributionDeserializer.class) {
            if (f4898a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("app_id", FbJsonField.jsonField(ComposerAppAttribution.class.getDeclaredField("appId")));
                    builder.b("app_name", FbJsonField.jsonField(ComposerAppAttribution.class.getDeclaredField("appName")));
                    builder.b("app_key_hash", FbJsonField.jsonField(ComposerAppAttribution.class.getDeclaredField("appKeyHash")));
                    builder.b("app_metadata", FbJsonField.jsonField(ComposerAppAttribution.class.getDeclaredField("appMetadata")));
                    f4898a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f4898a;
        }
        return map;
    }

    public final FbJsonField m7694a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m7693e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m7693e().keySet());
    }
}
