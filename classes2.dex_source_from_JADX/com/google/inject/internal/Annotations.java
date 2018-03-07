package com.google.inject.internal;

import com.google.common.base.Function;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheLoader.FunctionToCacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.inject.BindingAnnotation;
import com.google.inject.ScopeAnnotation;
import com.google.inject.name.NamedImpl;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collection;
import javax.inject.Named;
import javax.inject.Qualifier;
import javax.inject.Scope;

/* compiled from: write text value */
public class Annotations {
    private static final AnnotationChecker f681a = new AnnotationChecker(Arrays.asList(new Class[]{ScopeAnnotation.class, Scope.class}));
    private static final AnnotationChecker f682b = new AnnotationChecker(Arrays.asList(new Class[]{BindingAnnotation.class, Qualifier.class}));

    /* compiled from: write text value */
    class AnnotationChecker {
        final LoadingCache<Class<? extends Annotation>, Boolean> f683a = CacheBuilder.newBuilder().m1138g().m1127a(this.f685c);
        public final Collection<Class<? extends Annotation>> f684b;
        private CacheLoader<Class<? extends Annotation>, Boolean> f685c = new FunctionToCacheLoader(new C00411(this));

        /* compiled from: write text value */
        class C00411 implements Function<Class<? extends Annotation>, Boolean> {
            final /* synthetic */ AnnotationChecker f686a;

            C00411(AnnotationChecker annotationChecker) {
                this.f686a = annotationChecker;
            }

            public Object apply(Object obj) {
                for (Annotation annotationType : ((Class) obj).getAnnotations()) {
                    if (this.f686a.f684b.contains(annotationType.annotationType())) {
                        return Boolean.valueOf(true);
                    }
                }
                return Boolean.valueOf(false);
            }
        }

        AnnotationChecker(Collection<Class<? extends Annotation>> collection) {
            this.f684b = collection;
        }
    }

    public static Annotation m1400a(Annotation annotation) {
        return annotation instanceof Named ? new NamedImpl(((Named) annotation).value()) : annotation;
    }

    public static Class<? extends Annotation> m1401b(Class<? extends Annotation> cls) {
        if (cls == Named.class) {
            return com.google.inject.name.Named.class;
        }
        return cls;
    }
}
