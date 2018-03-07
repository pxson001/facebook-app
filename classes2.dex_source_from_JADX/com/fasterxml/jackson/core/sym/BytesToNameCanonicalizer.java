package com.fasterxml.jackson.core.sym;

import com.facebook.proxygen.HTTPTransportCallback;
import com.fasterxml.jackson.core.util.InternCache;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: stories_about_topic_feed */
public final class BytesToNameCanonicalizer {
    protected final BytesToNameCanonicalizer f4104a;
    protected final AtomicReference<TableInfo> f4105b;
    protected final boolean f4106c;
    protected int f4107d;
    protected int f4108e;
    protected int f4109f;
    protected int[] f4110g;
    protected Name[] f4111h;
    protected Bucket[] f4112i;
    protected int f4113j;
    protected int f4114k;
    private final int f4115l;
    private transient boolean f4116m;
    private boolean f4117n;
    private boolean f4118o;
    private boolean f4119p;

    /* compiled from: stories_about_topic_feed */
    final class TableInfo {
        public final int f4120a;
        public final int f4121b;
        public final int[] f4122c;
        public final Name[] f4123d;
        public final Bucket[] f4124e;
        public final int f4125f;
        public final int f4126g;
        public final int f4127h;

        public TableInfo(int i, int i2, int[] iArr, Name[] nameArr, Bucket[] bucketArr, int i3, int i4, int i5) {
            this.f4120a = i;
            this.f4121b = i2;
            this.f4122c = iArr;
            this.f4123d = nameArr;
            this.f4124e = bucketArr;
            this.f4125f = i3;
            this.f4126g = i4;
            this.f4127h = i5;
        }

        public TableInfo(BytesToNameCanonicalizer bytesToNameCanonicalizer) {
            this.f4120a = bytesToNameCanonicalizer.f4107d;
            this.f4121b = bytesToNameCanonicalizer.f4109f;
            this.f4122c = bytesToNameCanonicalizer.f4110g;
            this.f4123d = bytesToNameCanonicalizer.f4111h;
            this.f4124e = bytesToNameCanonicalizer.f4112i;
            this.f4125f = bytesToNameCanonicalizer.f4113j;
            this.f4126g = bytesToNameCanonicalizer.f4114k;
            this.f4127h = bytesToNameCanonicalizer.f4108e;
        }
    }

    public static Name m7205c() {
        return Name1.f21921c;
    }

    private BytesToNameCanonicalizer(int i, boolean z, int i2) {
        int i3 = 16;
        this.f4104a = null;
        this.f4115l = i2;
        this.f4106c = z;
        if (i < 16) {
            i = 16;
        } else if (((i - 1) & i) != 0) {
            while (i3 < i) {
                i3 += i3;
            }
            i = i3;
        }
        this.f4105b = new AtomicReference(m7203b(i));
    }

    private BytesToNameCanonicalizer(BytesToNameCanonicalizer bytesToNameCanonicalizer, boolean z, int i, TableInfo tableInfo) {
        this.f4104a = bytesToNameCanonicalizer;
        this.f4115l = i;
        this.f4106c = z;
        this.f4105b = null;
        this.f4107d = tableInfo.f4120a;
        this.f4109f = tableInfo.f4121b;
        this.f4110g = tableInfo.f4122c;
        this.f4111h = tableInfo.f4123d;
        this.f4112i = tableInfo.f4124e;
        this.f4113j = tableInfo.f4125f;
        this.f4114k = tableInfo.f4126g;
        this.f4108e = tableInfo.f4127h;
        this.f4116m = false;
        this.f4117n = true;
        this.f4118o = true;
        this.f4119p = true;
    }

    private static TableInfo m7203b(int i) {
        return new TableInfo(0, i - 1, new int[i], new Name[i], null, 0, 0, 0);
    }

    public static BytesToNameCanonicalizer m7196a() {
        long currentTimeMillis = System.currentTimeMillis();
        return m7204c((((int) (currentTimeMillis >>> 32)) + ((int) currentTimeMillis)) | 1);
    }

