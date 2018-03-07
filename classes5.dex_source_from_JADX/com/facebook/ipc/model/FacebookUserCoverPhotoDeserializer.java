package com.facebook.ipc.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: TEXT_HEADER */
public class FacebookUserCoverPhotoDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f14130a;

    static {
        GlobalAutoGenDeserializerCache.a(FacebookUserCoverPhoto.class, new FacebookUserCoverPhotoDeserializer());
        m23507e();
    }

    public FacebookUserCoverPhotoDeserializer() {
        a(FacebookUserCoverPhoto.class);
    }

    private static synchronized Map<String, FbJsonField> m23507e() {
        Map<String, FbJsonField> map;
        synchronized (FacebookUserCoverPhotoDeserializer.class) {
            if (f14130a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("cover_id", FbJsonField.jsonField(FacebookUserCoverPhoto.class.getDeclaredField("coverID")));
                    builder.b("source", FbJsonField.jsonField(FacebookUserCoverPhoto.class.getDeclaredField("source")));
                    builder.b("offset_x", FbJsonField.jsonField(FacebookUserCoverPhoto.class.getDeclaredField("offsetX")));
                    builder.b("offset_y", FbJsonField.jsonField(FacebookUserCoverPhoto.class.getDeclaredField("offsetY")));
                    f14130a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f14130a;
        }
        return map;
    }

    public final FbJsonField m23508a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m23507e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m23507e().keySet());
    }
}
