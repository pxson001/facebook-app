package com.fasterxml.jackson.core.sym;

import com.fasterxml.jackson.core.util.InternCache;
import java.util.Arrays;

/* compiled from: stories_order */
public final class CharsToNameCanonicalizer {
    static final CharsToNameCanonicalizer f4089a = new CharsToNameCanonicalizer();
    protected CharsToNameCanonicalizer f4090b;
    protected final boolean f4091c;
    protected final boolean f4092d;
    protected String[] f4093e;
    protected Bucket[] f4094f;
    protected int f4095g;
    protected int f4096h;
    protected int f4097i;
    protected int f4098j;
    public boolean f4099k;
    public final int f4100l;

    /* compiled from: stories_order */
    public final class Bucket {
        public final String f4101a;
        public final Bucket f4102b;
        public final int f4103c;

        public Bucket(String str, Bucket bucket) {
            this.f4101a = str;
            this.f4102b = bucket;
            this.f4103c = bucket == null ? 1 : bucket.f4103c + 1;
        }

        public final String m7192a() {
            return this.f4101a;
        }

        public final Bucket m7194b() {
            return this.f4102b;
        }

        public final int m7195c() {
            return this.f4103c;
        }

        public final String m7193a(char[] cArr, int i, int i2) {
            String str = this.f4101a;
            Bucket bucket = this.f4102b;
            while (true) {
                if (str.length() == i2) {
                    int i3 = 0;
                    while (str.charAt(i3) == cArr[i + i3]) {
                        i3++;
                        if (i3 >= i2) {
                            break;
                        }
                    }
                    if (i3 == i2) {
                        return str;
                    }
                }
                if (bucket == null) {
                    return null;
                }
                str = bucket.f4101a;
                bucket = bucket.f4102b;
            }
        }
    }

    public static CharsToNameCanonicalizer m7176a() {
        long currentTimeMillis = System.currentTimeMillis();
        return m7177a((((int) (currentTimeMillis >>> 32)) + ((int) currentTimeMillis)) | 1);
    }

    private static CharsToNameCanonicalizer m7177a(int i) {
        return f4089a.m7182d(i);
    }

    private CharsToNameCanonicalizer() {
        this.f4092d = true;
        this.f4091c = true;
        this.f4099k = true;
        this.f4100l = 0;
        this.f4098j = 0;
        m7179b(64);
    }

    private void m7179b(int i) {
        this.f4093e = new String[i];
        this.f4094f = new Bucket[(i >> 1)];
        this.f4097i = i - 1;
        this.f4095g = 0;
        this.f4098j = 0;
        this.f4096h = m7180c(i);
    }

    private static int m7180c(int i) {
        return i - (i >> 2);
    }

    private CharsToNameCanonicalizer(CharsToNameCanonicalizer charsToNameCanonicalizer, boolean z, boolean z2, String[] strArr, Bucket[] bucketArr, int i, int i2, int i3) {
        this.f4090b = charsToNameCanonicalizer;
        this.f4092d = z;
        this.f4091c = z2;
        this.f4093e = strArr;
        this.f4094f = bucketArr;
        this.f4095g = i;
        this.f4100l = i2;
        int length = strArr.length;
        this.f4096h = m7180c(length);
        this.f4097i = length - 1;
        this.f4098j = i3;
        this.f4099k = false;
    }

    public final CharsToNameCanonicalizer m7188a(boolean z, boolean z2) {
        String[] strArr;
        Bucket[] bucketArr;
        int i;
        int i2;
        int i3;
        synchronized (this) {
            strArr = this.f4093e;
            bucketArr = this.f4094f;
            i = this.f4095g;
            i2 = this.f4100l;
            i3 = this.f4098j;
        }
        return new CharsToNameCanonicalizer(this, z, z2, strArr, bucketArr, i, i2, i3);
    }

    private CharsToNameCanonicalizer m7182d(int i) {
        return new CharsToNameCanonicalizer(null, true, true, this.f4093e, this.f4094f, this.f4095g, i, this.f4098j);
    }

    private void m7178a(CharsToNameCanonicalizer charsToNameCanonicalizer) {
        if (charsToNameCanonicalizer.m7181d() > 12000 || charsToNameCanonicalizer.f4098j > 63) {
            synchronized (this) {
                m7179b(64);
                this.f4099k = false;
            }
        } else if (charsToNameCanonicalizer.m7181d() > m7181d()) {
            synchronized (this) {
                this.f4093e = charsToNameCanonicalizer.f4093e;
                this.f4094f = charsToNameCanonicalizer.f4094f;
                this.f4095g = charsToNameCanonicalizer.f4095g;
                this.f4096h = charsToNameCanonicalizer.f4096h;
                this.f4097i = charsToNameCanonicalizer.f4097i;
                this.f4098j = charsToNameCanonicalizer.f4098j;
                this.f4099k = false;
            }
        }
    }

    private int m7181d() {
        return this.f4095g;
    }

    private boolean m7184e() {
        return this.f4099k;
    }

    public final void m7190b() {
        if (this.f4099k && this.f4090b != null) {
            this.f4090b.m7178a(this);
            this.f4099k = false;
        }
    }

