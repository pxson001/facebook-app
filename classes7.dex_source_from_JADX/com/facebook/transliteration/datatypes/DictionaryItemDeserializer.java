package com.facebook.transliteration.datatypes;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: everything */
public class DictionaryItemDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f15179a;

    static {
        GlobalAutoGenDeserializerCache.a(DictionaryItem.class, new DictionaryItemDeserializer());
        m19187e();
    }

    public DictionaryItemDeserializer() {
        a(DictionaryItem.class);
    }

    private static synchronized Map<String, FbJsonField> m19187e() {
        Map<String, FbJsonField> map;
        synchronized (DictionaryItemDeserializer.class) {
            if (f15179a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("dictionary", FbJsonField.jsonField(DictionaryItem.class.getDeclaredField("mDictionary")));
                    f15179a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f15179a;
        }
        return map;
    }

    public final FbJsonField m19188a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m19187e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m19187e().keySet());
    }
}
