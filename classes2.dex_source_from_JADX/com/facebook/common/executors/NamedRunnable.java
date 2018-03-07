package com.facebook.common.executors;

/* compiled from: oldCount */
public abstract class NamedRunnable implements ProvidesName, Runnable {
    public final String f11309a;
    public final String f11310b;

    public NamedRunnable(Class<?> cls, String str) {
        this(cls.getSimpleName(), str);
    }

    public NamedRunnable(String str, String str2) {
        this.f11309a = str;
        this.f11310b = str2;
    }

    public String toString() {
        return mo502a();
    }

    public final String mo502a() {
        return this.f11309a + "/" + this.f11310b;
    }
}
