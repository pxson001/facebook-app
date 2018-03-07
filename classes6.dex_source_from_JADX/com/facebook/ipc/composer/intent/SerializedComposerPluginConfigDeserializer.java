package com.facebook.ipc.composer.intent;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: lightweight_place_picker_place_picked */
public class SerializedComposerPluginConfigDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f11592a;

    static {
        GlobalAutoGenDeserializerCache.a(SerializedComposerPluginConfig.class, new SerializedComposerPluginConfigDeserializer());
        m18285e();
    }

    public SerializedComposerPluginConfigDeserializer() {
        a(SerializedComposerPluginConfig.class);
    }

    private static synchronized Map<String, FbJsonField> m18285e() {
        Map<String, FbJsonField> map;
        synchronized (SerializedComposerPluginConfigDeserializer.class) {
            if (f11592a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("persist_key", FbJsonField.jsonField(SerializedComposerPluginConfig.class.getDeclaredField("mPersistenceKey")));
                    builder.b("data", FbJsonField.jsonField(SerializedComposerPluginConfig.class.getDeclaredField("mData")));
                    f11592a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f11592a;
        }
        return map;
    }

    public final FbJsonField m18286a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m18285e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m18285e().keySet());
    }
}
