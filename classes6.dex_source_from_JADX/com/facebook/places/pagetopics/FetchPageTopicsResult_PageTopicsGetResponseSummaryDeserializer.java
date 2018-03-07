package com.facebook.places.pagetopics;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.places.pagetopics.FetchPageTopicsResult.PageTopicsGetResponseSummary;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: followup_action_type */
public class FetchPageTopicsResult_PageTopicsGetResponseSummaryDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f14740a;

    static {
        GlobalAutoGenDeserializerCache.a(PageTopicsGetResponseSummary.class, new FetchPageTopicsResult_PageTopicsGetResponseSummaryDeserializer());
        m22302e();
    }

    public FetchPageTopicsResult_PageTopicsGetResponseSummaryDeserializer() {
        a(PageTopicsGetResponseSummary.class);
    }

    private static synchronized Map<String, FbJsonField> m22302e() {
        Map<String, FbJsonField> map;
        synchronized (FetchPageTopicsResult_PageTopicsGetResponseSummaryDeserializer.class) {
            if (f14740a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("topics_version", FbJsonField.jsonField(PageTopicsGetResponseSummary.class.getDeclaredField("topicsVersion")));
                    f14740a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f14740a;
        }
        return map;
    }

    public final FbJsonField m22303a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m22302e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m22302e().keySet());
    }
}
