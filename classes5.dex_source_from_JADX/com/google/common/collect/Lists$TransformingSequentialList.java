package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: bump_story_deduplication_key */
class Lists$TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
    final List<F> fromList;
    final Function<? super F, ? extends T> function;

    Lists$TransformingSequentialList(List<F> list, Function<? super F, ? extends T> function) {
        this.fromList = (List) Preconditions.checkNotNull(list);
        this.function = (Function) Preconditions.checkNotNull(function);
    }

    public void clear() {
        this.fromList.clear();
    }

    public int size() {
        return this.fromList.size();
    }

    public ListIterator<T> listIterator(int i) {
        return new TransformedListIterator<F, T>(this, this.fromList.listIterator(i)) {
            final /* synthetic */ Lists$TransformingSequentialList f7424a;

            final T m13504a(F f) {
                return this.f7424a.function.apply(f);
            }
        };
    }
}
