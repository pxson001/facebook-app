package com.facebook.ipc.composer.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: TIMELINE_HEADER_CARD */
public class MinutiaeTagDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f14001a;

    static {
        GlobalAutoGenDeserializerCache.a(MinutiaeTag.class, new MinutiaeTagDeserializer());
        m23385e();
    }

    public MinutiaeTagDeserializer() {
        a(MinutiaeTag.class);
    }

    private static synchronized Map<String, FbJsonField> m23385e() {
        Map<String, FbJsonField> map;
        synchronized (MinutiaeTagDeserializer.class) {
            if (f14001a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("og_action_type_id", FbJsonField.jsonField(MinutiaeTag.class.getDeclaredField("ogActionTypeId")));
                    builder.b("og_object_id", FbJsonField.jsonField(MinutiaeTag.class.getDeclaredField("ogObjectId")));
                    builder.b("og_phrase", FbJsonField.jsonField(MinutiaeTag.class.getDeclaredField("ogPhrase")));
                    builder.b("og_icon_id", FbJsonField.jsonField(MinutiaeTag.class.getDeclaredField("ogIconId")));
                    builder.b("oh_hide_attachment", FbJsonField.jsonField(MinutiaeTag.class.getDeclaredField("ogHideAttachment")));
                    builder.b("og_suggestion_mechanism", FbJsonField.jsonField(MinutiaeTag.class.getDeclaredField("ogSuggestionMechanism")));
                    f14001a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f14001a;
        }
        return map;
    }

    public final FbJsonField m23386a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m23385e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m23385e().keySet());
    }
}
