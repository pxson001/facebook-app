package com.facebook.greetingcards.verve.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: viewer_context_util_fetched */
public class VMViewDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f345a;

    static {
        GlobalAutoGenDeserializerCache.a(VMView.class, new VMViewDeserializer());
        m309e();
    }

    public VMViewDeserializer() {
        a(VMView.class);
    }

    private static synchronized Map<String, FbJsonField> m309e() {
        Map<String, FbJsonField> map;
        synchronized (VMViewDeserializer.class) {
            if (f345a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("name", FbJsonField.jsonField(VMView.class.getDeclaredField("name")));
                    builder.b("size", FbJsonField.jsonField(VMView.class.getDeclaredField("size"), Float.class));
                    builder.b("position", FbJsonField.jsonField(VMView.class.getDeclaredField("position"), Float.class));
                    builder.b("anchor", FbJsonField.jsonField(VMView.class.getDeclaredField("anchor"), Float.class));
                    builder.b("type", FbJsonField.jsonField(VMView.class.getDeclaredField("mType")));
                    builder.b("rotation", FbJsonField.jsonField(VMView.class.getDeclaredField("rotation")));
                    builder.b("opacity", FbJsonField.jsonField(VMView.class.getDeclaredField("opacity")));
                    builder.b("src", FbJsonField.jsonField(VMView.class.getDeclaredField("src")));
                    builder.b("placeholder-src", FbJsonField.jsonField(VMView.class.getDeclaredField("placeholderSrc")));
                    builder.b("resize", FbJsonField.jsonField(VMView.class.getDeclaredField("resize")));
                    builder.b("fill-color", FbJsonField.jsonField(VMView.class.getDeclaredField("fillColor")));
                    builder.b("placeholder-color", FbJsonField.jsonField(VMView.class.getDeclaredField("placeholderColor")));
                    builder.b("subviews", FbJsonField.jsonField(VMView.class.getDeclaredField("subviews"), VMView.class));
                    builder.b("states", FbJsonField.jsonField(VMView.class.getDeclaredField("statesMap")));
                    builder.b("text", FbJsonField.jsonField(VMView.class.getDeclaredField("text")));
                    builder.b("font-size", FbJsonField.jsonField(VMView.class.getDeclaredField("fontSize")));
                    builder.b("font", FbJsonField.jsonField(VMView.class.getDeclaredField("font")));
                    builder.b("shadow-color", FbJsonField.jsonField(VMView.class.getDeclaredField("shadowColor")));
                    builder.b("shadow-radius", FbJsonField.jsonField(VMView.class.getDeclaredField("shadowRadius")));
                    builder.b("shadow-offset", FbJsonField.jsonField(VMView.class.getDeclaredField("shadowOffset"), Float.class));
                    builder.b("alignment", FbJsonField.jsonField(VMView.class.getDeclaredField("alignment")));
                    builder.b("v-alignment", FbJsonField.jsonField(VMView.class.getDeclaredField("vAlignment")));
                    builder.b("value-name", FbJsonField.jsonField(VMView.class.getDeclaredField("valueName")));
                    builder.b("style", FbJsonField.jsonField(VMView.class.getDeclaredField("styleName")));
                    builder.b("title", FbJsonField.jsonField(VMView.class.getDeclaredField("title")));
                    builder.b("button-style", FbJsonField.jsonField(VMView.class.getDeclaredField("buttonStyle")));
                    builder.b("button-size", FbJsonField.jsonField(VMView.class.getDeclaredField("buttonSize")));
                    builder.b("actions", FbJsonField.jsonField(VMView.class.getDeclaredField("actionsMap")));
                    builder.b("duration", FbJsonField.jsonField(VMView.class.getDeclaredField("duration")));
                    builder.b("line-break", FbJsonField.jsonField(VMView.class.getDeclaredField("lineBreak")));
                    f345a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f345a;
        }
        return map;
    }

    public final FbJsonField m310a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m309e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m309e().keySet());
    }
}
