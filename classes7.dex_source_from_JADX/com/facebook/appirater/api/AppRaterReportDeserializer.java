package com.facebook.appirater.api;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: cta_lead_gen_close_confirmation_dialog_click */
public class AppRaterReportDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f16479a;

    static {
        GlobalAutoGenDeserializerCache.a(AppRaterReport.class, new AppRaterReportDeserializer());
        m20539e();
    }

    public AppRaterReportDeserializer() {
        a(AppRaterReport.class);
    }

    private static synchronized Map<String, FbJsonField> m20539e() {
        Map<String, FbJsonField> map;
        synchronized (AppRaterReportDeserializer.class) {
            if (f16479a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("star_rating", FbJsonField.jsonField(AppRaterReport.class.getDeclaredField("starRating")));
                    builder.b("review_text", FbJsonField.jsonField(AppRaterReport.class.getDeclaredField("reviewText")));
                    builder.b("last_event", FbJsonField.jsonField(AppRaterReport.class.getDeclaredField("lastEvent")));
                    builder.b("build_number", FbJsonField.jsonField(AppRaterReport.class.getDeclaredField("buildNumber")));
                    builder.b("last_event_completed_at_millis", FbJsonField.jsonField(AppRaterReport.class.getDeclaredField("lastEventCompletedAtMillis")));
                    f16479a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f16479a;
        }
        return map;
    }

    public final FbJsonField m20540a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m20539e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m20539e().keySet());
    }
}
