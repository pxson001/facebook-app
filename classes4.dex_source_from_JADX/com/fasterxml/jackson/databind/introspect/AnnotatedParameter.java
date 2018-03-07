package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.type.TypeFactory;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

/* compiled from: videoChannelIds should not have been previously already set */
public final class AnnotatedParameter extends AnnotatedMember {
    private static final long serialVersionUID = 1;
    public final int _index;
    public final AnnotatedWithParams _owner;
    protected final Type _type;

    public AnnotatedParameter(AnnotatedWithParams annotatedWithParams, Type type, AnnotationMap annotationMap, int i) {
        super(annotationMap);
        this._owner = annotatedWithParams;
        this._type = type;
        this._index = i;
    }

    public final AnnotatedParameter m514a(AnnotationMap annotationMap) {
        return annotationMap == this.f275b ? this : this._owner.m480a(this._index, annotationMap);
    }

    public final AnnotatedElement m516a() {
        return null;
    }

    public final String m519b() {
        return "";
    }

    public final <A extends Annotation> A m515a(Class<A> cls) {
        return this.f275b == null ? null : this.f275b.a(cls);
    }

    public final Type m520c() {
        return this._type;
    }

    public final Class<?> m521d() {
        if (this._type instanceof Class) {
            return (Class) this._type;
        }
        return TypeFactory.a.a(this._type)._class;
    }

    public final Class<?> mo19i() {
        return this._owner.mo19i();
    }

    public final Member mo20j() {
        return this._owner.mo20j();
    }

    public final void mo17a(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Cannot call setValue() on constructor parameter of " + mo19i().getName());
    }

    public final Object mo18b(Object obj) {
        throw new UnsupportedOperationException("Cannot call getValue() on constructor parameter of " + mo19i().getName());
    }

    public final Type m522f() {
        return this._type;
    }

    public final AnnotatedWithParams m523g() {
        return this._owner;
    }

    public final int m524h() {
        return this._index;
    }

    public final String toString() {
        return "[parameter #" + this._index + ", annotations: " + this.f275b + "]";
    }
}
