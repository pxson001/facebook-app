package com.facebook.friendsharing.gif.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: SAVING_COMPLETED */
public class GifModelSubContainerDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f23922a;

    static {
        GlobalAutoGenDeserializerCache.a(GifModelSubContainer.class, new GifModelSubContainerDeserializer());
        m26057e();
    }

    public GifModelSubContainerDeserializer() {
        a(GifModelSubContainer.class);
    }

    private static synchronized Map<String, FbJsonField> m26057e() {
        Map<String, FbJsonField> map;
        synchronized (GifModelSubContainerDeserializer.class) {
            if (f23922a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("fixed_width", FbJsonField.jsonField(GifModelSubContainer.class.getDeclaredField("mModel")));
                    f23922a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f23922a;
        }
        return map;
    }

    public final FbJsonField m26058a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m26057e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m26057e().keySet());
    }
}
