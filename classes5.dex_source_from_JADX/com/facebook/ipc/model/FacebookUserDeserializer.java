package com.facebook.ipc.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: TEXTILES */
public class FacebookUserDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f14131a;

    static {
        GlobalAutoGenDeserializerCache.a(FacebookUser.class, new FacebookUserDeserializer());
        m23511e();
    }

    public FacebookUserDeserializer() {
        a(FacebookUser.class);
    }

    private static synchronized Map<String, FbJsonField> m23511e() {
        Map<String, FbJsonField> map;
        synchronized (FacebookUserDeserializer.class) {
            if (f14131a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("uid", FbJsonField.jsonField(FacebookUser.class.getDeclaredField("mUserId")));
                    builder.b("first_name", FbJsonField.jsonField(FacebookUser.class.getDeclaredField("mFirstName")));
                    builder.b("last_name", FbJsonField.jsonField(FacebookUser.class.getDeclaredField("mLastName")));
                    builder.b("name", FbJsonField.jsonField(FacebookUser.class.getDeclaredField("mDisplayName")));
                    builder.b("pic_square", FbJsonField.jsonField(FacebookUser.class.getDeclaredField("mImageUrl")));
                    builder.b("pic_cover", FbJsonField.jsonField(FacebookUser.class.getDeclaredField("mCoverPhoto")));
                    f14131a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f14131a;
        }
        return map;
    }

    public final FbJsonField m23512a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m23511e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m23511e().keySet());
    }
}
