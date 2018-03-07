package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: call_feedback_id */
public final class EnumHashBiMap<K extends Enum<K>, V> extends AbstractBiMap<K, V> {
    private transient Class<K> f7301b;

    final Object mo887a(Object obj) {
        return (Enum) Preconditions.checkNotNull((Enum) obj);
    }

    public final Object mo922a(Object obj, @Nullable Object obj2) {
        return super.mo922a((Enum) obj, obj2);
    }

    public final Object put(Object obj, @Nullable Object obj2) {
        return super.put((Enum) obj, obj2);
    }

    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f7301b);
        Serialization.m13655a((Map) this, objectOutputStream);
    }

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f7301b = (Class) objectInputStream.readObject();
        m13203a(WellBehavedMap.m13783a(new EnumMap(this.f7301b)), new HashMap((((Enum[]) this.f7301b.getEnumConstants()).length * 3) / 2));
        Serialization.m13653a((Map) this, objectInputStream);
    }
}
