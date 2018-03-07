package com.fasterxml.jackson.databind.deser.std;

import android.support.v7.widget.LinearLayoutCompat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.math.BigInteger;

@JacksonStdImpl
/* compiled from: checkin_after_party */
public class NumberDeserializers$BigIntegerDeserializer extends StdScalarDeserializer<BigInteger> {
    public static final NumberDeserializers$BigIntegerDeserializer f6089a = new NumberDeserializers$BigIntegerDeserializer();

    public /* synthetic */ Object m11234a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return m11235b(jsonParser, deserializationContext);
    }

    public NumberDeserializers$BigIntegerDeserializer() {
        super(BigInteger.class);
    }

    public BigInteger m11235b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken g = jsonParser.g();
        if (g == JsonToken.VALUE_NUMBER_INT) {
            switch (NumberDeserializers$1.f6087b[jsonParser.u().ordinal()]) {
                case 1:
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    return BigInteger.valueOf(jsonParser.y());
            }
        } else if (g == JsonToken.VALUE_NUMBER_FLOAT) {
            return jsonParser.C().toBigInteger();
        } else {
            if (g != JsonToken.VALUE_STRING) {
                throw deserializationContext.a(this._valueClass, g);
            }
        }
        String trim = jsonParser.o().trim();
        if (trim.length() == 0) {
            return null;
        }
        try {
            return new BigInteger(trim);
        } catch (IllegalArgumentException e) {
            throw deserializationContext.a(trim, this._valueClass, "not a valid representation");
        }
    }
}
