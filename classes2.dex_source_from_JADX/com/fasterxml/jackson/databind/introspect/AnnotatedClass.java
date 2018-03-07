package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector.MixInResolver;
import com.fasterxml.jackson.databind.util.Annotations;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: story_type */
public final class AnnotatedClass extends Annotated {
    private static final AnnotationMap[] f4016m = new AnnotationMap[0];
    public final Class<?> f4017a;
    protected final List<Class<?>> f4018b;
    protected final AnnotationIntrospector f4019c;
    protected final MixInResolver f4020d;
    protected final Class<?> f4021e;
    protected AnnotationMap f4022f;
    protected boolean f4023g = false;
    protected AnnotatedConstructor f4024h;
    protected List<AnnotatedConstructor> f4025i;
    protected List<AnnotatedMethod> f4026j;
    protected AnnotatedMethodMap f4027k;
    protected List<AnnotatedField> f4028l;

    private AnnotatedClass(Class<?> cls, List<Class<?>> list, AnnotationIntrospector annotationIntrospector, MixInResolver mixInResolver, AnnotationMap annotationMap) {
        Class cls2;
        this.f4017a = cls;
        this.f4018b = list;
        this.f4019c = annotationIntrospector;
        this.f4020d = mixInResolver;
        if (this.f4020d == null) {
            cls2 = null;
        } else {
            cls2 = this.f4020d.mo1064d(this.f4017a);
        }
        this.f4021e = cls2;
        this.f4022f = annotationMap;
    }

    public static AnnotatedClass m6750a(Class<?> cls, AnnotationIntrospector annotationIntrospector, MixInResolver mixInResolver) {
        return new AnnotatedClass(cls, ClassUtil.a(cls, null), annotationIntrospector, mixInResolver, null);
    }

    public static AnnotatedClass m6768b(Class<?> cls, AnnotationIntrospector annotationIntrospector, MixInResolver mixInResolver) {
        return new AnnotatedClass(cls, Collections.emptyList(), annotationIntrospector, mixInResolver, null);
    }

    public final /* synthetic */ AnnotatedElement mo937a() {
        return this.f4017a;
    }

    public final Class<?> m6788f() {
        return this.f4017a;
    }

    public final String mo938b() {
        return this.f4017a.getName();
    }

    public final <A extends Annotation> A mo936a(Class<A> cls) {
        if (this.f4022f == null) {
            m6776n();
        }
        return this.f4022f.m6807a((Class) cls);
    }

    public final Type mo939c() {
        return this.f4017a;
    }

    public final Class<?> mo940d() {
        return this.f4017a;
    }

    protected final AnnotationMap mo941e() {
        if (this.f4022f == null) {
            m6776n();
        }
        return this.f4022f;
    }

    public final Annotations m6789g() {
        if (this.f4022f == null) {
            m6776n();
        }
        return this.f4022f;
    }

    public final boolean m6790h() {
        if (this.f4022f == null) {
            m6776n();
        }
        return this.f4022f.m6806a() > 0;
    }

    public final AnnotatedConstructor m6791i() {
        if (!this.f4023g) {
            m6777o();
        }
        return this.f4024h;
    }

    public final List<AnnotatedConstructor> m6792j() {
        if (!this.f4023g) {
            m6777o();
        }
        return this.f4025i;
    }

    public final List<AnnotatedMethod> m6793k() {
        if (!this.f4023g) {
            m6777o();
        }
        return this.f4026j;
    }

    public final Iterable<AnnotatedMethod> m6794l() {
        if (this.f4027k == null) {
            m6778p();
        }
        return this.f4027k;
    }

    public final AnnotatedMethod m6781a(String str, Class<?>[] clsArr) {
        if (this.f4027k == null) {
            m6778p();
        }
        return this.f4027k.a(str, clsArr);
    }

    public final Iterable<AnnotatedField> m6795m() {
        if (this.f4028l == null) {
            m6779q();
        }
        return this.f4028l;
    }

    private void m6776n() {
        this.f4022f = new AnnotationMap();
        if (this.f4019c != null) {
            if (this.f4021e != null) {
                m6758a(this.f4022f, this.f4017a, this.f4021e);
            }
            m6759a(this.f4022f, this.f4017a.getDeclaredAnnotations());
            for (Class cls : this.f4018b) {
                m6757a(this.f4022f, cls);
                m6759a(this.f4022f, cls.getDeclaredAnnotations());
            }
            m6757a(this.f4022f, Object.class);
        }
    }

