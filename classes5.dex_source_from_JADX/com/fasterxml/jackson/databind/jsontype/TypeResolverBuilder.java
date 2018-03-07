package com.fasterxml.jackson.databind.jsontype;

import com.fasterxml.jackson.annotation.JsonTypeInfo$As;
import com.fasterxml.jackson.annotation.JsonTypeInfo$Id;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializationConfig;
import java.util.Collection;

/* compiled from: category_type */
public interface TypeResolverBuilder<T extends TypeResolverBuilder<T>> {
    TypeDeserializer mo718a(DeserializationConfig deserializationConfig, JavaType javaType, Collection<NamedType> collection);

    T mo719a(JsonTypeInfo$As jsonTypeInfo$As);

    T mo720a(JsonTypeInfo$Id jsonTypeInfo$Id, TypeIdResolver typeIdResolver);

    T mo721a(Class<?> cls);

    T mo722a(String str);

    T mo723a(boolean z);

    TypeSerializer mo724a(SerializationConfig serializationConfig, JavaType javaType, Collection<NamedType> collection);

    Class<?> mo725a();
}
