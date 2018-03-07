package com.facebook.katana.features.faceweb;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: p2p_pin_delete_fail */
public class FacewebComponentsStoreDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f7556a;

    static {
        GlobalAutoGenDeserializerCache.a(FacewebComponentsStore.class, new FacewebComponentsStoreDeserializer());
        m7855e();
    }

    public FacewebComponentsStoreDeserializer() {
        a(FacewebComponentsStore.class);
    }

    private static synchronized Map<String, FbJsonField> m7855e() {
        Map<String, FbJsonField> map;
        synchronized (FacewebComponentsStoreDeserializer.class) {
            if (f7556a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("version", FbJsonField.jsonField(FacewebComponentsStore.class.getDeclaredField("mVersion")));
                    builder.b("components", FbJsonField.jsonField(FacewebComponentsStore.class.getDeclaredField("mSkeletonString")));
                    f7556a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f7556a;
        }
        return map;
    }

    public final FbJsonField m7856a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m7855e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m7855e().keySet());
    }
}
