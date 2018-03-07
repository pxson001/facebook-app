package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.math.BigDecimal;

@JacksonStdImpl
/* compiled from: checkin_after_party */
public class NumberDeserializers$BigDecimalDeserializer extends StdScalarDeserializer<BigDecimal> {
    public static final NumberDeserializers$BigDecimalDeserializer f6088a = new NumberDeserializers$BigDecimalDeserializer();

    public /* synthetic */ Object m11232a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return m11233b(jsonParser, deserializationContext);
    }

    public NumberDeserializers$BigDecimalDeserializer() {
        super(BigDecimal.class);
    }

    public BigDecimal m11233b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken g = jsonParser.g();
        if (g == JsonToken.VALUE_NUMBER_INT || g == JsonToken.VALUE_NUMBER_FLOAT) {
            return jsonParser.C();
        }
        if (g == JsonToken.VALUE_STRING) {
            String trim = jsonParser.o().trim();
            if (trim.length() == 0) {
                return null;
            }
            try {
                return new BigDecimal(trim);
            } catch (IllegalArgumentException e) {
                throw deserializationContext.a(trim, this._valueClass, "not a valid representation");
            }
        }
        throw deserializationContext.a(this._valueClass, g);
    }
}
