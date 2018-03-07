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

/* compiled from: server_specified_transcode_bitrate */
public class LinksPreviewDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f4899a;

    static {
        GlobalAutoGenDeserializerCache.a(LinksPreview.class, new LinksPreviewDeserializer());
        m7699e();
    }

    public LinksPreviewDeserializer() {
        a(LinksPreview.class);
    }

    private static synchronized Map<String, FbJsonField> m7699e() {
        Map<String, FbJsonField> map;
        synchronized (LinksPreviewDeserializer.class) {
            if (f4899a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("href", FbJsonField.jsonField(LinksPreview.class.getDeclaredField("href")));
                    builder.b("name", FbJsonField.jsonField(LinksPreview.class.getDeclaredField("name")));
                    builder.b("caption", FbJsonField.jsonField(LinksPreview.class.getDeclaredField("caption")));
                    builder.b("description", FbJsonField.jsonField(LinksPreview.class.getDeclaredField("description")));
                    builder.b("media", FbJsonField.jsonField(LinksPreview.class.getDeclaredField("media"), Media.class));
                    builder.b("properties", FbJsonField.jsonField(LinksPreview.class.getDeclaredField("properties")));
                    f4899a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f4899a;
        }
        return map;
    }

    public final FbJsonField m7700a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m7699e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m7699e().keySet());
    }
}
