package com.facebook.zero.sdk.rewrite;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: com.android.internal.os.PowerProfile */
public class ZeroUrlRewriteRuleDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f5906a;

    static {
        GlobalAutoGenDeserializerCache.a(ZeroUrlRewriteRule.class, new ZeroUrlRewriteRuleDeserializer());
        m10702e();
    }

    public ZeroUrlRewriteRuleDeserializer() {
        a(ZeroUrlRewriteRule.class);
    }

    private static synchronized Map<String, FbJsonField> m10702e() {
        Map<String, FbJsonField> map;
        synchronized (ZeroUrlRewriteRuleDeserializer.class) {
            if (f5906a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("matcher", FbJsonField.jsonField(ZeroUrlRewriteRule.class.getDeclaredField("mMatcher")));
                    builder.b("replacer", FbJsonField.jsonField(ZeroUrlRewriteRule.class.getDeclaredField("mReplacer")));
                    f5906a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f5906a;
        }
        return map;
    }

    public final FbJsonField m10703a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m10702e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m10702e().keySet());
    }
}
