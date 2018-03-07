package com.facebook.katana.features.faceweb;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.katana.features.faceweb.FacewebComponentsStore.FacewebComponentsRule;
import com.facebook.katana.features.faceweb.FacewebComponentsStore.Skeleton;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: p2p_payment_info_map */
public class FacewebComponentsStore_SkeletonDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f7559a;

    static {
        GlobalAutoGenDeserializerCache.a(Skeleton.class, new FacewebComponentsStore_SkeletonDeserializer());
        m7863e();
    }

    public FacewebComponentsStore_SkeletonDeserializer() {
        a(Skeleton.class);
    }

    private static synchronized Map<String, FbJsonField> m7863e() {
        Map<String, FbJsonField> map;
        synchronized (FacewebComponentsStore_SkeletonDeserializer.class) {
            if (f7559a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("rules", FbJsonField.jsonField(Skeleton.class.getDeclaredField("mRules"), FacewebComponentsRule.class));
                    builder.b("components", FbJsonField.jsonField(Skeleton.class.getDeclaredField("mComponents")));
                    f7559a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f7559a;
        }
        return map;
    }

    public final FbJsonField m7864a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m7863e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m7863e().keySet());
    }
}
