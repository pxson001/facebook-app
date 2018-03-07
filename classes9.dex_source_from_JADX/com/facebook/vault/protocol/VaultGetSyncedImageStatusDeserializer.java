package com.facebook.vault.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: thread_id IN (SELECT thread_id FROM #pinned_thread_ids) AND folder='inbox' */
public class VaultGetSyncedImageStatusDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f1859a;

    static {
        GlobalAutoGenDeserializerCache.a(VaultGetSyncedImageStatus.class, new VaultGetSyncedImageStatusDeserializer());
        m1938e();
    }

    public VaultGetSyncedImageStatusDeserializer() {
        a(VaultGetSyncedImageStatus.class);
    }

    private static synchronized Map<String, FbJsonField> m1938e() {
        Map<String, FbJsonField> map;
        synchronized (VaultGetSyncedImageStatusDeserializer.class) {
            if (f1859a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(VaultGetSyncedImageStatus.class.getDeclaredField("mFbid")));
                    builder.b("deleted", FbJsonField.jsonField(VaultGetSyncedImageStatus.class.getDeclaredField("mDeleted")));
                    builder.b("width", FbJsonField.jsonField(VaultGetSyncedImageStatus.class.getDeclaredField("mWidth")));
                    builder.b("height", FbJsonField.jsonField(VaultGetSyncedImageStatus.class.getDeclaredField("mHeight")));
                    f1859a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f1859a;
        }
        return map;
    }

    public final FbJsonField m1939a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m1938e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m1938e().keySet());
    }
}
