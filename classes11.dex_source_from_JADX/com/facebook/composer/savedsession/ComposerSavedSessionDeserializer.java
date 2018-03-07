package com.facebook.composer.savedsession;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: fetch_single_page_service */
public class ComposerSavedSessionDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f6936a;

    static {
        GlobalAutoGenDeserializerCache.a(ComposerSavedSession.class, new ComposerSavedSessionDeserializer());
        m8253e();
    }

    public ComposerSavedSessionDeserializer() {
        a(ComposerSavedSession.class);
    }

    private static synchronized Map<String, FbJsonField> m8253e() {
        Map<String, FbJsonField> map;
        synchronized (ComposerSavedSessionDeserializer.class) {
            if (f6936a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("version", FbJsonField.jsonField(ComposerSavedSession.class.getDeclaredField("version")));
                    builder.b("creation_time_ms", FbJsonField.jsonField(ComposerSavedSession.class.getDeclaredField("creationTimeMs")));
                    builder.b("load_attempts", FbJsonField.jsonField(ComposerSavedSession.class.getDeclaredField("loadAttempts")));
                    builder.b("session_id", FbJsonField.jsonField(ComposerSavedSession.class.getDeclaredField("sessionId")));
                    builder.b("configuration", FbJsonField.jsonField(ComposerSavedSession.class.getDeclaredField("configuration")));
                    builder.b("composition", FbJsonField.jsonField(ComposerSavedSession.class.getDeclaredField("composition")));
                    builder.b("viewer_coordinates", FbJsonField.jsonField(ComposerSavedSession.class.getDeclaredField("viewerCoordinates")));
                    builder.b("target_data", FbJsonField.jsonField(ComposerSavedSession.class.getDeclaredField("targetData")));
                    builder.b("page_data", FbJsonField.jsonField(ComposerSavedSession.class.getDeclaredField("pageData")));
                    builder.b("privacy_override", FbJsonField.jsonField(ComposerSavedSession.class.getDeclaredField("privacyOverride")));
                    builder.b("photos_enabled", FbJsonField.jsonField(ComposerSavedSession.class.getDeclaredField("photosEnabled")));
                    builder.b("privacy_has_changed", FbJsonField.jsonField(ComposerSavedSession.class.getDeclaredField("privacyHasChanged")));
                    builder.b("plugin_state", FbJsonField.jsonField(ComposerSavedSession.class.getDeclaredField("pluginState")));
                    f6936a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f6936a;
        }
        return map;
    }

    public final FbJsonField m8254a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m8253e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m8253e().keySet());
    }
}
