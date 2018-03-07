package com.facebook.ipc.composer.intent;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: link_for_share */
public class ComposerTargetDataDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f11580a;

    static {
        GlobalAutoGenDeserializerCache.a(ComposerTargetData.class, new ComposerTargetDataDeserializer());
        m18267e();
    }

    public ComposerTargetDataDeserializer() {
        a(ComposerTargetData.class);
    }

    private static synchronized Map<String, FbJsonField> m18267e() {
        Map<String, FbJsonField> map;
        synchronized (ComposerTargetDataDeserializer.class) {
            if (f11580a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("target_id", FbJsonField.jsonField(ComposerTargetData.class.getDeclaredField("targetId")));
                    builder.b("target_type", FbJsonField.jsonField(ComposerTargetData.class.getDeclaredField("targetType")));
                    builder.b("target_name", FbJsonField.jsonField(ComposerTargetData.class.getDeclaredField("targetName")));
                    builder.b("target_profile_pic_url", FbJsonField.jsonField(ComposerTargetData.class.getDeclaredField("targetProfilePicUrl")));
                    builder.b("target_privacy", FbJsonField.jsonField(ComposerTargetData.class.getDeclaredField("targetPrivacy")));
                    builder.b("acts_as_target", FbJsonField.jsonField(ComposerTargetData.class.getDeclaredField("actsAsTarget")));
                    f11580a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f11580a;
        }
        return map;
    }

    public final FbJsonField m18268a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m18267e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m18267e().keySet());
    }
}
