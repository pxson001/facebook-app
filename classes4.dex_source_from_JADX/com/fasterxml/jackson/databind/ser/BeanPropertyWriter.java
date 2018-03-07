package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.Empty;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.SerializerAndMapResult;
import com.fasterxml.jackson.databind.ser.impl.UnwrappingBeanPropertyWriter;
import com.fasterxml.jackson.databind.util.Annotations;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;

/* compiled from: vbm */
public class BeanPropertyWriter implements BeanProperty {
    public static final Object f317a = new Object();
    protected final AnnotatedMember f318b;
    protected final Annotations f319c;
    protected final JavaType f320d;
    protected final Method f321e;
    protected final Field f322f;
    protected HashMap<Object, Object> f323g;
    protected final SerializedString f324h;
    protected final PropertyName f325i;
    public final JavaType f326j;
    protected JsonSerializer<Object> f327k;
    protected JsonSerializer<Object> f328l;
    protected PropertySerializerMap f329m;
    public final boolean f330n;
    protected final Object f331o;
    public final Class<?>[] f332p;
    protected TypeSerializer f333q;
    public JavaType f334r;
    protected final boolean f335s;

    public BeanPropertyWriter(BeanPropertyDefinition beanPropertyDefinition, AnnotatedMember annotatedMember, Annotations annotations, JavaType javaType, JsonSerializer<?> jsonSerializer, TypeSerializer typeSerializer, JavaType javaType2, boolean z, Object obj) {
        PropertySerializerMap propertySerializerMap;
        this.f318b = annotatedMember;
        this.f319c = annotations;
        this.f324h = new SerializedString(beanPropertyDefinition.mo22a());
        this.f325i = beanPropertyDefinition.mo23b();
        this.f320d = javaType;
        this.f327k = jsonSerializer;
        if (jsonSerializer == null) {
            propertySerializerMap = Empty.f359a;
        } else {
            propertySerializerMap = null;
        }
        this.f329m = propertySerializerMap;
        this.f333q = typeSerializer;
        this.f326j = javaType2;
        this.f335s = beanPropertyDefinition.mo39s();
        if (annotatedMember instanceof AnnotatedField) {
            this.f321e = null;
            this.f322f = (Field) annotatedMember.mo20j();
        } else if (annotatedMember instanceof AnnotatedMethod) {
            this.f321e = (Method) annotatedMember.mo20j();
            this.f322f = null;
        } else {
            throw new IllegalArgumentException("Can not pass member of type " + annotatedMember.getClass().getName());
        }
        this.f330n = z;
        this.f331o = obj;
        this.f332p = beanPropertyDefinition.mo36p();
        this.f328l = null;
    }

    protected BeanPropertyWriter(BeanPropertyWriter beanPropertyWriter) {
        this(beanPropertyWriter, beanPropertyWriter.f324h);
    }

    protected BeanPropertyWriter(BeanPropertyWriter beanPropertyWriter, SerializedString serializedString) {
        this.f324h = serializedString;
        this.f325i = beanPropertyWriter.f325i;
        this.f318b = beanPropertyWriter.f318b;
        this.f319c = beanPropertyWriter.f319c;
        this.f320d = beanPropertyWriter.f320d;
        this.f321e = beanPropertyWriter.f321e;
        this.f322f = beanPropertyWriter.f322f;
        this.f327k = beanPropertyWriter.f327k;
        this.f328l = beanPropertyWriter.f328l;
        if (beanPropertyWriter.f323g != null) {
            this.f323g = new HashMap(beanPropertyWriter.f323g);
        }
        this.f326j = beanPropertyWriter.f326j;
        this.f329m = beanPropertyWriter.f329m;
        this.f330n = beanPropertyWriter.f330n;
        this.f331o = beanPropertyWriter.f331o;
        this.f332p = beanPropertyWriter.f332p;
        this.f333q = beanPropertyWriter.f333q;
        this.f334r = beanPropertyWriter.f334r;
        this.f335s = beanPropertyWriter.f335s;
    }

    public BeanPropertyWriter m555a(NameTransformer nameTransformer) {
        String a = nameTransformer.a(this.f324h.a());
        return a.equals(this.f324h.toString()) ? this : new BeanPropertyWriter(this, new SerializedString(a));
    }

    public void m559a(JsonSerializer<Object> jsonSerializer) {
        if (this.f327k == null || this.f327k == jsonSerializer) {
            this.f327k = jsonSerializer;
            return;
        }
        throw new IllegalStateException("Can not override serializer");
    }

    public void m563b(JsonSerializer<Object> jsonSerializer) {
        if (this.f328l == null || this.f328l == jsonSerializer) {
            this.f328l = jsonSerializer;
            return;
        }
        throw new IllegalStateException("Can not override null serializer");
    }

    public final BeanPropertyWriter m562b(NameTransformer nameTransformer) {
        return new UnwrappingBeanPropertyWriter(this, nameTransformer);
    }

    public final void m558a(JavaType javaType) {
        this.f334r = javaType;
    }

