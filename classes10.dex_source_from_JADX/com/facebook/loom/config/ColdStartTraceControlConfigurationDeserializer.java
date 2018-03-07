package com.facebook.loom.config;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: tiers */
public class ColdStartTraceControlConfigurationDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f1430a;

    static {
        GlobalAutoGenDeserializerCache.a(ColdStartTraceControlConfiguration.class, new ColdStartTraceControlConfigurationDeserializer());
        m1427e();
    }

    public ColdStartTraceControlConfigurationDeserializer() {
        a(ColdStartTraceControlConfiguration.class);
    }

    private static synchronized Map<String, FbJsonField> m1427e() {
        Map<String, FbJsonField> map;
        synchronized (ColdStartTraceControlConfigurationDeserializer.class) {
            if (f1430a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("coinflip_sample_rate", FbJsonField.jsonField(ColdStartTraceControlConfiguration.class.getDeclaredField("mCoinflipSampleRate")));
                    builder.b("enabled_event_providers", FbJsonField.jsonField(ColdStartTraceControlConfiguration.class.getDeclaredField("mEnabledEventProviders"), String.class));
                    builder.b("stop_qpl_marker", FbJsonField.jsonField(ColdStartTraceControlConfiguration.class.getDeclaredField("mStopQPLMarker")));
                    builder.b("max_trace_timeout_ms", FbJsonField.jsonField(ColdStartTraceControlConfiguration.class.getDeclaredField("mTraceTimeoutMs")));
                    builder.b("timed_out_upload_sample_rate", FbJsonField.jsonField(ColdStartTraceControlConfiguration.class.getDeclaredField("mTimedOutUploadSampleRate")));
                    f1430a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f1430a;
        }
        return map;
    }

    public final FbJsonField m1428a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m1427e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m1427e().keySet());
    }
}
