package com.facebook.messaging.media.photoquality;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: login_logout */
public class PhotoQualityQueryResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f11793a;

    static {
        GlobalAutoGenDeserializerCache.a(PhotoQualityQueryResult.class, new PhotoQualityQueryResultDeserializer());
        m12420e();
    }

    public PhotoQualityQueryResultDeserializer() {
        a(PhotoQualityQueryResult.class);
    }

    private static synchronized Map<String, FbJsonField> m12420e() {
        Map<String, FbJsonField> map;
        synchronized (PhotoQualityQueryResultDeserializer.class) {
            if (f11793a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("resolution", FbJsonField.jsonField(PhotoQualityQueryResult.class.getDeclaredField("resolution")));
                    builder.b("thumbnail_resolution", FbJsonField.jsonField(PhotoQualityQueryResult.class.getDeclaredField("thumbnailResolution")));
                    f11793a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f11793a;
        }
        return map;
    }

    public final FbJsonField m12421a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m12420e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m12420e().keySet());
    }
}
