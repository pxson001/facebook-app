package com.facebook.feedback.reactions.ui;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: setPressed */
public class VectorGraphicConfigDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f3958a;

    static {
        GlobalAutoGenDeserializerCache.a(VectorGraphicConfig.class, new VectorGraphicConfigDeserializer());
        m4611e();
    }

    public VectorGraphicConfigDeserializer() {
        a(VectorGraphicConfig.class);
    }

    private static synchronized Map<String, FbJsonField> m4611e() {
        Map<String, FbJsonField> map;
        synchronized (VectorGraphicConfigDeserializer.class) {
            if (f3958a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("name", FbJsonField.jsonField(VectorGraphicConfig.class.getDeclaredField("mName")));
                    builder.b("canvas_size", FbJsonField.jsonField(VectorGraphicConfig.class.getDeclaredField("mCanvasSize")));
                    builder.b("vector_count", FbJsonField.jsonField(VectorGraphicConfig.class.getDeclaredField("mVectorCount")));
                    builder.b("states", FbJsonField.jsonField(VectorGraphicConfig.class.getDeclaredField("mStates")));
                    builder.b("paint_map", FbJsonField.jsonField(VectorGraphicConfig.class.getDeclaredField("mPaintMapConfig")));
                    f3958a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f3958a;
        }
        return map;
    }

    public final FbJsonField m4612a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m4611e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m4611e().keySet());
    }
}
