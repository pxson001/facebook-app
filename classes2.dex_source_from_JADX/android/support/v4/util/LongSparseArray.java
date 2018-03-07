package android.support.v4.util;

/* compiled from: ttl */
public class LongSparseArray<E> implements Cloneable {
    public static final Object f2211a = new Object();
    public boolean f2212b;
    private long[] f2213c;
    public Object[] f2214d;
    private int f2215e;

    public LongSparseArray() {
        this(10);
    }

    public LongSparseArray(int i) {
        this.f2212b = false;
        if (i == 0) {
            this.f2213c = ContainerHelpers.b;
            this.f2214d = ContainerHelpers.c;
        } else {
            int b = ContainerHelpers.b(i);
            this.f2213c = new long[b];
            this.f2214d = new Object[b];
        }
        this.f2215e = 0;
    }

    public Object clone() {
        try {
            LongSparseArray longSparseArray = (LongSparseArray) super.clone();
            try {
                longSparseArray.f2213c = (long[]) this.f2213c.clone();
                longSparseArray.f2214d = (Object[]) this.f2214d.clone();
                return longSparseArray;
            } catch (CloneNotSupportedException e) {
                return longSparseArray;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public final E m4358a(long j) {
        return m4359a(j, null);
    }

    public final E m4359a(long j, E e) {
        int a = ContainerHelpers.a(this.f2213c, this.f2215e, j);
        return (a < 0 || this.f2214d[a] == f2211a) ? e : this.f2214d[a];
    }

    public final void m4363b(long j) {
        int a = ContainerHelpers.a(this.f2213c, this.f2215e, j);
        if (a >= 0 && this.f2214d[a] != f2211a) {
            this.f2214d[a] = f2211a;
            this.f2212b = true;
        }
    }

    public final void m4366c(long j) {
        m4363b(j);
    }

    private void m4355d() {
        int i = this.f2215e;
        long[] jArr = this.f2213c;
        Object[] objArr = this.f2214d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f2211a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f2212b = false;
        this.f2215e = i2;
    }

    public final void m4364b(long j, E e) {
        int a = ContainerHelpers.a(this.f2213c, this.f2215e, j);
        if (a >= 0) {
            this.f2214d[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.f2215e || this.f2214d[a] != f2211a) {
            if (this.f2212b && this.f2215e >= this.f2213c.length) {
                m4355d();
                a = ContainerHelpers.a(this.f2213c, this.f2215e, j) ^ -1;
            }
            if (this.f2215e >= this.f2213c.length) {
                int b = ContainerHelpers.b(this.f2215e + 1);
                Object obj = new long[b];
                Object obj2 = new Object[b];
                System.arraycopy(this.f2213c, 0, obj, 0, this.f2213c.length);
                System.arraycopy(this.f2214d, 0, obj2, 0, this.f2214d.length);
                this.f2213c = obj;
                this.f2214d = obj2;
            }
            if (this.f2215e - a != 0) {
                System.arraycopy(this.f2213c, a, this.f2213c, a + 1, this.f2215e - a);
                System.arraycopy(this.f2214d, a, this.f2214d, a + 1, this.f2215e - a);
            }
            this.f2213c[a] = j;
            this.f2214d[a] = e;
            this.f2215e++;
            return;
        }
        this.f2213c[a] = j;
        this.f2214d[a] = e;
    }

    public final int m4356a() {
        if (this.f2212b) {
            m4355d();
        }
        return this.f2215e;
    }

    public final long m4361b(int i) {
        if (this.f2212b) {
            m4355d();
        }
        return this.f2213c[i];
    }

    public final E m4365c(int i) {
        if (this.f2212b) {
            m4355d();
        }
        return this.f2214d[i];
    }

    public final void m4360a(int i, E e) {
        if (this.f2212b) {
            m4355d();
        }
        this.f2214d[i] = e;
    }

    public final int m4367d(long j) {
        if (this.f2212b) {
            m4355d();
        }
        return ContainerHelpers.a(this.f2213c, this.f2215e, j);
    }

    public final int m4357a(E e) {
        if (this.f2212b) {
            m4355d();
        }
        for (int i = 0; i < this.f2215e; i++) {
            if (this.f2214d[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public final void m4362b() {
        int i = this.f2215e;
        Object[] objArr = this.f2214d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f2215e = 0;
        this.f2212b = false;
    }

    public String toString() {
        if (m4356a() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f2215e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f2215e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m4361b(i));
            stringBuilder.append('=');
            LongSparseArray c = m4365c(i);
            if (c != this) {
                stringBuilder.append(c);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
