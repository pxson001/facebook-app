package com.facebook.composer.publish.common;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: activity_type */
public class PostParamsWrapperDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f11531a;

    static {
        GlobalAutoGenDeserializerCache.a(PostParamsWrapper.class, new PostParamsWrapperDeserializer());
        m19693e();
    }

    public PostParamsWrapperDeserializer() {
        a(PostParamsWrapper.class);
    }

    private static synchronized Map<String, FbJsonField> m19693e() {
        Map<String, FbJsonField> map;
        synchronized (PostParamsWrapperDeserializer.class) {
            if (f11531a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("publish_post_params", FbJsonField.jsonField(PostParamsWrapper.class.getDeclaredField("publishPostParams")));
                    builder.b("edit_post_params", FbJsonField.jsonField(PostParamsWrapper.class.getDeclaredField("editPostParams")));
                    f11531a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f11531a;
        }
        return map;
    }

    public final FbJsonField m19694a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m19693e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m19693e().keySet());
    }
}
