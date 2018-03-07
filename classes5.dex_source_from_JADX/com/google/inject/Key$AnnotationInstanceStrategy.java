package com.google.inject;

import com.google.common.base.Preconditions;
import com.google.inject.Key.AnnotationStrategy;
import java.lang.annotation.Annotation;

/* compiled from: bug_build_number */
class Key$AnnotationInstanceStrategy implements AnnotationStrategy {
    final Annotation f7684a;

    Key$AnnotationInstanceStrategy(Annotation annotation) {
        this.f7684a = (Annotation) Preconditions.checkNotNull(annotation, "annotation");
    }

    public Annotation getAnnotation() {
        return this.f7684a;
    }

    public Class<? extends Annotation> getAnnotationType() {
        return this.f7684a.annotationType();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Key$AnnotationInstanceStrategy)) {
            return false;
        }
        return this.f7684a.equals(((Key$AnnotationInstanceStrategy) obj).f7684a);
    }

    public int hashCode() {
        return this.f7684a.hashCode();
    }

    public String toString() {
        return this.f7684a.toString();
    }
}
