package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer;

@JacksonStdImpl
/* compiled from: checkin_after_party */
public final class NumberDeserializers$CharacterDeserializer extends PrimitiveOrWrapperDeserializer<Character> {
    public static final NumberDeserializers$CharacterDeserializer f6092a = new NumberDeserializers$CharacterDeserializer(Character.class, Character.valueOf('\u0000'));
    public static final NumberDeserializers$CharacterDeserializer f6093b = new NumberDeserializers$CharacterDeserializer(Character.TYPE, null);
    private static final long serialVersionUID = 1;

    public final /* synthetic */ Object m11242a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return m11243b(jsonParser, deserializationContext);
    }

    private NumberDeserializers$CharacterDeserializer(Class<Character> cls, Character ch) {
        super(cls, ch);
    }

    public final Character m11243b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken g = jsonParser.g();
        if (g == JsonToken.VALUE_NUMBER_INT) {
            int x = jsonParser.x();
            if (x >= 0 && x <= 65535) {
                return Character.valueOf((char) x);
            }
        } else if (g == JsonToken.VALUE_STRING) {
            String o = jsonParser.o();
            if (o.length() == 1) {
                return Character.valueOf(o.charAt(0));
            }
            if (o.length() == 0) {
                return (Character) b();
            }
        }
        throw deserializationContext.a(this._valueClass, g);
    }
}
