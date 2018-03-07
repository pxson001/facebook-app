package com.facebook.transliteration.algorithms.unigram;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: external_session_id */
public class UnigramLanguageModelDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f15139a;

    static {
        GlobalAutoGenDeserializerCache.a(UnigramLanguageModel.class, new UnigramLanguageModelDeserializer());
        m19128e();
    }

    public UnigramLanguageModelDeserializer() {
        a(UnigramLanguageModel.class);
    }

    private static synchronized Map<String, FbJsonField> m19128e() {
        Map<String, FbJsonField> map;
        synchronized (UnigramLanguageModelDeserializer.class) {
            if (f15139a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("version", FbJsonField.jsonField(UnigramLanguageModel.class.getDeclaredField("mVersion")));
                    builder.b("locale", FbJsonField.jsonField(UnigramLanguageModel.class.getDeclaredField("mLocale")));
                    builder.b("model", FbJsonField.jsonField(UnigramLanguageModel.class.getDeclaredField("mModel")));
                    f15139a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f15139a;
        }
        return map;
    }

    public final FbJsonField m19129a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m19128e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m19128e().keySet());
    }
}
