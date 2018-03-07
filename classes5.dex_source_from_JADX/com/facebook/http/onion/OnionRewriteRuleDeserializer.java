package com.facebook.http.onion;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: direct_share_preview_image */
public class OnionRewriteRuleDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f5059a;

    static {
        GlobalAutoGenDeserializerCache.a(OnionRewriteRule.class, new OnionRewriteRuleDeserializer());
        m9979e();
    }

    public OnionRewriteRuleDeserializer() {
        a(OnionRewriteRule.class);
    }

    private static synchronized Map<String, FbJsonField> m9979e() {
        Map<String, FbJsonField> map;
        synchronized (OnionRewriteRuleDeserializer.class) {
            if (f5059a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("matcher", FbJsonField.jsonField(OnionRewriteRule.class.getDeclaredField("matcher")));
                    builder.b("format", FbJsonField.jsonField(OnionRewriteRule.class.getDeclaredField("format")));
                    f5059a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f5059a;
        }
        return map;
    }

    public final FbJsonField m9980a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m9979e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m9979e().keySet());
    }
}
