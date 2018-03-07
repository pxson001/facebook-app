package com.facebook.user.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: comment_create_subscribe */
public class PicSquareDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f5516a;

    static {
        GlobalAutoGenDeserializerCache.a(PicSquare.class, new PicSquareDeserializer());
        m10361e();
    }

    public PicSquareDeserializer() {
        a(PicSquare.class);
    }

    private static synchronized Map<String, FbJsonField> m10361e() {
        Map<String, FbJsonField> map;
        synchronized (PicSquareDeserializer.class) {
            if (f5516a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("picSquareUrls", FbJsonField.jsonField(PicSquare.class.getDeclaredField("mPicSquareUrlsWithSizes"), PicSquareUrlWithSize.class));
                    f5516a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f5516a;
        }
        return map;
    }

    public final FbJsonField m10362a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m10361e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m10361e().keySet());
    }
}
