package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* compiled from: video_data_length */
public abstract class AnnotatedWithParams extends AnnotatedMember {
    private static final long serialVersionUID = 1;
    protected final AnnotationMap[] _paramAnnotations;

    public abstract Object mo41a(Object obj);

    public abstract Object mo42a(Object[] objArr);

    public abstract Type mo43b(int i);

    public abstract Object mo44h();

    protected AnnotatedWithParams(AnnotationMap annotationMap, AnnotationMap[] annotationMapArr) {
        super(annotationMap);
        this._paramAnnotations = annotationMapArr;
    }

    public final void m484a(int i, Annotation annotation) {
        AnnotationMap annotationMap = this._paramAnnotations[i];
        if (annotationMap == null) {
            annotationMap = new AnnotationMap();
            this._paramAnnotations[i] = annotationMap;
        }
        annotationMap.b(annotation);
    }

    protected final AnnotatedParameter m480a(int i, AnnotationMap annotationMap) {
        this._paramAnnotations[i] = annotationMap;
        return m486c(i);
    }

    protected final JavaType m479a(TypeBindings typeBindings, TypeVariable<?>[] typeVariableArr) {
        if (typeVariableArr != null && typeVariableArr.length > 0) {
            typeBindings = typeBindings.m586a();
            for (TypeVariable typeVariable : typeVariableArr) {
                JavaType c;
                typeBindings.m588b(typeVariable.getName());
                Type type = typeVariable.getBounds()[0];
                if (type == null) {
                    c = TypeFactory.c();
                } else {
                    c = typeBindings.m585a(type);
                }
                typeBindings.m587a(typeVariable.getName(), c);
            }
        }
        return typeBindings.m585a(c());
    }

    public final <A extends Annotation> A m483a(Class<A> cls) {
        return this.f275b.a(cls);
    }

    private AnnotationMap mo40a(int i) {
        if (this._paramAnnotations == null || i < 0 || i > this._paramAnnotations.length) {
            return null;
        }
        return this._paramAnnotations[i];
    }

    public final AnnotatedParameter m486c(int i) {
        return new AnnotatedParameter(this, mo43b(i), mo40a(i), i);
    }
}
