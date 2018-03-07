package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* compiled from: video_data_rotation */
public final class AnnotatedMethod extends AnnotatedWithParams implements Serializable {
    private static final long serialVersionUID = 1;
    protected Class<?>[] _paramClasses;
    protected Serialization _serialization;
    public final transient Method f299a;

    public AnnotatedMethod(Method method, AnnotationMap annotationMap, AnnotationMap[] annotationMapArr) {
        super(annotationMap, annotationMapArr);
        if (method == null) {
            throw new IllegalArgumentException("Can not construct AnnotatedMethod with null Method");
        }
        this.f299a = method;
    }

    private AnnotatedMethod(Serialization serialization) {
        super(null, null);
        this.f299a = null;
        this._serialization = serialization;
    }

    public final AnnotatedMethod m458a(Method method) {
        return new AnnotatedMethod(method, this.f275b, this._paramAnnotations);
    }

    public final AnnotatedMethod m457a(AnnotationMap annotationMap) {
        return new AnnotatedMethod(this.f299a, annotationMap, this._paramAnnotations);
    }

    public final /* synthetic */ AnnotatedElement m462a() {
        return this.f299a;
    }

    public final Method m469f() {
        return this.f299a;
    }

    public final String m465b() {
        return this.f299a.getName();
    }

    public final Type m467c() {
        return this.f299a.getGenericReturnType();
    }

    public final Class<?> m468d() {
        return this.f299a.getReturnType();
    }

    public final JavaType m456a(TypeBindings typeBindings) {
        return m479a(typeBindings, this.f299a.getTypeParameters());
    }

    public final Object mo44h() {
        return this.f299a.invoke(null, new Object[0]);
    }

    public final Object mo42a(Object[] objArr) {
        return this.f299a.invoke(null, objArr);
    }

    public final Object mo41a(Object obj) {
        return this.f299a.invoke(null, new Object[]{obj});
    }

    public final Class<?> mo19i() {
        return this.f299a.getDeclaringClass();
    }

    public final Method m470g() {
        return this.f299a;
    }

    public final /* synthetic */ Member mo20j() {
        return this.f299a;
    }

    public final void mo17a(Object obj, Object obj2) {
        try {
            this.f299a.invoke(obj, new Object[]{obj2});
        } catch (Throwable e) {
            throw new IllegalArgumentException("Failed to setValue() with method " + m475m() + ": " + e.getMessage(), e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException("Failed to setValue() with method " + m475m() + ": " + e2.getMessage(), e2);
        }
    }

    public final Object mo18b(Object obj) {
        try {
            return this.f299a.invoke(obj, new Object[0]);
        } catch (Throwable e) {
            throw new IllegalArgumentException("Failed to getValue() with method " + m475m() + ": " + e.getMessage(), e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException("Failed to getValue() with method " + m475m() + ": " + e2.getMessage(), e2);
        }
    }

    public final int m474l() {
        return m476n().length;
    }

    public final String m475m() {
        return mo19i().getName() + "#" + b() + "(" + m474l() + " params)";
    }

    public final Class<?>[] m476n() {
        if (this._paramClasses == null) {
            this._paramClasses = this.f299a.getParameterTypes();
        }
        return this._paramClasses;
    }

    public final Class<?> mo40a(int i) {
        Class[] n = m476n();
        return i >= n.length ? null : n[i];
    }

    public final Type mo43b(int i) {
        Type[] genericParameterTypes = this.f299a.getGenericParameterTypes();
        return i >= genericParameterTypes.length ? null : genericParameterTypes[i];
    }

    public final Class<?> m477o() {
        return this.f299a.getReturnType();
    }

    public final String toString() {
        return "[method " + m475m() + "]";
    }

    final Object writeReplace() {
        return new AnnotatedMethod(new Serialization(this.f299a));
    }

    final Object readResolve() {
        Class cls = this._serialization.clazz;
        try {
            Member declaredMethod = cls.getDeclaredMethod(this._serialization.name, this._serialization.args);
            if (!declaredMethod.isAccessible()) {
                ClassUtil.m311a(declaredMethod);
            }
            return new AnnotatedMethod(declaredMethod, null, null);
        } catch (Exception e) {
            throw new IllegalArgumentException("Could not find method '" + this._serialization.name + "' from Class '" + cls.getName());
        }
    }
}
