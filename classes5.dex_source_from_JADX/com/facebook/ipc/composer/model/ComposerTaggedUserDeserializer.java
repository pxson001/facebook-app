package com.facebook.ipc.composer.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: TIME_JOINED_GROUP */
public class ComposerTaggedUserDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f13977a;

    static {
        GlobalAutoGenDeserializerCache.a(ComposerTaggedUser.class, new ComposerTaggedUserDeserializer());
        m23364e();
    }

    public ComposerTaggedUserDeserializer() {
        a(ComposerTaggedUser.class);
    }

    private static synchronized Map<String, FbJsonField> m23364e() {
        Map<String, FbJsonField> map;
        synchronized (ComposerTaggedUserDeserializer.class) {
            if (f13977a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(ComposerTaggedUser.class.getDeclaredField("mId")));
                    builder.b("name", FbJsonField.jsonField(ComposerTaggedUser.class.getDeclaredField("mName")));
                    builder.b("image_url", FbJsonField.jsonField(ComposerTaggedUser.class.getDeclaredField("mImageUrl")));
                    f13977a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f13977a;
        }
        return map;
    }

    public final FbJsonField m23365a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m23364e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m23364e().keySet());
    }
}
