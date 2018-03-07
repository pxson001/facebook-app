package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.annotation.JsonInclude$Include;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.NoClass;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.util.Annotations;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.Converter.None;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: story_location */
public class BasicBeanDescription extends BeanDescription {
    protected final MapperConfig<?> f4030b;
    protected final AnnotationIntrospector f4031c;
    protected final AnnotatedClass f4032d;
    protected TypeBindings f4033e;
    protected final List<BeanPropertyDefinition> f4034f;
    protected ObjectIdInfo f4035g;
    protected AnnotatedMethod f4036h;
    protected Map<Object, AnnotatedMember> f4037i;
    protected Set<String> f4038j;
    protected AnnotatedMethod f4039k;
    protected AnnotatedMember f4040l;

    private BasicBeanDescription(MapperConfig<?> mapperConfig, JavaType javaType, AnnotatedClass annotatedClass, List<BeanPropertyDefinition> list) {
        super(javaType);
        this.f4030b = mapperConfig;
        this.f4031c = mapperConfig == null ? null : mapperConfig.mo1061a();
        this.f4032d = annotatedClass;
        this.f4034f = list;
    }

    public static BasicBeanDescription m6811a(POJOPropertiesCollector pOJOPropertiesCollector) {
        BasicBeanDescription basicBeanDescription = new BasicBeanDescription(pOJOPropertiesCollector);
        basicBeanDescription.f4036h = pOJOPropertiesCollector.h();
        basicBeanDescription.f4038j = pOJOPropertiesCollector.m;
        basicBeanDescription.f4037i = pOJOPropertiesCollector.n;
        basicBeanDescription.f4039k = pOJOPropertiesCollector.f();
        return basicBeanDescription;
    }

    private BasicBeanDescription(POJOPropertiesCollector pOJOPropertiesCollector) {
        this(pOJOPropertiesCollector.a, pOJOPropertiesCollector.c, pOJOPropertiesCollector.d, pOJOPropertiesCollector.d());
        this.f4035g = pOJOPropertiesCollector.j();
    }

    public static BasicBeanDescription m6814b(POJOPropertiesCollector pOJOPropertiesCollector) {
        BasicBeanDescription basicBeanDescription = new BasicBeanDescription(pOJOPropertiesCollector);
        basicBeanDescription.f4039k = pOJOPropertiesCollector.f();
        basicBeanDescription.f4040l = pOJOPropertiesCollector.g();
        return basicBeanDescription;
    }

    public static BasicBeanDescription m6810a(MapperConfig<?> mapperConfig, JavaType javaType, AnnotatedClass annotatedClass) {
        return new BasicBeanDescription(mapperConfig, javaType, annotatedClass, Collections.emptyList());
    }

