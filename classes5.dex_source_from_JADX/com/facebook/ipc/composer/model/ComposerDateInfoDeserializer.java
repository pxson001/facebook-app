package com.facebook.ipc.composer.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: TOGGLE_ON */
public class ComposerDateInfoDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f13941a;

    static {
        GlobalAutoGenDeserializerCache.a(ComposerDateInfo.class, new ComposerDateInfoDeserializer());
        m23301e();
    }

    public ComposerDateInfoDeserializer() {
        a(ComposerDateInfo.class);
    }

    private static synchronized Map<String, FbJsonField> m23301e() {
        Map<String, FbJsonField> map;
        synchronized (ComposerDateInfoDeserializer.class) {
            if (f13941a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("start_date", FbJsonField.jsonField(ComposerDateInfo.class.getDeclaredField("mStartDate")));
                    builder.b("end_date", FbJsonField.jsonField(ComposerDateInfo.class.getDeclaredField("mEndDate")));
                    builder.b("is_current", FbJsonField.jsonField(ComposerDateInfo.class.getDeclaredField("mIsCurrent")));
                    f13941a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f13941a;
        }
        return map;
    }

    public final FbJsonField m23302a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m23301e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m23301e().keySet());
    }
}
