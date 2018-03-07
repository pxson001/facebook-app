package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;

/* compiled from: video_home_stale_data_interval_s */
public abstract class AnnotatedMember extends Annotated implements Serializable {
    private static final long serialVersionUID = 7364428299211355871L;
    protected final transient AnnotationMap f275b;

    public abstract void mo17a(Object obj, Object obj2);

    public abstract Object mo18b(Object obj);

    public abstract Class<?> mo19i();

    public abstract Member mo20j();

    protected AnnotatedMember(AnnotationMap annotationMap) {
        this.f275b = annotationMap;
    }

    protected final AnnotationMap m370e() {
        return this.f275b;
    }

    public final void m367a(Annotation annotation) {
        this.f275b.b(annotation);
    }

    public final void m369b(Annotation annotation) {
        this.f275b.a(annotation);
    }

    public final void m373k() {
        ClassUtil.m311a(mo20j());
    }
}
