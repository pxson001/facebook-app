package com.fasterxml.jackson.databind.util;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* compiled from: storyProps */
public class LRUMap<K, V> extends LinkedHashMap<K, V> implements Serializable {
    private static final long serialVersionUID = 1;
    protected final int _maxEntries;
    protected transient int f4059a;

    public LRUMap(int i, int i2) {
        super(i, 0.8f, true);
        this._maxEntries = i2;
    }

    protected boolean removeEldestEntry(Entry<K, V> entry) {
        return size() > this._maxEntries;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.f4059a = objectInputStream.readInt();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.f4059a);
    }

    protected Object readResolve() {
        return new LRUMap(this.f4059a, this.f4059a);
    }
}
