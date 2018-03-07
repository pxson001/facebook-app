package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;

/* compiled from: states */
public abstract class DeserializerFactory {
    protected static final Deserializers[] f4155d = new Deserializers[0];

    public abstract JavaType mo1083a(DeserializationConfig deserializationConfig, JavaType javaType);

    public abstract JsonDeserializer<?> mo1084a(DeserializationConfig deserializationConfig, JavaType javaType, BeanDescription beanDescription);

    public abstract JsonDeserializer<?> mo1085a(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription);

    public abstract JsonDeserializer<Object> mo1080a(DeserializationContext deserializationContext, JavaType javaType, Class<?> cls);

    public abstract JsonDeserializer<?> mo1086a(DeserializationContext deserializationContext, ArrayType arrayType, BeanDescription beanDescription);

    public abstract JsonDeserializer<?> mo1087a(DeserializationContext deserializationContext, CollectionLikeType collectionLikeType, BeanDescription beanDescription);

    public abstract JsonDeserializer<?> mo1088a(DeserializationContext deserializationContext, CollectionType collectionType, BeanDescription beanDescription);

    public abstract JsonDeserializer<?> mo1089a(DeserializationContext deserializationContext, MapLikeType mapLikeType, BeanDescription beanDescription);

    public abstract JsonDeserializer<?> mo1090a(DeserializationContext deserializationContext, MapType mapType, BeanDescription beanDescription);

    public abstract KeyDeserializer mo1091a(DeserializationContext deserializationContext, JavaType javaType);

    public abstract DeserializerFactory mo1092a(Deserializers deserializers);

    public abstract TypeDeserializer mo1093b(DeserializationConfig deserializationConfig, JavaType javaType);

    public abstract JsonDeserializer<Object> mo1082c(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription);
}
