package com.facebook.transliteration.api;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: expected OggS capture pattern at begin of page */
public class TransliterationModelResponseDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f15152a;

    static {
        GlobalAutoGenDeserializerCache.a(TransliterationModelResponse.class, new TransliterationModelResponseDeserializer());
        m19149e();
    }

    public TransliterationModelResponseDeserializer() {
        a(TransliterationModelResponse.class);
    }

    private static synchronized Map<String, FbJsonField> m19149e() {
        Map<String, FbJsonField> map;
        synchronized (TransliterationModelResponseDeserializer.class) {
            if (f15152a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("dictionary", FbJsonField.jsonField(TransliterationModelResponse.class.getDeclaredField("mDictionary")));
                    builder.b("language_model", FbJsonField.jsonField(TransliterationModelResponse.class.getDeclaredField("mLanguageModel")));
                    builder.b("version", FbJsonField.jsonField(TransliterationModelResponse.class.getDeclaredField("mVersion")));
                    f15152a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f15152a;
        }
        return map;
    }

    public final FbJsonField m19150a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m19149e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m19149e().keySet());
    }
}
