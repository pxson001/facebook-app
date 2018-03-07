package com.facebook.ipc.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: TEXT_MULTILINE */
public class FacebookProfileDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f14128a;

    static {
        GlobalAutoGenDeserializerCache.a(FacebookProfile.class, new FacebookProfileDeserializer());
        m23502e();
    }

    public FacebookProfileDeserializer() {
        a(FacebookProfile.class);
    }

    private static synchronized Map<String, FbJsonField> m23502e() {
        Map<String, FbJsonField> map;
        synchronized (FacebookProfileDeserializer.class) {
            if (f14128a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(FacebookProfile.class.getDeclaredField("mId")));
                    builder.b("name", FbJsonField.jsonField(FacebookProfile.class.getDeclaredField("mDisplayName")));
                    builder.b("pic_square", FbJsonField.jsonField(FacebookProfile.class.getDeclaredField("mImageUrl")));
                    builder.b("type", FbJsonField.jsonField(FacebookProfile.class.getDeclaredField("mTypeString")));
                    f14128a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f14128a;
        }
        return map;
    }

    public FbJsonField m23503a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m23502e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m23502e().keySet());
    }
}
