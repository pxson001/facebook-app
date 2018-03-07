package com.facebook.feedback.reactions.ui.deserializers;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.reactionsanimations.data.ReactionsGradient;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: gu_IN */
public class ReactionsGradientDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f21445a;

    public ReactionsGradientDeserializer() {
        m13809a(ReactionsGradient.class);
    }

    static {
        m29172e();
    }

    private static synchronized Map<String, FbJsonField> m29172e() {
        Map<String, FbJsonField> map;
        synchronized (ReactionsGradientDeserializer.class) {
            if (f21445a == null) {
                try {
                    Builder builder = new Builder();
                    builder.m609b("color_start", FbJsonField.jsonField(ReactionsGradient.class.getDeclaredField("mColorStart")));
                    builder.m609b("color_end", FbJsonField.jsonField(ReactionsGradient.class.getDeclaredField("mColorEnd")));
                    f21445a = builder.m610b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f21445a;
        }
        return map;
    }

    public final FbJsonField mo1880a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m29172e().get(str);
        return fbJsonField != null ? fbJsonField : super.mo1880a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.m1324b(m29172e().keySet());
    }
}
