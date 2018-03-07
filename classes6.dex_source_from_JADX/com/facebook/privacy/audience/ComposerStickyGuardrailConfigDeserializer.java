package com.facebook.privacy.audience;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: fetchShare */
public class ComposerStickyGuardrailConfigDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f14973a;

    static {
        GlobalAutoGenDeserializerCache.a(ComposerStickyGuardrailConfig.class, new ComposerStickyGuardrailConfigDeserializer());
        m22574e();
    }

    public ComposerStickyGuardrailConfigDeserializer() {
        a(ComposerStickyGuardrailConfig.class);
    }

    private static synchronized Map<String, FbJsonField> m22574e() {
        Map<String, FbJsonField> map;
        synchronized (ComposerStickyGuardrailConfigDeserializer.class) {
            if (f14973a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("eligible", FbJsonField.jsonField(ComposerStickyGuardrailConfig.class.getDeclaredField("mEligible")));
                    builder.b("current_privacy_option", FbJsonField.jsonField(ComposerStickyGuardrailConfig.class.getDeclaredField("mCurrentPrivacyOption")));
                    builder.b("suggested_privacy_option", FbJsonField.jsonField(ComposerStickyGuardrailConfig.class.getDeclaredField("mSuggestedPrivacyOption")));
                    builder.b("suggestion_timestamp", FbJsonField.jsonField(ComposerStickyGuardrailConfig.class.getDeclaredField("mSuggestedTime")));
                    builder.b("config_updated_time", FbJsonField.jsonField(ComposerStickyGuardrailConfig.class.getDeclaredField("mUpdatedTime")));
                    f14973a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f14973a;
        }
        return map;
    }

    public final FbJsonField m22575a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m22574e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m22574e().keySet());
    }
}
