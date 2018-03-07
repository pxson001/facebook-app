package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty;
import com.fasterxml.jackson.databind.PropertyName;

/* compiled from: video_data_width */
public class POJOPropertyBuilder extends BeanPropertyDefinition implements Comparable<POJOPropertyBuilder> {
    protected final boolean f285a;
    protected final AnnotationIntrospector f286b;
    protected final String f287c;
    public final String f288d;
    protected Linked<AnnotatedField> f289e;
    protected Linked<AnnotatedParameter> f290f;
    protected Linked<AnnotatedMethod> f291g;
    protected Linked<AnnotatedMethod> f292h;

    /* compiled from: video_data_width */
    final class Linked<T> {
        public final T f293a;
        public final Linked<T> f294b;
        public final String f295c;
        public final boolean f296d;
        public final boolean f297e;

        public Linked(T t, Linked<T> linked, String str, boolean z, boolean z2) {
            Linked linked2;
            this.f293a = t;
            this.f294b = linked;
            if (str == null) {
                str = null;
                linked2 = this;
            } else if (str.length() == 0) {
                str = null;
                linked2 = this;
            } else {
                linked2 = this;
            }
            linked2.f295c = str;
            this.f296d = z;
            this.f297e = z2;
        }

        public final Linked<T> m448a(T t) {
            if (t == this.f293a) {
                return this;
            }
            return new Linked(t, this.f294b, this.f295c, this.f296d, this.f297e);
        }

        private Linked<T> m444a(Linked<T> linked) {
            if (linked == this.f294b) {
                return this;
            }
            return new Linked(this.f293a, linked, this.f295c, this.f296d, this.f297e);
        }

        public final Linked<T> m447a() {
            if (this.f297e) {
                return this.f294b == null ? null : this.f294b.m447a();
            } else {
                if (this.f294b == null) {
                    return this;
                }
                Linked a = this.f294b.m447a();
                if (a != this.f294b) {
                    return m444a(a);
                }
                return this;
            }
        }

        public final Linked<T> m449b() {
            Linked b = this.f294b == null ? null : this.f294b.m449b();
            return this.f296d ? m444a(b) : b;
        }

        public static Linked m446b(Linked linked, Linked linked2) {
            if (linked.f294b == null) {
                return linked.m444a(linked2);
            }
            return linked.m444a(m446b(linked.f294b, linked2));
        }

        public final Linked<T> m450c() {
            if (this.f294b == null) {
                return this;
            }
            Linked<T> c = this.f294b.m450c();
            if (this.f295c != null) {
                if (c.f295c == null) {
                    return m444a(null);
                }
                return m444a((Linked) c);
            } else if (c.f295c != null) {
                return c;
            } else {
                if (this.f296d == c.f296d) {
                    return m444a((Linked) c);
                }
                return this.f296d ? m444a(null) : c;
            }
        }

        public final String toString() {
            String str = this.f293a.toString() + "[visible=" + this.f296d + "]";
            if (this.f294b != null) {
                return str + ", " + this.f294b.toString();
            }
            return str;
        }
    }

    /* compiled from: video_data_width */
    class C00313 implements WithMember<Boolean> {
        final /* synthetic */ POJOPropertyBuilder f349a;

        C00313(POJOPropertyBuilder pOJOPropertyBuilder) {
            this.f349a = pOJOPropertyBuilder;
        }

        public final Object mo47a(AnnotatedMember annotatedMember) {
            return this.f349a.f286b.g(annotatedMember);
        }
    }

    /* compiled from: video_data_width */
    interface WithMember<T> {
        T mo47a(AnnotatedMember annotatedMember);
    }

    /* compiled from: video_data_width */
    class C00322 implements WithMember<ReferenceProperty> {
        final /* synthetic */ POJOPropertyBuilder f350a;

        C00322(POJOPropertyBuilder pOJOPropertyBuilder) {
            this.f350a = pOJOPropertyBuilder;
        }

        public final Object mo47a(AnnotatedMember annotatedMember) {
            return this.f350a.f286b.a(annotatedMember);
        }
    }

    /* compiled from: video_data_width */
    class C00334 implements WithMember<Boolean> {
        final /* synthetic */ POJOPropertyBuilder f357a;

        C00334(POJOPropertyBuilder pOJOPropertyBuilder) {
            this.f357a = pOJOPropertyBuilder;
        }

        public final Object mo47a(AnnotatedMember annotatedMember) {
            return this.f357a.f286b.e(annotatedMember);
        }
    }

    /* compiled from: video_data_width */
    class C00351 implements WithMember<Class<?>[]> {
        final /* synthetic */ POJOPropertyBuilder f360a;

