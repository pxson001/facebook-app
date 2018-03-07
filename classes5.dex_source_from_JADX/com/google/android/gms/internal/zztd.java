package com.google.android.gms.internal;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zztd {
    public final ByteBuffer f6972a;

    public class zza extends IOException {
        zza(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private zztd(ByteBuffer byteBuffer) {
        this.f6972a = byteBuffer;
        this.f6972a.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zztd(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    public static int m12955a(int i) {
        return i >= 0 ? m12975c(i) : 10;
    }

    private static int m12956a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < '') {
            i++;
        }
        int i2 = i;
        i = length;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt >= 'ࠀ') {
                i += m12957a(charSequence, i2);
                break;
            }
            i2++;
            i = ((127 - charAt) >>> 31) + i;
        }
        if (i >= length) {
            return i;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i) + 4294967296L));
    }

    private static int m12957a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        int i3 = i;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt < 'ࠀ') {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if ('?' <= charAt && charAt <= '?') {
                    if (Character.codePointAt(charSequence, i3) < 65536) {
                        throw new IllegalArgumentException("Unpaired surrogate at index " + i3);
                    }
                    i3++;
                }
            }
            i3++;
        }
        return i2;
    }

    private static int m12958a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        int i4 = i + i2;
        while (i3 < length && i3 + i < i4) {
            char charAt = charSequence.charAt(i3);
            if (charAt >= '') {
                break;
            }
            bArr[i + i3] = (byte) charAt;
            i3++;
        }
        if (i3 == length) {
            return i + length;
        }
        int i5 = i + i3;
        while (i3 < length) {
            int i6;
            char charAt2 = charSequence.charAt(i3);
            if (charAt2 < '' && i5 < i4) {
                i6 = i5 + 1;
                bArr[i5] = (byte) charAt2;
            } else if (charAt2 < 'ࠀ' && i5 <= i4 - 2) {
                r6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 6) | 960);
                i6 = r6 + 1;
                bArr[r6] = (byte) ((charAt2 & 63) | 128);
            } else if ((charAt2 < '?' || '?' < charAt2) && i5 <= i4 - 3) {
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 12) | 480);
                i5 = i6 + 1;
                bArr[i6] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 & 63) | 128);
            } else if (i5 <= i4 - 4) {
                if (i3 + 1 != charSequence.length()) {
                    i3++;
                    charAt = charSequence.charAt(i3);
                    if (Character.isSurrogatePair(charAt2, charAt)) {
                        int toCodePoint = Character.toCodePoint(charAt2, charAt);
                        i6 = i5 + 1;
                        bArr[i5] = (byte) ((toCodePoint >>> 18) | 240);
                        i5 = i6 + 1;
                        bArr[i6] = (byte) (((toCodePoint >>> 12) & 63) | 128);
                        r6 = i5 + 1;
                        bArr[i5] = (byte) (((toCodePoint >>> 6) & 63) | 128);
                        i6 = r6 + 1;
                        bArr[r6] = (byte) ((toCodePoint & 63) | 128);
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i3 - 1));
            } else if ('?' > charAt2 || charAt2 > '?' || (i3 + 1 != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i3 + 1)))) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i5);
            } else {
                throw new IllegalArgumentException("Unpaired surrogate at index " + i3);
            }
            i3++;
            i5 = i6;
        }
        return i5;
    }

    public static int m12959a(String str) {
        int a = m12956a((CharSequence) str);
        return a + m12975c(a);
    }

    public static zztd m12960a(byte[] bArr) {
        return m12961a(bArr, 0, bArr.length);
    }

    public static zztd m12961a(byte[] bArr, int i, int i2) {
        return new zztd(bArr, i, i2);
    }

    private void m12962a(byte b) {
        if (this.f6972a.hasRemaining()) {
            this.f6972a.put(b);
            return;
        }
        throw new zza(this.f6972a.position(), this.f6972a.limit());
    }

    private void m12963a(double d) {
        m12984g(Double.doubleToLongBits(d));
    }

    private void m12964a(float f) {
        m12987i(Float.floatToIntBits(f));
    }

    private static void m12965a(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(m12958a(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (Throwable e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            m12972b(charSequence, byteBuffer);
        }
    }

    private void m12966a(boolean z) {
        m12983g(z ? 1 : 0);
    }

    public static int m12967b(int i, float f) {
        return m12985h(i) + 4;
    }

    public static int m12968b(int i, String str) {
        return m12985h(i) + m12959a(str);
    }

    public static int m12969b(int i, boolean z) {
        return m12985h(i) + 1;
    }

    public static int m12970b(int i, byte[] bArr) {
        return m12985h(i) + m12971b(bArr);
    }

    public static int m12971b(byte[] bArr) {
        return m12975c(bArr.length) + bArr.length;
    }

    private static void m12972b(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < '') {
                byteBuffer.put((byte) charAt);
            } else if (charAt < 'ࠀ') {
                byteBuffer.put((byte) ((charAt >>> 6) | 960));
                byteBuffer.put((byte) ((charAt & 63) | 128));
            } else if (charAt < '?' || '?' < charAt) {
                byteBuffer.put((byte) ((charAt >>> 12) | 480));
                byteBuffer.put((byte) (((charAt >>> 6) & 63) | 128));
                byteBuffer.put((byte) ((charAt & 63) | 128));
            } else {
                if (i + 1 != charSequence.length()) {
                    i++;
                    char charAt2 = charSequence.charAt(i);
                    if (Character.isSurrogatePair(charAt, charAt2)) {
                        int toCodePoint = Character.toCodePoint(charAt, charAt2);
                        byteBuffer.put((byte) ((toCodePoint >>> 18) | 240));
                        byteBuffer.put((byte) (((toCodePoint >>> 12) & 63) | 128));
                        byteBuffer.put((byte) (((toCodePoint >>> 6) & 63) | 128));
                        byteBuffer.put((byte) ((toCodePoint & 63) | 128));
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i - 1));
            }
            i++;
        }
    }

    private void m12973b(String str) {
        try {
            int c = m12975c(str.length());
            if (c == m12975c(str.length() * 3)) {
                int position = this.f6972a.position();
                if (this.f6972a.remaining() < c) {
                    throw new zza(c + position, this.f6972a.limit());
                }
                this.f6972a.position(position + c);
                m12965a((CharSequence) str, this.f6972a);
                int position2 = this.f6972a.position();
                this.f6972a.position(position);
                m12999b((position2 - position) - c);
                this.f6972a.position(position2);
                return;
            }
            m12999b(m12956a((CharSequence) str));
            m12965a((CharSequence) str, this.f6972a);
        } catch (Throwable e) {
            zza com_google_android_gms_internal_zztd_zza = new zza(this.f6972a.position(), this.f6972a.limit());
            com_google_android_gms_internal_zztd_zza.initCause(e);
            throw com_google_android_gms_internal_zztd_zza;
        }
    }

    private void m12974b(byte[] bArr, int i, int i2) {
        if (this.f6972a.remaining() >= i2) {
            this.f6972a.put(bArr, i, i2);
            return;
        }
        throw new zza(this.f6972a.position(), this.f6972a.limit());
    }

    public static int m12975c(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int m12976c(int i, int i2) {
        return m12985h(i) + m12955a(i2);
    }

    public static int m12977c(int i, long j) {
        return m12985h(i) + m12982f(j);
    }

    public static int m12978c(int i, zztk com_google_android_gms_internal_zztk) {
        int h = m12985h(i);
        int d = com_google_android_gms_internal_zztk.m12903d();
        return h + (d + m12975c(d));
    }

    private void m12979c(long j) {
        m12981e(m12986h(j));
    }

    private void m12980d(int i) {
        if (i >= 0) {
            m12999b(i);
        } else {
            m12981e((long) i);
        }
    }

    private void m12981e(long j) {
        while ((-128 & j) != 0) {
            m12983g((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m12983g((int) j);
    }

    public static int m12982f(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    private void m12983g(int i) {
        m12962a((byte) i);
    }

    private void m12984g(long j) {
        if (this.f6972a.remaining() < 8) {
            throw new zza(this.f6972a.position(), this.f6972a.limit());
        }
        this.f6972a.putLong(j);
    }

    public static int m12985h(int i) {
        return m12975c(zztn.m13045a(i, 0));
    }

    public static long m12986h(long j) {
        return (j << 1) ^ (j >> 63);
    }

    private void m12987i(int i) {
        if (this.f6972a.remaining() < 4) {
            throw new zza(this.f6972a.position(), this.f6972a.limit());
        }
        this.f6972a.putInt(i);
    }

    public static int m12988j(int i) {
        return (i << 1) ^ (i >> 31);
    }

    public final void m12989a() {
        if (this.f6972a.remaining() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void m12990a(int i, double d) {
        m13003e(i, 1);
        m12963a(d);
    }

    public final void m12991a(int i, float f) {
        m13003e(i, 5);
        m12964a(f);
    }

    public final void m12992a(int i, int i2) {
        m13003e(i, 0);
        m12980d(i2);
    }

    public final void m12993a(int i, long j) {
        m13003e(i, 0);
        m12981e(j);
    }

    public final void m12994a(int i, zztk com_google_android_gms_internal_zztk) {
        m13003e(i, 2);
        m13001b(com_google_android_gms_internal_zztk);
    }

    public final void m12995a(int i, String str) {
        m13003e(i, 2);
        m12973b(str);
    }

    public final void m12996a(int i, boolean z) {
        m13003e(i, 0);
        m12966a(z);
    }

    public final void m12997a(int i, byte[] bArr) {
        m13003e(i, 2);
        m12999b(bArr.length);
        m13002c(bArr);
    }

    public final void m12998a(zztk com_google_android_gms_internal_zztk) {
        com_google_android_gms_internal_zztk.mo845a(this);
    }

    public final void m12999b(int i) {
        while ((i & -128) != 0) {
            m12983g((i & 127) | 128);
            i >>>= 7;
        }
        m12983g(i);
    }

    public final void m13000b(int i, long j) {
        m13003e(i, 0);
        m12979c(j);
    }

    public final void m13001b(zztk com_google_android_gms_internal_zztk) {
        if (com_google_android_gms_internal_zztk.f6915b < 0) {
            com_google_android_gms_internal_zztk.m12903d();
        }
        m12999b(com_google_android_gms_internal_zztk.f6915b);
        com_google_android_gms_internal_zztk.mo845a(this);
    }

    public final void m13002c(byte[] bArr) {
        m12974b(bArr, 0, bArr.length);
    }

    public final void m13003e(int i, int i2) {
        m12999b(zztn.m13045a(i, i2));
    }
}
