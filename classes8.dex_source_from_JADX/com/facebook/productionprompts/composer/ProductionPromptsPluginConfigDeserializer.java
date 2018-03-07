package com.facebook.productionprompts.composer;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: request %d completed */
public class ProductionPromptsPluginConfigDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f4539a;

    static {
        GlobalAutoGenDeserializerCache.a(ProductionPromptsPluginConfig.class, new ProductionPromptsPluginConfigDeserializer());
        m4397e();
    }

    public ProductionPromptsPluginConfigDeserializer() {
        a(ProductionPromptsPluginConfig.class);
    }

    private static synchronized Map<String, FbJsonField> m4397e() {
        Map<String, FbJsonField> map;
        synchronized (ProductionPromptsPluginConfigDeserializer.class) {
            if (f4539a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("prompt", FbJsonField.jsonField(ProductionPromptsPluginConfig.class.getDeclaredField("mPrompt")));
                    builder.b("prompt_entry_point_analytics", FbJsonField.jsonField(ProductionPromptsPluginConfig.class.getDeclaredField("mPromptAnalytics")));
                    builder.b("is_prefilled", FbJsonField.jsonField(ProductionPromptsPluginConfig.class.getDeclaredField("mIsPrefilled")));
                    f4539a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f4539a;
        }
        return map;
    }

    public final FbJsonField m4398a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m4397e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m4397e().keySet());
    }
}
