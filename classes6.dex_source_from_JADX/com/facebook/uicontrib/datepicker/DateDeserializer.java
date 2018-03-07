package com.facebook.uicontrib.datepicker;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: search_bootstrap */
public class DateDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f5243a;

    static {
        GlobalAutoGenDeserializerCache.a(Date.class, new DateDeserializer());
        m7936e();
    }

    public DateDeserializer() {
        a(Date.class);
    }

    private static synchronized Map<String, FbJsonField> m7936e() {
        Map<String, FbJsonField> map;
        synchronized (DateDeserializer.class) {
            if (f5243a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("year", FbJsonField.jsonField(Date.class.getDeclaredField("year")));
                    builder.b("month", FbJsonField.jsonField(Date.class.getDeclaredField("month")));
                    builder.b("day", FbJsonField.jsonField(Date.class.getDeclaredField("dayOfMonth")));
                    f5243a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f5243a;
        }
        return map;
    }

    public final FbJsonField m7937a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m7936e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m7936e().keySet());
    }
}
