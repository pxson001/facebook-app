package com.facebook.privacy.nux;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: fbids */
public class SmallAudiencePrivacyNuxConfigDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f15128a;

    static {
        GlobalAutoGenDeserializerCache.a(SmallAudiencePrivacyNuxConfig.class, new SmallAudiencePrivacyNuxConfigDeserializer());
        m22719e();
    }

    public SmallAudiencePrivacyNuxConfigDeserializer() {
        a(SmallAudiencePrivacyNuxConfig.class);
    }

    private static synchronized Map<String, FbJsonField> m22719e() {
        Map<String, FbJsonField> map;
        synchronized (SmallAudiencePrivacyNuxConfigDeserializer.class) {
            if (f15128a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("included_count", FbJsonField.jsonField(SmallAudiencePrivacyNuxConfig.class.getDeclaredField("includedCount")));
                    builder.b("previous_privacy", FbJsonField.jsonField(SmallAudiencePrivacyNuxConfig.class.getDeclaredField("previousPrivacy")));
                    f15128a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f15128a;
        }
        return map;
    }

    public final FbJsonField m22720a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m22719e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m22719e().keySet());
    }
}
