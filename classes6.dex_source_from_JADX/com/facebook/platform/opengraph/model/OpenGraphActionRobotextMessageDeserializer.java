package com.facebook.platform.opengraph.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: storage_constraint */
public class OpenGraphActionRobotextMessageDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f4103a;

    static {
        GlobalAutoGenDeserializerCache.a(OpenGraphActionRobotextMessage.class, new OpenGraphActionRobotextMessageDeserializer());
        m6018e();
    }

    public OpenGraphActionRobotextMessageDeserializer() {
        a(OpenGraphActionRobotextMessage.class);
    }

    private static synchronized Map<String, FbJsonField> m6018e() {
        Map<String, FbJsonField> map;
        synchronized (OpenGraphActionRobotextMessageDeserializer.class) {
            if (f4103a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("robotext", FbJsonField.jsonField(OpenGraphActionRobotextMessage.class.getDeclaredMethod("setRobotext", new Class[]{String.class})));
                    builder.b("robotext_tags", FbJsonField.jsonField(OpenGraphActionRobotextMessage.class.getDeclaredMethod("setRobotextTags", new Class[]{Map.class})));
                    f4103a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f4103a;
        }
        return map;
    }

    public final FbJsonField m6019a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m6018e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m6018e().keySet());
    }
}
