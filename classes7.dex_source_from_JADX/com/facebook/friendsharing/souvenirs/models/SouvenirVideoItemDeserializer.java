package com.facebook.friendsharing.souvenirs.models;

import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: RETRY */
public class SouvenirVideoItemDeserializer extends SouvenirUriItemDeserializer {
    private static Map<String, FbJsonField> f24075a;

    static {
        GlobalAutoGenDeserializerCache.a(SouvenirVideoItem.class, new SouvenirVideoItemDeserializer());
        m26205e();
    }

    public SouvenirVideoItemDeserializer() {
        a(SouvenirVideoItem.class);
    }

    private static synchronized Map<String, FbJsonField> m26205e() {
        Map<String, FbJsonField> map;
        synchronized (SouvenirVideoItemDeserializer.class) {
            if (f24075a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("media_data", FbJsonField.jsonField(SouvenirVideoItem.class.getDeclaredField("mLocalMediaData")));
                    builder.b("duration", FbJsonField.jsonField(SouvenirVideoItem.class.getDeclaredField("mDurationMsecs")));
                    f24075a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f24075a;
        }
        return map;
    }

    public final FbJsonField mo1600a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m26205e().get(str);
        return fbJsonField != null ? fbJsonField : super.mo1600a(str);
    }

    public static Set<String> getJsonFields() {
        Set<String> b = Sets.b(m26205e().keySet());
        Collection jsonFields = SouvenirUriItemDeserializer.getJsonFields();
        if (jsonFields != null) {
            b.addAll(jsonFields);
        }
        return b;
    }
}