    public final int m7191c() {
        return this.f4100l;
    }

    public final String m7189a(char[] cArr, int i, int i2, int i3) {
        if (i2 <= 0) {
            return "";
        }
        if (!this.f4092d) {
            return new String(cArr, i, i2);
        }
        int i4;
        int e = m7183e(i3);
        String str = this.f4093e[e];
        if (str != null) {
            if (str.length() == i2) {
                i4 = 0;
                while (str.charAt(i4) == cArr[i + i4]) {
                    i4++;
                    if (i4 >= i2) {
                        break;
                    }
                }
                if (i4 == i2) {
                    return str;
                }
            }
            Bucket bucket = this.f4094f[e >> 1];
            if (bucket != null) {
                String a = bucket.m7193a(cArr, i, i2);
                if (a != null) {
                    return a;
                }
            }
        }
        if (!this.f4099k) {
            m7185f();
            this.f4099k = true;
            i4 = e;
        } else if (this.f4095g >= this.f4096h) {
            m7187g();
            i4 = m7183e(m7175a(cArr, i2));
        } else {
            i4 = e;
        }
        String str2 = new String(cArr, i, i2);
        if (this.f4091c) {
            str2 = InternCache.f8652a.m13436a(str2);
        }
        this.f4095g++;
        if (this.f4093e[i4] == null) {
            this.f4093e[i4] = str2;
            return str2;
        }
        i4 >>= 1;
        Bucket bucket2 = new Bucket(str2, this.f4094f[i4]);
        this.f4094f[i4] = bucket2;
        this.f4098j = Math.max(bucket2.f4103c, this.f4098j);
        if (this.f4098j <= 255) {
            return str2;
        }
        m7186f(255);
        return str2;
    }

    private int m7183e(int i) {
        return ((i >>> 15) + i) & this.f4097i;
    }

    private int m7175a(char[] cArr, int i) {
        int i2 = this.f4100l;
        int i3 = 0;
        while (i3 < i) {
            int i4 = cArr[i3] + (i2 * 33);
            i3++;
            i2 = i4;
        }
        return i2 == 0 ? 1 : i2;
    }

    private int m7174a(String str) {
        int length = str.length();
        int i = this.f4100l;
        int i2 = 0;
        while (i2 < length) {
            int charAt = str.charAt(i2) + (i * 33);
            i2++;
            i = charAt;
        }
        return i == 0 ? 1 : i;
    }

    private void m7185f() {
        Object obj = this.f4093e;
        int length = obj.length;
        this.f4093e = new String[length];
        System.arraycopy(obj, 0, this.f4093e, 0, length);
        obj = this.f4094f;
        length = obj.length;
        this.f4094f = new Bucket[length];
        System.arraycopy(obj, 0, this.f4094f, 0, length);
    }

    private void m7187g() {
        int length = this.f4093e.length;
        int i = length + length;
        if (i > 65536) {
            this.f4095g = 0;
            Arrays.fill(this.f4093e, null);
            Arrays.fill(this.f4094f, null);
            this.f4099k = true;
            return;
        }
        int i2;
        String[] strArr = this.f4093e;
        Bucket[] bucketArr = this.f4094f;
        this.f4093e = new String[i];
        this.f4094f = new Bucket[(i >> 1)];
        this.f4097i = i - 1;
        this.f4096h = m7180c(i);
        i = 0;
        int i3 = 0;
        for (i2 = 0; i2 < length; i2++) {
            String str = strArr[i2];
            if (str != null) {
                i3++;
                int e = m7183e(m7174a(str));
                if (this.f4093e[e] == null) {
                    this.f4093e[e] = str;
                } else {
                    e >>= 1;
                    Bucket bucket = new Bucket(str, this.f4094f[e]);
                    this.f4094f[e] = bucket;
                    i = Math.max(i, bucket.f4103c);
                }
            }
        }
        length >>= 1;
        i2 = 0;
        int i4 = i3;
        i3 = i;
        while (i2 < length) {
            i = i3;
            for (Bucket bucket2 = bucketArr[i2]; bucket2 != null; bucket2 = bucket2.f4102b) {
                i4++;
                String str2 = bucket2.f4101a;
                int e2 = m7183e(m7174a(str2));
                if (this.f4093e[e2] == null) {
                    this.f4093e[e2] = str2;
                } else {
                    e2 >>= 1;
                    Bucket bucket3 = new Bucket(str2, this.f4094f[e2]);
                    this.f4094f[e2] = bucket3;
                    i = Math.max(i, bucket3.f4103c);
                }
            }
            i2++;
            i3 = i;
        }
        this.f4098j = i3;
        if (i4 != this.f4095g) {
            throw new Error("Internal error on SymbolTable.rehash(): had " + this.f4095g + " entries; now have " + i4 + ".");
        }
    }

    private void m7186f(int i) {
        throw new IllegalStateException("Longest collision chain in symbol table (of size " + this.f4095g + ") now exceeds maximum, " + i + " -- suspect a DoS attack based on hash collisions");
    }
}
