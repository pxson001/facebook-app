package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;

@GwtCompatible
/* compiled from: titlebar_with_modal_done */
interface SortedIterable<T> extends Iterable<T> {
    Comparator<? super T> comparator();
}
