package com.facebook.transliteration.algorithms.unigram;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: expiry */
public class UnigramModelDataItemDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f15143a;

    static {
        GlobalAutoGenDeserializerCache.a(UnigramModelDataItem.class, new UnigramModelDataItemDeserializer());
        m19136e();
    }

    public UnigramModelDataItemDeserializer() {
        a(UnigramModelDataItem.class);
    }

    private static synchronized Map<String, FbJsonField> m19136e() {
        Map<String, FbJsonField> map;
        synchronized (UnigramModelDataItemDeserializer.class) {
            if (f15143a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("standard", FbJsonField.jsonField(UnigramModelDataItem.class.getDeclaredField("mStandardEmission")));
                    builder.b("emissions", FbJsonField.jsonField(UnigramModelDataItem.class.getDeclaredField("mEmissions")));
                    f15143a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f15143a;
        }
        return map;
    }

    public final FbJsonField m19137a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m19136e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m19136e().keySet());
    }
}
