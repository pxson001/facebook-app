package com.facebook.feedback.reactions.ui.deserializers;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.reactionsanimations.data.ReactionsColorFrame;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: h */
public class ReactionsColorFrameDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f21426a;

    public ReactionsColorFrameDeserializer() {
        m13809a(ReactionsColorFrame.class);
    }

    static {
        m29150e();
    }

    private static synchronized Map<String, FbJsonField> m29150e() {
        Map<String, FbJsonField> map;
        synchronized (ReactionsColorFrameDeserializer.class) {
            if (f21426a == null) {
                try {
                    Builder builder = new Builder();
                    builder.m609b("start_frame", FbJsonField.jsonField(ReactionsColorFrame.class.getDeclaredField("mStartFrame")));
                    builder.m609b("data", FbJsonField.jsonField(ReactionsColorFrame.class.getDeclaredField("mColor")));
                    f21426a = builder.m610b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f21426a;
        }
        return map;
    }

    public final FbJsonField mo1880a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m29150e().get(str);
        return fbJsonField != null ? fbJsonField : super.mo1880a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.m1324b(m29150e().keySet());
    }
}
