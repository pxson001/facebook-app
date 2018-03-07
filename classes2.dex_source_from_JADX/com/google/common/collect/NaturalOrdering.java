package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;

@GwtCompatible
/* compiled from: glBindTexture */
public final class NaturalOrdering extends Ordering<Comparable> implements Serializable {
    public static final NaturalOrdering f22266a = new NaturalOrdering();

    public final int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        Preconditions.checkNotNull(comparable);
        Preconditions.checkNotNull(comparable2);
        return comparable.compareTo(comparable2);
    }

    public final <S extends Comparable> Ordering<S> mo3241a() {
        return ReverseNaturalOrdering.f22267a;
    }

    private Object readResolve() {
        return f22266a;
    }

    public final String toString() {
        return "Ordering.natural()";
    }

    private NaturalOrdering() {
    }
}
