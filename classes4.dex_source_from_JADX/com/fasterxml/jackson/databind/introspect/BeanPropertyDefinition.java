package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty;
import com.fasterxml.jackson.databind.PropertyName;

/* compiled from: video_data_thumbnail_url */
public abstract class BeanPropertyDefinition {
    public abstract String mo22a();

    public abstract PropertyName mo23b();

    public abstract boolean mo24c();

    public abstract boolean mo25e();

    public abstract boolean mo26f();

    public abstract boolean mo27g();

    public abstract boolean mo28h();

    public abstract AnnotatedMethod mo29i();

    public abstract AnnotatedMethod mo30j();

    public abstract AnnotatedField mo31k();

    public abstract AnnotatedParameter mo32l();

    public abstract AnnotatedMember mo33m();

    public abstract AnnotatedMember mo34n();

    public final boolean m428d() {
        return mo34n() != null;
    }

    public AnnotatedMember mo35o() {
        return null;
    }

    public Class<?>[] mo36p() {
        return null;
    }

    public ReferenceProperty mo37q() {
        return null;
    }

    public boolean mo38r() {
        return false;
    }

    public boolean mo39s() {
        return false;
    }
}
