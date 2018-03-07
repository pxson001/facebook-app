package com.facebook.feed.photoreminder.composer;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: admin_click_scheduled_post */
public class PhotoReminderPluginConfigDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f19768a;

    static {
        GlobalAutoGenDeserializerCache.a(PhotoReminderPluginConfig.class, new PhotoReminderPluginConfigDeserializer());
        m23028e();
    }

    public PhotoReminderPluginConfigDeserializer() {
        a(PhotoReminderPluginConfig.class);
    }

    private static synchronized Map<String, FbJsonField> m23028e() {
        Map<String, FbJsonField> map;
        synchronized (PhotoReminderPluginConfigDeserializer.class) {
            if (f19768a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("prompt_entry_point_analytics", FbJsonField.jsonField(PhotoReminderPluginConfig.class.getDeclaredField("mPromptAnalytics")));
                    f19768a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f19768a;
        }
        return map;
    }

    public final FbJsonField m23029a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m23028e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m23028e().keySet());
    }
}
