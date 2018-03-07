package com.facebook.vault.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: thread_fbid=' */
public class VaultGetSyncedImageStatusResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f1863a;

    static {
        GlobalAutoGenDeserializerCache.a(VaultGetSyncedImageStatusResult.class, new VaultGetSyncedImageStatusResultDeserializer());
        m1942e();
    }

    public VaultGetSyncedImageStatusResultDeserializer() {
        a(VaultGetSyncedImageStatusResult.class);
    }

    private static synchronized Map<String, FbJsonField> m1942e() {
        Map<String, FbJsonField> map;
        synchronized (VaultGetSyncedImageStatusResultDeserializer.class) {
            if (f1863a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("data", FbJsonField.jsonField(VaultGetSyncedImageStatusResult.class.getDeclaredField("mResult")));
                    f1863a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f1863a;
        }
        return map;
    }

    public final FbJsonField m1943a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m1942e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m1942e().keySet());
    }
}
