package com.facebook.friendsharing.souvenirs.models;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: RKUIManager */
public class SouvenirMetadataDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f24068a;

    static {
        GlobalAutoGenDeserializerCache.a(SouvenirMetadata.class, new SouvenirMetadataDeserializer());
        m26173e();
    }

    public SouvenirMetadataDeserializer() {
        a(SouvenirMetadata.class);
    }

    private static synchronized Map<String, FbJsonField> m26173e() {
        Map<String, FbJsonField> map;
        synchronized (SouvenirMetadataDeserializer.class) {
            if (f24068a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("local_id", FbJsonField.jsonField(SouvenirMetadata.class.getDeclaredField("mId")));
                    builder.b("title", FbJsonField.jsonField(SouvenirMetadata.class.getDeclaredField("mTitle")));
                    builder.b("start_date", FbJsonField.jsonField(SouvenirMetadata.class.getDeclaredField("mStartDate")));
                    builder.b("end_date", FbJsonField.jsonField(SouvenirMetadata.class.getDeclaredField("mEndDate")));
                    builder.b("shareability_score", FbJsonField.jsonField(SouvenirMetadata.class.getDeclaredField("mShareabilityScore")));
                    f24068a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f24068a;
        }
        return map;
    }

    public final FbJsonField m26174a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m26173e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m26173e().keySet());
    }
}
