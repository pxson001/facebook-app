package com.facebook.friendsharing.souvenirs.models;

import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: RIFF */
public class SouvenirPhotoItemDeserializer extends SouvenirUriItemDeserializer {
    private static Map<String, FbJsonField> f24073a;

    static {
        GlobalAutoGenDeserializerCache.a(SouvenirPhotoItem.class, new SouvenirPhotoItemDeserializer());
        m26191e();
    }

    public SouvenirPhotoItemDeserializer() {
        a(SouvenirPhotoItem.class);
    }

    private static synchronized Map<String, FbJsonField> m26191e() {
        Map<String, FbJsonField> map;
        synchronized (SouvenirPhotoItemDeserializer.class) {
            if (f24073a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("media_data", FbJsonField.jsonField(SouvenirPhotoItem.class.getDeclaredField("mLocalMediaData")));
                    f24073a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f24073a;
        }
        return map;
    }

    public final FbJsonField mo1600a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m26191e().get(str);
        return fbJsonField != null ? fbJsonField : super.mo1600a(str);
    }

    public static Set<String> getJsonFields() {
        Set<String> b = Sets.b(m26191e().keySet());
        Collection jsonFields = SouvenirUriItemDeserializer.getJsonFields();
        if (jsonFields != null) {
            b.addAll(jsonFields);
        }
        return b;
    }
}
