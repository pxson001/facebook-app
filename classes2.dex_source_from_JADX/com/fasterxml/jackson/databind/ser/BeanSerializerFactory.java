package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty.Std;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.impl.FilteredBeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.fasterxml.jackson.databind.ser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import com.fasterxml.jackson.databind.ser.std.StdDelegatingSerializer;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: start_date */
public class BeanSerializerFactory extends BasicSerializerFactory implements Serializable {
    public static final BeanSerializerFactory f4161c = new BeanSerializerFactory(null);
    private static final long serialVersionUID = 1;

    private BeanSerializerFactory(SerializerFactoryConfig serializerFactoryConfig) {
        super(serializerFactoryConfig);
    }

    public final SerializerFactory mo1096a(SerializerFactoryConfig serializerFactoryConfig) {
        if (this._factoryConfig == serializerFactoryConfig) {
            return this;
        }
        if (getClass() != BeanSerializerFactory.class) {
            throw new IllegalStateException("Subtype of BeanSerializerFactory (" + getClass().getName() + ") has not properly overridden method 'withAdditionalSerializers': can not instantiate subtype with additional serializer definitions");
        }
        this(serializerFactoryConfig);
        return this;
    }

    protected final Iterable<Serializers> mo1097a() {
        return this._factoryConfig.m7723c();
    }

