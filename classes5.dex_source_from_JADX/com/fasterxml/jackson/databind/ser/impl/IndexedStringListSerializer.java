package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.util.List;

@JacksonStdImpl
/* compiled from: can_watch_and_browse */
public final class IndexedStringListSerializer extends StaticListSerializerBase<List<String>> implements ContextualSerializer {
    public static final IndexedStringListSerializer f6164a = new IndexedStringListSerializer();
    protected final JsonSerializer<String> f6165b;

    public final void m11595a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        List list = (List) obj;
        int size = list.size();
        if (size == 1 && serializerProvider.a(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) {
            m11592b(list, jsonGenerator, serializerProvider);
            return;
        }
        jsonGenerator.d();
        if (this.f6165b == null) {
            m11591a(list, jsonGenerator, serializerProvider, size);
        } else {
            m11593b(list, jsonGenerator, serializerProvider, size);
        }
        jsonGenerator.e();
    }

    public final void m11596a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        List list = (List) obj;
        int size = list.size();
        typeSerializer.mo709c(list, jsonGenerator);
        if (this.f6165b == null) {
            m11591a(list, jsonGenerator, serializerProvider, size);
        } else {
            m11593b(list, jsonGenerator, serializerProvider, size);
        }
        typeSerializer.mo712f(list, jsonGenerator);
    }

    protected IndexedStringListSerializer() {
        this(null);
    }

    private IndexedStringListSerializer(JsonSerializer<?> jsonSerializer) {
        super(List.class);
        this.f6165b = jsonSerializer;
    }

    public final JsonSerializer<?> m11594a(SerializerProvider serializerProvider, BeanProperty beanProperty) {
        JsonSerializer b;
        if (beanProperty != null) {
            AnnotatedMember b2 = beanProperty.b();
            if (b2 != null) {
                Object h = serializerProvider.e().h(b2);
                if (h != null) {
                    b = serializerProvider.b(b2, h);
                    if (b == null) {
                        b = this.f6165b;
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
                    if (b == this.f6165b) {
                        return this;
                    }
                    this(b);
                    return this;
                }
            }
        }
        b = null;
        if (b == null) {
            b = this.f6165b;
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
        if (b == this.f6165b) {
            return this;
        }
        this(b);
        return this;
    }

    private final void m11592b(List<String> list, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        if (this.f6165b == null) {
            m11591a((List) list, jsonGenerator, serializerProvider, 1);
        } else {
            m11593b(list, jsonGenerator, serializerProvider, 1);
        }
    }

    private final void m11591a(List<String> list, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, int i) {
        int i2 = 0;
        while (i2 < i) {
            try {
                String str = (String) list.get(i2);
                if (str == null) {
                    serializerProvider.a(jsonGenerator);
                } else {
                    jsonGenerator.b(str);
                }
                i2++;
            } catch (Throwable e) {
                StdSerializer.a(serializerProvider, e, list, i2);
                return;
            }
        }
    }

    private final void m11593b(List<String> list, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, int i) {
        int i2 = 0;
        try {
            JsonSerializer jsonSerializer = this.f6165b;
            while (i2 < i) {
                String str = (String) list.get(i2);
                if (str == null) {
                    serializerProvider.a(jsonGenerator);
                } else {
                    jsonSerializer.a(str, jsonGenerator, serializerProvider);
                }
                i2++;
            }
        } catch (Throwable e) {
            StdSerializer.a(serializerProvider, e, list, 0);
        }
    }
}
