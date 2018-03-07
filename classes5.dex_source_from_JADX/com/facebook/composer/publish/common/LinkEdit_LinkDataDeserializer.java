package com.facebook.composer.publish.common;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.composer.publish.common.LinkEdit.LinkData;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: ad_id */
public class LinkEdit_LinkDataDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f11515a;

    static {
        GlobalAutoGenDeserializerCache.a(LinkData.class, new LinkEdit_LinkDataDeserializer());
        m19664e();
    }

    public LinkEdit_LinkDataDeserializer() {
        a(LinkData.class);
    }

    private static synchronized Map<String, FbJsonField> m19664e() {
        Map<String, FbJsonField> map;
        synchronized (LinkEdit_LinkDataDeserializer.class) {
            if (f11515a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("link", FbJsonField.jsonField(LinkData.class.getDeclaredField("link")));
                    f11515a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f11515a;
        }
        return map;
    }

    public final FbJsonField m19665a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m19664e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m19664e().keySet());
    }
}
