package com.facebook.friendsharing.souvenirs.models;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: RKJSModules/Apps/Fb4a/Fb4aBundle */
public class SouvenirModelDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f24071a;

    static {
        GlobalAutoGenDeserializerCache.a(SouvenirModel.class, new SouvenirModelDeserializer());
        m26180e();
    }

    public SouvenirModelDeserializer() {
        a(SouvenirModel.class);
    }

    private static synchronized Map<String, FbJsonField> m26180e() {
        Map<String, FbJsonField> map;
        synchronized (SouvenirModelDeserializer.class) {
            if (f24071a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("metadata", FbJsonField.jsonField(SouvenirModel.class.getDeclaredField("mMetadata")));
                    builder.b("items", FbJsonField.jsonField(SouvenirModel.class.getDeclaredField("mItems"), SouvenirItem.class));
                    f24071a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f24071a;
        }
        return map;
    }

    public final FbJsonField m26181a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m26180e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m26180e().keySet());
    }
}
