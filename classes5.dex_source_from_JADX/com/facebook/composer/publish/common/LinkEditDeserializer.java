package com.facebook.composer.publish.common;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: ad_preview_id */
public class LinkEditDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f11514a;

    static {
        GlobalAutoGenDeserializerCache.a(LinkEdit.class, new LinkEditDeserializer());
        m19660e();
    }

    public LinkEditDeserializer() {
        a(LinkEdit.class);
    }

    private static synchronized Map<String, FbJsonField> m19660e() {
        Map<String, FbJsonField> map;
        synchronized (LinkEditDeserializer.class) {
            if (f11514a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("no_link", FbJsonField.jsonField(LinkEdit.class.getDeclaredField("noLink")));
                    builder.b("link_data", FbJsonField.jsonField(LinkEdit.class.getDeclaredField("linkData")));
                    f11514a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f11514a;
        }
        return map;
    }

    public final FbJsonField m19661a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m19660e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m19660e().keySet());
    }
}
