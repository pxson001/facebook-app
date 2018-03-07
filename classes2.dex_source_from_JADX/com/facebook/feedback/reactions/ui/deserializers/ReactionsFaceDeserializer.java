package com.facebook.feedback.reactions.ui.deserializers;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.reactionsanimations.data.ReactionsAnimationGroup;
import com.facebook.reactionsanimations.data.ReactionsFace;
import com.facebook.reactionsanimations.data.ReactionsFeature;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: gysj_size_param */
public class ReactionsFaceDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f21428a;

    public ReactionsFaceDeserializer() {
        m13809a(ReactionsFace.class);
    }

    static {
        m29153e();
    }

    private static synchronized Map<String, FbJsonField> m29153e() {
        Map<String, FbJsonField> map;
        synchronized (ReactionsFaceDeserializer.class) {
            if (f21428a == null) {
                try {
                    Builder builder = new Builder();
                    builder.m609b("animation_duration", FbJsonField.jsonField(ReactionsFace.class.getDeclaredField("mAnimationDuration")));
                    builder.m609b("frame_rate", FbJsonField.jsonField(ReactionsFace.class.getDeclaredField("mFrameRate")));
                    builder.m609b("animation_frame_count", FbJsonField.jsonField(ReactionsFace.class.getDeclaredField("mFrameCount")));
                    builder.m609b("features", FbJsonField.jsonField(ReactionsFace.class.getDeclaredField("mFeatures"), ReactionsFeature.class));
                    builder.m609b("animation_groups", FbJsonField.jsonField(ReactionsFace.class.getDeclaredField("mAnimationGroups"), ReactionsAnimationGroup.class));
                    builder.m609b("canvas_size", FbJsonField.jsonField(ReactionsFace.class.getDeclaredField("mCanvasSize")));
                    builder.m609b("key", FbJsonField.jsonField(ReactionsFace.class.getDeclaredField("mKey")));
                    f21428a = builder.m610b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f21428a;
        }
        return map;
    }

    public final FbJsonField mo1880a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m29153e().get(str);
        return fbJsonField != null ? fbJsonField : super.mo1880a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.m1324b(m29153e().keySet());
    }
}
