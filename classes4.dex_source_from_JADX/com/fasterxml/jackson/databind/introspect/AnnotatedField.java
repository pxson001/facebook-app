package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

/* compiled from: video_log_max_bitrate_kbps */
public final class AnnotatedField extends AnnotatedMember implements Serializable {
    private static final long serialVersionUID = 7364428299211355871L;
    protected Serialization _serialization;
    public final transient Field f274a;

    public AnnotatedField(Field field, AnnotationMap annotationMap) {
        super(annotationMap);
        this.f274a = field;
    }

    public final AnnotatedField m353a(AnnotationMap annotationMap) {
        return new AnnotatedField(this.f274a, annotationMap);
    }

    private AnnotatedField(Serialization serialization) {
        super(null);
        this.f274a = null;
        this._serialization = serialization;
    }

    public final /* synthetic */ AnnotatedElement m355a() {
        return this.f274a;
    }

    public final Field m361f() {
        return this.f274a;
    }

    public final int m362g() {
        return this.f274a.getModifiers();
    }

    public final String m358b() {
        return this.f274a.getName();
    }

    public final <A extends Annotation> A m354a(Class<A> cls) {
        return this.f275b == null ? null : this.f275b.a(cls);
    }

    public final Type m359c() {
        return this.f274a.getGenericType();
    }

    public final Class<?> m360d() {
        return this.f274a.getType();
    }

    public final Class<?> mo19i() {
        return this.f274a.getDeclaringClass();
    }

    public final Member mo20j() {
        return this.f274a;
    }

    public final void mo17a(Object obj, Object obj2) {
        try {
            this.f274a.set(obj, obj2);
        } catch (Throwable e) {
            throw new IllegalArgumentException("Failed to setValue() for field " + m363h() + ": " + e.getMessage(), e);
        }
    }

    public final Object mo18b(Object obj) {
        try {
            return this.f274a.get(obj);
        } catch (Throwable e) {
            throw new IllegalArgumentException("Failed to getValue() for field " + m363h() + ": " + e.getMessage(), e);
        }
    }

    public final String m363h() {
        return mo19i().getName() + "#" + b();
    }

    public final String toString() {
        return "[field " + m363h() + "]";
    }

    final Object writeReplace() {
        return new AnnotatedField(new Serialization(this.f274a));
    }

    final Object readResolve() {
        Class cls = this._serialization.clazz;
        try {
            Member declaredField = cls.getDeclaredField(this._serialization.name);
            if (!declaredField.isAccessible()) {
                ClassUtil.m311a(declaredField);
            }
            return new AnnotatedField(declaredField, null);
        } catch (Exception e) {
            throw new IllegalArgumentException("Could not find method '" + this._serialization.name + "' from Class '" + cls.getName());
        }
    }
}
