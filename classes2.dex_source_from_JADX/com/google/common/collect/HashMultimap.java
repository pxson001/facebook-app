package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: rxjava.plugin. */
public final class HashMultimap<K, V> extends AbstractSetMultimap<K, V> {
    @VisibleForTesting
    transient int f6338a = 2;

    public final /* bridge */ /* synthetic */ boolean mo408a(Multimap multimap) {
        return super.mo408a(multimap);
    }

    public final /* bridge */ /* synthetic */ boolean mo409a(@Nullable Object obj, Iterable iterable) {
        return super.mo409a(obj, iterable);
    }

    public final /* bridge */ /* synthetic */ boolean mo410b(@Nullable Object obj, @Nullable Object obj2) {
        return super.mo410b(obj, obj2);
    }

    final /* synthetic */ Collection mo411c() {
        return mo1473a();
    }

    public final /* bridge */ /* synthetic */ boolean mo412c(@Nullable Object obj, @Nullable Object obj2) {
        return super.mo412c(obj, obj2);
    }

    public final /* bridge */ /* synthetic */ int mo413f() {
        return super.mo413f();
    }

    public final /* bridge */ /* synthetic */ boolean mo414f(@Nullable Object obj) {
        return super.mo414f(obj);
    }

    public final /* bridge */ /* synthetic */ void mo415g() {
        super.mo415g();
    }

    public final /* bridge */ /* synthetic */ boolean mo416g(@Nullable Object obj) {
        return super.mo416g(obj);
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* bridge */ /* synthetic */ Collection mo418i() {
        return super.mo418i();
    }

    public final /* bridge */ /* synthetic */ boolean mo420n() {
        return super.mo420n();
    }

    public final /* bridge */ /* synthetic */ Set mo421p() {
        return super.mo421p();
    }

    public final /* bridge */ /* synthetic */ Multiset mo422q() {
        return super.mo422q();
    }

    public final /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <K, V> HashMultimap<K, V> m10690u() {
        return new HashMultimap();
    }

    private HashMultimap() {
        super(new HashMap());
    }

    final Set<V> mo1473a() {
        return Sets.m1314a(this.f6338a);
    }

    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Serialization.a(this, objectOutputStream);
    }

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f6338a = 2;
        int a = Serialization.a(objectInputStream);
        m3001a(Maps.m838c());
        Serialization.a(this, objectInputStream, a);
    }
}
