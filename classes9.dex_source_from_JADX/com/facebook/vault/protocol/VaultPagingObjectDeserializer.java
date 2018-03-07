package com.facebook.vault.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: threadFbid */
public class VaultPagingObjectDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f1873a;

    static {
        GlobalAutoGenDeserializerCache.a(VaultPagingObject.class, new VaultPagingObjectDeserializer());
        m1955e();
    }

    public VaultPagingObjectDeserializer() {
        a(VaultPagingObject.class);
    }

    private static synchronized Map<String, FbJsonField> m1955e() {
        Map<String, FbJsonField> map;
        synchronized (VaultPagingObjectDeserializer.class) {
            if (f1873a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("next", FbJsonField.jsonField(VaultPagingObject.class.getDeclaredField("next")));
                    builder.b("cursors", FbJsonField.jsonField(VaultPagingObject.class.getDeclaredField("cursors")));
                    f1873a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f1873a;
        }
        return map;
    }

    public final FbJsonField m1956a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m1955e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m1955e().keySet());
    }
}
