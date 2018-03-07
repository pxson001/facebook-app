package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: always_show */
public class LazyStringArrayList extends AbstractList<String> implements LazyStringList, RandomAccess {
    public static final LazyStringList f20956a = new UnmodifiableLazyStringList(new LazyStringArrayList());
    private final List<Object> f20957b;

    public void add(int i, Object obj) {
        this.f20957b.add(i, (String) obj);
        this.modCount = this.modCount + 1;
    }

    public Object set(int i, Object obj) {
        return m21382a(this.f20957b.set(i, (String) obj));
    }

    public LazyStringArrayList() {
        this.f20957b = new ArrayList();
    }

    public LazyStringArrayList(LazyStringList lazyStringList) {
        this.f20957b = new ArrayList(lazyStringList.size());
        addAll(lazyStringList);
    }

    public Object get(int i) {
        Object obj = this.f20957b.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String e = byteString.m20186e();
        if (byteString.mo916f()) {
            this.f20957b.set(i, e);
        }
        return e;
    }

    public int size() {
        return this.f20957b.size();
    }

    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public boolean addAll(int i, Collection<? extends String> collection) {
        if (collection instanceof LazyStringList) {
            collection = ((LazyStringList) collection).mo906a();
        }
        boolean addAll = this.f20957b.addAll(i, collection);
        this.modCount = this.modCount + 1;
        return addAll;
    }

    public Object remove(int i) {
        Object remove = this.f20957b.remove(i);
        this.modCount = this.modCount + 1;
        return m21382a(remove);
    }

    public void clear() {
        this.f20957b.clear();
        this.modCount = this.modCount + 1;
    }

    public final void mo907a(ByteString byteString) {
        this.f20957b.add(byteString);
        this.modCount = this.modCount + 1;
    }

    public final ByteString mo905a(int i) {
        Object obj = this.f20957b.get(i);
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString a = ByteString.m20173a((String) obj);
        this.f20957b.set(i, a);
        return a;
    }

    private static String m21382a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        return ((ByteString) obj).m20186e();
    }

    public final List<?> mo906a() {
        return Collections.unmodifiableList(this.f20957b);
    }
}
