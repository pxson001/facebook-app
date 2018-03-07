package com.facebook.friendsharing.gif.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: SEARCH_RESULTS */
public class GifListDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f23919a;

    static {
        GlobalAutoGenDeserializerCache.a(GifList.class, new GifListDeserializer());
        m26048e();
    }

    public GifListDeserializer() {
        a(GifList.class);
    }

    private static synchronized Map<String, FbJsonField> m26048e() {
        Map<String, FbJsonField> map;
        synchronized (GifListDeserializer.class) {
            if (f23919a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("data", FbJsonField.jsonField(GifList.class.getDeclaredField("mList"), GifModelContainer.class));
                    f23919a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f23919a;
        }
        return map;
    }

    public final FbJsonField m26049a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m26048e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m26048e().keySet());
    }
}
