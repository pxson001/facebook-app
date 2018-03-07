package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.util.Annotations;

/* compiled from: vault_upload_start */
public interface BeanProperty {

    /* compiled from: vault_upload_start */
    public class Std implements BeanProperty {
        protected final String f351a;
        protected final JavaType f352b;
        protected final PropertyName f353c;
        protected final boolean f354d;
        protected final AnnotatedMember f355e;
        protected final Annotations f356f;

        public Std(String str, JavaType javaType, PropertyName propertyName, Annotations annotations, AnnotatedMember annotatedMember, boolean z) {
            this.f351a = str;
            this.f352b = javaType;
            this.f353c = propertyName;
            this.f354d = z;
            this.f355e = annotatedMember;
            this.f356f = annotations;
        }

        public final Std m593a(JavaType javaType) {
            return new Std(this.f351a, javaType, this.f353c, this.f356f, this.f355e, this.f354d);
        }

        public final JavaType mo45a() {
            return this.f352b;
        }

        public final PropertyName m596c() {
            return this.f353c;
        }

        public final boolean m597d() {
            return this.f354d;
        }

        public final AnnotatedMember mo46b() {
            return this.f355e;
        }
    }

    JavaType mo45a();

    AnnotatedMember mo46b();
}