    private static BytesToNameCanonicalizer m7204c(int i) {
        return new BytesToNameCanonicalizer(64, true, i);
    }

    public final BytesToNameCanonicalizer m7216a(boolean z) {
        return new BytesToNameCanonicalizer(this, z, this.f4115l, (TableInfo) this.f4105b.get());
    }

    public final void m7222b() {
        if (this.f4104a != null && m7207d()) {
            this.f4104a.m7200a(new TableInfo(this));
            this.f4117n = true;
            this.f4118o = true;
            this.f4119p = true;
        }
    }

    private void m7200a(TableInfo tableInfo) {
        int i = tableInfo.f4120a;
        TableInfo tableInfo2 = (TableInfo) this.f4105b.get();
        if (i > tableInfo2.f4120a) {
            if (i > 6000 || tableInfo.f4127h > 63) {
                tableInfo = m7203b(64);
            }
            this.f4105b.compareAndSet(tableInfo2, tableInfo);
        }
    }

    private boolean m7207d() {
        return !this.f4117n;
    }

    public final Name m7217a(int i) {
        int d = m7206d(i);
        int i2 = this.f4109f & d;
        int i3 = this.f4110g[i2];
        if ((((i3 >> 8) ^ d) << 8) == 0) {
            Name name = this.f4111h[i2];
            if (name == null) {
                return null;
            }
            if (name.mo3210a(i)) {
                return name;
            }
        } else if (i3 == 0) {
            return null;
        }
        i2 = i3 & 255;
        if (i2 <= 0) {
            return null;
        }
        Bucket bucket = this.f4112i[i2 - 1];
        if (bucket != null) {
            return bucket.a(d, i, 0);
        }
        return null;
    }

    public final Name m7218a(int i, int i2) {
        int d = i2 == 0 ? m7206d(i) : m7201b(i, i2);
        int i3 = this.f4109f & d;
        int i4 = this.f4110g[i3];
        if ((((i4 >> 8) ^ d) << 8) == 0) {
            Name name = this.f4111h[i3];
            if (name == null) {
                return null;
            }
            if (name.mo3211a(i, i2)) {
                return name;
            }
        } else if (i4 == 0) {
            return null;
        }
        i3 = i4 & 255;
        if (i3 > 0) {
            Bucket bucket = this.f4112i[i3 - 1];
            if (bucket != null) {
                return bucket.a(d, i, i2);
            }
        }
        return null;
    }

    public final Name m7221a(int[] iArr, int i) {
        int i2 = 0;
        if (i < 3) {
            int i3 = iArr[0];
            if (i >= 2) {
                i2 = iArr[1];
            }
            return m7218a(i3, i2);
        }
        int b = m7202b(iArr, i);
        i2 = this.f4109f & b;
        int i4 = this.f4110g[i2];
        if ((((i4 >> 8) ^ b) << 8) == 0) {
            Name name = this.f4111h[i2];
            if (name == null || name.mo3212a(iArr, i)) {
                return name;
            }
        } else if (i4 == 0) {
            return null;
        }
        i2 = i4 & 255;
        if (i2 > 0) {
            Bucket bucket = this.f4112i[i2 - 1];
            if (bucket != null) {
                return bucket.a(b, iArr, i);
            }
        }
        return null;
    }

    public final Name m7219a(String str, int i, int i2) {
        if (this.f4106c) {
            str = InternCache.f8652a.m13436a(str);
        }
        int d = i2 == 0 ? m7206d(i) : m7201b(i, i2);
        Name a = m7197a(d, str, i, i2);
        m7199a(d, a);
        return a;
    }

    public final Name m7220a(String str, int[] iArr, int i) {
        if (this.f4106c) {
            str = InternCache.f8652a.m13436a(str);
        }
        int d = i < 3 ? i == 1 ? m7206d(iArr[0]) : m7201b(iArr[0], iArr[1]) : m7202b(iArr, i);
        Name a = m7198a(d, str, iArr, i);
        m7199a(d, a);
        return a;
    }

