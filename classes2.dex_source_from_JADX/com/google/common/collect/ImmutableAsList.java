package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

@GwtCompatible
/* compiled from: reaction_color/ */
abstract class ImmutableAsList<E> extends ImmutableList<E> {
    abstract ImmutableCollection<E> mo1722a();

    ImmutableAsList() {
    }

    public boolean contains(Object obj) {
        return mo1722a().contains(obj);
    }

    public int size() {
        return mo1722a().size();
    }

    public boolean isEmpty() {
        return mo1722a().isEmpty();
    }

    boolean isPartialView() {
        return mo1722a().isPartialView();
    }

    @GwtIncompatible("serialization")
    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @GwtIncompatible("serialization")
    Object writeReplace() {
        return new SerializedForm(mo1722a());
    }
}
