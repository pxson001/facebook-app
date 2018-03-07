package com.facebook.friendsharing.souvenirs.prompt.composer;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: REMOVE_ASSETS */
public class SouvenirPromptPluginConfigDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f24126a;

    static {
        GlobalAutoGenDeserializerCache.a(SouvenirPromptPluginConfig.class, new SouvenirPromptPluginConfigDeserializer());
        m26249e();
    }

    public SouvenirPromptPluginConfigDeserializer() {
        a(SouvenirPromptPluginConfig.class);
    }

    private static synchronized Map<String, FbJsonField> m26249e() {
        Map<String, FbJsonField> map;
        synchronized (SouvenirPromptPluginConfigDeserializer.class) {
            if (f24126a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("prompt_entry_point_analytics", FbJsonField.jsonField(SouvenirPromptPluginConfig.class.getDeclaredField("promptAnalytics")));
                    f24126a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f24126a;
        }
        return map;
    }

    public final FbJsonField m26250a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m26249e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m26249e().keySet());
    }
}
