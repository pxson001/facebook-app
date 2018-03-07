package com.facebook.common.unicode;

/* compiled from: google_app_id */
public final class UTF16Range {
    public final int f22086a;
    public final int f22087b;

    public UTF16Range(int i, int i2) {
        this.f22086a = i;
        this.f22087b = i2;
    }

    public final int m29946a() {
        return this.f22086a;
    }

    public final int m29947c() {
        return this.f22086a + this.f22087b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UTF16Range uTF16Range = (UTF16Range) obj;
        if (this.f22087b == uTF16Range.f22087b && this.f22086a == uTF16Range.f22086a) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.f22086a * 31) + this.f22087b;
    }

    public final String toString() {
        return "UTF16Range(" + this.f22086a + ", " + this.f22087b + ")";
    }
}
