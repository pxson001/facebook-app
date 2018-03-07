package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: offline */
public final class HashMultiset<E> extends AbstractMapBasedMultiset<E> {
    public final /* bridge */ /* synthetic */ boolean mo2151a(@Nullable Object obj, int i, int i2) {
        return super.mo2151a(obj, i, i2);
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

    public final /* bridge */ /* synthetic */ Set mo2155d() {
        return super.mo2155d();
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

    public static <E> HashMultiset<E> m16740g() {
        return new HashMultiset();
    }

    private HashMultiset() {
        super(new HashMap());
    }

    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Serialization.a(this, objectOutputStream);
    }

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int a = Serialization.a(objectInputStream);
        this.f11459a = Maps.m838c();
        Serialization.a(this, objectInputStream, a);
    }
}
