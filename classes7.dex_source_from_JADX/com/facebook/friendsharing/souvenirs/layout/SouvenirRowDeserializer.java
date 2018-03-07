package com.facebook.friendsharing.souvenirs.layout;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.friendsharing.souvenirs.models.SouvenirItem;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: ReactionMoreSubComponentsQuery */
public class SouvenirRowDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f24049a;

    static {
        GlobalAutoGenDeserializerCache.a(SouvenirRow.class, new SouvenirRowDeserializer());
        m26149e();
    }

    public SouvenirRowDeserializer() {
        a(SouvenirRow.class);
    }

    private static synchronized Map<String, FbJsonField> m26149e() {
        Map<String, FbJsonField> map;
        synchronized (SouvenirRowDeserializer.class) {
            if (f24049a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("template", FbJsonField.jsonField(SouvenirRow.class.getDeclaredField("mTemplate")));
                    builder.b("items", FbJsonField.jsonField(SouvenirRow.class.getDeclaredField("mItems"), SouvenirItem.class));
                    f24049a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f24049a;
        }
        return map;
    }

    public final FbJsonField m26150a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m26149e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m26149e().keySet());
    }
}
