package com.fasterxml.jackson.databind.deser.std;

import android.support.v7.widget.LinearLayoutCompat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.math.BigDecimal;
import java.math.BigInteger;

@JacksonStdImpl
/* compiled from: checkin_after_party */
public final class NumberDeserializers$NumberDeserializer extends StdScalarDeserializer<Number> {
    public static final NumberDeserializers$NumberDeserializer f6094a = new NumberDeserializers$NumberDeserializer();

    public final /* synthetic */ Object m11244a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return m11246b(jsonParser, deserializationContext);
    }

    public NumberDeserializers$NumberDeserializer() {
        super(Number.class);
    }

    public final Number m11246b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken g = jsonParser.g();
        if (g == JsonToken.VALUE_NUMBER_INT) {
            if (deserializationContext.a(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS)) {
                return jsonParser.z();
            }
            return jsonParser.t();
        } else if (g == JsonToken.VALUE_NUMBER_FLOAT) {
            if (deserializationContext.a(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                return jsonParser.C();
            }
            return Double.valueOf(jsonParser.B());
        } else if (g == JsonToken.VALUE_STRING) {
            String trim = jsonParser.o().trim();
            try {
                if (trim.indexOf(46) >= 0) {
                    if (deserializationContext.a(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                        return new BigDecimal(trim);
                    }
                    return new Double(trim);
                } else if (deserializationContext.a(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS)) {
                    return new BigInteger(trim);
                } else {
                    long parseLong = Long.parseLong(trim);
                    if (parseLong > 2147483647L || parseLong < -2147483648L) {
                        return Long.valueOf(parseLong);
                    }
                    return Integer.valueOf((int) parseLong);
                }
            } catch (IllegalArgumentException e) {
                throw deserializationContext.a(trim, this._valueClass, "not a valid number");
            }
        } else {
            throw deserializationContext.a(this._valueClass, g);
        }
    }

    public final Object m11245a(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        switch (NumberDeserializers$1.f6086a[jsonParser.g().ordinal()]) {
            case 1:
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
            case 3:
                return m11246b(jsonParser, deserializationContext);
            default:
                return typeDeserializer.mo701c(jsonParser, deserializationContext);
        }
    }
}
