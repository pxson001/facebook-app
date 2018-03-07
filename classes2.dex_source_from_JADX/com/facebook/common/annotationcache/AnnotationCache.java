package com.facebook.common.annotationcache;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Optional;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBasedTable.Factory;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.HashMap;
import java.util.Map;

/* compiled from: survey_theme_arg */
public class AnnotationCache {
    public static final AnnotationCache f3736a = new AnnotationCache();
    private final Table<AnnotatedElement, Class<? extends Annotation>, Optional<Annotation>> f3737b = new HashBasedTable(new HashMap(), new Factory(0));
    private final Map<AnnotatedElement, Annotation[][]> f3738c = Maps.m838c();
    private int f3739d;
    private int f3740e;

    @VisibleForTesting
    AnnotationCache() {
    }

    public static AnnotationCache m6137a() {
        return f3736a;
    }

    private synchronized <A extends Annotation> A m6138b(AnnotatedElement annotatedElement, Class<A> cls) {
        A a;
        Optional optional = (Optional) this.f3737b.mo886a(annotatedElement, cls);
        if (optional != null) {
            this.f3739d++;
            a = (Annotation) optional.orNull();
        } else {
            a = annotatedElement.getAnnotation(cls);
            this.f3737b.mo887a(annotatedElement, cls, Optional.fromNullable(a));
            this.f3740e++;
        }
        return a;
    }

    public final synchronized boolean m6139a(AnnotatedElement annotatedElement, Class<? extends Annotation> cls) {
        return m6138b(annotatedElement, cls) != null;
    }
}
