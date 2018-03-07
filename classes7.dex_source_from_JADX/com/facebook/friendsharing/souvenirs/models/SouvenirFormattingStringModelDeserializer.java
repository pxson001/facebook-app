package com.facebook.friendsharing.souvenirs.models;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: ROTATION */
public class SouvenirFormattingStringModelDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f24060a;

    static {
        GlobalAutoGenDeserializerCache.a(SouvenirFormattingStringModel.class, new SouvenirFormattingStringModelDeserializer());
        m26162e();
    }

    public SouvenirFormattingStringModelDeserializer() {
        a(SouvenirFormattingStringModel.class);
    }

    private static synchronized Map<String, FbJsonField> m26162e() {
        Map<String, FbJsonField> map;
        synchronized (SouvenirFormattingStringModelDeserializer.class) {
            if (f24060a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("name", FbJsonField.jsonField(SouvenirFormattingStringModel.class.getDeclaredField("name")));
                    builder.b("assetCount", FbJsonField.jsonField(SouvenirFormattingStringModel.class.getDeclaredField("assetCount")));
                    f24060a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f24060a;
        }
        return map;
    }

    public final FbJsonField m26163a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m26162e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m26162e().keySet());
    }
}
