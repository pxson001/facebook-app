package com.facebook.friendsharing.souvenirs.models;

import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: RIDGE_BUTTON */
public class SouvenirRemoteItemDeserializer extends SouvenirUriItemDeserializer {
    private static Map<String, FbJsonField> f24074a;

    static {
        GlobalAutoGenDeserializerCache.a(SouvenirRemoteItem.class, new SouvenirRemoteItemDeserializer());
        m26196e();
    }

    public SouvenirRemoteItemDeserializer() {
        a(SouvenirRemoteItem.class);
    }

    private static synchronized Map<String, FbJsonField> m26196e() {
        Map<String, FbJsonField> map;
        synchronized (SouvenirRemoteItemDeserializer.class) {
            if (f24074a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("media_data", FbJsonField.jsonField(SouvenirRemoteItem.class.getDeclaredField("mMediaData")));
                    builder.b("model", FbJsonField.jsonField(SouvenirRemoteItem.class.getDeclaredField("mMediaModel")));
                    f24074a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f24074a;
        }
        return map;
    }

    public final FbJsonField mo1600a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m26196e().get(str);
        return fbJsonField != null ? fbJsonField : super.mo1600a(str);
    }

    public static Set<String> getJsonFields() {
        Set<String> b = Sets.b(m26196e().keySet());
        Collection jsonFields = SouvenirUriItemDeserializer.getJsonFields();
        if (jsonFields != null) {
            b.addAll(jsonFields);
        }
        return b;
    }
}
