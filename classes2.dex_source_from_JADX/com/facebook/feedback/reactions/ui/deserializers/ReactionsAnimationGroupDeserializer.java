package com.facebook.feedback.reactions.ui.deserializers;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.reactionsanimations.data.ReactionsAnimation;
import com.facebook.reactionsanimations.data.ReactionsAnimationGroup;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: handleFetchConfiguration */
public class ReactionsAnimationGroupDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f21425a;

    public ReactionsAnimationGroupDeserializer() {
        m13809a(ReactionsAnimationGroup.class);
    }

    static {
        m29146e();
    }

    private static synchronized Map<String, FbJsonField> m29146e() {
        Map<String, FbJsonField> map;
        synchronized (ReactionsAnimationGroupDeserializer.class) {
            if (f21425a == null) {
                try {
                    Builder builder = new Builder();
                    builder.m609b("group_id", FbJsonField.jsonField(ReactionsAnimationGroup.class.getDeclaredField("mGroupId")));
                    builder.m609b("parent_group", FbJsonField.jsonField(ReactionsAnimationGroup.class.getDeclaredField("mParentGroup")));
                    builder.m609b("animations", FbJsonField.jsonField(ReactionsAnimationGroup.class.getDeclaredField("mAnimations"), ReactionsAnimation.class));
                    f21425a = builder.m610b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f21425a;
        }
        return map;
    }

    public final FbJsonField mo1880a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m29146e().get(str);
        return fbJsonField != null ? fbJsonField : super.mo1880a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.m1324b(m29146e().keySet());
    }
}
