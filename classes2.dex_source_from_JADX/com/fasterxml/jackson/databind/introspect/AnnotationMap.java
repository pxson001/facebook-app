package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.util.Annotations;
import java.lang.annotation.Annotation;
import java.util.HashMap;

/* compiled from: story_max_age_in_cache_in_hours */
public final class AnnotationMap implements Annotations {
    protected HashMap<Class<? extends Annotation>, Annotation> f4029a;

    private AnnotationMap(HashMap<Class<? extends Annotation>, Annotation> hashMap) {
        this.f4029a = hashMap;
    }

    public final <A extends Annotation> A m6807a(Class<A> cls) {
        if (this.f4029a == null) {
            return null;
        }
        return (Annotation) this.f4029a.get(cls);
    }

    public static AnnotationMap m6804a(AnnotationMap annotationMap, AnnotationMap annotationMap2) {
        if (annotationMap == null || annotationMap.f4029a == null || annotationMap.f4029a.isEmpty()) {
            return annotationMap2;
        }
        if (annotationMap2 == null || annotationMap2.f4029a == null || annotationMap2.f4029a.isEmpty()) {
            return annotationMap;
        }
        HashMap hashMap = new HashMap();
        for (Annotation annotation : annotationMap2.f4029a.values()) {
            hashMap.put(annotation.annotationType(), annotation);
        }
        for (Annotation annotation2 : annotationMap.f4029a.values()) {
            hashMap.put(annotation2.annotationType(), annotation2);
        }
        return new AnnotationMap(hashMap);
    }

    public final int m6806a() {
        return this.f4029a == null ? 0 : this.f4029a.size();
    }

    public final void m6808a(Annotation annotation) {
        if (this.f4029a == null || !this.f4029a.containsKey(annotation.annotationType())) {
            m6805c(annotation);
        }
    }

    public final void m6809b(Annotation annotation) {
        m6805c(annotation);
    }

    public final String toString() {
        if (this.f4029a == null) {
            return "[null]";
        }
        return this.f4029a.toString();
    }

    private void m6805c(Annotation annotation) {
        if (this.f4029a == null) {
            this.f4029a = new HashMap();
        }
        this.f4029a.put(annotation.annotationType(), annotation);
    }
}
