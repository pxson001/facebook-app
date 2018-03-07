package com.facebook.vault.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: threads_legacy_thread_id_index */
public class BlacklistedSyncPathDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f1710a;

    static {
        GlobalAutoGenDeserializerCache.a(BlacklistedSyncPath.class, new BlacklistedSyncPathDeserializer());
        m1741e();
    }

    public BlacklistedSyncPathDeserializer() {
        a(BlacklistedSyncPath.class);
    }

    private static synchronized Map<String, FbJsonField> m1741e() {
        Map<String, FbJsonField> map;
        synchronized (BlacklistedSyncPathDeserializer.class) {
            if (f1710a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("path", FbJsonField.jsonField(BlacklistedSyncPath.class.getDeclaredField("path")));
                    f1710a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f1710a;
        }
        return map;
    }

    public final FbJsonField m1742a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m1741e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m1741e().keySet());
    }
}
