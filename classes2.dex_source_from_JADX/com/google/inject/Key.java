package com.google.inject;

import com.google.common.base.Preconditions;
import com.google.inject.internal.Annotations;
import com.google.inject.internal.MoreTypes;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* compiled from: x-fb-net-hni */
public class Key<T> {
    private final AnnotationStrategy f663a;
    public final TypeLiteral<T> f664b;
    private final int f665c;

    /* compiled from: x-fb-net-hni */
    public enum NullAnnotationStrategy implements AnnotationStrategy {
        INSTANCE;

        public final boolean hasAttributes() {
            return false;
        }

        public final AnnotationStrategy withoutAttributes() {
            throw new UnsupportedOperationException("Key already has no attributes.");
        }

        public final Annotation getAnnotation() {
            return null;
        }

        public final Class<? extends Annotation> getAnnotationType() {
            return null;
        }

        public final String toString() {
            return "[none]";
        }
    }

    /* compiled from: x-fb-net-hni */
    interface AnnotationStrategy {
        Annotation getAnnotation();

        Class<? extends Annotation> getAnnotationType();
    }

    /* compiled from: x-fb-net-hni */
    class AnnotationTypeStrategy implements AnnotationStrategy {
        final Class<? extends Annotation> f679a;
        final Annotation f680b;

        AnnotationTypeStrategy(Class<? extends Annotation> cls, @Nullable Annotation annotation) {
            this.f679a = (Class) Preconditions.checkNotNull(cls, "annotation type");
            this.f680b = annotation;
        }

        public Annotation getAnnotation() {
            return this.f680b;
        }

        public Class<? extends Annotation> getAnnotationType() {
            return this.f679a;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof AnnotationTypeStrategy)) {
                return false;
            }
            return this.f679a.equals(((AnnotationTypeStrategy) obj).f679a);
        }

        public int hashCode() {
            return this.f679a.hashCode();
        }

        public String toString() {
            return "@" + this.f679a.getName();
        }
    }

    private Key() {
        this.f663a = NullAnnotationStrategy.INSTANCE;
        this.f664b = new TypeLiteral(TypeLiteral.m1373b(getClass()));
        this.f665c = m1368d();
    }

    public Key(Type type, AnnotationStrategy annotationStrategy) {
        this.f663a = annotationStrategy;
        this.f664b = MoreTypes.m1376a(TypeLiteral.m1372a(type));
        this.f665c = m1368d();
    }

    public Key(TypeLiteral<T> typeLiteral, AnnotationStrategy annotationStrategy) {
        this.f663a = annotationStrategy;
        this.f664b = MoreTypes.m1376a((TypeLiteral) typeLiteral);
        this.f665c = m1368d();
    }

    private int m1368d() {
        return (this.f664b.hashCode() * 31) + this.f663a.hashCode();
    }

    public final TypeLiteral<T> m1369a() {
        return this.f664b;
    }

    public final Class<? extends Annotation> m1370b() {
        return this.f663a.getAnnotationType();
    }

    public final Annotation m1371c() {
        return this.f663a.getAnnotation();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Key)) {
            return false;
        }
        Key key = (Key) obj;
        if (this.f663a.equals(key.f663a) && this.f664b.equals(key.f664b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f665c;
    }

    public final String toString() {
        return "Key[type=" + this.f664b + ", annotation=" + this.f663a + "]";
    }

    public static <T> Key<T> m1365a(Class<T> cls) {
        return new Key((Type) cls, NullAnnotationStrategy.INSTANCE);
    }

    public static <S> Key<S> m1366a(Class<S> cls, Class<? extends Annotation> cls2) {
        return new Key((Type) cls, m1367b(cls2));
    }

    public static <S> Key<S> m1363a(TypeLiteral<S> typeLiteral) {
        return new Key((TypeLiteral) typeLiteral, NullAnnotationStrategy.INSTANCE);
    }

    public static <S> Key<S> m1364a(TypeLiteral<S> typeLiteral, Class<? extends Annotation> cls) {
        return new Key((TypeLiteral) typeLiteral, m1367b(cls));
    }

    public static AnnotationStrategy m1362a(Annotation annotation) {
        Object obj;
        Preconditions.checkNotNull(annotation, "annotation");
        Class annotationType = annotation.annotationType();
        if (annotationType.getDeclaredMethods().length == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            return new AnnotationTypeStrategy(annotationType, annotation);
        }
        return new AnnotationInstanceStrategy(Annotations.m1400a(annotation));
    }

    public static AnnotationStrategy m1367b(Class<? extends Annotation> cls) {
        Preconditions.checkNotNull(cls, "annotation type");
        return new AnnotationTypeStrategy(Annotations.m1401b(cls), null);
    }
}
