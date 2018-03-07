package com.facebook.ipc.composer.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.ipc.composer.model.ComposerLaunchLoggingParams.Builder;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: TOBACCO_COMPANY */
public class ComposerLaunchLoggingParams_BuilderDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f13957a;

    static {
        GlobalAutoGenDeserializerCache.a(Builder.class, new ComposerLaunchLoggingParams_BuilderDeserializer());
        m23315e();
    }

    public ComposerLaunchLoggingParams_BuilderDeserializer() {
        a(Builder.class);
    }

    private static synchronized Map<String, FbJsonField> m23315e() {
        Map<String, FbJsonField> map;
        synchronized (ComposerLaunchLoggingParams_BuilderDeserializer.class) {
            if (f13957a == null) {
                try {
                    ImmutableMap.Builder builder = new ImmutableMap.Builder();
                    builder.b("entry_picker", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setEntryPicker", new Class[]{ComposerEntryPicker.class})));
                    builder.b("entry_point_description", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setEntryPointDescription", new Class[]{String.class})));
                    builder.b("source_surface", FbJsonField.jsonField(Builder.class.getDeclaredMethod("setSourceSurface", new Class[]{ComposerSourceSurface.class})));
                    f13957a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f13957a;
        }
        return map;
    }

    public final FbJsonField m23316a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m23315e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m23315e().keySet());
    }
}
