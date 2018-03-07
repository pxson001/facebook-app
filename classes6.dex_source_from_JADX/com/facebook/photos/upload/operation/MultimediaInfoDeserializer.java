package com.facebook.photos.upload.operation;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: goodfriends_fetcher */
public class MultimediaInfoDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f13688a;

    static {
        GlobalAutoGenDeserializerCache.a(MultimediaInfo.class, new MultimediaInfoDeserializer());
        m21438e();
    }

    public MultimediaInfoDeserializer() {
        a(MultimediaInfo.class);
    }

    private static synchronized Map<String, FbJsonField> m21438e() {
        Map<String, FbJsonField> map;
        synchronized (MultimediaInfoDeserializer.class) {
            if (f13688a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("videoPathToWaterfallId", FbJsonField.jsonField(MultimediaInfo.class.getDeclaredField("videoPathToWaterfallId")));
                    f13688a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f13688a;
        }
        return map;
    }

    public final FbJsonField m21439a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m21438e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m21438e().keySet());
    }
}
