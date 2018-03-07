package com.facebook.friendsharing.gif.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: SCALED_UP */
public class GifModelDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f23921a;

    static {
        GlobalAutoGenDeserializerCache.a(GifModel.class, new GifModelDeserializer());
        m26054e();
    }

    public GifModelDeserializer() {
        a(GifModel.class);
    }

    private static synchronized Map<String, FbJsonField> m26054e() {
        Map<String, FbJsonField> map;
        synchronized (GifModelDeserializer.class) {
            if (f23921a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("url", FbJsonField.jsonField(GifModel.class.getDeclaredField("mUrl")));
                    builder.b("width", FbJsonField.jsonField(GifModel.class.getDeclaredField("mWidth")));
                    builder.b("height", FbJsonField.jsonField(GifModel.class.getDeclaredField("mHeight")));
                    f23921a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f23921a;
        }
        return map;
    }

    public final FbJsonField m26055a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m26054e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m26054e().keySet());
    }
}
