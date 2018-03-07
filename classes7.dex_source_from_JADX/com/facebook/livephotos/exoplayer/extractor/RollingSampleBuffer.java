package com.facebook.livephotos.exoplayer.extractor;

import com.facebook.livephotos.exoplayer.SampleHolder;
import com.facebook.livephotos.exoplayer.upstream.Allocation;
import com.facebook.livephotos.exoplayer.upstream.DefaultAllocator;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingDeque;

/* compiled from: page_service_card_impression */
public final class RollingSampleBuffer {
    public final DefaultAllocator f7041a;
    public final int f7042b;
    public final InfoQueue f7043c = new InfoQueue();
    public final LinkedBlockingDeque<Allocation> f7044d = new LinkedBlockingDeque();
    private final SampleExtrasHolder f7045e = new SampleExtrasHolder();
    private final ParsableByteArray f7046f = new ParsableByteArray(32);
    public long f7047g;
    public long f7048h;
    public Allocation f7049i;
    public int f7050j = this.f7042b;

    /* compiled from: page_service_card_impression */
    public final class InfoQueue {
        private int f7029a = 1000;
        private long[] f7030b = new long[this.f7029a];
        private int[] f7031c = new int[this.f7029a];
        private int[] f7032d = new int[this.f7029a];
        private long[] f7033e = new long[this.f7029a];
        private byte[][] f7034f = new byte[this.f7029a][];
        public int f7035g;
        public int f7036h;
        public int f7037i;
        public int f7038j;

        public final synchronized boolean m8901a(SampleHolder sampleHolder, SampleExtrasHolder sampleExtrasHolder) {
            boolean z;
            if (this.f7035g == 0) {
                z = false;
            } else {
                sampleHolder.f6873e = this.f7033e[this.f7037i];
                sampleHolder.f6871c = this.f7031c[this.f7037i];
                sampleHolder.f6872d = this.f7032d[this.f7037i];
                sampleExtrasHolder.f7039a = this.f7030b[this.f7037i];
                sampleExtrasHolder.f7040b = this.f7034f[this.f7037i];
                z = true;
            }
            return z;
        }

        public final synchronized long m8902b() {
            long j;
            this.f7035g--;
            int i = this.f7037i;
            this.f7037i = i + 1;
            this.f7036h++;
            if (this.f7037i == this.f7029a) {
                this.f7037i = 0;
            }
            if (this.f7035g > 0) {
                j = this.f7030b[this.f7037i];
            } else {
                j = this.f7030b[i] + ((long) this.f7031c[i]);
            }
            return j;
        }

        public final synchronized long m8899a(long j) {
            long j2 = -1;
            synchronized (this) {
                if (this.f7035g != 0 && j >= this.f7033e[this.f7037i]) {
                    if (j <= this.f7033e[(this.f7038j == 0 ? this.f7029a : this.f7038j) - 1]) {
                        int i = 0;
                        int i2 = this.f7037i;
                        int i3 = -1;
                        while (i2 != this.f7038j && this.f7033e[i2] <= j) {
                            if ((this.f7032d[i2] & 1) != 0) {
                                i3 = i;
                            }
                            i2 = (i2 + 1) % this.f7029a;
                            i++;
                        }
                        if (i3 != -1) {
                            this.f7035g -= i3;
                            this.f7037i = (this.f7037i + i3) % this.f7029a;
                            this.f7036h += i3;
                            j2 = this.f7030b[this.f7037i];
                        }
                    }
                }
            }
            return j2;
        }

        public final synchronized void m8900a(long j, int i, long j2, int i2, byte[] bArr) {
            this.f7033e[this.f7038j] = j;
            this.f7030b[this.f7038j] = j2;
            this.f7031c[this.f7038j] = i2;
            this.f7032d[this.f7038j] = i;
            this.f7034f[this.f7038j] = bArr;
            this.f7035g++;
            if (this.f7035g == this.f7029a) {
                int i3 = this.f7029a + 1000;
                Object obj = new long[i3];
                Object obj2 = new long[i3];
                Object obj3 = new int[i3];
                Object obj4 = new int[i3];
                Object obj5 = new byte[i3][];
                int i4 = this.f7029a - this.f7037i;
                System.arraycopy(this.f7030b, this.f7037i, obj, 0, i4);
                System.arraycopy(this.f7033e, this.f7037i, obj2, 0, i4);
                System.arraycopy(this.f7032d, this.f7037i, obj3, 0, i4);
                System.arraycopy(this.f7031c, this.f7037i, obj4, 0, i4);
                System.arraycopy(this.f7034f, this.f7037i, obj5, 0, i4);
                int i5 = this.f7037i;
                System.arraycopy(this.f7030b, 0, obj, i4, i5);
                System.arraycopy(this.f7033e, 0, obj2, i4, i5);
                System.arraycopy(this.f7032d, 0, obj3, i4, i5);
                System.arraycopy(this.f7031c, 0, obj4, i4, i5);
                System.arraycopy(this.f7034f, 0, obj5, i4, i5);
                this.f7030b = obj;
                this.f7033e = obj2;
                this.f7032d = obj3;
                this.f7031c = obj4;
                this.f7034f = obj5;
                this.f7037i = 0;
                this.f7038j = this.f7029a;
                this.f7035g = this.f7029a;
                this.f7029a = i3;
            } else {
                this.f7038j++;
                if (this.f7038j == this.f7029a) {
                    this.f7038j = 0;
                }
            }
        }
    }

    /* compiled from: page_service_card_impression */
    final class SampleExtrasHolder {
        public long f7039a;
        public byte[] f7040b;
    }

    public RollingSampleBuffer(DefaultAllocator defaultAllocator) {
        this.f7041a = defaultAllocator;
        this.f7042b = defaultAllocator.f7641a;
    }

