package com.facebook.feedback.reactions.ui.deserializers;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.reactionsanimations.data.ReactionsColorFrame;
import com.facebook.reactionsanimations.data.ReactionsGradientColor;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: guava.concurrent.generate_cancellation_cause */
public class ReactionsGradientColorDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f21444a;

    public ReactionsGradientColorDeserializer() {
        m13809a(ReactionsGradientColor.class);
    }

    static {
        m29170e();
    }

    private static synchronized Map<String, FbJsonField> m29170e() {
        Map<String, FbJsonField> map;
        synchronized (ReactionsGradientColorDeserializer.class) {
            if (f21444a == null) {
                try {
                    Builder builder = new Builder();
                    builder.m609b("key_values", FbJsonField.jsonField(ReactionsGradientColor.class.getDeclaredField("mKeyValues"), ReactionsColorFrame.class));
                    builder.m609b("timing_curves", FbJsonField.jsonField(ReactionsGradientColor.class.getDeclaredField("mTimingCurves")));
                    f21444a = builder.m610b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f21444a;
        }
        return map;
    }

    public final FbJsonField mo1880a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m29170e().get(str);
        return fbJsonField != null ? fbJsonField : super.mo1880a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.m1324b(m29170e().keySet());
    }
}