        C00351(POJOPropertyBuilder pOJOPropertyBuilder) {
            this.f360a = pOJOPropertyBuilder;
        }

        public final Object mo47a(AnnotatedMember annotatedMember) {
            return this.f360a.f286b.d(annotatedMember);
        }
    }

    public int compareTo(Object obj) {
        POJOPropertyBuilder pOJOPropertyBuilder = (POJOPropertyBuilder) obj;
        if (this.f290f != null) {
            if (pOJOPropertyBuilder.f290f == null) {
                return -1;
            }
        } else if (pOJOPropertyBuilder.f290f != null) {
            return 1;
        }
        return mo22a().compareTo(pOJOPropertyBuilder.mo22a());
    }

    public POJOPropertyBuilder(String str, AnnotationIntrospector annotationIntrospector, boolean z) {
        this.f288d = str;
        this.f287c = str;
        this.f286b = annotationIntrospector;
        this.f285a = z;
    }

    private POJOPropertyBuilder(POJOPropertyBuilder pOJOPropertyBuilder, String str) {
        this.f288d = pOJOPropertyBuilder.f288d;
        this.f287c = str;
        this.f286b = pOJOPropertyBuilder.f286b;
        this.f289e = pOJOPropertyBuilder.f289e;
        this.f290f = pOJOPropertyBuilder.f290f;
        this.f291g = pOJOPropertyBuilder.f291g;
        this.f292h = pOJOPropertyBuilder.f292h;
        this.f285a = pOJOPropertyBuilder.f285a;
    }

    public final POJOPropertyBuilder m392a(String str) {
        return new POJOPropertyBuilder(this, str);
    }

    public final String mo22a() {
        return this.f287c;
    }

    public final String m418t() {
        return this.f288d;
    }

    public final PropertyName mo23b() {
        if (mo35o() == null || this.f286b == null) {
            return null;
        }
        return null;
    }

    public final boolean mo24c() {
        return m389d(this.f289e) || m389d(this.f291g) || m389d(this.f292h) || m389d(this.f290f);
    }

    public final boolean mo25e() {
        return this.f291g != null;
    }

    public final boolean mo26f() {
        return this.f292h != null;
    }

    public final boolean mo27g() {
        return this.f289e != null;
    }

    public final boolean mo28h() {
        return this.f290f != null;
    }

    public final AnnotatedMethod mo29i() {
        if (this.f291g == null) {
            return null;
        }
        AnnotatedMember annotatedMember = (AnnotatedMethod) this.f291g.f293a;
        Linked linked = this.f291g.f294b;
        AnnotatedMember annotatedMember2 = annotatedMember;
        while (linked != null) {
            annotatedMember = (AnnotatedMethod) linked.f293a;
            Class i = annotatedMember2.mo19i();
            Class i2 = annotatedMember.mo19i();
            if (i != i2) {
                if (!i.isAssignableFrom(i2)) {
                    if (i2.isAssignableFrom(i)) {
                        annotatedMember = annotatedMember2;
                    }
                }
                linked = linked.f294b;
                annotatedMember2 = annotatedMember;
            }
            throw new IllegalArgumentException("Conflicting getter definitions for property \"" + mo22a() + "\": " + annotatedMember2.m475m() + " vs " + annotatedMember.m475m());
        }
        return annotatedMember2;
    }

    public final AnnotatedMethod mo30j() {
        if (this.f292h == null) {
            return null;
        }
        AnnotatedMember annotatedMember = (AnnotatedMethod) this.f292h.f293a;
        Linked linked = this.f292h.f294b;
        AnnotatedMember annotatedMember2 = annotatedMember;
        while (linked != null) {
            annotatedMember = (AnnotatedMethod) linked.f293a;
            Class i = annotatedMember2.mo19i();
            Class i2 = annotatedMember.mo19i();
            if (i != i2) {
                if (!i.isAssignableFrom(i2)) {
                    if (i2.isAssignableFrom(i)) {
                        annotatedMember = annotatedMember2;
                    }
                }
                linked = linked.f294b;
                annotatedMember2 = annotatedMember;
            }
            throw new IllegalArgumentException("Conflicting setter definitions for property \"" + mo22a() + "\": " + annotatedMember2.m475m() + " vs " + annotatedMember.m475m());
        }
        return annotatedMember2;
    }

