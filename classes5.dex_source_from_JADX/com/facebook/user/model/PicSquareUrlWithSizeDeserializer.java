package com.facebook.user.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: comment_create_shim */
public class PicSquareUrlWithSizeDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f5517a;

    static {
        GlobalAutoGenDeserializerCache.a(PicSquareUrlWithSize.class, new PicSquareUrlWithSizeDeserializer());
        m10363e();
    }

    public PicSquareUrlWithSizeDeserializer() {
        a(PicSquareUrlWithSize.class);
    }

    private static synchronized Map<String, FbJsonField> m10363e() {
        Map<String, FbJsonField> map;
        synchronized (PicSquareUrlWithSizeDeserializer.class) {
            if (f5517a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("size", FbJsonField.jsonField(PicSquareUrlWithSize.class.getDeclaredField("size")));
                    builder.b("url", FbJsonField.jsonField(PicSquareUrlWithSize.class.getDeclaredField("url")));
                    f5517a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f5517a;
        }
        return map;
    }

    public final FbJsonField m10364a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m10363e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m10363e().keySet());
    }
}