    private void m6777o() {
        int i;
        int size;
        int i2 = 0;
        Constructor[] declaredConstructors = this.f4017a.getDeclaredConstructors();
        List list = null;
        for (Constructor constructor : declaredConstructors) {
            if (constructor.getParameterTypes().length == 0) {
                this.f4024h = m6751a(constructor, true);
            } else {
                if (list == null) {
                    list = new ArrayList(Math.max(10, declaredConstructors.length));
                }
                list.add(m6751a(constructor, false));
            }
        }
        if (list == null) {
            this.f4025i = Collections.emptyList();
        } else {
            this.f4025i = list;
        }
        if (!(this.f4021e == null || (this.f4024h == null && this.f4025i.isEmpty()))) {
            m6773c(this.f4021e);
        }
        if (this.f4019c != null) {
            if (this.f4024h != null && this.f4019c.mo989c(this.f4024h)) {
                this.f4024h = null;
            }
            if (this.f4025i != null) {
                size = this.f4025i.size();
                while (true) {
                    i = size - 1;
                    if (i < 0) {
                        break;
                    } else if (this.f4019c.mo989c((AnnotatedMember) this.f4025i.get(i))) {
                        this.f4025i.remove(i);
                        size = i;
                    } else {
                        size = i;
                    }
                }
            }
        }
        Method[] declaredMethods = this.f4017a.getDeclaredMethods();
        int length = declaredMethods.length;
        list = null;
        while (i2 < length) {
            Method method = declaredMethods[i2];
            if (Modifier.isStatic(method.getModifiers())) {
                if (list == null) {
                    list = new ArrayList(8);
                }
                list.add(m6769b(method));
            }
            i2++;
        }
        if (list == null) {
            this.f4026j = Collections.emptyList();
        } else {
            this.f4026j = list;
            if (this.f4021e != null) {
                m6775d(this.f4021e);
            }
            if (this.f4019c != null) {
                size = this.f4026j.size();
                while (true) {
                    i2 = size - 1;
                    if (i2 < 0) {
                        break;
                    } else if (this.f4019c.mo989c((AnnotatedMember) this.f4026j.get(i2))) {
                        this.f4026j.remove(i2);
                        size = i2;
                    } else {
                        size = i2;
                    }
                }
            }
        }
        this.f4023g = true;
    }

