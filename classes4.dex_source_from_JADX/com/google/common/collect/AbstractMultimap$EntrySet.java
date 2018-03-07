package com.google.common.collect;

import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: font_scale */
class AbstractMultimap$EntrySet extends AbstractMultimap$Entries implements Set<Entry<K, V>> {
    final /* synthetic */ AbstractMultimap f11491b;

    public AbstractMultimap$EntrySet(AbstractMultimap abstractMultimap) {
        this.f11491b = abstractMultimap;
        super(abstractMultimap);
    }

    public int hashCode() {
        return Sets.a(this);
    }

    public boolean equals(@Nullable Object obj) {
        return Sets.a(this, obj);
    }
}
