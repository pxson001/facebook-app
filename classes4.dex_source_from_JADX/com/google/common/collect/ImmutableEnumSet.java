package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.EnumSet;

@GwtCompatible
/* compiled from: pending_contactpoint_count */
public final class ImmutableEnumSet<E extends Enum<E>> extends ImmutableSet<E> {
    private final transient EnumSet<E> f5255a;
    private transient int f5256b;

    public static ImmutableSet m5775a(EnumSet enumSet) {
        switch (enumSet.size()) {
            case 0:
                return RegularImmutableSet.a;
            case 1:
                return ImmutableSet.of(Iterables.d(enumSet));
            default:
                return new ImmutableEnumSet(enumSet);
        }
    }

    public ImmutableEnumSet(EnumSet<E> enumSet) {
        this.f5255a = enumSet;
    }

    final boolean isPartialView() {
        return false;
    }

    public final UnmodifiableIterator<E> iterator() {
        return Iterators.a(this.f5255a.iterator());
    }

    public final int size() {
        return this.f5255a.size();
    }

    public final boolean contains(Object obj) {
        return this.f5255a.contains(obj);
    }

    public final boolean containsAll(Collection<?> collection) {
        if (collection instanceof ImmutableEnumSet) {
            collection = ((ImmutableEnumSet) collection).f5255a;
        }
        return this.f5255a.containsAll(collection);
    }

    public final boolean isEmpty() {
        return this.f5255a.isEmpty();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableEnumSet) {
            obj = ((ImmutableEnumSet) obj).f5255a;
        }
        return this.f5255a.equals(obj);
    }

    final boolean isHashCodeFast() {
        return true;
    }

    public final int hashCode() {
        int i = this.f5256b;
        if (i != 0) {
            return i;
        }
        i = this.f5255a.hashCode();
        this.f5256b = i;
        return i;
    }

    public final String toString() {
        return this.f5255a.toString();
    }

    final Object writeReplace() {
        return new EnumSerializedForm(this.f5255a);
    }
}
