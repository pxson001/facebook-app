package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.Multiset.Entry;
import com.google.j2objc.annotations.Weak;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: video_search */
public final class Multimaps {

    /* compiled from: video_search */
    public class CustomListMultimap<K, V> extends AbstractListMultimap<K, V> {
        transient Supplier<? extends List<V>> f2022a;

        protected final /* synthetic */ Collection m2101c() {
            return m2100a();
        }

        public CustomListMultimap(Map<K, Collection<V>> map, Supplier<? extends List<V>> supplier) {
            super(map);
            this.f2022a = (Supplier) Preconditions.checkNotNull(supplier);
        }

        protected final List<V> m2100a() {
            return (List) this.f2022a.get();
        }

        @GwtIncompatible("java.io.ObjectOutputStream")
        private void writeObject(ObjectOutputStream objectOutputStream) {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.f2022a);
            objectOutputStream.writeObject(this.a);
        }

        @GwtIncompatible("java.io.ObjectInputStream")
        private void readObject(ObjectInputStream objectInputStream) {
            objectInputStream.defaultReadObject();
            this.f2022a = (Supplier) objectInputStream.readObject();
            a((Map) objectInputStream.readObject());
        }
    }

    /* compiled from: video_search */
    public class CustomSetMultimap<K, V> extends AbstractSetMultimap<K, V> {
        transient Supplier<? extends Set<V>> f9014a;

        protected final /* synthetic */ Collection m9366c() {
            return m9365a();
        }

        public CustomSetMultimap(Map<K, Collection<V>> map, Supplier<? extends Set<V>> supplier) {
            super(map);
            this.f9014a = (Supplier) Preconditions.checkNotNull(supplier);
        }

        protected final Set<V> m9365a() {
            return (Set) this.f9014a.get();
        }

        @GwtIncompatible("java.io.ObjectOutputStream")
        private void writeObject(ObjectOutputStream objectOutputStream) {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.f9014a);
            objectOutputStream.writeObject(this.a);
        }

        @GwtIncompatible("java.io.ObjectInputStream")
        private void readObject(ObjectInputStream objectInputStream) {
            objectInputStream.defaultReadObject();
            this.f9014a = (Supplier) objectInputStream.readObject();
            a((Map) objectInputStream.readObject());
        }
    }

    /* compiled from: video_search */
    class Keys<K, V> extends AbstractMultiset<K> {
        @Weak
        final Multimap<K, V> f11490a;

        Keys(Multimap<K, V> multimap) {
            this.f11490a = multimap;
        }

        final Iterator<Entry<K>> m11971b() {
            return new 1(this, this.f11490a.b().entrySet().iterator());
        }

        final int m11972c() {
            return this.f11490a.b().size();
        }

        final Set<Entry<K>> m11974f() {
            return new KeysEntrySet(this);
        }

        public boolean contains(@Nullable Object obj) {
            return this.f11490a.f(obj);
        }

        public Iterator<K> iterator() {
            return Maps.a(this.f11490a.k().iterator());
        }

        public final int m11969a(@Nullable Object obj) {
            Collection collection = (Collection) Maps.a(this.f11490a.b(), obj);
            return collection == null ? 0 : collection.size();
        }

        public final int m11970b(@Nullable Object obj, int i) {
            int i2 = 0;
            CollectPreconditions.a(i, "occurrences");
            if (i == 0) {
                return m11969a(obj);
            }
            Collection collection = (Collection) Maps.a(this.f11490a.b(), obj);
            if (collection == null) {
                return 0;
            }
            int size = collection.size();
            if (i >= size) {
                collection.clear();
            } else {
                Iterator it = collection.iterator();
                while (i2 < i) {
                    it.next();
                    it.remove();
                    i2++;
                }
            }
            return size;
        }

        public void clear() {
            this.f11490a.g();
        }

        public final Set<K> m11973d() {
            return this.f11490a.p();
        }
    }

    /* compiled from: video_search */
    abstract class Entries<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        abstract Multimap<K, V> mo850a();

        Entries() {
        }

        public int size() {
            return mo850a().f();
        }

        public boolean contains(@Nullable Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return mo850a().b(entry.getKey(), entry.getValue());
        }

        public boolean remove(@Nullable Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return mo850a().c(entry.getKey(), entry.getValue());
        }

        public void clear() {
            mo850a().g();
        }
    }

    private Multimaps() {
    }

    static boolean m274a(Multimap<?, ?> multimap, @Nullable Object obj) {
        if (obj == multimap) {
            return true;
        }
        if (!(obj instanceof Multimap)) {
            return false;
        }
        return multimap.b().equals(((Multimap) obj).b());
    }
}
