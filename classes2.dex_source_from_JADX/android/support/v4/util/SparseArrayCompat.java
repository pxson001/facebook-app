package android.support.v4.util;

/* compiled from: supported_prompts */
public class SparseArrayCompat<E> implements Cloneable {
    private static final Object f3805a = new Object();
    private boolean f3806b;
    private int[] f3807c;
    private Object[] f3808d;
    private int f3809e;

    public SparseArrayCompat() {
        this(10);
    }

    public SparseArrayCompat(int i) {
        this.f3806b = false;
        if (i == 0) {
            this.f3807c = ContainerHelpers.a;
            this.f3808d = ContainerHelpers.c;
        } else {
            int a = ContainerHelpers.a(i);
            this.f3807c = new int[a];
            this.f3808d = new Object[a];
        }
        this.f3809e = 0;
    }

    public Object clone() {
        try {
            SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) super.clone();
            try {
                sparseArrayCompat.f3807c = (int[]) this.f3807c.clone();
                sparseArrayCompat.f3808d = (Object[]) this.f3808d.clone();
                return sparseArrayCompat;
            } catch (CloneNotSupportedException e) {
                return sparseArrayCompat;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public final E m6350a(int i) {
        return m6346c(i, null);
    }

    private E m6346c(int i, E e) {
        int a = ContainerHelpers.a(this.f3807c, this.f3809e, i);
        return (a < 0 || this.f3808d[a] == f3805a) ? e : this.f3808d[a];
    }

    public final void m6353b(int i) {
        int a = ContainerHelpers.a(this.f3807c, this.f3809e, i);
        if (a >= 0 && this.f3808d[a] != f3805a) {
            this.f3808d[a] = f3805a;
            this.f3806b = true;
        }
    }

    public final void m6355d(int i) {
        if (this.f3808d[i] != f3805a) {
            this.f3808d[i] = f3805a;
            this.f3806b = true;
        }
    }

    private void m6347d() {
        int i = this.f3809e;
        int[] iArr = this.f3807c;
        Object[] objArr = this.f3808d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f3805a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f3806b = false;
        this.f3809e = i2;
    }

    public final void m6351a(int i, E e) {
        int a = ContainerHelpers.a(this.f3807c, this.f3809e, i);
        if (a >= 0) {
            this.f3808d[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.f3809e || this.f3808d[a] != f3805a) {
            if (this.f3806b && this.f3809e >= this.f3807c.length) {
                m6347d();
                a = ContainerHelpers.a(this.f3807c, this.f3809e, i) ^ -1;
            }
            if (this.f3809e >= this.f3807c.length) {
                int a2 = ContainerHelpers.a(this.f3809e + 1);
                Object obj = new int[a2];
                Object obj2 = new Object[a2];
                System.arraycopy(this.f3807c, 0, obj, 0, this.f3807c.length);
                System.arraycopy(this.f3808d, 0, obj2, 0, this.f3808d.length);
                this.f3807c = obj;
                this.f3808d = obj2;
            }
            if (this.f3809e - a != 0) {
                System.arraycopy(this.f3807c, a, this.f3807c, a + 1, this.f3809e - a);
                System.arraycopy(this.f3808d, a, this.f3808d, a + 1, this.f3809e - a);
            }
            this.f3807c[a] = i;
            this.f3808d[a] = e;
            this.f3809e++;
            return;
        }
        this.f3807c[a] = i;
        this.f3808d[a] = e;
    }

    public final int m6348a() {
        if (this.f3806b) {
            m6347d();
        }
        return this.f3809e;
    }

    public final int m6356e(int i) {
        if (this.f3806b) {
            m6347d();
        }
        return this.f3807c[i];
    }

    public final E m6357f(int i) {
        if (this.f3806b) {
            m6347d();
        }
        return this.f3808d[i];
    }

    public final int m6358g(int i) {
        if (this.f3806b) {
            m6347d();
        }
        return ContainerHelpers.a(this.f3807c, this.f3809e, i);
    }

    public final int m6349a(E e) {
        if (this.f3806b) {
            m6347d();
        }
        for (int i = 0; i < this.f3809e; i++) {
            if (this.f3808d[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public final void m6352b() {
        int i = this.f3809e;
        Object[] objArr = this.f3808d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f3809e = 0;
        this.f3806b = false;
    }

    public final void m6354b(int i, E e) {
        if (this.f3809e == 0 || i > this.f3807c[this.f3809e - 1]) {
            if (this.f3806b && this.f3809e >= this.f3807c.length) {
                m6347d();
            }
            int i2 = this.f3809e;
            if (i2 >= this.f3807c.length) {
                int a = ContainerHelpers.a(i2 + 1);
                Object obj = new int[a];
                Object obj2 = new Object[a];
                System.arraycopy(this.f3807c, 0, obj, 0, this.f3807c.length);
                System.arraycopy(this.f3808d, 0, obj2, 0, this.f3808d.length);
                this.f3807c = obj;
                this.f3808d = obj2;
            }
            this.f3807c[i2] = i;
            this.f3808d[i2] = e;
            this.f3809e = i2 + 1;
            return;
        }
        m6351a(i, e);
    }

    public String toString() {
        if (m6348a() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f3809e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f3809e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m6356e(i));
            stringBuilder.append('=');
            SparseArrayCompat f = m6357f(i);
            if (f != this) {
                stringBuilder.append(f);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
