package com.facebook.composer.savedsession;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: filtering out invalid TypeaheadPlace result */
public class ComposerInstanceTracker_ComposerInstanceDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f6913a;

    static {
        GlobalAutoGenDeserializerCache.a(ComposerInstance.class, new ComposerInstanceTracker_ComposerInstanceDeserializer());
        m8231e();
    }

    public ComposerInstanceTracker_ComposerInstanceDeserializer() {
        a(ComposerInstance.class);
    }

    private static synchronized Map<String, FbJsonField> m8231e() {
        Map<String, FbJsonField> map;
        synchronized (ComposerInstanceTracker_ComposerInstanceDeserializer.class) {
            if (f6913a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("start_time", FbJsonField.jsonField(ComposerInstance.class.getDeclaredField("startTime")));
                    builder.b("configuration", FbJsonField.jsonField(ComposerInstance.class.getDeclaredField("configuration")));
                    builder.b("last_saved_session", FbJsonField.jsonField(ComposerInstance.class.getDeclaredField("lastSavedSession")));
                    f6913a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f6913a;
        }
        return map;
    }

    public final FbJsonField m8232a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m8231e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m8231e().keySet());
    }
}
