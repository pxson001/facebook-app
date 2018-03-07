package com.facebook.messaging.payment.service.model.sync;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: fetchThreadParams= */
public class FetchIrisSequenceIdResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f14731a;

    static {
        GlobalAutoGenDeserializerCache.a(FetchIrisSequenceIdResult.class, new FetchIrisSequenceIdResultDeserializer());
        m15197e();
    }

    public FetchIrisSequenceIdResultDeserializer() {
        a(FetchIrisSequenceIdResult.class);
    }

    private static synchronized Map<String, FbJsonField> m15197e() {
        Map<String, FbJsonField> map;
        synchronized (FetchIrisSequenceIdResultDeserializer.class) {
            if (f14731a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("iris_sequence_id", FbJsonField.jsonField(FetchIrisSequenceIdResult.class.getDeclaredField("mIrisSequenceId")));
                    f14731a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f14731a;
        }
        return map;
    }

    public final FbJsonField m15198a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m15197e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m15197e().keySet());
    }
}