    public final AnnotatedField mo31k() {
        if (this.f289e == null) {
            return null;
        }
        AnnotatedMember annotatedMember = (AnnotatedField) this.f289e.f293a;
        Linked linked = this.f289e.f294b;
        AnnotatedMember annotatedMember2 = annotatedMember;
        while (linked != null) {
            annotatedMember = (AnnotatedField) linked.f293a;
            Class i = annotatedMember2.mo19i();
            Class i2 = annotatedMember.mo19i();
            if (i != i2) {
                if (!i.isAssignableFrom(i2)) {
                    if (i2.isAssignableFrom(i)) {
                        annotatedMember = annotatedMember2;
                    }
                }
                linked = linked.f294b;
                annotatedMember2 = annotatedMember;
            }
            throw new IllegalArgumentException("Multiple fields representing property \"" + mo22a() + "\": " + annotatedMember2.m363h() + " vs " + annotatedMember.m363h());
        }
        return annotatedMember2;
    }

    public final AnnotatedParameter mo32l() {
        if (this.f290f == null) {
            return null;
        }
        Linked linked = this.f290f;
        while (!(((AnnotatedParameter) linked.f293a)._owner instanceof AnnotatedConstructor)) {
            Linked linked2 = linked.f294b;
            if (linked2 == null) {
                return (AnnotatedParameter) this.f290f.f293a;
            }
            linked = linked2;
        }
        return (AnnotatedParameter) linked.f293a;
    }

    public final AnnotatedMember mo33m() {
        AnnotatedMember i = mo29i();
        if (i == null) {
            return mo31k();
        }
        return i;
    }

    public final AnnotatedMember mo34n() {
        AnnotatedMember l = mo32l();
        if (l != null) {
            return l;
        }
        l = mo30j();
        if (l == null) {
            return mo31k();
        }
        return l;
    }

    public final AnnotatedMember mo35o() {
        if (this.f285a) {
            return mo33m();
        }
        return mo34n();
    }

    public final Class<?>[] mo36p() {
        return (Class[]) m385a(new C00351(this));
    }

    public final ReferenceProperty mo37q() {
        return (ReferenceProperty) m385a(new C00322(this));
    }

    public final boolean mo38r() {
        Boolean bool = (Boolean) m385a(new C00313(this));
        return bool != null && bool.booleanValue();
    }

    public final boolean mo39s() {
        Boolean bool = (Boolean) m385a(new C00334(this));
        return bool != null && bool.booleanValue();
    }

    public final void m394a(AnnotatedField annotatedField, String str, boolean z, boolean z2) {
        this.f289e = new Linked(annotatedField, this.f289e, str, z, z2);
    }

    public final void m396a(AnnotatedParameter annotatedParameter, String str, boolean z, boolean z2) {
        this.f290f = new Linked(annotatedParameter, this.f290f, str, z, z2);
    }

    public final void m395a(AnnotatedMethod annotatedMethod, String str, boolean z, boolean z2) {
        this.f291g = new Linked(annotatedMethod, this.f291g, str, z, z2);
    }

    public final void m400b(AnnotatedMethod annotatedMethod, String str, boolean z, boolean z2) {
        this.f292h = new Linked(annotatedMethod, this.f292h, str, z, z2);
    }

    public final void m397a(POJOPropertyBuilder pOJOPropertyBuilder) {
        this.f289e = m384a(this.f289e, pOJOPropertyBuilder.f289e);
        this.f290f = m384a(this.f290f, pOJOPropertyBuilder.f290f);
        this.f291g = m384a(this.f291g, pOJOPropertyBuilder.f291g);
        this.f292h = m384a(this.f292h, pOJOPropertyBuilder.f292h);
    }

    private static <T> Linked<T> m384a(Linked<T> linked, Linked<T> linked2) {
        if (linked == null) {
            return linked2;
        }
        if (linked2 == null) {
            return linked;
        }
        return Linked.m446b(linked, linked2);
    }

    public final void m419u() {
        this.f289e = m383a(this.f289e);
        this.f291g = m383a(this.f291g);
        this.f292h = m383a(this.f292h);
        this.f290f = m383a(this.f290f);
    }

    public final void m398a(boolean z) {
        this.f291g = m386b(this.f291g);
        this.f290f = m386b(this.f290f);
        if (z || this.f291g == null) {
            this.f289e = m386b(this.f289e);
            this.f292h = m386b(this.f292h);
        }
    }

    public final void m420v() {
        this.f289e = m388c(this.f289e);
        this.f291g = m388c(this.f291g);
        this.f292h = m388c(this.f292h);
        this.f290f = m388c(this.f290f);
    }

