package com.facebook.appirater.ratingdialog;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: crowdsourcing_region_report_incorrect */
public class RatingDialogSaveStateDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f16495a;

    static {
        GlobalAutoGenDeserializerCache.a(RatingDialogSaveState.class, new RatingDialogSaveStateDeserializer());
        m20563e();
    }

    public RatingDialogSaveStateDeserializer() {
        a(RatingDialogSaveState.class);
    }

    private static synchronized Map<String, FbJsonField> m20563e() {
        Map<String, FbJsonField> map;
        synchronized (RatingDialogSaveStateDeserializer.class) {
            if (f16495a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("rating", FbJsonField.jsonField(RatingDialogSaveState.class.getDeclaredField("rating")));
                    builder.b("rating_comment", FbJsonField.jsonField(RatingDialogSaveState.class.getDeclaredField("ratingComment")));
                    builder.b("last_screen", FbJsonField.jsonField(RatingDialogSaveState.class.getDeclaredField("lastScreen")));
                    f16495a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f16495a;
        }
        return map;
    }

    public final FbJsonField m20564a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m20563e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m20563e().keySet());
    }
}
