package com.facebook.resources.impl.loading;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: PRIVACY */
public class LanguagePackInfoDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f12526a;

    static {
        GlobalAutoGenDeserializerCache.a(LanguagePackInfo.class, new LanguagePackInfoDeserializer());
        m12927e();
    }

    public LanguagePackInfoDeserializer() {
        a(LanguagePackInfo.class);
    }

    private static synchronized Map<String, FbJsonField> m12927e() {
        Map<String, FbJsonField> map;
        synchronized (LanguagePackInfoDeserializer.class) {
            if (f12526a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("download_url", FbJsonField.jsonField(LanguagePackInfo.class.getDeclaredField("downloadUrl")));
                    builder.b("download_checksum", FbJsonField.jsonField(LanguagePackInfo.class.getDeclaredField("checksum")));
                    builder.b("version_code", FbJsonField.jsonField(LanguagePackInfo.class.getDeclaredField("versionCode")));
                    builder.b("locale", FbJsonField.jsonField(LanguagePackInfo.class.getDeclaredField("locale")));
                    f12526a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f12526a;
        }
        return map;
    }

    public final FbJsonField m12928a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m12927e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m12927e().keySet());
    }
}
