package com.facebook.friendsharing.souvenirs.models;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: ROUTE_%08x */
public class SouvenirBurstItemDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f24058a;

    static {
        GlobalAutoGenDeserializerCache.a(SouvenirBurstItem.class, new SouvenirBurstItemDeserializer());
        m26159e();
    }

    public SouvenirBurstItemDeserializer() {
        a(SouvenirBurstItem.class);
    }

    private static synchronized Map<String, FbJsonField> m26159e() {
        Map<String, FbJsonField> map;
        synchronized (SouvenirBurstItemDeserializer.class) {
            if (f24058a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("photo_items", FbJsonField.jsonField(SouvenirBurstItem.class.getDeclaredField("mItems"), SouvenirPhotoItem.class));
                    builder.b("selected_index", FbJsonField.jsonField(SouvenirBurstItem.class.getDeclaredField("mSelectedIndex")));
                    f24058a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f24058a;
        }
        return map;
    }

    public final FbJsonField m26160a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m26159e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m26159e().keySet());
    }
}
