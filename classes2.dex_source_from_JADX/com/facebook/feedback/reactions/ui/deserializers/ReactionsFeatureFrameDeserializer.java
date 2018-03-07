package com.facebook.feedback.reactions.ui.deserializers;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.reactionsanimations.data.ReactionsFeatureFrame;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: gv/share?campaign_id=%s&campaign_type=%s&source=%s&direct_source=%s&share_preview=%s&share_autofill=%s&share_placeholder=%s */
public class ReactionsFeatureFrameDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f21443a;

    public ReactionsFeatureFrameDeserializer() {
        m13809a(ReactionsFeatureFrame.class);
    }

    static {
        m29168e();
    }

    private static synchronized Map<String, FbJsonField> m29168e() {
        Map<String, FbJsonField> map;
        synchronized (ReactionsFeatureFrameDeserializer.class) {
            if (f21443a == null) {
                try {
                    Builder builder = new Builder();
                    builder.m609b("start_frame", FbJsonField.jsonField(ReactionsFeatureFrame.class.getDeclaredField("mStartFrame")));
                    builder.m609b("data", FbJsonField.jsonField(ReactionsFeatureFrame.class.getDeclaredField("mData"), String.class));
                    f21443a = builder.m610b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f21443a;
        }
        return map;
    }

    public final FbJsonField mo1880a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m29168e().get(str);
        return fbJsonField != null ? fbJsonField : super.mo1880a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.m1324b(m29168e().keySet());
    }
}