    public final boolean m6821a(String str) {
        Iterator it = this.f4034f.iterator();
        while (it.hasNext()) {
            if (((BeanPropertyDefinition) it.next()).a().equals(str)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public final AnnotatedClass mo949c() {
        return this.f4032d;
    }

    public final ObjectIdInfo mo950d() {
        return this.f4035g;
    }

    public final List<BeanPropertyDefinition> mo954h() {
        return this.f4034f;
    }

    public final AnnotatedMethod mo962p() {
        return this.f4039k;
    }

    public final Set<String> mo956j() {
        if (this.f4038j == null) {
            return Collections.emptySet();
        }
        return this.f4038j;
    }

    public final boolean mo951e() {
        return this.f4032d.m6790h();
    }

    public final Annotations mo953g() {
        return this.f4032d.m6789g();
    }

    public final TypeBindings mo952f() {
        if (this.f4033e == null) {
            this.f4033e = new TypeBindings(this.f4030b.m7269n(), this.f4041a);
        }
        return this.f4033e;
    }

    public final JavaType mo944a(Type type) {
        if (type == null) {
            return null;
        }
        return mo952f().a(type);
    }

    public final AnnotatedConstructor mo959m() {
        return this.f4032d.m6791i();
    }

    public final AnnotatedMethod mo961o() {
        if (this.f4036h != null) {
            Class a = this.f4036h.a(0);
            if (!(a == String.class || a == Object.class)) {
                throw new IllegalArgumentException("Invalid 'any-setter' annotation on method " + this.f4036h.mo938b() + "(): first argument not of type String or Object, but " + a.getName());
            }
        }
        return this.f4036h;
    }

    public final Map<Object, AnnotatedMember> mo965s() {
        return this.f4037i;
    }

    public final List<AnnotatedConstructor> mo957k() {
        return this.f4032d.m6792j();
    }

    public final Object mo946a(boolean z) {
        AnnotatedConstructor i = this.f4032d.m6791i();
        if (i == null) {
            return null;
        }
        if (z) {
            i.k();
        }
        try {
            return i.f().newInstance(new Object[0]);
        } catch (Exception e) {
            Throwable e2 = e;
            while (e2.getCause() != null) {
                e2 = e2.getCause();
            }
            if (e2 instanceof Error) {
                throw ((Error) e2);
            } else if (e2 instanceof RuntimeException) {
                throw ((RuntimeException) e2);
            } else {
                throw new IllegalArgumentException("Failed to instantiate bean of type " + this.f4032d.m6788f().getName() + ": (" + e2.getClass().getName() + ") " + e2.getMessage(), e2);
            }
        }
    }

    public final AnnotatedMethod mo945a(String str, Class<?>[] clsArr) {
        return this.f4032d.m6781a(str, (Class[]) clsArr);
    }

    public final Value mo942a(Value value) {
        if (this.f4031c == null) {
            return value;
        }
        Value e = this.f4031c.mo994e(this.f4032d);
        if (e != null) {
            return e;
        }
        return value;
    }

    public final Converter<Object, Object> mo963q() {
        if (this.f4031c == null) {
            return null;
        }
        return m6812a(this.f4031c.mo1015m(this.f4032d));
    }

    public final JsonInclude$Include mo943a(JsonInclude$Include jsonInclude$Include) {
        return this.f4031c == null ? jsonInclude$Include : this.f4031c.mo968a(this.f4032d, jsonInclude$Include);
    }

    public final AnnotatedMember mo960n() {
        if (this.f4040l != null) {
            if (!Map.class.isAssignableFrom(this.f4040l.mo940d())) {
                throw new IllegalArgumentException("Invalid 'any-getter' annotation on method " + this.f4040l.mo938b() + "(): return type is not instance of java.util.Map");
            }
        }
        return this.f4040l;
    }

    public final Map<String, AnnotatedMember> mo955i() {
        Map<String, AnnotatedMember> map = null;
        for (BeanPropertyDefinition n : this.f4034f) {
            AnnotatedMember n2 = n.n();
            if (n2 != null) {
                ReferenceProperty a = this.f4031c.mo969a(n2);
                if (a != null && a.c()) {
                    HashMap hashMap;
                    if (map == null) {
                        hashMap = new HashMap();
                    } else {
                        Map map2 = map;
                    }
                    String str = a.b;
                    if (hashMap.put(str, n2) != null) {
                        throw new IllegalArgumentException("Multiple back-reference properties with name '" + str + "'");
                    }
                    map = hashMap;
                }
            }
        }
        return map;
    }

    public final List<AnnotatedMethod> mo958l() {
        List<AnnotatedMethod> k = this.f4032d.m6793k();
        if (k.isEmpty()) {
            return k;
        }
        ArrayList arrayList = new ArrayList();
        for (AnnotatedMethod annotatedMethod : k) {
            if (m6813a(annotatedMethod)) {
                arrayList.add(annotatedMethod);
            }
        }
        return arrayList;
    }

    public final Constructor<?> mo947a(Class<?>... clsArr) {
        for (AnnotatedConstructor annotatedConstructor : this.f4032d.m6792j()) {
            if (annotatedConstructor.g() == 1) {
                Class<?> a = annotatedConstructor.a(0);
                for (Class<?> cls : clsArr) {
                    if (cls == a) {
                        return annotatedConstructor._constructor;
                    }
                }
                continue;
            }
        }
        return null;
    }

    public final Method mo948b(Class<?>... clsArr) {
        for (AnnotatedMethod annotatedMethod : this.f4032d.m6793k()) {
            if (m6813a(annotatedMethod)) {
                Class a = annotatedMethod.a(0);
                for (Class isAssignableFrom : clsArr) {
                    if (a.isAssignableFrom(isAssignableFrom)) {
                        return annotatedMethod.a;
                    }
                }
                continue;
            }
        }
        return null;
    }

    private boolean m6813a(AnnotatedMethod annotatedMethod) {
        if (!m6849b().isAssignableFrom(annotatedMethod.o())) {
            return false;
        }
        if (this.f4031c.mo1025w(annotatedMethod)) {
            return true;
        }
        if ("valueOf".equals(annotatedMethod.mo938b())) {
            return true;
        }
        return false;
    }

    public final Class<?> mo966t() {
        if (this.f4031c == null) {
            return null;
        }
        return this.f4031c.mo1011j(this.f4032d);
    }

    public final JsonPOJOBuilder.Value mo967u() {
        if (this.f4031c == null) {
            return null;
        }
        return this.f4031c.mo1012k(this.f4032d);
    }

    public final Converter<Object, Object> mo964r() {
        if (this.f4031c == null) {
            return null;
        }
        return m6812a(this.f4031c.mo1023u(this.f4032d));
    }

    private Converter<Object, Object> m6812a(Object obj) {
        Converter converter = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Converter) {
            return (Converter) obj;
        }
        if (obj instanceof Class) {
            Class cls = (Class) obj;
            if (cls == None.class || cls == NoClass.class) {
                return null;
            }
            if (Converter.class.isAssignableFrom(cls)) {
                if (this.f4030b.m7267l() != null) {
                    converter = null;
                }
                if (converter == null) {
                    converter = (Converter) ClassUtil.b(cls, this.f4030b.m7263h());
                }
                return converter;
            }
            throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<Converter>");
        }
        throw new IllegalStateException("AnnotationIntrospector returned Converter definition of type " + obj.getClass().getName() + "; expected type Converter or Class<Converter> instead");
    }
}
