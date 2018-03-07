package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: busy */
public final class LinkedHashMultiset<E> extends AbstractMapBasedMultiset<E> {
    public final /* bridge */ /* synthetic */ boolean m13473a(@Nullable Object obj, int i, int i2) {
        return super.a(obj, i, i2);
    }

    public final /* bridge */ /* synthetic */ boolean add(@Nullable Object obj) {
        return super.add(obj);
    }

    public final /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
        return super.addAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean contains(@Nullable Object obj) {
        return super.contains(obj);
    }

    public final /* bridge */ /* synthetic */ Set m13474d() {
        return super.d();
    }

    public final /* bridge */ /* synthetic */ boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public final /* bridge */ /* synthetic */ boolean remove(@Nullable Object obj) {
        return super.remove(obj);
    }

    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public final /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <E> LinkedHashMultiset<E> m13472g() {
        return new LinkedHashMultiset();
    }

    public static <E> LinkedHashMultiset<E> m13471a(int i) {
        return new LinkedHashMultiset(i);
    }

    private LinkedHashMultiset() {
        super(new LinkedHashMap());
    }

    private LinkedHashMultiset(int i) {
        super(Maps.c(i));
    }

    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Serialization.m13652a((Multiset) this, objectOutputStream);
    }

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int a = Serialization.m13646a(objectInputStream);
        this.a = new LinkedHashMap();
        Serialization.m13651a((Multiset) this, objectInputStream, a);
    }
}
