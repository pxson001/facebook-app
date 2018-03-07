package com.facebook.katana.features.faceweb;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.katana.features.faceweb.FacewebComponentsStore.FacewebSkeletonPalCall;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: p2p_payment_pins */
public class FacewebComponentsStore_FacewebSkeletonPalCallDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f7558a;

    static {
        GlobalAutoGenDeserializerCache.a(FacewebSkeletonPalCall.class, new FacewebComponentsStore_FacewebSkeletonPalCallDeserializer());
        m7861e();
    }

    public FacewebComponentsStore_FacewebSkeletonPalCallDeserializer() {
        a(FacewebSkeletonPalCall.class);
    }

    private static synchronized Map<String, FbJsonField> m7861e() {
        Map<String, FbJsonField> map;
        synchronized (FacewebComponentsStore_FacewebSkeletonPalCallDeserializer.class) {
            if (f7558a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("method", FbJsonField.jsonField(FacewebSkeletonPalCall.class.getDeclaredField("mMethod")));
                    builder.b("params", FbJsonField.jsonField(FacewebSkeletonPalCall.class.getDeclaredField("mParams")));
                    f7558a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f7558a;
        }
        return map;
    }

    public final FbJsonField m7862a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m7861e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m7861e().keySet());
    }
}
