package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultiset.1;
import java.util.Map.Entry;

/* compiled from: cameraBearing */
class AbstractMapBasedMultiset$1$1 extends Multisets$AbstractEntry<E> {
    final /* synthetic */ Entry f7275a;
    final /* synthetic */ 1 f7276b;

    AbstractMapBasedMultiset$1$1(1 1, Entry entry) {
        this.f7276b = 1;
        this.f7275a = entry;
    }

    public final E mo889a() {
        return this.f7275a.getKey();
    }

    public final int mo890b() {
        Count count = (Count) this.f7275a.getValue();
        if (count == null || count.value == 0) {
            Count count2 = (Count) this.f7276b.c.a.get(mo889a());
            if (count2 != null) {
                return count2.value;
            }
        }
        return count == null ? 0 : count.value;
    }
}
