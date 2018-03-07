package com.facebook.bitmaps;

/* compiled from: androidPackageName */
public class Dimension {
    public final int f10361a;
    public final int f10362b;

    public Dimension(int i, int i2) {
        this.f10361a = i2;
        this.f10362b = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Dimension)) {
            return false;
        }
        Dimension dimension = (Dimension) obj;
        if (this.f10362b == dimension.f10362b && this.f10361a == dimension.f10361a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f10361a * 31) + this.f10362b;
    }
}
