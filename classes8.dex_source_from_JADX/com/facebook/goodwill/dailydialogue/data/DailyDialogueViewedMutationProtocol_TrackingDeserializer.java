package com.facebook.goodwill.dailydialogue.data;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: fetch_auto_fill_data */
public class DailyDialogueViewedMutationProtocol_TrackingDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f13435a;

    static {
        GlobalAutoGenDeserializerCache.a(DailyDialogueViewedMutationProtocol$Tracking.class, new DailyDialogueViewedMutationProtocol_TrackingDeserializer());
        m15055e();
    }

    public DailyDialogueViewedMutationProtocol_TrackingDeserializer() {
        a(DailyDialogueViewedMutationProtocol$Tracking.class);
    }

    private static synchronized Map<String, FbJsonField> m15055e() {
        Map<String, FbJsonField> map;
        synchronized (DailyDialogueViewedMutationProtocol_TrackingDeserializer.class) {
            if (f13435a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("daily_dialogue_lightweight_unit_type", FbJsonField.jsonField(DailyDialogueViewedMutationProtocol$Tracking.class.getDeclaredField("type")));
                    builder.b("daily_dialogue_lightweight_unit_id", FbJsonField.jsonField(DailyDialogueViewedMutationProtocol$Tracking.class.getDeclaredField("id")));
                    builder.b("daily_dialogue_lightweight_extra", FbJsonField.jsonField(DailyDialogueViewedMutationProtocol$Tracking.class.getDeclaredField("extra")));
                    f13435a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f13435a;
        }
        return map;
    }

    public final FbJsonField m15056a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m15055e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m15055e().keySet());
    }
}
