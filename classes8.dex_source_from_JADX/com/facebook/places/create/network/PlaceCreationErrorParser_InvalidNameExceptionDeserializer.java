package com.facebook.places.create.network;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.places.create.network.PlaceCreationErrorParser.InvalidNameException;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: card_form_fail */
public class PlaceCreationErrorParser_InvalidNameExceptionDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f18367a;

    static {
        GlobalAutoGenDeserializerCache.a(InvalidNameException.class, new PlaceCreationErrorParser_InvalidNameExceptionDeserializer());
        m22315e();
    }

    public PlaceCreationErrorParser_InvalidNameExceptionDeserializer() {
        a(InvalidNameException.class);
    }

    private static synchronized Map<String, FbJsonField> m22315e() {
        Map<String, FbJsonField> map;
        synchronized (PlaceCreationErrorParser_InvalidNameExceptionDeserializer.class) {
            if (f18367a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("suggestion", FbJsonField.jsonField(InvalidNameException.class.getDeclaredField("suggestion")));
                    builder.b("reason", FbJsonField.jsonFieldWithCreator(InvalidNameException.class.getDeclaredField("reason")));
                    f18367a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f18367a;
        }
        return map;
    }

    public final FbJsonField m22316a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m22315e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m22315e().keySet());
    }
}
