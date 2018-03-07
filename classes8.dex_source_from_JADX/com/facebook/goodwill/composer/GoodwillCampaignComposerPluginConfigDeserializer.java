package com.facebook.goodwill.composer;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: {reaction_session_id} */
public class GoodwillCampaignComposerPluginConfigDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f48a;

    static {
        GlobalAutoGenDeserializerCache.a(GoodwillCampaignComposerPluginConfig.class, new GoodwillCampaignComposerPluginConfigDeserializer());
        m56e();
    }

    public GoodwillCampaignComposerPluginConfigDeserializer() {
        a(GoodwillCampaignComposerPluginConfig.class);
    }

    private static synchronized Map<String, FbJsonField> m56e() {
        Map<String, FbJsonField> map;
        synchronized (GoodwillCampaignComposerPluginConfigDeserializer.class) {
            if (f48a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("composer_hint", FbJsonField.jsonField(GoodwillCampaignComposerPluginConfig.class.getDeclaredField("mComposerHint")));
                    builder.b("composer_title", FbJsonField.jsonField(GoodwillCampaignComposerPluginConfig.class.getDeclaredField("mComposerTitle")));
                    f48a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f48a;
        }
        return map;
    }

    public final FbJsonField m57a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m56e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m56e().keySet());
    }
}
