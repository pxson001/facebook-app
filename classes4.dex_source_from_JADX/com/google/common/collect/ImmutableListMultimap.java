package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableMultimap.FieldSettersHolder;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: sms_takeover_fallback_notification */
public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> implements ListMultimap<K, V> {
    @GwtIncompatible("Not needed in emulated source")
    private static final long serialVersionUID = 0;

    public final /* synthetic */ List m2107a(@Nullable Object obj) {
        return m2111e(obj);
    }

    @Deprecated
    public final /* synthetic */ List m2108b(Object obj) {
        return m2106y();
    }

    public final /* synthetic */ Collection m2109c(@Nullable Object obj) {
        return m2111e(obj);
    }

    @Deprecated
    public final /* synthetic */ Collection m2110d(Object obj) {
        return m2106y();
    }

    public final /* synthetic */ ImmutableCollection m2112h(@Nullable Object obj) {
        return m2111e(obj);
    }

    @Deprecated
    public final /* synthetic */ ImmutableCollection m2113i(Object obj) {
        return m2106y();
    }

    public static <K, V> ImmutableListMultimap<K, V> m2104a() {
        return EmptyImmutableListMultimap.a;
    }

    public static <K, V> ImmutableListMultimap<K, V> m2105b(Multimap<? extends K, ? extends V> multimap) {
        if (multimap.n()) {
            return EmptyImmutableListMultimap.a;
        }
        if (multimap instanceof ImmutableListMultimap) {
            ImmutableListMultimap<K, V> immutableListMultimap = (ImmutableListMultimap) multimap;
            if (!immutableListMultimap.d()) {
                return immutableListMultimap;
            }
        }
        Builder builder = new Builder(multimap.b().size());
        int i = 0;
        for (Entry entry : multimap.b().entrySet()) {
            int i2;
            ImmutableList copyOf = ImmutableList.copyOf((Collection) entry.getValue());
            if (copyOf.isEmpty()) {
                i2 = i;
            } else {
                builder.b(entry.getKey(), copyOf);
                i2 = copyOf.size() + i;
            }
            i = i2;
        }
        return new ImmutableListMultimap(builder.b(), i);
    }

    ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> immutableMap, int i) {
        super(immutableMap, i);
    }

    public final ImmutableList<V> m2111e(@Nullable K k) {
        ImmutableList<V> immutableList = (ImmutableList) this.b.get(k);
        return immutableList == null ? RegularImmutableList.a : immutableList;
    }

    @Deprecated
    private static ImmutableList<V> m2106y() {
        throw new UnsupportedOperationException();
    }

    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Serialization.a(this, objectOutputStream);
    }

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt < 0) {
            throw new InvalidObjectException("Invalid key count " + readInt);
        }
        Builder builder = ImmutableMap.builder();
        int i = 0;
        for (int i2 = 0; i2 < readInt; i2++) {
            Object readObject = objectInputStream.readObject();
            int readInt2 = objectInputStream.readInt();
            if (readInt2 <= 0) {
                throw new InvalidObjectException("Invalid value count " + readInt2);
            }
            ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i3 = 0; i3 < readInt2; i3++) {
                builder2.c(objectInputStream.readObject());
            }
            builder.b(readObject, builder2.b());
            i += readInt2;
        }
        try {
            FieldSettersHolder.a.a(this, builder.b());
            FieldSettersHolder.b.a(this, i);
        } catch (Throwable e) {
            throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
        }
    }
}
