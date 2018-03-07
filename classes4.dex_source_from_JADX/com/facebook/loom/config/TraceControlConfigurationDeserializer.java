package com.facebook.loom.config;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: getTopContacts */
public class TraceControlConfigurationDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f11096a;

    static {
        GlobalAutoGenDeserializerCache.a(TraceControlConfiguration.class, new TraceControlConfigurationDeserializer());
        m11529e();
    }

    public TraceControlConfigurationDeserializer() {
        a(TraceControlConfiguration.class);
    }

    private static synchronized Map<String, FbJsonField> m11529e() {
        Map<String, FbJsonField> map;
        synchronized (TraceControlConfigurationDeserializer.class) {
            if (f11096a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("qpl", FbJsonField.jsonField(TraceControlConfiguration.class.getDeclaredField("mQPLTraceControl")));
                    builder.b("http", FbJsonField.jsonField(TraceControlConfiguration.class.getDeclaredField("mHTTPTraceControl")));
                    builder.b("cold_start", FbJsonField.jsonField(TraceControlConfiguration.class.getDeclaredField("mColdStartTraceControl")));
                    builder.b("max_trace_timeout_ms", FbJsonField.jsonField(TraceControlConfiguration.class.getDeclaredField("mTraceTimeousMs")));
                    builder.b("timed_out_upload_sample_rate", FbJsonField.jsonField(TraceControlConfiguration.class.getDeclaredField("mTimedOutUploadSampleRate")));
                    f11096a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f11096a;
        }
        return map;
    }

    public final FbJsonField m11530a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m11529e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m11529e().keySet());
    }
}
