package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty.Std;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder.Value;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.deser.impl.FieldProperty;
import com.fasterxml.jackson.databind.deser.impl.MethodProperty;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.deser.impl.SetterlessProperty;
import com.fasterxml.jackson.databind.deser.std.JdkDeserializers.AtomicReferenceDeserializer;
import com.fasterxml.jackson.databind.deser.std.ThrowableDeserializer;
import com.fasterxml.jackson.databind.ext.OptionalHandlerFactory;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.SimpleBeanPropertyDefinition;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: static.0.facebook.com */
public class BeanDeserializerFactory extends BasicDeserializerFactory implements Serializable {
    public static final BeanDeserializerFactory f4146c = new BeanDeserializerFactory(new DeserializerFactoryConfig());
    private static final Class<?>[] f4147e = new Class[]{Throwable.class};
    private static final Class<?>[] f4148f = new Class[0];
    private static final long serialVersionUID = 1;

    private BeanDeserializerFactory(DeserializerFactoryConfig deserializerFactoryConfig) {
        super(deserializerFactoryConfig);
    }

    public final DeserializerFactory mo1081a(DeserializerFactoryConfig deserializerFactoryConfig) {
        if (this._factoryConfig == deserializerFactoryConfig) {
            return this;
        }
        if (getClass() != BeanDeserializerFactory.class) {
            throw new IllegalStateException("Subtype of BeanDeserializerFactory (" + getClass().getName() + ") has not properly overridden method 'withAdditionalDeserializers': can not instantiate subtype with additional deserializer definitions");
        }
        this(deserializerFactoryConfig);
        return this;
    }

