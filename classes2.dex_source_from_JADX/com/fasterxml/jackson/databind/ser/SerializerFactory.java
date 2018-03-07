package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: start_callback_count */
public abstract class SerializerFactory {
    public abstract JsonSerializer<Object> mo1098a(SerializationConfig serializationConfig, JavaType javaType, JsonSerializer<Object> jsonSerializer);

    public abstract JsonSerializer<Object> mo1095a(SerializerProvider serializerProvider, JavaType javaType);

    public abstract TypeSerializer mo1099a(SerializationConfig serializationConfig, JavaType javaType);

    public abstract SerializerFactory mo1100a(BeanSerializerModifier beanSerializerModifier);

    public abstract SerializerFactory mo1101a(Serializers serializers);
}
