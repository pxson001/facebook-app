package com.facebook.productionprompts.logging;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: start_offset */
public class PromptAnalyticsDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f4229a;

    static {
        GlobalAutoGenDeserializerCache.a(PromptAnalytics.class, new PromptAnalyticsDeserializer());
        m6270e();
    }

    public PromptAnalyticsDeserializer() {
        a(PromptAnalytics.class);
    }

    private static synchronized Map<String, FbJsonField> m6270e() {
        Map<String, FbJsonField> map;
        synchronized (PromptAnalyticsDeserializer.class) {
            if (f4229a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("prompt_id", FbJsonField.jsonField(PromptAnalytics.class.getDeclaredField("promptId")));
                    builder.b("prompt_type", FbJsonField.jsonField(PromptAnalytics.class.getDeclaredField("promptType")));
                    builder.b("prompt_session_id", FbJsonField.jsonField(PromptAnalytics.class.getDeclaredField("promptSessionId")));
                    builder.b("composer_session_id", FbJsonField.jsonField(PromptAnalytics.class.getDeclaredField("composerSessionId")));
                    builder.b("tracking_string", FbJsonField.jsonField(PromptAnalytics.class.getDeclaredField("trackingString")));
                    builder.b("prompt_view_state", FbJsonField.jsonField(PromptAnalytics.class.getDeclaredField("promptViewState")));
                    f4229a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f4229a;
        }
        return map;
    }

    public final FbJsonField m6271a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m6270e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m6270e().keySet());
    }
}
