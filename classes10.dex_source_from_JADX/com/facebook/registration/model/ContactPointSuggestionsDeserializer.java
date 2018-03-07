package com.facebook.registration.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: landing_page */
public class ContactPointSuggestionsDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f8902a;

    static {
        GlobalAutoGenDeserializerCache.a(ContactPointSuggestions.class, new ContactPointSuggestionsDeserializer());
        m8887e();
    }

    public ContactPointSuggestionsDeserializer() {
        a(ContactPointSuggestions.class);
    }

    private static synchronized Map<String, FbJsonField> m8887e() {
        Map<String, FbJsonField> map;
        synchronized (ContactPointSuggestionsDeserializer.class) {
            if (f8902a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("prefill", FbJsonField.jsonField(ContactPointSuggestions.class.getDeclaredField("prefillContactPoints"), ContactPointSuggestion.class));
                    builder.b("autocomplete", FbJsonField.jsonField(ContactPointSuggestions.class.getDeclaredField("autocompleteContactPoints"), ContactPointSuggestion.class));
                    f8902a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f8902a;
        }
        return map;
    }

    public final FbJsonField m8888a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m8887e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m8887e().keySet());
    }
}