    public final String m565c() {
        return this.f324h.a();
    }

    public final JavaType mo45a() {
        return this.f320d;
    }

    public final AnnotatedMember mo46b() {
        return this.f318b;
    }

    public final boolean m566d() {
        return this.f327k != null;
    }

    public final boolean m567e() {
        return this.f328l != null;
    }

    public final boolean m568f() {
        return this.f330n;
    }

    public final JavaType m569g() {
        return this.f326j;
    }

    public final Class<?> m570h() {
        if (this.f321e != null) {
            return this.f321e.getReturnType();
        }
        return this.f322f.getType();
    }

    public final Type m571i() {
        if (this.f321e != null) {
            return this.f321e.getGenericReturnType();
        }
        return this.f322f.getGenericType();
    }

    public final Class<?>[] m572j() {
        return this.f332p;
    }

    public void m560a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        Object a = m556a(obj);
        if (a != null) {
            JsonSerializer jsonSerializer = this.f327k;
            if (jsonSerializer == null) {
                Class cls = a.getClass();
                PropertySerializerMap propertySerializerMap = this.f329m;
                jsonSerializer = propertySerializerMap.mo48a(cls);
                if (jsonSerializer == null) {
                    jsonSerializer = m554a(propertySerializerMap, cls, serializerProvider);
                }
            }
            if (this.f331o != null) {
                if (f317a == this.f331o) {
                    if (jsonSerializer.a(a)) {
                        return;
                    }
                } else if (this.f331o.equals(a)) {
                    return;
                }
            }
            if (a == obj) {
                m552c(jsonSerializer);
            }
            jsonGenerator.b(this.f324h);
            if (this.f333q == null) {
                jsonSerializer.a(a, jsonGenerator, serializerProvider);
            } else {
                jsonSerializer.a(a, jsonGenerator, serializerProvider, this.f333q);
            }
        } else if (this.f328l != null) {
            jsonGenerator.b(this.f324h);
            this.f328l.a(null, jsonGenerator, serializerProvider);
        }
    }

    public void m564b(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        Object a = m556a(obj);
        if (a != null) {
            JsonSerializer jsonSerializer = this.f327k;
            if (jsonSerializer == null) {
                Class cls = a.getClass();
                PropertySerializerMap propertySerializerMap = this.f329m;
                jsonSerializer = propertySerializerMap.mo48a(cls);
                if (jsonSerializer == null) {
                    jsonSerializer = m554a(propertySerializerMap, cls, serializerProvider);
                }
            }
            if (this.f331o != null) {
                if (f317a == this.f331o) {
                    if (jsonSerializer.a(a)) {
                        m557a(jsonGenerator, serializerProvider);
                        return;
                    }
                } else if (this.f331o.equals(a)) {
                    m557a(jsonGenerator, serializerProvider);
                    return;
                }
            }
            if (a == obj) {
                m552c(jsonSerializer);
            }
            if (this.f333q == null) {
                jsonSerializer.a(a, jsonGenerator, serializerProvider);
            } else {
                jsonSerializer.a(a, jsonGenerator, serializerProvider, this.f333q);
            }
        } else if (this.f328l != null) {
            this.f328l.a(null, jsonGenerator, serializerProvider);
        } else {
            jsonGenerator.h();
        }
    }

    public final void m557a(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        if (this.f328l != null) {
            this.f328l.a(null, jsonGenerator, serializerProvider);
        } else {
            jsonGenerator.h();
        }
    }

    protected JsonSerializer<Object> m554a(PropertySerializerMap propertySerializerMap, Class<?> cls, SerializerProvider serializerProvider) {
        SerializerAndMapResult a;
        if (this.f334r != null) {
            a = propertySerializerMap.m602a(serializerProvider.a(this.f334r, cls), serializerProvider, (BeanProperty) this);
        } else {
            a = propertySerializerMap.m603a((Class) cls, serializerProvider, (BeanProperty) this);
        }
        if (propertySerializerMap != a.f392b) {
            this.f329m = a.f392b;
        }
        return a.f391a;
    }

    public final Object m556a(Object obj) {
        if (this.f321e != null) {
            return this.f321e.invoke(obj, new Object[0]);
        }
        return this.f322f.get(obj);
    }

    protected static void m552c(JsonSerializer<?> jsonSerializer) {
        if (!jsonSerializer.b()) {
            throw new JsonMappingException("Direct self-reference leading to cycle");
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(40);
        stringBuilder.append("property '").append(m565c()).append("' (");
        if (this.f321e != null) {
            stringBuilder.append("via method ").append(this.f321e.getDeclaringClass().getName()).append("#").append(this.f321e.getName());
        } else {
            stringBuilder.append("field \"").append(this.f322f.getDeclaringClass().getName()).append("#").append(this.f322f.getName());
        }
        if (this.f327k == null) {
            stringBuilder.append(", no static serializer");
        } else {
            stringBuilder.append(", static serializer of type " + this.f327k.getClass().getName());
        }
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
