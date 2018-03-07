package com.fasterxml.jackson.databind.util;

/* compiled from: can_viewer_export */
public abstract class NameTransformer {
    public static final NameTransformer f6237a = new C05561();

    /* compiled from: can_viewer_export */
    final class C05561 extends NameTransformer {
        C05561() {
        }

        public final String mo728a(String str) {
            return str;
        }
    }

    /* compiled from: can_viewer_export */
    final class C05572 extends NameTransformer {
        final /* synthetic */ String f6238b;
        final /* synthetic */ String f6239c;

        C05572(String str, String str2) {
            this.f6238b = str;
            this.f6239c = str2;
        }

        public final String mo728a(String str) {
            return this.f6238b + str + this.f6239c;
        }

        public final String toString() {
            return "[PreAndSuffixTransformer('" + this.f6238b + "','" + this.f6239c + "')]";
        }
    }

    /* compiled from: can_viewer_export */
    final class C05583 extends NameTransformer {
        final /* synthetic */ String f6240b;

        C05583(String str) {
            this.f6240b = str;
        }

        public final String mo728a(String str) {
            return this.f6240b + str;
        }

        public final String toString() {
            return "[PrefixTransformer('" + this.f6240b + "')]";
        }
    }

    /* compiled from: can_viewer_export */
    final class C05594 extends NameTransformer {
        final /* synthetic */ String f6241b;

        C05594(String str) {
            this.f6241b = str;
        }

        public final String mo728a(String str) {
            return str + this.f6241b;
        }

        public final String toString() {
            return "[SuffixTransformer('" + this.f6241b + "')]";
        }
    }

    /* compiled from: can_viewer_export */
    public class Chained extends NameTransformer {
        protected final NameTransformer f6242b;
        protected final NameTransformer f6243c;

        public Chained(NameTransformer nameTransformer, NameTransformer nameTransformer2) {
            this.f6242b = nameTransformer;
            this.f6243c = nameTransformer2;
        }

        public final String mo728a(String str) {
            return this.f6242b.mo728a(this.f6243c.mo728a(str));
        }

        public String toString() {
            return "[ChainedTransformer(" + this.f6242b + ", " + this.f6243c + ")]";
        }
    }

    public abstract String mo728a(String str);

    protected NameTransformer() {
    }

    public static NameTransformer m11787a(String str, String str2) {
        Object obj = 1;
        Object obj2 = (str == null || str.length() <= 0) ? null : 1;
        if (str2 == null || str2.length() <= 0) {
            obj = null;
        }
        if (obj2 == null) {
            return obj != null ? new C05594(str2) : f6237a;
        } else {
            if (obj != null) {
                return new C05572(str, str2);
            }
            return new C05583(str);
        }
    }

    public static NameTransformer m11786a(NameTransformer nameTransformer, NameTransformer nameTransformer2) {
        return new Chained(nameTransformer, nameTransformer2);
    }
}
