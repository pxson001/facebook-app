package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Collections2.1;
import java.util.Collection;
import java.util.Iterator;

@GwtCompatible
/* compiled from: locales/ */
public abstract class ForwardingCollection<E> extends ForwardingObject implements Collection<E> {
    protected abstract Collection<E> mo731b();

    protected /* synthetic */ Object mo733e() {
        return mo731b();
    }

    protected ForwardingCollection() {
    }

    public Iterator<E> iterator() {
        return mo731b().iterator();
    }

    public int size() {
        return mo731b().size();
    }

    public boolean removeAll(Collection<?> collection) {
        return mo731b().removeAll(collection);
    }

    public boolean isEmpty() {
        return mo731b().isEmpty();
    }

    public boolean contains(Object obj) {
        return mo731b().contains(obj);
    }

    public boolean add(E e) {
        return mo731b().add(e);
    }

    public boolean remove(Object obj) {
        return mo731b().remove(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return mo731b().containsAll(collection);
    }

    public boolean addAll(Collection<? extends E> collection) {
        return mo731b().addAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return mo731b().retainAll(collection);
    }

    public void clear() {
        mo731b().clear();
    }

    public Object[] toArray() {
        return mo731b().toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return mo731b().toArray(tArr);
    }

    protected boolean m9503b(Collection<? extends E> collection) {
        return Iterators.a(this, collection.iterator());
    }

    protected boolean mo809c(Collection<?> collection) {
        return Iterators.a(iterator(), collection);
    }

    protected boolean m9505d(Collection<?> collection) {
        return Iterators.b(iterator(), collection);
    }

    protected final Object[] m9508o() {
        return toArray(new Object[size()]);
    }

    protected final <T> T[] m9501a(T[] tArr) {
        return ObjectArrays.a(this, tArr);
    }

    protected String m9507m() {
        StringBuilder append = Collections2.a(size()).append('[');
        Collections2.a.appendTo(append, Iterables.a(this, new 1(this)));
        return append.append(']').toString();
    }
}
