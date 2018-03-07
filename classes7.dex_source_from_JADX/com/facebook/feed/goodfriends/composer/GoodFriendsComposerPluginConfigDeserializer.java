package com.facebook.feed.goodfriends.composer;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: animation */
public class GoodFriendsComposerPluginConfigDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f19219a;

    static {
        GlobalAutoGenDeserializerCache.a(GoodFriendsComposerPluginConfig.class, new GoodFriendsComposerPluginConfigDeserializer());
        m22736e();
    }

    public GoodFriendsComposerPluginConfigDeserializer() {
        a(GoodFriendsComposerPluginConfig.class);
    }

    private static synchronized Map<String, FbJsonField> m22736e() {
        Map<String, FbJsonField> map;
        synchronized (GoodFriendsComposerPluginConfigDeserializer.class) {
            if (f19219a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("composer_hint", FbJsonField.jsonField(GoodFriendsComposerPluginConfig.class.getDeclaredField("mComposerHint")));
                    f19219a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f19219a;
        }
        return map;
    }

    public final FbJsonField m22737a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m22736e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m22736e().keySet());
    }
}
