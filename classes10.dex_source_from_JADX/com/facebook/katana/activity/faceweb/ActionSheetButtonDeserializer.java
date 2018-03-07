package com.facebook.katana.activity.faceweb;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: user refresh */
public class ActionSheetButtonDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f730a;

    static {
        GlobalAutoGenDeserializerCache.a(ActionSheetButton.class, new ActionSheetButtonDeserializer());
        m741e();
    }

    public ActionSheetButtonDeserializer() {
        a(ActionSheetButton.class);
    }

    private static synchronized Map<String, FbJsonField> m741e() {
        Map<String, FbJsonField> map;
        synchronized (ActionSheetButtonDeserializer.class) {
            if (f730a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("title", FbJsonField.jsonField(ActionSheetButton.class.getDeclaredField("title")));
                    builder.b("callback", FbJsonField.jsonField(ActionSheetButton.class.getDeclaredField("callback")));
                    builder.b("type", FbJsonField.jsonField(ActionSheetButton.class.getDeclaredField("type")));
                    f730a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f730a;
        }
        return map;
    }

    public final FbJsonField m742a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m741e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m741e().keySet());
    }
}