    private JsonDeserializer<Object> m7415a(JavaType javaType, DeserializationConfig deserializationConfig, BeanDescription beanDescription) {
        for (Deserializers a : this._factoryConfig.m7500e()) {
            JsonDeserializer<Object> a2 = a.mo1144a(javaType, deserializationConfig, beanDescription);
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    public final JsonDeserializer<Object> mo1080a(DeserializationContext deserializationContext, JavaType javaType, Class<?> cls) {
        return m7432g(deserializationContext, javaType, deserializationContext._config.m7288d(deserializationContext.m7379a((Class) cls)));
    }

    public final JsonDeserializer<Object> mo1082c(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) {
        DeserializationConfig deserializationConfig = deserializationContext._config;
        JsonDeserializer<Object> a = m7415a(javaType, deserializationConfig, beanDescription);
        if (a != null) {
            return a;
        }
        if (javaType.m6715f()) {
            return m7425c(deserializationContext, beanDescription);
        }
        if (javaType.m6711d()) {
            JavaType b = m7423b(deserializationContext, beanDescription);
            if (b != null) {
                return m7431f(deserializationContext, b, deserializationConfig.m7281b(b));
            }
        }
        a = m7427d(deserializationContext, javaType, beanDescription);
        if (a != null) {
            return a;
        }
        if (m7422a(javaType._class)) {
            return m7431f(deserializationContext, javaType, beanDescription);
        }
        return null;
    }

    private JsonDeserializer<?> m7427d(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) {
        JsonDeserializer<?> b = m7472b(deserializationContext, javaType, beanDescription);
        if (b != null) {
            return b;
        }
        if (!AtomicReference.class.isAssignableFrom(javaType._class)) {
            return m7430e(deserializationContext, javaType, beanDescription);
        }
        JavaType c;
        JavaType[] b2 = deserializationContext.mo1071c().m7116b(javaType, AtomicReference.class);
        if (b2 == null || b2.length <= 0) {
            c = TypeFactory.m7101c();
        } else {
            c = b2[0];
        }
        return new AtomicReferenceDeserializer(c);
    }

    private static JsonDeserializer<?> m7430e(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) {
        return OptionalHandlerFactory.a.a(javaType, deserializationContext._config, beanDescription);
    }

    private JavaType m7423b(DeserializationContext deserializationContext, BeanDescription beanDescription) {
        Iterator it = this._factoryConfig.m7503h().iterator();
        while (it.hasNext()) {
            it.next();
            JavaType javaType = null;
            if (javaType != null) {
                return javaType;
            }
        }
        return null;
    }

    private JsonDeserializer<Object> m7431f(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) {
        JsonDeserializer<Object> f;
        ValueInstantiator a = m7471a(deserializationContext, beanDescription);
        BeanDeserializerBuilder d = m7428d(deserializationContext, beanDescription);
        d.g = a;
        m7424b(deserializationContext, beanDescription, d);
        m7420a(deserializationContext, beanDescription, d);
        m7426c(deserializationContext, beanDescription, d);
        m7429d(deserializationContext, beanDescription, d);
        if (this._factoryConfig.m7497b()) {
            Iterator it = this._factoryConfig.m7502g().iterator();
            while (it.hasNext()) {
                it.next();
                d = d;
            }
        }
        if (!javaType.m6711d() || a.b()) {
            f = d.f();
        } else {
            f = d.g();
        }
        if (this._factoryConfig.m7497b()) {
            Iterator it2 = this._factoryConfig.m7502g().iterator();
            while (it2.hasNext()) {
                it2.next();
                f = f;
            }
        }
        return f;
    }

    private JsonDeserializer<Object> m7432g(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) {
        ValueInstantiator a = m7471a(deserializationContext, beanDescription);
        MapperConfig mapperConfig = deserializationContext._config;
        BeanDeserializerBuilder d = m7428d(deserializationContext, beanDescription);
        d.g = a;
        m7424b(deserializationContext, beanDescription, d);
        m7420a(deserializationContext, beanDescription, d);
        m7426c(deserializationContext, beanDescription, d);
        m7429d(deserializationContext, beanDescription, d);
        Value u = beanDescription.mo967u();
        String str = u == null ? "build" : u.a;
        AnnotatedMethod a2 = beanDescription.mo945a(str, null);
        if (a2 != null && mapperConfig.m7263h()) {
            ClassUtil.a(a2.a);
        }
        d.a(a2, u);
        if (this._factoryConfig.m7497b()) {
            Iterator it = this._factoryConfig.m7502g().iterator();
            while (it.hasNext()) {
                it.next();
                d = d;
            }
        }
        JsonDeserializer<Object> a3 = d.a(javaType, str);
        if (this._factoryConfig.m7497b()) {
            Iterator it2 = this._factoryConfig.m7502g().iterator();
            while (it2.hasNext()) {
                it2.next();
                a3 = a3;
            }
        }
        return a3;
    }

    private static void m7420a(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanDeserializerBuilder beanDeserializerBuilder) {
        ObjectIdInfo d = beanDescription.mo950d();
        if (d != null) {
            SettableBeanProperty b;
            JavaType a;
            ObjectIdGenerator propertyBasedObjectIdGenerator;
            Class cls = d.b;
            if (cls == PropertyGenerator.class) {
                String str = d.a;
                b = beanDeserializerBuilder.b(str);
                if (b == null) {
                    throw new IllegalArgumentException("Invalid Object Id definition for " + beanDescription.m6849b().getName() + ": can not find property with name '" + str + "'");
                }
                a = b.a();
                propertyBasedObjectIdGenerator = new PropertyBasedObjectIdGenerator(d.c);
            } else {
                a = deserializationContext.mo1071c().m7116b(deserializationContext.m7379a(cls), ObjectIdGenerator.class)[0];
                b = null;
                propertyBasedObjectIdGenerator = deserializationContext.m7331a(beanDescription.mo949c(), d);
            }
            beanDeserializerBuilder.h = ObjectIdReader.a(a, d.a, propertyBasedObjectIdGenerator, deserializationContext.m7380a(a), b);
        }
    }

    private JsonDeserializer<Object> m7425c(DeserializationContext deserializationContext, BeanDescription beanDescription) {
        Iterator it;
        BeanDeserializerBuilder d = m7428d(deserializationContext, beanDescription);
        d.g = m7471a(deserializationContext, beanDescription);
        m7424b(deserializationContext, beanDescription, d);
        AnnotatedMethod a = beanDescription.mo945a("initCause", f4147e);
        if (a != null) {
            SettableBeanProperty a2 = m7418a(deserializationContext, beanDescription, SimpleBeanPropertyDefinition.a(deserializationContext._config, a, "cause"), a.b(0));
            if (a2 != null) {
                d.a(a2);
            }
        }
        d.a("localizedMessage");
        d.a("suppressed");
        d.a("message");
        if (this._factoryConfig.m7497b()) {
            it = this._factoryConfig.m7502g().iterator();
            while (it.hasNext()) {
                it.next();
                d = d;
            }
        }
        JsonDeserializer<Object> f = d.f();
        if (f instanceof BeanDeserializer) {
            f = new ThrowableDeserializer((BeanDeserializer) f);
        }
        if (this._factoryConfig.m7497b()) {
            it = this._factoryConfig.m7502g().iterator();
            while (it.hasNext()) {
                it.next();
                f = f;
            }
        }
        return f;
    }

    private static BeanDeserializerBuilder m7428d(DeserializationContext deserializationContext, BeanDescription beanDescription) {
        return new BeanDeserializerBuilder(beanDescription, deserializationContext._config);
    }

    private void m7424b(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanDeserializerBuilder beanDeserializerBuilder) {
        Iterator it;
        SettableBeanProperty[] a = beanDeserializerBuilder.g.a(deserializationContext._config);
        AnnotationIntrospector f = deserializationContext.m7407f();
        Boolean b = f.mo982b(beanDescription.mo949c());
        if (b != null) {
            beanDeserializerBuilder.j = b.booleanValue();
        }
        Set<String> a2 = ArrayBuilders.m7771a(f.mo985b(beanDescription.mo949c()));
        for (String a3 : a2) {
            beanDeserializerBuilder.a(a3);
        }
        AnnotatedMethod o = beanDescription.mo961o();
        if (o != null) {
            beanDeserializerBuilder.a(m7416a(deserializationContext, beanDescription, o));
        }
        if (o == null) {
            Collection<String> j = beanDescription.mo956j();
            if (j != null) {
                for (String a32 : j) {
                    beanDeserializerBuilder.a(a32);
                }
            }
        }
        int i = (deserializationContext.m7336a(MapperFeature.USE_GETTERS_AS_SETTERS) && deserializationContext.m7336a(MapperFeature.AUTO_DETECT_GETTERS)) ? 1 : 0;
        List a4 = m7419a(deserializationContext, beanDescription, beanDeserializerBuilder, beanDescription.mo954h(), a2);
        if (this._factoryConfig.m7497b()) {
            it = this._factoryConfig.m7502g().iterator();
            while (it.hasNext()) {
                it.next();
                a4 = a4;
            }
        }
        for (BeanPropertyDefinition beanPropertyDefinition : r0) {
            SettableBeanProperty settableBeanProperty = null;
            if (beanPropertyDefinition.h()) {
                String a5 = beanPropertyDefinition.a();
                if (a != null) {
                    for (SettableBeanProperty settableBeanProperty2 : a) {
                        if (a5.equals(settableBeanProperty2._propName)) {
                            settableBeanProperty = settableBeanProperty2;
                            break;
                        }
                    }
                }
                if (settableBeanProperty == null) {
                    throw deserializationContext.m7402c("Could not find creator property with name '" + a5 + "' (in class " + beanDescription.m6849b().getName() + ")");
                }
                beanDeserializerBuilder.b(settableBeanProperty);
            } else {
                if (beanPropertyDefinition.f()) {
                    settableBeanProperty = m7418a(deserializationContext, beanDescription, beanPropertyDefinition, beanPropertyDefinition.j().b(0));
                } else if (beanPropertyDefinition.g()) {
                    settableBeanProperty = m7418a(deserializationContext, beanDescription, beanPropertyDefinition, beanPropertyDefinition.k().mo939c());
                } else if (i != 0 && beanPropertyDefinition.e()) {
                    Class d = beanPropertyDefinition.i().mo940d();
                    if (Collection.class.isAssignableFrom(d) || Map.class.isAssignableFrom(d)) {
                        settableBeanProperty = m7417a(deserializationContext, beanDescription, beanPropertyDefinition);
                    }
                }
                if (settableBeanProperty != null) {
                    Class[] p = beanPropertyDefinition.p();
                    if (p == null && !deserializationContext.m7336a(MapperFeature.DEFAULT_VIEW_INCLUSION)) {
                        p = f4148f;
                    }
                    settableBeanProperty.a(p);
                    beanDeserializerBuilder.b(settableBeanProperty);
                }
            }
        }
    }

    private List<BeanPropertyDefinition> m7419a(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanDeserializerBuilder beanDeserializerBuilder, List<BeanPropertyDefinition> list, Set<String> set) {
        List arrayList = new ArrayList(Math.max(4, list.size()));
        Map hashMap = new HashMap();
        for (BeanPropertyDefinition beanPropertyDefinition : list) {
            String a = beanPropertyDefinition.a();
            if (!set.contains(a)) {
                if (!beanPropertyDefinition.h()) {
                    Class cls = null;
                    if (beanPropertyDefinition.f()) {
                        cls = beanPropertyDefinition.j().a(0);
                    } else if (beanPropertyDefinition.g()) {
                        cls = beanPropertyDefinition.k().mo940d();
                    }
                    if (cls != null && m7421a(deserializationContext._config, cls, hashMap)) {
                        beanDeserializerBuilder.a(a);
                    }
                }
                arrayList.add(beanPropertyDefinition);
            }
        }
        return arrayList;
    }

    private void m7426c(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanDeserializerBuilder beanDeserializerBuilder) {
        Map i = beanDescription.mo955i();
        if (i != null) {
            for (Entry entry : i.entrySet()) {
                Type b;
                String str = (String) entry.getKey();
                AnnotatedMember annotatedMember = (AnnotatedMember) entry.getValue();
                if (annotatedMember instanceof AnnotatedMethod) {
                    b = ((AnnotatedMethod) annotatedMember).b(0);
                } else {
                    b = annotatedMember.mo940d();
                }
                beanDeserializerBuilder.a(str, m7418a(deserializationContext, beanDescription, SimpleBeanPropertyDefinition.a(deserializationContext._config, annotatedMember), b));
            }
        }
    }

    private static void m7429d(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanDeserializerBuilder beanDeserializerBuilder) {
        Map s = beanDescription.mo965s();
        if (s != null) {
            boolean b = deserializationContext.m7337b();
            for (Entry entry : s.entrySet()) {
                AnnotatedMember annotatedMember = (AnnotatedMember) entry.getValue();
                if (b) {
                    annotatedMember.k();
                }
                beanDeserializerBuilder.a(annotatedMember.mo938b(), beanDescription.mo944a(annotatedMember.mo939c()), beanDescription.mo953g(), annotatedMember, entry.getKey());
            }
        }
    }

    private SettableAnyProperty m7416a(DeserializationContext deserializationContext, BeanDescription beanDescription, AnnotatedMethod annotatedMethod) {
        if (deserializationContext.m7337b()) {
            annotatedMethod.k();
        }
        JavaType a = beanDescription.mo952f().a(annotatedMethod.b(1));
        Std std = new Std(annotatedMethod.mo938b(), a, null, beanDescription.mo953g(), annotatedMethod, false);
        a = m7460a(deserializationContext, a, (AnnotatedMember) annotatedMethod);
        JsonDeserializer a2 = BasicDeserializerFactory.m7437a(deserializationContext, (Annotated) annotatedMethod);
        if (a2 != null) {
            return new SettableAnyProperty(std, annotatedMethod, a, a2);
        }
        return new SettableAnyProperty(std, annotatedMethod, BasicDeserializerFactory.m7436a(deserializationContext, (Annotated) annotatedMethod, a), null);
    }

    private SettableBeanProperty m7418a(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanPropertyDefinition beanPropertyDefinition, Type type) {
        SettableBeanProperty methodProperty;
        Annotated n = beanPropertyDefinition.n();
        if (deserializationContext.m7337b()) {
            n.k();
        }
        JavaType a = beanDescription.mo944a(type);
        Std std = new Std(beanPropertyDefinition.a(), a, beanPropertyDefinition.b(), beanDescription.mo953g(), n, beanPropertyDefinition.s());
        JavaType a2 = m7460a(deserializationContext, a, (AnnotatedMember) n);
        if (a2 != a) {
            std.a(a2);
        }
        JsonDeserializer a3 = BasicDeserializerFactory.m7437a(deserializationContext, n);
        a = BasicDeserializerFactory.m7436a(deserializationContext, n, a2);
        TypeDeserializer typeDeserializer = (TypeDeserializer) a.mo930u();
        if (n instanceof AnnotatedMethod) {
            methodProperty = new MethodProperty(beanPropertyDefinition, a, typeDeserializer, beanDescription.mo953g(), (AnnotatedMethod) n);
        } else {
            methodProperty = new FieldProperty(beanPropertyDefinition, a, typeDeserializer, beanDescription.mo953g(), (AnnotatedField) n);
        }
        if (a3 != null) {
            methodProperty = methodProperty.b(a3);
        }
        ReferenceProperty q = beanPropertyDefinition.q();
        if (q != null && q.b()) {
            methodProperty._managedReferenceName = q.b;
        }
        return methodProperty;
    }

    private SettableBeanProperty m7417a(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanPropertyDefinition beanPropertyDefinition) {
        Annotated i = beanPropertyDefinition.i();
        if (deserializationContext.m7337b()) {
            i.k();
        }
        JavaType a = i.m6796a(beanDescription.mo952f());
        JsonDeserializer a2 = BasicDeserializerFactory.m7437a(deserializationContext, i);
        JavaType a3 = BasicDeserializerFactory.m7436a(deserializationContext, i, a);
        SettableBeanProperty setterlessProperty = new SetterlessProperty(beanPropertyDefinition, a3, (TypeDeserializer) a3.mo930u(), beanDescription.mo953g(), i);
        if (a2 != null) {
            return setterlessProperty.b(a2);
        }
        return setterlessProperty;
    }

    private static boolean m7422a(Class<?> cls) {
        String a = ClassUtil.a(cls);
        if (a != null) {
            throw new IllegalArgumentException("Can not deserialize Class " + cls.getName() + " (of type " + a + ") as a Bean");
        } else if (ClassUtil.c(cls)) {
            throw new IllegalArgumentException("Can not deserialize Proxy class " + cls.getName() + " as a Bean");
        } else {
            a = ClassUtil.a(cls, true);
            if (a == null) {
                return true;
            }
            throw new IllegalArgumentException("Can not deserialize Class " + cls.getName() + " (of type " + a + ") as a Bean");
        }
    }

    private static boolean m7421a(DeserializationConfig deserializationConfig, Class<?> cls, Map<Class<?>, Boolean> map) {
        Boolean bool = (Boolean) map.get(cls);
        if (bool == null) {
            bool = deserializationConfig.mo1061a().mo986c(deserializationConfig.m7260c(cls).mo949c());
            if (bool == null) {
                bool = Boolean.FALSE;
            }
        }
        return bool.booleanValue();
    }
}
