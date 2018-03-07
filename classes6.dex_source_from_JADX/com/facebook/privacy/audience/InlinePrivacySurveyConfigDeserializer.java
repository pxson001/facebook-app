package com.facebook.privacy.audience;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: fetchReview */
public class InlinePrivacySurveyConfigDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f14974a;

    static {
        GlobalAutoGenDeserializerCache.a(InlinePrivacySurveyConfig.class, new InlinePrivacySurveyConfigDeserializer());
        m22576e();
    }

    public InlinePrivacySurveyConfigDeserializer() {
        a(InlinePrivacySurveyConfig.class);
    }

    private static synchronized Map<String, FbJsonField> m22576e() {
        Map<String, FbJsonField> map;
        synchronized (InlinePrivacySurveyConfigDeserializer.class) {
            if (f14974a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("eligible", FbJsonField.jsonField(InlinePrivacySurveyConfig.class.getDeclaredField("mEligible")));
                    builder.b("trigger_option", FbJsonField.jsonField(InlinePrivacySurveyConfig.class.getDeclaredField("mTriggerPrivacyOption")));
                    builder.b("first_option", FbJsonField.jsonField(InlinePrivacySurveyConfig.class.getDeclaredField("mFirstSurveyOption")));
                    builder.b("second_option", FbJsonField.jsonField(InlinePrivacySurveyConfig.class.getDeclaredField("mSecondSurveyOption")));
                    f14974a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f14974a;
        }
        return map;
    }

    public final FbJsonField m22577a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m22576e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m22576e().keySet());
    }
}
