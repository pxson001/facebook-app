package com.facebook.goodwill.composer;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: {notif_trigger} */
public class GoodwillFriendsBirthdayComposerPluginConfigDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f87a;

    static {
        GlobalAutoGenDeserializerCache.a(GoodwillFriendsBirthdayComposerPluginConfig.class, new GoodwillFriendsBirthdayComposerPluginConfigDeserializer());
        m111e();
    }

    public GoodwillFriendsBirthdayComposerPluginConfigDeserializer() {
        a(GoodwillFriendsBirthdayComposerPluginConfig.class);
    }

    private static synchronized Map<String, FbJsonField> m111e() {
        Map<String, FbJsonField> map;
        synchronized (GoodwillFriendsBirthdayComposerPluginConfigDeserializer.class) {
            if (f87a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("composer_hint", FbJsonField.jsonField(GoodwillFriendsBirthdayComposerPluginConfig.class.getDeclaredField("mComposerHint")));
                    f87a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f87a;
        }
        return map;
    }

    public final FbJsonField m112a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m111e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m111e().keySet());
    }
}
