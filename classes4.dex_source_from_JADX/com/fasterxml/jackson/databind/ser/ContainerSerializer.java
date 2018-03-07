package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/* compiled from: flush_tag */
public abstract class ContainerSerializer<T> extends StdSerializer<T> {
    protected abstract ContainerSerializer<?> mo853b(TypeSerializer typeSerializer);

    public abstract boolean mo854b(T t);

    protected ContainerSerializer(Class<T> cls) {
        super(cls);
    }

    protected ContainerSerializer(Class<?> cls, boolean z) {
        super(cls, (byte) 0);
    }

    protected ContainerSerializer(ContainerSerializer<?> containerSerializer) {
        super(containerSerializer.k, (byte) 0);
    }

    public final ContainerSerializer<?> m12005a(TypeSerializer typeSerializer) {
        return typeSerializer == null ? this : mo853b(typeSerializer);
    }

    protected static boolean a_(SerializerProvider serializerProvider, BeanProperty beanProperty) {
        if (beanProperty != null) {
            AnnotationIntrospector e = serializerProvider.e();
            if (!(e == null || e.k(beanProperty.mo46b()) == null)) {
                return true;
            }
        }
        return false;
    }
}
