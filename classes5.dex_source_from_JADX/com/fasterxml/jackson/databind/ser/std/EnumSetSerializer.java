package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import java.util.EnumSet;
import java.util.Iterator;

/* compiled from: can_viewer_promote_website */
public class EnumSetSerializer extends AsArraySerializerBase<EnumSet<? extends Enum<?>>> {
    public final boolean m11661a(Object obj) {
        EnumSet enumSet = (EnumSet) obj;
        return enumSet == null || enumSet.isEmpty();
    }

    public final void m11663b(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        EnumSet enumSet = (EnumSet) obj;
        JsonSerializer jsonSerializer = this.d;
        Iterator it = enumSet.iterator();
        JsonSerializer jsonSerializer2 = jsonSerializer;
        while (it.hasNext()) {
            Enum enumR = (Enum) it.next();
            if (jsonSerializer2 == null) {
                jsonSerializer2 = serializerProvider.a(enumR.getDeclaringClass(), this.e);
            }
            jsonSerializer2.a(enumR, jsonGenerator, serializerProvider);
        }
    }

    public final boolean m11664b(Object obj) {
        return ((EnumSet) obj).size() == 1;
    }

    public EnumSetSerializer(JavaType javaType, BeanProperty beanProperty) {
        super(EnumSet.class, javaType, true, null, beanProperty, null);
    }

    private EnumSetSerializer(EnumSetSerializer enumSetSerializer, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer) {
        super(enumSetSerializer, beanProperty, typeSerializer, jsonSerializer);
    }

    public final ContainerSerializer m11662b(TypeSerializer typeSerializer) {
        return this;
    }

    public final AsArraySerializerBase m11660a(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer jsonSerializer) {
        return new EnumSetSerializer(this, beanProperty, typeSerializer, jsonSerializer);
    }
}
