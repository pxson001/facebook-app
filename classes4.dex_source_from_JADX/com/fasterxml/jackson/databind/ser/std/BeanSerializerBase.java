package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonMappingException.Reference;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.AnyGetterWriter;
import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerBuilder;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.ResolvableSerializer;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.fasterxml.jackson.databind.ser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.ser.impl.WritableObjectId;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: vault.table_refreshed_key */
public abstract class BeanSerializerBase extends StdSerializer<Object> implements ContextualSerializer, ResolvableSerializer {
    protected static final BeanPropertyWriter[] f361b = new BeanPropertyWriter[0];
    protected final BeanPropertyWriter[] f362c;
    protected final BeanPropertyWriter[] f363d;
    protected final AnyGetterWriter f364e;
    protected final Object f365f;
    protected final AnnotatedMember f366g;
    protected final ObjectIdWriter f367h;
    protected final Shape f368i;

    public abstract BeanSerializerBase mo50a(ObjectIdWriter objectIdWriter);

    protected abstract BeanSerializerBase mo51a(String[] strArr);

    protected abstract BeanSerializerBase mo52d();

    protected BeanSerializerBase(JavaType javaType, BeanSerializerBuilder beanSerializerBuilder, BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        Shape shape = null;
        super(javaType);
        this.f362c = beanPropertyWriterArr;
        this.f363d = beanPropertyWriterArr2;
        if (beanSerializerBuilder == null) {
            this.f366g = null;
            this.f364e = null;
            this.f365f = null;
            this.f367h = null;
        } else {
            this.f366g = beanSerializerBuilder.f315g;
            this.f364e = beanSerializerBuilder.f313e;
            this.f365f = beanSerializerBuilder.f314f;
            this.f367h = beanSerializerBuilder.f316h;
            Value a = beanSerializerBuilder.f309a.a(null);
            if (a != null) {
                shape = a.b;
            }
        }
        this.f368i = shape;
    }

    private BeanSerializerBase(BeanSerializerBase beanSerializerBase, BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        super(beanSerializerBase.k);
        this.f362c = beanPropertyWriterArr;
        this.f363d = beanPropertyWriterArr2;
        this.f366g = beanSerializerBase.f366g;
        this.f364e = beanSerializerBase.f364e;
        this.f367h = beanSerializerBase.f367h;
        this.f365f = beanSerializerBase.f365f;
        this.f368i = beanSerializerBase.f368i;
    }

    protected BeanSerializerBase(BeanSerializerBase beanSerializerBase, ObjectIdWriter objectIdWriter) {
        super(beanSerializerBase.k);
        this.f362c = beanSerializerBase.f362c;
        this.f363d = beanSerializerBase.f363d;
        this.f366g = beanSerializerBase.f366g;
        this.f364e = beanSerializerBase.f364e;
        this.f367h = objectIdWriter;
        this.f365f = beanSerializerBase.f365f;
        this.f368i = beanSerializerBase.f368i;
    }

    protected BeanSerializerBase(BeanSerializerBase beanSerializerBase, String[] strArr) {
        ArrayList arrayList;
        BeanPropertyWriter[] beanPropertyWriterArr = null;
        super(beanSerializerBase.k);
        HashSet a = ArrayBuilders.a(strArr);
        BeanPropertyWriter[] beanPropertyWriterArr2 = beanSerializerBase.f362c;
        BeanPropertyWriter[] beanPropertyWriterArr3 = beanSerializerBase.f363d;
        int length = beanPropertyWriterArr2.length;
        ArrayList arrayList2 = new ArrayList(length);
        if (beanPropertyWriterArr3 == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(length);
        }
        for (int i = 0; i < length; i++) {
            BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr2[i];
            if (!a.contains(beanPropertyWriter.m565c())) {
                arrayList2.add(beanPropertyWriter);
                if (beanPropertyWriterArr3 != null) {
                    arrayList.add(beanPropertyWriterArr3[i]);
                }
            }
        }
        this.f362c = (BeanPropertyWriter[]) arrayList2.toArray(new BeanPropertyWriter[arrayList2.size()]);
        if (arrayList != null) {
            beanPropertyWriterArr = (BeanPropertyWriter[]) arrayList.toArray(new BeanPropertyWriter[arrayList.size()]);
        }
        this.f363d = beanPropertyWriterArr;
        this.f366g = beanSerializerBase.f366g;
        this.f364e = beanSerializerBase.f364e;
        this.f367h = beanSerializerBase.f367h;
        this.f365f = beanSerializerBase.f365f;
        this.f368i = beanSerializerBase.f368i;
    }

