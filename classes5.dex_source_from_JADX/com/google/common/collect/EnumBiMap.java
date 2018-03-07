package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.EnumMap;
import java.util.Map;

@GwtCompatible
/* compiled from: call_log */
public final class EnumBiMap<K extends Enum<K>, V extends Enum<V>> extends AbstractBiMap<K, V> {
    private transient Class<K> f7299b;
    private transient Class<V> f7300c;

    final Object mo887a(Object obj) {
        return (Enum) Preconditions.checkNotNull((Enum) obj);
    }

    final Object mo888b(Object obj) {
        return (Enum) Preconditions.checkNotNull((Enum) obj);
    }

    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f7299b);
        objectOutputStream.writeObject(this.f7300c);
        Serialization.m13655a((Map) this, objectOutputStream);
    }

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f7299b = (Class) objectInputStream.readObject();
        this.f7300c = (Class) objectInputStream.readObject();
        m13203a(WellBehavedMap.m13783a(new EnumMap(this.f7299b)), WellBehavedMap.m13783a(new EnumMap(this.f7300c)));
        Serialization.m13653a((Map) this, objectInputStream);
    }
}
