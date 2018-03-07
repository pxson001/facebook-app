package com.google.common.collect;

import com.google.common.collect.Multiset.Entry;
import com.google.common.collect.Sets.ImprovedAbstractSet;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: cameraTargetLat */
abstract class Multisets$ElementSet<E> extends ImprovedAbstractSet<E> {
    abstract Multiset<E> mo891a();

    Multisets$ElementSet() {
    }

    public void clear() {
        mo891a().clear();
    }

    public boolean contains(Object obj) {
        return mo891a().contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return mo891a().containsAll(collection);
    }

    public boolean isEmpty() {
        return mo891a().isEmpty();
    }

    public Iterator<E> iterator() {
        return new TransformedIterator<Entry<E>, E>(this, mo891a().a().iterator()) {
            final /* synthetic */ Multisets$ElementSet f7520a;

            final Object m13592a(Object obj) {
                return ((Multisets$AbstractEntry) obj).mo889a();
            }
        };
    }

    public boolean remove(Object obj) {
        return mo891a().b(obj, Integer.MAX_VALUE) > 0;
    }

    public int size() {
        return mo891a().a().size();
    }
}
