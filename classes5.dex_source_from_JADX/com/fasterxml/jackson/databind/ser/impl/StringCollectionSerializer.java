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
import java.util.Collection;

@JacksonStdImpl
/* compiled from: can_viewer_save */
public class StringCollectionSerializer extends StaticListSerializerBase<Collection<String>> implements ContextualSerializer {
    public static final StringCollectionSerializer f6182a = new StringCollectionSerializer();
    protected final JsonSerializer<String> f6183b;

    public final void m11627a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        Collection collection = (Collection) obj;
        if (collection.size() == 1 && serializerProvider.a(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) {
            m11623b(collection, jsonGenerator, serializerProvider);
            return;
        }
        jsonGenerator.d();
        if (this.f6183b == null) {
            m11624c(collection, jsonGenerator, serializerProvider);
        } else {
            m11625d(collection, jsonGenerator, serializerProvider);
        }
        jsonGenerator.e();
    }

    public final void m11628a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        Collection collection = (Collection) obj;
        typeSerializer.mo709c(collection, jsonGenerator);
        if (this.f6183b == null) {
            m11624c(collection, jsonGenerator, serializerProvider);
        } else {
            m11625d(collection, jsonGenerator, serializerProvider);
        }
        typeSerializer.mo712f(collection, jsonGenerator);
    }

    protected StringCollectionSerializer() {
        this(null);
    }

    private StringCollectionSerializer(JsonSerializer<?> jsonSerializer) {
        super(Collection.class);
        this.f6183b = jsonSerializer;
    }

    public final JsonSerializer<?> m11626a(SerializerProvider serializerProvider, BeanProperty beanProperty) {
        JsonSerializer b;
        if (beanProperty != null) {
            AnnotatedMember b2 = beanProperty.b();
            if (b2 != null) {
                Object h = serializerProvider.e().h(b2);
                if (h != null) {
                    b = serializerProvider.b(b2, h);
                    if (b == null) {
                        b = this.f6183b;
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
                    if (b == this.f6183b) {
                        return this;
                    }
                    this(b);
                    return this;
                }
            }
        }
        b = null;
        if (b == null) {
            b = this.f6183b;
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
        if (b == this.f6183b) {
            return this;
        }
        this(b);
        return this;
    }

    private final void m11623b(Collection<String> collection, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        if (this.f6183b == null) {
            m11624c(collection, jsonGenerator, serializerProvider);
        } else {
            m11625d(collection, jsonGenerator, serializerProvider);
        }
    }

    private final void m11624c(Collection<String> collection, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        if (this.f6183b != null) {
            m11625d(collection, jsonGenerator, serializerProvider);
            return;
        }
        int i = 0;
        for (String str : collection) {
            if (str == null) {
                try {
                    serializerProvider.a(jsonGenerator);
                } catch (Throwable e) {
                    StdSerializer.a(serializerProvider, e, collection, i);
                }
            } else {
                jsonGenerator.b(str);
            }
            i++;
        }
    }

    private void m11625d(Collection<String> collection, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        JsonSerializer jsonSerializer = this.f6183b;
        for (String str : collection) {
            if (str == null) {
                try {
                    serializerProvider.a(jsonGenerator);
                } catch (Throwable e) {
                    StdSerializer.a(serializerProvider, e, collection, 0);
                }
            } else {
                jsonSerializer.a(str, jsonGenerator, serializerProvider);
            }
        }
    }
}
