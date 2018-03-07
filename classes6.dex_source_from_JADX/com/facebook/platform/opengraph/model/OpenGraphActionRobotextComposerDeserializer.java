package com.facebook.platform.opengraph.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: store_sticker_matches_shown */
public class OpenGraphActionRobotextComposerDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f4102a;

    static {
        GlobalAutoGenDeserializerCache.a(OpenGraphActionRobotextComposer.class, new OpenGraphActionRobotextComposerDeserializer());
        m6016e();
    }

    public OpenGraphActionRobotextComposerDeserializer() {
        a(OpenGraphActionRobotextComposer.class);
    }

    private static synchronized Map<String, FbJsonField> m6016e() {
        Map<String, FbJsonField> map;
        synchronized (OpenGraphActionRobotextComposerDeserializer.class) {
            if (f4102a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("description", FbJsonField.jsonField(OpenGraphActionRobotextComposer.class.getDeclaredMethod("setDescription", new Class[]{String.class})));
                    builder.b("description_tags", FbJsonField.jsonField(OpenGraphActionRobotextComposer.class.getDeclaredMethod("setDescriptionTags", new Class[]{Map.class})));
                    f4102a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f4102a;
        }
        return map;
    }

    public final FbJsonField m6017a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m6016e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m6016e().keySet());
    }
}
