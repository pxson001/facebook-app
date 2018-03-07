package com.facebook.katana.features.faceweb;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.katana.features.faceweb.FacewebComponentsStore.FacewebComponentsRule;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: p2p_pin_change_fail */
public class FacewebComponentsStore_FacewebComponentsRuleDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f7557a;

    static {
        GlobalAutoGenDeserializerCache.a(FacewebComponentsRule.class, new FacewebComponentsStore_FacewebComponentsRuleDeserializer());
        m7859e();
    }

    public FacewebComponentsStore_FacewebComponentsRuleDeserializer() {
        a(FacewebComponentsRule.class);
    }

    private static synchronized Map<String, FbJsonField> m7859e() {
        Map<String, FbJsonField> map;
        synchronized (FacewebComponentsStore_FacewebComponentsRuleDeserializer.class) {
            if (f7557a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("componentsId", FbJsonField.jsonField(FacewebComponentsRule.class.getDeclaredField("mComponentsId")));
                    builder.b("path", FbJsonField.jsonField(FacewebComponentsRule.class.getDeclaredField("mPathRegex")));
                    builder.b("continueSearch", FbJsonField.jsonField(FacewebComponentsRule.class.getDeclaredField("mContinueSearch")));
                    builder.b("parameters", FbJsonField.jsonField(FacewebComponentsRule.class.getDeclaredField("mParameters")));
                    f7557a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f7557a;
        }
        return map;
    }

    public final FbJsonField m7860a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m7859e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m7859e().keySet());
    }
}
