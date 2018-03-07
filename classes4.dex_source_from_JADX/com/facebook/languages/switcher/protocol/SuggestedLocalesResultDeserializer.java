package com.facebook.languages.switcher.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.languages.switcher.protocol.SuggestedLocalesResult.LocaleModel;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: token_pool_size */
public class SuggestedLocalesResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f923a;

    static {
        GlobalAutoGenDeserializerCache.a(SuggestedLocalesResult.class, new SuggestedLocalesResultDeserializer());
        m1262e();
    }

    public SuggestedLocalesResultDeserializer() {
        a(SuggestedLocalesResult.class);
    }

    private static synchronized Map<String, FbJsonField> m1262e() {
        Map<String, FbJsonField> map;
        synchronized (SuggestedLocalesResultDeserializer.class) {
            if (f923a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("locales", FbJsonField.jsonField(SuggestedLocalesResult.class.getDeclaredField("locales"), LocaleModel.class));
                    f923a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f923a;
        }
        return map;
    }

    public final FbJsonField m1263a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m1262e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m1262e().keySet());
    }
}
