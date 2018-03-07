package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

/* compiled from: video_atom_size */
public final class AnnotatedConstructor extends AnnotatedWithParams {
    private static final long serialVersionUID = 1;
    public final Constructor<?> _constructor;
    protected Serialization _serialization;

    public AnnotatedConstructor(Constructor<?> constructor, AnnotationMap annotationMap, AnnotationMap[] annotationMapArr) {
        super(annotationMap, annotationMapArr);
        if (constructor == null) {
            throw new IllegalArgumentException("Null constructor not allowed");
        }
        this._constructor = constructor;
    }

    private AnnotatedConstructor(Serialization serialization) {
        super(null, null);
        this._constructor = null;
        this._serialization = serialization;
    }

    public final /* synthetic */ AnnotatedElement m502a() {
        return this._constructor;
    }

    public final Constructor<?> m509f() {
        return this._constructor;
    }

    public final String m505b() {
        return this._constructor.getName();
    }

    public final Type m507c() {
        return d();
    }

    public final Class<?> m508d() {
        return this._constructor.getDeclaringClass();
    }

    public final JavaType m498a(TypeBindings typeBindings) {
        return m479a(typeBindings, this._constructor.getTypeParameters());
    }

    public final int m510g() {
        return this._constructor.getParameterTypes().length;
    }

    public final Class<?> mo40a(int i) {
        Class[] parameterTypes = this._constructor.getParameterTypes();
        return i >= parameterTypes.length ? null : parameterTypes[i];
    }

    public final Type mo43b(int i) {
        Type[] genericParameterTypes = this._constructor.getGenericParameterTypes();
        return i >= genericParameterTypes.length ? null : genericParameterTypes[i];
    }

    public final Object mo44h() {
        return this._constructor.newInstance(new Object[0]);
    }

    public final Object mo42a(Object[] objArr) {
        return this._constructor.newInstance(objArr);
    }

    public final Object mo41a(Object obj) {
        return this._constructor.newInstance(new Object[]{obj});
    }

    public final Class<?> mo19i() {
        return this._constructor.getDeclaringClass();
    }

    public final Member mo20j() {
        return this._constructor;
    }

    public final void mo17a(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Cannot call setValue() on constructor of " + mo19i().getName());
    }

    public final Object mo18b(Object obj) {
        throw new UnsupportedOperationException("Cannot call getValue() on constructor of " + mo19i().getName());
    }

    public final String toString() {
        return "[constructor for " + b() + ", annotations: " + this.f275b + "]";
    }

    final Object writeReplace() {
        return new AnnotatedConstructor(new Serialization(this._constructor));
    }

    final Object readResolve() {
        Class cls = this._serialization.clazz;
        try {
            Member declaredConstructor = cls.getDeclaredConstructor(this._serialization.args);
            if (!declaredConstructor.isAccessible()) {
                ClassUtil.m311a(declaredConstructor);
            }
            return new AnnotatedConstructor(declaredConstructor, null, null);
        } catch (Exception e) {
            throw new IllegalArgumentException("Could not find constructor with " + this._serialization.args.length + " args from Class '" + cls.getName());
        }
    }
}
