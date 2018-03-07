package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.util.List;

@JacksonStdImpl
/* compiled from: disable_sound */
public final class IndexedListSerializer extends AsArraySerializerBase<List<?>> {
    public final boolean m14549a(Object obj) {
        List list = (List) obj;
        return list == null || list.isEmpty();
    }

    public final void mo987b(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        List list = (List) obj;
        if (this.f13796d != null) {
            m14546a(list, jsonGenerator, serializerProvider, this.f13796d);
        } else if (this.f13795c != null) {
            m14547b(list, jsonGenerator, serializerProvider);
        } else {
            int size = list.size();
            if (size != 0) {
                int i = 0;
                try {
                    PropertySerializerMap propertySerializerMap = this.f13798f;
                    while (i < size) {
                        Object obj2 = list.get(i);
                        if (obj2 == null) {
                            serializerProvider.a(jsonGenerator);
                        } else {
                            Class cls = obj2.getClass();
                            JsonSerializer a = propertySerializerMap.mo48a(cls);
                            if (a == null) {
                                JsonSerializer a2;
                                if (this.f13794b.p()) {
                                    a2 = m14554a(propertySerializerMap, serializerProvider.a(this.f13794b, cls), serializerProvider);
                                } else {
                                    a2 = m14555a(propertySerializerMap, cls, serializerProvider);
                                }
                                JsonSerializer jsonSerializer = a2;
                                propertySerializerMap = this.f13798f;
                                a = jsonSerializer;
                            }
                            a.a(obj2, jsonGenerator, serializerProvider);
                        }
                        i++;
                    }
                } catch (Throwable e) {
                    StdSerializer.a(serializerProvider, e, list, 0);
                }
            }
        }
    }

    public final boolean mo854b(Object obj) {
        return ((List) obj).size() == 1;
    }

    public IndexedListSerializer(JavaType javaType, boolean z, TypeSerializer typeSerializer, BeanProperty beanProperty, JsonSerializer<Object> jsonSerializer) {
        super(List.class, javaType, z, typeSerializer, beanProperty, jsonSerializer);
    }

    private IndexedListSerializer(IndexedListSerializer indexedListSerializer, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer) {
        super(indexedListSerializer, beanProperty, typeSerializer, jsonSerializer);
    }

    public final AsArraySerializerBase mo986a(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer jsonSerializer) {
        return new IndexedListSerializer(this, beanProperty, typeSerializer, jsonSerializer);
    }

    public final ContainerSerializer<?> mo853b(TypeSerializer typeSerializer) {
        return new IndexedListSerializer(this.f13794b, this.f13793a, typeSerializer, this.f13797e, this.f13796d);
    }

    private void m14546a(List<?> list, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, JsonSerializer<Object> jsonSerializer) {
        int size = list.size();
        if (size != 0) {
            TypeSerializer typeSerializer = this.f13795c;
            for (int i = 0; i < size; i++) {
                Object obj = list.get(i);
                if (obj == null) {
                    try {
                        serializerProvider.a(jsonGenerator);
                    } catch (Throwable e) {
                        StdSerializer.a(serializerProvider, e, list, i);
                    }
                } else if (typeSerializer == null) {
                    jsonSerializer.a(obj, jsonGenerator, serializerProvider);
                } else {
                    jsonSerializer.a(obj, jsonGenerator, serializerProvider, typeSerializer);
                }
            }
        }
    }

    private void m14547b(List<?> list, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        int size = list.size();
        if (size != 0) {
            int i = 0;
            try {
                TypeSerializer typeSerializer = this.f13795c;
                PropertySerializerMap propertySerializerMap = this.f13798f;
                while (i < size) {
                    Object obj = list.get(i);
                    if (obj == null) {
                        serializerProvider.a(jsonGenerator);
                    } else {
                        Class cls = obj.getClass();
                        JsonSerializer a = propertySerializerMap.mo48a(cls);
                        if (a == null) {
                            JsonSerializer a2;
                            if (this.f13794b.p()) {
                                a2 = m14554a(propertySerializerMap, serializerProvider.a(this.f13794b, cls), serializerProvider);
                            } else {
                                a2 = m14555a(propertySerializerMap, cls, serializerProvider);
                            }
                            JsonSerializer jsonSerializer = a2;
                            propertySerializerMap = this.f13798f;
                            a = jsonSerializer;
                        }
                        a.a(obj, jsonGenerator, serializerProvider, typeSerializer);
                    }
                    i++;
                }
            } catch (Throwable e) {
                StdSerializer.a(serializerProvider, e, list, 0);
            }
        }
    }
}
