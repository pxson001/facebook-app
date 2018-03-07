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

/* compiled from: togglePlaceParamsKey */
public class SuggestedLocalesResult_LocaleModelDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f927a;

    static {
        GlobalAutoGenDeserializerCache.a(LocaleModel.class, new SuggestedLocalesResult_LocaleModelDeserializer());
        m1265e();
    }

    public SuggestedLocalesResult_LocaleModelDeserializer() {
        a(LocaleModel.class);
    }

    private static synchronized Map<String, FbJsonField> m1265e() {
        Map<String, FbJsonField> map;
        synchronized (SuggestedLocalesResult_LocaleModelDeserializer.class) {
            if (f927a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("locale", FbJsonField.jsonField(LocaleModel.class.getDeclaredField("locale")));
                    f927a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f927a;
        }
        return map;
    }

    public final FbJsonField m1266a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m1265e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m1265e().keySet());
    }
}
