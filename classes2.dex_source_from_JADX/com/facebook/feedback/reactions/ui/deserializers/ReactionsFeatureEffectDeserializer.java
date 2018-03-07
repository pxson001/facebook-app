package com.facebook.feedback.reactions.ui.deserializers;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.reactionsanimations.data.ReactionsFeatureEffect;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: gysc_member_profile_size */
public class ReactionsFeatureEffectDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f21438a;

    public ReactionsFeatureEffectDeserializer() {
        m13809a(ReactionsFeatureEffect.class);
    }

    static {
        m29163e();
    }

    private static synchronized Map<String, FbJsonField> m29163e() {
        Map<String, FbJsonField> map;
        synchronized (ReactionsFeatureEffectDeserializer.class) {
            if (f21438a == null) {
                try {
                    Builder builder = new Builder();
                    builder.m609b("gradient", FbJsonField.jsonField(ReactionsFeatureEffect.class.getDeclaredField("mGradient")));
                    f21438a = builder.m610b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f21438a;
        }
        return map;
    }

    public final FbJsonField mo1880a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m29163e().get(str);
        return fbJsonField != null ? fbJsonField : super.mo1880a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.m1324b(m29163e().keySet());
    }
}