    public final JsonSerializer<Object> mo1095a(SerializerProvider serializerProvider, JavaType javaType) {
        SerializationConfig serializationConfig = serializerProvider._config;
        BeanDescription b = serializationConfig.m7243b(javaType);
        JsonSerializer<Object> a = m7578a(serializerProvider, b.mo949c());
        if (a != null) {
            return a;
        }
        boolean z;
        JavaType a2 = BasicSerializerFactory.m7558a(serializationConfig, b.mo949c(), javaType);
        if (a2 == javaType) {
            z = false;
        } else if (a2.m6717g(javaType._class)) {
            z = true;
        } else {
            b = serializationConfig.m7243b(a2);
            z = true;
        }
        Converter q = b.mo963q();
        if (q == null) {
            return m7554c(serializerProvider, a2, b, z);
        }
        serializerProvider.mo1071c();
        JavaType c = q.c();
        if (!c.m6717g(a2._class)) {
            b = serializationConfig.m7243b(c);
        }
        return new StdDelegatingSerializer(q, c, m7554c(serializerProvider, c, b, true));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.fasterxml.jackson.databind.JsonSerializer<?> m7554c(com.fasterxml.jackson.databind.SerializerProvider r6, com.fasterxml.jackson.databind.JavaType r7, com.fasterxml.jackson.databind.BeanDescription r8, boolean r9) {
        /*
        r5 = this;
        r0 = r5.m7576a(r6, r7, r8);
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return r0;
    L_0x0007:
        r4 = r6._config;
        r1 = r4;
        r2 = r7.mo924l();
        if (r2 == 0) goto L_0x0054;
    L_0x0010:
        if (r9 != 0) goto L_0x0017;
    L_0x0012:
        r0 = 0;
        r9 = com.fasterxml.jackson.databind.ser.BasicSerializerFactory.m7565a(r1, r8, r0);
    L_0x0017:
        r0 = r5.m7584b(r6, r7, r8, r9);
        if (r0 != 0) goto L_0x0006;
    L_0x001d:
        if (r0 != 0) goto L_0x0035;
    L_0x001f:
        r0 = com.fasterxml.jackson.databind.ser.BasicSerializerFactory.m7559a(r7);
        if (r0 != 0) goto L_0x0035;
    L_0x0025:
        r0 = r5.m7577a(r6, r7, r8, r9);
        if (r0 != 0) goto L_0x0035;
    L_0x002b:
        r0 = r5.m7551b(r6, r7, r8);
        if (r0 != 0) goto L_0x0035;
    L_0x0031:
        r0 = r5.m7574a(r1, r7, r8, r9);
    L_0x0035:
        if (r0 == 0) goto L_0x0006;
    L_0x0037:
        r1 = r5._factoryConfig;
        r1 = r1.m7722b();
        if (r1 == 0) goto L_0x0006;
    L_0x003f:
        r1 = r5._factoryConfig;
        r1 = r1.m7725e();
        r1 = r1.iterator();
    L_0x0049:
        r2 = r1.hasNext();
        if (r2 == 0) goto L_0x0006;
    L_0x004f:
        r1.next();
        r0 = r0;
        goto L_0x0049;
    L_0x0054:
        r2 = r5.mo1097a();
        r2 = r2.iterator();
    L_0x005c:
        r3 = r2.hasNext();
        if (r3 == 0) goto L_0x001d;
    L_0x0062:
        r0 = r2.next();
        r0 = (com.fasterxml.jackson.databind.ser.Serializers) r0;
        r0 = r0.mo1152a(r1, r7, r8);
        if (r0 != 0) goto L_0x001d;
    L_0x006e:
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.BeanSerializerFactory.c(com.fasterxml.jackson.databind.SerializerProvider, com.fasterxml.jackson.databind.JavaType, com.fasterxml.jackson.databind.BeanDescription, boolean):com.fasterxml.jackson.databind.JsonSerializer<?>");
    }

    private JsonSerializer<Object> m7551b(SerializerProvider serializerProvider, JavaType javaType, BeanDescription beanDescription) {
        if (m7550a(javaType._class) || javaType.m6718h()) {
            return m7538a(serializerProvider, beanDescription);
        }
        return null;
    }

    private TypeSerializer m7539a(JavaType javaType, SerializationConfig serializationConfig, AnnotatedMember annotatedMember) {
        AnnotationIntrospector a = serializationConfig.mo1061a();
        TypeResolverBuilder a2 = a.mo975a((MapperConfig) serializationConfig, annotatedMember, javaType);
        if (a2 == null) {
            return mo1099a(serializationConfig, javaType);
        }
        return a2.a(serializationConfig, javaType, serializationConfig._subtypeResolver.mo1060a(annotatedMember, serializationConfig, a, javaType));
    }

    private TypeSerializer m7552b(JavaType javaType, SerializationConfig serializationConfig, AnnotatedMember annotatedMember) {
        JavaType r = javaType.m6728r();
        AnnotationIntrospector a = serializationConfig.mo1061a();
        TypeResolverBuilder b = a.mo980b(serializationConfig, annotatedMember, javaType);
        if (b == null) {
            return mo1099a(serializationConfig, r);
        }
        return b.a(serializationConfig, r, serializationConfig._subtypeResolver.mo1060a(annotatedMember, serializationConfig, a, r));
    }

    private JsonSerializer<Object> m7538a(SerializerProvider serializerProvider, BeanDescription beanDescription) {
        if (beanDescription.m6849b() == Object.class) {
            return serializerProvider._unknownTypeSerializer;
        }
        List list;
        BeanSerializerBuilder beanSerializerBuilder;
        SerializationConfig d = serializerProvider.m7321d();
        BeanSerializerBuilder a = m7542a(beanDescription);
        a.b = d;
        List a2 = m7546a(serializerProvider, beanDescription, a);
        if (a2 == null) {
            a2 = new ArrayList();
        }
        if (this._factoryConfig.m7722b()) {
            list = a2;
            for (BeanSerializerModifier a3 : this._factoryConfig.m7725e()) {
                list = a3.mo1159a(list);
            }
        } else {
            list = a2;
        }
        a2 = m7545a(d, beanDescription, list);
        if (this._factoryConfig.m7722b()) {
            Iterator it = this._factoryConfig.m7725e().iterator();
            while (it.hasNext()) {
                it.next();
                a2 = a2;
            }
        }
        a.h = m7544a(serializerProvider, beanDescription, a2);
        a.c = a2;
        a.f = m7553b(d, beanDescription);
        AnnotatedMember n = beanDescription.mo960n();
        if (n != null) {
            if (d.m7263h()) {
                n.k();
            }
            JavaType a4 = n.m6796a(beanDescription.mo952f());
            boolean a5 = d.m7257a(MapperFeature.USE_STATIC_TYPING);
            JavaType r = a4.m6728r();
            a.e = new AnyGetterWriter(new Std(n.mo938b(), r, null, beanDescription.mo953g(), n, false), n, MapSerializer.a(null, a4, a5, mo1099a(d, r), null, null));
        }
        m7547a(d, a);
        if (this._factoryConfig.m7722b()) {
            Iterator it2 = this._factoryConfig.m7725e().iterator();
            beanSerializerBuilder = a;
            while (it2.hasNext()) {
                it2.next();
                beanSerializerBuilder = beanSerializerBuilder;
            }
        } else {
            beanSerializerBuilder = a;
        }
        JsonSerializer<Object> g = beanSerializerBuilder.g();
        return (g == null && beanDescription.mo951e()) ? beanSerializerBuilder.h() : g;
    }

    private static ObjectIdWriter m7544a(SerializerProvider serializerProvider, BeanDescription beanDescription, List<BeanPropertyWriter> list) {
        ObjectIdInfo d = beanDescription.mo950d();
        if (d == null) {
            return null;
        }
        Type type = d.b;
        if (type == PropertyGenerator.class) {
            String str = d.a;
            int size = list.size();
            for (int i = 0; i != size; i++) {
                BeanPropertyWriter beanPropertyWriter = (BeanPropertyWriter) list.get(i);
                if (str.equals(beanPropertyWriter.c())) {
                    if (i > 0) {
                        list.remove(i);
                        list.add(0, beanPropertyWriter);
                    }
                    return ObjectIdWriter.a(beanPropertyWriter.a(), null, new PropertyBasedObjectIdGenerator(d, beanPropertyWriter), d.d);
                }
            }
            throw new IllegalArgumentException("Invalid Object Id definition for " + beanDescription.m6849b().getName() + ": can not find property with name '" + str + "'");
        }
        return ObjectIdWriter.a(serializerProvider.mo1071c().m7116b(serializerProvider.m7333a(type), ObjectIdGenerator.class)[0], d.a, serializerProvider.m7331a(beanDescription.mo949c(), d), d.d);
    }

    private static BeanPropertyWriter m7541a(BeanPropertyWriter beanPropertyWriter, Class<?>[] clsArr) {
        return FilteredBeanPropertyWriter.a(beanPropertyWriter, clsArr);
    }

    private static PropertyBuilder m7543a(SerializationConfig serializationConfig, BeanDescription beanDescription) {
        return new PropertyBuilder(serializationConfig, beanDescription);
    }

    private static BeanSerializerBuilder m7542a(BeanDescription beanDescription) {
        return new BeanSerializerBuilder(beanDescription);
    }

    private static Object m7553b(SerializationConfig serializationConfig, BeanDescription beanDescription) {
        return serializationConfig.mo1061a().mo990d(beanDescription.mo949c());
    }

    private static boolean m7550a(Class<?> cls) {
        return ClassUtil.a(cls) == null && !ClassUtil.c(cls);
    }

    private List<BeanPropertyWriter> m7546a(SerializerProvider serializerProvider, BeanDescription beanDescription, BeanSerializerBuilder beanSerializerBuilder) {
        List<BeanPropertyDefinition> h = beanDescription.mo954h();
        SerializationConfig serializationConfig = serializerProvider._config;
        m7548a(serializationConfig, (List) h);
        if (serializationConfig.m7257a(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS)) {
            m7549a((List) h);
        }
        if (h.isEmpty()) {
            return null;
        }
        boolean a = BasicSerializerFactory.m7565a(serializationConfig, beanDescription, null);
        PropertyBuilder a2 = m7543a(serializationConfig, beanDescription);
        ArrayList arrayList = new ArrayList(h.size());
        TypeBindings f = beanDescription.mo952f();
        for (BeanPropertyDefinition beanPropertyDefinition : h) {
            AnnotatedMember m = beanPropertyDefinition.m();
            if (!beanPropertyDefinition.r()) {
                ReferenceProperty q = beanPropertyDefinition.q();
                if (q == null || !q.c()) {
                    if (m instanceof AnnotatedMethod) {
                        arrayList.add(m7540a(serializerProvider, beanPropertyDefinition, f, a2, a, (AnnotatedMethod) m));
                    } else {
                        arrayList.add(m7540a(serializerProvider, beanPropertyDefinition, f, a2, a, (AnnotatedField) m));
                    }
                }
            } else if (m != null) {
                if (serializationConfig.m7263h()) {
                    m.k();
                }
                beanSerializerBuilder.a(m);
            }
        }
        return arrayList;
    }

    private static List<BeanPropertyWriter> m7545a(SerializationConfig serializationConfig, BeanDescription beanDescription, List<BeanPropertyWriter> list) {
        Object[] b = serializationConfig.mo1061a().mo985b(beanDescription.mo949c());
        if (b != null && b.length > 0) {
            HashSet a = ArrayBuilders.m7771a(b);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (a.contains(((BeanPropertyWriter) it.next()).c())) {
                    it.remove();
                }
            }
        }
        return list;
    }

    private void m7547a(SerializationConfig serializationConfig, BeanSerializerBuilder beanSerializerBuilder) {
        List list = beanSerializerBuilder.c;
        boolean a = serializationConfig.m7257a(MapperFeature.DEFAULT_VIEW_INCLUSION);
        int size = list.size();
        BeanPropertyWriter[] beanPropertyWriterArr = new BeanPropertyWriter[size];
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            BeanPropertyWriter beanPropertyWriter = (BeanPropertyWriter) list.get(i);
            Class[] clsArr = beanPropertyWriter.p;
            if (clsArr == null) {
                if (a) {
                    beanPropertyWriterArr[i] = beanPropertyWriter;
                    i3 = i2;
                }
                i3 = i2;
            } else {
                i2++;
                beanPropertyWriterArr[i] = FilteredBeanPropertyWriter.a(beanPropertyWriter, clsArr);
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        if (!a || i2 != 0) {
            beanSerializerBuilder.d = beanPropertyWriterArr;
        }
    }

    private static void m7548a(SerializationConfig serializationConfig, List<BeanPropertyDefinition> list) {
        AnnotationIntrospector a = serializationConfig.mo1061a();
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AnnotatedMember m = ((BeanPropertyDefinition) it.next()).m();
            if (m == null) {
                it.remove();
            } else {
                Class d = m.mo940d();
                Boolean bool = (Boolean) hashMap.get(d);
                if (bool == null) {
                    bool = a.mo986c(serializationConfig.m7260c(d).mo949c());
                    if (bool == null) {
                        bool = Boolean.FALSE;
                    }
                    hashMap.put(d, bool);
                }
                if (bool.booleanValue()) {
                    it.remove();
                }
            }
        }
    }

    private static void m7549a(List<BeanPropertyDefinition> list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            BeanPropertyDefinition beanPropertyDefinition = (BeanPropertyDefinition) it.next();
            if (!(beanPropertyDefinition.d() || beanPropertyDefinition.c())) {
                it.remove();
            }
        }
    }

    private BeanPropertyWriter m7540a(SerializerProvider serializerProvider, BeanPropertyDefinition beanPropertyDefinition, TypeBindings typeBindings, PropertyBuilder propertyBuilder, boolean z, AnnotatedMember annotatedMember) {
        String a = beanPropertyDefinition.a();
        if (serializerProvider.m7337b()) {
            annotatedMember.k();
        }
        JavaType a2 = annotatedMember.m6796a(typeBindings);
        Std std = new Std(a, a2, beanPropertyDefinition.b(), propertyBuilder.a(), annotatedMember, beanPropertyDefinition.s());
        JsonSerializer a3 = m7578a(serializerProvider, (Annotated) annotatedMember);
        if (a3 instanceof ResolvableSerializer) {
            ((ResolvableSerializer) a3).a(serializerProvider);
        }
        if (a3 instanceof ContextualSerializer) {
            a3 = ((ContextualSerializer) a3).mo1105a(serializerProvider, std);
        }
        TypeSerializer typeSerializer = null;
        if (ClassUtil.e(a2._class)) {
            typeSerializer = m7552b(a2, serializerProvider.m7321d(), annotatedMember);
        }
        return propertyBuilder.a(beanPropertyDefinition, a2, a3, m7539a(a2, serializerProvider.m7321d(), annotatedMember), typeSerializer, annotatedMember, z);
    }
}
