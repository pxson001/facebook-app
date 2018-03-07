package com.fasterxml.jackson.core.sym;

/* compiled from: identifier */
public final class BytesToNameCanonicalizer$Bucket {
    protected final Name f10528a;
    protected final BytesToNameCanonicalizer$Bucket f10529b;
    public final int f10530c;

    BytesToNameCanonicalizer$Bucket(Name name, BytesToNameCanonicalizer$Bucket bytesToNameCanonicalizer$Bucket) {
        this.f10528a = name;
        this.f10529b = bytesToNameCanonicalizer$Bucket;
        this.f10530c = bytesToNameCanonicalizer$Bucket == null ? 1 : bytesToNameCanonicalizer$Bucket.f10530c + 1;
    }

    public final int m11061a() {
        return this.f10530c;
    }

    public final Name m11062a(int i, int i2, int i3) {
        if (this.f10528a.hashCode() == i && this.f10528a.a(i2, i3)) {
            return this.f10528a;
        }
        for (BytesToNameCanonicalizer$Bucket bytesToNameCanonicalizer$Bucket = this.f10529b; bytesToNameCanonicalizer$Bucket != null; bytesToNameCanonicalizer$Bucket = bytesToNameCanonicalizer$Bucket.f10529b) {
            Name name = bytesToNameCanonicalizer$Bucket.f10528a;
            if (name.hashCode() == i && name.a(i2, i3)) {
                return name;
            }
        }
        return null;
    }

    public final Name m11063a(int i, int[] iArr, int i2) {
        if (this.f10528a.hashCode() == i && this.f10528a.a(iArr, i2)) {
            return this.f10528a;
        }
        for (BytesToNameCanonicalizer$Bucket bytesToNameCanonicalizer$Bucket = this.f10529b; bytesToNameCanonicalizer$Bucket != null; bytesToNameCanonicalizer$Bucket = bytesToNameCanonicalizer$Bucket.f10529b) {
            Name name = bytesToNameCanonicalizer$Bucket.f10528a;
            if (name.hashCode() == i && name.a(iArr, i2)) {
                return name;
            }
        }
        return null;
    }
}
