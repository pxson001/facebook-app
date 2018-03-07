package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: call_comment_id */
public final class EnumMultiset<E extends Enum<E>> extends AbstractMapBasedMultiset<E> {
    private transient Class<E> f7302a;

    public final /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
        return super.addAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean contains(@Nullable Object obj) {
        return super.contains(obj);
    }

    public final /* bridge */ /* synthetic */ Set m13338d() {
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

    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f7302a);
        Serialization.m13652a((Multiset) this, objectOutputStream);
    }

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f7302a = (Class) objectInputStream.readObject();
        this.a = WellBehavedMap.m13783a(new EnumMap(this.f7302a));
        Serialization.m13650a((Multiset) this, objectInputStream);
    }
}
