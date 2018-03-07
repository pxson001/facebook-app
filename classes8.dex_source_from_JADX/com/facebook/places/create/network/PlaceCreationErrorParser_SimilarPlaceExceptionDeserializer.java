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

/* compiled from: card_form_cancel */
public class PlaceCreationErrorParser_SimilarPlaceExceptionDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f18368a;

    static {
        GlobalAutoGenDeserializerCache.a(SimilarPlaceException.class, new PlaceCreationErrorParser_SimilarPlaceExceptionDeserializer());
        m22318e();
    }

    public PlaceCreationErrorParser_SimilarPlaceExceptionDeserializer() {
        a(SimilarPlaceException.class);
    }

    private static synchronized Map<String, FbJsonField> m22318e() {
        Map<String, FbJsonField> map;
        synchronized (PlaceCreationErrorParser_SimilarPlaceExceptionDeserializer.class) {
            if (f18368a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(SimilarPlaceException.class.getDeclaredField("id")));
                    builder.b("name", FbJsonField.jsonField(SimilarPlaceException.class.getDeclaredField("name")));
                    f18368a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f18368a;
        }
        return map;
    }

    public final FbJsonField m22319a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m22318e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m22318e().keySet());
    }
}
