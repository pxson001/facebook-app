package com.facebook.katana.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: unwrap */
public class NewsFeedToggleOptionDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f940a;

    static {
        GlobalAutoGenDeserializerCache.a(NewsFeedToggleOption.class, new NewsFeedToggleOptionDeserializer());
        m993e();
    }

    public NewsFeedToggleOptionDeserializer() {
        a(NewsFeedToggleOption.class);
    }

    private static synchronized Map<String, FbJsonField> m993e() {
        Map<String, FbJsonField> map;
        synchronized (NewsFeedToggleOptionDeserializer.class) {
            if (f940a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("title", FbJsonField.jsonField(NewsFeedToggleOption.class.getDeclaredField("title")));
                    builder.b("script", FbJsonField.jsonField(NewsFeedToggleOption.class.getDeclaredField("script")));
                    f940a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f940a;
        }
        return map;
    }

    public final FbJsonField m994a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m993e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m993e().keySet());
    }
}
