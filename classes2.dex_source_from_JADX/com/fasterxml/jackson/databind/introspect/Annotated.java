package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;

/* compiled from: story_ranking_time */
public abstract class Annotated {
    public abstract <A extends Annotation> A mo936a(Class<A> cls);

    public abstract AnnotatedElement mo937a();

    public abstract String mo938b();

    public abstract Type mo939c();

    public abstract Class<?> mo940d();

    protected abstract AnnotationMap mo941e();

    protected Annotated() {
    }

    public final <A extends Annotation> boolean m6800b(Class<A> cls) {
        return mo936a((Class) cls) != null;
    }

    public JavaType m6796a(TypeBindings typeBindings) {
        return typeBindings.a(mo939c());
    }
}
