package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;

@GwtCompatible
/* compiled from: gk_video_player_service */
final class ReverseNaturalOrdering extends Ordering<Comparable> implements Serializable {
    static final ReverseNaturalOrdering f22267a = new ReverseNaturalOrdering();

    public final Object mo3244a(Object obj, Object obj2) {
        return (Comparable) NaturalOrdering.f22266a.mo3247b((Comparable) obj, (Comparable) obj2);
    }

    public final Object mo3247b(Object obj, Object obj2) {
        return (Comparable) NaturalOrdering.f22266a.mo3244a((Comparable) obj, (Comparable) obj2);
    }

    public final int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        Preconditions.checkNotNull(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    public final Object mo3245a(Iterator it) {
        return (Comparable) NaturalOrdering.f22266a.mo3248b(it);
    }

    public final Object mo3243a(Iterable iterable) {
        return (Comparable) NaturalOrdering.f22266a.mo3246b(iterable);
    }

    public final Object mo3248b(Iterator it) {
        return (Comparable) NaturalOrdering.f22266a.mo3245a(it);
    }

    public final Object mo3246b(Iterable iterable) {
        return (Comparable) NaturalOrdering.f22266a.mo3243a(iterable);
    }

    private Object readResolve() {
        return f22267a;
    }

    public final String toString() {
        return "Ordering.natural().reverse()";
    }

    private ReverseNaturalOrdering() {
    }

    public final <S extends Comparable> Ordering<S> mo3241a() {
        return NaturalOrdering.f22266a;
    }
}