    protected BeanSerializerBase(BeanSerializerBase beanSerializerBase, NameTransformer nameTransformer) {
        this(beanSerializerBase, m618a(beanSerializerBase.f362c, nameTransformer), m618a(beanSerializerBase.f363d, nameTransformer));
    }

    private static final BeanPropertyWriter[] m618a(BeanPropertyWriter[] beanPropertyWriterArr, NameTransformer nameTransformer) {
        if (beanPropertyWriterArr == null || beanPropertyWriterArr.length == 0 || nameTransformer == null || nameTransformer == NameTransformer.a) {
            return beanPropertyWriterArr;
        }
        int length = beanPropertyWriterArr.length;
        BeanPropertyWriter[] beanPropertyWriterArr2 = new BeanPropertyWriter[length];
        for (int i = 0; i < length; i++) {
            BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i];
            if (beanPropertyWriter != null) {
                beanPropertyWriterArr2[i] = beanPropertyWriter.m555a(nameTransformer);
            }
        }
        return beanPropertyWriterArr2;
    }

    public final void mo53a(SerializerProvider serializerProvider) {
        int i;
        if (this.f363d == null) {
            i = 0;
        } else {
            i = this.f363d.length;
        }
        int length = this.f362c.length;
        for (int i2 = 0; i2 < length; i2++) {
            BeanPropertyWriter beanPropertyWriter = this.f362c[i2];
            if (!(beanPropertyWriter.f330n || beanPropertyWriter.m567e())) {
                JsonSerializer l = serializerProvider.l();
                if (l != null) {
                    beanPropertyWriter.m563b(l);
                    if (i2 < i) {
                        BeanPropertyWriter beanPropertyWriter2 = this.f363d[i2];
                        if (beanPropertyWriter2 != null) {
                            beanPropertyWriter2.m563b(l);
                        }
                    }
                }
            }
            if (!beanPropertyWriter.m566d()) {
                JsonSerializer a = m617a(serializerProvider, beanPropertyWriter);
                if (a == null) {
                    JavaType javaType = beanPropertyWriter.f326j;
                    if (javaType == null) {
                        javaType = serializerProvider.a(beanPropertyWriter.m571i());
                        if (!javaType.k()) {
                            if (javaType.l() || javaType.s() > 0) {
                                beanPropertyWriter.f334r = javaType;
                            }
                        }
                    }
                    a = serializerProvider.a(javaType, beanPropertyWriter);
                    if (javaType.l()) {
                        TypeSerializer typeSerializer = (TypeSerializer) javaType.r().u();
                        if (typeSerializer != null && (a instanceof ContainerSerializer)) {
                            a = ((ContainerSerializer) a).m12005a(typeSerializer);
                        }
                    }
                }
                beanPropertyWriter.m559a(a);
                if (i2 < i) {
                    BeanPropertyWriter beanPropertyWriter3 = this.f363d[i2];
                    if (beanPropertyWriter3 != null) {
                        beanPropertyWriter3.m559a(a);
                    }
                }
            }
        }
        if (this.f364e != null) {
            this.f364e.a(serializerProvider);
        }
    }

    private static JsonSerializer<Object> m617a(SerializerProvider serializerProvider, BeanPropertyWriter beanPropertyWriter) {
        AnnotationIntrospector e = serializerProvider.e();
        if (e != null) {
            Object m = e.m(beanPropertyWriter.mo46b());
            if (m != null) {
                Converter a = serializerProvider.a(beanPropertyWriter.mo46b(), m);
                serializerProvider.c();
                JavaType c = a.m11550c();
                return new StdDelegatingSerializer(a, c, serializerProvider.a(c, beanPropertyWriter));
            }
        }
        return null;
    }

    public final JsonSerializer<?> m622a(SerializerProvider serializerProvider, BeanProperty beanProperty) {
        Annotated annotated;
        ObjectIdWriter a;
        String[] strArr;
        BeanSerializerBase a2;
        Value e;
        Shape shape = null;
        ObjectIdWriter objectIdWriter = this.f367h;
        AnnotationIntrospector e2 = serializerProvider.e();
        if (beanProperty == null || e2 == null) {
            annotated = null;
        } else {
            annotated = beanProperty.mo46b();
        }
        if (annotated != null) {
            String[] b = e2.b(annotated);
            ObjectIdInfo a3 = e2.a(annotated);
            String[] strArr2;
            if (a3 != null) {
                a3 = e2.a(annotated, a3);
                Type c = a3.c();
                JavaType javaType = serializerProvider.c().b(serializerProvider.a(c), ObjectIdGenerator.class)[0];
                if (c == PropertyGenerator.class) {
                    String a4 = a3.a();
                    int length = this.f362c.length;
                    int i = 0;
                    while (i != length) {
                        BeanPropertyWriter beanPropertyWriter = this.f362c[i];
                        if (a4.equals(beanPropertyWriter.m565c())) {
                            if (i > 0) {
                                System.arraycopy(this.f362c, 0, this.f362c, 1, i);
                                this.f362c[0] = beanPropertyWriter;
                                if (this.f363d != null) {
                                    BeanPropertyWriter beanPropertyWriter2 = this.f363d[i];
                                    System.arraycopy(this.f363d, 0, this.f363d, 1, i);
                                    this.f363d[0] = beanPropertyWriter2;
                                }
                            }
                            strArr2 = b;
                            a = ObjectIdWriter.a(beanPropertyWriter.mo45a(), null, new PropertyBasedObjectIdGenerator(a3, beanPropertyWriter), a3.d());
                            strArr = strArr2;
                        } else {
                            i++;
                        }
                    }
                    throw new IllegalArgumentException("Invalid Object Id definition for " + this.k.getName() + ": can not find property with name '" + a4 + "'");
                }
                strArr2 = b;
                a = ObjectIdWriter.a(javaType, a3.a(), serializerProvider.a(annotated, a3), a3.d());
                strArr = strArr2;
            } else if (objectIdWriter != null) {
                strArr2 = b;
                a = this.f367h.a(e2.a(annotated, new ObjectIdInfo("", null, null)).d());
                strArr = strArr2;
            } else {
                strArr2 = b;
                a = objectIdWriter;
                strArr = strArr2;
            }
        } else {
            a = objectIdWriter;
            strArr = null;
        }
        if (a != null) {
            a = a.a(serializerProvider.a(a.a, beanProperty));
            if (a != this.f367h) {
                a2 = mo50a(a);
                if (!(strArr == null || strArr.length == 0)) {
                    a2 = a2.mo51a(strArr);
                }
                if (annotated != null) {
                    e = e2.e(annotated);
                    if (e != null) {
                        shape = e.b();
                    }
                }
                if (shape == null) {
                    shape = this.f368i;
                }
                if (shape != Shape.ARRAY) {
                    return a2.mo52d();
                }
                return a2;
            }
        }
        a2 = this;
        a2 = a2.mo51a(strArr);
        if (annotated != null) {
            e = e2.e(annotated);
            if (e != null) {
                shape = e.b();
            }
        }
        if (shape == null) {
            shape = this.f368i;
        }
        if (shape != Shape.ARRAY) {
            return a2;
        }
        return a2.mo52d();
    }

    public final boolean m629b() {
        return this.f367h != null;
    }

    public void m626a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        if (this.f367h != null) {
            m621b(obj, jsonGenerator, serializerProvider, typeSerializer);
            return;
        }
        String b = this.f366g == null ? null : m620b(obj);
        if (b == null) {
            typeSerializer.b(obj, jsonGenerator);
        } else {
            typeSerializer.a(obj, jsonGenerator, b);
        }
        if (this.f365f != null) {
            m630c(obj, jsonGenerator, serializerProvider);
        } else {
            m628b(obj, jsonGenerator, serializerProvider);
        }
        if (b == null) {
            typeSerializer.e(obj, jsonGenerator);
        } else {
            typeSerializer.b(obj, jsonGenerator, b);
        }
    }

    protected final void m627a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, boolean z) {
        ObjectIdWriter objectIdWriter = this.f367h;
        WritableObjectId a = serializerProvider.a(obj, objectIdWriter.c);
        if (!a.a(jsonGenerator, serializerProvider, objectIdWriter)) {
            Object a2 = a.a(obj);
            if (objectIdWriter.e) {
                objectIdWriter.d.a(a2, jsonGenerator, serializerProvider);
                return;
            }
            if (z) {
                jsonGenerator.f();
            }
            a.b(jsonGenerator, serializerProvider, objectIdWriter);
            if (this.f365f != null) {
                m630c(obj, jsonGenerator, serializerProvider);
            } else {
                m628b(obj, jsonGenerator, serializerProvider);
            }
            if (z) {
                jsonGenerator.g();
            }
        }
    }

    private void m621b(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        ObjectIdWriter objectIdWriter = this.f367h;
        WritableObjectId a = serializerProvider.a(obj, objectIdWriter.c);
        if (!a.a(jsonGenerator, serializerProvider, objectIdWriter)) {
            Object a2 = a.a(obj);
            if (objectIdWriter.e) {
                objectIdWriter.d.a(a2, jsonGenerator, serializerProvider);
                return;
            }
            String b = this.f366g == null ? null : m620b(obj);
            if (b == null) {
                typeSerializer.b(obj, jsonGenerator);
            } else {
                typeSerializer.a(obj, jsonGenerator, b);
            }
            a.b(jsonGenerator, serializerProvider, objectIdWriter);
            if (this.f365f != null) {
                m630c(obj, jsonGenerator, serializerProvider);
            } else {
                m628b(obj, jsonGenerator, serializerProvider);
            }
            if (b == null) {
                typeSerializer.e(obj, jsonGenerator);
            } else {
                typeSerializer.b(obj, jsonGenerator, b);
            }
        }
    }

    private final String m620b(Object obj) {
        Object b = this.f366g.mo18b(obj);
        if (b == null) {
            return "";
        }
        return b instanceof String ? (String) b : b.toString();
    }

    protected final void m628b(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        BeanPropertyWriter[] beanPropertyWriterArr;
        if (this.f363d == null || serializerProvider.f() == null) {
            beanPropertyWriterArr = this.f362c;
        } else {
            beanPropertyWriterArr = this.f363d;
        }
        int i = 0;
        try {
            int length = beanPropertyWriterArr.length;
            while (i < length) {
                BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i];
                if (beanPropertyWriter != null) {
                    beanPropertyWriter.m560a(obj, jsonGenerator, serializerProvider);
                }
                i++;
            }
            if (this.f364e != null) {
                this.f364e.a(obj, jsonGenerator, serializerProvider);
            }
        } catch (Throwable e) {
            StdSerializer.a(serializerProvider, e, obj, 0 == beanPropertyWriterArr.length ? "[anySetter]" : beanPropertyWriterArr[0].m565c());
        } catch (Throwable e2) {
            JsonMappingException jsonMappingException = new JsonMappingException("Infinite recursion (StackOverflowError)", e2);
            jsonMappingException.m1250a(new Reference(obj, 0 == beanPropertyWriterArr.length ? "[anySetter]" : beanPropertyWriterArr[0].m565c()));
            throw jsonMappingException;
        }
    }

    protected final void m630c(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        BeanPropertyWriter[] beanPropertyWriterArr;
        if (this.f363d == null || serializerProvider.f() == null) {
            beanPropertyWriterArr = this.f362c;
        } else {
            beanPropertyWriterArr = this.f363d;
        }
        if (m619b(serializerProvider) == null) {
            m628b(obj, jsonGenerator, serializerProvider);
            return;
        }
        int i = 0;
        try {
            while (i < beanPropertyWriterArr.length) {
                i++;
            }
            if (this.f364e != null) {
                this.f364e.a(obj, jsonGenerator, serializerProvider);
            }
        } catch (Throwable e) {
            StdSerializer.a(serializerProvider, e, obj, 0 == beanPropertyWriterArr.length ? "[anySetter]" : beanPropertyWriterArr[0].m565c());
        } catch (Throwable e2) {
            JsonMappingException jsonMappingException = new JsonMappingException("Infinite recursion (StackOverflowError)", e2);
            jsonMappingException.m1250a(new Reference(obj, 0 == beanPropertyWriterArr.length ? "[anySetter]" : beanPropertyWriterArr[0].m565c()));
            throw jsonMappingException;
        }
    }

    private BeanPropertyFilter m619b(SerializerProvider serializerProvider) {
        Object obj = this.f365f;
        FilterProvider g = serializerProvider.g();
        if (g != null) {
            return g.a();
        }
        throw new JsonMappingException("Can not resolve BeanPropertyFilter with id '" + obj + "'; no FilterProvider configured");
    }
}
