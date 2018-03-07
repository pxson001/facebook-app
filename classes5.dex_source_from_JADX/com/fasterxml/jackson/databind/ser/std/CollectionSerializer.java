package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: can_viewer_rate */
public class CollectionSerializer extends AsArraySerializerBase<Collection<?>> {
    public final boolean m11647a(Object obj) {
        Collection collection = (Collection) obj;
        return collection == null || collection.isEmpty();
    }

    public final void m11649b(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        Collection collection = (Collection) obj;
        if (this.d != null) {
            m11645a(collection, jsonGenerator, serializerProvider, this.d);
            return;
        }
        Iterator it = collection.iterator();
        if (it.hasNext()) {
            PropertySerializerMap propertySerializerMap = this.f;
            TypeSerializer typeSerializer = this.c;
            int i = 0;
            do {
                try {
                    Object next = it.next();
                    if (next == null) {
                        serializerProvider.a(jsonGenerator);
                    } else {
                        Class cls = next.getClass();
                        JsonSerializer a = propertySerializerMap.a(cls);
                        if (a == null) {
                            JsonSerializer a2;
                            if (this.b.p()) {
                                a2 = a(propertySerializerMap, serializerProvider.a(this.b, cls), serializerProvider);
                            } else {
                                a2 = a(propertySerializerMap, cls, serializerProvider);
                            }
                            JsonSerializer jsonSerializer = a2;
                            propertySerializerMap = this.f;
                            a = jsonSerializer;
                        }
                        if (typeSerializer == null) {
                            a.a(next, jsonGenerator, serializerProvider);
                        } else {
                            a.a(next, jsonGenerator, serializerProvider, typeSerializer);
                        }
                    }
                    i++;
                } catch (Throwable e) {
                    StdSerializer.a(serializerProvider, e, collection, i);
                    return;
                }
            } while (it.hasNext());
        }
    }

    public final boolean m11650b(Object obj) {
        Iterator it = ((Collection) obj).iterator();
        if (!it.hasNext()) {
            return false;
        }
        it.next();
        if (it.hasNext()) {
            return false;
        }
        return true;
    }

    public CollectionSerializer(JavaType javaType, boolean z, TypeSerializer typeSerializer, BeanProperty beanProperty, JsonSerializer<Object> jsonSerializer) {
        super(Collection.class, javaType, z, typeSerializer, beanProperty, jsonSerializer);
    }

    private CollectionSerializer(CollectionSerializer collectionSerializer, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer) {
        super(collectionSerializer, beanProperty, typeSerializer, jsonSerializer);
    }

    public final ContainerSerializer<?> m11648b(TypeSerializer typeSerializer) {
        return new CollectionSerializer(this.b, this.a, typeSerializer, this.e, this.d);
    }

    public final AsArraySerializerBase m11646a(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer jsonSerializer) {
        return new CollectionSerializer(this, beanProperty, typeSerializer, jsonSerializer);
    }

    private void m11645a(Collection<?> collection, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, JsonSerializer<Object> jsonSerializer) {
        Iterator it = collection.iterator();
        if (it.hasNext()) {
            TypeSerializer typeSerializer = this.c;
            int i = 0;
            do {
                Object next = it.next();
                if (next == null) {
                    try {
                        serializerProvider.a(jsonGenerator);
                    } catch (Throwable e) {
                        StdSerializer.a(serializerProvider, e, collection, i);
                    }
                } else if (typeSerializer == null) {
                    jsonSerializer.a(next, jsonGenerator, serializerProvider);
                } else {
                    jsonSerializer.a(next, jsonGenerator, serializerProvider, typeSerializer);
                }
                i++;
            } while (it.hasNext());
        }
    }
}
