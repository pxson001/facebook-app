package com.google.android.gms.internal;

import android.support.v4.util.ArrayMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

public class zzng<E> extends AbstractSet<E> {
    public final ArrayMap<E, E> f6912a;

    public zzng() {
        this.f6912a = new ArrayMap();
    }

    public zzng(int i) {
        this.f6912a = new ArrayMap(i);
    }

    public boolean add(E e) {
        if (this.f6912a.containsKey(e)) {
            return false;
        }
        this.f6912a.put(e, e);
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        if (!(collection instanceof zzng)) {
            return super.addAll(collection);
        }
        zzng com_google_android_gms_internal_zzng = (zzng) collection;
        int size = size();
        this.f6912a.a(com_google_android_gms_internal_zzng.f6912a);
        return size() > size;
    }

    public void clear() {
        this.f6912a.clear();
    }

    public boolean contains(Object obj) {
        return this.f6912a.containsKey(obj);
    }

    public Iterator<E> iterator() {
        return this.f6912a.keySet().iterator();
    }

    public boolean remove(Object obj) {
        if (!this.f6912a.containsKey(obj)) {
            return false;
        }
        this.f6912a.remove(obj);
        return true;
    }

    public int size() {
        return this.f6912a.size();
    }
}
