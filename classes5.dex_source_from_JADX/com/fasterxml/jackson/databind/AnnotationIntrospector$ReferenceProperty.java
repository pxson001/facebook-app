package com.fasterxml.jackson.databind;

/* compiled from: close */
public class AnnotationIntrospector$ReferenceProperty {
    private final Type f5970a;
    public final String f5971b;

    /* compiled from: close */
    public enum Type {
        MANAGED_REFERENCE,
        BACK_REFERENCE
    }

    private AnnotationIntrospector$ReferenceProperty(Type type, String str) {
        this.f5970a = type;
        this.f5971b = str;
    }

    public static AnnotationIntrospector$ReferenceProperty m10784a(String str) {
        return new AnnotationIntrospector$ReferenceProperty(Type.MANAGED_REFERENCE, str);
    }

    public static AnnotationIntrospector$ReferenceProperty m10785b(String str) {
        return new AnnotationIntrospector$ReferenceProperty(Type.BACK_REFERENCE, str);
    }

    public final String m10786a() {
        return this.f5971b;
    }

    public final boolean m10787b() {
        return this.f5970a == Type.MANAGED_REFERENCE;
    }

    public final boolean m10788c() {
        return this.f5970a == Type.BACK_REFERENCE;
    }
}
