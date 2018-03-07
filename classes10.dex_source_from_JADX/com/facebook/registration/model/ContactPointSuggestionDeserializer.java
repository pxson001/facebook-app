package com.facebook.registration.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: language_switcher_activity */
public class ContactPointSuggestionDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f8900a;

    static {
        GlobalAutoGenDeserializerCache.a(ContactPointSuggestion.class, new ContactPointSuggestionDeserializer());
        m8882e();
    }

    public ContactPointSuggestionDeserializer() {
        a(ContactPointSuggestion.class);
    }

    private static synchronized Map<String, FbJsonField> m8882e() {
        Map<String, FbJsonField> map;
        synchronized (ContactPointSuggestionDeserializer.class) {
            if (f8900a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("type", FbJsonField.jsonField(ContactPointSuggestion.class.getDeclaredField("contactPointTypeString")));
                    builder.b("value", FbJsonField.jsonField(ContactPointSuggestion.class.getDeclaredField("contactPoint")));
                    f8900a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f8900a;
        }
        return map;
    }

    public final FbJsonField m8883a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m8882e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m8882e().keySet());
    }
}