    private int m7206d(int i) {
        int i2 = this.f4115l ^ i;
        i2 += i2 >>> 15;
        return i2 ^ (i2 >>> 9);
    }

    private int m7201b(int i, int i2) {
        int i3 = (((i >>> 15) ^ i) + (i2 * 33)) ^ this.f4115l;
        return i3 + (i3 >>> 7);
    }

    private int m7202b(int[] iArr, int i) {
        int i2 = 3;
        if (i < 3) {
            throw new IllegalArgumentException();
        }
        int i3 = iArr[0] ^ this.f4115l;
        i3 = (((i3 + (i3 >>> 9)) * 33) + iArr[1]) * 65599;
        i3 = (i3 + (i3 >>> 15)) ^ iArr[2];
        i3 += i3 >>> 17;
        while (i2 < i) {
            i3 = (i3 * 31) ^ iArr[i2];
            i3 += i3 >>> 3;
            i3 ^= i3 << 7;
            i2++;
        }
        i2 = (i3 >>> 15) + i3;
        return i2 ^ (i2 << 9);
    }

    private void m7199a(int i, Name name) {
        int i2;
        if (this.f4117n) {
            m7212h();
        }
        if (this.f4116m) {
            m7208e();
        }
        this.f4107d++;
        int i3 = i & this.f4109f;
        if (this.f4111h[i3] == null) {
            this.f4110g[i3] = i << 8;
            if (this.f4118o) {
                m7214j();
            }
            this.f4111h[i3] = name;
        } else {
            if (this.f4119p) {
                m7213i();
            }
            this.f4113j++;
            int i4 = this.f4110g[i3];
            i2 = i4 & 255;
            if (i2 == 0) {
                if (this.f4114k <= 254) {
                    i2 = this.f4114k;
                    this.f4114k++;
                    if (i2 >= this.f4112i.length) {
                        m7215k();
                    }
                } else {
                    i2 = m7211g();
                }
                this.f4110g[i3] = (i4 & -256) | (i2 + 1);
            } else {
                i2--;
            }
            Bucket bucket = new Bucket(name, this.f4112i[i2]);
            this.f4112i[i2] = bucket;
            this.f4108e = Math.max(bucket.c, this.f4108e);
            if (this.f4108e > 255) {
                m7209e(255);
            }
        }
        i2 = this.f4110g.length;
        if (this.f4107d > (i2 >> 1)) {
            i3 = i2 >> 2;
            if (this.f4107d > i2 - i3) {
                this.f4116m = true;
            } else if (this.f4113j >= i3) {
                this.f4116m = true;
            }
        }
    }

