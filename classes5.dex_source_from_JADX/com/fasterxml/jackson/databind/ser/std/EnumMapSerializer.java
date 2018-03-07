package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.util.EnumValues;
import java.util.EnumMap;
import java.util.Map.Entry;

@JacksonStdImpl
/* compiled from: can_viewer_purchase_onsite_tickets */
public class EnumMapSerializer extends ContainerSerializer<EnumMap<? extends Enum<?>, ?>> implements ContextualSerializer {
    protected final boolean f6191a;
    protected final BeanProperty f6192b;
    protected final EnumValues f6193c;
    protected final JavaType f6194d;
    protected final JsonSerializer<Object> f6195e;
    protected final TypeSerializer f6196f;

    public final void m11655a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        EnumMap enumMap = (EnumMap) obj;
        jsonGenerator.f();
        if (!enumMap.isEmpty()) {
            m11653b(enumMap, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }

    public final void m11656a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        EnumMap enumMap = (EnumMap) obj;
        typeSerializer.mo707b(enumMap, jsonGenerator);
        if (!enumMap.isEmpty()) {
            m11653b(enumMap, jsonGenerator, serializerProvider);
        }
        typeSerializer.mo711e(enumMap, jsonGenerator);
    }

    public final boolean m11657a(Object obj) {
        EnumMap enumMap = (EnumMap) obj;
        return enumMap == null || enumMap.isEmpty();
    }

    public final boolean m11659b(Object obj) {
        return ((EnumMap) obj).size() == 1;
    }

    public EnumMapSerializer(JavaType javaType, boolean z, EnumValues enumValues, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        boolean z2 = false;
        super(EnumMap.class, false);
        this.f6192b = null;
        if (z || (javaType != null && javaType.k())) {
            z2 = true;
        }
        this.f6191a = z2;
        this.f6194d = javaType;
        this.f6193c = enumValues;
        this.f6196f = typeSerializer;
        this.f6195e = jsonSerializer;
    }

    private EnumMapSerializer(EnumMapSerializer enumMapSerializer, BeanProperty beanProperty, JsonSerializer<?> jsonSerializer) {
        super(enumMapSerializer);
        this.f6192b = beanProperty;
        this.f6191a = enumMapSerializer.f6191a;
        this.f6194d = enumMapSerializer.f6194d;
        this.f6193c = enumMapSerializer.f6193c;
        this.f6196f = enumMapSerializer.f6196f;
        this.f6195e = jsonSerializer;
    }

    public final ContainerSerializer m11658b(TypeSerializer typeSerializer) {
        return new EnumMapSerializer(this.f6194d, this.f6191a, this.f6193c, typeSerializer, this.f6195e);
    }

    private EnumMapSerializer m11651a(BeanProperty beanProperty, JsonSerializer<?> jsonSerializer) {
        return (this.f6192b == beanProperty && jsonSerializer == this.f6195e) ? this : new EnumMapSerializer(this, beanProperty, jsonSerializer);
    }

    public final JsonSerializer<?> m11654a(SerializerProvider serializerProvider, BeanProperty beanProperty) {
        JsonSerializer jsonSerializer = null;
        if (beanProperty != null) {
            AnnotatedMember b = beanProperty.b();
            if (b != null) {
                Object h = serializerProvider.e().h(b);
                if (h != null) {
                    jsonSerializer = serializerProvider.b(b, h);
                }
            }
        }
        if (jsonSerializer == null) {
            jsonSerializer = this.f6195e;
        }
        jsonSerializer = StdSerializer.a(serializerProvider, beanProperty, jsonSerializer);
        if (jsonSerializer == null) {
            if (this.f6191a) {
                return m11651a(beanProperty, serializerProvider.a(this.f6194d, beanProperty));
            }
        } else if (this.f6195e instanceof ContextualSerializer) {
            jsonSerializer = ((ContextualSerializer) jsonSerializer).a(serializerProvider, beanProperty);
        }
        if (jsonSerializer != this.f6195e) {
            return m11651a(beanProperty, jsonSerializer);
        }
        return this;
    }

    private void m11653b(EnumMap<? extends Enum<?>, ?> enumMap, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        if (this.f6195e != null) {
            m11652a((EnumMap) enumMap, jsonGenerator, serializerProvider, this.f6195e);
            return;
        }
        Object obj;
        EnumValues enumValues = this.f6193c;
        if (serializerProvider.a(SerializationFeature.WRITE_NULL_MAP_VALUES)) {
            obj = null;
        } else {
            obj = 1;
        }
        TypeSerializer typeSerializer = this.f6196f;
        Class cls = null;
        JsonSerializer jsonSerializer = null;
        EnumValues enumValues2 = enumValues;
        for (Entry entry : enumMap.entrySet()) {
            Object value = entry.getValue();
            if (obj == null || value != null) {
                Enum enumR = (Enum) entry.getKey();
                if (enumValues2 == null) {
                    enumValues2 = ((EnumSerializer) ((StdSerializer) serializerProvider.a(enumR.getDeclaringClass(), this.f6192b))).d();
                }
                jsonGenerator.b(enumValues2.a(enumR));
                if (value == null) {
                    serializerProvider.a(jsonGenerator);
                } else {
                    JsonSerializer jsonSerializer2;
                    Class cls2 = value.getClass();
                    if (cls2 == cls) {
                        cls2 = cls;
                        jsonSerializer2 = jsonSerializer;
                    } else {
                        jsonSerializer = serializerProvider.a(cls2, this.f6192b);
                        jsonSerializer2 = jsonSerializer;
                    }
                    if (typeSerializer == null) {
                        try {
                            jsonSerializer.a(value, jsonGenerator, serializerProvider);
                        } catch (Throwable e) {
                            StdSerializer.a(serializerProvider, e, enumMap, ((Enum) entry.getKey()).name());
                        }
                        jsonSerializer = jsonSerializer2;
                        cls = cls2;
                    } else {
                        jsonSerializer.a(value, jsonGenerator, serializerProvider, typeSerializer);
                        jsonSerializer = jsonSerializer2;
                        cls = cls2;
                    }
                }
            }
        }
    }

    private void m11652a(EnumMap<? extends Enum<?>, ?> enumMap, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, JsonSerializer<Object> jsonSerializer) {
        Object obj;
        EnumValues enumValues = this.f6193c;
        if (serializerProvider.a(SerializationFeature.WRITE_NULL_MAP_VALUES)) {
            obj = null;
        } else {
            obj = 1;
        }
        TypeSerializer typeSerializer = this.f6196f;
        EnumValues enumValues2 = enumValues;
        for (Entry entry : enumMap.entrySet()) {
            Object value = entry.getValue();
            if (obj == null || value != null) {
                Enum enumR = (Enum) entry.getKey();
                if (enumValues2 == null) {
                    enumValues2 = ((EnumSerializer) ((StdSerializer) serializerProvider.a(enumR.getDeclaringClass(), this.f6192b))).d();
                }
                jsonGenerator.b(enumValues2.a(enumR));
                if (value == null) {
                    serializerProvider.a(jsonGenerator);
                } else if (typeSerializer == null) {
                    try {
                        jsonSerializer.a(value, jsonGenerator, serializerProvider);
                    } catch (Throwable e) {
                        StdSerializer.a(serializerProvider, e, enumMap, ((Enum) entry.getKey()).name());
                    }
                } else {
                    jsonSerializer.a(value, jsonGenerator, serializerProvider, typeSerializer);
                }
            }
        }
    }
}
