package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.type.MapLikeType;

/* compiled from: ssl_version */
public interface Serializers {

    /* compiled from: ssl_version */
    public class Base implements Serializers {
        public JsonSerializer<?> mo1152a(SerializationConfig serializationConfig, JavaType javaType, BeanDescription beanDescription) {
            return null;
        }

        public final JsonSerializer<?> mo1154a() {
            return null;
        }

        public final JsonSerializer<?> mo1155b() {
            return null;
        }

        public final JsonSerializer<?> mo1156c() {
            return null;
        }

        public final JsonSerializer<?> mo1157d() {
            return null;
        }

        public JsonSerializer<?> mo1153a(SerializationConfig serializationConfig, MapLikeType mapLikeType, BeanDescription beanDescription, JsonSerializer<Object> jsonSerializer, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer2) {
            return null;
        }
    }

    JsonSerializer<?> mo1154a();

    JsonSerializer<?> mo1152a(SerializationConfig serializationConfig, JavaType javaType, BeanDescription beanDescription);

    JsonSerializer<?> mo1153a(SerializationConfig serializationConfig, MapLikeType mapLikeType, BeanDescription beanDescription, JsonSerializer<Object> jsonSerializer, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer2);

    JsonSerializer<?> mo1155b();

    JsonSerializer<?> mo1156c();

    JsonSerializer<?> mo1157d();
}
