package com.fasterxml.jackson.core.sym;

/* compiled from: t_ec */
public abstract class Name {
    public final String f4128a;
    protected final int f4129b;

    public abstract boolean mo3210a(int i);

    public abstract boolean mo3211a(int i, int i2);

    public abstract boolean mo3212a(int[] iArr, int i);

    protected Name(String str, int i) {
        this.f4128a = str;
        this.f4129b = i;
    }

    public final String m7223a() {
        return this.f4128a;
    }

    public String toString() {
        return this.f4128a;
    }

    public final int hashCode() {
        return this.f4129b;
    }

    public boolean equals(Object obj) {
        return obj == this;
    }
}
