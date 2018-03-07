package com.facebook.appirater.api;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: cta_ad_message_send2 */
public class FetchISRConfigResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f16483a;

    static {
        GlobalAutoGenDeserializerCache.a(FetchISRConfigResult.class, new FetchISRConfigResultDeserializer());
        m20547e();
    }

    public FetchISRConfigResultDeserializer() {
        a(FetchISRConfigResult.class);
    }

    private static synchronized Map<String, FbJsonField> m20547e() {
        Map<String, FbJsonField> map;
        synchronized (FetchISRConfigResultDeserializer.class) {
            if (f16483a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("should_ask_user", FbJsonField.jsonField(FetchISRConfigResult.class.getDeclaredField("shouldAskUser")));
                    builder.b("delay_asking_millisecs", FbJsonField.jsonField(FetchISRConfigResult.class.getDeclaredField("delayAskingMillis")));
                    builder.b("delay_till_next_ping_millisecs", FbJsonField.jsonField(FetchISRConfigResult.class.getDeclaredField("delayTillNextPingMillis")));
                    builder.b("max_stars_for_feedback", FbJsonField.jsonField(FetchISRConfigResult.class.getDeclaredField("maxStarsForFeedback")));
                    builder.b("min_stars_for_store", FbJsonField.jsonField(FetchISRConfigResult.class.getDeclaredField("minStarsForStore")));
                    builder.b("result_recieved_at_millis", FbJsonField.jsonField(FetchISRConfigResult.class.getDeclaredField("resultRecievedAtMillis")));
                    f16483a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f16483a;
        }
        return map;
    }

    public final FbJsonField m20548a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m20547e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m20547e().keySet());
    }
}
