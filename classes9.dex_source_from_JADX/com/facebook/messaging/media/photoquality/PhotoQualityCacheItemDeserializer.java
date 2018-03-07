package com.facebook.messaging.media.photoquality;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: lookup_response_payload */
public class PhotoQualityCacheItemDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f11792a;

    static {
        GlobalAutoGenDeserializerCache.a(PhotoQualityCacheItem.class, new PhotoQualityCacheItemDeserializer());
        m12416e();
    }

    public PhotoQualityCacheItemDeserializer() {
        a(PhotoQualityCacheItem.class);
    }

    private static synchronized Map<String, FbJsonField> m12416e() {
        Map<String, FbJsonField> map;
        synchronized (PhotoQualityCacheItemDeserializer.class) {
            if (f11792a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("threadKey", FbJsonField.jsonField(PhotoQualityCacheItem.class.getDeclaredField("threadKey")));
                    builder.b("resolution", FbJsonField.jsonField(PhotoQualityCacheItem.class.getDeclaredField("resolution")));
                    builder.b("thumbnailResolution", FbJsonField.jsonField(PhotoQualityCacheItem.class.getDeclaredField("thumbnailResolution")));
                    builder.b("expirationTimeMs", FbJsonField.jsonField(PhotoQualityCacheItem.class.getDeclaredField("expirationTimeMs")));
                    f11792a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f11792a;
        }
        return map;
    }

    public final FbJsonField m12417a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m12416e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m12416e().keySet());
    }
}
