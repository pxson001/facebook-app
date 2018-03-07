package com.facebook.feedback.reactions.ui.deserializers;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.reactionsanimations.data.ReactionsAnimation;
import com.facebook.reactionsanimations.data.ReactionsAnimationFrame;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: hard_nag */
public class ReactionsAnimationDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f21418a;

    public ReactionsAnimationDeserializer() {
        m13809a(ReactionsAnimation.class);
    }

    static {
        m29139e();
    }

    private static synchronized Map<String, FbJsonField> m29139e() {
        Map<String, FbJsonField> map;
        synchronized (ReactionsAnimationDeserializer.class) {
            if (f21418a == null) {
                try {
                    Builder builder = new Builder();
                    builder.m609b("property", FbJsonField.jsonField(ReactionsAnimation.class.getDeclaredField("mPropertyType")));
                    builder.m609b("key_values", FbJsonField.jsonField(ReactionsAnimation.class.getDeclaredField("mAnimationFrames"), ReactionsAnimationFrame.class));
                    builder.m609b("timing_curves", FbJsonField.jsonField(ReactionsAnimation.class.getDeclaredField("mTimingCurves")));
                    builder.m609b("anchor", FbJsonField.jsonField(ReactionsAnimation.class.getDeclaredField("mAnchor")));
                    f21418a = builder.m610b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f21418a;
        }
        return map;
    }

    public final FbJsonField mo1880a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m29139e().get(str);
        return fbJsonField != null ? fbJsonField : super.mo1880a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.m1324b(m29139e().keySet());
    }
}
