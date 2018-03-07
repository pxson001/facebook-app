package com.facebook.photos.creativeediting.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: support_groups_icons */
public class TextParamsDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f3538a;

    static {
        GlobalAutoGenDeserializerCache.a(TextParams.class, new TextParamsDeserializer());
        m4740e();
    }

    public TextParamsDeserializer() {
        a(TextParams.class);
    }

    private static synchronized Map<String, FbJsonField> m4740e() {
        Map<String, FbJsonField> map;
        synchronized (TextParamsDeserializer.class) {
            if (f3538a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(TextParams.class.getDeclaredField("id")));
                    builder.b("uri", FbJsonField.jsonField(TextParams.class.getDeclaredField("uri")));
                    builder.b("text_string", FbJsonField.jsonField(TextParams.class.getDeclaredField("textString")));
                    builder.b("left", FbJsonField.jsonField(TextParams.class.getDeclaredField("leftPercentage")));
                    builder.b("top", FbJsonField.jsonField(TextParams.class.getDeclaredField("topPercentage")));
                    builder.b("width", FbJsonField.jsonField(TextParams.class.getDeclaredField("widthPercentage")));
                    builder.b("height", FbJsonField.jsonField(TextParams.class.getDeclaredField("heightPercentage")));
                    builder.b("rotation_degrees", FbJsonField.jsonField(TextParams.class.getDeclaredField("rotateDegrees")));
                    builder.b("text_color", FbJsonField.jsonField(TextParams.class.getDeclaredField("textColor")));
                    builder.b("isSelectable", FbJsonField.jsonField(TextParams.class.getDeclaredField("isSelectable")));
                    builder.b("isFrameItem", FbJsonField.jsonField(TextParams.class.getDeclaredField("isFrameItem")));
                    f3538a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f3538a;
        }
        return map;
    }

    public final FbJsonField m4741a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m4740e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m4740e().keySet());
    }
}
