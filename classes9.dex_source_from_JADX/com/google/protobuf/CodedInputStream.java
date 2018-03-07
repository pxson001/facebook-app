package com.google.protobuf;

import com.google.protobuf.MessageLite.Builder;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: android-app scheme is required. */
public final class CodedInputStream {
    private final byte[] f20602a;
    private int f20603b;
    private int f20604c;
    private int f20605d;
    private final InputStream f20606e;
    private int f20607f;
    private int f20608g;
    private int f20609h;
    private int f20610i;
    private int f20611j;
    private int f20612k;

    public static CodedInputStream m20191a(byte[] bArr) {
        return m20192a(bArr, 0, bArr.length);
    }

    public static CodedInputStream m20192a(byte[] bArr, int i, int i2) {
        CodedInputStream codedInputStream = new CodedInputStream(bArr, i, i2);
        try {
            codedInputStream.m20210c(i2);
            return codedInputStream;
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public final int m20202a() {
        if (m20200y()) {
            this.f20607f = 0;
            return 0;
        }
        this.f20607f = m20225r();
        if ((this.f20607f >>> 3) != 0) {
            return this.f20607f;
        }
        throw new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
    }

    public final void m20204a(int i) {
        if (this.f20607f != i) {
            throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final boolean m20208b(int i) {
        switch (i & 7) {
            case 0:
                m20214f();
                return true;
            case 1:
                m20198w();
                return true;
            case 2:
                m20195g(m20225r());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                m20197v();
                return true;
            default:
                throw InvalidProtocolBufferException.m21372g();
        }
        int a;
        do {
            a = m20202a();
            if (a != 0) {
            }
            m20204a(WireFormat.m21527a(i >>> 3, 4));
            return true;
        } while (m20208b(a));
        m20204a(WireFormat.m21527a(i >>> 3, 4));
        return true;
    }

    public final double m20207b() {
        return Double.longBitsToDouble(m20198w());
    }

    public final float m20209c() {
        return Float.intBitsToFloat(m20197v());
    }

    public final long m20211d() {
        return m20196u();
    }

    public final long m20213e() {
        return m20196u();
    }

    public final int m20214f() {
        return m20225r();
    }

    public final long m20215g() {
        return m20198w();
    }

    public final int m20216h() {
        return m20197v();
    }

    public final boolean m20217i() {
        return m20225r() != 0;
    }

    public final String m20218j() {
        int r = m20225r();
        if (r > this.f20603b - this.f20605d || r <= 0) {
            return new String(m20194f(r), "UTF-8");
        }
        String str = new String(this.f20602a, this.f20605d, r, "UTF-8");
        this.f20605d = r + this.f20605d;
        return str;
    }

    public final void m20205a(int i, Builder builder, ExtensionRegistryLite extensionRegistryLite) {
        if (this.f20610i >= this.f20611j) {
            throw InvalidProtocolBufferException.m21373h();
        }
        this.f20610i++;
        builder.mo840c(this, extensionRegistryLite);
        m20204a(WireFormat.m21527a(i, 4));
        this.f20610i--;
    }

    public final void m20206a(Builder builder, ExtensionRegistryLite extensionRegistryLite) {
        int r = m20225r();
        if (this.f20610i >= this.f20611j) {
            throw InvalidProtocolBufferException.m21373h();
        }
        r = m20210c(r);
        this.f20610i++;
        builder.mo840c(this, extensionRegistryLite);
        m20204a(0);
        this.f20610i--;
        m20212d(r);
    }

    public final <T extends MessageLite> T m20203a(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) {
        int r = m20225r();
        if (this.f20610i >= this.f20611j) {
            throw InvalidProtocolBufferException.m21373h();
        }
        int c = m20210c(r);
        this.f20610i++;
        MessageLite messageLite = (MessageLite) parser.mo859a(this, extensionRegistryLite);
        m20204a(0);
        this.f20610i--;
        m20212d(c);
        return messageLite;
    }

    public final ByteString m20219k() {
        int r = m20225r();
        if (r == 0) {
            return ByteString.f20600a;
        }
        if (r > this.f20603b - this.f20605d || r <= 0) {
            return ByteString.m20174a(m20194f(r));
        }
        ByteString a = ByteString.m20175a(this.f20602a, this.f20605d, r);
        this.f20605d = r + this.f20605d;
        return a;
    }

    public final int m20220l() {
        return m20225r();
    }

    public final int m20221m() {
        return m20225r();
    }

    public final int m20222n() {
        return m20197v();
    }

    public final long m20223o() {
        return m20198w();
    }

    public final long m20224q() {
        long u = m20196u();
        return (u >>> 1) ^ (-(1 & u));
    }

    public final int m20225r() {
        byte z = m20201z();
        if (z >= (byte) 0) {
            return z;
        }
        int i = z & 127;
        byte z2 = m20201z();
        if (z2 >= (byte) 0) {
            return i | (z2 << 7);
        }
        i |= (z2 & 127) << 7;
        z2 = m20201z();
        if (z2 >= (byte) 0) {
            return i | (z2 << 14);
        }
        i |= (z2 & 127) << 14;
        z2 = m20201z();
        if (z2 >= (byte) 0) {
            return i | (z2 << 21);
        }
        i |= (z2 & 127) << 21;
        z2 = m20201z();
        i |= z2 << 28;
        if (z2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (m20201z() >= (byte) 0) {
                return i;
            }
        }
        throw InvalidProtocolBufferException.m21371d();
    }

    private long m20196u() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte z = m20201z();
            j |= ((long) (z & 127)) << i;
            if ((z & 128) == 0) {
                return j;
            }
        }
        throw InvalidProtocolBufferException.m21371d();
    }

    private int m20197v() {
        return (((m20201z() & 255) | ((m20201z() & 255) << 8)) | ((m20201z() & 255) << 16)) | ((m20201z() & 255) << 24);
    }

    private long m20198w() {
        byte z = m20201z();
        byte z2 = m20201z();
        return ((((((((((long) z2) & 255) << 8) | (((long) z) & 255)) | ((((long) m20201z()) & 255) << 16)) | ((((long) m20201z()) & 255) << 24)) | ((((long) m20201z()) & 255) << 32)) | ((((long) m20201z()) & 255) << 40)) | ((((long) m20201z()) & 255) << 48)) | ((((long) m20201z()) & 255) << 56);
    }

    private CodedInputStream(byte[] bArr, int i, int i2) {
        this.f20609h = Integer.MAX_VALUE;
        this.f20611j = 64;
        this.f20612k = 67108864;
        this.f20602a = bArr;
        this.f20603b = i + i2;
        this.f20605d = i;
        this.f20608g = -i;
        this.f20606e = null;
    }

    public CodedInputStream(InputStream inputStream) {
        this.f20609h = Integer.MAX_VALUE;
        this.f20611j = 64;
        this.f20612k = 67108864;
        this.f20602a = new byte[4096];
        this.f20603b = 0;
        this.f20605d = 0;
        this.f20608g = 0;
        this.f20606e = inputStream;
    }

    public final int m20210c(int i) {
        if (i < 0) {
            throw InvalidProtocolBufferException.m21370c();
        }
        int i2 = (this.f20608g + this.f20605d) + i;
        int i3 = this.f20609h;
        if (i2 > i3) {
            throw InvalidProtocolBufferException.m21369b();
        }
        this.f20609h = i2;
        m20199x();
        return i3;
    }

    private void m20199x() {
        this.f20603b += this.f20604c;
        int i = this.f20608g + this.f20603b;
        if (i > this.f20609h) {
            this.f20604c = i - this.f20609h;
            this.f20603b -= this.f20604c;
            return;
        }
        this.f20604c = 0;
    }

    public final void m20212d(int i) {
        this.f20609h = i;
        m20199x();
    }

    public final int m20226s() {
        if (this.f20609h == Integer.MAX_VALUE) {
            return -1;
        }
        return this.f20609h - (this.f20608g + this.f20605d);
    }

    private boolean m20200y() {
        return this.f20605d == this.f20603b && !m20193a(false);
    }

    private boolean m20193a(boolean z) {
        if (this.f20605d < this.f20603b) {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        } else if (this.f20608g + this.f20603b != this.f20609h) {
            this.f20608g += this.f20603b;
            this.f20605d = 0;
            this.f20603b = this.f20606e == null ? -1 : this.f20606e.read(this.f20602a);
            if (this.f20603b == 0 || this.f20603b < -1) {
                throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.f20603b + "\nThe InputStream implementation is buggy.");
            } else if (this.f20603b == -1) {
                this.f20603b = 0;
                if (!z) {
                    return false;
                }
                throw InvalidProtocolBufferException.m21369b();
            } else {
                m20199x();
                int i = (this.f20608g + this.f20603b) + this.f20604c;
                if (i <= this.f20612k && i >= 0) {
                    return true;
                }
                throw new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
            }
        } else if (!z) {
            return false;
        } else {
            throw InvalidProtocolBufferException.m21369b();
        }
    }

    private byte m20201z() {
        if (this.f20605d == this.f20603b) {
            m20193a(true);
        }
        byte[] bArr = this.f20602a;
        int i = this.f20605d;
        this.f20605d = i + 1;
        return bArr[i];
    }

    private byte[] m20194f(int i) {
        if (i < 0) {
            throw InvalidProtocolBufferException.m21370c();
        } else if ((this.f20608g + this.f20605d) + i > this.f20609h) {
            m20195g((this.f20609h - this.f20608g) - this.f20605d);
            throw InvalidProtocolBufferException.m21369b();
        } else if (i <= this.f20603b - this.f20605d) {
            Object obj = new byte[i];
            System.arraycopy(this.f20602a, this.f20605d, obj, 0, i);
            this.f20605d += i;
            return obj;
        } else if (i < 4096) {
            Object obj2 = new byte[i];
            r0 = this.f20603b - this.f20605d;
            System.arraycopy(this.f20602a, this.f20605d, obj2, 0, r0);
            this.f20605d = this.f20603b;
            m20193a(true);
            while (i - r0 > this.f20603b) {
                System.arraycopy(this.f20602a, 0, obj2, r0, this.f20603b);
                r0 += this.f20603b;
                this.f20605d = this.f20603b;
                m20193a(true);
            }
            System.arraycopy(this.f20602a, 0, obj2, r0, i - r0);
            this.f20605d = i - r0;
            return obj2;
        } else {
            int i2;
            int i3 = this.f20605d;
            int i4 = this.f20603b;
            this.f20608g += this.f20603b;
            this.f20605d = 0;
            this.f20603b = 0;
            r0 = i - (i4 - i3);
            List<byte[]> arrayList = new ArrayList();
            int i5 = r0;
            while (i5 > 0) {
                Object obj3 = new byte[Math.min(i5, 4096)];
                r0 = 0;
                while (r0 < obj3.length) {
                    if (this.f20606e == null) {
                        i2 = -1;
                    } else {
                        i2 = this.f20606e.read(obj3, r0, obj3.length - r0);
                    }
                    if (i2 == -1) {
                        throw InvalidProtocolBufferException.m21369b();
                    }
                    this.f20608g += i2;
                    r0 += i2;
                }
                r0 = i5 - obj3.length;
                arrayList.add(obj3);
                i5 = r0;
            }
            Object obj4 = new byte[i];
            r0 = i4 - i3;
            System.arraycopy(this.f20602a, i3, obj4, 0, r0);
            i2 = r0;
            for (byte[] bArr : arrayList) {
                System.arraycopy(bArr, 0, obj4, i2, bArr.length);
                i2 = bArr.length + i2;
            }
            return obj4;
        }
    }

    private void m20195g(int i) {
        if (i < 0) {
            throw InvalidProtocolBufferException.m21370c();
        } else if ((this.f20608g + this.f20605d) + i > this.f20609h) {
            m20195g((this.f20609h - this.f20608g) - this.f20605d);
            throw InvalidProtocolBufferException.m21369b();
        } else if (i <= this.f20603b - this.f20605d) {
            this.f20605d += i;
        } else {
            int i2 = this.f20603b - this.f20605d;
            this.f20605d = this.f20603b;
            m20193a(true);
            while (i - i2 > this.f20603b) {
                i2 += this.f20603b;
                this.f20605d = this.f20603b;
                m20193a(true);
            }
            this.f20605d = i - i2;
        }
    }
}
