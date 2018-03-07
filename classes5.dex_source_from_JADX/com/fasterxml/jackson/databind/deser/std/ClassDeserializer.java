package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.util.ClassUtil;

@JacksonStdImpl
/* compiled from: chose_1 */
public class ClassDeserializer extends StdScalarDeserializer<Class<?>> {
    public static final ClassDeserializer f6060a = new ClassDeserializer();
    private static final long serialVersionUID = 1;

    public /* synthetic */ Object m11141a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return m11142b(jsonParser, deserializationContext);
    }

    public ClassDeserializer() {
        super(Class.class);
    }

    public Class<?> m11142b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken g = jsonParser.g();
        if (g == JsonToken.VALUE_STRING) {
            try {
                return ClassUtil.a(jsonParser.o().trim());
            } catch (Throwable e) {
                throw deserializationContext.a(this._valueClass, ClassUtil.a(e));
            }
        }
        throw deserializationContext.a(this._valueClass, g);
    }
}
