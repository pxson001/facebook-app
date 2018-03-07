package com.google.common.collect;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.Nullable;

/* compiled from: bug_report_retry_upload_success */
class Synchronized$SynchronizedList<E> extends Synchronized$SynchronizedCollection<E> implements List<E> {
    final /* synthetic */ Collection mo990b() {
        return m13681a();
    }

    final /* synthetic */ Object mo991c() {
        return m13681a();
    }

    Synchronized$SynchronizedList(List<E> list, @Nullable Object obj) {
        super(list, obj);
    }

    private List<E> m13681a() {
        return (List) super.mo990b();
    }

    public void add(int i, E e) {
        synchronized (this.mutex) {
            m13681a().add(i, e);
        }
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        boolean addAll;
        synchronized (this.mutex) {
            addAll = m13681a().addAll(i, collection);
        }
        return addAll;
    }

    public E get(int i) {
        E e;
        synchronized (this.mutex) {
            e = m13681a().get(i);
        }
        return e;
    }

    public int indexOf(Object obj) {
        int indexOf;
        synchronized (this.mutex) {
            indexOf = m13681a().indexOf(obj);
        }
        return indexOf;
    }

    public int lastIndexOf(Object obj) {
        int lastIndexOf;
        synchronized (this.mutex) {
            lastIndexOf = m13681a().lastIndexOf(obj);
        }
        return lastIndexOf;
    }

    public ListIterator<E> listIterator() {
        return m13681a().listIterator();
    }

    public ListIterator<E> listIterator(int i) {
        return m13681a().listIterator(i);
    }

    public E remove(int i) {
        E remove;
        synchronized (this.mutex) {
            remove = m13681a().remove(i);
        }
        return remove;
    }

    public E set(int i, E e) {
        E e2;
        synchronized (this.mutex) {
            e2 = m13681a().set(i, e);
        }
        return e2;
    }

    public List<E> subList(int i, int i2) {
        List<E> b;
        synchronized (this.mutex) {
            b = Synchronized.b(m13681a().subList(i, i2), this.mutex);
        }
        return b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        boolean equals;
        synchronized (this.mutex) {
            equals = m13681a().equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.mutex) {
            hashCode = m13681a().hashCode();
        }
        return hashCode;
    }
}
