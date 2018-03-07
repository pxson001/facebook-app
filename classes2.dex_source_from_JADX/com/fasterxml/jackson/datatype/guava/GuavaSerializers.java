package com.fasterxml.jackson.datatype.guava;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.Serializers.Base;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.datatype.guava.ser.GuavaOptionalSerializer;
import com.fasterxml.jackson.datatype.guava.ser.MultimapSerializer;
import com.google.common.base.Optional;
import com.google.common.collect.Multimap;

/* compiled from: sq_AL */
public class GuavaSerializers extends Base {
    public final JsonSerializer<?> mo1153a(SerializationConfig serializationConfig, MapLikeType mapLikeType, BeanDescription beanDescription, JsonSerializer<Object> jsonSerializer, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer2) {
        if (Multimap.class.isAssignableFrom(mapLikeType._class)) {
            return new MultimapSerializer(mapLikeType, jsonSerializer, typeSerializer, jsonSerializer2);
        }
        return null;
    }

    public final JsonSerializer<?> mo1152a(SerializationConfig serializationConfig, JavaType javaType, BeanDescription beanDescription) {
        if (Optional.class.isAssignableFrom(javaType._class)) {
            return new GuavaOptionalSerializer(javaType);
        }
        return super.mo1152a(serializationConfig, javaType, beanDescription);
    }
}
