package com.facebook.friendsharing.gif.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: SCALE_XY */
public class GifModelContainerDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f23920a;

    static {
        GlobalAutoGenDeserializerCache.a(GifModelContainer.class, new GifModelContainerDeserializer());
        m26052e();
    }

    public GifModelContainerDeserializer() {
        a(GifModelContainer.class);
    }

    private static synchronized Map<String, FbJsonField> m26052e() {
        Map<String, FbJsonField> map;
        synchronized (GifModelContainerDeserializer.class) {
            if (f23920a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("images", FbJsonField.jsonField(GifModelContainer.class.getDeclaredField("mModelSubContainer")));
                    f23920a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f23920a;
        }
        return map;
    }

    public final FbJsonField m26053a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m26052e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m26052e().keySet());
    }
}
