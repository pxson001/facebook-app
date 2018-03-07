package com.facebook.vault.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: thread_cache_duration */
public class VaultImageResultObjectDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f1864a;

    static {
        GlobalAutoGenDeserializerCache.a(VaultImageResultObject.class, new VaultImageResultObjectDeserializer());
        m1950e();
    }

    public VaultImageResultObjectDeserializer() {
        a(VaultImageResultObject.class);
    }

    private static synchronized Map<String, FbJsonField> m1950e() {
        Map<String, FbJsonField> map;
        synchronized (VaultImageResultObjectDeserializer.class) {
            if (f1864a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("source", FbJsonField.jsonField(VaultImageResultObject.class.getDeclaredField("uri")));
                    builder.b("width", FbJsonField.jsonField(VaultImageResultObject.class.getDeclaredField("width")));
                    builder.b("height", FbJsonField.jsonField(VaultImageResultObject.class.getDeclaredField("height")));
                    builder.b("id", FbJsonField.jsonField(VaultImageResultObject.class.getDeclaredField("fbid")));
                    builder.b("date_taken", FbJsonField.jsonField(VaultImageResultObject.class.getDeclaredField("dateTaken")));
                    f1864a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f1864a;
        }
        return map;
    }

    public final FbJsonField m1951a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m1950e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m1950e().keySet());
    }
}
