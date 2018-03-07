package com.facebook.feedback.reactions.ui.deserializers;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.reactionsanimations.data.ReactionsAnimationFrame;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: handle_type */
public class ReactionsAnimationFrameDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f21423a;

    public ReactionsAnimationFrameDeserializer() {
        m13809a(ReactionsAnimationFrame.class);
    }

    static {
        m29144e();
    }

    private static synchronized Map<String, FbJsonField> m29144e() {
        Map<String, FbJsonField> map;
        synchronized (ReactionsAnimationFrameDeserializer.class) {
            if (f21423a == null) {
                try {
                    Builder builder = new Builder();
                    builder.m609b("start_frame", FbJsonField.jsonField(ReactionsAnimationFrame.class.getDeclaredField("mStartFrame")));
                    builder.m609b("data", FbJsonField.jsonField(ReactionsAnimationFrame.class.getDeclaredField("mData")));
                    f21423a = builder.m610b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f21423a;
        }
        return map;
    }

    public final FbJsonField mo1880a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m29144e().get(str);
        return fbJsonField != null ? fbJsonField : super.mo1880a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.m1324b(m29144e().keySet());
    }
}
