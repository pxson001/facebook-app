package com.google.common.hash;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.annotation.Nullable;

/* compiled from: bug_report_did_detach_screenshot */
public final class Murmur3_128HashFunction extends AbstractStreamingHashFunction implements Serializable {
    private final int seed;

    /* compiled from: bug_report_did_detach_screenshot */
    public final class Murmur3_128Hasher extends AbstractStreamingHashFunction$AbstractStreamingHasher {
        public long f7639a;
        public long f7640b;
        private int f7641c = 0;

        Murmur3_128Hasher(int i) {
            super(16);
            this.f7639a = (long) i;
            this.f7640b = (long) i;
        }

        protected final void mo1013a(ByteBuffer byteBuffer) {
            long j = byteBuffer.getLong();
            long j2 = byteBuffer.getLong();
            this.f7639a ^= m13801c(j);
            this.f7639a = Long.rotateLeft(this.f7639a, 27);
            this.f7639a += this.f7640b;
            this.f7639a = (this.f7639a * 5) + 1390208809;
            this.f7640b ^= m13802d(j2);
            this.f7640b = Long.rotateLeft(this.f7640b, 31);
            this.f7640b += this.f7639a;
            this.f7640b = (this.f7640b * 5) + 944331445;
            this.f7641c += 16;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected final void mo1015b(java.nio.ByteBuffer r15) {
            /*
            r14 = this;
            r10 = 32;
            r9 = 24;
            r8 = 16;
            r7 = 8;
            r2 = 0;
            r0 = r14.f7641c;
            r1 = r15.remaining();
            r0 = r0 + r1;
            r14.f7641c = r0;
            r0 = r15.remaining();
            switch(r0) {
                case 1: goto L_0x010f;
                case 2: goto L_0x010d;
                case 3: goto L_0x010b;
                case 4: goto L_0x0109;
                case 5: goto L_0x0107;
                case 6: goto L_0x0105;
                case 7: goto L_0x0095;
                case 8: goto L_0x0102;
                case 9: goto L_0x00ff;
                case 10: goto L_0x00fc;
                case 11: goto L_0x00f9;
                case 12: goto L_0x00f6;
                case 13: goto L_0x00f3;
                case 14: goto L_0x00f0;
                case 15: goto L_0x0022;
                default: goto L_0x001a;
            };
        L_0x001a:
            r0 = new java.lang.AssertionError;
            r1 = "Should never get here.";
            r0.<init>(r1);
            throw r0;
        L_0x0022:
            r0 = 14;
            r0 = r15.get(r0);
            r13 = r0 & 255;
            r0 = r13;
            r0 = (long) r0;
            r4 = 48;
            r0 = r0 << r4;
            r0 = r0 ^ r2;
        L_0x0030:
            r4 = 13;
            r4 = r15.get(r4);
            r4 = com.google.common.primitives.UnsignedBytes.m13821a(r4);
            r4 = (long) r4;
            r6 = 40;
            r4 = r4 << r6;
            r0 = r0 ^ r4;
        L_0x003f:
            r4 = 12;
            r4 = r15.get(r4);
            r4 = com.google.common.primitives.UnsignedBytes.m13821a(r4);
            r4 = (long) r4;
            r4 = r4 << r10;
            r0 = r0 ^ r4;
        L_0x004c:
            r4 = 11;
            r4 = r15.get(r4);
            r4 = com.google.common.primitives.UnsignedBytes.m13821a(r4);
            r4 = (long) r4;
            r4 = r4 << r9;
            r0 = r0 ^ r4;
        L_0x0059:
            r4 = 10;
            r4 = r15.get(r4);
            r4 = com.google.common.primitives.UnsignedBytes.m13821a(r4);
            r4 = (long) r4;
            r4 = r4 << r8;
            r0 = r0 ^ r4;
        L_0x0066:
            r4 = 9;
            r4 = r15.get(r4);
            r4 = com.google.common.primitives.UnsignedBytes.m13821a(r4);
            r4 = (long) r4;
            r4 = r4 << r7;
            r0 = r0 ^ r4;
        L_0x0073:
            r4 = r15.get(r7);
            r4 = com.google.common.primitives.UnsignedBytes.m13821a(r4);
            r4 = (long) r4;
            r0 = r0 ^ r4;
        L_0x007d:
            r4 = r15.getLong();
            r2 = r2 ^ r4;
        L_0x0082:
            r4 = r14.f7639a;
            r2 = m13801c(r2);
            r2 = r2 ^ r4;
            r14.f7639a = r2;
            r2 = r14.f7640b;
            r0 = m13802d(r0);
            r0 = r0 ^ r2;
            r14.f7640b = r0;
            return;
        L_0x0095:
            r0 = 6;
            r0 = r15.get(r0);
            r0 = com.google.common.primitives.UnsignedBytes.m13821a(r0);
            r0 = (long) r0;
            r4 = 48;
            r0 = r0 << r4;
            r0 = r0 ^ r2;
        L_0x00a3:
            r4 = 5;
            r4 = r15.get(r4);
            r4 = com.google.common.primitives.UnsignedBytes.m13821a(r4);
            r4 = (long) r4;
            r6 = 40;
            r4 = r4 << r6;
            r0 = r0 ^ r4;
        L_0x00b1:
            r4 = 4;
            r4 = r15.get(r4);
            r4 = com.google.common.primitives.UnsignedBytes.m13821a(r4);
            r4 = (long) r4;
            r4 = r4 << r10;
            r0 = r0 ^ r4;
        L_0x00bd:
            r4 = 3;
            r4 = r15.get(r4);
            r4 = com.google.common.primitives.UnsignedBytes.m13821a(r4);
            r4 = (long) r4;
            r4 = r4 << r9;
            r0 = r0 ^ r4;
        L_0x00c9:
            r4 = 2;
            r4 = r15.get(r4);
            r4 = com.google.common.primitives.UnsignedBytes.m13821a(r4);
            r4 = (long) r4;
            r4 = r4 << r8;
            r0 = r0 ^ r4;
        L_0x00d5:
            r4 = 1;
            r4 = r15.get(r4);
            r4 = com.google.common.primitives.UnsignedBytes.m13821a(r4);
            r4 = (long) r4;
            r4 = r4 << r7;
            r0 = r0 ^ r4;
        L_0x00e1:
            r4 = 0;
            r4 = r15.get(r4);
            r4 = com.google.common.primitives.UnsignedBytes.m13821a(r4);
            r4 = (long) r4;
            r0 = r0 ^ r4;
            r11 = r2;
            r2 = r0;
            r0 = r11;
            goto L_0x0082;
        L_0x00f0:
            r0 = r2;
            goto L_0x0030;
        L_0x00f3:
            r0 = r2;
            goto L_0x003f;
        L_0x00f6:
            r0 = r2;
            goto L_0x004c;
        L_0x00f9:
            r0 = r2;
            goto L_0x0059;
        L_0x00fc:
            r0 = r2;
            goto L_0x0066;
        L_0x00ff:
            r0 = r2;
            goto L_0x0073;
        L_0x0102:
            r0 = r2;
            goto L_0x007d;
        L_0x0105:
            r0 = r2;
            goto L_0x00a3;
        L_0x0107:
            r0 = r2;
            goto L_0x00b1;
        L_0x0109:
            r0 = r2;
            goto L_0x00bd;
        L_0x010b:
            r0 = r2;
            goto L_0x00c9;
        L_0x010d:
            r0 = r2;
            goto L_0x00d5;
        L_0x010f:
            r0 = r2;
            goto L_0x00e1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.hash.Murmur3_128HashFunction.Murmur3_128Hasher.b(java.nio.ByteBuffer):void");
        }

        public final HashCode mo1014b() {
            this.f7639a ^= (long) this.f7641c;
            this.f7640b ^= (long) this.f7641c;
            this.f7639a += this.f7640b;
            this.f7640b += this.f7639a;
            this.f7639a = m13800b(this.f7639a);
            this.f7640b = m13800b(this.f7640b);
            this.f7639a += this.f7640b;
            this.f7640b += this.f7639a;
            return HashCode.a(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f7639a).putLong(this.f7640b).array());
        }

        private static long m13800b(long j) {
            long j2 = ((j >>> 33) ^ j) * -49064778989728563L;
            j2 = (j2 ^ (j2 >>> 33)) * -4265267296055464877L;
            return j2 ^ (j2 >>> 33);
        }

        public static long m13801c(long j) {
            return Long.rotateLeft(-8663945395140668459L * j, 31) * 5545529020109919103L;
        }

        public static long m13802d(long j) {
            return Long.rotateLeft(5545529020109919103L * j, 33) * -8663945395140668459L;
        }
    }

    public Murmur3_128HashFunction(int i) {
        this.seed = i;
    }

    public final Hasher m13806a() {
        return new Murmur3_128Hasher(this.seed);
    }

    public final String toString() {
        return "Hashing.murmur3_128(" + this.seed + ")";
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Murmur3_128HashFunction)) {
            return false;
        }
        if (this.seed == ((Murmur3_128HashFunction) obj).seed) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return getClass().hashCode() ^ this.seed;
    }
}
