package com.google.zxing.common;

/* compiled from: event_send_share_photos_reminder */
public final class BitMatrix {
    public final int f13477a;
    public final int f13478b;
    public final int f13479c;
    public final int[] f13480d;

    public BitMatrix(int i) {
        this(i, i);
    }

    public BitMatrix(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f13477a = i;
        this.f13478b = i2;
        this.f13479c = (i + 31) >> 5;
        this.f13480d = new int[(this.f13479c * i2)];
    }

    public final boolean m13674a(int i, int i2) {
        return ((this.f13480d[(this.f13479c * i2) + (i >> 5)] >>> (i & 31)) & 1) != 0;
    }

    public final void m13676b(int i, int i2) {
        int i3 = (this.f13479c * i2) + (i >> 5);
        int[] iArr = this.f13480d;
        iArr[i3] = iArr[i3] | (1 << (i & 31));
    }

    public final void m13673a(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (i4 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            int i5 = i + i3;
            int i6 = i2 + i4;
            if (i6 > this.f13478b || i5 > this.f13477a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i2 < i6) {
                int i7 = i2 * this.f13479c;
                for (int i8 = i; i8 < i5; i8++) {
                    int[] iArr = this.f13480d;
                    int i9 = (i8 >> 5) + i7;
                    iArr[i9] = iArr[i9] | (1 << (i8 & 31));
                }
                i2++;
            }
        }
    }

    public final int[] m13675a() {
        int i = 0;
        while (i < this.f13480d.length && this.f13480d[i] == 0) {
            i++;
        }
        if (i == this.f13480d.length) {
            return null;
        }
        int i2 = i / this.f13479c;
        int i3 = (i % this.f13479c) << 5;
        int i4 = this.f13480d[i];
        i = 0;
        while ((i4 << (31 - i)) == 0) {
            i++;
        }
        i3 += i;
        return new int[]{i3, i2};
    }

    public final int[] m13677b() {
        int length = this.f13480d.length - 1;
        while (length >= 0 && this.f13480d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i = length / this.f13479c;
        int i2 = (length % this.f13479c) << 5;
        int i3 = this.f13480d[length];
        length = 31;
        while ((i3 >>> length) == 0) {
            length--;
        }
        i2 += length;
        return new int[]{i2, i};
    }

    public final int m13678c() {
        return this.f13477a;
    }

    public final int m13679d() {
        return this.f13478b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof BitMatrix)) {
            return false;
        }
        BitMatrix bitMatrix = (BitMatrix) obj;
        if (this.f13477a != bitMatrix.f13477a || this.f13478b != bitMatrix.f13478b || this.f13479c != bitMatrix.f13479c || this.f13480d.length != bitMatrix.f13480d.length) {
            return false;
        }
        for (int i = 0; i < this.f13480d.length; i++) {
            if (this.f13480d[i] != bitMatrix.f13480d[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = this.f13479c + (((((this.f13477a * 31) + this.f13477a) * 31) + this.f13478b) * 31);
        for (int i2 : this.f13480d) {
            i = (i * 31) + i2;
        }
        return i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.f13478b * (this.f13477a + 1));
        for (int i = 0; i < this.f13478b; i++) {
            for (int i2 = 0; i2 < this.f13477a; i2++) {
                stringBuilder.append(m13674a(i2, i) ? "X " : "  ");
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
