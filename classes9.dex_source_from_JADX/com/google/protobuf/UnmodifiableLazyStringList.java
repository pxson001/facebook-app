package com.google.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: all_promos */
public class UnmodifiableLazyStringList extends AbstractList<String> implements LazyStringList, RandomAccess {
    public final LazyStringList f21039a;

    /* compiled from: all_promos */
    class C24492 implements Iterator<String> {
        Iterator<String> f21037a = this.f21038b.f21039a.iterator();
        final /* synthetic */ UnmodifiableLazyStringList f21038b;

        C24492(UnmodifiableLazyStringList unmodifiableLazyStringList) {
            this.f21038b = unmodifiableLazyStringList;
        }

        public boolean hasNext() {
            return this.f21037a.hasNext();
        }

        public Object next() {
            return (String) this.f21037a.next();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public UnmodifiableLazyStringList(LazyStringList lazyStringList) {
        this.f21039a = lazyStringList;
    }

    public Object get(int i) {
        return (String) this.f21039a.get(i);
    }

    public int size() {
        return this.f21039a.size();
    }

    public final ByteString mo905a(int i) {
        return this.f21039a.mo905a(i);
    }

    public final void mo907a(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    public ListIterator<String> listIterator(final int i) {
        return new ListIterator<String>(this) {
            ListIterator<String> f21034a = this.f21036c.f21039a.listIterator(i);
            final /* synthetic */ UnmodifiableLazyStringList f21036c;

            public boolean hasNext() {
                return this.f21034a.hasNext();
            }

            public Object next() {
                return (String) this.f21034a.next();
            }

            public boolean hasPrevious() {
                return this.f21034a.hasPrevious();
            }

            public Object previous() {
                return (String) this.f21034a.previous();
            }

            public int nextIndex() {
                return this.f21034a.nextIndex();
            }

            public int previousIndex() {
                return this.f21034a.previousIndex();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public void set(Object obj) {
                throw new UnsupportedOperationException();
            }

            public void add(Object obj) {
                throw new UnsupportedOperationException();
            }
        };
    }

    public Iterator<String> iterator() {
        return new C24492(this);
    }

    public final List<?> mo906a() {
        return this.f21039a.mo906a();
    }
}