    private void m7208e() {
        int i = 0;
        this.f4116m = false;
        this.f4118o = false;
        int length = this.f4110g.length;
        int i2 = length + length;
        if (i2 > 65536) {
            m7210f();
            return;
        }
        int i3;
        this.f4110g = new int[i2];
        this.f4109f = i2 - 1;
        Name[] nameArr = this.f4111h;
        this.f4111h = new Name[i2];
        i2 = 0;
        for (i3 = 0; i3 < length; i3++) {
            Name name = nameArr[i3];
            if (name != null) {
                i2++;
                int hashCode = name.hashCode();
                int i4 = this.f4109f & hashCode;
                this.f4111h[i4] = name;
                this.f4110g[i4] = hashCode << 8;
            }
        }
        int i5 = this.f4114k;
        if (i5 == 0) {
            this.f4108e = 0;
            return;
        }
        this.f4113j = 0;
        this.f4114k = 0;
        this.f4119p = false;
        Bucket[] bucketArr = this.f4112i;
        this.f4112i = new Bucket[bucketArr.length];
        int i6 = 0;
        i3 = i2;
        while (i6 < i5) {
            i2 = i3;
            Bucket bucket = bucketArr[i6];
            while (bucket != null) {
                length = i2 + 1;
                Name name2 = bucket.a;
                i2 = name2.hashCode();
                int i7 = this.f4109f & i2;
                int i8 = this.f4110g[i7];
                if (this.f4111h[i7] == null) {
                    this.f4110g[i7] = i2 << 8;
                    this.f4111h[i7] = name2;
                    i2 = i;
                } else {
                    this.f4113j++;
                    i2 = i8 & 255;
                    if (i2 == 0) {
                        if (this.f4114k <= 254) {
                            i2 = this.f4114k;
                            this.f4114k++;
                            if (i2 >= this.f4112i.length) {
                                m7215k();
                            }
                        } else {
                            i2 = m7211g();
                        }
                        this.f4110g[i7] = (i8 & -256) | (i2 + 1);
                    } else {
                        i2--;
                    }
                    Bucket bucket2 = new Bucket(name2, this.f4112i[i2]);
                    this.f4112i[i2] = bucket2;
                    i2 = Math.max(i, bucket2.c);
                }
                bucket = bucket.b;
                i = i2;
                i2 = length;
            }
            i6++;
            i3 = i2;
        }
        this.f4108e = i;
        if (i3 != this.f4107d) {
            throw new RuntimeException("Internal error: count after rehash " + i3 + "; should be " + this.f4107d);
        }
    }

    private void m7210f() {
        this.f4107d = 0;
        this.f4108e = 0;
        Arrays.fill(this.f4110g, 0);
        Arrays.fill(this.f4111h, null);
        Arrays.fill(this.f4112i, null);
        this.f4113j = 0;
        this.f4114k = 0;
    }

    private int m7211g() {
        Bucket[] bucketArr = this.f4112i;
        int i = Integer.MAX_VALUE;
        int i2 = -1;
        int i3 = 0;
        int i4 = this.f4114k;
        while (i3 < i4) {
            int i5 = bucketArr[i3].c;
            if (i5 >= i) {
                i5 = i;
            } else if (i5 == 1) {
                return i3;
            } else {
                i2 = i3;
            }
            i3++;
            i = i5;
        }
        return i2;
    }

    private void m7212h() {
        Object obj = this.f4110g;
        int length = this.f4110g.length;
        this.f4110g = new int[length];
        System.arraycopy(obj, 0, this.f4110g, 0, length);
        this.f4117n = false;
    }

    private void m7213i() {
        Object obj = this.f4112i;
        if (obj == null) {
            this.f4112i = new Bucket[32];
        } else {
            int length = obj.length;
            this.f4112i = new Bucket[length];
            System.arraycopy(obj, 0, this.f4112i, 0, length);
        }
        this.f4119p = false;
    }

    private void m7214j() {
        Object obj = this.f4111h;
        int length = obj.length;
        this.f4111h = new Name[length];
        System.arraycopy(obj, 0, this.f4111h, 0, length);
        this.f4118o = false;
    }

    private void m7215k() {
        Object obj = this.f4112i;
        int length = obj.length;
        this.f4112i = new Bucket[(length + length)];
        System.arraycopy(obj, 0, this.f4112i, 0, length);
    }

    private static Name m7197a(int i, String str, int i2, int i3) {
        if (i3 == 0) {
            return new Name1(str, i, i2);
        }
        return new Name2(str, i, i2, i3);
    }

    private static Name m7198a(int i, String str, int[] iArr, int i2) {
        if (i2 < 4) {
            switch (i2) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    return new Name1(str, i, iArr[0]);
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    return new Name2(str, i, iArr[0], iArr[1]);
                case 3:
                    return new Name3(str, i, iArr[0], iArr[1], iArr[2]);
            }
        }
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr2[i3] = iArr[i3];
        }
        return new NameN(str, i, iArr2, i2);
    }

    private void m7209e(int i) {
        throw new IllegalStateException("Longest collision chain in symbol table (of size " + this.f4107d + ") now exceeds maximum, " + i + " -- suspect a DoS attack based on hash collisions");
    }
}