    private void m6778p() {
        this.f4027k = new AnnotatedMethodMap();
        AnnotatedMethodMap annotatedMethodMap = new AnnotatedMethodMap();
        m6760a(this.f4017a, this.f4027k, this.f4021e, annotatedMethodMap);
        for (Class cls : this.f4018b) {
            Class cls2;
            m6760a(cls2, this.f4027k, this.f4020d == null ? null : this.f4020d.mo1064d(cls2), annotatedMethodMap);
        }
        if (this.f4020d != null) {
            cls2 = this.f4020d.mo1064d(Object.class);
            if (cls2 != null) {
                m6771b(this.f4017a, this.f4027k, cls2, annotatedMethodMap);
            }
        }
        if (this.f4019c != null && !annotatedMethodMap.a()) {
            Iterator it = annotatedMethodMap.iterator();
            while (it.hasNext()) {
                AnnotatedMethod annotatedMethod = (AnnotatedMethod) it.next();
                try {
                    Method declaredMethod = Object.class.getDeclaredMethod(annotatedMethod.mo938b(), annotatedMethod.n());
                    if (declaredMethod != null) {
                        AnnotatedMethod a = m6753a(declaredMethod);
                        m6764a(annotatedMethod.f(), a, false);
                        this.f4027k.a(a);
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    private void m6779q() {
        Map a = m6755a(this.f4017a, null);
        if (a == null || a.size() == 0) {
            this.f4028l = Collections.emptyList();
            return;
        }
        this.f4028l = new ArrayList(a.size());
        this.f4028l.addAll(a.values());
    }

    private void m6757a(AnnotationMap annotationMap, Class<?> cls) {
        if (this.f4020d != null) {
            m6758a(annotationMap, (Class) cls, this.f4020d.mo1064d(cls));
        }
    }

    private void m6758a(AnnotationMap annotationMap, Class<?> cls, Class<?> cls2) {
        if (cls2 != null) {
            m6759a(annotationMap, cls2.getDeclaredAnnotations());
            for (Class declaredAnnotations : ClassUtil.a(cls2, cls)) {
                m6759a(annotationMap, declaredAnnotations.getDeclaredAnnotations());
            }
        }
    }

    private void m6773c(Class<?> cls) {
        int size = this.f4025i == null ? 0 : this.f4025i.size();
        MemberKey[] memberKeyArr = null;
        for (Constructor constructor : cls.getDeclaredConstructors()) {
            if (constructor.getParameterTypes().length != 0) {
                MemberKey[] memberKeyArr2;
                if (memberKeyArr == null) {
                    memberKeyArr2 = new MemberKey[size];
                    for (int i = 0; i < size; i++) {
                        memberKeyArr2[i] = new MemberKey(((AnnotatedConstructor) this.f4025i.get(i))._constructor);
                    }
                } else {
                    memberKeyArr2 = memberKeyArr;
                }
                MemberKey memberKey = new MemberKey(constructor);
                for (int i2 = 0; i2 < size; i2++) {
                    if (memberKey.equals(memberKeyArr2[i2])) {
                        m6762a(constructor, (AnnotatedConstructor) this.f4025i.get(i2), true);
                        memberKeyArr = memberKeyArr2;
                        break;
                    }
                }
                memberKeyArr = memberKeyArr2;
            } else if (this.f4024h != null) {
                m6762a(constructor, this.f4024h, false);
            }
        }
    }

    private void m6775d(Class<?> cls) {
        MemberKey[] memberKeyArr = null;
        int size = this.f4026j.size();
        Method[] declaredMethods = cls.getDeclaredMethods();
        int length = declaredMethods.length;
        int i = 0;
        while (i < length) {
            MemberKey[] memberKeyArr2;
            Method method = declaredMethods[i];
            if (!Modifier.isStatic(method.getModifiers()) || method.getParameterTypes().length == 0) {
                memberKeyArr2 = memberKeyArr;
            } else {
                if (memberKeyArr == null) {
                    memberKeyArr2 = new MemberKey[size];
                    for (int i2 = 0; i2 < size; i2++) {
                        memberKeyArr2[i2] = new MemberKey(((AnnotatedMethod) this.f4026j.get(i2)).a);
                    }
                } else {
                    memberKeyArr2 = memberKeyArr;
                }
                MemberKey memberKey = new MemberKey(method);
                for (int i3 = 0; i3 < size; i3++) {
                    if (memberKey.equals(memberKeyArr2[i3])) {
                        m6764a(method, (AnnotatedMethod) this.f4026j.get(i3), true);
                        break;
                    }
                }
            }
            i++;
            memberKeyArr = memberKeyArr2;
        }
    }

    private void m6760a(Class<?> cls, AnnotatedMethodMap annotatedMethodMap, Class<?> cls2, AnnotatedMethodMap annotatedMethodMap2) {
        if (cls2 != null) {
            m6771b(cls, annotatedMethodMap, cls2, annotatedMethodMap2);
        }
        if (cls != null) {
            for (Method method : cls.getDeclaredMethods()) {
                if (m6774c(method)) {
                    AnnotatedMethod b = annotatedMethodMap.b(method);
                    if (b == null) {
                        b = m6753a(method);
                        annotatedMethodMap.a(b);
                        AnnotatedMethod a = annotatedMethodMap2.a(method);
                        if (a != null) {
                            m6764a(a.a, b, false);
                        }
                    } else {
                        m6763a(method, b);
                        if (b.i().isInterface() && !method.getDeclaringClass().isInterface()) {
                            annotatedMethodMap.a(b.a(method));
                        }
                    }
                }
            }
        }
    }

    private void m6771b(Class<?> cls, AnnotatedMethodMap annotatedMethodMap, Class<?> cls2, AnnotatedMethodMap annotatedMethodMap2) {
        List<Class> arrayList = new ArrayList();
        arrayList.add(cls2);
        ClassUtil.a(cls2, cls, arrayList);
        for (Class declaredMethods : arrayList) {
            for (Method method : declaredMethods.getDeclaredMethods()) {
                if (m6774c(method)) {
                    AnnotatedMethod b = annotatedMethodMap.b(method);
                    if (b != null) {
                        m6763a(method, b);
                    } else {
                        annotatedMethodMap2.a(m6753a(method));
                    }
                }
            }
        }
    }

    private Map<String, AnnotatedField> m6755a(Class<?> cls, Map<String, AnnotatedField> map) {
        Class superclass = cls.getSuperclass();
        if (superclass == null) {
            return map;
        }
        Map<String, AnnotatedField> a = m6755a(superclass, (Map) map);
        Map map2 = a;
        for (Field field : cls.getDeclaredFields()) {
            if (m6772b(field)) {
                if (map2 == null) {
                    map2 = new LinkedHashMap();
                }
                map2.put(field.getName(), m6752a(field));
            }
        }
        if (this.f4020d == null) {
            return map2;
        }
        Class d = this.f4020d.mo1064d(cls);
        if (d == null) {
            return map2;
        }
        m6761a(superclass, d, map2);
        return map2;
    }

    private void m6761a(Class<?> cls, Class<?> cls2, Map<String, AnnotatedField> map) {
        List<Class> arrayList = new ArrayList();
        arrayList.add(cls2);
        ClassUtil.a(cls2, cls, arrayList);
        for (Class declaredFields : arrayList) {
            for (Field field : declaredFields.getDeclaredFields()) {
                if (m6772b(field)) {
                    AnnotatedField annotatedField = (AnnotatedField) map.get(field.getName());
                    if (annotatedField != null) {
                        m6770b(annotatedField, field.getDeclaredAnnotations());
                    }
                }
            }
        }
    }

    private AnnotatedMethod m6753a(Method method) {
        if (this.f4019c == null) {
            return new AnnotatedMethod(method, m6780r(), null);
        }
        return new AnnotatedMethod(method, m6754a(method.getDeclaredAnnotations()), null);
    }

    private AnnotatedConstructor m6751a(Constructor<?> constructor, boolean z) {
        if (this.f4019c == null) {
            return new AnnotatedConstructor(constructor, m6780r(), m6766a(constructor.getParameterTypes().length));
        }
        if (z) {
            return new AnnotatedConstructor(constructor, m6754a(constructor.getDeclaredAnnotations()), null);
        }
        AnnotationMap[] a;
        Object parameterAnnotations = constructor.getParameterAnnotations();
        int length = constructor.getParameterTypes().length;
        if (length != parameterAnnotations.length) {
            Object obj;
            Class declaringClass = constructor.getDeclaringClass();
            if (declaringClass.isEnum() && length == parameterAnnotations.length + 2) {
                obj = new Annotation[(parameterAnnotations.length + 2)][];
                System.arraycopy(parameterAnnotations, 0, obj, 2, parameterAnnotations.length);
                a = m6767a((Annotation[][]) obj);
            } else if (declaringClass.isMemberClass() && length == parameterAnnotations.length + 1) {
                Annotation[][] annotationArr = new Annotation[(parameterAnnotations.length + 1)][];
                System.arraycopy(parameterAnnotations, 0, annotationArr, 1, parameterAnnotations.length);
                a = m6767a(annotationArr);
            } else {
                obj = parameterAnnotations;
                a = null;
            }
            if (a == null) {
                throw new IllegalStateException("Internal error: constructor for " + constructor.getDeclaringClass().getName() + " has mismatch: " + length + " parameters; " + obj.length + " sets of annotations");
            }
        }
        a = m6767a((Annotation[][]) parameterAnnotations);
        return new AnnotatedConstructor(constructor, m6754a(constructor.getDeclaredAnnotations()), a);
    }

    private AnnotatedMethod m6769b(Method method) {
        if (this.f4019c == null) {
            return new AnnotatedMethod(method, m6780r(), m6766a(method.getParameterTypes().length));
        }
        return new AnnotatedMethod(method, m6754a(method.getDeclaredAnnotations()), m6767a(method.getParameterAnnotations()));
    }

    private AnnotatedField m6752a(Field field) {
        if (this.f4019c == null) {
            return new AnnotatedField(field, m6780r());
        }
        return new AnnotatedField(field, m6754a(field.getDeclaredAnnotations()));
    }

    private static AnnotationMap m6780r() {
        return new AnnotationMap();
    }

    private AnnotationMap[] m6766a(int i) {
        if (i == 0) {
            return f4016m;
        }
        AnnotationMap[] annotationMapArr = new AnnotationMap[i];
        for (int i2 = 0; i2 < i; i2++) {
            annotationMapArr[i2] = m6780r();
        }
        return annotationMapArr;
    }

    private static boolean m6774c(Method method) {
        if (Modifier.isStatic(method.getModifiers()) || method.isSynthetic() || method.isBridge() || method.getParameterTypes().length > 2) {
            return false;
        }
        return true;
    }

    private static boolean m6772b(Field field) {
        if (field.isSynthetic()) {
            return false;
        }
        int modifiers = field.getModifiers();
        if (Modifier.isStatic(modifiers) || Modifier.isTransient(modifiers)) {
            return false;
        }
        return true;
    }

    private AnnotationMap[] m6767a(Annotation[][] annotationArr) {
        int length = annotationArr.length;
        AnnotationMap[] annotationMapArr = new AnnotationMap[length];
        for (int i = 0; i < length; i++) {
            annotationMapArr[i] = m6754a(annotationArr[i]);
        }
        return annotationMapArr;
    }

    private AnnotationMap m6754a(Annotation[] annotationArr) {
        AnnotationMap annotationMap = new AnnotationMap();
        m6759a(annotationMap, annotationArr);
        return annotationMap;
    }

    private void m6759a(AnnotationMap annotationMap, Annotation[] annotationArr) {
        if (annotationArr != null) {
            List list = null;
            for (Annotation annotation : annotationArr) {
                if (m6765a(annotation)) {
                    if (r0 == null) {
                        list = new LinkedList();
                    }
                    list.add(annotation.annotationType().getDeclaredAnnotations());
                } else {
                    annotationMap.m6808a(annotation);
                }
            }
            if (r0 != null) {
                for (Annotation[] a : r0) {
                    m6759a(annotationMap, a);
                }
            }
        }
    }

    private void m6756a(AnnotatedMember annotatedMember, Annotation[] annotationArr) {
        if (annotationArr != null) {
            List list = null;
            for (Annotation annotation : annotationArr) {
                if (m6765a(annotation)) {
                    if (r0 == null) {
                        list = new LinkedList();
                    }
                    list.add(annotation.annotationType().getDeclaredAnnotations());
                } else {
                    annotatedMember.b(annotation);
                }
            }
            if (r0 != null) {
                for (Annotation[] a : r0) {
                    m6756a(annotatedMember, a);
                }
            }
        }
    }

    private void m6770b(AnnotatedMember annotatedMember, Annotation[] annotationArr) {
        if (annotationArr != null) {
            List list = null;
            for (Annotation annotation : annotationArr) {
                if (m6765a(annotation)) {
                    if (r0 == null) {
                        list = new LinkedList();
                    }
                    list.add(annotation.annotationType().getDeclaredAnnotations());
                } else {
                    annotatedMember.a(annotation);
                }
            }
            if (r0 != null) {
                for (Annotation[] b : r0) {
                    m6770b(annotatedMember, b);
                }
            }
        }
    }

    private void m6762a(Constructor<?> constructor, AnnotatedConstructor annotatedConstructor, boolean z) {
        m6770b(annotatedConstructor, constructor.getDeclaredAnnotations());
        if (z) {
            Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
            int length = parameterAnnotations.length;
            for (int i = 0; i < length; i++) {
                for (Annotation a : parameterAnnotations[i]) {
                    annotatedConstructor.a(i, a);
                }
            }
        }
    }

    private void m6764a(Method method, AnnotatedMethod annotatedMethod, boolean z) {
        m6770b(annotatedMethod, method.getDeclaredAnnotations());
        if (z) {
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            int length = parameterAnnotations.length;
            for (int i = 0; i < length; i++) {
                for (Annotation a : parameterAnnotations[i]) {
                    annotatedMethod.a(i, a);
                }
            }
        }
    }

    private void m6763a(Method method, AnnotatedMethod annotatedMethod) {
        m6756a((AnnotatedMember) annotatedMethod, method.getDeclaredAnnotations());
    }

    private final boolean m6765a(Annotation annotation) {
        return this.f4019c != null && this.f4019c.mo979a(annotation);
    }

    public final String toString() {
        return "[AnnotedClass " + this.f4017a.getName() + "]";
    }
}
