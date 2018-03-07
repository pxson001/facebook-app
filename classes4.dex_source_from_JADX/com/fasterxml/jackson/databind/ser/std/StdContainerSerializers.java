package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.impl.IndexedListSerializer;
import com.fasterxml.jackson.databind.ser.impl.IteratorSerializer;

/* compiled from: disable_sync */
public class StdContainerSerializers {
    protected StdContainerSerializers() {
    }

    public static ContainerSerializer<?> m14543a(JavaType javaType, boolean z, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        return new IndexedListSerializer(javaType, z, typeSerializer, null, jsonSerializer);
    }

    public static ContainerSerializer<?> m14545b(JavaType javaType, boolean z, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        return new CollectionSerializer(javaType, z, typeSerializer, null, jsonSerializer);
    }

    public static ContainerSerializer<?> m14542a(JavaType javaType, boolean z, TypeSerializer typeSerializer) {
        return new IteratorSerializer(javaType, z, typeSerializer, null);
    }

    public static ContainerSerializer<?> m14544b(JavaType javaType, boolean z, TypeSerializer typeSerializer) {
        return new IterableSerializer(javaType, z, typeSerializer, null);
    }

    public static JsonSerializer<?> m14541a(JavaType javaType) {
        return new EnumSetSerializer(javaType, null);
    }
}
