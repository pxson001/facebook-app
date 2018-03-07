package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.std.ArraySerializerBase;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.databind.type.TypeFactory;

@JacksonStdImpl
/* compiled from: can_viewer_send_message_to_guests */
public class StringArraySerializer extends ArraySerializerBase<String[]> implements ContextualSerializer {
    public static final StringArraySerializer f6179a = new StringArraySerializer();
    private static final JavaType f6180d = TypeFactory.a(String.class);
    protected final JsonSerializer<Object> f6181b;

    public final boolean m11619a(Object obj) {
        String[] strArr = (String[]) obj;
        return strArr == null || strArr.length == 0;
    }

    public final void mo726b(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        String[] strArr = (String[]) obj;
        int length = strArr.length;
        if (length != 0) {
            if (this.f6181b != null) {
                m11617a(strArr, jsonGenerator, serializerProvider, this.f6181b);
                return;
            }
            for (int i = 0; i < length; i++) {
                if (strArr[i] == null) {
                    jsonGenerator.h();
                } else {
                    jsonGenerator.b(strArr[i]);
                }
            }
        }
    }

    public final boolean m11622b(Object obj) {
        return ((String[]) obj).length == 1;
    }

    protected StringArraySerializer() {
        super(String[].class, null);
        this.f6181b = null;
    }

    private StringArraySerializer(StringArraySerializer stringArraySerializer, BeanProperty beanProperty, JsonSerializer<?> jsonSerializer) {
        super((ArraySerializerBase) stringArraySerializer, beanProperty);
        this.f6181b = jsonSerializer;
    }

    public final ContainerSerializer<?> m11620b(TypeSerializer typeSerializer) {
        return this;
    }

    public final JsonSerializer<?> m11618a(SerializerProvider serializerProvider, BeanProperty beanProperty) {
        JsonSerializer b;
        if (beanProperty != null) {
            AnnotatedMember b2 = beanProperty.b();
            if (b2 != null) {
                Object h = serializerProvider.e().h(b2);
                if (h != null) {
                    b = serializerProvider.b(b2, h);
                    if (b == null) {
                        b = this.f6181b;
                    }
                    b = StdSerializer.a(serializerProvider, beanProperty, b);
                    if (b == null) {
                        b = serializerProvider.a(String.class, beanProperty);
                    } else if (b instanceof ContextualSerializer) {
                        b = ((ContextualSerializer) b).a(serializerProvider, beanProperty);
                    }
                    if (StdSerializer.a(b)) {
                        b = null;
                    }
                    return b != this.f6181b ? this : new StringArraySerializer(this, beanProperty, b);
                }
            }
        }
        b = null;
        if (b == null) {
            b = this.f6181b;
        }
        b = StdSerializer.a(serializerProvider, beanProperty, b);
        if (b == null) {
            b = serializerProvider.a(String.class, beanProperty);
        } else if (b instanceof ContextualSerializer) {
            b = ((ContextualSerializer) b).a(serializerProvider, beanProperty);
        }
        if (StdSerializer.a(b)) {
            b = null;
        }
        if (b != this.f6181b) {
        }
    }

    static {
        TypeFactory typeFactory = TypeFactory.a;
    }

    private static void m11617a(String[] strArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, JsonSerializer<Object> jsonSerializer) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (strArr[i] == null) {
                serializerProvider.a(jsonGenerator);
            } else {
                jsonSerializer.a(strArr[i], jsonGenerator, serializerProvider);
            }
        }
    }
}
