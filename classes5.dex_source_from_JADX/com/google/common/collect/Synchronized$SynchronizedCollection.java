package com.google.common.collect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Synchronized.SynchronizedObject;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

@VisibleForTesting
/* compiled from: bug_report_retry_upload_success */
class Synchronized$SynchronizedCollection<E> extends SynchronizedObject implements Collection<E> {
    private static final long serialVersionUID = 0;

    /* synthetic */ Object mo991c() {
        return mo990b();
    }

    public Synchronized$SynchronizedCollection(Collection<E> collection, @Nullable Object obj) {
        super(collection, obj);
    }

    Collection<E> mo990b() {
        return (Collection) super.c();
    }

    public boolean add(E e) {
        boolean add;
        synchronized (this.mutex) {
            add = mo990b().add(e);
        }
        return add;
    }

    public boolean addAll(Collection<? extends E> collection) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = mo990b().addAll(collection);
        }
        return addAll;
    }

    public void clear() {
        synchronized (this.mutex) {
            mo990b().clear();
        }
    }

    public boolean contains(Object obj) {
        boolean contains;
        synchronized (this.mutex) {
            contains = mo990b().contains(obj);
        }
        return contains;
    }

    public boolean containsAll(Collection<?> collection) {
        boolean containsAll;
        synchronized (this.mutex) {
            containsAll = mo990b().containsAll(collection);
        }
        return containsAll;
    }

    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.mutex) {
            isEmpty = mo990b().isEmpty();
        }
        return isEmpty;
    }

    public Iterator<E> iterator() {
        return mo990b().iterator();
    }

    public boolean remove(Object obj) {
        boolean remove;
        synchronized (this.mutex) {
            remove = mo990b().remove(obj);
        }
        return remove;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean removeAll;
        synchronized (this.mutex) {
            removeAll = mo990b().removeAll(collection);
        }
        return removeAll;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean retainAll;
        synchronized (this.mutex) {
            retainAll = mo990b().retainAll(collection);
        }
        return retainAll;
    }

    public int size() {
        int size;
        synchronized (this.mutex) {
            size = mo990b().size();
        }
        return size;
    }

    public Object[] toArray() {
        Object[] toArray;
        synchronized (this.mutex) {
            toArray = mo990b().toArray();
        }
        return toArray;
    }

    public <T> T[] toArray(T[] tArr) {
        T[] toArray;
        synchronized (this.mutex) {
            toArray = mo990b().toArray(tArr);
        }
        return toArray;
    }
}
