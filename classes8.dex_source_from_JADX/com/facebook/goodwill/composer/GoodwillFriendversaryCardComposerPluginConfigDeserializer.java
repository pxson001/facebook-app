package com.facebook.goodwill.composer;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: {coupon_id} */
public class GoodwillFriendversaryCardComposerPluginConfigDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f97a;

    static {
        GlobalAutoGenDeserializerCache.a(GoodwillFriendversaryCardComposerPluginConfig.class, new GoodwillFriendversaryCardComposerPluginConfigDeserializer());
        m132e();
    }

    public GoodwillFriendversaryCardComposerPluginConfigDeserializer() {
        a(GoodwillFriendversaryCardComposerPluginConfig.class);
    }

    private static synchronized Map<String, FbJsonField> m132e() {
        Map<String, FbJsonField> map;
        synchronized (GoodwillFriendversaryCardComposerPluginConfigDeserializer.class) {
            if (f97a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("campaign_id", FbJsonField.jsonField(GoodwillFriendversaryCardComposerPluginConfig.class.getDeclaredField("mCampaignId")));
                    builder.b("source", FbJsonField.jsonField(GoodwillFriendversaryCardComposerPluginConfig.class.getDeclaredField("mSource")));
                    builder.b("media_ids", FbJsonField.jsonField(GoodwillFriendversaryCardComposerPluginConfig.class.getDeclaredField("mMediaIds"), String.class));
                    f97a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f97a;
        }
        return map;
    }

    public final FbJsonField m133a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m132e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m132e().keySet());
    }
}
