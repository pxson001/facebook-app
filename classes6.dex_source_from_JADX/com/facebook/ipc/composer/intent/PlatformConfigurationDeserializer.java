package com.facebook.ipc.composer.intent;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: linear */
public class PlatformConfigurationDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f11591a;

    static {
        GlobalAutoGenDeserializerCache.a(PlatformConfiguration.class, new PlatformConfigurationDeserializer());
        m18278e();
    }

    public PlatformConfigurationDeserializer() {
        a(PlatformConfiguration.class);
    }

    private static synchronized Map<String, FbJsonField> m18278e() {
        Map<String, FbJsonField> map;
        synchronized (PlatformConfigurationDeserializer.class) {
            if (f11591a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("data_failures_fatal", FbJsonField.jsonField(PlatformConfiguration.class.getDeclaredField("dataFailuresFatal")));
                    builder.b("insights_platform_ref", FbJsonField.jsonField(PlatformConfiguration.class.getDeclaredField("insightsPlatformRef")));
                    builder.b("hashtag", FbJsonField.jsonField(PlatformConfiguration.class.getDeclaredField("hashtag")));
                    builder.b("og_action_json_for_robotext", FbJsonField.jsonField(PlatformConfiguration.class.getDeclaredField("ogActionJsonForRobotext")));
                    builder.b("og_action_type", FbJsonField.jsonField(PlatformConfiguration.class.getDeclaredField("ogActionType")));
                    builder.b("name_for_share_link", FbJsonField.jsonField(PlatformConfiguration.class.getDeclaredField("nameForShareLink")));
                    builder.b("caption_for_share_link", FbJsonField.jsonField(PlatformConfiguration.class.getDeclaredField("captionForShareLink")));
                    builder.b("picture_for_share_link", FbJsonField.jsonField(PlatformConfiguration.class.getDeclaredField("pictureForShareLink")));
                    builder.b("description_for_share_link", FbJsonField.jsonField(PlatformConfiguration.class.getDeclaredField("descriptionForShareLink")));
                    f11591a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f11591a;
        }
        return map;
    }

    public final FbJsonField m18279a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m18278e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m18278e().keySet());
    }
}
