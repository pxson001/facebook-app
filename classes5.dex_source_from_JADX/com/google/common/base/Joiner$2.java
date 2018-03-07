package com.google.common.base;

import com.google.common.base.Joiner.MapJoiner;
import java.util.Iterator;

/* compiled from: canHandleWarning */
class Joiner$2 extends Joiner {
    final /* synthetic */ Joiner this$0;

    Joiner$2(Joiner joiner, Joiner joiner2) {
        this.this$0 = joiner;
        super(joiner2);
    }

    public <A extends Appendable> A appendTo(A a, Iterator<?> it) {
        Preconditions.checkNotNull(a, "appendable");
        Preconditions.checkNotNull(it, "parts");
        while (it.hasNext()) {
            Object next = it.next();
            if (next != null) {
                a.append(this.this$0.toString(next));
                break;
            }
        }
        while (it.hasNext()) {
            next = it.next();
            if (next != null) {
                a.append(this.this$0.separator);
                a.append(this.this$0.toString(next));
            }
        }
        return a;
    }

    public Joiner useForNull(String str) {
        throw new UnsupportedOperationException("already specified skipNulls");
    }

    public MapJoiner withKeyValueSeparator(String str) {
        throw new UnsupportedOperationException("can't use .skipNulls() with maps");
    }
}
