package com.facebook.places.pagetopics;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.ipc.model.PageTopic;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: followup_feed_unit_type */
public class FetchPageTopicsResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f14739a;

    static {
        GlobalAutoGenDeserializerCache.a(FetchPageTopicsResult.class, new FetchPageTopicsResultDeserializer());
        m22300e();
    }

    public FetchPageTopicsResultDeserializer() {
        a(FetchPageTopicsResult.class);
    }

    private static synchronized Map<String, FbJsonField> m22300e() {
        Map<String, FbJsonField> map;
        synchronized (FetchPageTopicsResultDeserializer.class) {
            if (f14739a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("data", FbJsonField.jsonField(FetchPageTopicsResult.class.getDeclaredField("data"), PageTopic.class));
                    builder.b("summary", FbJsonField.jsonField(FetchPageTopicsResult.class.getDeclaredField("summary")));
                    builder.b("locale", FbJsonField.jsonField(FetchPageTopicsResult.class.getDeclaredField("mLocale")));
                    f14739a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f14739a;
        }
        return map;
    }

    public final FbJsonField m22301a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m22300e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m22300e().keySet());
    }
}