    public final void m401b(boolean z) {
        if (z) {
            if (this.f291g != null) {
                this.f291g = this.f291g.m448a(((AnnotatedMethod) this.f291g.f293a).m457a(m382a(0, this.f291g, this.f289e, this.f290f, this.f292h)));
            } else if (this.f289e != null) {
                this.f289e = this.f289e.m448a(((AnnotatedField) this.f289e.f293a).m353a(m382a(0, this.f289e, this.f290f, this.f292h)));
            }
        } else if (this.f290f != null) {
            this.f290f = this.f290f.m448a(((AnnotatedParameter) this.f290f.f293a).m514a(m382a(0, this.f290f, this.f292h, this.f289e, this.f291g)));
        } else if (this.f292h != null) {
            this.f292h = this.f292h.m448a(((AnnotatedMethod) this.f292h.f293a).m457a(m382a(0, this.f292h, this.f289e, this.f291g)));
        } else if (this.f289e != null) {
            this.f289e = this.f289e.m448a(((AnnotatedField) this.f289e.f293a).m353a(m382a(0, this.f289e, this.f291g)));
        }
    }

    private AnnotationMap m382a(int i, Linked<? extends AnnotatedMember>... linkedArr) {
        AnnotationMap e = ((AnnotatedMember) linkedArr[i].f293a).m370e();
        for (int i2 = i + 1; i2 < linkedArr.length; i2++) {
            if (linkedArr[i2] != null) {
                return AnnotationMap.a(e, m382a(i2, (Linked[]) linkedArr));
            }
        }
        return e;
    }

    private static <T> Linked<T> m383a(Linked<T> linked) {
        return linked == null ? linked : linked.m447a();
    }

    private static <T> Linked<T> m386b(Linked<T> linked) {
        return linked == null ? linked : linked.m449b();
    }

    private static <T> Linked<T> m388c(Linked<T> linked) {
        return linked == null ? linked : linked.m450c();
    }

    private static <T> boolean m389d(Linked<T> linked) {
        while (linked != null) {
            if (linked.f295c != null && linked.f295c.length() > 0) {
                return true;
            }
            linked = linked.f294b;
        }
        return false;
    }

    public final boolean m421w() {
        return m390e(this.f289e) || m390e(this.f291g) || m390e(this.f292h) || m390e(this.f290f);
    }

    private static <T> boolean m390e(Linked<T> linked) {
        while (linked != null) {
            if (linked.f296d) {
                return true;
            }
            linked = linked.f294b;
        }
        return false;
    }

    public final boolean m422x() {
        return m391f(this.f289e) || m391f(this.f291g) || m391f(this.f292h) || m391f(this.f290f);
    }

    private static <T> boolean m391f(Linked<T> linked) {
        while (linked != null) {
            if (linked.f297e) {
                return true;
            }
            linked = linked.f294b;
        }
        return false;
    }

    public final String m423y() {
        Linked b = m387b(this.f290f, m387b(this.f292h, m387b(this.f291g, m387b(this.f289e, null))));
        if (b == null) {
            return null;
        }
        return b.f295c;
    }

    private Linked<? extends AnnotatedMember> m387b(Linked<? extends AnnotatedMember> linked, Linked<? extends AnnotatedMember> linked2) {
        Linked<? extends AnnotatedMember> linked3 = linked2;
        for (Linked<? extends AnnotatedMember> linked4 = linked; linked4 != null; linked4 = linked4.f294b) {
            String str = linked4.f295c;
            if (!(str == null || str.equals(this.f287c))) {
                if (linked3 == null) {
                    linked3 = linked4;
                } else if (!str.equals(linked3.f295c)) {
                    throw new IllegalStateException("Conflicting property name definitions: '" + linked3.f295c + "' (for " + linked3.f293a + ") vs '" + linked4.f295c + "' (for " + linked4.f293a + ")");
                }
            }
        }
        return linked3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[Property '").append(this.f287c).append("'; ctors: ").append(this.f290f).append(", field(s): ").append(this.f289e).append(", getter(s): ").append(this.f291g).append(", setter(s): ").append(this.f292h);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private <T> T m385a(WithMember<T> withMember) {
        T t = null;
        if (this.f286b == null) {
            return null;
        }
        if (!this.f285a) {
            if (this.f290f != null) {
                t = withMember.mo47a((AnnotatedMember) this.f290f.f293a);
            }
            if (t == null && this.f292h != null) {
                t = withMember.mo47a((AnnotatedMember) this.f292h.f293a);
            }
        } else if (this.f291g != null) {
            t = withMember.mo47a((AnnotatedMember) this.f291g.f293a);
        }
        if (t != null || this.f289e == null) {
            return t;
        }
        return withMember.mo47a((AnnotatedMember) this.f289e.f293a);
    }
}
