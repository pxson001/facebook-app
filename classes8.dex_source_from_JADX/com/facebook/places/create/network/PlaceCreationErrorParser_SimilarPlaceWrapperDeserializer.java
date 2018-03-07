package com.facebook.places.create.network;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.places.create.network.PlaceCreationErrorParser.SimilarPlaceException;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: cardType */
public class PlaceCreationErrorParser_SimilarPlaceWrapperDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f18369a;

    static {
        GlobalAutoGenDeserializerCache.a(SimilarPlaceWrapper.class, new PlaceCreationErrorParser_SimilarPlaceWrapperDeserializer());
        m22320e();
    }

    public PlaceCreationErrorParser_SimilarPlaceWrapperDeserializer() {
        a(SimilarPlaceWrapper.class);
    }

    private static synchronized Map<String, FbJsonField> m22320e() {
        Map<String, FbJsonField> map;
        synchronized (PlaceCreationErrorParser_SimilarPlaceWrapperDeserializer.class) {
            if (f18369a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("similar_places", FbJsonField.jsonField(SimilarPlaceWrapper.class.getDeclaredField("similarPlaces"), SimilarPlaceException.class));
                    f18369a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f18369a;
        }
        return map;
    }

    public final FbJsonField m22321a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m22320e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m22320e().keySet());
    }
}
