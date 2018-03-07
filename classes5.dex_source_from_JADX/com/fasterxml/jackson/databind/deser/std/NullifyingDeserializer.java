package com.fasterxml.jackson.databind.deser.std;

import android.support.v7.widget.LinearLayoutCompat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;

/* compiled from: checkin_composer */
public class NullifyingDeserializer extends StdDeserializer<Object> {
    public static final NullifyingDeserializer f6085a = new NullifyingDeserializer();
    private static final long serialVersionUID = 1;

    /* compiled from: checkin_composer */
    /* synthetic */ class C05521 {
        static final /* synthetic */ int[] f6084a = new int[JsonToken.values().length];

        static {
            try {
                f6084a[JsonToken.START_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6084a[JsonToken.START_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6084a[JsonToken.FIELD_NAME.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public NullifyingDeserializer() {
        super(Object.class);
    }

    public Object m11230a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        jsonParser.f();
        return null;
    }

    public final Object m11231a(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        switch (C05521.f6084a[jsonParser.g().ordinal()]) {
            case 1:
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
            case 3:
                return typeDeserializer.mo702d(jsonParser, deserializationContext);
            default:
                return null;
        }
    }
}
