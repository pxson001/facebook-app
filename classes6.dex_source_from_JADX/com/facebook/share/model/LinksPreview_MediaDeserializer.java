package com.facebook.share.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.share.model.LinksPreview.Media;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: server_ranking_score */
public class LinksPreview_MediaDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f4900a;

    static {
        GlobalAutoGenDeserializerCache.a(Media.class, new LinksPreview_MediaDeserializer());
        m7701e();
    }

    public LinksPreview_MediaDeserializer() {
        a(Media.class);
    }

    private static synchronized Map<String, FbJsonField> m7701e() {
        Map<String, FbJsonField> map;
        synchronized (LinksPreview_MediaDeserializer.class) {
            if (f4900a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("type", FbJsonField.jsonField(Media.class.getDeclaredField("type")));
                    builder.b("src", FbJsonField.jsonField(Media.class.getDeclaredField("src")));
                    builder.b("width", FbJsonField.jsonField(Media.class.getDeclaredField("width")));
                    builder.b("height", FbJsonField.jsonField(Media.class.getDeclaredField("height")));
                    f4900a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f4900a;
        }
        return map;
    }

    public final FbJsonField m7702a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m7701e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m7701e().keySet());
    }
}
