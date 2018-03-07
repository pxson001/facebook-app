package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMultimap.FieldSettersHolder;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: log_id */
public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements SetMultimap<K, V> {
    @GwtIncompatible("not needed in emulated source.")
    private static final long serialVersionUID = 0;
    private final transient ImmutableSet<V> f9006a;
    private transient ImmutableSet<Entry<K, V>> f9007d;

    /* compiled from: log_id */
    public final class Builder<K, V> extends ImmutableMultimap$Builder<K, V> {
        public final /* synthetic */ ImmutableMultimap$Builder mo696b(Object obj, Iterable iterable) {
            return m9348a(obj, iterable);
        }

        public final /* synthetic */ ImmutableMultimap mo698b() {
            return m9349a();
        }

        public Builder() {
            super(MultimapBuilder.m9358a().m9362c().mo700b());
        }

        public final ImmutableMultimap$Builder mo697b(Object obj, Object obj2) {
            this.f9008a.a(Preconditions.checkNotNull(obj), Preconditions.checkNotNull(obj2));
            return this;
        }

        public final Builder<K, V> m9348a(K k, Iterable<? extends V> iterable) {
            Collection c = this.f9008a.c(Preconditions.checkNotNull(k));
            for (Object checkNotNull : iterable) {
                c.add(Preconditions.checkNotNull(checkNotNull));
            }
            return this;
        }

        public final ImmutableMultimap$Builder mo695b(Multimap multimap) {
            for (Entry entry : multimap.b().entrySet()) {
                m9348a(entry.getKey(), (Iterable) entry.getValue());
            }
            return this;
        }

        public final ImmutableSetMultimap<K, V> m9349a() {
            if (this.f9009b != null) {
                SetMultimap b = MultimapBuilder.m9358a().m9362c().mo700b();
                for (Entry entry : Ordering.a(this.f9009b).e().d(this.f9008a.b().entrySet())) {
                    b.a(entry.getKey(), (Iterable) entry.getValue());
                }
                this.a = b;
            }
            return ImmutableSetMultimap.m9336b(this.f9008a, this.f9010c);
        }
    }

    public final /* synthetic */ Set m9339a(@Nullable Object obj) {
        return m9343e(obj);
    }

    @Deprecated
    public final /* synthetic */ Set m9340b(Object obj) {
        return m9338z();
    }

    public final /* synthetic */ Collection m9341c(@Nullable Object obj) {
        return m9343e(obj);
    }

    @Deprecated
    public final /* synthetic */ Collection m9342d(Object obj) {
        return m9338z();
    }

    public final /* synthetic */ ImmutableCollection m9344h(@Nullable Object obj) {
        return m9343e(obj);
    }

    @Deprecated
    public final /* synthetic */ ImmutableCollection m9345i(Object obj) {
        return m9338z();
    }

    public final /* synthetic */ Collection m9346k() {
        return m9329A();
    }

    public final /* synthetic */ ImmutableCollection m9347u() {
        return m9329A();
    }

    public static <K, V> ImmutableSetMultimap<K, V> m9333a() {
        return EmptyImmutableSetMultimap.a;
    }

    public static <K, V> Builder<K, V> m9337y() {
        return new Builder();
    }

    public static <K, V> ImmutableSetMultimap<K, V> m9336b(Multimap<? extends K, ? extends V> multimap, Comparator<? super V> comparator) {
        Preconditions.checkNotNull(multimap);
        if (multimap.n() && comparator == null) {
            return EmptyImmutableSetMultimap.a;
        }
        if (multimap instanceof ImmutableSetMultimap) {
            ImmutableSetMultimap<K, V> immutableSetMultimap = (ImmutableSetMultimap) multimap;
            if (!immutableSetMultimap.d()) {
                return immutableSetMultimap;
            }
        }
        com.google.common.collect.ImmutableMap.Builder builder = new com.google.common.collect.ImmutableMap.Builder(multimap.b().size());
        int i = 0;
        for (Entry entry : multimap.b().entrySet()) {
            int i2;
            Object key = entry.getKey();
            ImmutableSet a = m9332a((Comparator) comparator, (Collection) entry.getValue());
            if (a.isEmpty()) {
                i2 = i;
            } else {
                builder.b(key, a);
                i2 = a.size() + i;
            }
            i = i2;
        }
        return new ImmutableSetMultimap(builder.b(), i, comparator);
    }

    ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> immutableMap, int i, @Nullable Comparator<? super V> comparator) {
        super(immutableMap, i);
        this.f9006a = m9331a((Comparator) comparator);
    }

    public final ImmutableSet<V> m9343e(@Nullable K k) {
        return (ImmutableSet) MoreObjects.firstNonNull((ImmutableSet) this.b.get(k), this.f9006a);
    }

    @Deprecated
    private static ImmutableSet<V> m9338z() {
        throw new UnsupportedOperationException();
    }

    private ImmutableSet<Entry<K, V>> m9329A() {
        ImmutableSet<Entry<K, V>> immutableSet = this.f9007d;
        if (immutableSet != null) {
            return immutableSet;
        }
        EntrySet entrySet = new EntrySet(this);
        this.f9007d = entrySet;
        return entrySet;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <V> com.google.common.collect.ImmutableSet<V> m9332a(@javax.annotation.Nullable java.util.Comparator<? super V> r3, java.util.Collection<? extends V> r4) {
        /*
        if (r3 != 0) goto L_0x0007;
    L_0x0002:
        r0 = com.google.common.collect.ImmutableSet.copyOf(r4);
    L_0x0006:
        return r0;
    L_0x0007:
        com.google.common.base.Preconditions.checkNotNull(r3);
        r1 = com.google.common.collect.SortedIterables.a(r3, r4);
        if (r1 == 0) goto L_0x001f;
    L_0x0010:
        r1 = r4 instanceof com.google.common.collect.ImmutableSortedSet;
        if (r1 == 0) goto L_0x001f;
    L_0x0014:
        r1 = r4;
        r1 = (com.google.common.collect.ImmutableSortedSet) r1;
        r2 = r1.isPartialView();
        if (r2 != 0) goto L_0x001f;
    L_0x001d:
        r0 = r1;
        goto L_0x0006;
    L_0x001f:
        r1 = com.google.common.collect.Iterables.e(r4);
        r1 = (java.lang.Object[]) r1;
        r2 = r1.length;
        r1 = com.google.common.collect.ImmutableSortedSet.a(r3, r2, r1);
        goto L_0x001d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ImmutableSetMultimap.a(java.util.Comparator, java.util.Collection):com.google.common.collect.ImmutableSet<V>");
    }

    private static <V> ImmutableSet<V> m9331a(@Nullable Comparator<? super V> comparator) {
        if (comparator == null) {
            return RegularImmutableSet.a;
        }
        return ImmutableSortedSet.a(comparator);
    }

    private static <V> com.google.common.collect.ImmutableSet.Builder<V> m9335b(@Nullable Comparator<? super V> comparator) {
        return comparator == null ? new com.google.common.collect.ImmutableSet.Builder() : new com.google.common.collect.ImmutableSortedSet.Builder(comparator);
    }

    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(m9330B());
        Serialization.a(this, objectOutputStream);
    }

    @Nullable
    private Comparator<? super V> m9330B() {
        return this.f9006a instanceof ImmutableSortedSet ? ((ImmutableSortedSet) this.f9006a).comparator() : null;
    }

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        int readInt = objectInputStream.readInt();
        if (readInt < 0) {
            throw new InvalidObjectException("Invalid key count " + readInt);
        }
        com.google.common.collect.ImmutableMap.Builder builder = ImmutableMap.builder();
        int i = 0;
        for (int i2 = 0; i2 < readInt; i2++) {
            Object readObject = objectInputStream.readObject();
            int readInt2 = objectInputStream.readInt();
            if (readInt2 <= 0) {
                throw new InvalidObjectException("Invalid value count " + readInt2);
            }
            com.google.common.collect.ImmutableSet.Builder b = m9335b(comparator);
            for (int i3 = 0; i3 < readInt2; i3++) {
                b.c(objectInputStream.readObject());
            }
            ImmutableSet b2 = b.b();
            if (b2.size() != readInt2) {
                throw new InvalidObjectException("Duplicate key-value pairs exist for key " + readObject);
            }
            builder.b(readObject, b2);
            i += readInt2;
        }
        try {
            FieldSettersHolder.a.a(this, builder.b());
            FieldSettersHolder.b.a(this, i);
            FieldSettersHolder.c.a(this, m9331a(comparator));
        } catch (Throwable e) {
            throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
        }
    }
}
