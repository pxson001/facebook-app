package com.facebook.composer.publish.common.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.composer.publish.common.model.ComposerSessionLoggingData.Builder;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: activity */
public class ComposerSessionLoggingData_BuilderDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f11598a;

    static {
        GlobalAutoGenDeserializerCache.a(Builder.class, new ComposerSessionLoggingData_BuilderDeserializer());
        m19725e();
    }

    public ComposerSessionLoggingData_BuilderDeserializer() {
        a(Builder.class);
    }

    private static synchronized Map<String, FbJsonField> m19725e() {
        Map<String, FbJsonField> map;
        synchronized (ComposerSessionLoggingData_BuilderDeserializer.class) {
            if (f11598a == null) {
                try {
                    ImmutableMap.Builder builder = new ImmutableMap.Builder();
                    builder.b("composition_duration", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setCompositionDuration", new Class[]{Long.TYPE})));
                    builder.b("number_of_copy_pastes", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setNumberOfCopyPastes", new Class[]{Integer.TYPE})));
                    builder.b("number_of_keystrokes", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setNumberOfKeystrokes", new Class[]{Integer.TYPE})));
                    f11598a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f11598a;
        }
        return map;
    }

    public final FbJsonField m19726a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m19725e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m19725e().keySet());
    }
}
