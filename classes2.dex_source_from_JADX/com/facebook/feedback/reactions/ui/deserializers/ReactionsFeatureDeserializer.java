package com.facebook.feedback.reactions.ui.deserializers;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.reactionsanimations.data.ReactionsAnimation;
import com.facebook.reactionsanimations.data.ReactionsFeature;
import com.facebook.reactionsanimations.data.ReactionsFeatureFrame;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: gysj_facepile_size_param */
public class ReactionsFeatureDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f21436a;

    public ReactionsFeatureDeserializer() {
        m13809a(ReactionsFeature.class);
    }

    static {
        m29159e();
    }

    private static synchronized Map<String, FbJsonField> m29159e() {
        Map<String, FbJsonField> map;
        synchronized (ReactionsFeatureDeserializer.class) {
            if (f21436a == null) {
                try {
                    Builder builder = new Builder();
                    builder.m609b("name", FbJsonField.jsonField(ReactionsFeature.class.getDeclaredField("mName")));
                    builder.m609b("fill_color", FbJsonField.jsonField(ReactionsFeature.class.getDeclaredField("mFillColor")));
                    builder.m609b("stroke_color", FbJsonField.jsonField(ReactionsFeature.class.getDeclaredField("mStrokeColor")));
                    builder.m609b("stroke_width", FbJsonField.jsonField(ReactionsFeature.class.getDeclaredField("mStrokeWidth")));
                    builder.m609b("key_frames", FbJsonField.jsonField(ReactionsFeature.class.getDeclaredField("mKeyFrames"), ReactionsFeatureFrame.class));
                    builder.m609b("timing_curves", FbJsonField.jsonField(ReactionsFeature.class.getDeclaredField("mTimingCurves")));
                    builder.m609b("animation_group", FbJsonField.jsonField(ReactionsFeature.class.getDeclaredField("mAnimationGroup")));
                    builder.m609b("feature_animations", FbJsonField.jsonField(ReactionsFeature.class.getDeclaredField("mFeatureAnimations"), ReactionsAnimation.class));
                    builder.m609b("effects", FbJsonField.jsonField(ReactionsFeature.class.getDeclaredField("mEffect")));
                    f21436a = builder.m610b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f21436a;
        }
        return map;
    }

    public final FbJsonField mo1880a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m29159e().get(str);
        return fbJsonField != null ? fbJsonField : super.mo1880a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.m1324b(m29159e().keySet());
    }
}
