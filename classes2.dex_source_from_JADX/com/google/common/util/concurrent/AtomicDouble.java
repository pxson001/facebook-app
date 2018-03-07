package com.google.common.util.concurrent;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* compiled from: prefetch_start */
public class AtomicDouble extends Number implements Serializable {
    private static final AtomicLongFieldUpdater<AtomicDouble> f9212b = AtomicLongFieldUpdater.newUpdater(AtomicDouble.class, "a");
    private volatile transient long f9213a;

    private double m14128a() {
        return Double.longBitsToDouble(this.f9213a);
    }

    public final void m14129a(double d) {
        this.f9213a = Double.doubleToRawLongBits(d);
    }

    public String toString() {
        return Double.toString(m14128a());
    }

    public int intValue() {
        return (int) m14128a();
    }

    public long longValue() {
        return (long) m14128a();
    }

    public float floatValue() {
        return (float) m14128a();
    }

    public double doubleValue() {
        return m14128a();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeDouble(m14128a());
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        m14129a(objectInputStream.readDouble());
    }
}
