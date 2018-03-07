package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;

/* compiled from: can_viewer_edit_post_privacy */
public class SimpleBeanPropertyDefinition extends BeanPropertyDefinition {
    protected final AnnotationIntrospector f6253a;
    protected final AnnotatedMember f6254b;
    protected final String f6255c;

    private SimpleBeanPropertyDefinition(AnnotatedMember annotatedMember, String str, AnnotationIntrospector annotationIntrospector) {
        this.f6253a = annotationIntrospector;
        this.f6254b = annotatedMember;
        this.f6255c = str;
    }

    public static SimpleBeanPropertyDefinition m11809a(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember) {
        AnnotationIntrospector annotationIntrospector;
        String b = annotatedMember.b();
        if (mapperConfig == null) {
            annotationIntrospector = null;
        } else {
            annotationIntrospector = mapperConfig.a();
        }
        return new SimpleBeanPropertyDefinition(annotatedMember, b, annotationIntrospector);
    }

    public static SimpleBeanPropertyDefinition m11810a(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, String str) {
        AnnotationIntrospector annotationIntrospector;
        if (mapperConfig == null) {
            annotationIntrospector = null;
        } else {
            annotationIntrospector = mapperConfig.a();
        }
        return new SimpleBeanPropertyDefinition(annotatedMember, str, annotationIntrospector);
    }

    public final String m11811a() {
        return this.f6255c;
    }

    public final PropertyName m11812b() {
        return this.f6253a == null ? null : null;
    }

    public final boolean m11813c() {
        return false;
    }

    public final boolean m11814e() {
        return i() != null;
    }

    public final boolean m11815f() {
        return j() != null;
    }

    public final boolean m11816g() {
        return this.f6254b instanceof AnnotatedField;
    }

    public final boolean m11817h() {
        return this.f6254b instanceof AnnotatedParameter;
    }

    public final AnnotatedMethod m11818i() {
        if ((this.f6254b instanceof AnnotatedMethod) && ((AnnotatedMethod) this.f6254b).l() == 0) {
            return (AnnotatedMethod) this.f6254b;
        }
        return null;
    }

    public final AnnotatedMethod m11819j() {
        if ((this.f6254b instanceof AnnotatedMethod) && ((AnnotatedMethod) this.f6254b).l() == 1) {
            return (AnnotatedMethod) this.f6254b;
        }
        return null;
    }

    public final AnnotatedField m11820k() {
        return this.f6254b instanceof AnnotatedField ? (AnnotatedField) this.f6254b : null;
    }

    public final AnnotatedParameter m11821l() {
        return this.f6254b instanceof AnnotatedParameter ? (AnnotatedParameter) this.f6254b : null;
    }

    public final AnnotatedMember m11822m() {
        AnnotatedMember i = i();
        if (i == null) {
            return k();
        }
        return i;
    }

    public final AnnotatedMember m11823n() {
        AnnotatedMember l = l();
        if (l != null) {
            return l;
        }
        l = j();
        if (l == null) {
            return k();
        }
        return l;
    }

    public final AnnotatedMember m11824o() {
        return this.f6254b;
    }
}