    private static void m8908b(ParsableByteArray parsableByteArray, int i) {
        if (parsableByteArray.f7733c < i) {
            parsableByteArray.m9334a(new byte[i], i);
        }
    }

    public final boolean m8913a(SampleHolder sampleHolder) {
        return this.f7043c.m8901a(sampleHolder, this.f7045e);
    }

    public final void m8914b() {
        m8907b(this.f7043c.m8902b());
    }

    public final boolean m8912a(long j) {
        long a = this.f7043c.m8899a(j);
        if (a == -1) {
            return false;
        }
        m8907b(a);
        return true;
    }

    public final boolean m8915b(SampleHolder sampleHolder) {
        if (!this.f7043c.m8901a(sampleHolder, this.f7045e)) {
            return false;
        }
        if (sampleHolder.m8750a()) {
            m8906a(sampleHolder, this.f7045e);
        }
        sampleHolder.m8749a(sampleHolder.f6871c);
        m8904a(this.f7045e.f7039a, sampleHolder.f6870b, sampleHolder.f6871c);
        m8907b(this.f7043c.m8902b());
        return true;
    }

    private void m8906a(SampleHolder sampleHolder, SampleExtrasHolder sampleExtrasHolder) {
        long j;
        int i = 0;
        long j2 = sampleExtrasHolder.f7039a;
        m8905a(j2, this.f7046f.f7731a, 1);
        long j3 = 1 + j2;
        byte b = this.f7046f.f7731a[0];
        int i2 = (b & 128) != 0 ? 1 : 0;
        int i3 = b & 127;
        if (sampleHolder.f6869a.f6699a == null) {
            sampleHolder.f6869a.f6699a = new byte[16];
        }
        m8905a(j3, sampleHolder.f6869a.f6699a, i3);
        j3 += (long) i3;
        if (i2 != 0) {
            m8905a(j3, this.f7046f.f7731a, 2);
            j3 += 2;
            this.f7046f.m9337b(0);
            i3 = this.f7046f.m9344g();
            j = j3;
        } else {
            i3 = 1;
            j = j3;
        }
        int[] iArr = sampleHolder.f6869a.f6702d;
        if (iArr == null || iArr.length < i3) {
            iArr = new int[i3];
        }
        int[] iArr2 = sampleHolder.f6869a.f6703e;
        if (iArr2 == null || iArr2.length < i3) {
            iArr2 = new int[i3];
        }
        if (i2 != 0) {
            i2 = i3 * 6;
            m8908b(this.f7046f, i2);
            m8905a(j, this.f7046f.f7731a, i2);
            j += (long) i2;
            this.f7046f.m9337b(0);
            while (i < i3) {
                iArr[i] = this.f7046f.m9344g();
                iArr2[i] = this.f7046f.m9355s();
                i++;
            }
        } else {
            iArr[0] = 0;
            iArr2[0] = sampleHolder.f6871c - ((int) (j - sampleExtrasHolder.f7039a));
        }
        sampleHolder.f6869a.m8575a(i3, iArr, iArr2, sampleExtrasHolder.f7040b, sampleHolder.f6869a.f6699a, 1);
        i2 = (int) (j - sampleExtrasHolder.f7039a);
        sampleExtrasHolder.f7039a += (long) i2;
        sampleHolder.f6871c -= i2;
    }

    private void m8904a(long j, ByteBuffer byteBuffer, int i) {
        while (i > 0) {
            m8907b(j);
            int i2 = (int) (j - this.f7047g);
            int min = Math.min(i, this.f7042b - i2);
            Allocation allocation = (Allocation) this.f7044d.peek();
            byteBuffer.put(allocation.f7620a, allocation.m9252a(i2), min);
            j += (long) min;
            i -= min;
        }
    }

    private void m8905a(long j, byte[] bArr, int i) {
        int i2 = 0;
        while (i2 < i) {
            m8907b(j);
            int i3 = (int) (j - this.f7047g);
            int min = Math.min(i - i2, this.f7042b - i3);
            Allocation allocation = (Allocation) this.f7044d.peek();
            System.arraycopy(allocation.f7620a, allocation.m9252a(i3), bArr, i2, min);
            j += (long) min;
            i2 += min;
        }
    }

    private void m8907b(long j) {
        int i = ((int) (j - this.f7047g)) / this.f7042b;
        for (int i2 = 0; i2 < i; i2++) {
            this.f7041a.m9265a((Allocation) this.f7044d.remove());
            this.f7047g += (long) this.f7042b;
        }
    }

    public final long m8916c() {
        return this.f7048h;
    }

    public final int m8909a(DefaultExtractorInput defaultExtractorInput, int i, boolean z) {
        int a = defaultExtractorInput.m8837a(this.f7049i.f7620a, this.f7049i.m9252a(this.f7050j), m8903a(i));
        if (a != -1) {
            this.f7050j += a;
            this.f7048h += (long) a;
            return a;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public final void m8911a(ParsableByteArray parsableByteArray, int i) {
        while (i > 0) {
            int a = m8903a(i);
            parsableByteArray.m9335a(this.f7049i.f7620a, this.f7049i.m9252a(this.f7050j), a);
            this.f7050j += a;
            this.f7048h += (long) a;
            i -= a;
        }
    }

    public final void m8910a(long j, int i, long j2, int i2, byte[] bArr) {
        this.f7043c.m8900a(j, i, j2, i2, bArr);
    }

    private int m8903a(int i) {
        if (this.f7050j == this.f7042b) {
            this.f7050j = 0;
            this.f7049i = this.f7041a.m9263a();
            this.f7044d.add(this.f7049i);
        }
        return Math.min(i, this.f7042b - this.f7050j);
    }
}
