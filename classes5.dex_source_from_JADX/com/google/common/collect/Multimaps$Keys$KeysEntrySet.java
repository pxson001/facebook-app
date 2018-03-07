package com.google.common.collect;

import com.google.common.collect.Multimaps.Keys;
import com.google.common.collect.Multiset.Entry;
import com.google.common.collect.Multisets.EntrySet;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: build_num */
class Multimaps$Keys$KeysEntrySet extends EntrySet<K> {
    final /* synthetic */ Keys f7519a;

    Multimaps$Keys$KeysEntrySet(Keys keys) {
        this.f7519a = keys;
    }

    final Multiset<K> m13591a() {
        return this.f7519a;
    }

    public Iterator<Entry<K>> iterator() {
        return this.f7519a.b();
    }

    public int size() {
        return this.f7519a.c();
    }

    public boolean isEmpty() {
        return this.f7519a.a.n();
    }

    public boolean contains(@Nullable Object obj) {
        if (!(obj instanceof Multisets$AbstractEntry)) {
            return false;
        }
        Multisets$AbstractEntry multisets$AbstractEntry = (Multisets$AbstractEntry) obj;
        Collection collection = (Collection) this.f7519a.a.b().get(multisets$AbstractEntry.mo889a());
        if (collection == null || collection.size() != multisets$AbstractEntry.mo890b()) {
            return false;
        }
        return true;
    }

    public boolean remove(@Nullable Object obj) {
        if (obj instanceof Multisets$AbstractEntry) {
            Multisets$AbstractEntry multisets$AbstractEntry = (Multisets$AbstractEntry) obj;
            Collection collection = (Collection) this.f7519a.a.b().get(multisets$AbstractEntry.mo889a());
            if (collection != null && collection.size() == multisets$AbstractEntry.mo890b()) {
                collection.clear();
                return true;
            }
        }
        return false;
    }
}
