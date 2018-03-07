package com.facebook.vault.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: thread_id IN (SELECT thread_id FROM #thread_list_ids) */
public class VaultAllImagesGetResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f1848a;

    static {
        GlobalAutoGenDeserializerCache.a(VaultAllImagesGetResult.class, new VaultAllImagesGetResultDeserializer());
        m1931e();
    }

    public VaultAllImagesGetResultDeserializer() {
        a(VaultAllImagesGetResult.class);
    }

    private static synchronized Map<String, FbJsonField> m1931e() {
        Map<String, FbJsonField> map;
        synchronized (VaultAllImagesGetResultDeserializer.class) {
            if (f1848a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("data", FbJsonField.jsonField(VaultAllImagesGetResult.class.getDeclaredField("data"), VaultImageResultObject.class));
                    builder.b("paging", FbJsonField.jsonField(VaultAllImagesGetResult.class.getDeclaredField("paging")));
                    f1848a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f1848a;
        }
        return map;
    }

    public final FbJsonField m1932a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m1931e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m1931e().keySet());
    }
}
